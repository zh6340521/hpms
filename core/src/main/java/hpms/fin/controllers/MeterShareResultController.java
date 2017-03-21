package hpms.fin.controllers;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterShareResult;
import hpms.fin.service.IMeterShareResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name MeterShareResultController :公表分摊结果controller
 * @description
 * @date 2017/3/20
 */
@Controller
public class MeterShareResultController extends BaseController {
    @Autowired
    private IMeterShareResultService meterShareResultService;

    /**
     * 查询仪表类型下拉框
     * @param projectId
     * @param request
     * @return
     */
    @RequestMapping(value = "/fin/metershareresult/queryEquipmentId")
    @ResponseBody
    public ResponseData queryEquipmentId(Long projectId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        MeterCharge mc = new MeterCharge();
        mc.setProjectId(projectId);
        List<MeterCharge> mcList = meterShareResultService.findEquipmentTypeByMeterCharge(mc,requestContext);
        return new ResponseData(mcList);
    }

    /**
     * 查询年份下拉框
     * @param request
     * @return
     */
    @RequestMapping(value = "/fin/metershareresult/queryYear")
    @ResponseBody
    public ResponseData queryYear(HttpServletRequest request) {
       List<MeterShareResult> yearList = new ArrayList<>();
        yearList = meterShareResultService.findYear();
        //List<MeterCharge> mcList = meterShareResultService.findEquipmentTypeByMeterCharge(mc,requestContext);
        return new ResponseData(yearList);
    }

    /**
     * 查询月份下拉框
     * @param request
     * @return
     */
    @RequestMapping(value = "/fin/metershareresult/queryMonth")
    @ResponseBody
    public ResponseData queryMonth(HttpServletRequest request) {
        List<MeterShareResult> monthList = new ArrayList<>();
        monthList = meterShareResultService.findMonth();
        //List<MeterCharge> mcList = meterShareResultService.findEquipmentTypeByMeterCharge(mc,requestContext);
        return new ResponseData(monthList);
    }

    /**
     * 批量更新
     * @param meterShareResultList
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fin/metershareresult/submit", method = RequestMethod.POST)
    @ResponseBody
    public  ResponseData feeListSubmit(@RequestBody List<MeterShareResult> meterShareResultList , HttpServletRequest request) throws Exception{
        IRequest requestContext = createRequestContext(request);
        meterShareResultService.myBatchUpdate(requestContext,meterShareResultList);
        return new ResponseData(meterShareResultList);
    }







}
