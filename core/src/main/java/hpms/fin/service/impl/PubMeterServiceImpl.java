package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.PubMeter;
import hpms.fin.mapper.PubMeterMapper;
import hpms.fin.service.IPubMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PubMeterServiceImpl extends BaseServiceImpl<PubMeter> implements IPubMeterService {
    @Autowired
    private PubMeterMapper pubMeterMapper;

    @Override
    public List<PubMeter> queryPubMeter(IRequest requestContext, PubMeter pubMeter, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return pubMeterMapper.queryPubMeter(pubMeter);
    }

    @Override
    public List<PubMeter> queryPubMeterInit(IRequest requestContext, PubMeter pubMeter, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return pubMeterMapper.queryPubMeterInit(pubMeter);
    }

    @Override
    public List<PubMeter> queryPubMeterChange(IRequest requestContext, PubMeter pubMeter, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return pubMeterMapper.queryPubMeterChange(pubMeter);
    }
}