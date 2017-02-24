package hpms.mdm.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/02/23
 * @version 1.0
 * @name hpms.mdm.dto.EquipmentType
 * @description 设备类型 dto 类 ， 映射 HPMS_MDM_EQUIPMENT_TYPE 表
 */

@Table(name = "HPMS_MDM_EQUIPMENT_TYPE")
public class EquipmentType extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long equipmentTypeId;

    /**
     *类型编码
     */
    private String typeCode;

    /**
     *类型名称
     */
    private String typeName;

    /**
     *设备属性
     */
    private String typeAttribute;

    /**
     *是否为仪表类型
     */
    private String meterFlag;

    /**
     *编码前缀
     */
    private String prefix;

    /**
     *起始编码
     */
    private String startNum;

    /**
     *终止编码
     */
    private String endNum;

    /**
     *当前编码
     */
    private String curNum;

    /**
     *记录状态
     */
    private String enableFlag;


    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeAttribute(String typeAttribute) {
        this.typeAttribute = typeAttribute;
    }

    public String getTypeAttribute() {
        return typeAttribute;
    }

    public void setMeterFlag(String meterFlag) {
        this.meterFlag = meterFlag;
    }

    public String getMeterFlag() {
        return meterFlag;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setCurNum(String curNum) {
        this.curNum = curNum;
    }

    public String getCurNum() {
        return curNum;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

}
