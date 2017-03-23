package hpms.fin.dto;/**
 * Created by user1 on 2017/3/20.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name MeterShareResult:公表分摊结果dto
 * @description
 * @date 2017/3/20
 */
@Table(name="HPMS_FIN_METER_SHARE_RESULT")
public class MeterShareResult extends BaseDTO {

    /*share_result_id       NUMBER not null,
    company_id            NUMBER not null,
    project_id            NUMBER not null,
    equipment_id          NUMBER not null,
    property_id           NUMBER not null,
    ms_date               DATE,
    ms_person             VARCHAR2(240),
    invoice_code          VARCHAR2(100),
    ms_mount              NUMBER,
    callable_date         DATE,
    status                VARCHAR2(30),*/

    private static final long serialVersionUID = 2856108923186548186L;

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long   shareResultId;

    /**
     * 公司id
     */
    @Column
    private Long companyId;

    /**
     * 项目id
     */
    @Column
    private Long  projectId;

    /**
     * 设备id
     */
    @Column
    private Long  equipmentId;

    /**
     * 建筑实体id
     */
    @Column
    private Long  propertyId;

    /**
     * 分摊日期
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  msDate;

    /**
     * 分摊人
     */
    @Column
    private String  msPerson;

    /**
     * 发票号
     */
    @Column
    private String  invoiceCode;

    /**
     * 分摊金额
     */
    @Column
    private Float  msMount;

    /**
     * 费用日期
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   callableDate;

    /**
     * 状态
     */
    @Column
    private String status;

    @Transient
    private String year; //当前年份
    @Transient
    private String Month;//月份
    @Transient
    private String startMonth;//开始月份
    @Transient
    private String endMonth;//结束月份

    @Transient
    private String companyName;//公司名称
    @Transient
    private String projectName;//项目名称
    @Transient
    private String equipmentCode;//设备编号
    @Transient
    private String equipmentName;//设备名称
    @Transient
    private String statusMeanings;//状态
    @Transient
    private Long equipmentTypeId;  //设备类型id
    @Transient
    private String propertyName;//建筑名称
    @Transient
    private String customerName;//业主

    @Transient
    private String formatCallableDate;
    @Transient
    private String formatMsDate;

    @Transient
    private String  shareRule;//分摊规则



    public String getShareRule() {
        return shareRule;
    }

    public void setShareRule(String shareRule) {
        this.shareRule = shareRule;
    }

    public String getFormatCallableDate() {
        return formatCallableDate;
    }

    public void setFormatCallableDate(String formatCallableDate) {
        this.formatCallableDate = formatCallableDate;
    }

    public String getFormatMsDate() {
        return formatMsDate;
    }

    public void setFormatMsDate(String formatMsDate) {
        this.formatMsDate = formatMsDate;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
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

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getStatusMeanings() {
        return statusMeanings;
    }

    public void setStatusMeanings(String statusMeanings) {
        this.statusMeanings = statusMeanings;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getShareResultId() {
        return shareResultId;
    }

    public void setShareResultId(Long shareResultId) {
        this.shareResultId = shareResultId;
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

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Date getMsDate() {
        return msDate;
    }

    public void setMsDate(Date msDate) {
        this.msDate = msDate;
    }

    public String getMsPerson() {
        return msPerson;
    }

    public void setMsPerson(String msPerson) {
        this.msPerson = msPerson;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Float getMsMount() {
        return msMount;
    }

    public void setMsMount(Float msMount) {
        this.msMount = msMount;
    }

    public Date getCallableDate() {
        return callableDate;
    }

    public void setCallableDate(Date callableDate) {
        this.callableDate = callableDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
