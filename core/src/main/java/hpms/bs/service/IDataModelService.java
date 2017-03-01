package hpms.bs.service;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.DataModel;
import hpms.utils.ValidationTableException;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IDataModelService
 * @description
 * @date 2017/2/28
 */
public interface IDataModelService extends IBaseService<DataModel>,ProxySelf<IDataModelService> {

    /**
     * 批量更新
     * @param dm
     * @param requestCtx
     */
    public void myBatchUpdate(List<DataModel> dm,IRequest requestCtx) throws ValidationTableException;
}