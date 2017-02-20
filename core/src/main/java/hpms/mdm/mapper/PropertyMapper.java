package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.fnd.dto.Company;
import com.hand.hap.mybatis.common.Mapper;

import hpms.mdm.dto.ConfigValue;
import hpms.mdm.dto.Project;
import hpms.mdm.dto.Property;

/**
 * @name PropertyMapper
 * @description 建筑档案Mapper
 * @author chengye.hu@hand-china.com	2017年2月15日下午7:57:10
 * @version 1.0
 */
public interface PropertyMapper extends Mapper<Property>{
	/**
     * 建筑档案信息查询
     * @author chengye.hu@hand-china.com
     * @param property 建筑档案对象
     * @return List<Property> 符合的对象集合
     */
	List<Property> propertyQuery(Property property);
	/**
     * 公司信息查询
     * @author chengye.hu@hand-china.com
     * @param company 公司对象
     * @return List<Company> 符合的对象集合
     */
	List<Company> companyQuery(Company company);
	/**
     * 集团信息查询
     * @author chengye.hu@hand-china.com
     * @return List<Company> 符合的对象集合
     */
	List<Company> groupQuery();
	/**
     * 项目信息查询
     * @author chengye.hu@hand-china.com
     * @param property 公司对象
     * @return List<Project> 符合的对象集合
     */
	List<Project> projectQuery(Company company);
	/**
     * 建筑类型信息查询
     * @author chengye.hu@hand-china.com
     * @param property 建筑类型对象
     * @return List<ConfigValue> 符合的对象集合
     */
	List<ConfigValue> propertyTypeQuery(ConfigValue configValue);

}
