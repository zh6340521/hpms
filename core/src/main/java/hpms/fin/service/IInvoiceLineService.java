package hpms.fin.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.fin.dto.InvoiceLine;
import java.util.List;

import com.hand.hap.core.IRequest;

public interface IInvoiceLineService extends IBaseService<InvoiceLine>, ProxySelf<IInvoiceLineService>{
    public List<InvoiceLine> queryInvoiceLine(InvoiceLine fee,IRequest requestContext,int page,int pagesize);

    public void submitInvoiceLine(IRequest request,InvoiceLine invoiceLine);
}