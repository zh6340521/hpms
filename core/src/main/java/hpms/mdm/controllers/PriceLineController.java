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
import org.springframework.web.servlet.support.RequestContextUtils;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;

import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.CalculateRule;
import hpms.mdm.dto.Fee;
import hpms.mdm.dto.FeeType;
import hpms.mdm.dto.PriceLine;
import hpms.mdm.service.ICalculateRuleService;
import hpms.mdm.service.IFeeService;
import hpms.mdm.service.IFeeTypeService;
import hpms.mdm.service.IPriceLineService;
import hpms.utils.ValidationTableException;
/**
 * 
 * @name PriceLineController
 * @description 定价表行Controller
 * @author chengye.hu@hand-china.com	2017年2月21日下午5:31:52
 * @version 1.0
 */
@Controller
public class PriceLineController extends BaseController{
	@Autowired
	private IPriceLineService priceLineService;
	@Autowired
	private IFeeTypeService feeTypeService;
	@Autowired
	private IFeeService feeService;
	@Autowired
	private ICalculateRuleService calculateRuleService;
	/**
     * 根据条件查询priceLine 
     *
     * @param priceLine 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceLine/priceLineQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData priceLineQuery(@ModelAttribute PriceLine priceLine , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<PriceLine> priceLines = priceLineService.priceLineQuery(requestContext,priceLine,page,pageSize);
		return new ResponseData(priceLines);
	}
	/**
     * property基础信息保存更新 
     *
     * @param propertys 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceLine/priceLineSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData priceLineSubmit(@RequestBody List<PriceLine> priceLines , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(priceLines, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	try{
	        	PriceLine priceLine4 = new PriceLine();
	        	for (PriceLine priceLine3 : priceLines) {
	        		priceLine4.setFeeId(priceLine3.getFeeId());
	        		if(priceLineService.select(requestContext, priceLine4, 1, 100).size()>0){
	        			throw new ValidationTableException("hpms.fin.feelist.fee_exist_erorr", null);
	        		}
				}
        	}catch (ValidationTableException e){
    	        ResponseData responseData = new ResponseData(false);
    	        String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
    	                RequestContextUtils.getLocale(request));
    	        responseData.setMessage(errorMessage);
    	        return responseData;
            }
        	priceLines = priceLineService.batchUpdate(requestContext, priceLines);
        	PriceLine priceLine = new PriceLine();
        	List<PriceLine> priceLines2 = new ArrayList<PriceLine>();
        	for (PriceLine priceLine2 : priceLines) {
        		priceLine.setPriceHeaderId(priceLine2.getPriceHeaderId());
        		priceLines2.add(priceLineService.priceLineQuery(requestContext,priceLine,1,100).get(0));
			}
        	return new ResponseData(priceLines2);
        }
	}
	/**
     * 费项类型查询URL 
     *
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceLine/feeTypeQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeTypeQuery(HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		FeeType feeType = new FeeType();
		feeType.setEnableFlag("Y");
		List<FeeType> feeTypes = feeTypeService.select(requestContext, feeType, 1, 100);
		return new ResponseData(feeTypes);
	}
	/**
     * 费项查询URL 
     *
     * @param fee 费项对象
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceLine/feeQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeQuery(Long feeTypeId, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		Fee fee = new Fee();
		fee.setFeeTypeId(feeTypeId);
		fee.setEnableFlag("Y");
		List<Fee> fees = feeService.select(requestContext, fee, 1, 100);
		return new ResponseData(fees);
	}
	/**
     * 计算规则查询URL 
     *
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceLine/calculateRuleQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData calculateRuleQuery(HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		CalculateRule calculateRule = new CalculateRule();
		calculateRule.setEnableFlag("Y");
		List<CalculateRule> calculateRules = calculateRuleService.select(requestContext, calculateRule, 1, 100);
		return new ResponseData(calculateRules);
	}
}
