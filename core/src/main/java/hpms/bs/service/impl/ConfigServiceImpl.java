package hpms.bs.service.impl;/**
 * Created by user1 on 2017/3/1.
 */

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.Config;
import hpms.bs.mapper.ConfigMapper;
import hpms.bs.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigServiceImpl
 * @description
 * @date 2017/3/1
 */
@Service
@Transactional
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements IConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<Config> selectAllConfig(IRequest requestContext, Config c,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Config> cList = configMapper.findAllConfig(c);
        return cList;
    }
}
