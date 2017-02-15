package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.Fee;
import hpms.mdm.service.IFeeService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeeServiceImpl extends BaseServiceImpl<Fee> implements IFeeService{

}