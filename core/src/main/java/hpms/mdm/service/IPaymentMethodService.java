package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.PaymentMethod;

/**
 * 
 * @name IPaymentMethodService
 * @description 付款方式Service
 * @author chengye.hu@hand-china.com	2017年2月23日下午2:08:58
 * @version 1.0
 */
public interface IPaymentMethodService extends IBaseService<PaymentMethod>,ProxySelf<PaymentMethod>{
	/**
     * 根据条件查询paymentMethod 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param paymentMethod  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<PaymentMethod> 所有符合的结果集
     */
	List<PaymentMethod> paymentMethodQuery(IRequest requestContext, PaymentMethod paymentMethod, int page,
			int pageSize);

}
