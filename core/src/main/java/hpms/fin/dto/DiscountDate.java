package hpms.fin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.activiti.rest.common.util.DateToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hand.hap.system.dto.BaseDTO;

import hpms.mdm.dto.DiscountPro;

/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name DiscountDate
 * @description:应收优惠实体类
 * @date 2017/3/9
 * 
 */
@Table(name="HPMS_FIN_DISCOUNT")
public class DiscountDate extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 表ID，主键，供其他表做外键
	 */
	@Id
	@Column
	@GeneratedValue(generator=GENERATOR_TYPE)
	private Long discountId;
	
	/**
	 * 公司id
	 */
	@Column
	private Long complanyId;
	
	/**
	 * 项目id
	 */
	@Column
	private Long projectId;
	
	/**
	 * 入货表id
	 */
	@Column
	private Long occupationId;
	
	/**
	 * 优惠日期从
	 */
	@Column
	private String discountDateFrom;
	
	/**
	 * 优惠日期至
	 */
	@Column
	private String discountDateTo;
	
	/**
	 * 优惠方案id
	 */
	@Column
	private Long discountProId;
	
	/**
	 * 调整时间
	 */
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date discountDate;
	
	/**
	 * 行版本号，用来处理锁
	 */
	@Column
	private Long objectVersionNumber;
	
	/**
	 * 公司名称
	 */
	@Transient
	private String companyFullName;
	
	/**
	 * 项目名称
	 */
	@Transient
	private String projectName;

	/**
	 * 版本id
	 */
	@Transient
	private Long versionId;
	
	/**
	 * 客户
	 */
	@Transient
	private String customerName;
	/**
	 * 建筑编码
	 */
	@Transient
	private String propertyNumber;
	
	@Transient
	private String fromDate;//计费日期起
	@Transient
	private String todate;//计费日期
	@Transient
	private String propertyName;//建筑名称
	@Transient
	private String feeStatus;//状态
	@Transient
	private String feePeriod;//计费日期
	@Transient
	private Long feeId;//费项类型id
	@Transient
	private Long feeListId;//id
	@Transient
	private String discountProName;//优惠方案名称
	@Transient
	private String feeName;//费项类型名称
	@Column
	private float grossAmount;//总额
	
	@Column
	private float adjAmount;//优惠总额
	
	@Column
	private float totalAmount;//应收总额
	
	@Transient
	private Long item;//查询到的条数别名
	@Transient
	private float gross;//总金额别名
	
	@Transient
	private FeeList feelist;//应收对象
	
	@Transient
	private DiscountPro discountPro;//优惠表对象
	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	public float getGross() {
		return gross;
	}

	public void setGross(float gross) {
		this.gross = gross;
	}

	public Long getFeeId() {
		return feeId;
	}

	public float getGrossAmount() {
		return grossAmount;
	}
	
	

	

	public Long getFeeListId() {
		return feeListId;
	}

	public void setFeeListId(Long feeListId) {
		this.feeListId = feeListId;
	}

	public void setGrossAmount(float grossAmount) {
		this.grossAmount = grossAmount;
	}

	public float getAdjAmount() {
		return adjAmount;
	}

	public void setAdjAmount(float adjAmount) {
		this.adjAmount = adjAmount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public FeeList getFeelist() {
		return feelist;
	}

	public void setFeelist(FeeList feelist) {
		this.feelist = feelist;
	}

	public DiscountPro getDiscountPro() {
		return discountPro;
	}

	public void setDiscountPro(DiscountPro discountPro) {
		this.discountPro = discountPro;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	public String getDiscountProName() {
		return discountProName;
	}

	public void setDiscountProName(String discountProName) {
		this.discountProName = discountProName;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public String getFeePeriod() {
		return feePeriod;
	}

	public void setFeePeriod(String feePeriod) {
		this.feePeriod = feePeriod;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Long getComplanyId() {
		return complanyId;
	}

	public void setComplanyId(Long complanyId) {
		this.complanyId = complanyId;
	}

	public void setObjectVersionNumber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}
	

	public String getDiscountDateFrom() {
		return discountDateFrom;
	}

	public void setDiscountDateFrom(String discountDateFrom) {
		this.discountDateFrom = discountDateFrom;
	}

	public String getDiscountDateTo() {
		return discountDateTo;
	}

	public void setDiscountDateTo(String discountDateTo) {
		this.discountDateTo = discountDateTo;
	}

	public Long getDiscountProId() {
		return discountProId;
	}

	public void setDiscountProId(Long discountProId) {
		this.discountProId = discountProId;
	}

	
	public Date getDiscountDate() {
		return discountDate;
	}

	public void setDiscountDate(Date discountDate) {
		this.discountDate = discountDate;
	}

	public Long getObjectVersionNumber() {
		return objectVersionNumber;
	}

	public void setObjectVersionNymber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	

}
