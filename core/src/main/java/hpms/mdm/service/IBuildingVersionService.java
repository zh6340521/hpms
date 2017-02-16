package hpms.mdm.service;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.util.ValidationTableException;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IBuildingVersionService
 * @description：建筑版本接口
 * @date 2017/2/15
 */
public interface IBuildingVersionService extends IBaseService<BuildingVersion>,ProxySelf<IBuildingVersionService> {

    /**
     * 批量提交建筑版本数据
     * @param requestCtx
     * @param bvs
     * @throws ValidationTableException
     */
    public void myBatchUpdate(IRequest requestCtx, List<BuildingVersion> bvs) throws ValidationTableException;

}