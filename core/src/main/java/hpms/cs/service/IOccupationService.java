package hpms.cs.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.cs.dto.Occupation;

import java.util.List;

/**
 * @author feng.liu01@hand-china.com 2017/03/01
 * @version 1.0
 * @name hpms.cs.service.IOccupationService
 * @description 入退伙 service 接口类
 */

public interface IOccupationService extends IBaseService<Occupation>, ProxySelf<IOccupationService> {

    /**
     * 分页查询
     * @param request
     * @param occupation
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Occupation> propertyQuery(IRequest request, Occupation occupation, int pageNum, int pageSize);

    /**
     * 根据项目id查询一个 Occupation 对象
     * @param request
     * @param occupation
     * @return
     */
    Occupation queryOne(IRequest request,Occupation occupation);

    /**
     * 插入或者更新 Occupation 对象
     * @param request
     * @param occupation
     * @return
     */
    Occupation updateOccu(IRequest request,Occupation occupation);

    /**
     * 关联查询 Occupation
     * @param requestContext
     * @param dto
     * @param page
     * @param pageSize
     * @return
     */
    List<Occupation> selectOccupation(IRequest requestContext, Occupation dto, int page, int pageSize);
}