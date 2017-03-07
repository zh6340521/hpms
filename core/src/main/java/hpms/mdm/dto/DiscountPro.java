package hpms.mdm.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.system.dto.BaseDTO;
/**
 * 
 * @name DiscountPro
 * @description 优惠方案DTO
 * @author chengye.hu@hand-china.com	2017年2月24日上午9:44:54
 * @version 1.0
 */
@Table(name = "hpms_mdm_discount_pro")
public class DiscountPro extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long discountProId;//主键ID
	@NotEmpty
	@Column
	private String discountProCode;//优惠方案编码
	@NotEmpty
	@Column
	private String discountProName;//优惠方案名称
	@NotNull
	@Column
	private Long companyId;//公司
	@Transient
	private String companyName;//公司名称
	@NotNull
	@Column
	private Long projectId;//项目名称
	@Transient
	private String projectName;//项目名称
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
	@NotEmpty
	@Column
	private String discountType;//折扣类型
	@Transient
	private String discountTypeName;//折扣类型名称
	@Column
	private Float amount;//优惠金额
	@Column
	private Float percent;//百分比
	@Column
	private String description;//描述
	@Column
	private String enableFlag;//记录状态
	@Transient
	private String enableFlagName;//状态名称
	public Long getDiscountProId() {
		return discountProId;
	}
	public void setDiscountProId(Long discountProId) {
		this.discountProId = discountProId;
	}
	public String getDiscountProCode() {
		return discountProCode;
	}
	public void setDiscountProCode(String discountProCode) {
		this.discountProCode = discountProCode;
	}
	public String getDiscountProName() {
		return discountProName;
	}
	public void setDiscountProName(String discountProName) {
		this.discountProName = discountProName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountTypeName() {
		return discountTypeName;
	}
	public void setDiscountTypeName(String discountTypeName) {
		this.discountTypeName = discountTypeName;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getPercent() {
		return percent;
	}
	public void setPercent(Float percent) {
		this.percent = percent;
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
	public String getEnableFlagName() {
		return enableFlagName;
	}
	public void setEnableFlagName(String enableFlagName) {
		this.enableFlagName = enableFlagName;
	}
	
}
