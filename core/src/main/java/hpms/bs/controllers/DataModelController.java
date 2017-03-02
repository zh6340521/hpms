package hpms.bs.controllers;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.DataModel;
import hpms.bs.service.IDataModelService;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
 * @name DataModelController
 * @description
 * @date 2017/2/28
 */
@Controller
public class DataModelController extends BaseController {
    @Autowired
    private IDataModelService dataModelService;

    private Logger logger = LoggerFactory.getLogger(DataModelController.class);

    /**
     *
     * 查询
     * @param dm
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/DataModel/query")
    @ResponseBody
    public ResponseData query(DataModel dm, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<DataModel> dmList = dataModelService.findAllDataModel(requestContext,dm,page,pageSize);
        return new ResponseData(dmList);
    }

    /**
     * 批量更新
     * @param request
     * @param dms
     * @return
     */
    @RequestMapping(value = "/bs/DataModel/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<DataModel> dms,BindingResult result){
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        try {
            dataModelService.myBatchUpdate(dms,requestCtx);
        } catch (ValidationTableException e) {
            ResponseData rd = new ResponseData(false);
            String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
                    RequestContextUtils.getLocale(request));
            rd.setMessage(errorMessage);
            return rd;
        }
        return new ResponseData(dms);
    }

    /**
     * 删除
     * @param request
     * @param dms
     * @return
     */
    @RequestMapping(value = "/bs/DataModel/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<DataModel> dms){
        dataModelService.deleteDataModel(dms);
        return new ResponseData();
    }

    @RequestMapping(value = "/bs/DataModel/queryByModelId")
    @ResponseBody
    public ResponseData queryByModelId(Long modelId,HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        String mId = Long.toString(modelId);
        List<DataModel> dmList = dataModelService.findDataModelbyModelId(requestContext,mId);
        return new ResponseData(dmList);
    }
}
