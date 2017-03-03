package hpms.cs.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.Occupation;
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

    @Override
    public List<Occupation> propertyQuery(IRequest request, Occupation occupation, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mapper.propertyQuery(occupation);
    }
}