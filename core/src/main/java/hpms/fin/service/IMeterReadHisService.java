package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.dto.Code;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.MeterReadHis;

import java.util.List;

public interface IMeterReadHisService extends IBaseService<MeterReadHis>, ProxySelf<IMeterReadHisService>{
    List<MeterReadHis> queryMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize);

    List<MeterReadHis> changeMeterReadHis(IRequest requestContext, Long equipmentId, Long changeEipmentId);

    List<Code> queryYear(IRequest requestContext, Code code, int page, int pagesize);

    List<Code> queryMonth(IRequest requestContext, Code code, int page, int pagesize);

    List<MeterReadHis> batchMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize);

}