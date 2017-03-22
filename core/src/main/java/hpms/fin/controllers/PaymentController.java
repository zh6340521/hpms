package hpms.fin.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hpms.fin.dto.Invoice;
import hpms.fin.service.IPaymentService;

@Controller
public class PaymentController extends BaseController{
	@Autowired
	private IPaymentService paymentService;
	@RequestMapping(value = "/hpms/fin/payment/query")
    @ResponseBody
    public ResponseData query(Invoice dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(paymentService.queryInvoice(dto, requestContext, page, pageSize));
    }
}
