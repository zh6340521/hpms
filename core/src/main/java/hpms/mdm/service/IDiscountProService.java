package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.DiscountPro;
/**
 * 
 * @name IDiscountProService
 * @description 优惠方案Service
 * @author chengye.hu@hand-china.com	2017年2月24日上午10:33:44
 * @version 1.0
 */
public interface IDiscountProService extends IBaseService<DiscountPro>,ProxySelf<DiscountPro>{
	/**
     * 根据条件查询discountPro 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param discountPro  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<DiscountPro> 所有符合的结果集
     */
	List<DiscountPro> discountProQuery(IRequest requestContext, DiscountPro discountPro, int page, int pageSize);

}
