package hpms.cs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.cs.dto.OccProcedure;
import hpms.cs.service.IOccProcedureService;
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
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.controllers.OccProcedureController
 * @description 入伙手续材料关联 controller 类
 */

@Controller
public class OccProcedureController extends BaseController {

    @Autowired
    private IOccProcedureService service;


    @RequestMapping(value = "/cs/occProcedure/query")
    @ResponseBody
    public ResponseData query(OccProcedure dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/cs/occProcedure/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<OccProcedure> dto,
                               BindingResult result) throws BaseException {

        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/cs/occProcedure/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<OccProcedure> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}