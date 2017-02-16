package hpms.mdm.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.FeeType;
import hpms.mdm.service.IFeeTypeService;
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
 * @name hpms.mdm.controllers.FeeTypeController
 * @description 费项类型 controller 类
 * @author feng.liu01@hand-china.com 2017/02/16
 * @version 1.0
 */

@Controller
@RequestMapping(value = "/mdm/feetype")
public class FeeTypeController extends BaseController {

    @Autowired
    private IFeeTypeService service;

    /**
     * 查询
     * @param dto
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public ResponseData query(FeeType dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    /**
     * 插入和更新
     * @param request
     * @param dto
     * @return
     */
    @RequestMapping(value = "/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<FeeType> dto, BindingResult result) {
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
    @RequestMapping(value = "/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<FeeType> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}