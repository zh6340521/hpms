package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.fnd.dto.Company;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.ConfigValue;
import hpms.mdm.dto.Project;
import hpms.mdm.dto.Property;

import java.util.List;

/**
 * @name IPropertyService
 * @description 建筑档案Service
 * @author chengye.hu@hand-china.com	2017年2月15日下午7:55:10
 * @version 1.0
 */
public interface IPropertyService extends IBaseService<Property>,ProxySelf<Property>{
	/**
     * 根据条件查询property 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param property  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<Property> 所有符合的结果集
     */
	List<Property> propertyQuery(IRequest requestContext, Property property, int page, int pageSize);
	/**
     * 根据条件查询company 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param company  封装参数对象
     * @return List<Company> 所有符合的结果集
     */
	List<Company> companyQuery(IRequest requestContext, Company company);
	/**
     * 根据条件查询group 
     * @author chengye.hu@hand-china.com
     * @return List<Company> 所有符合的结果集
     */
	List<Company> groupQuery();
	/**
     * 根据条件查询project 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param project  封装参数对象
     * @return List<Project> 所有符合的结果集
     */
	List<Project> projectQuery(IRequest requestContext, Project project);
	/**
     * 根据条件查询建筑类型 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param configValue  封装参数对象
     * @return List<ConfigValue> 所有符合的结果集
     */
	List<ConfigValue> propertyTypeQuery(IRequest requestContext, ConfigValue configValue);

	/**
	 * 查询建筑档案动态的字段
	 * @param requestContext
	 * @param project
     * @return
     */
	List<Property> propertyShow(IRequest requestContext, Property property);

}
