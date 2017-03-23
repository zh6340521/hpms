package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.EquipmentType;

import java.util.List;

public interface IEquipmentService extends IBaseService<Equipment>, ProxySelf<IEquipmentService> {


    List<EquipmentType> queryEquipmentType(IRequest requestContext, EquipmentType equipmentType);

    List<EquipmentType> queryFeeEquipmentType(IRequest requestContext, EquipmentType equipmentType);

    List<Equipment> queryEquipment(IRequest requestContext,Equipment equipment,int page,int pagesize);

    List<Equipment> submitEquipment(IRequest requestContext,List<Equipment> equipments);
}