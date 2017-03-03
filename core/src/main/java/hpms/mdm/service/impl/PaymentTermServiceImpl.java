package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.PaymentTerm;
import hpms.mdm.mapper.PaymentTermMapper;
import hpms.mdm.service.IPaymentTermService;
/**
 * 
 * @name PaymentTermServiceImpl
 * @description 付款条件Impl
 * @author chengye.hu@hand-china.com	2017年2月23日下午4:43:46
 * @version 1.0
 */
@Service
public class PaymentTermServiceImpl extends BaseServiceImpl<PaymentTerm> implements IPaymentTermService{
	@Autowired
	private PaymentTermMapper paymentTermMapper;
	@Override
	public List<PaymentTerm> paymentTermQuery(IRequest requestContext, PaymentTerm paymentTerm, int page,
			int pageSize) {
		PageHelper.startPage(page, pageSize);
		return paymentTermMapper.paymentTermQuery(paymentTerm);
	}

}
