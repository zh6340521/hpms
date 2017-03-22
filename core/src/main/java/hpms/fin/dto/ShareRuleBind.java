package hpms.fin.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.hand.hap.core.BaseConstants.GENERATOR_TYPE;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:24
 */
@Table(name = "HPMS_FIN_METER_SHARE_BIND")
public class ShareRuleBind {
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long shareBindId;

    // 公司ID
    private Long companyId;

    // 项目ID
    private Long projectId;

    // 公表分摊规则
    private Long shareRuleId;

    // 建筑实体ID
    private Long propertyId;

    public Long getShareBindId() {
        return shareBindId;
    }

    public ShareRuleBind setShareBingId(Long shareBindId) {
        this.shareBindId = shareBindId;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public ShareRuleBind setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public Long getProjectId() {
        return projectId;
    }

    public ShareRuleBind setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public Long getShareRuleId() {
        return shareRuleId;
    }

    public ShareRuleBind setShareRuleId(Long shareRuleId) {
        this.shareRuleId = shareRuleId;
        return this;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public ShareRuleBind setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
        return this;
    }
}
