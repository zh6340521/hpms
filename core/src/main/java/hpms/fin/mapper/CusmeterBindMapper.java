package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.CusmeterBind;
import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.Property;

import java.util.List;

public interface CusmeterBindMapper extends Mapper<CusmeterBind>{
    List<CusmeterBind> queryCusmeter(CusmeterBind cusmeterBind);
    List<Property> queryPropertyNoLink(Property property);
    List<Equipment> queryEquipmentInUse(Equipment equipment);
}