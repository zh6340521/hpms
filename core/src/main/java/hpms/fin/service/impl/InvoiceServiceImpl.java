package hpms.fin.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.fin.dto.Invoice;
import hpms.fin.service.IInvoiceService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl extends BaseServiceImpl<Invoice> implements IInvoiceService {


    @Autowired

    private InvoiceMapper invoiceMapper;
    @Override
    public void submitInvoiceLine(IRequest request, Invoice invoice) {
        invoiceMapper.updateByPrimaryKeySelective(invoice);
    }

    @Override
    public Invoice queryOccupation(IRequest request, Invoice invoice) {
        return invoiceMapper.queryOccupation(invoice);
    }
}