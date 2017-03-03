package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.Config;
import hpms.bs.service.IConfigService;
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
 * @name ConfigController
 * @description
 * @date 2017/3/1
 */
@Controller
public class ConfigController extends BaseController {

    @Autowired
    private IConfigService configService;
    /**
     *
     * 查询
     * @param cf
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/config/query")
    @ResponseBody
    public ResponseData query(Config cf, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<Config> cList = configService.selectAllConfig(requestContext,cf,page,pageSize);
        return new ResponseData(cList);
    }

    /**
     * 批量更新
     * @param request
     * @param cf
     * @return
     */
    @RequestMapping(value = "/bs/config/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Config> cf){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(configService.batchUpdate(requestCtx, cf));
    }

    /**
     * 删除
     * @param request
     * @param cf
     * @return
     */
    @RequestMapping(value = "/bs/config/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Config> cf){
        configService.batchDelete(cf);
        return new ResponseData();
    }
}
