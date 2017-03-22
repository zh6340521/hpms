package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.MeterCharge;
import hpms.fin.service.IMeterChargeService;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping(value = "fin/charge/find",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData find(HttpServletRequest request, MeterCharge meterCharge){
        IRequest requestContext = this.createRequestContext(request);
        boolean a = meterChargeService.isChange(meterChargeService.selectByPrimaryKey(requestContext,meterCharge));
        ResponseData responseData = new ResponseData();
        if(a){
            responseData.setMessage("true");
            responseData.setSuccess(true);
        }else{
            responseData.setMessage("false");
            responseData.setSuccess(false);
        }
        return responseData;
    }


    @RequestMapping(value = "fin/charge/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, MeterCharge meterCharge,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(meterChargeService.select(requestContext,meterCharge, page, pageSize));
    }



    @RequestMapping(value = "fin/charge/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData add(HttpServletRequest request, @RequestBody List<MeterCharge> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        boolean a = meterChargeService.isHaveEn(dto.get(0));
        System.out.println(a);
        if( a == false){
            ResponseData responseData = new ResponseData();
            responseData.setMessage("同一公司项目下某一种仪表类型的计费规则只允许一条为启用!");
            responseData.setSuccess(false);
            return responseData;
        }
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(meterChargeService.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "fin/charge/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<MeterCharge> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        boolean a = meterChargeService.isHaveEn(dto.get(0));
        System.out.println(a);
        if( a == false){
            ResponseData responseData = new ResponseData();
            responseData.setMessage("同一公司项目下某一种仪表类型的计费规则只允许一条为启用!");
            responseData.setSuccess(false);
            return responseData;
        }
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(meterChargeService.batchUpdate(requestCtx, dto));
    }


    @RequestMapping(value = "fin/charge/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<MeterCharge> sequences){
        ResponseData responseData = new ResponseData();
        meterChargeService.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }

}
