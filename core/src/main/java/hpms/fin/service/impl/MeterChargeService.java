package hpms.fin.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.MeterCharge;
import hpms.fin.mapper.MeterChargeMapper;
import hpms.fin.service.IMeterChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:22
 */
@Service
@Transactional
public class MeterChargeService extends BaseServiceImpl<MeterCharge> implements IMeterChargeService{
    @Autowired
    private MeterChargeMapper mapper;


    @Override
    public boolean isHaveEn(MeterCharge meterCharge) {
        boolean a = true;
        String b = meterCharge.getEnableFlag();
        List<MeterCharge> list = mapper.isHaveEnable(meterCharge);
        if(b == "Y"||b.equals("Y")){
            for(int i = 0; i < list.size(); ++i){
                String c = list.get(i).getEnableFlag();
                if(c=="Y"||c.equals("Y")){
                    return false;
                }
            }
        }
        return a;
    }

    @Override
    public boolean isChange(MeterCharge meterCharge) {
        Integer i = mapper.isChange(meterCharge);
        if(i != 0){
            return false;
        }
        return true;
    }
}
