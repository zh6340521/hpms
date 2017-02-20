package hpms.mdm.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.fnd.dto.Company;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.ConfigValue;
import hpms.mdm.dto.Project;
import hpms.mdm.dto.Property;
import hpms.mdm.service.IPropertyService;

/**
 * @name PropertyController
 * @description 建筑档案Controller
 * @author chengye.hu@hand-china.com	2017年2月15日下午7:48:26
 * @version 1.0
 */
@Controller
public class PropertyController extends BaseController{
	@Autowired
	private IPropertyService propertyService;
	/**
     * 根据条件查询property 
     *
     * @param property 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/propertyQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData propertyQuery(@ModelAttribute Property property , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<Property> propertys = propertyService.propertyQuery(requestContext,property,page,pageSize);
		return new ResponseData(propertys);
	}
	/**
     * property基础信息保存更新 
     *
     * @param propertys 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/propertySubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData propertySubmit(@RequestBody List<Property> propertys , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(propertys, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	return new ResponseData(propertyService.batchUpdate(requestContext, propertys));
        }
	}
	/**
     * 公司查询URL 
     *
     * @param company 封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/companyQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData companyQuery(@ModelAttribute Company company, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<Company> companys = propertyService.companyQuery(requestContext,company);
		return new ResponseData(companys);
	}
	/**
     * 集团查询URL 
     *
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/groupQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData groupQuery(HttpServletRequest request){
		List<Company> companys = propertyService.groupQuery();
		return new ResponseData(companys);
	}
	/**
     * 项目查询URL 
     *
     * @param company 封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/projectQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData projectQuery(@ModelAttribute Company company, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<Project> projects = propertyService.projectQuery(requestContext,company);
		return new ResponseData(projects);
	}
	/**
     * 建筑类型查询URL 
     *
     * @param configValue 封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/property/propertyTypeQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData propertyTypeQuery(@ModelAttribute ConfigValue configValue, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<ConfigValue> configValues = propertyService.propertyTypeQuery(requestContext,configValue);
		return new ResponseData(configValues);
	}
}
