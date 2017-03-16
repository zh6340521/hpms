package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.PubMeter;
import hpms.fin.service.IPubMeterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PubMeterController extends BaseController {

    @Autowired
    private IPubMeterService service;

    @RequestMapping(value = "/hpms/fin/pubmeter/query")
    @ResponseBody
    public ResponseData query(PubMeter dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPubMeter(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/pubmeter/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<PubMeter> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }
}
