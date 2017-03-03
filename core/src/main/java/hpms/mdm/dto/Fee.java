package hpms.mdm.dto;



import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;


/**
 * @author jun.guo@hand-china.com
 * @version 1.0
 * @name Fee
 * @description:收费项目实体类
 * @date 2017/2/16
 */
@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_FEE")
public class Fee extends BaseDTO {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -3690266863289816002L;
	@Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long feeId;
    @Column
    private String feeCode;
    @Column
    private String feeName;
    @Column
    private String description;
    @Column
    private String billingFrequency;
    @Column
    private String billingMethod;
    @Column
    private String revenueAccount;
    @Column
    private Date startDateActive;
    @Column
    private Date endDateActive;
    @Column
    private String enableFlag;
    @Column
    private Long feeTypeId;
    @Column
    private String transType;
    @Column
    private Long overdueRate;
    @Column
    private Long chargeDays;
    @Column
    private String roundRule;
    @Column
    private Long precision;
    @Column
    private String priceEditFlag;
    @Column
    private String equipmentFlag;
    @Column
    private String equipmentType;
    @Column
    private String overdueFalg;
    @Column
    private String itemFlag;

    @Transient
    private String feeTypeName;
    
    @Transient
    private String meaning1;
    
    @Transient
    private String meaning2;
    
    @Transient
    private String meaning3;
    
    @Transient
    private String meaning4;
    
    @Transient
    private Long itemCount;

    public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	public String getMeaning1() {
		return meaning1;
	}

	public void setMeaning1(String meaning1) {
		this.meaning1 = meaning1;
	}

	public String getMeaning2() {
		return meaning2;
	}

	public void setMeaning2(String meaning2) {
		this.meaning2 = meaning2;
	}

	public String getMeaning3() {
		return meaning3;
	}

	public void setMeaning3(String meaning3) {
		this.meaning3 = meaning3;
	}

	public String getMeaning4() {
		return meaning4;
	}

	public void setMeaning4(String meaning4) {
		this.meaning4 = meaning4;
	}

	public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public Long getFeeId() {
        return feeId;
    }

    public String getFeeTypeName() {
		return feeTypeName;
	}

	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}

	public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setBillingFrequency(String billingFrequency) {
        this.billingFrequency = billingFrequency;
    }

    public String getBillingFrequency() {
        return billingFrequency;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod;
    }

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setRevenueAccount(String revenueAccount) {
        this.revenueAccount = revenueAccount;
    }

    public String getRevenueAccount() {
        return revenueAccount;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setFeeTypeId(Long feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    public Long getFeeTypeId() {
        return feeTypeId;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransType() {
        return transType;
    }

    public void setOverdueRate(Long overdueRate) {
        this.overdueRate = overdueRate;
    }

    public Long getOverdueRate() {
        return overdueRate;
    }

    public void setChargeDays(Long chargeDays) {
        this.chargeDays = chargeDays;
    }

    public Long getChargeDays() {
        return chargeDays;
    }

    public void setRoundRule(String roundRule) {
        this.roundRule = roundRule;
    }

    public String getRoundRule() {
        return roundRule;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPriceEditFlag(String priceEditFlag) {
        this.priceEditFlag = priceEditFlag;
    }

    public String getPriceEditFlag() {
        return priceEditFlag;
    }

    public void setEquipmentFlag(String equipmentFlag) {
        this.equipmentFlag = equipmentFlag;
    }

    public String getEquipmentFlag() {
        return equipmentFlag;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setOverdueFalg(String overdueFalg) {
        this.overdueFalg = overdueFalg;
    }

    public String getOverdueFalg() {
        return overdueFalg;
    }

    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag;
    }

    public String getItemFlag() {
        return itemFlag;
    }

}
