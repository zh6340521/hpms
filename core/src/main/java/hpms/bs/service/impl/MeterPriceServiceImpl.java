package hpms.bs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.MeterGradePrice;
import hpms.bs.service.IMeterChargeService;
import hpms.bs.service.IMeterPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LoseMyself
 * on 2017/3/14   18:19
 */
@Service
@Transactional
public class MeterPriceServiceImpl extends BaseServiceImpl<MeterGradePrice> implements IMeterPriceService {
}
