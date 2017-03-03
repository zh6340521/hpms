package hpms.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.mdm.dto.DiscountPro;
import hpms.mdm.mapper.DiscountProMapper;
import hpms.mdm.service.IDiscountProService;
/**
 * 
 * @name DiscountProServiceImpl
 * @description 优惠方案Impl
 * @author chengye.hu@hand-china.com	2017年2月24日上午10:35:58
 * @version 1.0
 */
@Controller
public class DiscountProServiceImpl extends BaseServiceImpl<DiscountPro> implements IDiscountProService{
	@Autowired
	private DiscountProMapper discountProMapper;
	@Override
	public List<DiscountPro> discountProQuery(IRequest requestContext, DiscountPro discountPro, int page,
			int pageSize) {
		PageHelper.startPage(page, pageSize);
		return discountProMapper.discountProQuery(discountPro);
	}

}
