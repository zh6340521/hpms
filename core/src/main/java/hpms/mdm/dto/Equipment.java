package hpms.mdm.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;

import javax.persistence.Column;
import javax.persistence.Table;

import com.hand.hap.system.dto.BaseDTO;

import java.util.Date;

@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_EQUIPMENT")
public class Equipment extends BaseDTO {
    @Id
    @Column
    @GeneratedValue
    private Long equipmentId;

    @Column
    private Long equipmentTypeId;
    @Column
    private String equipmentCode;
    @Column
    private String equipmentName;
    @Column
    private String equipmentBarcode;
    @Column
    private String equipmentSerial;
    @Column
    private String assetsNumber;
    @Column
    private String equipmentUom;
    @Column
    private String doorNo;
    @Column
    private Long companyId;
    @Column
    private Long projectId;
    @Column
    private Long orgId;
    @Column
    private String equipmentSignificance;
    @Column
    private String equipmentStatus;
    @Column
    private Date purchasingDate;
    @Column
    private String equipmentSupplier;
    @Column
    private String equipmentManufacture;
    @Column
    private String equipmentModel;
    @Column
    private Date productionDate;
    @Column
    private String factoryNumber;
    @Column
    private Date installDate;
    @Column
    private Date useDate;
    @Column
    private String maintenanceType;
    @Column
    private Long durableYear;
    @Column
    private Date guaranteeDate;
    @Column
    private Long indicativePrice;
    @Column
    private String equipmentAttachment;
    @Column
    private String equipmentPicture;
    @Column
    private String technicalParameter;
    @Column
    private Long parentEquipmentId;
    @Column
    private Long versionId;
    @Column
    private String equipmentPictureFileName;
    @Column
    private String equipmentPictureContentType;
    @Column
    private Long equipmentPictureFileSize;
    @Column
    private Date equipmentPictureUpdatedAt;
    @Column
    private Long changeEquipmentId;
    @Column
    private String changeReason;
    @Column
    private Long programId;
    @Column
    private Long requestId;

    @Transient
    private String typeName;
    @Transient
    private String companyFullName;
    @Transient
    private String projectName;
    @Transient
    private String parentEquipmentName;
    @Transient
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentEquipmentName() {
        return parentEquipmentName;
    }

    public void setParentEquipmentName(String parentEquipmentName) {
        this.parentEquipmentName = parentEquipmentName;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
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

    @Transient
    private String meaning1;
    @Transient
    private String meaning2;

    public String getMeaning1() {
        return meaning1;
    }

    public void setMeaning1(String meaning1) {
        this.meaning1 = meaning1;
    }

    public String getMeaning2() {
        return meaning2;
    }

    public void setMeaning2(String meaning2) {
        this.meaning2 = meaning2;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentBarcode(String equipmentBarcode) {
        this.equipmentBarcode = equipmentBarcode;
    }

    public String getEquipmentBarcode() {
        return equipmentBarcode;
    }

    public void setEquipmentSerial(String equipmentSerial) {
        this.equipmentSerial = equipmentSerial;
    }

    public String getEquipmentSerial() {
        return equipmentSerial;
    }

    public void setAssetsNumber(String assetsNumber) {
        this.assetsNumber = assetsNumber;
    }

    public String getAssetsNumber() {
        return assetsNumber;
    }

    public void setEquipmentUom(String equipmentUom) {
        this.equipmentUom = equipmentUom;
    }

    public String getEquipmentUom() {
        return equipmentUom;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getDoorNo() {
        return doorNo;
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

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setEquipmentSignificance(String equipmentSignificance) {
        this.equipmentSignificance = equipmentSignificance;
    }

    public String getEquipmentSignificance() {
        return equipmentSignificance;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setPurchasingDate(Date purchasingDate) {
        this.purchasingDate = purchasingDate;
    }

    public Date getPurchasingDate() {
        return purchasingDate;
    }

    public void setEquipmentSupplier(String equipmentSupplier) {
        this.equipmentSupplier = equipmentSupplier;
    }

    public String getEquipmentSupplier() {
        return equipmentSupplier;
    }

    public void setEquipmentManufacture(String equipmentManufacture) {
        this.equipmentManufacture = equipmentManufacture;
    }

    public String getEquipmentManufacture() {
        return equipmentManufacture;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setDurableYear(Long durableYear) {
        this.durableYear = durableYear;
    }

    public Long getDurableYear() {
        return durableYear;
    }

    public void setGuaranteeDate(Date guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    public Date getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setIndicativePrice(Long indicativePrice) {
        this.indicativePrice = indicativePrice;
    }

    public Long getIndicativePrice() {
        return indicativePrice;
    }

    public void setEquipmentAttachment(String equipmentAttachment) {
        this.equipmentAttachment = equipmentAttachment;
    }

    public String getEquipmentAttachment() {
        return equipmentAttachment;
    }

    public void setEquipmentPicture(String equipmentPicture) {
        this.equipmentPicture = equipmentPicture;
    }

    public String getEquipmentPicture() {
        return equipmentPicture;
    }

    public void setTechnicalParameter(String technicalParameter) {
        this.technicalParameter = technicalParameter;
    }

    public String getTechnicalParameter() {
        return technicalParameter;
    }

    public void setParentEquipmentId(Long parentEquipmentId) {
        this.parentEquipmentId = parentEquipmentId;
    }

    public Long getParentEquipmentId() {
        return parentEquipmentId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setEquipmentPictureFileName(String equipmentPictureFileName) {
        this.equipmentPictureFileName = equipmentPictureFileName;
    }

    public String getEquipmentPictureFileName() {
        return equipmentPictureFileName;
    }

    public void setEquipmentPictureContentType(String equipmentPictureContentType) {
        this.equipmentPictureContentType = equipmentPictureContentType;
    }

    public String getEquipmentPictureContentType() {
        return equipmentPictureContentType;
    }

    public void setEquipmentPictureFileSize(Long equipmentPictureFileSize) {
        this.equipmentPictureFileSize = equipmentPictureFileSize;
    }

    public Long getEquipmentPictureFileSize() {
        return equipmentPictureFileSize;
    }

    public void setEquipmentPictureUpdatedAt(Date equipmentPictureUpdatedAt) {
        this.equipmentPictureUpdatedAt = equipmentPictureUpdatedAt;
    }

    public Date getEquipmentPictureUpdatedAt() {
        return equipmentPictureUpdatedAt;
    }

    public void setChangeEquipmentId(Long changeEquipmentId) {
        this.changeEquipmentId = changeEquipmentId;
    }

    public Long getChangeEquipmentId() {
        return changeEquipmentId;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getChangeReason() {
        return changeReason;
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
