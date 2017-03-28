package hpms.fin.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.Payment;
/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name PaymentMapper
 * @description:付款Mapper
 * @date 2017/3/21
 * 
 */
public interface PaymentMapper extends Mapper<Payment>{
	/**
	 * 查询状态为应付和其他应付的应付发票
	 * @param invoice
	 * @return
	 */
	public List<Payment> queryInvoice(Payment payment);
	
	
	/**
	 * 查询收款单状态为已收款的应收应付
	 * @param invoice
	 * @return
	 */
	public List<Payment> queryCollection(Payment payment);
	
	/**
	 * 应付的付款按钮事件
	 * @param invoice
	 * @return
	 */
	public List<Payment> saveReceipt(List<Payment> payment);
}
