package hpms.bs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.MeterCharge;
import hpms.bs.mapper.MeterChargeMapper;
import hpms.bs.service.IMeterChargeService;
import hpms.cache.DataModelCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private DataModelCache dataModelCache;

    private Logger logger = LoggerFactory.getLogger(DataModelColServiceImpl.class);

    @Override
    public boolean isHaveEn(MeterCharge meterCharge) {
        boolean a = true;
        List<MeterCharge> list = mapper.isHaveEnable(meterCharge);
        for(int i = 0; i < list.size(); ++i){
            if(list.get(i).getEnableFlag()=="Y"){
                return a = false;
            }
        }
        return  a;
    }
}
