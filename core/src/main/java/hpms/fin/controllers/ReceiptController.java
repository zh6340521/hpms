package hpms.fin.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.Receipt;
import hpms.fin.dto.ReceiptFeeList;
import hpms.fin.service.IReceiptService;
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
 * @author feng.liu01@hand-china.com 2017/03/08
 * @version 1.0
 * @name hpms.fin.controllers.ReceiptController
 * @description 收款录入 controller 类
 */

@Controller
public class ReceiptController extends BaseController {

    @Autowired
    private IReceiptService service;


    @RequestMapping(value = "/fin/receipt/query")
    @ResponseBody
    public ResponseData query(ReceiptFeeList dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectReceipt(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/fin/receipt/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,
                               @RequestBody Receipt receipt,
                               BindingResult result) throws BaseException {
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        return new ResponseData(service.updateReceipt(requestCtx, receipt));
    }

    @RequestMapping(value = "/fin/receipt/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Receipt> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}