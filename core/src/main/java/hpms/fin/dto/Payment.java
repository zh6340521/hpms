package hpms.fin.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;


/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name Payment
 * @description:付款实体类
 * @date 2017/3/21
 *
 */
@Table(name="HPMS_FIN_PAYMENT")
public class Payment extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 表ID，主键，供其他表做外键
	 */
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long paymentId;
	
	/**
	 * 公司id
	 */
	@Column
	private Long companyId;
	
	/**
	 * 项目id
	 */
	@Column
	private Long projectId;
	
	/**
	 * 应付明细id
	 */
	@Column
	private Long invoiceId;
	
	/**
	 * 付款状态
	 */
	@Column
	private String status;
	
	/**
	 * 发票编码
	 */
	@Column
	private String invoiceNumber;
	/**
	 * 付款单编号
	 */
	@Column
	private String paymentCode;
	
	/**
	 * 收费项目id
	 */
	@Column
	private Long feeId;
	
	/**
	 * 金额
	 */
	@Column
	private Float amount;
	
	/**
	 * 交易类型
	 */
	@Column
	private String transType;
	
	/**
	 * 参考编号
	 */
	@Column
	private String referenceCode; 
	/**
	 * 付款日期
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date payDate;
	
	/**
	 * 房间编码
	 */
	@Column
	private String propertyNumber;
	
	/**
	 * 付款条件id
	 */
	@Column
	private Long paymentTermId;
	
	/**
	 * 付款方式id
	 */
	@Column
	private Long paymentMethodId;
	
	
	@Column
	private Long programId;
	
	@Column
	private Long requestId;
	
    @Transient
    private String docTypePay;//单据类型
    
	/**
	 * 行版本号，用来处理锁
	 */
	@Column
	private Long objectVersionNumber;
	
	@Transient
	private String type;
    
    /**
     * 可结算金额
     */
	@Transient
    private Float settlementAmount;
	/**
	 * 交款人
	 */
    @Column
    public String payer;
    /**
     * 行项目
     */
    @Column
    public Long lineNumber;
    @Transient
    private List<Invoice> invoice;

    /**
     * 用于在service层判断前台操作类型
     */
    @Transient
    private String operationType;
    
    @Transient
    private Long occupationId;//入伙表id
    
    @Transient
	private String payableCode;//应付明细编号 
    @Transient
    private String chargeStatus;//计费状态
    @Transient
    private String accountPeriod;//计费期间
    @Transient
    private Float invoiceAmount;//应付总额
    @Transient
    public Long feeListId;//应收id
    @Transient
    private String feeListCode;//应收计费编号
    @Transient
    private String feeStatus;//计费状态
    @Transient
    private String feePeriod;//计费期间 
    @Transient
    private Float totalAmount;//应收总额
	
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public Long getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Float getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Float invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getPayableCode() {
		return payableCode;
	}
	public void setPayableCode(String payableCode) {
		this.payableCode = payableCode;
	}
	public String getChargeStatus() {
		return chargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}
	public String getAccountPeriod() {
		return accountPeriod;
	}
	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}
	public Long getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}
	public String getDocTypePay() {
		return docTypePay;
	}
	public void setDocTypePay(String docTypePay) {
		this.docTypePay = docTypePay;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(Float settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public List<Invoice> getInvoice() {
		return invoice;
	}
	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public Long getFeeId() {
		return feeId;
	}
	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getReferenceCode() {
		return referenceCode;
	}
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPropertyNumber() {
		return propertyNumber;
	}
	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}
	public Long getPaymentTermId() {
		return paymentTermId;
	}
	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public Long getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getObjectVersionNumber() {
		return objectVersionNumber;
	}
	public void setObjectVersionNumber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}
	
	
	
	
}
