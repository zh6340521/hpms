package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.ShareRule;
import hpms.fin.service.IShareRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/20   14:46
 */
@Controller
public class ShareRuleController extends BaseController{
    @Autowired
    private IShareRuleService service;

    @RequestMapping(value = "fin/share/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, ShareRule shareRule,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(service.select(requestContext,shareRule, page, pageSize));
    }

    @RequestMapping(value = "fin/share/submit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<ShareRule> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }


    @RequestMapping(value = "fin/share/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<ShareRule> sequences){
        ResponseData responseData = new ResponseData();
        service.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }

}
