package hpms.bs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by LoseMyself on 2017/3/7.
 */
@Table(name = "HPMS_SEQUENCE")
public class Sequence extends BaseDTO{
    /**
     * 表ID，主键，供其他表做外键
     */
    @Id
    @GeneratedValue(generator = GENERATOR_TYPE)
    private Long sequenceId;

    /*
     * 序列编码
     */
    @Condition(operator = LIKE)
    private String sequenceCode;

    /*
     * 序列名称
     */
    @Condition(operator = LIKE)
    private String sequenceName;

    /*
     * 公司
     */
    private String companyFlag;

    /*
     * 项目
     */
    private String projectFlag;

    /*
     * 前缀
     */
    private String prefix;

    /*
     * 日期格式
     */
    private String dateFormat;

    /*
     * 流水号位数
     */
    private Long figure;

    /*
     * 起始编号
     */
    private Long startNum;

    /*
     * 当前编号
     */
    private Long currentNum;

    /*
     * 有效期起
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDateActive;

    public Long getSequenceId() {
        return sequenceId;
    }

    public Sequence setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
        return this;
    }

    public String getSequenceCode() {
        return sequenceCode;
    }

    public Sequence setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
        return this;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public Sequence setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
        return this;
    }

    public String getCompanyFlag() {
        return companyFlag;
    }

    public Sequence setCompanyFlag(String companyFlag) {
        this.companyFlag = companyFlag;
        return this;
    }

    public String getProjectFlag() {
        return projectFlag;
    }

    public Sequence setProjectFlag(String projectFlag) {
        this.projectFlag = projectFlag;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public Sequence setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public Sequence setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Long getFigure() {
        return figure;
    }

    public Sequence setFigure(Long figure) {
        this.figure = figure;
        return this;
    }

    public Long getStartNum() {
        return startNum;
    }

    public Sequence setStartNum(Long startNum) {
        this.startNum = startNum;
        return this;
    }

    public Long getCurrentNum() {
        return currentNum;
    }

    public Sequence setCurrentNum(Long currentNum) {
        this.currentNum = currentNum;
        return this;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public Sequence setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
        return this;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public Sequence setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
        return this;
    }

    /*
        * 有效期至
        */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDateActive;
}
