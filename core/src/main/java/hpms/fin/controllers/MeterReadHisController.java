package hpms.fin.controllers;

import com.hand.hap.system.dto.Code;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.MeterReadHis;
import hpms.fin.service.IMeterReadHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class MeterReadHisController extends BaseController{

    @Autowired
    private IMeterReadHisService service;


    @RequestMapping(value = "/hpms/fin/meter/read/his/query")
    @ResponseBody
    public ResponseData query(MeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryMeterReadHis(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hpms/fin/meter/read/his/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<MeterReadHis> dto) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/fin/meter/read/his/changeMeter")
    @ResponseBody
    public ResponseData changeMeter(HttpServletRequest request, @RequestParam Long equipmentId, @RequestParam Long changeEquipmentId) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.changeMeterReadHis(requestCtx, equipmentId, changeEquipmentId));
    }

    @RequestMapping(value = "/hpms/fin/meter/read/his/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<MeterReadHis> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }


    @RequestMapping(value = "/hpms/fin/meter/read/his/queryYear")
    @ResponseBody
    public ResponseData queryYear(Code dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                  @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryYear(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hpms/fin/meter/read/his/queryMonth")
    @ResponseBody
    public ResponseData queryMonth(Code dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryMonth(requestContext,dto,page,pageSize));
    }

    }