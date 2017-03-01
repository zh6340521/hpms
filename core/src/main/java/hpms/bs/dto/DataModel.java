package hpms.bs.dto;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.annotation.Children;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModel
 * @description
 * @date 2017/2/28
 */
@Table(name = "HPMS_DATA_MODEL")
public class DataModel extends BaseDTO {

    /*model_id              NUMBER not null,
    model_code            VARCHAR2(30) not null,
    model_name            VARCHAR2(240) not null,
    table_name            VARCHAR2(30) not null,*/

    private static final long serialVersionUID = 2856108923186548186L;

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long  modelId;

    /**
     * 编码
     */
    @Column
    private String modelCode;

    /**
     * 模型名称
     */
    @Column
    private String modelName;

    /**
     * 数据表名
     */
    @Column
    private String tableName;

    @Transient
    @Children
    private List<DataModelCol> dataModelCol;


    public List<DataModelCol> getDataModelCol() {
        return dataModelCol;
    }

    public void setDataModelCol(List<DataModelCol> dataModelCol) {
        this.dataModelCol = dataModelCol;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
