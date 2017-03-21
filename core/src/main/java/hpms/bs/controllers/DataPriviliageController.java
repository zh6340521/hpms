package hpms.bs.controllers;

import com.hand.hap.account.dto.Role;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.DataPriviliage;
import hpms.bs.service.IDataPriviliageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DataPriviliageController extends BaseController {

    @Autowired
    private IDataPriviliageService service;


    @RequestMapping(value = "/hpms/data/priviliage/query")
    @ResponseBody
    public ResponseData query(DataPriviliage dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryDataPriviliage(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/data/priviliage/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<DataPriviliage> dto) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/data/priviliage/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<DataPriviliage> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }


    @RequestMapping(value = "/hpms/data/role/query")
    @ResponseBody
    public ResponseData roleQuery(HttpServletRequest request, @ModelAttribute Role dto) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.queryRole(requestCtx, dto));
    }
}