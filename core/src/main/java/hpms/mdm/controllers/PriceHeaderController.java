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
import hpms.mdm.dto.PriceHeader;
import hpms.mdm.service.IPriceHeaderService;

/**
 * 
 * @name PriceHeaderController
 * @description 定价表头Controller
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:55:02
 * @version 1.0
 */
@Controller
public class PriceHeaderController extends BaseController{
	@Autowired
	private IPriceHeaderService priceHeaderService;
	/**
     * 根据条件查询priceHeader 
     *
     * @param priceHeader 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceHeader/priceHeaderQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData priceHeaderQuery(@ModelAttribute PriceHeader priceHeader , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<PriceHeader> priceHeaders = priceHeaderService.priceHeaderQuery(requestContext,priceHeader,page,pageSize);
		return new ResponseData(priceHeaders);
	}
	/**
     * property基础信息保存更新 
     *
     * @param propertys 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/priceHeader/priceHeaderSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData priceHeaderSubmit(@RequestBody List<PriceHeader> priceHeaders , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(priceHeaders, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	priceHeaders = priceHeaderService.batchUpdate(requestContext, priceHeaders);
        	PriceHeader priceHeader = new PriceHeader();
        	List<PriceHeader> priceHeaders2 = new ArrayList<PriceHeader>();
        	for (PriceHeader priceHeader2 : priceHeaders) {
        		priceHeader.setPriceHeaderId(priceHeader2.getPriceHeaderId());
        		priceHeaders2.add(priceHeaderService.priceHeaderQuery(requestContext,priceHeader,1,100).get(0));
			}
        	return new ResponseData(priceHeaders2);
        }
	}
}
