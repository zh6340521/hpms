package hpms.mdm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.fnd.dto.Company;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.ConfigValue;
import hpms.mdm.dto.Project;
import hpms.mdm.dto.Property;
import hpms.mdm.mapper.PropertyMapper;
import hpms.mdm.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name PropertyServiceImpl
 * @description 建筑档案Impl
 * @author chengye.hu@hand-china.com	2017年2月15日下午7:54:33
 * @version 1.0
 */
@Service
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements IPropertyService{
	@Autowired
	private PropertyMapper propertyMapper;
	@Override
	public List<Property> propertyQuery(IRequest requestContext, Property property, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return propertyMapper.propertyQuery(property);
	}
	@Override
	public List<Company> companyQuery(IRequest requestContext, Company company) {
		return propertyMapper.companyQuery(company);
	}
	@Override
	public List<Company> groupQuery() {
		return propertyMapper.groupQuery();
	}
	@Override
	public List<Project> projectQuery(IRequest requestContext, Project project) {
		return propertyMapper.projectQuery(project);
	}
	@Override
	public List<ConfigValue> propertyTypeQuery(IRequest requestContext, ConfigValue configValue) {
		return propertyMapper.propertyTypeQuery(configValue);
	}

	@Override
		public List<Property> propertyShow(IRequest requestContext, Property property){
		return propertyMapper.propertyShow(property);
	}

}
