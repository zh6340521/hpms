package hpms.mdm.controllers;

import com.hand.hap.fnd.dto.Company;
import hpms.mdm.dto.Property;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.Project;
import hpms.mdm.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class ProjectController extends BaseController{

    @Autowired
    private IProjectService service;


    @RequestMapping(value = "/hpms/mdm/project/query")
    @ResponseBody
    public ResponseData query(Project dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<Project> projects = service.projectQuery(requestContext,dto,page,pageSize);
        return new ResponseData(projects);
    }

    @RequestMapping(value = "/hpms/mdm/project/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Project> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/mdm/project/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Project> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }

    @RequestMapping(value = "/hpms/mdm/project/companyQuery" )
    @ResponseBody
    public ResponseData companyQuery(Company dto, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<Company> companys = service.companyQuery(requestContext,dto);
        return new ResponseData(companys);
    }
    @RequestMapping(value = "/hpms/mdm/project/groupQuery" )
    @ResponseBody
    public ResponseData groupQuery(HttpServletRequest request) {
        List<Company> companys = service.groupQuery();
        return new ResponseData(companys);
    }
    }