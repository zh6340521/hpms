package hpms.fin.controllers;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterShareResult;
import hpms.fin.service.IMeterShareResultService;
import hpms.utils.ValidationTableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     * 保存方法---查询数据并保存到数据库
     * @param meterShareResultList
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fin/metershareresult/submit", method = RequestMethod.POST)
    @ResponseBody
    public  ResponseData msrSubmit(@RequestBody List<MeterShareResult> meterShareResultList , HttpServletRequest request){
        IRequest requestContext = createRequestContext(request);
        try {
            meterShareResultService.myBatchUpdate(requestContext,meterShareResultList);
        } catch (ValidationTableException e) {
            ResponseData rd = new ResponseData(false);
            String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
                    RequestContextUtils.getLocale(request));
            rd.setMessage(errorMessage);
            return rd;
        }
        return new ResponseData(meterShareResultList);
    }


    /**
     * 查询公表分摊结果数据
     * @param msr
     * @param request
     * @return
     */
    @RequestMapping(value = "/fin/metershareresult/query")
    @ResponseBody
    public ResponseData query(@ModelAttribute MeterShareResult msr, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) throws ParseException {
        IRequest requestContext = createRequestContext(request);

        List<MeterShareResult> mcList = meterShareResultService.findAllMeterShareResult(requestContext,msr,page,pageSize);
        for(MeterShareResult m1:mcList){
            //对日期进行类型转换
            SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
            String a1=dateformat1.format(m1.getCallableDate());

            String a2 = dateformat1.format(m1.getMsDate());


           m1.setFormatCallableDate(a1);
            m1.setFormatMsDate(a2);
        }
        return new ResponseData(mcList);
    }

    /**
     * 转入计费
     * @param meterShareResultList
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fin/metershareresult/changeStatus", method = RequestMethod.POST)
    @ResponseBody
    public  ResponseData msrChangeStatus(@RequestBody List<MeterShareResult> meterShareResultList , HttpServletRequest request) throws Exception{
        IRequest requestContext = createRequestContext(request);
        meterShareResultService.changeStaus(requestContext,meterShareResultList);
        return new ResponseData(meterShareResultList);
    }




}
