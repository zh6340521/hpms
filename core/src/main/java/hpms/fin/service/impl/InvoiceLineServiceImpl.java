package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.Invoice;
import hpms.fin.mapper.InvoiceLineMapper;
import hpms.fin.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.fin.dto.InvoiceLine;
import hpms.fin.service.IInvoiceLineService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InvoiceLineServiceImpl extends BaseServiceImpl<InvoiceLine> implements IInvoiceLineService{

    @Autowired
    private InvoiceLineMapper invoiceLineMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Override
    public List<InvoiceLine> queryInvoiceLine(InvoiceLine invoiceLine, IRequest requestContext, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return  invoiceLineMapper.queryInvoiceLine(invoiceLine);
    }


    @Override
    public void submitInvoiceLine(IRequest request,InvoiceLine invoiceLine){
        Invoice invoice=new Invoice();
        if(invoiceLine.getInvoiceId()==null){

            invoice=invoiceLine.getInvoice();
            Date curdate=new Date();
            invoice.setPayableCode(curdate.toString());
            invoiceMapper.insertSelective(invoice);
            invoiceLine.setInvoiceId(invoice.getInvoiceId());
            invoiceLineMapper.insertSelective(invoiceLine);
        }else{
            invoiceLineMapper.insertSelective(invoiceLine);
            invoice.setInvoiceId(invoiceLine.getInvoiceId());
            invoiceMapper.updateByPrimaryKeySelective(invoice);
        }

    }
}