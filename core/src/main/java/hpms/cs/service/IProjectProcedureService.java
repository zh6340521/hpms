package hpms.cs.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.cs.dto.ProjectProcedure;

import java.util.List;

/**
 * @name hpms.cs.service.IProjectProcedureService
 * @description 项目手续材料 service 接口类
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 */

public interface IProjectProcedureService extends IBaseService<ProjectProcedure>, ProxySelf<IProjectProcedureService> {

    /**
     * 联合查询出材料名称
     * @param request
     * @param pp
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProjectProcedure> selectProcedureName(IRequest request, ProjectProcedure pp, int pageNum, int pageSize);

    List<ProjectProcedure> batchUpdateProcedure(IRequest request, List<ProjectProcedure> list);
}