package hpms.fin.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.fin.dto.Invoice;
import hpms.fin.dto.Payment;


/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name IPaymentService
 * @description：付款接口
 * @date 2017/3/21
 */
public interface IPaymentService extends IBaseService<Payment>,ProxySelf<IPaymentService>{
	/**
	 * 查询状态为应付和其他应付的应付发票
	 * @param invoice
	 * @return
	 */
	public List<Invoice> queryInvoice(Invoice invoice,IRequest requestContext,int page,int pagesize);
}
