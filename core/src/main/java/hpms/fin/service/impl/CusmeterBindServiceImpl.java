package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.mapper.CusmeterBindMapper;
import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.fin.dto.CusmeterBind;
import hpms.fin.service.ICusmeterBindService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CusmeterBindServiceImpl extends BaseServiceImpl<CusmeterBind> implements ICusmeterBindService {
    @Autowired
    private CusmeterBindMapper cusmeterBindMapper;

    @Override
    public List<CusmeterBind> queryCusmeterBind(IRequest request, CusmeterBind cusmeterBind, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return cusmeterBindMapper.queryCusmeter(cusmeterBind);
    }

    @Override
    public List<Property> queryPropertyNoLink(IRequest request, Property property, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return cusmeterBindMapper.queryPropertyNoLink(property);
    }

    @Override
    public List<Equipment> queryEquipmentInUse(IRequest request, Equipment equipment, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return cusmeterBindMapper.queryEquipmentInUse(equipment);
    }
}