package hpms.bs.dto;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name Config
 * @description
 * @date 2017/3/1
 */
@Table(name="HPMS_CONFIG")
public class Config extends BaseDTO {

    private static final long serialVersionUID = 2856108923186548186L;

    /*config_id             NUMBER not null,
    config_number         VARCHAR2(50) not null,
    config_name           VARCHAR2(240) not null,
    company_id            NUMBER not null,
    model_id              NUMBER not null,
    column_name           VARCHAR2(30) not null,
    enable_flag           VARCHAR2(1) default 'Y',
    description           VARCHAR2(4000),*/

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long configId;

    /**
     * 配置表编码
     */
    @Column
    private String configNumber;

    /**
     * 配置表名称
     */
    @Column
    private String configName;

    /**
     * 公司id
     */
    @Column
    private Long companyId;

    /**
     * 模型名称
     */
    @Column
    private Long modelId;

    /**
     * 字段名
     */
    @Column
    private String  columnName;

    /**
     * 是否启用
     */
    @Column
    private String enableFlag;

    /**
     * 备注
     */
    @Column
    private String description;

    @Transient
    private String companyFullName;//公司名称

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getConfigNumber() {
        return configNumber;
    }

    public void setConfigNumber(String configNumber) {
        this.configNumber = configNumber;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
