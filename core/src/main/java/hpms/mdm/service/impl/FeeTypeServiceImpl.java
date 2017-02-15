package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.FeeType;
import hpms.mdm.service.IFeeTypeService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeeTypeServiceImpl extends BaseServiceImpl<FeeType> implements IFeeTypeService{

}