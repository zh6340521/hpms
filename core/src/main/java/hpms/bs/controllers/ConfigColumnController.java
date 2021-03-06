package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.service.IConfigColumnService;
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
 * @name ConfigValueColumnController
 * @description
 * @date 2017/3/2
 */
@Controller
public class ConfigColumnController extends BaseController {
    @Autowired
    private IConfigColumnService configColumnService;

    /**
     *
     * 查询
     * @param cc
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/query")
    @ResponseBody
    public ResponseData query(ConfigColumn cc, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<ConfigColumn> cList = configColumnService.select(requestContext,cc,page,pageSize);
        return new ResponseData(cList);
    }

    /**
     * 批量更新
     * @param request
     * @param cc
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<ConfigColumn> cc){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(configColumnService.batchUpdate(requestCtx, cc));
    }

    /**
     * 删除
     * @param request
     * @param cc
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<ConfigColumn> cc){
        configColumnService.batchDelete(cc);
        return new ResponseData();
    }
}
