package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.PriceLine;
import hpms.mdm.mapper.PriceLineMapper;
import hpms.mdm.service.IPriceLineService;
/**
 * 
 * @name PriceLineServiceImpl
 * @description 定价表行Impl
 * @author chengye.hu@hand-china.com	2017年2月20日下午4:05:17
 * @version 1.0
 */
@Service
public class PriceLineServiceImpl extends BaseServiceImpl<PriceLine> implements IPriceLineService{
	@Autowired
	private PriceLineMapper priceLineMapper;
	@Override
	public List<PriceLine> priceLineQuery(IRequest requestContext, PriceLine priceLine, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return priceLineMapper.priceLineQuery(priceLine);
	}

}
