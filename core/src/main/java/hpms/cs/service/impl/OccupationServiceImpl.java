package hpms.cs.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.OccProcedure;
import hpms.cs.dto.Occupation;
import hpms.cs.mapper.OccProcedureMapper;
import hpms.cs.mapper.OccupationMapper;
import hpms.cs.service.IOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.service.impl.OccupationServiceImpl
 * @description 入退伙 service 接口实现类
 */

@Service
@Transactional
public class OccupationServiceImpl extends BaseServiceImpl<Occupation> implements IOccupationService {

    @Autowired
    private OccupationMapper mapper;

    @Autowired
    private OccProcedureMapper occProcedureMapper;

    @Override
    public List<Occupation> propertyQuery(IRequest request, Occupation occupation, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Occupation> list = mapper.propertyQuery(occupation);
        for (Occupation occu :
                list) {
            if (occu.getStatus() == null || "OUT".equals(occu.getStatus())) {
                occu.setStatus("OUT");
                occu.setCustomerCode(null);
                occu.setCustomerId(null);
                occu.setCustomerName(null);
            }
        }
        return list;
    }

    @Override
    public Occupation queryOne(IRequest request, Occupation occupation) {
        Occupation occu = mapper.selectOne(occupation);
        OccProcedure occProcedure = new OccProcedure();
        occProcedure.setOccupationId(occu.getOccupationId());
        List<OccProcedure> list = occProcedureMapper.select(occProcedure);
        occu.setOccProcedures(list);
        return occu;
    }

    @Override
    public Occupation updateOccu(IRequest request, Occupation occupation) {

        if ("add".equals(occupation.get__status())) {
            insertSelective(request, occupation);
            Long occupationId = occupation.getOccupationId();
            List<OccProcedure> list = occupation.getOccProcedures();
            for (OccProcedure occProcedure :
                    list) {
                occProcedure.setOccupationId(occupationId);
                occProcedureMapper.insertSelective(occProcedure);
            }
        } else if ("update".equals(occupation.get__status())) {
            updateByPrimaryKeySelective(request, occupation);
        }
        return occupation;
    }

    @Override
    public List<Occupation> selectOccupation(IRequest requestContext, Occupation dto, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return mapper.selectOccupation(dto);
    }


}