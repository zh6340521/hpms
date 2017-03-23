package hpms.fin.mapper;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.MeterShareResult;

import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name MeterShareResultMapper:公表分摊mapper
 * @description
 * @date 2017/3/20
 */

public interface MeterShareResultMapper extends Mapper<MeterShareResult> {

    /**
     * 查询公表分摊结果数据
     * @param msr
     * @return
     */
    List<MeterShareResult> findMeterShareResult(MeterShareResult msr);

    /**
     * 转入计费后改变状态
     * @param msr
     */
    void changeMeterShareResult(MeterShareResult msr);

    /**
     * 根据设备id和费用日期查询历史表数据
     * @param msr
     * @return
     */
    List<MeterShareResult> findMsrData(MeterShareResult msr);
}