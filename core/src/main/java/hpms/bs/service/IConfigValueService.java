package hpms.bs.service;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hpms.bs.dto.ConfigValue;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name IConfigValueService
 * @description
 * @date 2017/3/1
 */

public interface IConfigValueService extends IBaseService<ConfigValue>,ProxySelf<IConfigValueService> {

}