package hpms.fin.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.ShareRule;
import hpms.fin.service.IShareRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LoseMyself
 * on 2017/3/20   14:45
 */
@Service
@Transactional
public class ShareRuleServiceImpl extends BaseServiceImpl<ShareRule> implements IShareRuleService {
}
