package hpms.fin.controllers;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.CusMeterReadHis;
import hpms.fin.service.ICusMeterReadHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CusMeterReadHisController extends BaseController {

    @Autowired
    private ICusMeterReadHisService service;

    @RequestMapping(value = "/hpms/fin/meter/read/cus/query")
    @ResponseBody
    public ResponseData query(CusMeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryMeterReadHis(requestContext, dto, page, pageSize));
    }


    @RequestMapping(value = "/hpms/fin/meter/read/cusMeter/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<CusMeterReadHis> dto) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.changeMeterReadHis(requestCtx, dto));
    }


    /**
     * 抄表时查询出符合条件的抄表
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<MeterReadHis> 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/cusMeterhis/batch")
    @ResponseBody
    public ResponseData batch(CusMeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.batchMeterReadHis(requestContext,dto,page,pageSize));
    }
}