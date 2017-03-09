package hpms.bs.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.BaseDTO;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.Sequence;
import hpms.bs.service.ISequenceService;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LoseMyself on 2017/3/7.
 */
@Controller
public class SequenceController extends BaseController{

    @Autowired
    private ISequenceService service;

    @RequestMapping(value = "bs/seq/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request,  Sequence sequence,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(service.select(requestContext,sequence, page, pageSize));
    }

    @RequestMapping(value = "bs/seq/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData add(HttpServletRequest request, @RequestBody List<Sequence> dto, BindingResult result) {
                if(service.isDateOk(dto)){
                    IRequest requestCtx = createRequestContext(request);
                    if (result.hasErrors()) {
                        ResponseData rd = new ResponseData(false);
                        rd.setMessage(getErrorMessage(result, request));
                        return rd;
                    }
                    return new ResponseData(service.batchUpdate(requestCtx, dto));
                }
                ResponseData rd1 = new ResponseData();
                rd1.setMessage("新建失败,该编码时间段重叠,请重新编辑!");
                rd1.setSuccess(false);
                return rd1;
        }

    @RequestMapping(value = "bs/seq/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<Sequence> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "bs/seq/delete",method = RequestMethod.DELETE)
    public ResponseData delete(@RequestBody List<Sequence> sequences){
        ResponseData responseData = new ResponseData();
        service.batchDelete(sequences);
        responseData.setMessage("删除成功");
        responseData.setSuccess(true);
        return responseData;
    }
}
