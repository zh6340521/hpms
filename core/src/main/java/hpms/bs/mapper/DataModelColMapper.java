package hpms.bs.mapper;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.bs.dto.DataModelCol;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelColMapper
 * @description
 * @date 2017/2/28
 */
public interface DataModelColMapper extends Mapper<DataModelCol> {

    /**
     * 查询字段名唯一性校验
     * @param dmc
     * @return
     */
    public List<DataModelCol> countColumnName(DataModelCol dmc);

    /**
     * lov查询字段名
     * @param dmc
     * @return
     */
    public List<DataModelCol> findColumnNameForLov(DataModelCol dmc);

    /**
     * 根据头表id删除
     * @param dmc
     * @return
     */
    public int deleteDataModelCol(DataModelCol dmc);

    /**
     * 查询行表数据
     * @param dmc
     * @return
     */
    public List<DataModelCol> findDataModelCol(DataModelCol dmc);


}