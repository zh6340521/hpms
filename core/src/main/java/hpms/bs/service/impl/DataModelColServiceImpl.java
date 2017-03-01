package hpms.bs.service.impl;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.DataModelCol;
import hpms.bs.mapper.DataModelColMapper;
import hpms.bs.service.IDataModelColService;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelColServiceImpl
 * @description
 * @date 2017/2/28
 */
@Service
@Transactional
public class DataModelColServiceImpl extends BaseServiceImpl<DataModelCol> implements IDataModelColService {
   @Autowired
   private DataModelColMapper dataModelColMapper;

    private Logger logger = LoggerFactory.getLogger(DataModelColServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ValidationTableException.class)
    public void myBatchUpdate(IRequest requestCtx, List<DataModelCol> dmcs) throws ValidationTableException {
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        for(DataModelCol dmc:dmcs){
            int a = UniqueColumnName(dmcs,dmc.getModelColId(),dmc);
            if(a>0){
                logger.info("将这条记录删除，并抛出错误信息");
                dmcs.remove(dmc);
                throw new ValidationTableException("hpms.bs.datamodel.columnname_error", null);
            }

            if(dmc.getModelColId()!=null){
                self.updateByPrimaryKey(requestCtx,dmc);
            }else{
                self.insertSelective(requestCtx,dmc);
            }
        }
    }

    //验证字段名的唯一性
    public int UniqueColumnName(List<DataModelCol> dmcs, Long  modelColId,DataModelCol dmc) {
        int count = 0;
        dmc.setModelColId(modelColId);

        logger.info("查询 除了自身外其他的数据");
        List<DataModelCol> dmcList = dataModelColMapper.countColumnName(dmc);
        count = dmcList.size();
        for (DataModelCol b1 : dmcList) {
            for (DataModelCol b2 : dmcs) {
                if (b1.getModelColId().equals(b2.getModelColId())) {
                    if (b1.getColumnName().equals(b2.getColumnName())) {
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
