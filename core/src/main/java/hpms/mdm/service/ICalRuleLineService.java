package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.CalRuleLine;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.service.ICalRuleLineService
 * @description 计费规则行数据 mapper 类
 */

public interface ICalRuleLineService extends IBaseService<CalRuleLine>, ProxySelf<ICalRuleLineService> {
    /**
     * 根据条件查询
     * @param calRuleLine
     * @return
     */
    List<CalRuleLine> selectElementName(IRequest request, CalRuleLine calRuleLine, int pageNum, int pageSize);
}