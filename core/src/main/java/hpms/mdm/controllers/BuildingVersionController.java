package hpms.mdm.controllers;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.service.IBuildingVersionService;
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
 * @name BuildingVersionController
 * @description:建筑版本controller
 * @date 2017/2/15
 */
@Controller
public class BuildingVersionController extends BaseController {

    @Autowired
    private IBuildingVersionService buildingVersionService;

    private Logger logger = LoggerFactory.getLogger(BuildingVersionController.class);

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
        List<BuildingVersion> bvList = buildingVersionService.selectBuildingVersion(requestContext,bv,page,pageSize);
        return new ResponseData(bvList);
    }

    /**
     * 批量更新
     * @param request
     * @param bv
     * @return
     */
    @RequestMapping(value = "/mdm/BuildingVersion/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<BuildingVersion> bv,BindingResult result){
        IRequest requestCtx = createRequestContext(request);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }

        logger.info("进行批量更新");
        try {
            buildingVersionService.myBatchUpdate(requestCtx, bv);
        } catch (ValidationTableException e) {
            ResponseData rd = new ResponseData(false);
            String errorMessage = this.getMessageSource().getMessage(e.getCode(), null,
                    RequestContextUtils.getLocale(request));
            rd.setMessage(errorMessage);
            return rd;
        }

        logger.info("将保存后的json数据传入前台");
        return  new ResponseData(bv);
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
