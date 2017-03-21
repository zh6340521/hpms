package hpms.bs.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.account.dto.Role;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.mapper.DataPriviliageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.bs.dto.DataPriviliage;
import hpms.bs.service.IDataPriviliageService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DataPriviliageServiceImpl extends BaseServiceImpl<DataPriviliage> implements IDataPriviliageService{

    @Autowired
    private DataPriviliageMapper dataPriviliageMapper;
    @Override
    public List<DataPriviliage> queryDataPriviliage(IRequest request, DataPriviliage dataPriviliage, int page, int size) {
        PageHelper.startPage(page, size);
        return dataPriviliageMapper.queryDataPriviliage(dataPriviliage);

    }

    @Override
    public List<Role> queryRole(IRequest request, Role role) {
        return dataPriviliageMapper.roleQuery(role);
    }
}