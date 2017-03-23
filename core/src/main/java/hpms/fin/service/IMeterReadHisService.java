package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.dto.Code;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.MeterGradePrice;
import hpms.fin.dto.MeterReadHis;

import java.util.List;

public interface IMeterReadHisService extends IBaseService<MeterReadHis>, ProxySelf<IMeterReadHisService>{

    /**
     * 根据条件查询抄表历史记录
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param meterReadHis  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterReadHis> queryMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize);

    /**
     * 根据条件查询公表抄表历史记录
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param meterReadHis  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterReadHis> queryPubMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize);

    /**
     * 根据换表时的双放设备，将旧表的最新抄表记录插入新表种
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param equipmentId  旧表ID
     * @param changeEipmentId  新表ID
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterReadHis> changeMeterReadHis(IRequest requestContext, Long equipmentId, Long changeEipmentId);

    /**
     * 抄表时插入新的抄表记录，更新旧记录的newRecordFlag为N
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param equipmentId  旧表ID
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterReadHis> updateMeterHisOld(IRequest requestContext, Long equipmentId);

    /**
     * 根据条件查询近5年的年份
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param code  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<Code> 所有符合的结果集
     */
    List<Code> queryYear(IRequest requestContext, Code code, int page, int pagesize);

    /**
     * 根据条件查询12个月份
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param code  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<Code> 所有符合的结果集
     */
    List<Code> queryMonth(IRequest requestContext, Code code, int page, int pagesize);

    /**
     * 抄表时查询出符合条件的抄表
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param meterReadHis  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterReadHis> batchMeterReadHis(IRequest requestContext, MeterReadHis meterReadHis, int page, int pagesize);

    /**
     * 根据公司、项目、设备类型、用量找到价格
     * @author jun.zhao02@hand-china.com
     * @param requestContext  请求
     * @param meterGradePrice  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<MeterReadHis> 所有符合的结果集
     */
    List<MeterGradePrice> queryGradePrice(IRequest requestContext, MeterGradePrice meterGradePrice, int page, int pagesize);

}