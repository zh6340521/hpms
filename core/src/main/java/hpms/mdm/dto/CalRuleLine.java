package hpms.mdm.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.dto.CalRuleLine
 * @description 计费规则行数据 dto 类 ， 映射 HPMS_MDM_CAL_RULE_LINE 表
 */

@Table(name = "HPMS_MDM_CAL_RULE_LINE")
public class CalRuleLine extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long calRuleLineId;

    /**
     *计算规则 ID
     */
    private Long calculateRuleId;

    /**
     *计算要素 ID
     */
    private Long calculateElementId;

    /**
     *计算符号
     */
    private String calculateOperator;

    /**
     *描述
     */
    private String description;

    /**
     *记录状态
     */
    private String enableFlag;

    /**
     * 计算要素名称
     */
    @Transient
    private String elementName;

    public void setCalRuleLineId(Long calRuleLineId) {
        this.calRuleLineId = calRuleLineId;
    }

    public Long getCalRuleLineId() {
        return calRuleLineId;
    }

    public void setCalculateRuleId(Long calculateRuleId) {
        this.calculateRuleId = calculateRuleId;
    }

    public Long getCalculateRuleId() {
        return calculateRuleId;
    }

    public void setCalculateElementId(Long calculateElementId) {
        this.calculateElementId = calculateElementId;
    }

    public Long getCalculateElementId() {
        return calculateElementId;
    }

    public void setCalculateOperator(String calculateOperator) {
        this.calculateOperator = calculateOperator;
    }

    public String getCalculateOperator() {
        return calculateOperator;
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

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
}
