package hpms.mdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.Customer;



/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersionMapper
 * @description:客户档案mapper
 * @date 2017/2/17
 */
public interface CustomerMapper extends Mapper<Customer>{
	/**
	 * 根据不同的列名查询改列名包含值的数据
	 * @param name
	 * @param value
	 * @return
	 */
	public List<Customer> selectByColumnName(Customer cs);
	
	
	/**
     * 查询最大的客户编号
     * @param calendarId
     * @return
     * 
     * @Author huifang.zhou@hand-china.com
     * */
    public Long selectByMaxCustomerNumber();
    
    /**
     * 查看记录状态
     * @param customer
     * @return 
     * @Author huifang.zhou@hand-china.com
     */
    public String queryByEnableFlag(@Param(value="customerId")Long customerId);
	
}
