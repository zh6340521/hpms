package hpms.mdm.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.EquipmentType;
import hpms.mdm.exception.EquipmentTypeException;
import hpms.mdm.service.IEquipmentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/23
 * @version 1.0
 * @name hpms.mdm.mapper.EquipmentTypeMapper
 * @description 设备类型 service 接口实现类
 */

@Service
@Transactional
public class EquipmentTypeServiceImpl extends BaseServiceImpl<EquipmentType> implements IEquipmentTypeService {



    @Override
    public List<EquipmentType> batchUpdateEquipmentType(
            IRequest request, List<EquipmentType> list) throws EquipmentTypeException{

        if (list.size()!=0){
            for (EquipmentType type :
                    list) {

                if (Integer.parseInt(type.getEndNum())<Integer.parseInt(type.getStartNum())){

                    throw new EquipmentTypeException(
                            EquipmentTypeException.ENDNUM_GREATER_THAN_CURNUM,
                            EquipmentTypeException.ENDNUM_GREATER_THAN_CURNUM,null);

                }

                if ("add".equals(type.get__status())) {

                    if ("CUSTOMER METER".equals(type.getTypeAttribute()) ||
                            "PUBLIC METER".equals(type.getTypeAttribute())){
                        type.setMeterFlag("Y");
                    } else {
                        type.setMeterFlag("N");
                    }

                    type.setPrefix(type.getPrefix().toUpperCase());
                    int endNumLength = type.getEndNum().length();
                    int startNumLength = type.getStartNum().length();
                    if (startNumLength<=endNumLength){
                        type.setStartNum(
                                type.getPrefix()+buildZero(endNumLength-startNumLength)+type.getStartNum());
                    }
                    type.setEndNum(type.getPrefix()+type.getEndNum());
                }


            }
        }
        return super.batchUpdate(request,list);
    }

    private String buildZero(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++){
            sb.append("0");
        }
        return sb.toString();
    }

}