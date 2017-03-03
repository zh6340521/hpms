package hpms.cs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.dto.Occupation
 * @description 入退伙 dto 类 ， 映射 HPMS_CS_OCCUPATION 表
 */

@Table(name = "HPMS_CS_OCCUPATION")
public class Occupation extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long occupationId;

    /**
     *公司
     */
    private Long companyId;

    /**
     *项目
     */
    private Long projectId;

    /**
     *客户ID
     */
    private Long customerId;

    /**
     *客户编码
     */
    private String customerCode;

    /**
     *客户
     */
    private String customerName;

    /**
     *建筑实体
     */
    private Long propertyId;

    /**
     *建筑代码
     */
    private String propertyNumber;

    /**
     *建筑名称
     */
    private String propertyName;

    /**
     *建筑面积
     */
    private Long roomArea;

    /**
     *服务开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date serviceDateFrom;

    /**
     *服务截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date serviceDateTo;

    /**
     *入伙日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transferDate;

    /**
     *计费开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feeDate;

    /**
     *入伙经办人
     */
    private String inTransactor;

    /**
     *退伙日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moveoutDate;

    /**
     *退伙经办人
     */
    private String outTransactor;

    /**
     *计费结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feeDateTo;

    /**
     *退伙原因
     */
    private String moveoutReason;

    /**
     *备注
     */
    private String remarks;

    /**
     *退伙材料是否齐全
     */
    private String moveoutFlag;

    /**
     *状态
     */
    private String status;

    /**
     * 公司名称
     */
    @Transient
    private String companyName;

    /**
     * 项目名称
     */
    @Transient
    private String projectName;

    @Transient
    private List<OccProcedure> occProcedures;

    public void setOccupationId(Long occupationId) {
        this.occupationId = occupationId;
    }

    public Long getOccupationId() {
        return occupationId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setRoomArea(Long roomArea) {
        this.roomArea = roomArea;
    }

    public Long getRoomArea() {
        return roomArea;
    }

    public void setServiceDateFrom(Date serviceDateFrom) {
        this.serviceDateFrom = serviceDateFrom;
    }

    public Date getServiceDateFrom() {
        return serviceDateFrom;
    }

    public void setServiceDateTo(Date serviceDateTo) {
        this.serviceDateTo = serviceDateTo;
    }

    public Date getServiceDateTo() {
        return serviceDateTo;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setInTransactor(String inTransactor) {
        this.inTransactor = inTransactor;
    }

    public String getInTransactor() {
        return inTransactor;
    }

    public void setMoveoutDate(Date moveoutDate) {
        this.moveoutDate = moveoutDate;
    }

    public Date getMoveoutDate() {
        return moveoutDate;
    }

    public void setOutTransactor(String outTransactor) {
        this.outTransactor = outTransactor;
    }

    public String getOutTransactor() {
        return outTransactor;
    }

    public void setFeeDateTo(Date feeDateTo) {
        this.feeDateTo = feeDateTo;
    }

    public Date getFeeDateTo() {
        return feeDateTo;
    }

    public void setMoveoutReason(String moveoutReason) {
        this.moveoutReason = moveoutReason;
    }

    public String getMoveoutReason() {
        return moveoutReason;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setMoveoutFlag(String moveoutFlag) {
        this.moveoutFlag = moveoutFlag;
    }

    public String getMoveoutFlag() {
        return moveoutFlag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<OccProcedure> getOccProcedures() {
        return occProcedures;
    }

    public void setOccProcedures(List<OccProcedure> occProcedures) {
        this.occProcedures = occProcedures;
    }
}
