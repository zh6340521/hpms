package hpms.mdm.dto;

/**
 * Auto Generated By Hap Code Generator
 **/

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.hand.hap.system.dto.BaseDTO;

@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_STORE_HOUSE")
public class StoreHouse extends BaseDTO {
    @Id
    @GeneratedValue
    private Long storeHouseId;

    private Long companyId;

    private Long projectId;

    private String storeHouseCode;

    private String storeHouseName;

    private String type;

    private String address;

    private String enableFlag;

    private Long programId;

    private Long requestId;
    @Transient
    private String companyFullName;
    @Transient
    private String projectName;
    @Transient
    private String meaning;

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

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setStoreHouseId(Long storeHouseId) {
        this.storeHouseId = storeHouseId;
    }

    public Long getStoreHouseId() {
        return storeHouseId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setStoreHouseCode(String storeHouseCode) {
        this.storeHouseCode = storeHouseCode;
    }

    public String getStoreHouseCode() {
        return storeHouseCode;
    }

    public void setStoreHouseName(String storeHouseName) {
        this.storeHouseName = storeHouseName;
    }

    public String getStoreHouseName() {
        return storeHouseName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getRequestId() {
        return requestId;
    }

}
