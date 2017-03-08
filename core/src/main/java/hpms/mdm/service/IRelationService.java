package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.Customer;
import hpms.mdm.dto.Fee;
import hpms.mdm.dto.Relation;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name IRelationService
 * @description：人员关系接口
 * @date 2017/2/27
 */
public interface IRelationService extends IBaseService<Relation>,ProxySelf<IRelationService>{
	//新增
	public void submitRelation(IRequest request,Relation Relation);
	
	//修改
	public void updateReation(IRequest request,Relation relation);
	//查询是否建立过关系
	public int queryByBpId(IRequest requestContext,Relation relation);
	//查询客户表的记录状态
	public int selectByCountIcmFlag(IRequest requestContext,int fromBpId);
}
