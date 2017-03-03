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
 * @name DiscountProController
 * @description 优惠方案Controller
 * @author chengye.hu@hand-china.com	2017年2月24日上午10:30:14
 * @version 1.0
 */
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.DiscountPro;
import hpms.mdm.service.IDiscountProService;
@Controller
public class DiscountProController extends BaseController{
	@Autowired
	private IDiscountProService discountProService;
	/**
     * 根据条件查询discountPro 
     *
     * @param discountPro 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/discountPro/discountProQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData discountProQuery(@ModelAttribute DiscountPro discountPro , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<DiscountPro> discountPros = discountProService.discountProQuery(requestContext,discountPro,page,pageSize);
		return new ResponseData(discountPros);
	}
	/**
     * discountPro基础信息保存更新 
     *
     * @param discountPros 封装参数对象
     * @param result      校验
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/mdm/discountPro/discountProSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData discountProSubmit(@RequestBody List<DiscountPro> discountPros , BindingResult result ,HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		getValidator().validate(discountPros, result);
		if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }else{
        	discountPros = discountProService.batchUpdate(requestContext, discountPros);
        	DiscountPro discountPro = new DiscountPro();
        	List<DiscountPro> discountPros2 = new ArrayList<DiscountPro>();
        	for (DiscountPro discountPro2 : discountPros) {
        		discountPro.setDiscountProId(discountPro2.getDiscountProId());
        		discountPros2.add(discountProService.discountProQuery(requestContext,discountPro,1,100).get(0));
			}
        	return new ResponseData(discountPros2);
        }
	}
}
