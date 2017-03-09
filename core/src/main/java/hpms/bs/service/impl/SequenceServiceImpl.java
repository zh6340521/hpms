package hpms.bs.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.Sequence;
import hpms.bs.mapper.SequenceRuleMapper;
import hpms.bs.service.ISequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by LoseMyself on 2017/3/7.
 */
@Service
@Transactional
public class SequenceServiceImpl extends BaseServiceImpl<Sequence> implements ISequenceService{
    @Autowired
    private SequenceRuleMapper sequenceRuleMapper;

    @Override
    public boolean isDateOk(List<Sequence> sequences) {
        List<Sequence> seq = sequenceRuleMapper.getDate(sequences.get(0).getSequenceCode());
        Date startDate = null;
        Date endDate = null;
        Date sd = sequences.get(0).getStartDateActive();
        Date ed = sequences.get(0).getEndDateActive();
        for(int i = 0; i < seq.size(); ++i){
            startDate = seq.get(i).getStartDateActive();
            endDate = seq.get(i).getEndDateActive();
            if(ed == null){
                if(endDate.before(sd)){
                    return true;
                }else
                    return false;
            }
            if(endDate == null){
                if(ed.before(startDate)){
                    return true;
                }else
                    return false;
            }else if(sd.after(endDate)){
                return true;
            }else if(ed.before(startDate)){
                return true;
            }else
                return false;
        }
        return true;
    }
}
