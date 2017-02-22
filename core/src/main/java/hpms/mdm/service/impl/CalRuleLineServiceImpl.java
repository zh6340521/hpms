package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.CalRuleLine;
import hpms.mdm.service.ICalRuleLineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.service.impl.CalRuleLineServiceImpl
 * @description 计费规则行数据 service 接口实现类
 */

@Service
@Transactional
public class CalRuleLineServiceImpl extends BaseServiceImpl<CalRuleLine> implements ICalRuleLineService {

}