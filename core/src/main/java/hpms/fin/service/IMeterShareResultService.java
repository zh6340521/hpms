package hpms.fin.service;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterShareResult;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IMeterShareResultService:公表分摊结果service
 * @description
 * @date 2017/3/20
 */
public interface IMeterShareResultService extends IBaseService<MeterShareResult>, ProxySelf<IMeterShareResultService> {

    /**
     * 根据项目选择有效的仪表类型
     * @param meterCharge
     * @return
     */
    List<MeterCharge> findEquipmentTypeByMeterCharge(MeterCharge meterCharge,IRequest requestContext);
}