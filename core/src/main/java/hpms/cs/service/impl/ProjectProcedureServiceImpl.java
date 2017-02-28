package hpms.cs.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.Procedure;
import hpms.cs.dto.ProjectProcedure;
import hpms.cs.mapper.ProcedureMapper;
import hpms.cs.mapper.ProjectProcedureMapper;
import hpms.cs.service.IProjectProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @name hpms.cs.service.impl.ProjectProcedureServiceImpl
 * @description 项目手续材料 service 接口实现类
 * @author feng.liu01@hand-china.com 2017/02/27
 * @version 1.0
 */

@Service
@Transactional
public class ProjectProcedureServiceImpl extends BaseServiceImpl<ProjectProcedure> implements IProjectProcedureService{

    @Autowired
    private ProjectProcedureMapper mapper;

    @Autowired
    private ProcedureMapper procedureMapper;

    @Override
    public List<ProjectProcedure> selectProcedureName(IRequest request, ProjectProcedure pp, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mapper.selectProcedureName(pp);
    }

    public List<ProjectProcedure> batchUpdateProcedure(
            IRequest request, List<ProjectProcedure> list){

        ProjectProcedure projectProcedure = new ProjectProcedure();
        projectProcedure.setProjectId(list.get(0).getProjectId());
        mapper.delete(projectProcedure);

        if (list.get(0).getConfigProcedureId()!=null){
            for (ProjectProcedure pp :
                    list) {
                Procedure procedure = new Procedure();
                procedure.setConfigProcedureId(pp.getConfigProcedureId());
                procedure = procedureMapper.selectOne(procedure);
                pp.setProcedureType(procedure.getProcedureType());

            }
        }
        return  super.batchUpdate(request,list);
    }
}