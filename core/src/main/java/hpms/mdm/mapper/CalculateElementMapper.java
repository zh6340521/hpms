package hpms.mdm.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.CalculateElement;

import java.util.List;

/**
 * @name hpms.mdm.mapper.CalculateElementMapper
 * @description 计算要素 mapper 类
 * @author feng.liu01@hand-china.com 2017/02/20
 * @version 1.0
 */

public interface CalculateElementMapper extends Mapper<CalculateElement> {

    List<CalculateElement> selectTables(CalculateElement element);

    List<CalculateElement> selectColumns(CalculateElement element);
}