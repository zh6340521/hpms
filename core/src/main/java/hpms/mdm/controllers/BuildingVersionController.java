package hpms.mdm.controllers;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.service.IBuildingVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersionController
 * @description:建筑版本controller
 * @date 2017/2/15
 */
@Controller
public class BuildingVersionController extends BaseController {

    @Autowired
    private IBuildingVersionService buildingVersionService;

    /**
     *
     * 查询
     * @param bv
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/mdm/BuildingVersion/query")
    @ResponseBody
    public ResponseData query(BuildingVersion bv, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(buildingVersionService.select(requestContext,bv,page,pageSize));
    }

    /**
     * 批量更新
     * @param request
     * @param bv
     * @return
     */
    @RequestMapping(value = "/mdm/BuildingVersion/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<BuildingVersion> bv){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(buildingVersionService.batchUpdate(requestCtx, bv));
    }

    /**
     * 删除
     * @param request
     * @param bv
     * @return
     */
    @RequestMapping(value = "/mdm/BuildingVersion/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<BuildingVersion> bv){
        buildingVersionService.batchDelete(bv);
        return new ResponseData();
    }



}
