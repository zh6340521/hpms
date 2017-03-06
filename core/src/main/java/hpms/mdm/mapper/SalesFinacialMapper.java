package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.SalesFinacial;


/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name SalesFinacialMapper
 * @description:销售信息mapper
 * @date 2017/2/22
 */
public interface SalesFinacialMapper extends Mapper<SalesFinacial>{
	/**
	 * 根据id查询
	 * @param bpgeneral
	 * @return
	 */
	public List<SalesFinacial> selectByCustId(SalesFinacial sales);
}
