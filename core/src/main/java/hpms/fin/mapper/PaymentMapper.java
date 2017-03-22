package hpms.fin.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.fin.dto.Invoice;
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
	public List<Invoice> queryInvoice(Invoice invoice);
}
