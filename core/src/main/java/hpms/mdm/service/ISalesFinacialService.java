package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.mdm.dto.SalesFinacial;



public interface ISalesFinacialService extends IBaseService<SalesFinacial>,ProxySelf<ISalesFinacialService>{
	/**
	 * 根据id查询
	 * @param bpgeneral
	 * @return
	 */
	public List<SalesFinacial> selectByCustId(SalesFinacial sales,IRequest requestContext);
}
