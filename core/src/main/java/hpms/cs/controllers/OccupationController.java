package hpms.cs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.cs.dto.Occupation;
import hpms.cs.service.IOccupationService;
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
 * @name hpms.cs.controllers.OccupationController
 * @description 入退伙 controller 类
 */

@Controller
public class OccupationController extends BaseController {

    @Autowired
    private IOccupationService service;


    @RequestMapping(value = "/cs/occupation/queryProperty")
    @ResponseBody
    public ResponseData queryProperty(Occupation dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.propertyQuery(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/cs/occupation/query")
    @ResponseBody
    public ResponseData query(Occupation dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectOccupation(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/cs/occupation/queryOne")
    @ResponseBody
    public Occupation queryOne(Occupation dto, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        Occupation occupation = service.queryOne(requestContext, dto);
        return occupation;
    }



    @RequestMapping(value = "/cs/occupation/submit")
    @ResponseBody
    public Occupation update(HttpServletRequest request, @RequestBody Occupation occupation,
                               BindingResult result) throws BaseException {

        IRequest requestCtx = createRequestContext(request);
//        if (result.hasErrors()) {
//            ResponseData rd = new ResponseData(false);
//            rd.setMessage(getErrorMessage(result, request));
//            return rd;
//        }
        return service.updateOccu(requestCtx,occupation);
    }

    @RequestMapping(value = "/cs/occupation/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Occupation> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}