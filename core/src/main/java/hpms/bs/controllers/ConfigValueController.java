package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.Config;
import hpms.bs.dto.ConfigValue;
import hpms.bs.service.IConfigService;
import hpms.bs.service.IConfigValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    @Autowired
    private IConfigService configService;

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
    public ResponseData update(HttpServletRequest request,@RequestBody List<ConfigValue> cfv,BindingResult result){
        IRequest requestCtx = createRequestContext(request);
        //后台验证传递的参数
		Locale locale = RequestContextUtils.getLocale(request);
		getValidator().validate(cfv, result);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        configValueService.myBatchUpdate(requestCtx, cfv);
        return new ResponseData(cfv);
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
        IRequest requestContext = createRequestContext(request);
        configValueService.deleteConfigValue(cfv,requestContext);
        return new ResponseData();
    }


    @RequestMapping(value = "/bs/configvalue/queryByCache")
    @ResponseBody
    public ResponseData queryByCache(Long configId,Long configValueId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        String cId = Long.toString(configId);

        List<ConfigValue> dmList = configValueService.queryConfigCache(requestContext,configValueId,cId);
        return new ResponseData(dmList);
    }


    @RequestMapping(value = "/bs/configvalue/queryConValueByCache")
    @ResponseBody
    public ResponseData queryConValueByCache(Long companyId,String columnName,Long modelId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        Config config = new Config();
        config.setCompanyId(companyId);
        config.setColumnName(columnName);
        config.setModelId(modelId);

        List<ConfigValue> cvLis = new ArrayList<>();
        //查询对应的头表对象
        List<Config> configList = configService.select(requestContext,config,1,10);
        if(!configList.isEmpty()&&configList.size()!=0){
            Config c = configList.get(0);

            cvLis = configValueService.queryConfigCacheByConfigId(requestContext,c.getConfigId());

        }

        return new ResponseData(cvLis);
    }


}
