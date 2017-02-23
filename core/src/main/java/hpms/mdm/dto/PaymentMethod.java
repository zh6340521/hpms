package hpms.mdm.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.system.dto.BaseDTO;

/**
 * 
 * @name PaymentMethod
 * @description 付款方式 DTO
 * @author chengye.hu@hand-china.com	2017年2月23日下午1:37:05
 * @version 1.0
 */
@Table(name = "hpms_mdm_payment_method")
public class PaymentMethod extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long paymentMethodId;//表ID
	@NotEmpty
	@Column
	private String paymentMethodCode;//付款方式编码
	@NotEmpty
	@Column
	private String paymentMethodName;//付款方式名称
	@Column
	private String description;//描述
	@NotEmpty
	@Column
	private String apFlag;//应付
	@Transient
	private String apFlagName;
	@NotEmpty
	@Column
	private String arFlag;//应收
	@Transient
	private String arFlagName;
	public Long getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}
	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApFlag() {
		return apFlag;
	}
	public void setApFlag(String apFlag) {
		this.apFlag = apFlag;
	}
	public String getApFlagName() {
		return apFlagName;
	}
	public void setApFlagName(String apFlagName) {
		this.apFlagName = apFlagName;
	}
	public String getArFlag() {
		return arFlag;
	}
	public String getArFlagName() {
		return arFlagName;
	}
	public void setArFlagName(String arFlagName) {
		this.arFlagName = arFlagName;
	}
	public void setArFlag(String arFlag) {
		this.arFlag = arFlag;
	}
	
}
