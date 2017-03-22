package hpms.fin.controllers;

import com.hand.hap.system.dto.Code;
import hpms.fin.dto.MeterGradePrice;
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

    /**
     * 根据条件查询抄表历史记录
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return ResponseData 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/his/query")
    @ResponseBody
    public ResponseData query(MeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryMeterReadHis(requestContext,dto,page,pageSize));
    }

    /**
     * 根据条件查询公表抄表历史记录
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return ResponseData 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/his/queryPub")
    @ResponseBody
    public ResponseData queryPub(MeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryPubMeterReadHis(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/hpms/fin/meter/read/his/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<MeterReadHis> dto) {
        IRequest requestCtx = createRequestContext(request);
        for (MeterReadHis k:dto ) {
            List<MeterReadHis> mList = service.updateMeterHisOld(requestCtx, k.getEquipmentId());
        }
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    /**
     * 根据换表时的双放设备，将旧表的最新抄表记录插入新表种
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param equipmentId  旧表ID
     * @param changeEquipmentId  新表ID
     * @return ResponseData 所有符合的结果集
     */
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

    /**
     * 根据条件查询近5年的年份
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return ResponseData 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/his/queryYear")
    @ResponseBody
    public ResponseData queryYear(Code dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                  @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryYear(requestContext,dto,page,pageSize));
    }

    /**
     * 根据条件查询12个月份
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<Code> 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/his/queryMonth")
    @ResponseBody
    public ResponseData queryMonth(Code dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryMonth(requestContext,dto,page,pageSize));
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
    @RequestMapping(value = "/hpms/fin/meter/read/his/batch")
    @ResponseBody
    public ResponseData batch(MeterReadHis dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.batchMeterReadHis(requestContext,dto,page,pageSize));
    }

    /**
     * 根据公司、项目、设备类型、用量找到价格
     * @author jun.zhao02@hand-china.com
     * @param request  请求
     * @param dto  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<MeterGradePrice> 所有符合的结果集
     */
    @RequestMapping(value = "/hpms/fin/meter/read/his/queryPrice")
    @ResponseBody
    public ResponseData queryPrice(MeterGradePrice dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryGradePrice(requestContext,dto,page,pageSize));
    }

    }