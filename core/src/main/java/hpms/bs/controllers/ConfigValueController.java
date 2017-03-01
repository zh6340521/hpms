package hpms.bs.controllers;/**
 * Created by user1 on 2017/3/1.
 */

import com.hand.hap.system.controllers.BaseController;
import hpms.bs.service.IConfigValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name ConfigValueController
 * @description
 * @date 2017/3/1
 */
@Controller
public class ConfigValueController extends BaseController {
    @Autowired
    private IConfigValueService configValueService;
}
