package hpms.cs.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.cs.dto.ProjectProcedure;

import java.util.List;

/**
 * @name hpms.cs.mapper.ProjectProcedureMapper
 * @description 项目手续材料 mapper 类
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 */

public interface ProjectProcedureMapper extends Mapper<ProjectProcedure>{
    List<ProjectProcedure> selectProcedureName(ProjectProcedure pp);
}