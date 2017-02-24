package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.DiscountPro;
/**
 * 
 * @name DiscountProMapper
 * @description 优惠方案Mapper
 * @author chengye.hu@hand-china.com	2017年2月24日上午9:57:02
 * @version 1.0
 */
public interface DiscountProMapper extends Mapper<DiscountPro>{
	/**
     * 优惠方案信息查询
     * @author chengye.hu@hand-china.com
     * @param discountPro 定价表行对象
     * @return List<DiscountPro> 符合的对象集合
     */
	List<DiscountPro> discountProQuery(DiscountPro discountPro);

}
