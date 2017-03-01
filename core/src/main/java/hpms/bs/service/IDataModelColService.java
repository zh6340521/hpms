package hpms.bs.service;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.DataModelCol;
import hpms.utils.ValidationTableException;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IDataModelColService
 * @description
 * @date 2017/2/28
 */
public interface IDataModelColService extends IBaseService<DataModelCol>,ProxySelf<IDataModelColService> {

    /**
     * 批量更新
     * @param requestCtx
     * @param bvs
     */
    public void myBatchUpdate(IRequest requestCtx, List<DataModelCol> bvs) throws ValidationTableException;
}