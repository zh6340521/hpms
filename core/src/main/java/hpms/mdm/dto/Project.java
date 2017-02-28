package hpms.mdm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 *
 * @name Project
 * @description 项目档案 DTO
 * @author jun.zhao02@hand-china.com    2017/2/15 10:20:00
 * @version 1.0
 */
@ExtensionAttribute(disable=true)
@Table(name = "HPMS_MDM_PROJECT")
public class Project extends BaseDTO {
     @Id
     @GeneratedValue
      private Long projectId;//项目档案ID

      private String projectCode;//项目档案编码

      private String projectName;//项目档案名称

      private Long groupId;//集团ID

      private Long companyId;//公司ID

      private String projectContact;//项目联系人

      private String contactPhone;//联系人电话

      private String projectAddress;//项目地址

      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
      private Date startDateActive;//有效期起

      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
      private Date endDateActive;//有效期止

      private String enableFlag;//状态

      private Long programId;

      private Long requestId;

      @Transient
      private String groupName;//集团名称
      @Transient
      private String companyName;//公司名称


     public void setProjectId(Long projectId){
         this.projectId = projectId;
     }

     public Long getProjectId(){
         return projectId;
     }

     public void setProjectCode(String projectCode){
         this.projectCode = projectCode;
     }

     public String getProjectCode(){
         return projectCode;
     }

     public void setProjectName(String projectName){
         this.projectName = projectName;
     }

     public String getProjectName(){
         return projectName;
     }

     public void setGroupId(Long groupId){
         this.groupId = groupId;
     }

     public Long getGroupId(){
         return groupId;
     }

     public String getGroupName() {
        return groupName;
     }

     public void setGroupName(String groupName) {
        this.groupName = groupName;
     }

     public void setCompanyId(Long companyId){
         this.companyId = companyId;
     }

     public Long getCompanyId(){
         return companyId;
     }

     public String getCompanyName() {
        return companyName;
    }

     public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

     public void setProjectContact(String projectContact){
         this.projectContact = projectContact;
     }

     public String getProjectContact(){
         return projectContact;
     }

     public void setContactPhone(String contactPhone){
         this.contactPhone = contactPhone;
     }

     public String getContactPhone(){
         return contactPhone;
     }

     public void setProjectAddress(String projectAddress){
         this.projectAddress = projectAddress;
     }

     public String getProjectAddress(){
         return projectAddress;
     }

     public void setStartDateActive(Date startDateActive){
         this.startDateActive = startDateActive;
     }

     public Date getStartDateActive(){
         return startDateActive;
     }

     public void setEndDateActive(Date endDateActive){
         this.endDateActive = endDateActive;
     }

     public Date getEndDateActive(){
         return endDateActive;
     }

     public void setEnableFlag(String enableFlag){
         this.enableFlag = enableFlag;
     }

     public String getEnableFlag(){
         return enableFlag;
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

     }
