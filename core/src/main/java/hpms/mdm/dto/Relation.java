package hpms.mdm.dto;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;

/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name Relation
 * @description:人员关系实体类
 * @date 2017/2/24
 * 
 */
@ExtensionAttribute(disable = true)
@Table(name = "HPMS_MDM_RELATION")
public class Relation extends BaseDTO{
	
	
	/**
	 * 表ID，主键，供其他表做外键
	 */
	@Id
    @Column
    @GeneratedValue(generator = GENERATOR_TYPE)
	private Long relationId;
	
	/*
	 * 关系人1的bpid
	 */
	@Column
	private Long fromBpId;
	
	/*
	 * 关系人2的bpid
	 */
	@Column
	private Long toBpId;
	
	/**
	 * 关系类型
	 */
	@Column
	private String relType;
	
	/**
	 * 是否紧急联系人
	 */
	@Column
	private Long icmFlag;
	
	/**
	 * 是否紧急联系人
	 */
	@Column
	private String enableFlag;
	
	
	@Column
    private Long programId;
    
    
    @Column
    private Long requestId;
    
    @Transient
    private BpGeneral bpGeneral;
    public BpGeneral getBpGeneral() {
		return bpGeneral;
	}


	public void setBpGeneral(BpGeneral bpGeneral) {
		this.bpGeneral = bpGeneral;
	}

	@Transient
	public Long bpId;

	/**
     * 行版本号,用来处理锁
     */
    @Column
    private Long objectVersionNumber;


	public Long getRelationId() {
		return relationId;
	}


	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}


	public Long getFromBpId() {
		return fromBpId;
	}


	public void setFromBpId(Long fromBpId) {
		this.fromBpId = fromBpId;
	}


	public Long getToBpId() {
		return toBpId;
	}


	public void setToBpId(Long toBpId) {
		this.toBpId = toBpId;
	}


	public String getRelType() {
		return relType;
	}


	public void setRelType(String relType) {
		this.relType = relType;
	}


	public Long getIcmFlag() {
		return icmFlag;
	}


	public void setIcmFlag(Long icmFlag) {
		this.icmFlag = icmFlag;
	}


	public String getEnableFlag() {
		return enableFlag;
	}


	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}


	public Long getProgramId() {
		return programId;
	}


	public void setProgramId(Long programId) {
		this.programId = programId;
	}


	public Long getRequestId() {
		return requestId;
	}


	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}


	public Long getObjectVersionNumber() {
		return objectVersionNumber;
	}


	public void setObjectVersionNumber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}
    
    
    
}
