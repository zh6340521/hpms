package hpms.mdm.service.impl;/**
 * Created by user1 on 2017/2/15.
 */

import com.github.pagehelper.PageHelper;
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
                int a = UniqueVersion(bvs,bv.getVersionId(),bv);
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

    @Override
    public List<BuildingVersion> selectBuildingVersion(IRequest requestCtx, BuildingVersion bv, int page, int pagesize) {
        PageHelper.startPage(page,pagesize);
        return buildingVersionMapper.selectBuildingVersion(bv);
    }


    //验证版本id+默认版本的唯一性
    public int UniqueVersion(List<BuildingVersion> bvs, Long  versionId,BuildingVersion bv) {
        int count = 0;
        bv.setVersionId(versionId);

        logger.info("当传入的 默认版本 不为空且值为Y时");
        if(bv.getDefaultVersion()!=null&&bv.getDefaultVersion()!=""&&"Y".equals(bv.getDefaultVersion())){
            List<BuildingVersion> bvList = buildingVersionMapper.findDefaultVersion(bv);
            count = bvList.size();
            for(BuildingVersion b1:bvList){
                for(BuildingVersion b2:bvs){
                    if(b1.getDefaultVersion().equals(b2.getDefaultVersion())){
                        return count;
                    }else{
                        count = count-1;
                        break;
                    }
                }
            }
        }



        return count;

    }




}
