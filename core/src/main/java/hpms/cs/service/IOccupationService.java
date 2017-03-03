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

    List<Occupation> propertyQuery(IRequest request, Occupation occupation, int pageNum, int pageSize);

}