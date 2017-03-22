package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.CusmeterBind;
import hpms.fin.dto.PubMeter;
import hpms.fin.service.ICusmeterBindService;
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
    @Autowired
    private ICusmeterBindService iCusmeterBindService;

    @RequestMapping(value = "/hpms/fin/pubmeter/query")
    @ResponseBody
    public ResponseData query(PubMeter dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPubMeter(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/pubmeter/init/query")
    @ResponseBody
    public ResponseData queryInit(PubMeter dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                  @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPubMeterInit(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/pubmeter/change/query")
    @ResponseBody
    public ResponseData queryChange(PubMeter dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                    @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPubMeterChange(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/pubmeter/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<PubMeter> dto,@RequestParam Long cusmeterId) {
        IRequest requestCtx = createRequestContext(request);
        for (PubMeter pubMeter : dto) {
            if (pubMeter.getPropertyName() != null) {
                CusmeterBind cusmeterBind = new CusmeterBind();
                cusmeterBind.setCusmeterBindId(cusmeterId);
                cusmeterBind.setEquipmentId(pubMeter.getChangeEquipmentId());
                iCusmeterBindService.updateByPrimaryKeySelective(requestCtx, cusmeterBind);
            }

        }

        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }
}
