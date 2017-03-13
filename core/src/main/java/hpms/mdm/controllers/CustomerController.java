package hpms.mdm.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.Customer;
import hpms.mdm.service.ICustomerService;


/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name CustomerController
 * @description:客户档案controller
 * @date 2017/2/17
 */
@Controller
public class CustomerController extends BaseController{
	
	@Autowired
	private ICustomerService customerService; 
   
   /**
   *
   * 根据选择的列名进行查询
   * @param bv
   * @param page
   * @param pageSize
   * @param request
   * @return
   */
  @RequestMapping(value = "/hpms/mdm/Customer/queryByColumnName")
  @ResponseBody
  public ResponseData queryByColumnName(String value,String selectCombox,@RequestParam(defaultValue = DEFAULT_PAGE) int page,
                            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
          IRequest requestContext = createRequestContext(request);
    	  return new ResponseData(customerService.selectByColumnName(value,selectCombox, requestContext, page, pageSize));
	
  }
  
  /**
  *
  * 修改记录状态
  * @param bv
  * @param page
  * @param pageSize
  * @param request
  * @return
  */
 @RequestMapping(value = "/hpms/mdm/Customer/updateByEnableFlag")
 @ResponseBody
 public ResponseData updateByEnableFlag(HttpServletRequest request,Customer customer) {
         IRequest requestContext = createRequestContext(request);
         String flag = customerService.queryByEnableFlag(customer.getCustomerId());
         if ("Y".equals(flag)) {
			customer.setEnableFlag("N");
		} else {
			customer.setEnableFlag("Y");
		}
         customerService.updateByPrimaryKeySelective(requestContext, customer);
         return new ResponseData();
	
 }
}
