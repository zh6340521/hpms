package hpms.fin.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by LoseMyself
 * on 2017/3/13   18:21
 */
@Table(name = "HPMS_FIN_METER_GRADE_PRICE")
public class MeterGradePrice extends BaseDTO{


    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long gradePriceId;

    /*计费规则Id*/
    private Long chargeRuleId;

    /*计费段/峰段*/
    private String grade;

    /*价格*/
    private Double price;

    /*计量单位*/
    private String uom;

    /*公司ID*/
    @Transient
    private Long companyId;
    /*项目ID*/
    @Transient
    private Long projectId;
    /*设备类型ID*/
    @Transient
    private Long equipmentTypeId;

    public Long getGradePriceId() {
        return gradePriceId;
    }

    public MeterGradePrice setGradePriceId(Long gradePriceId) {
        this.gradePriceId = gradePriceId;
        return this;
    }

    public Long getChargeRuleId() {
        return chargeRuleId;
    }

    public MeterGradePrice setChargeRuleId(Long chargeRuleId) {
        this.chargeRuleId = chargeRuleId;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public MeterGradePrice setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public MeterGradePrice setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public MeterGradePrice setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }
}
