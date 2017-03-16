package hpms.fin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @name hpms.fin.dto.ReceiptFeeList
 * @description 收款录入使用，继承自FeeList，方便封装数据
 * @ author feng.liu01@hand-china.com 2017/03/08 15:42
 * @ version 1.0
 */
public class ReceiptFeeList extends FeeList{
    /**
     *收款方式
     */
    private String receiptMethod;

    /**
     *收款方式
     */
    private String receiptMethodName;

    /**
     * 可结算金额
     */
    private Float settlementAmount;

    /**
     * 收款单id
     */
    private Long receiptId;

    /**
     * 收款单编号
     */
    private String receiptNum;

    /**
     * 行项目
     */
    private Long lineNumber;

    /**
     * 收款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receiptDate;

    /**
     * 收款状态
     */
    private String receiptStatus;

    /**
     * 收款状态名称
     */
    private String receiptStatusName;

    private String type;

    /**
     * 单据类型
     */
    private String docType;

    /**
     * 收款金额
     */
    private Float receiptAmount;

    /**
     * 项目ID
     */
    private Long projectId;

    public String getReceiptMethod() {
        return receiptMethod;
    }

    public void setReceiptMethod(String receiptMethod) {
        this.receiptMethod = receiptMethod;
    }

    public Float getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Float settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public String getReceiptStatusName() {
        return receiptStatusName;
    }

    public void setReceiptStatusName(String receiptStatusName) {
        this.receiptStatusName = receiptStatusName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Float getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Float receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getReceiptMethodName() {
        return receiptMethodName;
    }

    public void setReceiptMethodName(String receiptMethodName) {
        this.receiptMethodName = receiptMethodName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
