package hpms.mdm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by LoseMyself
 * on 2017/3/27   16:33
 */
@Table(name = "HPMS_MDM_PURCHASE_ORG")
public class PurchaseOrg extends BaseDTO{
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    // 表ID,主键,供其它表查询
    private Long purchaseOrgId;

    @Column
    @Condition(operator = LIKE)
    // 采购组织代码
    private String orgCode;

    @Column
    @Condition(operator = LIKE)
    // 采购组织名称
    private String orgName;

    @Column
    // 描述
    private String description;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    // 有效期起
    private Date startDate;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    // 有效期至
    private Date endDate;

    public Long getPurchaseOrgId() {
        return purchaseOrgId;
    }

    public PurchaseOrg setPurchaseOrgId(Long purchaseOrgId) {
        this.purchaseOrgId = purchaseOrgId;
        return this;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public PurchaseOrg setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public PurchaseOrg setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PurchaseOrg setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PurchaseOrg setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PurchaseOrg setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
