package hpms.fin.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.MeterGradePrice;
import hpms.fin.service.IMeterPriceService;
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
