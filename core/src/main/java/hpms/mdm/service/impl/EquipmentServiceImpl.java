package hpms.mdm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.mapper.EquipmentTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import hpms.mdm.dto.EquipmentType;
import hpms.mdm.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.Equipment;
import hpms.mdm.service.IEquipmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment> implements IEquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private EquipmentTypeMapper equipmentTypeMapper;

    @Override
    public List<EquipmentType> queryEquipmentType(IRequest requestContext, EquipmentType equipmentType) {
        return equipmentMapper.queryEquipmentType(equipmentType);
    }

    @Override
    public List<Equipment> queryEquipment(IRequest requestContext, Equipment equipment, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return equipmentMapper.queryEquipment(equipment);
    }

    @Override
    public List<Equipment> submitEquipment(IRequest requestContext, List<Equipment> equipments) {

        for (Equipment equipment : equipments) {
            if (equipment.getEquipmentId() == null) {
                EquipmentType equipmentType = new EquipmentType();
                equipmentType.setEquipmentTypeId(equipment.getEquipmentTypeId());
                equipmentType = equipmentTypeMapper.selectByPrimaryKey(equipmentType);
                String frefix = equipmentType.getPrefix();
                String startNum = equipmentType.getStartNum();
                String endNum = equipmentType.getEndNum();
                String curNum = equipmentType.getCurNum();

                if (curNum == null) {
                    equipment.setEquipmentCode(startNum);
                    self().insertSelective(requestContext, equipment);
                    equipmentType.setCurNum(startNum);
                    equipmentTypeMapper.updateByPrimaryKey(equipmentType);
                } else {

                    String curCode=curNum.replaceFirst(frefix, "");
                    Long curNummber = Long.parseLong(curCode);
                    String endCode = endNum.replaceFirst(frefix, "");
                    String startCode = startNum.replaceFirst(frefix, "");

                    if (curNummber + 1 > Long.parseLong(endNum.replaceFirst(frefix, ""))) {
                        throw new RuntimeException("无法生成设备编号，超出终止编码");
                    } else {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < endCode.length() - curNummber.toString().length(); i++) {
                            sb.append("0");
                        }
                        equipment.setEquipmentCode(frefix + sb.toString() + (curNummber + 1));
                        self().insertSelective(requestContext, equipment);
                        equipmentType.setCurNum(frefix + sb.toString() + (curNummber + 1));
                        equipmentTypeMapper.updateByPrimaryKey(equipmentType);
                    }
                }
            } else {
                self().updateByPrimaryKey(requestContext, equipment);
            }
        }


        return equipments;
    }
}