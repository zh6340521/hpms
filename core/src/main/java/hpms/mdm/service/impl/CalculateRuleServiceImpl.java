package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.CalculateRule;
import hpms.mdm.service.ICalculateRuleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.service.impl.CalculateRuleServiceImpl
 * @description 计费规则 service 接口实现类
 */

@Service
@Transactional
public class CalculateRuleServiceImpl extends BaseServiceImpl<CalculateRule> implements ICalculateRuleService{

}