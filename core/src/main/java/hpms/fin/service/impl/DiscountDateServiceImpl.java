package hpms.fin.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.fin.dto.DiscountDate;
import hpms.fin.dto.FeeList;
import hpms.fin.mapper.DiscountDateMapper;
import hpms.fin.mapper.FeeListMapper;
import hpms.fin.service.IDiscountDateService;


/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name DiscountDateServiceImpl
 * @description:应收优惠接口实现类
 * @date 2017/3/9
 */
@Service
@Transactional
public class DiscountDateServiceImpl extends BaseServiceImpl<DiscountDate> implements IDiscountDateService{
	@Autowired
	private DiscountDateMapper discountDateMapper;
	
	@Autowired
	private FeeListMapper feeListMapper;

	@Override
	public DiscountDate queryName(DiscountDate discountDate, IRequest requestContext) {
		return discountDateMapper.queryName(discountDate);
	}

	@Override
	public DiscountDate querySum(DiscountDate discountDate, IRequest requestContext) {
		return discountDateMapper.querySum(discountDate);
	}

	@Override
	public List<DiscountDate> queryDiscount(DiscountDate discountDate, IRequest requestContext, int page,
			int pagesize) {
		PageHelper.startPage(page, pagesize);
		return discountDateMapper.queryDiscount(discountDate);
	}

	@Override
	public List<DiscountDate> updateFeeList(List<DiscountDate> discountDates, IRequest requestContext) {
		for(DiscountDate discountDate:discountDates ){
    		String todate=discountDate.getDiscountDateTo().substring(0, 7);
    		discountDate.setDiscountDateTo(todate);
    	}
		discountDates = self().batchUpdate(requestContext, discountDates);
		DiscountDate discountDate = discountDates.get(0);
		List<FeeList> queryDate = discountDateMapper.queryFeeListId(discountDate);
		for (FeeList fee : queryDate) {
			//优惠金额,当前优惠除以条数-均分优惠
			Float amount =discountDate.getAdjAmount() / queryDate.size();
			fee.setAdjAmount(amount);
			fee.setTotalAmount(fee.getGrossAmount()-amount);
			feeListMapper.updateByPrimaryKeySelective(fee);
		}
		return discountDates;
	}

}
