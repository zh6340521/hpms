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
 * @description:一般信息实体类
 * @date 2017/2/22
 * 
 */
@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_BP_GENERAL")
public class BpGeneral extends BaseDTO{
	
	
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
	private Long bpId;
    
    /**
     * 编号
     */
    @Column
    private String bpNumber;
    
    
    /**
     * 名称
     */
    @Column
    private String bpName;
    
    /**
     * 姓名
     */
    @Column
    private String fullName;
    
    
    @Column
    private String personTitle;
    
    
    /**
     * 企业名称
     */
    @Column
    private String companyName;
    
    /**
     * 企业类型
     */
    @Column
    private String companyType;
    
    /**
     * 性别
     */
    @Column
	private String personGender;
    
    /**
     * 出生日期
     */
    @Column
    private Date personBirthday;
    
    /**
     * 联系人
     */
    @Column
    private String contactName;
    
    /**
     * 手机号码
     */
    @Column
    private String contactMobile;
    
    /**
     *办公电话
     */
    @Column
    private String officeNumber;
    
    /**
     * 固定电话
     */
    @Column
    private String contactTel;
    
    /**
     * 邮箱
     */
    @Column
    private String contactEmail;
    
    /**
     * 传真
     */
    @Column
    private String fax;
    
    
    /**
     * 居住证
     */
    @Column
    private String habitationCard;
    
    /**
     * 证件号码
     */
    @Column
    private String credentialNumber;
    
    /**
     * 证件类型
     */
    @Column
    private String credentialType;
    

	/**
     * 国籍
     */
    @Column
    private String country;
    
    /**
     * 名族
     */
    @Column
    private String nation;
    
    /**
     * 籍贯
     */
    @Column
    private String placeOfOrigin;
    
    /**
     * 户口所在地
     */
    @Column
    private String residenza;
    
    /**
     * 是否接受信息
     */
    @Column
    private String messageFlag;
    
    
    @Column
    private String avatarFileName;
    
    
    @Column
    private String avatarContentType;
    
  
    @Column
    private Long avatarFileSize;
    
    
    /**
     * 日期
     */
    @Column
    private Date avatarUpdatedAt;
    
    /**
     * 记录状态
     */
    @Column
    private String enableFlag;
    
    @Transient
    private Long fromBpId;
    
    @Transient
    private Long toBpId;
    
    @Transient
    private Long relationId;
    public Long getFromBpId() {
		return fromBpId;
	}

	public void setFromBpId(Long fromBpId) {
		this.fromBpId = fromBpId;
	}

	public Long getToBpId() {
		return toBpId;
	}

	public void setToBpId(Long toBpId) {
		this.toBpId = toBpId;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	@Column
    private Long programId;
    
    
    @Column
    private Long requestId;
    
    
    /**
     * 客户编号
     */
    @Transient
    private String customerNumber;
    /**
     * 客户类型
     */
    @Transient
    private String customerType;
    
    
    @Transient
    private String meaning;
    
    @Transient
    private String meaning4;
    
    @Transient
    private String meaning2;
    @Transient
    private String meaning3;
    
    public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getMeaning4() {
		return meaning4;
	}

	public void setMeaning4(String meaning4) {
		this.meaning4 = meaning4;
	}

	public String getMeaning2() {
		return meaning2;
	}

	public void setMeaning2(String meaning2) {
		this.meaning2 = meaning2;
	}

	public String getMeaning3() {
		return meaning3;
	}

	public void setMeaning3(String meaning3) {
		this.meaning3 = meaning3;
	}

	/**
     * 集团id
     */
    @Transient
    private Long groupId;
    public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
     * 行版本号,用来处理锁
     */
    @Column
    private Long objectVersionNumber;
    
    @Transient
    private String relType;

    @Transient
    private String icmFlag;
    
    public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getIcmFlag() {
		return icmFlag;
	}

	public void setIcmFlag(String icmFlag) {
		this.icmFlag = icmFlag;
	}

	@Transient
    private Long customerId;
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

	public String getBpNumber() {
		return bpNumber;
	}

	public void setBpNumber(String bpNumber) {
		this.bpNumber = bpNumber;
	}

	public String getBpName() {
		return bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(String personTitle) {
		this.personTitle = personTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public Date getPersonBirthday() {
		return personBirthday;
	}

	public void setPersonBirthday(Date personBirthday) {
		this.personBirthday = personBirthday;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHabitationCard() {
		return habitationCard;
	}

	public void setHabitationCard(String habitationCard) {
		this.habitationCard = habitationCard;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getMessageFlag() {
		return messageFlag;
	}

	public void setMessageFlag(String messageFlag) {
		this.messageFlag = messageFlag;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public Long getAvatarFileSize() {
		return avatarFileSize;
	}

	public void setAvatarFileSize(Long avatarFileSize) {
		this.avatarFileSize = avatarFileSize;
	}

	public Date getAvatarUpdatedAt() {
		return avatarUpdatedAt;
	}

	public void setAvatarUpdatedAt(Date avatarUpdatedAt) {
		this.avatarUpdatedAt = avatarUpdatedAt;
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
    

    
    public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

    

}
