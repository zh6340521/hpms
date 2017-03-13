package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.Invoice;
import java.util.List;

public interface InvoiceMapper extends Mapper<Invoice>{
    List<Invoice> queryInvoice(Invoice invoice);
    Invoice queryOccupation(Invoice invoice);
}