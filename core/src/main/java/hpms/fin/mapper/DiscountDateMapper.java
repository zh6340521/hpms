package hpms.fin.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.fin.dto.DiscountDate;

/**
 * 
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name DiscountDateMapper
 * @description:应收优惠Mapper
 * @date 2017/3/9
 * 
 */
public interface DiscountDateMapper extends Mapper<DiscountDate>{
	
	/**
	 * 根据条件查询是否是否存在应收优惠清单
	 * @param discountDate
	 * @return
	 */
	public int queryCount(DiscountDate discountDate);
	
	/**
	 * 根据优惠方案查到费项类型
	 * @param discountDate
	 * @return
	 */
	public DiscountDate queryName(DiscountDate discountDate);
	
	/**
	 * 根据条件查询所有金额
	 * @param discountDate
	 * @return
	 */
	public DiscountDate querySum(DiscountDate discountDate);
	
	
	/**
	 * 根据条件查询应收优惠方案
	 * @return
	 */
	public List<DiscountDate> queryDiscount(DiscountDate discountDate);
	
	
}
