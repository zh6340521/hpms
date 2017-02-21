package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.CalculateElement;
import hpms.mdm.service.ICalculateElementService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @name hpms.mdm.service.impl.CalculateElementServiceImpl
 * @description 计算要素 service 接口实现类
 * @author feng.liu01@hand-china.com 2017/02/20
 * @version 1.0
 */

@Service
@Transactional
public class CalculateElementServiceImpl extends BaseServiceImpl<CalculateElement> implements ICalculateElementService {

}