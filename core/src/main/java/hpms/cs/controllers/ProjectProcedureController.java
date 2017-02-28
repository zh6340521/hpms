package hpms.cs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.cs.dto.ProjectProcedure;
import hpms.cs.service.IProjectProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 * @name hpms.cs.controllers.ProjectProcedureController
 * @description 项目手续材料 controller 类
 */

@Controller
public class ProjectProcedureController extends BaseController {

    @Autowired
    private IProjectProcedureService service;

    @RequestMapping(value = "/cs/projectProcedure/query")
    @ResponseBody
    public ResponseData query(ProjectProcedure dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectProcedureName(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/cs/projectProcedure/submit")
    @ResponseBody
    public ResponseData update(
            HttpServletRequest request, @RequestBody List<ProjectProcedure> dto,
            BindingResult result) throws BaseException {

        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }

        return new ResponseData(service.batchUpdateProcedure(requestCtx, dto));
    }

    @RequestMapping(value = "/cs/projectProcedure/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<ProjectProcedure> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}