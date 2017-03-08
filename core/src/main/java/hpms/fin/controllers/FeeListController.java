package hpms.fin.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import hpms.fin.dto.FeeList;
import hpms.fin.dto.FeeListNew;
import hpms.fin.service.IFeeListService;
import hpms.mdm.dto.BuildingVersion;
import hpms.utils.ValidationTableException;
/**
 * 
 * @name FeeListController
 * @description 应收费用清单Controller
 * @author chengye.hu@hand-china.com	2017年2月27日下午4:14:08
 * @version 1.0
 */
@Controller
public class FeeListController extends BaseController{
	@Autowired
	private IFeeListService feeListService;
	/**
     * 根据条件查询feeList 
     *
     * @param feeList 封装参数对象
     * @param page      查询页
     * @param pageSize  页面大小
     * @param request   请求
     * @return ResponseData 符合的对象集合以及其它信息所封装的对象
     */
	@RequestMapping(value = "/fin/feeList/feeListQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeListQuery(@ModelAttribute FeeList feeList , @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		List<FeeList> feeLists = feeListService.feeListQuery(requestContext,feeList,page,pageSize);
		return new ResponseData(feeLists);
	}
	
	@RequestMapping(value = "/fin/feeList/feeListUpdate" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeListUpdate(@RequestBody List<FeeList> feeLists , String operation ,  HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		feeLists = feeListService.feeListUpdate(requestContext ,feeLists ,operation);
		return new ResponseData(feeLists);
	}
	
	@RequestMapping(value = "/fin/feeList/structureQuery" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData structureQuery(@ModelAttribute BuildingVersion buildingVersion , HttpServletRequest request){
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(feeListService.structureQuery(buildingVersion, requestContext));
	}
	
	@RequestMapping(value = "/fin/feeList/preview" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeListPreview(@ModelAttribute FeeListNew feeListNew , HttpServletRequest request) throws Exception{
		IRequest requestContext = createRequestContext(request);
		try{
			if(feeListNew.getFeeId()!=null){
				return new ResponseData(feeListService.feeListPreview(feeListNew, requestContext));
			}else{
				return new ResponseData(false);
			}
			/*if(feeListNew.getFeeId()!=null){
				List<FeeList> feeLists = feeListService.feeListQuery(requestContext,null,1,100);
				return new ResponseData(feeLists);
			}else{
				return null;
			}*/
		}catch (ValidationTableException e){
	        ResponseData responseData = new ResponseData(false);
	        String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
	                RequestContextUtils.getLocale(request));
	        responseData.setMessage(errorMessage);
	        return responseData;
        }
	}
	@RequestMapping(value = "/fin/feeList/feeListSubmit" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseData feeListSubmit(@RequestBody List<FeeList> feeLists , HttpServletRequest request) throws Exception{
		IRequest requestContext = createRequestContext(request);
		feeListService.feeListSubmit(requestContext,feeLists);
		return new ResponseData();
	}
}
