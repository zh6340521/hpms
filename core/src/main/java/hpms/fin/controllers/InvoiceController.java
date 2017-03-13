package hpms.fin.controllers;

import hpms.fin.dto.InvoiceLine;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.Invoice;
import hpms.fin.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

    @Controller
    public class InvoiceController extends BaseController{

    @Autowired
    private IInvoiceService service;


    @RequestMapping(value = "/hpms/fin/invoice/query")
    @ResponseBody
    public ResponseData query(Invoice dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hpms/fin/invoice/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody Invoice dto){
        IRequest requestCtx = createRequestContext(request);
        service.submitInvoiceLine(requestCtx,dto);
        List<Invoice> invoices = new ArrayList<Invoice>();
        invoices.add(dto);
        return new ResponseData(invoices);
    }

    @RequestMapping(value = "/hpms/fin/invoice/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Invoice> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }

        @RequestMapping(value = "/hpms/fin/invoice/queryOccupation")
        @ResponseBody
        public ResponseData queryOccupation(HttpServletRequest request,@RequestBody Invoice dto){

            IRequest requestCtx = createRequestContext(request);
            /*Invoice curinvoice=new Invoice();
            curinvoice.setStructureId(dto);*/
            List<Invoice> invoices = new ArrayList<Invoice>();
            Invoice invoice = service.queryOccupation(requestCtx,dto);
            invoices.add(invoice);
            return new ResponseData(invoices);
        }
    }