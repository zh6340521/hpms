package hpms.mdm.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/02/20
 * @version 1.0
 * @name hpms.mdm.dto.CalculateElement
 * @description 计算要素 dto 类 ， 映射 HPMS_MDM_CALCULATE_ELEMENT 表
 */

@Table(name = "HPMS_MDM_CALCULATE_ELEMENT")
public class CalculateElement extends BaseDTO {
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long calculateElementId;

    /**
     * 编码
     */
    private String elementCode;

    /**
     * 计算要素名称
     */
    private String elementName;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 描述
     */
    private String description;

    /**
     * 记录状态
     */
    private String enableFlag;


    public void setCalculateElementId(Long calculateElementId) {
        this.calculateElementId = calculateElementId;
    }

    public Long getCalculateElementId() {
        return calculateElementId;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

}
