package hpms.fin.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
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
	public List<Payment> queryInvoice(Payment payment,IRequest requestContext,int page,int pagesize);
	/**
	 * 查询收款单状态为已收款的应收应付
	 * @param invoice
	 * @return
	 */
	public List<Payment> queryCollection(Payment payment,IRequest requestContext,int page,int pagesize);
	
	
	/**
	 * 应付的付款按钮事件
	 * @param invoice
	 * @return
	 */
	public List<Payment> saveReceipt(List<Payment> payment,IRequest requestContext);
}
