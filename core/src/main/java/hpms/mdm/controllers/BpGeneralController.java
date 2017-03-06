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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;

import hpms.mdm.dto.BpGeneral;
import hpms.mdm.dto.CalculateElement;
import hpms.mdm.dto.Customer;
import hpms.mdm.dto.Relation;
import hpms.mdm.dto.SalesFinacial;

import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.service.IBpGeneralService;
import hpms.mdm.service.ISalesFinacialService;



@Controller
public class BpGeneralController extends BaseController{
	
	@Autowired
	private IBpGeneralService bpGeneralService;
	
	@Autowired
    private ISalesFinacialService salesFinacialService;
    
	/**
	 * 保存一般信息tab页
	 * @param request
	 * @param customer
	 * @param result
	 * @return
	 */
    @RequestMapping(value = "/hpms/mdm/BpGeneral/submit")
    @ResponseBody
    public ResponseData submit(HttpServletRequest request,@RequestBody Customer customer,BindingResult result){
			IRequest requestCtx = createRequestContext(request);
			bpGeneralService.submitBpGeneral(requestCtx, customer);
			List<Customer> custs = new ArrayList<Customer>();
			custs.add(customer);
			return new ResponseData(custs);
    }
    /**
	 * 保存一般信息tab页
	 * @param request
	 * @param customer
	 * @param result
	 * @return
	 */
    @RequestMapping(value = "/hpms/mdm/BpGeneral/update")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody BpGeneral bpGeneral,BindingResult result){
			IRequest requestCtx = createRequestContext(request);
			bpGeneralService.updateByPrimaryKey(requestCtx, bpGeneral);
			return new ResponseData();
    }
    
    
    
    /**
	 * 保存销售tab页
	 * @param request
	 * @param customer
	 * @param result
	 * @return
	 */
    @RequestMapping(value = "/hpms/mdm/BpGeneral/submitSales")
    @ResponseBody
    public ResponseData saveSales(HttpServletRequest request,@RequestBody SalesFinacial sales,BindingResult result){
			IRequest requestCtx = createRequestContext(request);
			salesFinacialService.insertSelective(requestCtx, sales);
			List<SalesFinacial> sale = new ArrayList<SalesFinacial>();
			sale.add(sales);
			return new ResponseData(sale);
    }
    
    
    
    
    /**
	 * 保存一般信息tab页
	 * @param request
	 * @param customer
	 * @param result
	 * @return
	 */
    @RequestMapping(value = "/hpms/mdm/BpGeneral/updateBpGeneral")
    @ResponseBody
    public ResponseData updateBpGeneral(HttpServletRequest request,@RequestBody BpGeneral bpgeneral,BindingResult result){
			IRequest requestCtx = createRequestContext(request);
			bpGeneralService.updateByPrimaryKey(requestCtx, bpgeneral);
			List<BpGeneral> bpgen = new ArrayList<BpGeneral>();
			bpgen.add(bpgeneral);
			return new ResponseData(bpgen);
    }
    
    
    /**
    *
    * 根据选择的id进行查询
    * @param bv
    * @param page
    * @param pageSize
    * @param request
    * @return
    */
   @RequestMapping(value = "/hpms/mdm/BpGeneral/queryBycustomerId")
   @ResponseBody
   public ResponseData queryBycustomerId(HttpServletRequest request,BpGeneral bpGeneral) {
          IRequest requestContext = createRequestContext(request);
     	  return new ResponseData(bpGeneralService.selectByCustomerId(bpGeneral,requestContext));
 	
   }
   
   
   
   /**
   *
   * 根据条件进行查询
   * @param bv
   * @param page
   * @param pageSize
   * @param request
   * @return
   */
  @RequestMapping(value = "/hpms/mdm/BpGeneral/queryBpGeneral")
  @ResponseBody
  public ResponseData queryBpGeneral(HttpServletRequest request,BpGeneral bpGeneral) {
         IRequest requestContext = createRequestContext(request);
    	  return new ResponseData(bpGeneralService.queryBpgeneral(bpGeneral, requestContext));
	
  }
  
  
  
  /**
  *
  * 根据条件进行查询
  * @param bv
  * @param page
  * @param pageSize
  * @param request
  * @return
  */
 @RequestMapping(value = "/hpms/mdm/BpGeneral/queryByReation")
 @ResponseBody
 public ResponseData queryByReation(HttpServletRequest request,BpGeneral bpGeneral,@RequestParam(defaultValue = DEFAULT_PAGE) int page,
         @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
        IRequest requestContext = createRequestContext(request);
   	  return new ResponseData(bpGeneralService.selectByRetaion(bpGeneral, requestContext, page, pageSize));
	
 }
 
}
