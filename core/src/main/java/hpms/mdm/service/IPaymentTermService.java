package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.PaymentTerm;

/**
 * 
 * @name IPaymentTermService
 * @description 付款条件Service
 * @author chengye.hu@hand-china.com	2017年2月23日下午4:41:36
 * @version 1.0
 */
public interface IPaymentTermService extends IBaseService<PaymentTerm>,ProxySelf<PaymentTerm>{
	/**
     * 根据条件查询paymentTerm 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param paymentTerm  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<PaymentTerm> 所有符合的结果集
     */
	List<PaymentTerm> paymentTermQuery(IRequest requestContext, PaymentTerm paymentTerm, int page,
			int pageSize);

}
