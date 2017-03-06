package hpms.bs.service;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.ConfigColumn;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigColumnService
 * @description
 * @date 2017/3/2
 */
public interface IConfigColumnService extends IBaseService<ConfigColumn>,ProxySelf<IConfigColumnService> {

    /**
     * 批量更新
     * @param requestCtx
     * @param cvs
     */
    public void myBatchUpdate(IRequest requestCtx, List<ConfigColumn> cvs);

    /**
     * 删除数据同步redis
     * @param ccs
     * @return
     */
    public int deleteConfigColumn(List<ConfigColumn> ccs,IRequest iRequest);
}
