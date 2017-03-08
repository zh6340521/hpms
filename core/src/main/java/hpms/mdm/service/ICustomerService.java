package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.Customer;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name ICustomerService
 * @description：客户档案接口
 * @date 2017/2/27
 */
public interface ICustomerService extends IBaseService<Customer>,ProxySelf<ICustomerService>{
	
	
	/**
	 * 根据选择的列名,对该列名的内容进行模糊查询
	 * @param name
	 * @param value
	 * @param requestContext
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<Customer> selectByColumnName(String value,String selectCombox, IRequest requestContext,int page,int pagesize);
	
	/**
	 * 修改记录状态
	 * @param id
	 * @return 
	 */
	public String queryByEnableFlag(Long customerId);
    
}
