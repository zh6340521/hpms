package hpms.fin.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.Payment;
import hpms.fin.service.IPaymentService;

@Controller
public class PaymentController extends BaseController{
	@Autowired
	private IPaymentService paymentService;
	@RequestMapping(value = "/hpms/fin/payment/query")
    @ResponseBody
    public ResponseData query(Payment dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(paymentService.queryInvoice(dto, requestContext, page, pageSize));
    }
	
	
	@RequestMapping(value = "/hpms/fin/payment/saveAdvance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData saveAdvance(HttpServletRequest request,@RequestBody List<Payment> payment,BindingResult result){
		IRequest requestContext = createRequestContext(request);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String paymentCode = sdf.format(new Date());
	    payment.get(0).setPaymentCode(paymentCode);
	    Long LineNumber = (long) 1;
	    payment.get(0).setLineNumber(LineNumber);
		payment = (paymentService.batchUpdate(requestContext, payment));
		return new ResponseData(payment);
	}
	
	
	@RequestMapping(value = "/hpms/fin/payment/queryCollection")
    @ResponseBody
    public ResponseData queryCollection(Payment dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(paymentService.queryCollection(dto, requestContext, page, pageSize));
    }
}
