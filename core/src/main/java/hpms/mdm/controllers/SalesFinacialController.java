package hpms.mdm.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.SalesFinacial;
import hpms.mdm.service.ISalesFinacialService;
@Controller
public class SalesFinacialController extends BaseController{
	@Autowired
	private ISalesFinacialService salesFinacialService; 
	
	/**
    *
    * 根据选择的id进行查询
    * @param bv
    * @param page
    * @param pageSize
    * @param request
    * @return
    */
   @RequestMapping(value = "/hpms/mdm/SalesFinacial/queryByCustId")
   @ResponseBody
   public ResponseData queryBycustomerId(HttpServletRequest request,SalesFinacial sales) {
          IRequest requestContext = createRequestContext(request);
     	  return new ResponseData(salesFinacialService.selectByCustId(sales,requestContext));
 	
   }
   
   
   /**
    * SalesFinacial销售信息更新 
    *
    * @param salesFinacial 封装参数对象
    * @param result      校验
    * @param request   请求
    * @return ResponseData 符合的对象集合以及其它信息所封装的对象
    */
	@RequestMapping(value = "/hpms/mdm/SalesFinacial/salesFinacialSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData priceHeaderSubmit(HttpServletRequest request,@RequestBody List<SalesFinacial> salesFinacial,BindingResult result){
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(salesFinacialService.batchUpdate(requestContext, salesFinacial));
	}

}
