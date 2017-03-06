package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.Config;
import hpms.bs.service.IConfigService;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

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

    private Logger logger = LoggerFactory.getLogger(ConfigController.class);
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
        try {
            configService.myBatchUpdate(requestCtx, cf);
        } catch (ValidationTableException e) {
            logger.info("捕获消息并进行抛出");
            ResponseData rd = new ResponseData(false);
            String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
                    RequestContextUtils.getLocale(request));
            rd.setMessage(errorMessage);
            return rd;
        }
        return new ResponseData(cf);
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

    @RequestMapping(value = "/bs/config/queryByCache")
    @ResponseBody
    public ResponseData queryByCache(Long configId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        String cId = Long.toString(configId);
        List<Config> dmList = configService.queryConfigCache(requestContext,cId);
        return new ResponseData(dmList);
    }
}
