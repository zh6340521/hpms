package hpms.cache;

import com.hand.hap.cache.impl.HashStringRedisCache;
import hpms.bs.dto.DataModel;
import hpms.bs.dto.DataModelCol;
import hpms.bs.mapper.DataModelColMapper;
import hpms.bs.mapper.DataModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelCache
 * @description:数据模型缓存
 * @date 2017/3/1
 */
public class DataModelCache extends HashStringRedisCache<DataModel> {
    private Logger logger = LoggerFactory.getLogger(DataModelCache.class);

    @Autowired
    private DataModelMapper dataModelMapper;

    @Autowired
    private DataModelColMapper dataModelColMapper;

    /**
     * 初始化调用的方法
     */
    public void init() {
        this.setType(DataModel.class);
        this.strSerializer = this.getRedisTemplate().getStringSerializer();
        this.initLoad();
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
     * 查询所有数据
     * @return
     */
    @Override
    public List<DataModel> getAll(){
       return super.getAll();
    }

    /**
     * 根据id查询数据
     * @param key
     * @return
     */
    public DataModel getValue(String key) {
        return (DataModel)super.getValue(key);
    }


    @Override
    protected void initLoad() {
        DataModel area=new DataModel();
        DataModelCol d=new DataModelCol();
        this.updateDataModel(area,d);

    }



    /**
     * 将数据保存到redis
     * @param dm
     * @param dmc
     */
    public void updateDataModel(DataModel dm, DataModelCol dmc){
        logger.info("判断行表里的头id是否为空，不为空赋给头表对象");
        if(dmc.getModelId()!=null&&!dmc.getModelId().equals("")){
            dm.setModelId(dmc.getModelId());
        }

        logger.info("判断头表里的头id是否为空，不为空赋给行表");
        if(dm.getModelId()!=null &&!dm.getModelId().equals("")){
            dmc.setModelId(dm.getModelId());
        }

        logger.info("查询所有行表和头表对象");
        List<DataModel> dmList = dataModelMapper.findDataModel(dm);

        DataModelCol dmc1 = new DataModelCol();
        dmc1.setModelId(dm.getModelId());
        List<DataModelCol> dmcList = dataModelColMapper.findDataModelCol(dmc1);

        logger.info("遍历头表对象");
        Iterator headerList =dmList.iterator();
        while(headerList.hasNext()){
            Object dataModel = headerList.next();
            logger.info("遍历行表对象");
            Iterator lineList  = dmcList.iterator();


            List<DataModelCol> dmc1List = new ArrayList<DataModelCol>();
            while(lineList.hasNext()){
                Object dataModelCol = lineList.next();
                logger.info("判断此时头表和行表id是否相等");
                if(((DataModelCol)dataModelCol).getModelId().equals(((DataModel)dataModel).getModelId())){

                    dmc1List.add((DataModelCol)dataModelCol);
                    ((DataModel) dataModel).setDataModelCol(dmc1List);
                    this.setValue(Long.toString(((DataModel)dataModel).getModelId()),((DataModel) dataModel));

                }
            }

            this.setValue(Long.toString(((DataModel)dataModel).getModelId()),((DataModel) dataModel));

        }

    }

}
