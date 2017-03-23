package hpms.fin.service;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterShareResult;
import hpms.utils.ValidationTableException;

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

    /**
     * 查询当前年份下拉框
     * @return
     */
    List<MeterShareResult> findYear();

    /**
     * 查询当前月份下拉框
     * @return
     */
    List<MeterShareResult> findMonth();

    /**
     * 批量更新
     * @param requestCtx
     * @param meterShareResultList
     */
    void myBatchUpdate(IRequest requestCtx, List<MeterShareResult> meterShareResultList) throws ValidationTableException;

    /**
     * 查询公表分摊结果数据
     * @param requestContext
     * @param msr
     * @param page
     * @param pageSize
     * @return
     */
    List<MeterShareResult> findAllMeterShareResult(IRequest requestContext,MeterShareResult msr,int page,int pageSize);

    /**
     * 转入计费
     * @param requestCtx
     * @param meterShareResultList
     */
    void changeStaus(IRequest requestCtx, List<MeterShareResult> meterShareResultList);


}