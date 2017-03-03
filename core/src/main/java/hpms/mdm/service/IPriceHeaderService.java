package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.PriceHeader;
/**
 * 
 * @name IPriceHeaderService
 * @description 定价表Service
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:57:32
 * @version 1.0
 */
public interface IPriceHeaderService extends IBaseService<PriceHeader>,ProxySelf<PriceHeader>{
	/**
     * 根据条件查询priceHeader 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param priceHeader  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<PriceHeader> 所有符合的结果集
     */
	List<PriceHeader> priceHeaderQuery(IRequest requestContext, PriceHeader priceHeader, int page, int pageSize);

}
