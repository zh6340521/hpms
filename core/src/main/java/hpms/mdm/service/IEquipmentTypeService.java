package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.EquipmentType;
import hpms.mdm.exception.EquipmentTypeException;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/23
 * @version 1.0
 * @name hpms.mdm.mapper.EquipmentTypeMapper
 * @description 设备类型 service 接口类
 */

public interface IEquipmentTypeService extends IBaseService<EquipmentType>, ProxySelf<IEquipmentTypeService> {


    List<EquipmentType> batchUpdateEquipmentType(IRequest request, List<EquipmentType> list) throws EquipmentTypeException;
}