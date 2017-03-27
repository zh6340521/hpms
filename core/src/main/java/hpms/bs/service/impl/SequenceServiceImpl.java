package hpms.bs.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.fnd.dto.Company;
import com.hand.hap.fnd.mapper.CompanyMapper;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.bs.dto.Sequence;
import hpms.bs.mapper.SequenceRuleMapper;
import hpms.bs.service.ISequenceService;
import hpms.mdm.dto.Project;
import hpms.mdm.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LoseMyself on 2017/3/7.
 */
@Service
@Transactional
public class SequenceServiceImpl extends BaseServiceImpl<Sequence> implements ISequenceService{
    @Autowired
    private SequenceRuleMapper sequenceRuleMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private ProjectMapper projectMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Override
    public String getNextDocCode(IRequest request, String sequenceCode, Long companyId, Long projectId) {
        List<Sequence> seqList = sequenceRuleMapper.queryValidByCode(sequenceCode);
        //判断查询结果
        if (seqList.size() != 1) {
            throw new RuntimeException("无法生成单据编号，请检查编码规则");
        }

        //定义变量
        String docCode = "";
        String companyCode = "";
        String projectCode = "";

        //获取sequence
        Sequence sequence = new Sequence();
        sequence = seqList.get(0);
        String prefix = sequence.getPrefix();
        String companyFlag = sequence.getCompanyFlag();
        String projectFlag = sequence.getProjectFlag();
        String dateFormat = sequence.getDateFormat();
        Long figure = sequence.getFigure();
        Long startNum = sequence.getStartNum();
        Long currentNum = sequence.getCurrentNum();
        String currentPrefix = sequence.getCurrentPrefix();

        logger.debug("companyFlag：" + companyFlag) ;
        logger.debug("companyId：" + companyId) ;
        //获取公司编码
        if (companyFlag.equals("Y") && companyId != null) {
            logger.debug("if：1") ;
            Company company = new Company();
            company.setCompanyId(companyId);
            company = companyMapper.selectByPrimaryKey(company);
            companyCode = company.getCompanyCode();
        }

        //获取项目编码
        if (projectFlag.equals("Y") && projectId != null) {
            Project project = new Project();
            project.setProjectId(projectId);
            project = projectMapper.selectByPrimaryKey(project);
            projectCode = project.getProjectCode();
        }

        //获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //获取String类型的时间
        String currentDate = sdf.format(date);

        docCode = prefix + companyCode + projectCode + currentDate;

        logger.debug("docCode：" + docCode) ;
        logger.debug("currentPrefix：" + currentPrefix) ;
        logger.debug("currentNum：" + currentNum) ;

        //判断前缀及当前编号
        //首次生产编号或者重新编号
        if (currentNum == null || ! docCode.equals(currentPrefix)) {
            logger.debug("if") ;
            sequence.setCurrentNum(startNum);
            sequence.setCurrentPrefix(docCode);
            docCode = docCode + startNum;
            sequence.set__status("update");
            seqList = super.batchUpdate(request,seqList);
        }
        //根据当前编号生产下个编号
        else {
            logger.debug("else") ;
            if (String.valueOf(currentNum + 1).length()  > figure) {
                throw new RuntimeException("无法生成设备编号，超出终止编码");
            } else {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < String.valueOf(currentNum + 1).length() - figure; i++) {
                    sb.append("0");
                }
                sequence.setCurrentNum(currentNum + 1);
                docCode = currentPrefix + sb.toString() + (currentNum + 1);
                sequence.set__status("update");
                seqList = super.batchUpdate(request,seqList);
            }
        }
        //返回编号
        logger.debug("docCode：" + docCode) ;
        return docCode;
    }
}
