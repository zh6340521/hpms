package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hap.system.dto.Code;
import hpms.cs.dto.Occupation;
import hpms.fin.dto.CusMeterReadHis;


import java.util.List;

public interface CusMeterReadHisMapper extends Mapper<CusMeterReadHis>{
    List<CusMeterReadHis> queryCusMeterReadHis(CusMeterReadHis cusmeterReadHis);

    Occupation queryOccupationIn(CusMeterReadHis cusmeterReadHis);

    /**
     * 查询客户仪表批量录入时抄表
     * @author jun.guo@hand-china.com
     * 2017年3月22日 11:00:00
     * @param cusMeterReadHis
     * @return
     */
    List<CusMeterReadHis> batchCusMeterReadHis(CusMeterReadHis meterReadHis);

}