package hpms.mdm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;

/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name BpGeneral
 * @description:销售财务信息实体类
 * @date 2017/2/22
 * 
 */
@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_SALES_FINACIAL")
public class SalesFinacial extends BaseDTO{
	
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
	private Long  salesFinacialId;
    
    
    /**
     * 客户id
     */
    @Column
    private Long custId;
    
    /**
     * 公司id
     */
    @Column
    private Long companyId;
    
    @Column
    private Long creditLine;
    
    /**
     * 催款等级
     */
    @Column
    private String deptLevel;
    
    /**
     * 应收科目
     */
    @Column
    private String receivableAccount;

    /**
     * 税科目
     */
    @Column
    private String taxAccount;
    /**
     * 税码
     */
    @Column
    private String taxCode;
    
    /**
     * 付款条件id
     */
    @Column
    private Long paymentTermId;
    
    /**
     * 支付方式id
     */
    @Column
    private String paymentMethodId;

    /**
     * 付款币种
     */
    @Column
    private String paymentCurrency;
    
    /**
     * 银行账户id
     */
    @Column
    private Long bankAccountId;
    
    /**
     * 有效期起
     */
    @Column
    private Date startDateActive;
    
    /**
     * 有效期至
     */
    @Column
    private Date endDateActive;
    
    
    /**
     * 记录状态
     */
    @Column
    private String enableFlag;
    
    
    @Column
    private Long programId;
    
    
    @Column
    private Long requestId;
    
    
    /**
     * 行版本号,用来处理锁
     */
    @Column
    private Long objectVersionNumber;
    
    @Transient
    private String companyFullName;
    
    @Transient
    private String paymentMethodName;
    
    @Transient
    private String paymentTermName;
   @Transient 
    private String meaning1;
	
	public String getMeaning1() {
	return meaning1;
}

public void setMeaning1(String meaning1) {
	this.meaning1 = meaning1;
}




	public String getCompanyFullName() {
	return companyFullName;
}

public void setCompanyFullName(String companyFullName) {
	this.companyFullName = companyFullName;
}

public String getPaymentMethodName() {
	return paymentMethodName;
}

public void setPaymentMethodName(String paymentMethodName) {
	this.paymentMethodName = paymentMethodName;
}

public String getPaymentTermName() {
	return paymentTermName;
}

public void setPaymentTermName(String paymentTermName) {
	this.paymentTermName = paymentTermName;
}

	public Long getSalesFinacialId() {
		return salesFinacialId;
	}

	public void setSalesFinacialId(Long salesFinacialId) {
		this.salesFinacialId = salesFinacialId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(Long creditLine) {
		this.creditLine = creditLine;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getReceivableAccount() {
		return receivableAccount;
	}

	public void setReceivableAccount(String receivableAccount) {
		this.receivableAccount = receivableAccount;
	}

	public String getTaxAccount() {
		return taxAccount;
	}

	public void setTaxAccount(String taxAccount) {
		this.taxAccount = taxAccount;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Long getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
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
