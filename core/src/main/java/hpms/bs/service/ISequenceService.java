package hpms.bs.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.Sequence;

import java.util.List;

/**
 * Created by LoseMyself on 2017/3/7.
 */
public interface ISequenceService extends IBaseService<Sequence>, ProxySelf<ISequenceService> {

    public boolean isDateOk(List<Sequence> sequences);
}
