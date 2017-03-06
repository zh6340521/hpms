package hpms.mdm.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.EquipmentType;
import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment>{

    List<EquipmentType> queryEquipmentType(EquipmentType equipmentType);

    List<Equipment> queryEquipment(Equipment equipment);



}