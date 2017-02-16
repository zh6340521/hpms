package hpms.mdm.service.impl;/**
 * Created by user1 on 2017/2/15.
 */

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.mapper.BuildingVersionMapper;
import hpms.mdm.service.IBuildingVersionService;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name BuildingVersionServiceImpl
 * @description:建筑版本接口实现类
 * @date 2017/2/15
 */
@Service
@Transactional
public class BuildingVersionServiceImpl extends BaseServiceImpl<BuildingVersion> implements IBuildingVersionService {
    private Logger logger = LoggerFactory.getLogger(BuildingVersionServiceImpl.class);

    @Autowired
    private BuildingVersionMapper buildingVersionMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ValidationTableException.class)
    public void myBatchUpdate(IRequest requestCtx, List<BuildingVersion> bvs) throws ValidationTableException {
        for(BuildingVersion bv:bvs){
            bv.setLastUpdatedBy(requestCtx.getUserId());
            bv.setLastUpdateDate(new Date());

            if(bv.getDefaultVersion()=="Y"||"Y".equals(bv.getDefaultVersion())){

                logger.info("先查询表中是否存在默认版本");
                int a = findDefaultVersionCount();
                if(a>0){
                    logger.info("将这条记录删除，并抛出错误信息");
                    bvs.remove(bv);
                    throw new ValidationTableException("已经存在一个默认版本！", null);
                }
            }

            logger.info("进行批量更新或插入");
            if(bv.getVersionId()!=null){
                buildingVersionMapper.updateByPrimaryKey(bv);
            }else{
                buildingVersionMapper.insertSelective(bv);
            }

        }
    }


    /**
     * 查询表中默认版本数量
     * @return
     */
    public int findDefaultVersionCount(){
        return buildingVersionMapper.findDefaultVersion();
    }


}
