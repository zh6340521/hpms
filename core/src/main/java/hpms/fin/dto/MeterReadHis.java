package hpms.fin.dto;

import javax.persistence.*;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;
import java.util.Date;

@ExtensionAttribute(disable=true)
@Table(name = "HPMS_FIN_METER_READ_HIS")
public class MeterReadHis extends BaseDTO {
     @Id
     @Column
     @GeneratedValue
      private Long readHisId;
     @Column
      private Long companyId;
     @Column
      private Long projectId;
     @Column
      private Long equipmentId;
     @Column
      private String invoiceCode;
     @Column
      private Float lastRead;
     @Column
      private Float currentRead;
     @Column
      private Float meterTotalUse;
     @Column
      private Float meterTotalAmount;
     @Column
      private Date readDate;
     @Column
      private String flag;
     @Column
      private String newRecordFlag;
     @Column
      private String isPostedFlag;
     @Column
      private String status;
     @Column
      private Long programId;
     @Column
      private Long requestId;
     @Transient
      private String companyFullName;
     @Transient
      private String projectName;
     @Transient
      private String equipmentName;
     @Transient
      private String statusDesc;
     @Transient
      private Long equipmentTypeId;
     @Transient
      private String year;
     @Transient
      private String month;


     public void setReadHisId(Long readHisId){
         this.readHisId = readHisId;
     }

     public Long getReadHisId(){
         return readHisId;
     }

     public void setCompanyId(Long companyId){
         this.companyId = companyId;
     }

     public Long getCompanyId(){
         return companyId;
     }

     public void setProjectId(Long projectId){
         this.projectId = projectId;
     }

     public Long getProjectId(){
         return projectId;
     }

     public void setEquipmentId(Long equipmentId){
         this.equipmentId = equipmentId;
     }

     public Long getEquipmentId(){
         return equipmentId;
     }

     public void setInvoiceCode(String invoiceCode){
         this.invoiceCode = invoiceCode;
     }

     public String getInvoiceCode(){
         return invoiceCode;
     }

     public void setLastRead(Float lastRead){
         this.lastRead = lastRead;
     }

     public Float getLastRead(){
         return lastRead;
     }

     public void setCurrentRead(Float currentRead){
         this.currentRead = currentRead;
     }

     public Float getCurrentRead(){
         return currentRead;
     }

     public void setMeterTotalUse(Float meterTotalUse){
         this.meterTotalUse = meterTotalUse;
     }

     public Float getMeterTotalUse(){
         return meterTotalUse;
     }

     public void setMeterTotalAmount(Float meterTotalAmount){
         this.meterTotalAmount = meterTotalAmount;
     }

     public Float getMeterTotalAmount(){
         return meterTotalAmount;
     }

     public void setReadDate(Date readDate){
         this.readDate = readDate;
     }

     public Date getReadDate(){
         return readDate;
     }

     public void setFlag(String flag){
         this.flag = flag;
     }

     public String getFlag(){
         return flag;
     }

     public void setNewRecordFlag(String newRecordFlag){
         this.newRecordFlag = newRecordFlag;
     }

     public String getNewRecordFlag(){
         return newRecordFlag;
     }

     public void setIsPostedFlag(String isPostedFlag){
         this.isPostedFlag = isPostedFlag;
     }

     public String getIsPostedFlag(){
         return isPostedFlag;
     }

     public void setStatus(String status){
         this.status = status;
     }

     public String getStatus(){
         return status;
     }

     public void setProgramId(Long programId){
         this.programId = programId;
     }

     public Long getProgramId(){
         return programId;
     }

     public void setRequestId(Long requestId){
         this.requestId = requestId;
     }

     public Long getRequestId(){
         return requestId;
     }

     public void setCompanyFullName(String companyFullName){
        this.companyFullName = companyFullName;
    }

     public String getCompanyFullName(){
        return companyFullName;
    }

     public void setProjectName(String projectName){
        this.projectName = projectName;
    }

     public String getProjectName(){
        return projectName;
    }

     public void setEquipmentName(String equipmentName){
        this.equipmentName = equipmentName;
    }

     public String getEquipmentName(){
        return equipmentName;
    }

     public void setStatusDesc(String statusDesc){
        this.statusDesc = statusDesc;
    }

     public String getStatusDesc(){
        return statusDesc;
    }

     public void setEquipmentTypeId(Long equipmentTypeId){
        this.equipmentTypeId = equipmentTypeId;
    }

     public Long getEquipmentTypeId(){
        return equipmentTypeId;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getYear(){
        return year;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public String getMonth(){
        return month;
    }

     }
