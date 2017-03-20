package hpms.fin.dto;

import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;

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
    @Column
    private Long companyId;

    /*项目ID*/
    @Column
    private Long projectId;

    /*设备类型ID*/
    @Column
    private Long equipmentTypeId;

    /*计费维度*/
    @Column
    private String crObject;

    /*计费规则编码*/
    @Column
    private String crCode;

    /*计费规则*/
    @Column
    @Condition(operator = LIKE)
    private String crName;

    /*记录状态*/
    @Column
    private String enableFlag;

    /**
     * fuchun.hu@hand-china.com
     * 加了暂存字段--设备名称
     * 2017年3月20日 14:34:58
     */
    @Transient
    private String typeName;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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
