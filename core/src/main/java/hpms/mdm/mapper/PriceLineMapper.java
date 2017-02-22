package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.PriceLine;
/**
 * 
 * @name PriceLineMapper
 * @description 定价表行Mapper
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:37:18
 * @version 1.0
 */
public interface PriceLineMapper extends Mapper<PriceLine>{
	/**
     * 定价表行信息查询
     * @author chengye.hu@hand-china.com
     * @param priceLine 定价表行对象
     * @return List<PriceLine> 符合的对象集合
     */
	List<PriceLine> priceLineQuery(PriceLine priceLine);

}
