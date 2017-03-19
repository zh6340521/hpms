package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.Receipt;
import hpms.fin.dto.ReceiptFeeList;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/08
 * @version 1.0
 * @name hpms.fin.service.IReceiptService
 * @description 收款录入 service 接口类
 */

public interface IReceiptService extends IBaseService<Receipt>, ProxySelf<IReceiptService> {

    List<Receipt> updateReceipt(IRequest requestCtx, Receipt receipt);


    /**
     * 关联查询
     * @param requestCtx
     * @param receiptFeeList
     * @param page
     * @param pageSize
     * @return
     */
    List<Receipt> selectReceipt(IRequest requestCtx,ReceiptFeeList receiptFeeList, int page, int pageSize);
}