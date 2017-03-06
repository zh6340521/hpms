package hpms.fin.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.fin.dto.FeeList;

/**
 * 
 * @name FeeListMapper
 * @description 应收费用清单Mapper
 * @author chengye.hu@hand-china.com	2017年2月27日下午2:46:00
 * @version 1.0
 */
public interface FeeListMapper extends Mapper<FeeList>{
	/**
     * 应收费用清单信息查询
     * @author chengye.hu@hand-china.com
     * @param feeList 建筑档案对象
     * @return List<FeeList> 符合的对象集合
     */
	List<FeeList> feeListQuery(FeeList feeList);

}
