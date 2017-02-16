package hpms.mdm.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hpms.mdm.dto.Project;
import hpms.mdm.service.IProjectService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements IProjectService{

}