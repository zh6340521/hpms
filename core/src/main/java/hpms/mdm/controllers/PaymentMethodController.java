package hpms.mdm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
/**
 * 
 * @name PaymentMethodController
 * @description 付款方式Controller
 * @author chengye.hu@hand-china.com	2017年2月23日下午1:59:55
 * @version 1.0
 */
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.PaymentMethod;
import hpms.mdm.service.IPaymentMethodService;
@Controller
public class PaymentMethodController extends BaseController{
	@Autowired
	private IPaymentMethodService paymentMethodService;
	/**
     * 根据条件查询paymentMethod 
     *
     * @param paymentMethod 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/paymentMethod/paymentMethodQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData paymentMethodQuery(@ModelAttribute PaymentMethod paymentMethod , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<PaymentMethod> paymentMethods = paymentMethodService.paymentMethodQuery(requestContext,paymentMethod,page,pageSize);
		return new ResponseData(paymentMethods);
	}
	/**
     * property基础信息保存更新 
     *
     * @param propertys 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/paymentMethod/paymentMethodSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData paymentMethodSubmit(@RequestBody List<PaymentMethod> paymentMethods , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(paymentMethods, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	paymentMethods = paymentMethodService.batchUpdate(requestContext, paymentMethods);
        	PaymentMethod paymentMethod = new PaymentMethod();
        	List<PaymentMethod> paymentMethods2 = new ArrayList<PaymentMethod>();
        	for (PaymentMethod paymentMethod2 : paymentMethods) {
        		paymentMethod.setPaymentMethodId(paymentMethod2.getPaymentMethodId());
        		paymentMethods2.add(paymentMethodService.paymentMethodQuery(requestContext,paymentMethod,1,100).get(0));
			}
        	return new ResponseData(paymentMethods2);
        }
	}
}
