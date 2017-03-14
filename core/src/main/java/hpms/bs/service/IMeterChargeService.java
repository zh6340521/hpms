package hpms.bs.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.MeterCharge;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:21
 */
public interface IMeterChargeService extends IBaseService<MeterCharge>, ProxySelf<IMeterChargeService> {

    boolean isHaveEn(MeterCharge meterCharge);
}
