package hpms.bs.dto;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigColumn
 * @description
 * @date 2017/3/2
 */
@Table(name="HPMS_CONFIG_COLUMN")
public class ConfigColumn extends BaseDTO {
    private static final long serialVersionUID = 2856108923186548186L;

   /* config_column_id      NUMBER not null,
    config_vaule_id       NUMBER not null,
    company_id            NUMBER not null,
    column_name           VARCHAR2(30) not null,
    column_name_alias     VARCHAR2(100),
    required_flag         VARCHAR2(1),
    enable_flag           VARCHAR2(1) default 'Y',
    column_type           VARCHAR2(30) not null,
    column_length         NUMBER not null,
    column_style          VARCHAR2(30) not null,*/

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long configColumnId;

    /**
     *配置值id
     */
    @Column
    private Long configVauleId;

    /**
     *公司id
     */
    @Column
    private Long  companyId;

    /**
     *字段名
     */
    @Column
    private String columnName;

    /**
     *字段别名
     */
    @Column
    private String columnNameAlias;

    /**
     *必输标识
     */
    @Column
    private String requiredFlag;

    /**
     *是否启用
     */
    @Column
    private String enableFlag;

    /**
     *字段类型
     */
    @Column
    private String columnType;

    /**
     *字段长度
     */
    @Column
    private String columnLength;

    /**
     *字段样式
     */
    @Column
    private String columnStyle;

    public Long getConfigColumnId() {
        return configColumnId;
    }

    public void setConfigColumnId(Long configColumnId) {
        this.configColumnId = configColumnId;
    }

    public Long getConfigVauleId() {
        return configVauleId;
    }

    public void setConfigVauleId(Long configVauleId) {
        this.configVauleId = configVauleId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameAlias() {
        return columnNameAlias;
    }

    public void setColumnNameAlias(String columnNameAlias) {
        this.columnNameAlias = columnNameAlias;
    }

    public String getRequiredFlag() {
        return requiredFlag;
    }

    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnStyle() {
        return columnStyle;
    }

    public void setColumnStyle(String columnStyle) {
        this.columnStyle = columnStyle;
    }
}
