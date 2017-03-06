package hpms.mdm.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.BpGeneral;
import hpms.mdm.dto.Customer;
import hpms.mdm.mapper.BpGeneralMapper;
import hpms.mdm.mapper.CustomerMapper;
import hpms.mdm.service.IBpGeneralService;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name BpGeneralServiceImpl
 * @description:一般信息
 * @date 2017/2/22
 */
@Service
@Transactional
public class BpGeneralServiceImpl extends BaseServiceImpl<BpGeneral> implements IBpGeneralService{
	
	@Autowired
	private BpGeneralMapper bpGeneralMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public void submitBpGeneral(IRequest request,Customer customer){
		BpGeneral bpGeneral = customer.getBpGeneral();
		bpGeneralMapper.insertSelective(bpGeneral);
		customer.setBpId(bpGeneral.getBpId());
		Long customerNumber = customerMapper.selectByMaxCustomerNumber();
		//判断客户编号
		if ("null".equals(String.valueOf(customerNumber)) || "0".equals(String.valueOf(customerNumber))) {
			customer.setCustomerNumber("1000000001");
		}else{
			customer.setCustomerNumber(String.valueOf(customerMapper.selectByMaxCustomerNumber()+1));
		}
		customerMapper.insertSelective(customer);
	}


	@Override
	public List<BpGeneral> selectByCustomerId(BpGeneral bpGeneral,IRequest requestContext) {
		return bpGeneralMapper.selectByCustomerId(bpGeneral);
	}


	@Override
	public List<BpGeneral> queryBpgeneral(BpGeneral bpGeneral, IRequest requestContext) {
		return bpGeneralMapper.queryBpgeneral(bpGeneral);
	}


	@Override
	public List<BpGeneral> selectByRetaion(BpGeneral bpGeneral, IRequest requestContext,int page,int pagesize) {
		PageHelper.startPage(page, pagesize);
		return bpGeneralMapper.selectByRetaion(bpGeneral);
	}

}
