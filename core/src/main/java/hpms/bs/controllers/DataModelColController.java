package hpms.bs.controllers;/**
 * Created by user1 on 2017/2/28.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.bs.dto.DataModelCol;
import hpms.bs.service.IDataModelColService;
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
 * @name DataModelColController
 * @description
 * @date 2017/2/28
 */
@Controller
public class DataModelColController extends BaseController {
    @Autowired
    private IDataModelColService dataModelColService;

    /**
     *
     * 查询
     * @param dmc
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/bs/DataModelCol/query")
    @ResponseBody
    public ResponseData query(DataModelCol dmc, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        List<DataModelCol> dmcList = dataModelColService.select(requestContext,dmc,page,pageSize);
        return new ResponseData(dmcList);
    }

    /**
     * 批量更新
     * @param request
     * @param dms
     * @return
     */
    @RequestMapping(value = "/bs/DataModelCol/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<DataModelCol> dms){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(dataModelColService.batchUpdate(requestCtx, dms));
    }


}
