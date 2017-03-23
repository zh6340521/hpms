package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hap.system.dto.Code;
import hpms.fin.dto.MeterGradePrice;
import hpms.fin.dto.MeterReadHis;

import java.util.List;

public interface MeterReadHisMapper extends Mapper<MeterReadHis>{
    /**
     * 查询抄表历史数据
     * @author jun.zhao02@hand-china.com
     * 2017年3月14日 11:00:00
     * @param meterReadHis
     * @return
     */
    List<MeterReadHis> queryMeterReadHis(MeterReadHis meterReadHis);

    /**
     * 查询公表抄表历史数据
     * @author jun.zhao02@hand-china.com
     * 2017年3月14日 11:00:00
     * @param meterReadHis
     * @return
     */
    List<MeterReadHis> queryPubMeterReadHis(MeterReadHis meterReadHis);

    /**
     * 查询近5年的年份
     * @author jun.zchao02@hand-china.com
     * 2017年3月14日 11:00:00
     * @param code
     * @return
     */
    List<Code> queryYear(Code code);

    /**
     * 查询近12个月
     * @author jun.zchao02@hand-china.com
     * 2017年3月14日 11:00:00
     * @param code
     * @return
     */
    List<Code> queryMonth(Code code);

    /**
     * 查询公表批量录入时抄表
     * @author jun.zchao02@hand-china.com
     * 2017年3月14日 11:00:00
     * @param meterReadHis
     * @return
     */
    List<MeterReadHis> batchMeterReadHis(MeterReadHis meterReadHis);


    /**
     * 查询抄表历史数据 根据开始月份和结束月份
     * @author fuchun.hu@hand-china.com
     * 2017年3月21日 17:20:20
     * @param meterReadHis
     * @return
     */
    List<MeterReadHis> queryMeterReadHisForMsr(MeterReadHis meterReadHis);

    /**
     * 根据公司、项目、设备类型、用量找到价格
     * @author jun.zhao02@hand-china.com
     * 2017年3月22日 10:29:00
     * @param meterGradePrice
     * @return
     */
    List<MeterGradePrice> queryGradePrice(MeterGradePrice meterGradePrice);
}