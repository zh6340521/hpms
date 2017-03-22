package hpms.bs.service;

import com.hand.hap.account.dto.Role;
import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.DataPriviliage;
import java.util.List;

public interface IDataPriviliageService extends IBaseService<DataPriviliage>, ProxySelf<IDataPriviliageService>{

    public List<DataPriviliage> queryDataPriviliage(IRequest request,DataPriviliage dataPriviliage,int page,int size);

    public List<Role> queryRole(IRequest request,Role role);
}