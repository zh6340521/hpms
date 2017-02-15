package hpms.mdm.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.FeeType;
import hpms.mdm.service.IFeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class FeeTypeController extends BaseController{

    @Autowired
    private IFeeTypeService service;


    @RequestMapping(value = "/hpms/mdm/fee/type/query")
    @ResponseBody
    public ResponseData query(FeeType dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hpms/mdm/fee/type/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<FeeType> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/mdm/fee/type/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<FeeType> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }