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
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.PaymentTerm;
import hpms.mdm.service.IPaymentTermService;
/**
 * 
 * @name PaymentTermController
 * @description 付款条件
 * @author chengye.hu@hand-china.com	2017年2月23日下午4:40:35
 * @version 1.0
 */
@Controller
public class PaymentTermController extends BaseController{
	@Autowired
	private IPaymentTermService paymentTermService;
	/**
     * 根据条件查询paymentTerm 
     *
     * @param paymentTerm 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/paymentTerm/paymentTermQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData paymentTermQuery(@ModelAttribute PaymentTerm paymentTerm , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<PaymentTerm> paymentTerms = paymentTermService.paymentTermQuery(requestContext,paymentTerm,page,pageSize);
		return new ResponseData(paymentTerms);
	}
	/**
     * paymentTerm基础信息保存更新 
     *
     * @param paymentTerms 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/paymentTerm/paymentTermSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData paymentTermSubmit(@RequestBody List<PaymentTerm> paymentTerms , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(paymentTerms, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	paymentTerms = paymentTermService.batchUpdate(requestContext, paymentTerms);
        	PaymentTerm paymentTerm = new PaymentTerm();
        	List<PaymentTerm> paymentTerms2 = new ArrayList<PaymentTerm>();
        	for (PaymentTerm paymentTerm2 : paymentTerms) {
        		paymentTerm.setPaymentTermId(paymentTerm2.getPaymentTermId());
        		paymentTerms2.add(paymentTermService.paymentTermQuery(requestContext,paymentTerm,1,100).get(0));
			}
        	return new ResponseData(paymentTerms2);
        }
	}
}
