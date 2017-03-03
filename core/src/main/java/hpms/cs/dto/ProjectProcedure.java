package hpms.cs.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 * @name hpms.cs.dto.ProjectProcedure
 * @description 项目手续材料 dto 类 ， 映射 HPMS_PROJECT_PROCEDURE 表
 */

@Table(name = "HPMS_PROJECT_PROCEDURE")
public class ProjectProcedure extends BaseDTO {

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue
    private Long projectProcedureId;

    /**
     *项目ID
     */
    private Long projectId;

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

    /**
     * 材料名称
     */
    @Transient
    private String procedureName;

    public void setProjectProcedureId(Long projectProcedureId) {
        this.projectProcedureId = projectProcedureId;
    }

    public Long getProjectProcedureId() {
        return projectProcedureId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
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

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}
