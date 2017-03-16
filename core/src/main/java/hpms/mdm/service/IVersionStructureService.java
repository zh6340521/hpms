package hpms.mdm.service;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.ConfigValue;
import hpms.mdm.dto.VersionStructure;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IVersionStructureService
 * @description:结构版本service
 * @date 2017/2/15
 */
public interface IVersionStructureService extends IBaseService<VersionStructure>,ProxySelf<IVersionStructureService> {
    /**
     * 查询全部版本结构信息
     * @param vs
     * @return
     */
    public List<VersionStructure> findAllVersionStructure(VersionStructure vs,IRequest requestContext,int page,int pagesize);

    /**
     * 查询建筑类型
     * @param requestContext
     * @param configValue
     * @return
     */
    List<ConfigValue> propertyTypeQuery(IRequest requestContext, ConfigValue configValue);
}

