package hpms.bs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.MeterCharge;
import hpms.bs.service.IMeterChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:18
 */
@Controller
public class MeterChargeController extends BaseController{

    @Autowired
    private IMeterChargeService meterChargeService;

    @RequestMapping(value = "bs/charge/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, MeterCharge meterCharge,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(meterChargeService.select(requestContext,meterCharge, page, pageSize));
    }



    @RequestMapping(value = "bs/charge/submit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<MeterCharge> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(meterChargeService.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "bs/charge/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<MeterCharge> sequences){
        ResponseData responseData = new ResponseData();
        meterChargeService.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }

}
