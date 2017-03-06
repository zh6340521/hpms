package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.BpGeneral;
import hpms.mdm.dto.Customer;

public interface IBpGeneralService extends IBaseService<BpGeneral>,ProxySelf<IBpGeneralService>{
	
	public void submitBpGeneral(IRequest request,Customer customer);
	
	/**
	 * 根据id查询客户表以及一般信息表
	 * 
	 * @param name
	 * @param value
	 * @param requestContext
	 * @param page
	 * @param pagesize
	 * @return
	 */

	public List<BpGeneral> selectByCustomerId(BpGeneral bpGeneral,IRequest requestContext);
	
	
	
	/**
	 * 按条件查询一般信息表
	 * @param bpGeneral
	 * @return
	 */
	public List<BpGeneral> queryBpgeneral(BpGeneral bpGeneral,IRequest requestContext);
	
	
	
	/**
	 * 根据id查询人员关系
	 * @param bpGeneral
	 * @return
	 */
	public List<BpGeneral> selectByRetaion(BpGeneral bpGeneral,IRequest requestContext,int page,int pagesize);
}
