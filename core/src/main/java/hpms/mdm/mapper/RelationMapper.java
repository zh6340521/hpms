package hpms.mdm.mapper;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.Relation;

public interface RelationMapper extends Mapper<Relation>{
	
	/**
	 * 查询是否存在紧急联系人
	 * @return
	 */
	public Long selectByCountIcmFlag();
	
	/**
	 * 查询是否建立过关系
	 * @return
	 */
	public int queryByBpId(Relation relation);
	

}
