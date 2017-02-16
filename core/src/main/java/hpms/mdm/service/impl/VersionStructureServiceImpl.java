package hpms.mdm.service.impl;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.VersionStructure;
import hpms.mdm.service.IVersionStructureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
