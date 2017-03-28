package hpms.mdm.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.PurchaseOrg;
import hpms.mdm.service.IPurchaseOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name PurchaseOrgController
 * @description: 采购组织Controller
 * @date 2017/3/28  10:22
 */
@Controller
public class PurchaseOrgController extends BaseController{
    @Autowired
    private IPurchaseOrgService service;

    /**
     * 查询采购组织
     * @param request
     * @param page
     * @param pageSize
     * @param purchaseOrg
     * @return
     */
    @RequestMapping(value = "mdm/purchase/query",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, PurchaseOrg purchaseOrg,
                               @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(service.select(requestContext,purchaseOrg, page, pageSize));
    }

    /**
     * 查询采购组织
     * @param request
     * @param result
     * @param dto
     * @return
     */
    @RequestMapping(value = "mdm/purchase/submit",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<PurchaseOrg> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }


}
