package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.mapper.ConfigColumMapper;
import hpms.bs.service.IConfigColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigColumnServiceImpl
 * @description
 * @date 2017/3/2
 */
@Service
@Transactional
public class ConfigColumnServiceImpl extends BaseServiceImpl<ConfigColumn> implements IConfigColumnService {
    @Autowired
    private ConfigColumMapper configColumMapper;
}
