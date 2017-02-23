package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.PaymentMethod;
/**
 * 
 * @name PaymentMethodMapper
 * @description 付款方式Mapper
 * @author chengye.hu@hand-china.com	2017年2月23日下午1:44:23
 * @version 1.0
 */
public interface PaymentMethodMapper extends Mapper<PaymentMethod>{
	/**
     * 付款方式信息查询
     * @author chengye.hu@hand-china.com
     * @param paymentMethod 付款方式对象
     * @return List<PaymentMethod> 符合的对象集合
     */
	List<PaymentMethod> paymentMethodQuery(PaymentMethod paymentMethod);

}
