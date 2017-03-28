package hpms.mdm.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.mdm.dto.StoreHouse;
import java.util.List;

public interface StoreHouseMapper extends Mapper<StoreHouse>{

    List<StoreHouse> queryAllStoreHouse(StoreHouse storeHouse);

}