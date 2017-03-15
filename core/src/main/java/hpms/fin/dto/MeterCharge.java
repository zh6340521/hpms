package hpms.fin.dto;

import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LoseMyself
 * on 2017/3/13   18:16
 */
@Table(name = "HPMS_FIN_METER_CHARGE_RULE")
public class MeterCharge extends BaseDTO{

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long chargeRuleId;

    /*公司ID*/
    private Long companyId;

    /*项目ID*/
    private Long projectId;

    /*设备类型ID*/
    private Long equipmentTypeId;

    /*计费维度*/
    private String crObject;

    /*计费规则编码*/
    private String crCode;

    /*计费规则*/
    @Condition(operator = LIKE)
    private String crName;

    /*记录状态*/
    private String enableFlag;

    public Long getChargeRuleId() {
        return chargeRuleId;
    }

    public MeterCharge setChargeRuleId(Long chargeRuleId) {
        this.chargeRuleId = chargeRuleId;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public MeterCharge setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public Long getProjectId() {
        return projectId;
    }

    public MeterCharge setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public MeterCharge setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
        return this;
    }

    public String getCrObject() {
        return crObject;
    }

    public MeterCharge setCrObject(String crObject) {
        this.crObject = crObject;
        return this;
    }

    public String getCrCode() {
        return crCode;
    }

    public MeterCharge setCrCode(String crCode) {
        this.crCode = crCode;
        return this;
    }

    public String getCrName() {
        return crName;
    }

    public MeterCharge setCrName(String crName) {
        this.crName = crName;
        return this;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public MeterCharge setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
        return this;
    }
}
