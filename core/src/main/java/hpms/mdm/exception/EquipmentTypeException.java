package hpms.mdm.exception;

import com.hand.hap.core.exception.BaseException;

/**
 * @name hpms.mdm.exception
 * @description 设备类型 Exception 类
 * @ author feng.liu01@hand-china.com 2017/02/24 14:37
 * @ version 1.0
 */
public class EquipmentTypeException extends BaseException {

    public static final String ENDNUM_GREATER_THAN_CURNUM = "hpms.mdm.equipmenttype.numlimit";

    public EquipmentTypeException(String code, String descriptionKey, Object[] parameters) {
        super(code, descriptionKey, parameters);
    }
}
