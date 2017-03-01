package hpms.mdm.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.Fee;


public interface FeeMapper extends Mapper<Fee>{
	 public List<Fee> queryFee(Fee fee);
	 
	 public int queryCountByCode(Fee fee);

	public Long queryCountItemFlag();
}