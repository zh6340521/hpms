package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.Code;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.MeterGradePrice;
import hpms.fin.mapper.MeterReadHisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    public List<MeterReadHis> queryPubMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return meterReadHisMapper.queryPubMeterReadHis(meterReadHis);
    }

    @Override
    public List<MeterReadHis> changeMeterReadHis(IRequest requestContext, Long equipmentId, Long changeEipmentId) {
        MeterReadHis mrh = new MeterReadHis();
        mrh.setEquipmentId(equipmentId);
        mrh.setNewRecordFlag("Y");
        List<MeterReadHis> mList = meterReadHisMapper.queryMeterReadHis(mrh);
        for (MeterReadHis k:mList ) {
            k.setEquipmentId(changeEipmentId);
            k.set__status("add");
        }
        return batchUpdate(requestContext, mList);
    }

    @Override
    public List<MeterReadHis> updateMeterHisOld(IRequest requestContext, Long equipmentId) {
        MeterReadHis mrh = new MeterReadHis();
        mrh.setEquipmentId(equipmentId);
        mrh.setNewRecordFlag("Y");
        List<MeterReadHis> mList = meterReadHisMapper.queryMeterReadHis(mrh);
        for (MeterReadHis k:mList ) {
            k.setNewRecordFlag("N");
            k.set__status("update");
        }
        return batchUpdate(requestContext, mList);
    }

    @Override
    public List<Code> queryYear(IRequest requestContext, Code code, int page, int pagesize) {
        return meterReadHisMapper.queryYear(code);
    }

    @Override
    public List<Code> queryMonth(IRequest requestContext, Code code, int page, int pagesize) {
        return meterReadHisMapper.queryMonth(code);
    }

    @Override
    public List<MeterReadHis> batchMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return meterReadHisMapper.batchMeterReadHis(meterReadHis);
    }

    @Override
    public List<MeterGradePrice> queryGradePrice(IRequest requestContext, MeterGradePrice meterGradePrice, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return meterReadHisMapper.queryGradePrice(meterGradePrice);
    }

}