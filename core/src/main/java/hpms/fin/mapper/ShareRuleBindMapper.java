package hpms.fin.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hpms.fin.dto.ShareRuleBind;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/20   19:29
 */
public interface ShareRuleBindMapper extends Mapper<ShareRuleBind>{
    int myInsert(ShareRuleBind shareRuleBind);

    /**
     * 查询全部公表分摊绑定房间数据
     * @author fuchun.hu@hand-china.com
     * 2017年3月22日 15:38:06
     * @param sr
     * @return
     */
    List<ShareRuleBind> findAllShareRuleBind(ShareRuleBind sr);
}
