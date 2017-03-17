package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.FeeList;
import hpms.fin.dto.Receipt;
import hpms.fin.dto.ReceiptFeeList;
import hpms.fin.mapper.FeeListMapper;
import hpms.fin.mapper.ReceiptMapper;
import hpms.fin.service.IReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author feng.liu01@hand-china.com 2017/03/08
 * @version 1.0
 * @name hpms.fin.service.IReceiptService
 * @description 收款录入 service 接口实现类
 */

@Service
@Transactional
public class ReceiptServiceImpl extends BaseServiceImpl<Receipt> implements IReceiptService {

    @Autowired
    private ReceiptMapper mapper;

    @Autowired
    private FeeListMapper feeListMapper;

    @Override
    public List<Receipt> updateReceipt(IRequest requestCtx, Receipt receipt) {
        List<Receipt> receipts = new ArrayList<Receipt>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String receiptNum = sdf.format(new Date());

        Float receiptAmount = receipt.getReceiptAmount();

        Long lineNumber = 1L;

        if ("advanceReceivable".equals(receipt.getOperationType())){
            Receipt r = new Receipt();
            r.setReceiptAmount(-receiptAmount);

            r.setReceiptNum(receiptNum);
            r.setLineNumber(lineNumber++);

            r.setCompanyId(receipt.getCompanyId());
            r.setProjectId(receipt.getProjectId());
            r.setReceiptDate(receipt.getReceiptDate());
            r.setReceiptStatus(receipt.getReceiptStatus());

            r.setReceiptTerm(receipt.getReceiptTerm());
            r.setPayer(receipt.getPayer());
            r.setTransactor(receipt.getTransactor());
            r.setOccupationId(receipt.getOccupationId());

            r.setReceiptStatus("B");

            mapper.insertSelective(r);
            receipts.add(r);

        }

        if ("refund".equals(receipt.getOperationType())){

            Long receiptId = receipt.getReceiptId();

            receipt.setReceiptId(null);
            receipt.setReferenceNumber(receipt.getReceiptNum());
            receipt.setReceiptNum(receiptNum);
            receipt.setLineNumber(lineNumber);
            receipt.setReceiptStatus("C");
            mapper.insertSelective(receipt);

            Receipt r = new Receipt();
            r.setReceiptId(receiptId);
            r.setReferenceNumber(receiptNum);
            r.setReceiptStatus("C");
            mapper.updateByPrimaryKeySelective(r);
            receipts.add(r);

        } else if ("cancel".equals(receipt.getOperationType())){

            List<ReceiptFeeList> feeLists = receipt.getFeeLists();
            for (ReceiptFeeList feeList :
                    feeLists) {
                FeeList f = new FeeList();
                f.setFeeListId(feeList.getFeeListId());
                f.setFeeStatus("CREATED");
                feeListMapper.updateByPrimaryKeySelective(f);
            }

        }else {

            if ("C".equals(receipt.getReceiptStatus()) || "A".equals(receipt.getReceiptStatus())) {

                List<ReceiptFeeList> feeLists = receipt.getFeeLists();

                // 按照可结算金额排序

                feeLists.sort(new Comparator<ReceiptFeeList>() {
                    @Override
                    public int compare(ReceiptFeeList r1, ReceiptFeeList r2) {
                        return r1.getSettlementAmount().compareTo(r2.getSettlementAmount());
                    }
                });

                for (ReceiptFeeList feeList :
                        feeLists) {

                    if (receiptAmount <= 0){
                        break;
                    }

                    Receipt r = new Receipt();

                    // 获取可结算金额
                    Float settlementAmount = feeList.getSettlementAmount();

                    r.setReceiptNum(receiptNum);

                    r.setLineNumber(lineNumber++);

                    r.setCompanyId(receipt.getCompanyId());
                    r.setProjectId(receipt.getProjectId());
                    r.setReceiptDate(receipt.getReceiptDate());
                    r.setReceiptStatus(receipt.getReceiptStatus());

                    r.setReceiptTerm(r.getReceiptTerm());
                    r.setPayer(receipt.getPayer());
                    r.setTransactor(receipt.getTransactor());
                    r.setOccupationId(receipt.getOccupationId());


                    // 设置收款方式，如果feeList中有收款方式则从feeList中取值（添加费项收款）
                    if (feeList.getReceiptMethod()!=null){
                        r.setReceiptMethod(feeList.getReceiptMethod());
                    }else {
                        r.setReceiptMethod(receipt.getReceiptMethod());
                    }

                    r.setFeeListId(feeList.getFeeListId());
//            r.setOccupationId(feeList.getOccupationId());
                    r.setFeeTypeId(feeList.getFeeTypeId());
                    r.setFeeId(feeList.getFeeId());
                    r.setCurrency(feeList.getCurrencyType());
                    r.setReceiptPeriod(feeList.getFeePeriod());
                    r.setTransType(feeList.getTransType());

                    FeeList f = new FeeList();
                    f.setFeeListId(feeList.getFeeListId());
                    if (receiptAmount>=settlementAmount){
                        // 剩余收款金额大于等于可结算金额，已结算

                        f.setFeeStatus("SETTLEMENT");
                        r.setReceiptAmount(settlementAmount);

                    } else {
                        //剩余收款金额小于可结算金额，部分结算

                        f.setFeeStatus("PART_SETTLEMENT");
                        r.setReceiptAmount(receiptAmount);
                    }
                    receiptAmount -= settlementAmount;
                    BigDecimal bd = new BigDecimal(receiptAmount);
                    receiptAmount = bd.setScale(2,BigDecimal.ROUND_UP).floatValue();
                    mapper.insertSelective(r);
                    feeListMapper.updateByPrimaryKeySelective(f);
                    receipts.add(r);
                }
            } else if ("D".equals(receipt.getReceiptStatus())){
                receipt.setReceiptNum(receiptNum);

                receipt.setLineNumber(lineNumber);
                mapper.insertSelective(receipt);
                receipts.add(receipt);
            }

        }

        return receipts;
    }

    @Override
    public List<Receipt> selectReceipt(IRequest requestCtx, ReceiptFeeList receiptFeeList, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return mapper.selectReceipt(receiptFeeList);
    }
}