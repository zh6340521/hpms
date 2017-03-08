package hpms.fin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.activiti.rest.common.util.DateToStringSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hand.hap.system.dto.BaseDTO;
/**
 * 
 * @name FeeList
 * @description 应收费用清单DTO
 * @author chengye.hu@hand-china.com	2017年2月27日下午2:02:00
 * @version 1.0
 */
@Table(name = "hpms_fin_fee_list")
public class FeeList extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long feeListId;//表ID，主键
	@Column
	private String feeListCode;//计费单编号
	@Column
	private String feeStatus;//计费单状态
	@Transient
	private String feeStatusName;//计费单状态名称
	@Column
	private Long occupationId;//计费对象
	@Transient
	private String customerName;//客户名称
	@Transient
	private String propertyName;//建筑名称
	@Transient
	private String propertyNumber;//建筑编码
	@Column
	private String feePeriod;//计费期间
	@Column
	private Long feeTypeId;//款项类型ID
	@Transient
	private String feeTypeName;//款项类型名称
	@Column
	private Long feeId;//收费项目ID
	@Transient
	private String feeName;//收费项目名称
	@Column
	private Float unitPrice;//单价
	@Column
	private String feeUom;//单位
	@Column
	private Long feeQuantity;//数量
	@Column
	private String currencyType;//币种
	@Transient
	private String currencyTypeName;//币种名称
	@Column
	private String segmentFlag;//峰度
	@Column
	private Float lastRecord;//上次抄表数
	@Column
	private Float presentRecord;//本次抄表数
	@Column
	private Float grossAmount;//总额
	@Column
	private Float adjAmount;//折扣
	@Column
	private Float overduePayment;//违约金
	@Column
	private Float totalAmount;//应收合计
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date accruedDate;//计费初始日期
	@Transient
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date accruedDate2;
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date dateTo;//计费截止日期
	@Column
	private String remark;//备注
	@Column
	private String referenceNumber;//参考编号
	@Column
	private String dataSource;//数据来源
	@Column
	private Long companyId;//公司ID
	@Transient
	private String companyName;//公司名称
	@Column
	private String transType;//交易类型
	@Transient
	private String transTypeName;//交易类型名称
	@Column
	private String payPartRepair;//维修结算方
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date generateDate;//生成日期
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
	private Date countedDate;//计提日期
	@Transient
	private String beff;
	public Long getFeeListId() {
		return feeListId;
	}
	public void setFeeListId(Long feeListId) {
		this.feeListId = feeListId;
	}
	public String getFeeListCode() {
		return feeListCode;
	}
	public void setFeeListCode(String feeListCode) {
		this.feeListCode = feeListCode;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public String getFeeStatusName() {
		return feeStatusName;
	}
	public void setFeeStatusName(String feeStatusName) {
		this.feeStatusName = feeStatusName;
	}
	public Long getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyNumber() {
		return propertyNumber;
	}
	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}
	public String getFeePeriod() {
		return feePeriod;
	}
	public void setFeePeriod(String feePeriod) {
		this.feePeriod = feePeriod;
	}
	public Long getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(Long feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public String getFeeTypeName() {
		return feeTypeName;
	}
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	public Long getFeeId() {
		return feeId;
	}
	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getFeeUom() {
		return feeUom;
	}
	public void setFeeUom(String feeUom) {
		this.feeUom = feeUom;
	}
	public Long getFeeQuantity() {
		return feeQuantity;
	}
	public void setFeeQuantity(Long feeQuantity) {
		this.feeQuantity = feeQuantity;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getCurrencyTypeName() {
		return currencyTypeName;
	}
	public void setCurrencyTypeName(String currencyTypeName) {
		this.currencyTypeName = currencyTypeName;
	}
	public String getSegmentFlag() {
		return segmentFlag;
	}
	public void setSegmentFlag(String segmentFlag) {
		this.segmentFlag = segmentFlag;
	}
	public Float getLastRecord() {
		return lastRecord;
	}
	public void setLastRecord(Float lastRecord) {
		this.lastRecord = lastRecord;
	}
	public Float getPresentRecord() {
		return presentRecord;
	}
	public void setPresentRecord(Float presentRecord) {
		this.presentRecord = presentRecord;
	}
	public Float getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Float grossAmount) {
		this.grossAmount = grossAmount;
	}
	public Float getAdjAmount() {
		return adjAmount;
	}
	public void setAdjAmount(Float adjAmount) {
		this.adjAmount = adjAmount;
	}
	public Float getOverduePayment() {
		return overduePayment;
	}
	public void setOverduePayment(Float overduePayment) {
		this.overduePayment = overduePayment;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getAccruedDate() {
		return accruedDate;
	}
	public void setAccruedDate(Date accruedDate) {
		this.accruedDate = accruedDate;
	}
	public Date getAccruedDate2() {
		return accruedDate2;
	}
	public void setAccruedDate2(Date accruedDate2) {
		this.accruedDate2 = accruedDate2;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
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
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTransTypeName() {
		return transTypeName;
	}
	public void setTransTypeName(String transTypeName) {
		this.transTypeName = transTypeName;
	}
	public String getPayPartRepair() {
		return payPartRepair;
	}
	public void setPayPartRepair(String payPartRepair) {
		this.payPartRepair = payPartRepair;
	}
	public Date getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}
	public Date getCountedDate() {
		return countedDate;
	}
	public void setCountedDate(Date countedDate) {
		this.countedDate = countedDate;
	}
	public String getBeff() {
		return beff;
	}
	public void setBeff(String beff) {
		this.beff = beff;
	}
	
}
