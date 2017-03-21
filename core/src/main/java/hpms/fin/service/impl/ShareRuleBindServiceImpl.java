package hpms.fin.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.ShareRule;
import hpms.fin.dto.ShareRuleBind;
import hpms.fin.service.IShareRuleBindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:33
 */
@Service
@Transactional
public class ShareRuleBindServiceImpl extends BaseServiceImpl<ShareRuleBind> implements IShareRuleBindService {
}
