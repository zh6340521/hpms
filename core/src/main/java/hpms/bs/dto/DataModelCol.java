package hpms.bs.dto;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelCol
 * @description
 * @date 2017/2/28
 */
@Table(name = "HPMS_DATA_MODEL_COL")
public class DataModelCol extends BaseDTO{

    /*model_col_id          NUMBER not null,
    model_id              NUMBER not null,
    column_name           VARCHAR2(30) not null,
    column_type           VARCHAR2(30) not null,
    column_length         NUMBER not null,
    column_name_alias     VARCHAR2(100),*/

    private static final long serialVersionUID = 2856108923186548186L;

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long modelColId;

    /**
     * 头id
     */
    @Column
    private Long modelId;

    /**
     * 字段名
     */
    @Column
    private String  columnName;

    /**
     * 字段类型
     */
    @Column
    private String columnType;

    /**
     * 字段长度
     */
    @Column
    private Long columnLength;

    /**
     * 字段别名
     */
    @Column
    private String columnNameAlias;

    @Transient
    private String modelName; //模型名称

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getModelColId() {
        return modelColId;
    }

    public void setModelColId(Long modelColId) {
        this.modelColId = modelColId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Long getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(Long columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnNameAlias() {
        return columnNameAlias;
    }

    public void setColumnNameAlias(String columnNameAlias) {
        this.columnNameAlias = columnNameAlias;
    }
}
