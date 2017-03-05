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
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    //将数据同步到redis
    public void submitConfigColumnDataRedis(List<ConfigColumn> ccs,IRequest iRequest){
        ConfigValue cv = new ConfigValue();
        Config cf1 = new Config();
        for(ConfigColumn cc:ccs){
            ConfigValue cf = new ConfigValue();
            cf.setConfigValueId(cc.getConfigValueId());

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
