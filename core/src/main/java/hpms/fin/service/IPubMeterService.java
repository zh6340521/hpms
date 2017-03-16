package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.PubMeter;

import java.util.List;

public interface IPubMeterService extends IBaseService<PubMeter>, ProxySelf<IPubMeterService> {

    List<PubMeter> queryPubMeter(IRequest requestContext, PubMeter pubMeter, int page, int pagesize);
    List<PubMeter> queryPubMeterInit(IRequest requestContext, PubMeter pubMeter, int page, int pagesize);
    List<PubMeter> queryPubMeterChange(IRequest requestContext, PubMeter pubMeter, int page, int pagesize);

}