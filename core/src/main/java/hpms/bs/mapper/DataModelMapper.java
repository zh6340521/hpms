package hpms.bs.mapper;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.DataModel;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelMapper
 * @description
 * @date 2017/2/28
 */
public interface DataModelMapper extends Mapper<DataModel> {
    /**
     * 查询数据库中数据表名
     * @param d
     * @return
     */
    public List<DataModel> countTableName(DataModel d);

    /**
     * 查询数据库中的编码
     * @param d
     * @return
     */
    public List<DataModel> countModelCode(DataModel d);

    /**
     * 删除数据
     * @param d
     * @return
     */
    public int deleteDataModel(DataModel d);

    /**
     * 查询数据模型
     * @param d
     * @return
     */
    public List<DataModel> findDataModel(DataModel d);
}