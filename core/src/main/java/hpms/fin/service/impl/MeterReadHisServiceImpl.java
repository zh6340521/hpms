package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.mapper.MeterReadHisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.fin.dto.MeterReadHis;
import hpms.fin.service.IMeterReadHisService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeterReadHisServiceImpl extends BaseServiceImpl<MeterReadHis> implements IMeterReadHisService{
    @Autowired
    private MeterReadHisMapper meterReadHisMapper;

    @Override
    public List<MeterReadHis> queryMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return meterReadHisMapper.queryMeterReadHis(meterReadHis);
    }

}