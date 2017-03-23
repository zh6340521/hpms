package hpms.fin.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;

import static com.hand.hap.core.BaseConstants.GENERATOR_TYPE;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:24
 */
@Table(name = "HPMS_FIN_METER_SHARE_BIND")
public class ShareRuleBind{
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long shareBindId;

    // 公司ID
    @Column
    private Long companyId;

    // 项目ID
    @Column
    private Long projectId;

    // 公表分摊规则
    @Column
    private Long shareRuleId;

    // 建筑实体ID
    @Column
    private Long propertyId;

    /**
     * fuchun.hu@hand-china.com
     * 加了暂存字段
     */
    @Transient
    private String companyName;
    @Transient
    private String projectname;
    @Transient
    private String propertyName;
    @Transient
    private String propertyNumber;


    public Long getShareBindId() {
        return shareBindId;
    }

    public void setShareBindId(Long shareBindId) {
        this.shareBindId = shareBindId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getShareRuleId() {
        return shareRuleId;
    }

    public void setShareRuleId(Long shareRuleId) {
        this.shareRuleId = shareRuleId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }
}
