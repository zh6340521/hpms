package hpms.mdm.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.system.dto.BaseDTO;
@Table(name = "hpms_mdm_payment_term")
public class PaymentTerm extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long paymentTermId;//表ID
	@NotEmpty
	@Column
	private String paymentTermCode;//付款条件编码
	@NotEmpty
	@Column
	private String paymentTermName;//付款条件名称
	@Column
	private Long days;//天数
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
	public Long getPaymentTermId() {
		return paymentTermId;
	}
	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public String getPaymentTermCode() {
		return paymentTermCode;
	}
	public void setPaymentTermCode(String paymentTermCode) {
		this.paymentTermCode = paymentTermCode;
	}
	public String getPaymentTermName() {
		return paymentTermName;
	}
	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
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
	public void setArFlag(String arFlag) {
		this.arFlag = arFlag;
	}
	public String getArFlagName() {
		return arFlagName;
	}
	public void setArFlagName(String arFlagName) {
		this.arFlagName = arFlagName;
	}
	
}
