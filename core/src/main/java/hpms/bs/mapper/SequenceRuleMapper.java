package hpms.bs.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.Sequence;

import java.util.Date;
import java.util.List;

/**
 * Created by LoseMyself on 2017/3/7.
 */
public interface SequenceRuleMapper extends Mapper<Sequence>{
    List<Sequence> getDate (String code);
}
