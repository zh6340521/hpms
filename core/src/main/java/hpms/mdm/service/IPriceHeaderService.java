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

	List<PriceHeader> priceHeaderQuery(IRequest requestContext, PriceHeader priceHeader, int page, int pageSize);

}
