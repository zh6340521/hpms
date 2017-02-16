package hpms.mdm.dto;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersion
 * @description:建筑版本实体类
 * @date 2017/2/15
 */
@Table(name = "HPMS_MDM_BUILDING_VERSION")
public class BuildingVersion extends BaseDTO{

    private static final long serialVersionUID = 2856108923186548186L;

    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long  versionId;

    /**
     * 版本编码
     */
    @Column
    private String  versionNumber;

    /**
     *版本名称
     */
    @Column
    private String  versionName;

    /**
     *项目id
     */
    @Column
    private Long  projectId;

    /**
     *版本描述
     */
    @Column
    private String  versionDescription;

    /**
     *默认版本
     */
    @Column
    private Long   defaultVersion;

    /**
     *记录状态
     */
    @Column
    private String  enableFlag;

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public Long getDefaultVersion() {
        return defaultVersion;
    }

    public void setDefaultVersion(Long defaultVersion) {
        this.defaultVersion = defaultVersion;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }
}
