package hpms.mdm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.Fee;

import hpms.mdm.mapper.FeeMapper;

import hpms.mdm.service.IFeeService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeeServiceImpl extends BaseServiceImpl<Fee> implements IFeeService{
	@Autowired
    private FeeMapper feeMapper;
	
	@Override
    public List<Fee> findAllFee(Fee fee, IRequest requestContext,int page,int pagesize) {
        PageHelper.startPage(page, pagesize);
        return  feeMapper.queryFee(fee);
    }

	@Override
	public int queryCountByCode(IRequest requestContext, Fee fee) {
		
		return feeMapper.queryCountByCode(fee);
	}
}