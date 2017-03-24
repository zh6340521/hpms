package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/1.
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
import hpms.bs.service.IConfigValueService;
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
 * @name ConfigValueServiceImpl
 * @description
 * @date 2017/3/1
 */
@Service
@Transactional
public class ConfigValueServiceImpl extends BaseServiceImpl<ConfigValue> implements IConfigValueService {
    @Autowired
    private ConfigValuesMapper configValuesMapper;

    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private ConfigColumMapper configColumMapper;

    @Autowired
    private ConfigCache configCache;

    private Logger logger = LoggerFactory.getLogger(ConfigValueServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void myBatchUpdate(IRequest requestCtx, List<ConfigValue> cvs) throws ValidationTableException {
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        for(ConfigValue cv:cvs){
            int a = UniqueConfigValueNumber(cvs,cv.getConfigValueId(),cv);
            if(a>0){
                logger.info("将这条记录删除，并抛出错误信息");
                cvs.remove(cv);
                throw new ValidationTableException("该编码已存在！", null);
            }

            cv.setLastUpdatedBy(requestCtx.getUserId());
            cv.setLastUpdateDate(new Date());

            if(cv.getConfigValueId()!=null){
                self.updateByPrimaryKey(requestCtx,cv);
            }else{
                self.insertSelective(requestCtx,cv);
            }
        }

        logger.info("将数据同步到redis");
        submitConfigValueData(cvs,requestCtx);
    }


    //验证字段名的唯一性
    public int UniqueConfigValueNumber(List<ConfigValue> cvs, Long  configValueId,ConfigValue cv) {
        int count = 0;
        cv.setConfigValueId(configValueId);

        logger.info("查询 除了自身外其他的数据");
        List<ConfigValue> dmcList = configValuesMapper.findUnique(cv);
        count = dmcList.size();
        for (ConfigValue b1 : dmcList) {
            for (ConfigValue b2 : cvs) {
                if (b1.getConfigValueId().equals(b2.getConfigValueId())) {
                    if (b1.getConfigValueNumber().equals(b2.getConfigValueNumber())) {
                        continue;
                    } else {
                        count = count - 1;
                        break;
                    }
                }
            }
        }
        return count;
    }



    @Override
    public List<ConfigValue> queryConfigCache(IRequest requestCtx, Long configValueId,String configId) {
        List<ConfigValue> configValueList = new ArrayList<>();
        Config config = configCache.getValue(configId);
        List<ConfigValue> cvs = config.getConfigValueList();

        logger.info("查询该头id下对应的所有行表数据");
        if(!cvs.isEmpty()&&cvs.size()!=0){
            for(ConfigValue cv:cvs){
                if(cv.getConfigValueId().equals(configValueId)||cv.getConfigValueId()==configValueId){
                    configValueList.add(cv);
                }
            }
        }
        return configValueList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteConfigValue(List<ConfigValue> cfs,IRequest iRequest) {
        int c=0;
        for(ConfigValue cf:cfs){
            c=configValuesMapper.delete(cf);
        }

        logger.info("将数据同步到redis");
        submitConfigValueData(cfs,iRequest);

        return c;
    }

    @Override
    public List<ConfigValue> queryConfigCacheByConfigId(IRequest requestCtx, Long configId) {
        String cId = Long.toString(configId);
        Config config = configCache.getValue(cId);
        List<ConfigValue> cvList = config.getConfigValueList();
        return cvList;
    }

    //将数据同步到redis
    public void submitConfigValueData(List<ConfigValue> cvs,IRequest iRequest){

        Config c1 = new Config();
        for(ConfigValue cv:cvs){
            Config cf = new Config();
            ConfigColumn cc = new ConfigColumn();

            cf.setConfigId(cv.getConfigId());
            cc.setConfigValueId(cv.getConfigValueId());

            logger.info("查询对应的头表对象");
            List<Config> cfs = configMapper.select(cf);
            if(!cfs.isEmpty()&&cfs.size()!=0){
                 c1 = cfs.get(0);
            }

            configCache.updateConfigData(c1,cv,cc);

        }
    }
}
