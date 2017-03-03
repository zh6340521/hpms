package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.PaymentMethod;
import hpms.mdm.mapper.PaymentMethodMapper;
import hpms.mdm.service.IPaymentMethodService;
/**
 * 
 * @name PaymentMethodServiceImpl
 * @description 付款方式Impl
 * @author chengye.hu@hand-china.com	2017年2月23日下午2:09:55
 * @version 1.0
 */
@Service
public class PaymentMethodServiceImpl extends BaseServiceImpl<PaymentMethod> implements IPaymentMethodService{
	@Autowired
	private PaymentMethodMapper paymentMethodMapper;
	@Override
	public List<PaymentMethod> paymentMethodQuery(IRequest requestContext, PaymentMethod paymentMethod, int page,
			int pageSize) {
		PageHelper.startPage(page, pageSize);
		return paymentMethodMapper.paymentMethodQuery(paymentMethod);
	}

}
