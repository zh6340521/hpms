package hpms.fin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.fin.dto.DiscountDate;
import hpms.fin.mapper.DiscountDateMapper;
import hpms.fin.service.IDiscountDateService;


/**
 * @author huifang.zhou@hand-china.com
 * @version 1.0
 * @name DiscountDateServiceImpl
 * @description:应收优惠接口实现类
 * @date 2017/3/9
 */
@Service
public class DiscountDateServiceImpl extends BaseServiceImpl<DiscountDate> implements IDiscountDateService{
	@Autowired
	private DiscountDateMapper discountDateMapper;

	@Override
	public int queryCount(DiscountDate discountDate, IRequest requestContext) {
		return discountDateMapper.queryCount(discountDate);
	}

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

}
