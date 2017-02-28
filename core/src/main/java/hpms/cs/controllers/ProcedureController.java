package hpms.cs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.cs.dto.Procedure;
import hpms.cs.service.IProcedureService;
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
 * @name hpms.cs.controllers.ProcedureController
 * @description 手续材料 controller 类
 */

@Controller
public class ProcedureController extends BaseController {

    @Autowired
    private IProcedureService service;


    @RequestMapping(value = "/cs/procedure/query")
    @ResponseBody
    public ResponseData query(Procedure dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/cs/procedure/submit")
    @ResponseBody
    public ResponseData update(
            HttpServletRequest request, @RequestBody List<Procedure> dto,
            BindingResult result) throws BaseException {

        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }

        for (Procedure procedure :
                dto) {
            procedure.setProcedureType("OCC");
        }
        
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/cs/procedure/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Procedure> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}