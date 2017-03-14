package hpms.bs.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.MeterGradePrice;

/**
 * Created by LoseMyself
 * on 2017/3/14   18:18
 */
public interface IMeterPriceService extends IBaseService<MeterGradePrice>, ProxySelf<ISequenceService> {
}
