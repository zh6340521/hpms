package hpms.bs.mapper;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.ConfigValue;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigValueMapper
 * @description
 * @date 2017/3/1
 */
public interface ConfigValuesMapper extends Mapper<ConfigValue> {

    /**
     * 校验编码的唯一性
     * @param cv
     * @return
     */
    List<ConfigValue> findUnique(ConfigValue cv);


}