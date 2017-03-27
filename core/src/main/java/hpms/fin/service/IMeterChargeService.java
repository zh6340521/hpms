package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.MeterCharge;
import hpms.mdm.dto.Project;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/14   9:21
 */
public interface IMeterChargeService extends IBaseService<MeterCharge>, ProxySelf<IMeterChargeService> {

    boolean isHaveEn(MeterCharge meterCharge);
    boolean isChange(MeterCharge meterCharge);
    List<Project> projectQuery(IRequest requestContext, Project project, int page, int pageSize);
}
