package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.SalesFinacial;
import hpms.mdm.mapper.SalesFinacialMapper;
import hpms.mdm.service.ISalesFinacialService;

@Service
@Transactional
public class SalesFinacialServiceImpl extends BaseServiceImpl<SalesFinacial> implements ISalesFinacialService{
	
	@Autowired
	private SalesFinacialMapper salesFinalcialMapper;

	@Override
	public List<SalesFinacial> selectByCustId(SalesFinacial sales, IRequest requestContext) {
		return salesFinalcialMapper.selectByCustId(sales);
	}

}
