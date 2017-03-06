package hpms.mdm.dto;

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
 * @name Customer
 * @description:客户档案实体类
 * @date 2017/2/17
 * 
 */
@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_CUSTOMER")
public class Customer extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	/**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
	private Long customerId;
    
    /**
     * Bp表id
     */
    @Column
    private Long bpId;
    /**
     * 集团ID
     */
    @Column
    private Long groupId;
    
    /**
     * 公司ID
     */
    @Column
    private Long companyId;
    
    /**
     * 客户编号
     */
    @Column
    private String customerNumber;
    
    /**
     * 客户类型
     */
    @Column
    private String customerType;
    
    /**
     * 记录状态
     */
    @Column
    private String enableFlag;
    
    /**
     * 公司ID
     */
    @Column
    private Long programId;
    /**
     * 公司ID
     */
    @Column
    private Long requestId;
    /**
     * 
     *
     * 行版本号,用来处理锁
     */
    @Column
    private Long objectVersionNumber;
    
    /**
     * 姓名
     */
    @Transient
	private String fullName;
    
    public String getMeaning2() {
		return meaning2;
	}
	public void setMeaning2(String meaning2) {
		this.meaning2 = meaning2;
	}
	/**
     * 手机号码
     */
    @Transient
	private String contactMobile;
    
    /**
     * 证件号码
     */
    @Transient
	private String credentialNumber;
    
    /**
     * 客户类型
     */
    @Transient
    private String meaning1;
    
    
    /**
     * 证件类型(个人)
     */
    @Transient
    private String meaning2;
    
    
    
    /**
     * 证件类型(个人)
     */
    @Transient
    private String meaning;
    public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	/**
     * 证件类型(公司)
     */
    @Transient
    private String meaning3;
    
    public String getMeaning3() {
		return meaning3;
	}
	public void setMeaning3(String meaning3) {
		this.meaning3 = meaning3;
	}
	public String getMeaning1() {
		return meaning1;
	}
	public void setMeaning1(String meaning1) {
		this.meaning1 = meaning1;
	}
	/**
     * 证件类型
     */
    @Transient
	private String credentialType;
    
    @Transient
    private BpGeneral bpGeneral;
    
    
    
	public BpGeneral getBpGeneral() {
		return bpGeneral;
	}
	public void setBpGeneral(BpGeneral bpGeneral) {
		this.bpGeneral = bpGeneral;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getCredentialNumber() {
		return credentialNumber;
	}
	public void setCredentialNumber(String credentialNumber) {
		this.credentialNumber = credentialNumber;
	}
	public String getCredentialType() {
		return credentialType;
	}
	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getBpId() {
		return bpId;
	}
	public void setBpId(Long bpId) {
		this.bpId = bpId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
