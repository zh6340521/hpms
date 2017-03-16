package hpms.fin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hand.hap.system.dto.BaseDTO;
import org.activiti.rest.common.util.DateToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/08
 * @version 1.0
 * @name hpms.fin.dto.Receipt
 * @description 收款录入 dto 类
 */

@Table(name = "HPMS_FIN_RECEIPT")
public class Receipt extends BaseDTO {
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long receiptId;

    /**
     * 应收费用清单ID
     */
    private Long feeListId;

    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 收款单编号
     */
    private String receiptNum;

    /**
     * 行项目
     */
    private Long lineNumber;

    /**
     * 参考编号
     */
    private String referenceNumber;

    /**
     * 入伙表ID
     */
    private Long occupationId;

    /**
     * 款项类型ID
     */
    private Long feeTypeId;

    /**
     * 收费项目ID
     */
    private Long feeId;

    /**
     * 收款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date receiptDate;

    /**
     * 收款方式
     */
    private String receiptMethod;

    /**
     * 收款条件
     */
    private String receiptTerm;

    /**
     * 收款金额
     */
    private Float receiptAmount;

    /**
     * 退款金额
     */
    private Float refundAmount;

    /**
     * 扣款金额
     */
    private Float deductAmount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 计费期间
     */
    private String receiptPeriod;

    /**
     * 交易类型
     */
    private String transType;

    /**
     * 折扣金额
     */
    private Float adjAmount;

    /**
     * 折扣原因
     */
    private String deductReason;

    /**
     * 交款人
     */
    private String payer;

    /**
     * 收款人
     */
    private String transactor;

    /**
     * 结算人
     */
    private String clearTransactor;

    /**
     * 结算编号
     */
    private String clearCode;

    /**
     * 结清日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    private Date clearedDate;

    /**
     * 收款状态
     */
    private String receiptStatus;

    /**
     * 备注，有条件的话做成多行文本
     */
    private String description;

    @Transient
    private List<ReceiptFeeList> feeLists;

    /**
     * 用于在service层判断前台操作类型
     */
    @Transient
    private String operationType;

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getFeeListId() {
        return feeListId;
    }

    public void setFeeListId(Long feeListId) {
        this.feeListId = feeListId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Long occupationId) {
        this.occupationId = occupationId;
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptMethod() {
        return receiptMethod;
    }

    public void setReceiptMethod(String receiptMethod) {
        this.receiptMethod = receiptMethod;
    }

    public String getReceiptTerm() {
        return receiptTerm;
    }

    public void setReceiptTerm(String receiptTerm) {
        this.receiptTerm = receiptTerm;
    }

    public Float getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Float receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Float getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Float refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Float getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(Float deductAmount) {
        this.deductAmount = deductAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceiptPeriod() {
        return receiptPeriod;
    }

    public void setReceiptPeriod(String receiptPeriod) {
        this.receiptPeriod = receiptPeriod;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Float getAdjAmount() {
        return adjAmount;
    }

    public void setAdjAmount(Float adjAmount) {
        this.adjAmount = adjAmount;
    }

    public String getDeductReason() {
        return deductReason;
    }

    public void setDeductReason(String deductReason) {
        this.deductReason = deductReason;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getTransactor() {
        return transactor;
    }

    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }

    public String getClearTransactor() {
        return clearTransactor;
    }

    public void setClearTransactor(String clearTransactor) {
        this.clearTransactor = clearTransactor;
    }

    public String getClearCode() {
        return clearCode;
    }

    public void setClearCode(String clearCode) {
        this.clearCode = clearCode;
    }

    public Date getClearedDate() {
        return clearedDate;
    }

    public void setClearedDate(Date clearedDate) {
        this.clearedDate = clearedDate;
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReceiptFeeList> getFeeLists() {
        return feeLists;
    }

    public void setFeeLists(List<ReceiptFeeList> feeLists) {
        this.feeLists = feeLists;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
