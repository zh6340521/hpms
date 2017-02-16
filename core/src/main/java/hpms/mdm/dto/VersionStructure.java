package hpms.mdm.dto;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;

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

    public Long getParentStructureName() {
        return structureId;
    }

    public void setParentStructureName(String parentStructureName) {
        this.parentStructureName = parentStructureName;
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
}
