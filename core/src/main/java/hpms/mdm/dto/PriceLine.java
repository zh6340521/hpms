package hpms.mdm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
	private Long feeTypeId;//行ID
	@NotNull
	@Column
	private Long feeId;//费项类型
	@NotNull
	@Column
	private Long projectId;//费项
	@NotNull
	@Column
	private Long unitPrice;//单价
	@NotEmpty
	@Column
	private String currency;//币种
	@NotEmpty
	@Column
	private String billingMethod;//计算方式
	@Column
	private Long calculateRuleId;//计算规则
	@Column
	private String feeUom;//单位
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column
	private Date startDateActive;//有效期起
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
	public Long getFeeId() {
		return feeId;
	}
	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBillingMethod() {
		return billingMethod;
	}
	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
	public Long getCalculateRuleId() {
		return calculateRuleId;
	}
	public void setCalculateRuleId(Long calculateRuleId) {
		this.calculateRuleId = calculateRuleId;
	}
	public String getFeeUom() {
		return feeUom;
	}
	public void setFeeUom(String feeUom) {
		this.feeUom = feeUom;
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
