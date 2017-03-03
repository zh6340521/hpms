package hpms.mdm.dto;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.activiti.rest.common.util.DateToStringSerializer;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hand.hap.system.dto.BaseDTO;
/**
 * 
 * @name PriceHeader
 * @description 财务定价表头
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:14:05
 * @version 1.0
 */
@Table(name = "hpms_mdm_price_header")
public class PriceHeader extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long priceHeaderId;//表ID
	@NotEmpty
	@Column
	private String priceCode;//定价表编号
	@NotEmpty
	@Column
	private String priceName;//定价表名称
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
	@Column
	private String description;//描述
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	@Column
	private Date startDateActive;//有效期起
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date endDateActive;//有效期至
	@Column
	private String enableFlag;//记录状态
	public Long getPriceHeaderId() {
		return priceHeaderId;
	}
	public void setPriceHeaderId(Long priceHeaderId) {
		this.priceHeaderId = priceHeaderId;
	}
	public String getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
	public String getPriceName() {
		return priceName;
	}
	public void setPriceName(String priceName) {
		this.priceName = priceName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
