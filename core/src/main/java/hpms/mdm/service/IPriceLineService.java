package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.PriceLine;
/**
 * 
 * @name IPriceLineService
 * @description 定价表行Service
 * @author chengye.hu@hand-china.com	2017年2月20日下午4:03:50
 * @version 1.0
 */
public interface IPriceLineService extends IBaseService<PriceLine>,ProxySelf<PriceLine>{
	/**
     * 根据条件查询priceLine 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param priceLine  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<PriceLine> 所有符合的结果集
     */
	List<PriceLine> priceLineQuery(IRequest requestContext, PriceLine priceLine, int page, int pageSize);

}
