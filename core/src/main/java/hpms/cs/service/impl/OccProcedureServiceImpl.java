package hpms.cs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.OccProcedure;
import hpms.cs.service.IOccProcedureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.service.impl.OccProcedureServiceImpl
 * @description 入伙手续材料关联 service 接口实现类
 */


@Service
@Transactional
public class OccProcedureServiceImpl extends BaseServiceImpl<OccProcedure> implements IOccProcedureService {

}