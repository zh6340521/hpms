package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.StoreHouse;
import hpms.mdm.service.IStoreHouseService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreHouseServiceImpl extends BaseServiceImpl<StoreHouse> implements IStoreHouseService{

}