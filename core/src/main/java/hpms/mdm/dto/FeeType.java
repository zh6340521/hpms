package hpms.mdm.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/02/16
 * @version 1.0
 * @name hpms.mdm.dto.FeeType
 * @description 费项类型 dto 类 ，  映射 HPMS_MDM_FEE_TYPE 表
 */

@Table(name = "HPMS_MDM_FEE_TYPE")
public class FeeType extends BaseDTO {
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long feeTypeId;

    /**
     * 编码
     */
    private String feeTypeCode;

    /**
     * 名称
     */
    private String feeTypeName;

    /**
     * 描述
     */
    private String description;

    /**
     * 记录状态
     */
    private String enableFlag;


    public void setFeeTypeId(Long feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    public Long getFeeTypeId() {
        return feeTypeId;
    }

    public void setFeeTypeCode(String feeTypeCode) {
        this.feeTypeCode = feeTypeCode;
    }

    public String getFeeTypeCode() {
        return feeTypeCode;
    }

    public void setFeeTypeName(String feeTypeName) {
        this.feeTypeName = feeTypeName;
    }

    public String getFeeTypeName() {
        return feeTypeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

}
