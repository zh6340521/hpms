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

    /**
     * 关联查询
     * @param requestContext
     * @param dto
     * @param page
     * @param pageSize
     * @return
     */
    List<ReceiptFeeList> selectFeeList(IRequest requestContext, ReceiptFeeList dto, int page, int pageSize);

    List<Receipt> updateReceipt(IRequest requestCtx, Receipt receipt);

    List<Receipt> selectReceipt(IRequest requestCtx,ReceiptFeeList receiptFeeList, int page, int pageSize);
}