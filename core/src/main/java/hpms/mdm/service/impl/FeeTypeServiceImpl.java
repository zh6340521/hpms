package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.FeeType;
import hpms.mdm.service.IFeeTypeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @name hpms.mdm.dto.FeeType
 * @description 费项类型 service 接口实现类
 * @author feng.liu01@hand-china.com 2017/02/16
 * @version 1.0
 */

@Service
@Transactional
public class FeeTypeServiceImpl extends BaseServiceImpl<FeeType> implements IFeeTypeService{

}