package hpms.cs.dto;


import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 * @name hpms.cs.dto.Procedure
 * @description 手续材料 dto 类 ， 映射 HPMS_CONFIG_PROCEDURE 表
 */


@Table(name = "HPMS_CONFIG_PROCEDURE")
public class Procedure extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long configProcedureId;

    /**
     *材料类型（入伙为：OCC)
     */
    private String procedureType;

    /**
     *材料名称
     */
    @Condition(operator = LIKE)
    private String procedureName;

    /**
     *记录状态
     */
    private String enableFlag;

    public void setConfigProcedureId(Long configProcedureId) {
        this.configProcedureId = configProcedureId;
    }

    public Long getConfigProcedureId() {
        return configProcedureId;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

}
