package hpms.fin.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LoseMyself
 * on 2017/3/20   14:35
 */
@Table(name = "HPMS_FIN_METER_SHARE_RULE")
public class ShareRule extends BaseDTO{
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long shareRuleId;

    // 公司ID
    private Long companyId;

    // 项目ID
    private Long projectId;

    // 设备类型ID
    private Long equipmentTypeId;

    // 设备ID
    private Long equipmentId;

    // 分摊规则
    private String shareRule;

    public Long getShareRuleId() {
        return shareRuleId;
    }

    public ShareRule setShareRuleId(Long shareRuleId) {
        this.shareRuleId = shareRuleId;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public ShareRule setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public Long getProjectId() {
        return projectId;
    }

    public ShareRule setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public ShareRule setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
        return this;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public ShareRule setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    public String getShareRule() {
        return shareRule;
    }

    public ShareRule setShareRule(String shareRule) {
        this.shareRule = shareRule;
        return this;
    }
}
