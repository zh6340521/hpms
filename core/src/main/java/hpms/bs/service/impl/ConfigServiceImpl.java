package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/1.
 */

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.Config;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.dto.ConfigValue;
import hpms.bs.mapper.ConfigMapper;
import hpms.bs.service.IConfigService;
import hpms.cache.ConfigCache;
import hpms.utils.ValidationTableException;
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
 * @name ConfigServiceImpl
 * @description
 * @date 2017/3/1
 */
@Service
@Transactional
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements IConfigService {
    private Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private ConfigCache configCache;

    @Override
    public List<Config> selectAllConfig(IRequest requestContext, Config c,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Config> cList = configMapper.findAllConfig(c);
        return cList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = ValidationTableException.class)
    public void myBatchUpdate(IRequest requestCtx, List<Config> cfs) throws ValidationTableException {
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        for(Config c:cfs){
            c.setLastUpdatedBy(requestCtx.getUserId());
            c.setLastUpdateDate(new Date());



                logger.info("根据公司id+配置编码确定唯一性");
                int a = uniqueconfigNumber(cfs,c.getConfigId(),c);
                if(a>0){
                    logger.info("将这条记录删除，并抛出错误信息");
                    cfs.remove(c);
                    throw new ValidationTableException("hpms.bs.config.number_error", null);
                }

                logger.info("通过公司id+模型id+字段名确定唯一性");
                int b = uniqueconfig(cfs,c.getConfigId(),c);
                if(b>0){
                    logger.info("将这条记录删除，并抛出错误信息");
                    cfs.remove(c);
                    throw new ValidationTableException("hpms.bs.config.submit_error", null);
                }


            logger.info("进行批量更新或插入");
            if(c.getConfigId()!=null){
                self.updateByPrimaryKey(requestCtx,c);
            }else{
                self.insertSelective(requestCtx,c);
            }

        }

        logger.info("将数据同步到redis");
        submitConfigDataRedis(cfs,requestCtx);

    }

    @Override
    public List<Config> queryConfigCache(IRequest requestCtx, String configId) {
        List<Config> cList = new ArrayList<>();
        Config config= configCache.getValue(configId);

        cList.add(config);
        return cList;
    }

    public void submitConfigDataRedis(List<Config> cfs,IRequest iRequest){
        ConfigValue cv = new ConfigValue();
        ConfigColumn cc = new ConfigColumn();
        for(Config c:cfs){
            configCache.updateConfigData(c,cv,cc);
        }
    }

    //根据公司id+配置编码确定唯一性
    public int uniqueconfigNumber(List<Config> clist,Long configId,Config c){
       int count = 0;
       c.setConfigId(configId);

       logger.info("查询除了自身主键id外的其他数据");
       List<Config> c1List =configMapper.findConfigNumberByCompanyId(c);
       count = c1List.size();

       for(Config cf:c1List){
           for(Config cf1:clist){
               if(cf.getConfigId().equals(cf1.getConfigId())){
                   if(cf.getCompanyId().equals(cf1.getCompanyId())&&(cf.getConfigNumber().equals(cf1.getConfigNumber()))){
                       logger.info("结束本次循环");
                       continue;
                   }else{
                       count = count-1;
                       logger.info("结束整个循环体");
                       break;
                   }
               }

           }
       }

        return count;

    }

    //通过公司id+模型id+字段名确定唯一性
    public int uniqueconfig(List<Config> clist,Long configId,Config config){
        int count = 0;
        config.setConfigId(configId);

        List<Config> c1List = configMapper.findUniqueConfig(config);
        count =c1List.size();

        for(Config c1:c1List){
            for(Config c:clist){
                if(c1.getConfigId().equals(c.getConfigId())){
                    if(c.getCompanyId().equals(c1.getCompanyId())&&(c.getModelId().equals(c1.getModelId()))&&(c.getColumnName().equals(c1.getColumnName()))){
                        continue;
                    }else{
                        count = count-1;
                        break;
                    }
                }
            }
        }
        return count;
    }


}
