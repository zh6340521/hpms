package hpms.mdm.mapper;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.VersionStructure;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name VersionStructureMapper
 * @description:结构版本mapper
 * @date 2017/2/15
 */
public interface VersionStructureMapper extends Mapper<VersionStructure> {

    /**
     * 根据版本id查询结果数据
     * @param versionId
     * @return
     */
    public List<VersionStructure> findVersionStructureByVersionId(Long versionId);

    /**
     * 查询全部版本结构信息
     * @param vs
     * @return
     */
    public List<VersionStructure> queryVersionStructure(VersionStructure vs);
    
    /*
     * 查询建筑类型为房间的相关信息
     */
    public List<VersionStructure> queryByStructureName(VersionStructure vs);
}