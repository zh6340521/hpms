package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/2.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.ConfigColumn;
import hpms.bs.service.IConfigColumnService;
import hpms.utils.ValidationTableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
     * @param configValueId
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/query")
    @ResponseBody
    public ResponseData query(Long configValueId, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        ConfigColumn cc = new ConfigColumn();
        cc.setConfigValueId(configValueId);
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
    public ResponseData update(HttpServletRequest request,@RequestBody List<ConfigColumn> cc,BindingResult result){
        IRequest requestCtx = createRequestContext(request);
        //后台验证传递的参数
		Locale locale = RequestContextUtils.getLocale(request);
		getValidator().validate(cc, result);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }

        try {
            configColumnService.myBatchUpdate(requestCtx,cc);
        } catch (ValidationTableException e) {
            ResponseData rd = new ResponseData(false);
            String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
                    RequestContextUtils.getLocale(request));
            rd.setMessage(errorMessage);
            return rd;
        }
        return new ResponseData(cc);
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
        IRequest requestCtx = createRequestContext(request);
        configColumnService.deleteConfigColumn(cc,requestCtx);
        return new ResponseData();
    }

    /**
     * 从缓存中查询数据
     * @param configValueId
     * @param configId
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/queryByCache")
    @ResponseBody
    public ResponseData queryByCache(Long configValueId,Long configId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<ConfigColumn> ccList = configColumnService.findConfigColumnByCache(requestContext,configValueId,configId);
        return new ResponseData(ccList);
    }

    /**
     * 从缓存中查询必输字段
     * @param configValueId
     * @param configId
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/queryRequiredByCache")
    @ResponseBody
    public ResponseData queryRequiredByCache(Long configValueId,Long configId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<ConfigColumn> ccList = configColumnService.queryRequiredByCache(requestContext,configValueId,configId);
        return new ResponseData(ccList);
    }






    /**
     * 根据行号从缓存中查询数据
     * @param configValueId
     * @param configId
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/configcolumn/queryDataByCache")
    @ResponseBody
   /* public Map<Long,List<ConfigColumn>> queryDataByCache(@RequestParam Long configValueId,@RequestParam Long configId,@RequestParam Long displayLineNo[],HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        Map<Long,List<ConfigColumn>> ccMap = new HashMap<>();
        Map<Long,List<ConfigColumn>> map = new HashMap<>();

        for(int i = 0; i < displayLineNo.length; i++){
            ccMap = configColumnService.findConfigColumnCacheBydisplayLineNo(requestContext,configValueId,configId,displayLineNo[i]);

           *//* Iterator it = ccMap.keySet().iterator();
            while(it.hasNext()){
                Long key;
                List<ConfigColumn> configColumnList;
                key=(Long)it.next();
                configColumnList=(List<ConfigColumn>) ccMap.get(key);
                ccList.addAll(configColumnList);
            }*//*
            map.putAll(ccMap);
        }

        return map;
    }*/

    public ResponseData queryDataByCache(@RequestParam Long configValueId,@RequestParam Long configId,@RequestParam Long displayLineNo[],HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        Map<Long,List<ConfigColumn>> ccMap = new HashMap<>();
        List<ConfigColumn> ccList = new ArrayList<>();

        for(int i = 0; i < displayLineNo.length; i++){
            ccMap = configColumnService.findConfigColumnCacheBydisplayLineNo(requestContext,configValueId,configId,displayLineNo[i]);

             Iterator it = ccMap.keySet().iterator();
             while(it.hasNext()){
                Long key;
                List<ConfigColumn> configColumnList;
                key=(Long)it.next();
                configColumnList=(List<ConfigColumn>) ccMap.get(key);
                ccList.addAll(configColumnList);
            }

        }
        return new ResponseData(ccList);
    }



    /**
     *
     * @param configColumnId
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/configcolumn/code/queryBySqlId")
    @ResponseBody
    public ResponseData getDatas(Long configColumnId, @RequestParam Map<String, String> params,
                                    HttpServletRequest request) {
        String sqlId = "";
        IRequest requestContext = createRequestContext(request);
        ConfigColumn cc = new ConfigColumn();
        cc.setConfigColumnId(configColumnId);

        List<ConfigColumn> ccList = configColumnService.select(requestContext,cc,1,10);
        if(!ccList.isEmpty()&&ccList.size()!=0){
            ConfigColumn c1= ccList.get(0);
            sqlId = c1.getSqlId();
        }
        return new ResponseData(configColumnService.selectDatas(requestContext, sqlId, params));
    }

}
