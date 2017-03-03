package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.PriceHeader;
import hpms.mdm.mapper.PriceHeaderMapper;
import hpms.mdm.service.IPriceHeaderService;
/**
 * 
 * @name PriceHeaderServiceImpl
 * @description 定价表头Impl
 * @author chengye.hu@hand-china.com	2017年2月20日下午3:59:45
 * @version 1.0
 */
@Service
public class PriceHeaderServiceImpl extends BaseServiceImpl<PriceHeader> implements IPriceHeaderService{
	@Autowired
	private PriceHeaderMapper priceHeaderMapper;
	
	@Override
	public List<PriceHeader> priceHeaderQuery(IRequest requestContext, PriceHeader priceHeader, int page,
			int pageSize) {
		PageHelper.startPage(page, pageSize);
		return priceHeaderMapper.priceHeaderQuery(priceHeader);
	}

}
