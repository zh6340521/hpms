package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.MeterCharge;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:19
 */
public interface MeterChargeMapper extends Mapper<MeterCharge>{

    List<MeterCharge> isHaveEnable(MeterCharge meterCharge);
}