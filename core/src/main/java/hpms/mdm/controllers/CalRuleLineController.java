package hpms.mdm.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.CalRuleLine;
import hpms.mdm.service.ICalRuleLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.controllers.CalRuleLineController
 * @description 计费规则行数据 controller 类
 */

@Controller
public class CalRuleLineController extends BaseController {

    @Autowired
    private ICalRuleLineService service;

    /**
     * 查询
     * @param dto
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/mdm/calRuleLine/query")
    @ResponseBody
    public ResponseData query(CalRuleLine dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectElementName(requestContext, dto, page, pageSize));
    }

    /**
     * 保存和更新
     * @param request
     * @param dto
     * @param result
     * @return
     */
    @RequestMapping(value = "/mdm/calRuleLine/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<CalRuleLine> dto, BindingResult result) {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    /**
     * 删除
     * @param request
     * @param dto
     * @return
     */
    @RequestMapping(value = "/mdm/calRuleLine/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<CalRuleLine> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}