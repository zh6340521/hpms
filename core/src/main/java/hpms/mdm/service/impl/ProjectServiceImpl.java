package hpms.mdm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.fnd.dto.Company;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.Project;
import hpms.mdm.service.IProjectService;
import hpms.mdm.mapper.ProjectMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @name ProjectServiceImpl
 * @description 项目档案 Impl
 * @author jun.zhao02@hand-china.com    2017/2/15 10:20:00
 * @version 1.0
 */
@Service
@Transactional
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements IProjectService{
	@Autowired
	private ProjectMapper projectMapper;
	@Override
	public List<Project> projectQuery(IRequest requestContext, Project project, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return projectMapper.projectQuery(project);
	}
	@Override
	public List<Company> companyQuery(IRequest requestContext, Company company) {
		return projectMapper.companyQuery(company);
	}
	@Override
	public List<Company> groupQuery() {
		return projectMapper.groupQuery();
	}

}