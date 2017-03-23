package hpms.mdm.controllers;

import com.hand.hap.attachment.dto.SysFile;
import com.hand.hap.attachment.service.ISysFileService;
import hpms.mdm.dto.EquipmentType;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.Equipment;
import hpms.mdm.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EquipmentController extends BaseController {

    @Autowired
    private IEquipmentService service;
    @Autowired
    private ISysFileService sysFileService;

    @RequestMapping(value = "/hpms/mdm/equipment/query")
    @ResponseBody
    public ResponseData query(Equipment dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryEquipment(requestContext, dto, page, pageSize));
    }


   @RequestMapping(value = "/hpms/mdm/equipment/submit")
   @ResponseBody
   public ResponseData update(HttpServletRequest request, @RequestBody List<Equipment> dto) {
       IRequest requestCtx = createRequestContext(request);
       return new ResponseData(service.submitEquipment(requestCtx,dto));
   }



    @RequestMapping(value = "/hpms/mdm/equipment/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Equipment> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }

    @RequestMapping(value = "/hpms/mdm/equipment/queryEquipmentType",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData queryEquipmentType(@ModelAttribute EquipmentType equipmentType,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<EquipmentType> equipmentTypes=service.queryEquipmentType(requestContext,equipmentType);
        return new ResponseData(equipmentTypes);
    }

    @RequestMapping(value = "/hpms/mdm/equipment/queryFeeEquipmentType",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData queryFeeEquipmentType(@ModelAttribute EquipmentType equipmentType,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<EquipmentType> equipmentTypes=service.queryFeeEquipmentType(requestContext,equipmentType);
        return new ResponseData(equipmentTypes);
    }

    @RequestMapping({"/hpms/mdm/equipment/queryFiles"})
    public ResponseData query(HttpServletRequest request,  String sourceType, String sourceKey, @RequestParam(defaultValue = DEFAULT_PAGE) int page, @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(sysFileService.queryFilesByTypeAndKey(requestCtx,sourceType,sourceKey));
    }



}
