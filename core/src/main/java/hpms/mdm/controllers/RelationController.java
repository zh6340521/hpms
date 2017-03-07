package hpms.mdm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hpms.mdm.dto.Fee;
import hpms.mdm.dto.Relation;
import hpms.mdm.mapper.RelationMapper;
import hpms.mdm.service.IRelationService;

@Controller
public class RelationController extends BaseController{
	@Autowired
	private IRelationService relationService;
	@Autowired
	private RelationMapper relationMapper;
	
	
	/**
	 * 保存人员关系tab页
	 * @param request
	 * @param customer
	 * @param result
	 * @return
	 */
    @RequestMapping(value = "/hpms/mdm/Relation/submit")
    @ResponseBody
    public ResponseData saveRelation(HttpServletRequest request,@RequestBody Relation relations,BindingResult result){
			IRequest requestCtx = createRequestContext(request);
			List<Relation> relation = new ArrayList<Relation>();
			relationService.submitRelation(requestCtx, relations);
			relation.add(relations);
			return new ResponseData(relation);
    }
    
    /**
     * 是否建立过关系
     * @param request
     * @param relations
     * @param result
     * @return
     */
    @RequestMapping(value = "/hpms/mdm/Relation/submitReation")
    @ResponseBody
    public ResponseData submitRelation(HttpServletRequest request,@RequestBody Relation relations,BindingResult result){
		IRequest requestCtx = createRequestContext(request);
		List<Relation> relation = new ArrayList<Relation>();
		if (relations.getRelationId() == null) {
			int count = relationService.queryByBpId(requestCtx, relations);
			if (count > 0) {
				throw new RuntimeException("该联系人已存在");
			}
		}
		relationService.insertSelective(requestCtx, relations);
		relation.add(relations);
		return new ResponseData(relation);
}
    
    /**
     * 是否存在紧急联系人
     * @param request
     * @return
     */
    @RequestMapping(value = "/hpms/mdm/Relation/itemNumQuery")
    @ResponseBody
    public int itemNumQuery(HttpServletRequest request,int fromBpId) {
    	IRequest requestCtx = createRequestContext(request);
        int itemNum = relationService.selectByCountIcmFlag(requestCtx,fromBpId);
        return itemNum;
    }
    
    
    /**
     * 修改人员关系
     * @param request
     * @param relations
     * @param result
     * @return
     */
    @RequestMapping(value = "/hpms/mdm/Relation/updateReation")
    @ResponseBody
    public ResponseData updateReation(HttpServletRequest request,@RequestBody Relation relations,BindingResult result){
    	IRequest requestCtx = createRequestContext(request);
		List<Relation> relation = new ArrayList<Relation>();
		relationService.updateReation(requestCtx, relations);
		relation.add(relations);
		return new ResponseData(relation);
}
}
