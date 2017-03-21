package hpms.fin.dto;/**
 * Created by user1 on 2017/3/20.
 */

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
    private Long  msMount;

    /**
     * 费用日期
     */
    @Column
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

    public Long getMsMount() {
        return msMount;
    }

    public void setMsMount(Long msMount) {
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
