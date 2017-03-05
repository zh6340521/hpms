package hpms.bs.service;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.ConfigValue;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IConfigValueService
 * @description
 * @date 2017/3/1
 */

public interface IConfigValueService extends IBaseService<ConfigValue>,ProxySelf<IConfigValueService> {

    /**
     * 批量更新
     * @param requestCtx
     * @param cvs
     */
    public void myBatchUpdate(IRequest requestCtx, List<ConfigValue> cvs);

    /**
     * 查询redis中的数据
     * @param requestCtx
     * @param configValueId
     * @return
     */
    public List<ConfigValue> queryConfigCache(IRequest requestCtx,Long configValueId,String configId);

    /**
     * 删除数据同步redis
     * @param cfs
     * @return
     */
    public int deleteConfigValue(List<ConfigValue> cfs,IRequest iRequest);
}