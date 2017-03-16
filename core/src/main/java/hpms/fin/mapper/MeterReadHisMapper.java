package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.MeterReadHis;

import java.util.List;

public interface MeterReadHisMapper extends Mapper<MeterReadHis>{
    List<MeterReadHis> queryMeterReadHis(MeterReadHis meterReadHis);
}