package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.InvoiceLine;
import java.util.List;

public interface InvoiceLineMapper extends Mapper<InvoiceLine>{

    List<InvoiceLine> queryInvoiceLine(InvoiceLine invoiceLine);

}