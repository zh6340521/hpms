package hpms.fin.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hpms.fin.dto.DiscountDate;
import hpms.fin.dto.Invoice;
import hpms.fin.service.IDiscountDateService;

@Controller
public class DiscountDateController extends BaseController{
	@Autowired
	private IDiscountDateService discountDateService;
	
	
	/**
     * 是否存在数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/hpms/fin/discountDate/queryCount")
    @ResponseBody
    public int queryCount(HttpServletRequest request,DiscountDate discountDate) {
    	IRequest requestCtx = createRequestContext(request);
        int itemNum = discountDateService.queryCount(discountDate, requestCtx);
        return itemNum;
    }
    
    @RequestMapping(value = "/hpms/fin/discountDate/query")
    @ResponseBody
    public ResponseData query(DiscountDate discountDate, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(discountDateService.queryDiscount(discountDate, requestContext, page, pageSize));
    }
    /**
     * 根据选择的优惠方案查到对应的费项类型
     * @param request
     * @return
     */
    @RequestMapping(value = "/hpms/fin/discountDate/queryName")
    @ResponseBody
    public ResponseData queryName(HttpServletRequest request,DiscountDate discountDate) {
    	IRequest requestCtx = createRequestContext(request);
    	discountDate = discountDateService.queryName(discountDate, requestCtx);
    	List<DiscountDate> dates = new ArrayList<DiscountDate>();
    	dates.add(discountDate);
        return new ResponseData(dates);
    }
    
    
    
    /**
     * 根据选择的优惠方案查到对应的费项类型
     * @param request
     * @return
     */
    @RequestMapping(value = "/hpms/fin/discountDate/querySum")
    @ResponseBody
    public ResponseData querySum(HttpServletRequest request,DiscountDate discountDate) {
    	IRequest requestCtx = createRequestContext(request);
    	discountDate = discountDateService.querySum(discountDate, requestCtx);
    	List<DiscountDate> dates = new ArrayList<DiscountDate>();
    	dates.add(discountDate);
        return new ResponseData(dates);
    }
    
    
    
    /**
     * 保存
     * @param request
     * @return
     */
    @RequestMapping(value = "/hpms/fin/discountDate/save")
    @ResponseBody
    public ResponseData save(HttpServletRequest request,@RequestBody List<DiscountDate> discountDates) {
    	IRequest requestCtx = createRequestContext(request);
    	/*discountDate = discountDateService.insert(requestCtx, discountDate);
    	List<DiscountDate> dates = new ArrayList<DiscountDate>();
    	dates.add(discountDate);*/
    	for(DiscountDate discountDate:discountDates ){
    		String todate=discountDate.getDiscountDateTo().substring(0, 7);
    		discountDate.setDiscountDateTo(todate);
    		
    	}
        return new ResponseData(discountDateService.batchUpdate(requestCtx, discountDates));
    }

}
