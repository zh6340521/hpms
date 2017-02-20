package hpms.mdm.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hand.hap.system.dto.BaseDTO;
/**
 * 
 * @name ConfigValue
 * @description 
 * @author chengye.hu@hand-china.com	2017年2月20日上午10:50:17
 * @version
 */
@Table(name = "HPMS_MDM_CONFIG_VALUE")
public class ConfigValue extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long configValueId;
	@Column
	private Long configId;
	@Column
	private String configValueNumber;
	@Column
	private String configValueName;
	@Column
	private Long companyId;
	@Column
	private String enableFlag;
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
