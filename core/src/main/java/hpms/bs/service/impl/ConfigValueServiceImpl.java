package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.ConfigValue;
import hpms.bs.mapper.ConfigValuesMapper;
import hpms.bs.service.IConfigValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigValueServiceImpl
 * @description
 * @date 2017/3/1
 */
@Service
@Transactional
public class ConfigValueServiceImpl extends BaseServiceImpl<ConfigValue> implements IConfigValueService {
    @Autowired
    private ConfigValuesMapper configValuesMapper;
}
