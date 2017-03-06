package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.BpGeneral;

/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name BpGeneralMapper
 * @description:一般信息mapper
 * @date 2017/2/22
 */
public interface BpGeneralMapper extends Mapper<BpGeneral>{
	
	/**
	 * 根据id查询
	 * @param bpgeneral
	 * @return
	 */
	public List<BpGeneral> selectByCustomerId(BpGeneral bpGeneral);
	
	
	/**
	 * 按条件查询一般信息表
	 * @param bpGeneral
	 * @return
	 */
	public List<BpGeneral> queryBpgeneral(BpGeneral bpGeneral);
	
	
	
	/**
	 * 根据id查询人员关系
	 * @param bpGeneral
	 * @return
	 */
	public List<BpGeneral> selectByRetaion(BpGeneral bpGeneral);

}
