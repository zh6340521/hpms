package hpms.mdm.dto;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name VersionStructure
 * @description:版本结构dto
 * @date 2017/2/15
 */
@Table(name = "HPMS_MDM_VERSION_STRUCTURE")
public class VersionStructure extends BaseDTO {
    private static final long serialVersionUID = 2776430709705510697L;

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long structureId;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getConfigValueName() {
		return configValueName;
	}

	public void setConfigValueName(String configValueName) {
		this.configValueName = configValueName;
	}

	/**
     * 版本id
     */
    @Column
    private Long versionId;

    /**
     * 结构编码
     */
    @Column
    private String   structureNumber;

    /**
     * 结构名称
     */
    @Column
    private String   structureName;

    /**
     *绑定建筑实体id
     */
    @Column
    private Long  propertyId;

    /**
     *业态
     */
    @Column
    private String  businessFormat;

    /**
     *结构描述
     */
    @Column
    private String  structureDescription;

    /**
     *父结构id
     */
    @Column
    private Long   parentStructureId;

    /**
     * 父结构名称
     */
    @Transient
    private String parentStructureName;
    @Transient
    private String propertyName;//建筑实体
    @Transient
    private List<VersionStructure> items;//huchengye
    
    @Transient
    private boolean hasChildren;//huchengye

    @Transient
    private String businessFormatMeaning;//建筑实体名称




    @Transient
    private Long companyId;//公司id
    @Transient
    private Long projectId;//项目id
    @Transient
    private String customerName;//客户名称
    @Transient
    private String configValueName;//建筑类型
    @Transient
    private String status;//入伙状态
    @Transient
    private Long occupationId;//入伙表id


    public String getBusinessFormatMeaning() {
        return businessFormatMeaning;
    }

    public void setBusinessFormatMeaning(String businessFormatMeaning) {
        this.businessFormatMeaning = businessFormatMeaning;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Long occupationId) {
        this.occupationId = occupationId;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getStructureId() {
        return structureId;
    }

    public void setStructureId(Long structureId) {
        this.structureId = structureId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getStructureNumber() {
        return structureNumber;
    }

    public void setStructureNumber(String structureNumber) {
        this.structureNumber = structureNumber;
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getBusinessFormat() {
        return businessFormat;
    }

    public void setBusinessFormat(String businessFormat) {
        this.businessFormat = businessFormat;
    }

    public String getStructureDescription() {
        return structureDescription;
    }

    public void setStructureDescription(String structureDescription) {
        this.structureDescription = structureDescription;
    }

    public Long getParentStructureId() {
        return parentStructureId;
    }

    public void setParentStructureId(Long parentStructureId) {
        this.parentStructureId = parentStructureId;
    }

    public String getParentStructureName() {
        return parentStructureName;
    }

    public void setParentStructureName(String parentStructureName) {
        this.parentStructureName = parentStructureName;
    }

	public List<VersionStructure> getItems() {
		return items;
	}

	public void setItems(List<VersionStructure> items) {
		this.items = items;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
    
}
