package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hap.system.dto.Code;
import hpms.fin.dto.MeterReadHis;

import java.util.List;

public interface MeterReadHisMapper extends Mapper<MeterReadHis>{
    List<MeterReadHis> queryMeterReadHis(MeterReadHis meterReadHis);
    List<Code> queryYear(Code code);
    List<Code> queryMonth(Code code);
    List<MeterReadHis> batchMeterReadHis(MeterReadHis meterReadHis);
}