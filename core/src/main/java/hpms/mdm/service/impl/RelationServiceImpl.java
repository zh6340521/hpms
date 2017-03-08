package hpms.mdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.BpGeneral;
import hpms.mdm.dto.Relation;
import hpms.mdm.mapper.BpGeneralMapper;
import hpms.mdm.mapper.RelationMapper;
import hpms.mdm.service.IRelationService;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name RelationServiceImpl
 * @description:人员关系
 * @date 2017/2/27
 */
@Service
@Transactional
public class RelationServiceImpl extends BaseServiceImpl<Relation> implements IRelationService{
	@Autowired
	private RelationMapper relationMapper;
	@Autowired
	private BpGeneralMapper bpGeneralMapper;

	@Override
	public void submitRelation(IRequest request,Relation relation) {
		BpGeneral bpGeneral = relation.getBpGeneral();
		bpGeneralMapper.insertSelective(bpGeneral);
		relation.setToBpId(bpGeneral.getBpId());
		relationMapper.insertSelective(relation);
	}
	
	
	public void updateReation(IRequest request,Relation relation){
		BpGeneral bpGeneral = relation.getBpGeneral();
		bpGeneralMapper.updateByPrimaryKeySelective(bpGeneral);
		relationMapper.updateByPrimaryKeySelective(relation);
	}


	@Override
	public int queryByBpId(IRequest requestContext, Relation relation) {
		return relationMapper.queryByBpId(relation);
	}


	@Override
	public int selectByCountIcmFlag(IRequest requestContext,int fromBpId) {
		return relationMapper.selectByCountIcmFlag(fromBpId);
	}

}
