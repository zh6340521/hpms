package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.Invoice;

import java.util.List;

public interface IInvoiceService extends IBaseService<Invoice>, ProxySelf<IInvoiceService>{
    public void submitInvoiceLine(IRequest request, Invoice invoice);

    public Invoice queryOccupation(IRequest request, Invoice invoice);

    public List<Invoice> queryInvoice(IRequest request,Invoice invoice, int page, int pagesize);
}