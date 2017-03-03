package hpms.bs.service;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.Config;
import hpms.utils.ValidationTableException;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IConfigService
 * @description
 * @date 2017/3/1
 */
public interface IConfigService extends IBaseService<Config>,ProxySelf<IConfigService> {

    /**
     * 查询配置表的数据
     * @param requestContext
     * @param c
     * @return
     */
    public List<Config> selectAllConfig(IRequest requestContext,Config c,int page,int pageSize);

    /**
     * 批量更新
     * @param requestCtx
     * @param bvs
     */
    public void myBatchUpdate(IRequest requestCtx, List<Config> bvs) throws ValidationTableException;



}