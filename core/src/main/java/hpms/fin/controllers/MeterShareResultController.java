package hpms.fin.controllers;/**
 * Created by user1 on 2017/3/20.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.fin.dto.MeterCharge;
import hpms.fin.service.IMeterShareResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/fin/metershareresult/query")
    @ResponseBody
    public ResponseData query(Long projectId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        MeterCharge mc = new MeterCharge();
        mc.setProjectId(projectId);
        List<MeterCharge> mcList = meterShareResultService.findEquipmentTypeByMeterCharge(mc,requestContext);
        return new ResponseData(mcList);
    }

}
