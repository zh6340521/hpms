package hpms.bs.dto;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.annotation.Children;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.*;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigValue
 * @description
 * @date 2017/3/1
 */
@Table(name="HPMS_CONFIG_VALUE")
public class ConfigValue extends BaseDTO {

    private static final long serialVersionUID = 2856108923186548186L;

   /* config_value_id       NUMBER not null,
    config_id             NUMBER not null,
    config_value_number   VARCHAR2(50) not null,
    config_value_name     VARCHAR2(240),
    company_id            NUMBER not null,
    enable_flag           VARCHAR2(1) default 'Y',*/

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long  configValueId;

    /**
     * 配置表id
     */
    @Column
    private Long configId;

    /**
     * 配置值编码
     */
    @Column
    private String configValueNumber;

    /**
     * 配置值名称
     */
    @Column
    private String configValueName;

    /**
     * 公司id
     */
    @Column
    private Long companyId;

    /**
     * 记录状态
     */
    @Column
    private String enableFlag;

    @Transient
    @Children
    private List<ConfigColumn> configColumnList;

    public List<ConfigColumn> getConfigColumnList() {
        return configColumnList;
    }

    public void setConfigColumnList(List<ConfigColumn> configColumnList) {
        this.configColumnList = configColumnList;
    }

    public Long getConfigValueId() {
        return configValueId;
    }

    public void setConfigValueId(Long configValueId) {
        this.configValueId = configValueId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getConfigValueNumber() {
        return configValueNumber;
    }

    public void setConfigValueNumber(String configValueNumber) {
        this.configValueNumber = configValueNumber;
    }

    public String getConfigValueName() {
        return configValueName;
    }

    public void setConfigValueName(String configValueName) {
        this.configValueName = configValueName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }
}
