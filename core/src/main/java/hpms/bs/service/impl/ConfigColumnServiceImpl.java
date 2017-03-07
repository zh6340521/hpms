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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    //字段是必输时的显示字段
    public final static String vaildate_message = "required validationMessage='必输'";

    private Logger logger = LoggerFactory.getLogger(ConfigColumnServiceImpl.class);


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void myBatchUpdate(IRequest requestCtx, List<ConfigColumn> cvs) {
        IBaseService self = (IBaseService) AopContext.currentProxy();
        for(ConfigColumn cc:cvs){
            cc.setLastUpdatedBy(requestCtx.getUserId());
            cc.setLastUpdateDate(new Date());

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
                                        cc.setVaildateMessage(vaildate_message);
                                    }else{
                                        cc.setVaildateMessage("");
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
