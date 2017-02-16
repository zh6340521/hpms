package hpms.mdm.service.impl;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.service.IBuildingVersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersionServiceImpl
 * @description:建筑版本接口实现类
 * @date 2017/2/15
 */
@Service
@Transactional
public class BuildingVersionServiceImpl extends BaseServiceImpl<BuildingVersion> implements IBuildingVersionService {


}
