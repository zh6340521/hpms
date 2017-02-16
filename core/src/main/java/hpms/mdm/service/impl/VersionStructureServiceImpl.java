package hpms.mdm.service.impl;/**
 * Created by user1 on 2017/2/15.
 */

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.VersionStructure;
import hpms.mdm.mapper.VersionStructureMapper;
import hpms.mdm.service.IVersionStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name VersionStructureServiceImpl
 * @description:结构版本接口实现类
 * @date 2017/2/15
 */
@Service
@Transactional
public class VersionStructureServiceImpl extends BaseServiceImpl<VersionStructure> implements IVersionStructureService {
    @Autowired
    private VersionStructureMapper versionStructureMapper;


    @Override
    public List<VersionStructure> findAllVersionStructure(VersionStructure vs, IRequest requestContext,int page,int pagesize) {
        PageHelper.startPage(page, pagesize);
        return versionStructureMapper.queryVersionStructure(vs);
    }
}
