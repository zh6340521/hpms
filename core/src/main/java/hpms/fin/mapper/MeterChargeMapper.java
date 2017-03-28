package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.MeterCharge;
import hpms.mdm.dto.Project;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:19
 */
public interface MeterChargeMapper extends Mapper<MeterCharge>{

    List<MeterCharge> isHaveEnable(MeterCharge meterCharge);

    Integer isChange(MeterCharge meterCharge);

    /**
     * 根据项目选择有效的仪表类型
     * @author fuchun.hu@hand-china.com   2017年3月20日 14:22:44
     * @param meterCharge
     * @return
     */
    List<MeterCharge> findEquipmentTypeByMeterCharge(MeterCharge meterCharge);

    /**
     * 查询仪表计费
     * @author pengfei.zheng@hand-china.com   2017年3月28日 14:22:44
     * @param meterCharge
     * @return
     */
    List<MeterCharge> chargeQuery(MeterCharge meterCharge);
}
