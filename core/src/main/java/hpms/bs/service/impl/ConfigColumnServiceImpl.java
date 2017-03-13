package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.Config;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.dto.ConfigValue;
import hpms.bs.mapper.ConfigColumMapper;
import hpms.bs.mapper.ConfigMapper;
import hpms.bs.mapper.ConfigValuesMapper;
import hpms.bs.service.IConfigColumnService;
import hpms.cache.ConfigCache;
import hpms.utils.ValidationTableException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigColumnServiceImpl
 * @description
 * @date 2017/3/2
 */
@Service
@Transactional
public class ConfigColumnServiceImpl extends BaseServiceImpl<ConfigColumn> implements IConfigColumnService {
    @Autowired
    private ConfigColumMapper configColumMapper;

    @Autowired
    private ConfigCache configCache;

    @Autowired
    private ConfigValuesMapper configValuesMapper;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    //字段是必输时的显示字段
    public final static String vaildate_required_message = "1";
    public final static String vaildate_unrequired_message = "2";

    private Logger logger = LoggerFactory.getLogger(ConfigColumnServiceImpl.class);


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void myBatchUpdate(IRequest requestCtx, List<ConfigColumn> cvs) throws ValidationTableException {
        IBaseService self = (IBaseService) AopContext.currentProxy();
        for(ConfigColumn cc:cvs){
            cc.setLastUpdatedBy(requestCtx.getUserId());
            cc.setLastUpdateDate(new Date());

            logger.info("当字符类型为list并且sqlid和快码code都不空时，抛出错误");
            if(cc.getColumnStyle()=="LIST"||"LIST".equals(cc.getColumnStyle())){
                if((cc.getSqlId()!=null&&!"".equals(cc.getSqlId()))&&(cc.getSysCode()!=null&&!"".equals(cc.getSysCode()))){
                    logger.info("将这条记录删除，并抛出错误信息");
                    cvs.remove(cc);
                    throw new ValidationTableException("当字符样式为LIST时，Sql Id和快码CODE不能同时存在！", null);
                }
            }


            if(cc.getConfigColumnId()!=null){
                self.updateByPrimaryKey(requestCtx,cc);
            }else{
                self.insertSelective(requestCtx,cc);
            }

        }

        submitConfigColumnDataRedis(cvs,requestCtx);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteConfigColumn(List<ConfigColumn> ccs, IRequest iRequest) {
        int c=0;
        for(ConfigColumn cc:ccs){
           c= configColumMapper.delete(cc);
        }
        submitConfigColumnDataRedis(ccs,iRequest);
        return c;

    }

    @Override
    public List<ConfigColumn> findConfigColumnByCache(IRequest iRequest,Long configValueId,Long configId) {
        String cid = Long.toString(configId);
        logger.info("查询缓存中对应的头表对象");
        Config config = configCache.getValue(cid);

        List<ConfigValue> configValueList = new ArrayList<>();
        List<ConfigColumn> ccList = new ArrayList<>();

        logger.info("头表对象对应的行表");
        List<ConfigValue> cvList = config.getConfigValueList();
        if(!cvList.isEmpty()&&cvList.size()!=0){
            for(ConfigValue cv:cvList){
                if(cv.getConfigValueId().equals(configValueId)||cv.getConfigValueId()==configValueId){
                    configValueList.add(cv);

                    logger.info("查询该表对应的行表");
                    for(ConfigValue cv1:configValueList){
                        List<ConfigColumn> cc1List = cv1.getConfigColumnList();
                        if(!cc1List.isEmpty()&&cc1List.size()!=0){
                            for(ConfigColumn cc:cc1List){
                                logger.info("查询所有启用的字段");
                                if(cc.getEnableFlag().equals("Y")||cc.getEnableFlag()=="Y"){
                                    logger.info("判断字符是否必输");
                                    if(cc.getRequiredFlag().equals("Y")||cc.getRequiredFlag()=="Y"){
                                        cc.setVaildateMessage(vaildate_required_message);
                                    }else{
                                        cc.setVaildateMessage(vaildate_unrequired_message);
                                    }
                                        ccList.add(cc);

                                }

                            }
                        }


                    }
                }
            }
        }

        return ccList;
    }

    @Override
    public List<?> selectDatas(IRequest request, String sqlId, Object obj) {

        logger.info("调用spring的StringUtils工具类截取sqlId小数点前半部分并将首字母改成小写");
        String beanName = StringUtils.uncapitalize(StringUtils.substringBefore(sqlId, "."));

        logger.info("利用反射创建bean实例");
        Object mapperObjectDelegate = beanFactory.getBean(beanName);
        if (mapperObjectDelegate == null) {
            return Collections.emptyList();
        }

        logger.info("获取该类的定义信息，然后使用反射去访问其全部信息(包括函数和字段)");
        Class<?>[] interfaceClass = mapperObjectDelegate.getClass().getInterfaces();
        for (Class c : interfaceClass) {
            if (c.getSimpleName().equalsIgnoreCase(beanName)) {
                sqlId = c.getPackage().getName() + "." + StringUtils.capitalize(sqlId);
                break;
            }
        }
        logger.info("打开sql会话");
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            obj = convertMapParamToDtoParam(sqlSession, sqlId, obj);

            return sqlSession.selectList(sqlId, obj);
        } catch (Throwable e) {
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
        }

        return Collections.emptyList();
    }


    /**
     * 将 map 类型的参数 转换为 dto 类型
     *
     * @param sqlSession
     * @param sqlId
     * @param map
     * @return
     */
    private Object convertMapParamToDtoParam(SqlSession sqlSession, String sqlId, Object map) {
        if (!(map instanceof Map)) {
            logger.warn("lov query parameter is not a map:{}", map);
            return map;
        }
        MappedStatement statement = sqlSession.getConfiguration().getMappedStatement(sqlId);
        if (statement == null) {
            logger.warn("no statement found for sqlId:{}", sqlId);
            return map;
        }
        List<ResultMap> resultMaps = statement.getResultMaps();
        if (resultMaps == null || resultMaps.isEmpty()) {
            logger.warn("statement has no specified ResultMap, sqlId:{}", sqlId);
            return map;
        }
        ResultMap resultMap = resultMaps.get(0);
        try {
            Class dtoClass = resultMap.getType();
            Object dto = dtoClass.newInstance();
            ((Map) map).forEach((k, v) -> {
                try {
                    PropertyDescriptor desc = PropertyUtils.getPropertyDescriptor(dto, (String) k);
                    if (desc != null) {
                        BeanUtils.setProperty(dto, (String) k, v);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            logger.debug("convert lov query parameter to {}", dto);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //将数据同步到redis
    public void submitConfigColumnDataRedis(List<ConfigColumn> ccs,IRequest iRequest){
        int number = 1;

        ConfigValue cv = new ConfigValue();
        Config cf1 = new Config();

        //遍历list对象将字符编号循环插入
        for(ConfigColumn cc:ccs){
            ConfigValue cf = new ConfigValue();
            cf.setConfigValueId(cc.getConfigValueId());
            //循环插入编号
            cc.setColumnNumber(number++);
            //查询对应的主表对象
            List<ConfigValue> cvs =  configValuesMapper.select(cf);
            if(!cvs.isEmpty()&&cvs.size()!=0){
               cv = cvs.get(0);

                Config c1= new Config();
                c1.setConfigId(cv.getConfigId());
                List<Config> ccs1 = configMapper.select(c1);

                if(!ccs1.isEmpty()&&ccs1.size()!=0){
                    cf1 = ccs1.get(0);
                }
            }

            configCache.updateConfigData(cf1,cv,cc);
        }
    }
}
