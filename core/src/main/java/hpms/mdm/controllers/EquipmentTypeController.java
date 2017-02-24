package hpms.mdm.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.EquipmentType;
import hpms.mdm.service.IEquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/02/23
 * @version 1.0
 * @name hpms.mdm.controllers.EquipmentTypeController
 * @description 设备类型 controller 类
 */

@Controller
public class EquipmentTypeController extends BaseController {

    @Autowired
    private IEquipmentTypeService service;


    @RequestMapping(value = "/mdm/equipmentType/query")
    @ResponseBody
    public ResponseData query(EquipmentType dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/mdm/equipmentType/submit")
    @ResponseBody
    public ResponseData update(
            HttpServletRequest request, @RequestBody List<EquipmentType> dto,
            BindingResult result) throws BaseException {

        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }

        return new ResponseData(service.batchUpdateEquipmentType(requestCtx, dto));
    }

    @RequestMapping(value = "/mdm/equipmentType/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<EquipmentType> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}