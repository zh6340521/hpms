package hpms.fin.controllers;

import hpms.fin.mapper.InvoiceLineMapper;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.InvoiceLine;
import hpms.fin.service.IInvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

@Controller
public class InvoiceLineController extends BaseController {

    @Autowired
    private IInvoiceLineService service;



    @RequestMapping(value = "/hpms/fin/invoice/line/query")
    @ResponseBody
    public ResponseData query(InvoiceLine dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryInvoiceLine(dto, requestContext, page, pageSize));
    }

    @RequestMapping(value = "/hpms/fin/invoice/line/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody InvoiceLine dto) {
        IRequest requestCtx = createRequestContext(request);
        service.submitInvoiceLine(requestCtx,dto);

        List<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
        invoiceLines.add(dto);
        return new ResponseData(invoiceLines);
    }

    @RequestMapping(value = "/hpms/fin/invoice/line/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<InvoiceLine> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}