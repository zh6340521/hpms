package hpms.cs.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.cs.dto.Occupation;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.mapper.OccupationMapper
 * @description 入退伙 mapper 类
 */

public interface OccupationMapper extends Mapper<Occupation> {
    List<Occupation> propertyQuery(Occupation occupation);
}