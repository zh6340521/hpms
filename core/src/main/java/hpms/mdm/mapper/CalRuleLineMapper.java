package hpms.mdm.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.CalRuleLine;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/21
 * @version 1.0
 * @name hpms.mdm.mapper.CalRuleLineMapper
 * @description 计费规则行数据 mapper 类
 */

public interface CalRuleLineMapper extends Mapper<CalRuleLine> {

    /**
     * 与计算要素表 (HPMS_MDM_CALCULATE_ELEMENT) 连接查询出 计算要素名称(elementName)
     * @param calRuleLine
     * @return
     */
    List<CalRuleLine> selectElementName(CalRuleLine calRuleLine);
}