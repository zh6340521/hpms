package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.ConfigValue;
import hpms.bs.service.IConfigValueService;
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
 * @name ConfigValueController
 * @description
 * @date 2017/3/1
 */
@Controller
public class ConfigValueController extends BaseController {
    @Autowired
    private IConfigValueService configValueService;

    /**
     *
     * 查询
     * @param cfv
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configvalue/query")
    @ResponseBody
    public ResponseData query(ConfigValue cfv, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<ConfigValue> cList = configValueService.select(requestContext,cfv,page,pageSize);
        return new ResponseData(cList);
    }

    /**
     * 批量更新
     * @param request
     * @param cfv
     * @return
     */
    @RequestMapping(value = "/bs/configvalue/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<ConfigValue> cfv){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(configValueService.batchUpdate(requestCtx, cfv));
    }

    /**
     * 删除
     * @param request
     * @param cfv
     * @return
     */
    @RequestMapping(value = "/bs/configvalue/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<ConfigValue> cfv){
        configValueService.batchDelete(cfv);
        return new ResponseData();
    }
}
