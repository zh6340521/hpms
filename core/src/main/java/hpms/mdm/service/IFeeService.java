package hpms.mdm.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.mdm.dto.Fee;


public interface IFeeService extends IBaseService<Fee>, ProxySelf<IFeeService>{

	
	/**
     * 查询全部收费项目
     * @param fee
     * @return
     */
    public List<Fee> findAllFee(Fee fee,IRequest requestContext,int page,int pagesize);
    
    public int queryCountByCode(IRequest requestContext,Fee fee);
}