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

    /**
     * 删除
     * @param dm
     * @return
     */
    public int deleteDataModel(List<DataModel> dm);

    /**
     * 根据头表id去redis中查询数据
     * @param modelId
     * @return
     */
    public List<DataModel> findDataModelbyModelId(IRequest requestContext,String modelId);

    /**
     * 查询所有数据模型数据
     * @param requestCtx
     * @param dm
     * @param page
     * @param pageSize
     * @return
     */
    public List<DataModel> findAllDataModel(IRequest requestCtx,DataModel dm,int page,int pageSize);




}