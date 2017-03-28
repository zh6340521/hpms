package hpms.fin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.fin.dto.Invoice;
import hpms.fin.dto.Payment;
import hpms.fin.mapper.PaymentMapper;
import hpms.fin.service.IPaymentService;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name PaymentServiceImpl
 * @description:付款接口实现类
 * @date 2017/3/21
 */
@Service
@Transactional
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements IPaymentService{
	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public List<Payment> queryInvoice(Payment payment, IRequest requestContext, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return paymentMapper.queryInvoice(payment);
	}

	@Override
	public List<Payment> queryCollection(Payment payment, IRequest requestContext, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return paymentMapper.queryCollection(payment);
	}

	@Override
	public List<Payment> saveReceipt(List<Payment> payment, IRequest requestContext) {
		for (Payment payments : payment) {
			List<Invoice> invoices = payments.getInvoice();
			for (Invoice invoice : invoices) {
				invoice.getInvoiceId();
			}
		}
		
		return null;
	}
}
