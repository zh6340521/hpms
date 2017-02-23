package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.PaymentTerm;
/**
 * 
 * @name PaymentTermMapper
 * @description 付款条件Mapper
 * @author chengye.hu@hand-china.com	2017年2月23日下午4:31:12
 * @version 1.0
 */
public interface PaymentTermMapper extends Mapper<PaymentTerm>{
	/**
     * 付款条件信息查询
     * @author chengye.hu@hand-china.com
     * @param paymentTerm 付款条件对象
     * @return List<PaymentTerm> 符合的对象集合
     */
	List<PaymentTerm> paymentTermQuery(PaymentTerm paymentTerm);

}
