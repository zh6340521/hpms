package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.ShareRuleBind;
import hpms.fin.service.IShareRuleBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:34
 */
@Controller
public class ShareRuleBindController extends BaseController{
    @Autowired
    private IShareRuleBindService service;

    @RequestMapping(value = "fin/sharebind/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, ShareRuleBind shareRuleBind,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(service.select(requestContext,shareRuleBind, page, pageSize));
    }

    @RequestMapping(value = "fin/sharebind/submit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody ShareRuleBind dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        ResponseData rd = new ResponseData();
        if (result.hasErrors()) {
            rd.setSuccess(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        rd.setSuccess(true);
        rd.setRows(Collections.singletonList(service.insert(requestCtx,dto)));
        return rd;
    }


    @RequestMapping(value = "fin/sharebind/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<ShareRuleBind> sequences){
        ResponseData responseData = new ResponseData();
        service.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }

}
