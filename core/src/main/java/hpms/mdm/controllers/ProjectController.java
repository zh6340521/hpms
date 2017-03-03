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
/**
 *
 * @name ProjectController
 * @description 项目档案 Controller
 * @author jun.zhao02@hand-china.com    2017/2/15 10:20:00
 * @version 1.0
 */
@Controller
public class ProjectController extends BaseController{

    @Autowired
    private IProjectService service;

    /**
     * project查询
     *
     * @param dto       封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
    @RequestMapping(value = "/hpms/mdm/project/query")
    @ResponseBody
    public ResponseData query(Project dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<Project> projects = service.projectQuery(requestContext,dto,page,pageSize);
        return new ResponseData(projects);
    }

    /**
     * project保存更新
     *
     * @param dto       封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
    @RequestMapping(value = "/hpms/mdm/project/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Project> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    /**
     * project删除
     *
     * @param dto       封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
    @RequestMapping(value = "/hpms/mdm/project/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Project> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }

    /**
     * company查询
     *
     * @param dto       封装参数对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
    @RequestMapping(value = "/hpms/mdm/project/companyQuery" )
    @ResponseBody
    public ResponseData companyQuery(Company dto, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<Company> companys = service.companyQuery(requestContext,dto);
        return new ResponseData(companys);
    }

    /**
     * group查询
     *
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
    @RequestMapping(value = "/hpms/mdm/project/groupQuery" )
    @ResponseBody
    public ResponseData groupQuery(HttpServletRequest request) {
        List<Company> companys = service.groupQuery();
        return new ResponseData(companys);
    }
}