package hpms.fin.service.impl;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterShareResult;
import hpms.fin.mapper.MeterChargeMapper;
import hpms.fin.mapper.MeterShareResultMapper;
import hpms.fin.service.IMeterShareResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name MeterShareResultServiceImpl:公表分摊结果实现类
 * @description
 * @date 2017/3/20
 */
@Service
public class MeterShareResultServiceImpl extends BaseServiceImpl<MeterShareResult> implements IMeterShareResultService {

    @Autowired
    private MeterShareResultMapper meterShareResultMapper;

    @Autowired
    private MeterChargeMapper mterChargeMapper;

    @Override
    public List<MeterCharge> findEquipmentTypeByMeterCharge(MeterCharge meterCharge, IRequest requestContext) {
        List<MeterCharge> mcList = mterChargeMapper.findEquipmentTypeByMeterCharge(meterCharge);
        return mcList;
    }
}
