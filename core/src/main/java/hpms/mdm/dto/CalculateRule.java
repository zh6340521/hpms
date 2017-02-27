package hpms.mdm.dto;

import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.dto.CalculateRule
 * @description 计费规则 dto 类 ， 映射 HPMS_MDM_CALCULATE_RULE 表
 */

@Table(name = "HPMS_MDM_CALCULATE_RULE")
public class CalculateRule extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long calculateRuleId;

    /**
     * 编码
     */
    @Condition(operator = LIKE)
    private String ruleCode;

    /**
     * 计算公式名称
     */
    @Condition(operator = LIKE)
    private String ruleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 记录状态
     */
    private String enableFlag;

    public Long getCalculateRuleId() {
        return calculateRuleId;
    }

    public void setCalculateRuleId(Long calculateRuleId) {
        this.calculateRuleId = calculateRuleId;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

}
