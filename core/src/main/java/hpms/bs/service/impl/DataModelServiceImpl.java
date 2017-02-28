package hpms.bs.service.impl;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.DataModel;
import hpms.bs.service.IDataModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name DataModelServiceImpl
 * @description
 * @date 2017/2/28
 */
@Service
@Transactional
public class DataModelServiceImpl extends BaseServiceImpl<DataModel> implements IDataModelService {
}
