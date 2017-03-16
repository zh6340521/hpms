package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.Receipt;
import hpms.fin.dto.ReceiptFeeList;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/08
 * @version 1.0
 * @name hpms.fin.mapper.ReceiptMapper
 * @description 收款录入 mapper 类
 */

public interface ReceiptMapper extends Mapper<Receipt> {
    List<ReceiptFeeList> selectFeeList(ReceiptFeeList receiptFeeList);

    List<Receipt> selectReceipt(ReceiptFeeList receiptFeeList);
}