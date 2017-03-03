package hpms.bs.mapper;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.Config;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigMapper
 * @description
 * @date 2017/3/1
 */
public interface ConfigMapper extends Mapper<Config> {

    /**
     * 查询配置表的数据
     * @param c
     * @return
     */
    public List<Config> findAllConfig(Config c);
}