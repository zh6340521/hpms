package hpms.bs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.MeterCharge;
import hpms.bs.service.IMeterChargeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:22
 */
@Service
@Transactional
public class MeterChargeService extends BaseServiceImpl<MeterCharge> implements IMeterChargeService{
}
