package hpms.mdm.mapper;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.BuildingVersion;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersionMapper
 * @description:建筑版本mapper
 * @date 2017/2/15
 */
public interface BuildingVersionMapper extends Mapper<BuildingVersion> {

    /**
     * 查询表中是否存在默认版本
     * @return
     */
    public List<BuildingVersion> findDefaultVersion(BuildingVersion bv);

    /**
     * 查询建筑版本数据
     * @param bv
     * @return
     */
    public List<BuildingVersion> selectBuildingVersion(BuildingVersion bv);




}