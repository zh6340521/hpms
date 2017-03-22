package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.CusmeterBind;
import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.Property;

import java.util.List;

public interface ICusmeterBindService extends IBaseService<CusmeterBind>, ProxySelf<ICusmeterBindService>{
    public List<CusmeterBind> queryCusmeterBind(IRequest request, CusmeterBind cusmeterBind, int page, int pagesize);
    public List<Property> queryPropertyNoLink(IRequest request, Property property, int page, int pagesize);
    public List<Equipment> queryEquipmentInUse(IRequest request, Equipment equipment, int page, int pagesize);
}