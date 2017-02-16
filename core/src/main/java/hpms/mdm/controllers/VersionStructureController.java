package hpms.mdm.controllers;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.VersionStructure;
import hpms.mdm.service.IVersionStructureService;
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
 * @name VersionStructureController
 * @description:版本结构Controller
 * @date 2017/2/15
 */
@Controller
public class VersionStructureController extends BaseController {
    @Autowired
    private IVersionStructureService versionStructureService;

    /**
     *
     * 查询
     * @param vs
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/mdm/structure/query")
    @ResponseBody
    public ResponseData query(VersionStructure vs, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(versionStructureService.findAllVersionStructure(vs,requestContext,page,pageSize));
    }

    /**
     * 批量更新
     * @param request
     * @param vs
     * @return
     */
    @RequestMapping(value = "/mdm/structure/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<VersionStructure> vs){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(versionStructureService.batchUpdate(requestCtx, vs));
    }

    /**
     * 删除
     * @param request
     * @param vs
     * @return
     */
    @RequestMapping(value = "/mdm/structure/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<VersionStructure> vs){
        versionStructureService.batchDelete(vs);
        return new ResponseData();
    }

}
