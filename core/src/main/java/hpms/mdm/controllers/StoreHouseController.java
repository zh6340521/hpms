package hpms.mdm.controllers;

import com.github.pagehelper.PageHelper;
import hpms.mdm.mapper.StoreHouseMapper;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.StoreHouse;
import hpms.mdm.service.IStoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StoreHouseController extends BaseController {

    @Autowired
    private IStoreHouseService service;
    @Autowired
    private StoreHouseMapper storeHouseMapper;


    @RequestMapping(value = "/hpms/mdm/store/house/query")
    @ResponseBody
    public ResponseData query(StoreHouse dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext, dto, page, pageSize));
    }

    @RequestMapping(value = "/hpms/mdm/store/house/queryAll")
    @ResponseBody
    public ResponseData queryAllStoreHouse(StoreHouse dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        PageHelper.startPage(page, pageSize);
        return new ResponseData(storeHouseMapper.queryAllStoreHouse(dto));
    }

    @RequestMapping(value = "/hpms/mdm/store/house/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request, @RequestBody List<StoreHouse> dto) {
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hpms/mdm/store/house/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<StoreHouse> dto) {
        service.batchDelete(dto);
        return new ResponseData();
    }
}