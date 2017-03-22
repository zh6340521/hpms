package hpms.fin.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.ShareRuleBind;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:32
 */
public interface IShareRuleBindService extends IBaseService<ShareRuleBind>,ProxySelf<IShareRuleBindService> {
    int myInsert(ShareRuleBind shareRuleBind);
}
