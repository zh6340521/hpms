package hpms.mdm.controllers;

import hpms.mdm.mapper.FeeMapper;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.Fee;
import hpms.mdm.service.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FeeController extends BaseController {

    @Autowired
    private IFeeService service;

    @Autowired
    private FeeMapper feeMapper;


    @RequestMapping(value = "/hpms/mdm/fee/query")
    @ResponseBody
    public ResponseData query(Fee fee, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);

        return new ResponseData(service.findAllFee(fee, requestContext, page, pageSize));
    }

    @RequestMapping(value = "/hpms/mdm/fee/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<Fee> dto) {
        IRequest requestCtx = createRequestContext(request);
        for (Fee fee : dto) {


            if (fee.getFeeId() == null) {
                int count = service.queryCountByCode(requestCtx, fee);
                if (count > 0) {
                    throw new RuntimeException("编号已经存在");
                }
            }
        }

        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/mdm/fee/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Fee> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }


    @RequestMapping(value = "/hpms/mdm/fee/itemNumQuery")
    @ResponseBody
    public Long itemNumQuery(HttpServletRequest request) {
        Long itemNum = feeMapper.queryCountItemFlag();
        return itemNum;
    }
}