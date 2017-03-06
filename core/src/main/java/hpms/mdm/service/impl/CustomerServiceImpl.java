package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.Customer;
import hpms.mdm.mapper.CustomerMapper;
import hpms.mdm.service.ICustomerService;

@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	
	
	
	
	public List<Customer> selectByColumnName(String value,String selectCombox, IRequest requestContext,int page,int pagesize){
		PageHelper.startPage(page, pagesize);
		Customer cs = new Customer();
		if ("客户编号".equals(selectCombox)) {
			cs.setCustomerNumber(value);
		}else if("客户名称".equals(selectCombox)){
			cs.setFullName(value);
		}else if("手机号".equals(selectCombox)){
			cs.setContactMobile(value);
		}else if("证件号码".equals(selectCombox)){
			cs.setCredentialNumber(value);
		}
		return customerMapper.selectByColumnName(cs);
	}




	@Override
	public void updateByEnableFlag(IRequest requestContext,Customer customer) {
		customerMapper.updateByEnableFlag(customer);
	}

 

}
