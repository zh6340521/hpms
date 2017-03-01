package hpms.bs.service.impl;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.DataModel;
import hpms.bs.dto.DataModelCol;
import hpms.bs.mapper.DataModelColMapper;
import hpms.bs.mapper.DataModelMapper;
import hpms.bs.service.IDataModelService;
import hpms.cache.DataModelCache;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelServiceImpl
 * @description
 * @date 2017/2/28
 */
@Service
@Transactional
public class DataModelServiceImpl extends BaseServiceImpl<DataModel> implements IDataModelService {
    private Logger logger = LoggerFactory.getLogger(DataModelServiceImpl.class);

    @Autowired
    private DataModelMapper dataModelMapper;

    @Autowired
    private DataModelCache dataModelCache;

    @Autowired
    private DataModelColMapper dataModelColMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ValidationTableException.class)
    public void myBatchUpdate(List<DataModel> dms, IRequest requestCtx) throws ValidationTableException{
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        for(DataModel dm:dms){
            logger.info("查询数据库中是否存在除了自身的相同的编码");
            int count = UniqueModelCode(dms,dm.getModelId(),dm);

            logger.info("查询数据库中是否存在除了自身的相同的数据库表名");
            int b=UniqueTableName(dms,dm.getModelId(),dm);

            if(count>0){
                logger.info("将这条记录删除，并抛出错误信息");
                dms.remove(dm);
                throw new ValidationTableException("hpms.bs.datamodel.modelcode_error", null);
            }

            if(b>0){
                logger.info("将这条记录删除，并抛出错误信息");
                dms.remove(dm);
                throw new ValidationTableException("hpms.bs.datamodel.tablename_error", null);
            }



            logger.info("批量进行更新");
            if(dm.getModelId()==null){
                self.insertSelective(requestCtx,dm);

            }else{
                self.updateByPrimaryKey(requestCtx,dm);
            }

            logger.info("将数据保存到redis");
            submitDataModelRedis(requestCtx,dms);
        }



    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteDataModel(List<DataModel> dm) {
        int c=0;
        logger.info("先删除行表");
        DataModelCol dmc = new DataModelCol();
        for(DataModel d1:dm) {
            dmc.setModelId(d1.getModelId());
            c=dataModelColMapper.deleteDataModelCol(dmc);


            logger.info("删除头表");
            c=dataModelMapper.delete(d1);

            logger.info("删除redis");
            dataModelCache.remove(Long.toString(d1.getModelId()));


        }

        return c;
    }

    @Override
    public List<DataModel> findDataModelbyModelId(DataModel dm) {
        List<DataModel> dmList = new ArrayList<>();
        DataModel dm1 =  dataModelCache.getValue(Long.toString(dm.getModelId()));
        dmList.add(dm1);
        return dmList;
    }

    public void submitDataModelRedis(IRequest iRequest, List<DataModel> dm){
        DataModelCol dmc=new DataModelCol();
        for(DataModel d:dm){
            dataModelCache.updateDataModel(d,dmc);
        }

    }

    //验证编码的唯一性
    public int UniqueModelCode(List<DataModel> dmms, Long  modelId,DataModel dmm) {
        int count = 0;
        dmm.setModelId(modelId);

        logger.info("查询 除了自身外其他的数据");
        List<DataModel> bvList = dataModelMapper.countModelCode(dmm);
        count = bvList.size();
        for (DataModel d1 : bvList) {
            for (DataModel d2 : dmms) {
                if (d1.getModelId().equals(d2.getModelId())) {
                    if (d1.getModelCode().equals(d2.getModelCode())) {
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

    //验证数据表名的唯一性
    public int UniqueTableName(List<DataModel> dmms, Long  modelId,DataModel dmm) {
        int count = 0;
        dmm.setModelId(modelId);

        logger.info("查询 除了自身外其他的数据");
        List<DataModel> bvList = dataModelMapper.countTableName(dmm);
        count = bvList.size();
        for (DataModel d1 : bvList) {
            for (DataModel d2 : dmms) {
                if (d1.getModelId().equals(d2.getModelId())) {
                    if (d1.getTableName().equals(d2.getTableName())) {
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




}
