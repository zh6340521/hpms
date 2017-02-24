package hpms.mdm.mapper;

import com.hand.hap.fnd.dto.Company;
import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.Project;

import java.util.List;

/**
 *
 * @name ProjectMapper
 * @description 项目档案 Mapper
 * @author jun.zhao02@hand-china.com    2017/2/15 10:20:00
 * @version 1.0
 */
public interface ProjectMapper extends Mapper<Project>{

	/**
	 * 项目档案查询
	 * @author jun.zhao02@hand-china.com
	 * @param project 项目对象
	 * @return List<Project> 符合的对象集合
	 */
	List<Project> projectQuery(Project project);

	/**
	 * 公司信息查询
	 * @author jun.zhao02@hand-china.com
	 * @param company 公司对象
	 * @return List<Company> 符合的对象集合
	 */
	List<Company> companyQuery(Company company);

	/**
	 * 集团信息查询
	 * @author jun.zhao02@hand-china.com
	 * @return List<Company> 符合的对象集合
	 */
	List<Company> groupQuery();

}