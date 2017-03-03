package hpms.fin.dto;

import java.util.Date;

import org.activiti.rest.common.util.DateToStringSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class FeeListNew extends FeeList{
	private static final long serialVersionUID = 1L;
	private Long projectId;
	private String structureName;
	private Long structureId;
	private String creationPeriod;
	private Long num;
	private Long versionId;
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date feeListDate;
	private Long number;
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public Long getStructureId() {
		return structureId;
	}
	public void setStructureId(Long structureId) {
		this.structureId = structureId;
	}
	public String getCreationPeriod() {
		return creationPeriod;
	}
	public void setCreationPeriod(String creationPeriod) {
		this.creationPeriod = creationPeriod;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Date getFeeListDate() {
		return feeListDate;
	}
	public void setFeeListDate(Date feeListDate) {
		this.feeListDate = feeListDate;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
}
