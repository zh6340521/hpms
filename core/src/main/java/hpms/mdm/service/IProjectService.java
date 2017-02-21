package hpms.mdm.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.Project;
import com.hand.hap.fnd.dto.Company;
import java.util.List;

public interface IProjectService extends IBaseService<Project>, ProxySelf<IProjectService>{
	/**
	 * 根据条件查询project
	 * @author jun.zhao02@hand-china.com
	 * @param requestContext  请求
	 * @param project  封装参数对象
	 * @param page     查询页
	 * @param pageSize 页面大小
	 * @return List<Project> 所有符合的结果集
	 */
	List<Project> projectQuery(IRequest requestContext, Project project, int page, int pageSize);

	/**
	 * 根据条件查询company
	 * @author jun.zhao02@hand-china.com
	 * @param requestContext  请求
	 * @param company  封装参数对象
	 * @return List<Company> 所有符合的结果集
	 */
	List<Company> companyQuery(IRequest requestContext, Company company);

	/**
	 * 根据条件查询group
	 * @author jun.zhao02@hand-china.com
	 * @return List<Company> 所有符合的结果集
	 */
	List<Company> groupQuery();

}