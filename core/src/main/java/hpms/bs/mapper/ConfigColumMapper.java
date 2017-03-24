package hpms.bs.mapper;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.ConfigColumn;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigColumMapper
 * @description
 * @date 2017/3/2
 */
public interface ConfigColumMapper extends Mapper<ConfigColumn> {

    //根据行号查询数据
    public List<ConfigColumn> findConfigColumnBydisplayLineNo(ConfigColumn c);

    /**
     * 查询字段名的唯一性
     * @param c
     * @return
     */
    List<ConfigColumn>  findUniqueConfigColumn(ConfigColumn c);
}