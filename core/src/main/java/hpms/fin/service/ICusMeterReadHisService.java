package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.CusMeterReadHis;

import java.util.List;

public interface ICusMeterReadHisService extends IBaseService<CusMeterReadHis>, ProxySelf<ICusMeterReadHisService>{

    List<CusMeterReadHis> queryMeterReadHis(IRequest requestContext, CusMeterReadHis meterReadHis, int page, int pagesize);
    List<CusMeterReadHis> changeMeterReadHis(IRequest requestContext,List<CusMeterReadHis> cusMeterReadHises);
    /**
     * 抄表时查询出符合条件的抄表
     * @author jun.guo@hand-china.com
     * @param requestContext  请求
     * @param cusMeterReadHis  封装参数对象
     * @param page     查询页
     * @param pagesize 页面大小
     * @return List<CusMeterReadHis> 所有符合的结果集
     */
    List<CusMeterReadHis> batchMeterReadHis(IRequest requestContext, CusMeterReadHis meterReadHis, int page, int pagesize);
}