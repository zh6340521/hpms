package hpms.cs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.Procedure;
import hpms.cs.service.IProcedureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @name hpms.cs.service.impl.ProcedureServiceImpl
 * @description 手续材料 service 接口实现类
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 */

@Service
@Transactional
public class ProcedureServiceImpl extends BaseServiceImpl<Procedure> implements IProcedureService {

}