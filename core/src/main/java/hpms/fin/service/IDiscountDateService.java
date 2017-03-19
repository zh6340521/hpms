package hpms.fin.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.fin.dto.DiscountDate;
/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name IDiscountDateService
 * @description：应收优惠接口
 * @date 2017/3/9
 */
public interface IDiscountDateService extends IBaseService<DiscountDate>,ProxySelf<IDiscountDateService>{
	
	
	/**
	 * 根据优惠方案查到费项类型
	 * @param discountDate
	 * @return
	 */
	public DiscountDate queryName(DiscountDate discountDate,IRequest requestContext);
	
	
	/**
	 * 根据条件查询所有金额
	 * @param discountDate
	 * @return
	 */
	public DiscountDate querySum(DiscountDate discountDate,IRequest requestContext);
	
	
	/**
	 * 根据条件查询应收优惠方案
	 * @return
	 */
	public List<DiscountDate> queryDiscount(DiscountDate discountDate,IRequest requestContext,int page,int pagesize);
	
	/**
	 * 修改费用清单
	 * @param discountDate
	 * @param requestContext
	 * @return
	 */
	public List<DiscountDate> updateFeeList(List<DiscountDate> discountDate,IRequest requestContext);

}
