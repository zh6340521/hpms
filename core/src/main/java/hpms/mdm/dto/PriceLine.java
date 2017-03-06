package hpms.mdm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;
/**
 * 
 * @name PriceLine
 * @description 财务价目表行
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:24:10
 * @version 1.0
 */
@Table(name = "hpms_mdm_price_line")
public class PriceLine extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long priceLineId;//表ID
	@NotNull
	@Column
	private Long priceHeaderId;//定价表名称
	@NotNull
	@Column 
	private Long feeTypeId;//费项类型
	@Transient
	private String feeTypeName;//费项类型名称
	@NotNull
	@Column
	private Long feeId;//费项
	@Transient
	private String feeName;//费项名称
	@NotNull
	@Column
	private Float unitPrice;//单价
	@NotEmpty
	@Column
	private String currency;//币种
	@Transient
	private String currencyName;//币种名称
	@NotEmpty
	@Column
	private String billingMethod;//计算方式
	@Transient
	private String billingMethodName;//计算方式名称
	@Column
	private Long calculateRuleId;//计算规则
	@Transient
	private String ruleName;//计算规则名称
	@Column
	private String feeUom;//单位
	@Transient
	private String feeUomName;//单位名称
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private Date startDateActive;//有效期起
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private Date endDateActive;//有效期至
	@Column
	private String enableFlag;//记录状态
	public Long getPriceLineId() {
		return priceLineId;
	}
	public void setPriceLineId(Long priceLineId) {
		this.priceLineId = priceLineId;
	}
	public Long getPriceHeaderId() {
		return priceHeaderId;
	}
	public void setPriceHeaderId(Long priceHeaderId) {
		this.priceHeaderId = priceHeaderId;
	}
	public Long getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(Long feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public String getFeeTypeName() {
		return feeTypeName;
	}
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	public Long getFeeId() {
		return feeId;
	}
	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getBillingMethod() {
		return billingMethod;
	}
	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
	public String getBillingMethodName() {
		return billingMethodName;
	}
	public void setBillingMethodName(String billingMethodName) {
		this.billingMethodName = billingMethodName;
	}
	public Long getCalculateRuleId() {
		return calculateRuleId;
	}
	public void setCalculateRuleId(Long calculateRuleId) {
		this.calculateRuleId = calculateRuleId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getFeeUom() {
		return feeUom;
	}
	public void setFeeUom(String feeUom) {
		this.feeUom = feeUom;
	}
	public String getFeeUomName() {
		return feeUomName;
	}
	public void setFeeUomName(String feeUomName) {
		this.feeUomName = feeUomName;
	}
	public Date getStartDateActive() {
		return startDateActive;
	}
	public void setStartDateActive(Date startDateActive) {
		this.startDateActive = startDateActive;
	}
	public Date getEndDateActive() {
		return endDateActive;
	}
	public void setEndDateActive(Date endDateActive) {
		this.endDateActive = endDateActive;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	
}
