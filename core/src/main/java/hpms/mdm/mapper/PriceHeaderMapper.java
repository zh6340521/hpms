package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.PriceHeader;
/**
 * 
 * @name PriceHeaderMapper
 * @description 定价表头Mapper
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:35:46
 * @version 1.0
 */
public interface PriceHeaderMapper extends Mapper<PriceHeader>{
	/**
     * 定价表头信息查询
     * @author chengye.hu@hand-china.com
     * @param priceHeader 定价表头对象
     * @return List<PriceHeader> 符合的对象集合
     */
	List<PriceHeader> priceHeaderQuery(PriceHeader priceHeader);

}
