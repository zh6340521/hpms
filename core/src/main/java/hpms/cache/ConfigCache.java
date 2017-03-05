package hpms.cache;/**
 * Created by user1 on 2017/3/5.
 */

import com.hand.hap.cache.impl.HashStringRedisCache;
import hpms.bs.dto.Config;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.dto.ConfigValue;
import hpms.bs.mapper.ConfigColumMapper;
import hpms.bs.mapper.ConfigMapper;
import hpms.bs.mapper.ConfigValuesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name  类型配置缓存
 * @description
 * @date 2017/3/5
 */
public class ConfigCache extends HashStringRedisCache<Config> {
    private Logger logger = LoggerFactory.getLogger(ConfigCache.class);

    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private ConfigValuesMapper configValuesMapper;
    @Autowired
    private ConfigColumMapper configColumMapper;

    /**
     * 根据id查询数据
     * @param key
     * @return
     */
    public Config getValue(String key) {
        return (Config)super.getValue(key);
    }

    /**
     * 删除redis中的数据
     * @param key
     */
    @Override
    public void remove(String key) {
        super.remove(key);
    }


    /**
     * 初始化调用的方法
     */
    public void init() {
        this.setType(Config.class);
        this.strSerializer = this.getRedisTemplate().getStringSerializer();
        this.initLoad();
    }

    @Override
    protected void initLoad() {
        Config area=new Config();
        ConfigValue d=new ConfigValue();
        ConfigColumn c = new ConfigColumn();
        this.updateConfigData(area,d,c);

    }

    //将数据存入redis
    public void updateConfigData(Config cf, ConfigValue cv, ConfigColumn cc){

        logger.info("查询出三张表的数据");
        List<Config> cfList = configMapper.findAllConfig(cf);


        logger.info("遍历头表对象");
        Iterator headerList =cfList.iterator();
        while (headerList.hasNext()){
            Object config = headerList.next();

            logger.info("遍历第二张表对象");
            ConfigValue cv1 = new ConfigValue();
            cv1.setConfigId(((Config)config).getConfigId());
            List<ConfigValue> cvList = configValuesMapper.select(cv1);

            Iterator cv1List =cvList.iterator();

            List<ConfigValue> ConfigValueList = new ArrayList<>();
            while (cv1List.hasNext()){
                Object configValue = cv1List.next();

                logger.info("判断行表和主表id是否相等");
                if(((ConfigValue)configValue).getConfigId().equals(((Config)config).getConfigId())){
                    ConfigValueList.add((ConfigValue)configValue);
                    ((Config) config).setConfigValueList(ConfigValueList);



                }
                logger.info("遍历第三张表对象");
                ConfigColumn cc1 = new ConfigColumn();
                cc1.setConfigValueId(((ConfigValue)configValue).getConfigValueId());
                List<ConfigColumn> ccList = configColumMapper.select(cc1);
                Iterator cc1List = ccList.iterator();

                List<ConfigColumn> ConfigColumnList = new ArrayList<>();
                while(cc1List.hasNext()){
                    Object configColumn = cc1List.next();

                    logger.info("判断第二张表的id和第三张表是否相等");
                    if(((ConfigColumn)configColumn).getConfigValueId().equals(((ConfigValue)configValue).getConfigValueId())){
                        ConfigColumnList.add((ConfigColumn)configColumn);
                        ((ConfigValue) configValue).setConfigColumnList(ConfigColumnList);

                        //ConfigValueList.add((ConfigValue) configValue);


                    }
                }


            }
            this.setValue(Long.toString(((Config)config).getConfigId()),((Config) config));

        }
    }
}
