package hpms.bs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.MeterGradePrice;
import hpms.bs.service.IMeterPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   18:20
 */
@Controller
public class MeterPriceController extends BaseController{

    @Autowired
    private IMeterPriceService meterPriceService;

    @RequestMapping(value = "bs/meterprice/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, MeterGradePrice meterCharge,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(meterPriceService.select(requestContext,meterCharge, page, pageSize));
    }



    @RequestMapping(value = "bs/meterprice/submit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<MeterGradePrice> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(meterPriceService.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "bs/meterprice/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<MeterGradePrice> sequences){
        ResponseData responseData = new ResponseData();
        meterPriceService.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }
}
