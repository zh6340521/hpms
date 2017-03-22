package hpms.fin.controllers;

import hpms.mdm.dto.Equipment;
import hpms.mdm.dto.Property;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.CusmeterBind;
import hpms.fin.service.ICusmeterBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CusmeterBindController extends BaseController {

    @Autowired
    private ICusmeterBindService service;


    @RequestMapping(value = "/hpms/fin/cusmeter/bind/query")
    @ResponseBody
    public ResponseData query(CusmeterBind dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryCusmeterBind(requestContext, dto, page, pageSize));
    }


    @RequestMapping(value = "/hpms/fin/cusmeter/property/query")
    @ResponseBody
    public ResponseData queryProperty(Property dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPropertyNoLink(requestContext, dto, page, pageSize));
    }
    @RequestMapping(value = "/hpms/fin/cusmeter/equipment/query")
    @ResponseBody
    public ResponseData queryEquipment(Equipment dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                       @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryEquipmentInUse(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/cusmeter/bind/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody CusmeterBind dto) {
        IRequest requestCtx = createRequestContext(request);

        CusmeterBind cusmeterBind = service.insertSelective(requestCtx, dto);
        ArrayList<CusmeterBind> cusmeterBinds = new ArrayList<CusmeterBind>();
        cusmeterBinds.add(cusmeterBind);
        return new ResponseData(cusmeterBinds);
    }

    @RequestMapping(value = "/hpms/fin/cusmeter/bind/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<CusmeterBind> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}