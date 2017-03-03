package hpms.fin.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hpms.fin.dto.FeeList;
import hpms.fin.dto.FeeListNew;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.dto.VersionStructure;

/**
 * 
 * @name IFeeListService
 * @description 应收费用清单Service
 * @author chengye.hu@hand-china.com	2017年2月27日下午4:15:47
 * @version 1.0
 */
public interface IFeeListService extends IBaseService<FeeList>, ProxySelf<IFeeListService>{
	/**
     * 根据条件查询feeList 
     * @author chengye.hu@hand-china.com
     * @param requestContext  请求
     * @param feeList  封装参数对象
     * @param page     查询页
     * @param pageSize 页面大小
     * @return List<FeeList> 所有符合的结果集
     */
	List<FeeList> feeListQuery(IRequest requestContext, FeeList feeList, int page, int pageSize);

	List<FeeList> feeListUpdate(IRequest requestContext, List<FeeList> feeLists, String operation);

	List<VersionStructure> structureQuery(BuildingVersion buildingVersion, IRequest requestContext);

	List<FeeList> feeListPreview(FeeListNew feeListNew, IRequest requestContext)throws Exception;

}
