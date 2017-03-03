package hpms.cs.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.dto.OccProcedure
 * @description 入伙手续材料关联 dto 类 ， 映射 HPMS_CS_OCC_PROCEDURE 表
 */

@Table(name = "HPMS_CS_OCC_PROCEDURE")
public class OccProcedure extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long occProcedureId;

    /**
     *入伙ID
     */
    private Long occupationId;

    /**
     *材料类型（入伙为：OCC)
     */
    private String procedureType;

    /**
     *手续材料ID
     */
    private Long configProcedureId;

    /**
     *记录状态
     */
    private String enableFlag;

    public void setOccProcedureId(Long occProcedureId) {
        this.occProcedureId = occProcedureId;
    }

    public Long getOccProcedureId() {
        return occProcedureId;
    }

    public void setOccupationId(Long occupationId) {
        this.occupationId = occupationId;
    }

    public Long getOccupationId() {
        return occupationId;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setConfigProcedureId(Long configProcedureId) {
        this.configProcedureId = configProcedureId;
    }

    public Long getConfigProcedureId() {
        return configProcedureId;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

}
