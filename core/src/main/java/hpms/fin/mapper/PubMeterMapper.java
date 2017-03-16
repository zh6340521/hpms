package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.PubMeter;
import java.util.List;

public interface PubMeterMapper extends Mapper<PubMeter>{

    List<PubMeter> queryPubMeter(PubMeter pubMeter);
    List<PubMeter> queryPubMeterInit(PubMeter pubMeter);
    List<PubMeter> queryPubMeterChange(PubMeter pubMeter);
}