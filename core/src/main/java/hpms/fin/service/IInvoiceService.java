package hpms.fin.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.Invoice;
import hpms.fin.dto.InvoiceLine;

public interface IInvoiceService extends IBaseService<Invoice>, ProxySelf<IInvoiceService>{
    public void submitInvoiceLine(IRequest request, Invoice invoice);

    public Invoice queryOccupation(IRequest request, Invoice invoice);
}