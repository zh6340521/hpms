package hpms.fin.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.fin.dto.MeterCharge;
import hpms.fin.dto.MeterReadHis;
import hpms.fin.dto.MeterShareResult;
import hpms.fin.mapper.MeterChargeMapper;
import hpms.fin.mapper.MeterReadHisMapper;
import hpms.fin.mapper.MeterShareResultMapper;
import hpms.fin.service.IMeterShareResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 * @name MeterShareResultServiceImpl:公表分摊结果实现类
 * @description
 * @date 2017/3/20
 */
@Service
public class MeterShareResultServiceImpl extends BaseServiceImpl<MeterShareResult> implements IMeterShareResultService {
    private Logger logger = LoggerFactory.getLogger(MeterShareResultServiceImpl.class);
    @Autowired
    private MeterShareResultMapper meterShareResultMapper;

    @Autowired
    private MeterChargeMapper mterChargeMapper;

    @Autowired
    private MeterReadHisMapper meterReadHisMapper;

    @Override
    public List<MeterCharge> findEquipmentTypeByMeterCharge(MeterCharge meterCharge, IRequest requestContext) {
        List<MeterCharge> mcList = mterChargeMapper.findEquipmentTypeByMeterCharge(meterCharge);
        return mcList;
    }

    @Override
    public List<MeterShareResult> findYear() {

       logger.info("查询当前系统年份");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);

        logger.info("获得当前系统年份的上下五年");
        int a =Integer.parseInt(formatDate);
        String b = String.valueOf(a-1);
        String c = String.valueOf(a-2);
        String d = String.valueOf(a-3);
        String e = String.valueOf(a-4);
        String f = String.valueOf(a-5);

        String g = String.valueOf(a+1);
        String h = String.valueOf(a+2);
        String i = String.valueOf(a+3);
        String j = String.valueOf(a+4);
        String k = String.valueOf(a+5);



        MeterShareResult m1 = new MeterShareResult();
        m1.setYear(f);

        MeterShareResult m2 = new MeterShareResult();
        m2.setYear(e);


        MeterShareResult m3 = new MeterShareResult();
        m3.setYear(d);

        MeterShareResult m4 = new MeterShareResult();
        m4.setYear(c);

        MeterShareResult m5 = new MeterShareResult();
        m5.setYear(b);

        MeterShareResult m6 = new MeterShareResult();
        m6.setYear(formatDate);

        MeterShareResult m7 = new MeterShareResult();
        m7.setYear(g);

        MeterShareResult m8 = new MeterShareResult();
        m8.setYear(h);

        MeterShareResult m9 = new MeterShareResult();
        m9.setYear(i);

        MeterShareResult m10 = new MeterShareResult();
        m10.setYear(j);

        MeterShareResult m11 = new MeterShareResult();
        m11.setYear(k);

        //将该11条数据插入list中
        List<MeterShareResult> showYearList = Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11);

        return showYearList;




    }

    @Override
    public List<MeterShareResult> findMonth() {
        logger.info("月份的下拉框选值为0~12");
        String m1 = String.valueOf(1);
        String m2 = String.valueOf(2);
        String m3 = String.valueOf(3);
        String m4 = String.valueOf(4);
        String m5 = String.valueOf(5);
        String m6 = String.valueOf(6);
        String m7 = String.valueOf(7);
        String m8 = String.valueOf(8);
        String m9 = String.valueOf(9);
        String m10 = String.valueOf(10);
        String m11 = String.valueOf(11);
        String m12 = String.valueOf(12);

        MeterShareResult ms1 = new MeterShareResult();
        MeterShareResult ms2 = new MeterShareResult();
        MeterShareResult ms3 = new MeterShareResult();
        MeterShareResult ms4 = new MeterShareResult();
        MeterShareResult ms5 = new MeterShareResult();
        MeterShareResult ms6 = new MeterShareResult();
        MeterShareResult ms7 = new MeterShareResult();
        MeterShareResult ms8 = new MeterShareResult();
        MeterShareResult ms9 = new MeterShareResult();
        MeterShareResult ms10 = new MeterShareResult();
        MeterShareResult ms11 = new MeterShareResult();
        MeterShareResult ms12 = new MeterShareResult();

        ms1.setMonth(m1);
        ms2.setMonth(m2);
        ms3.setMonth(m3);
        ms4.setMonth(m4);
        ms5.setMonth(m5);
        ms6.setMonth(m6);
        ms7.setMonth(m7);
        ms8.setMonth(m8);
        ms9.setMonth(m9);
        ms10.setMonth(m10);
        ms11.setMonth(m11);
        ms12.setMonth(m12);

        //将该11条数据插入list中
        List<MeterShareResult> showMonthList = Arrays.asList(ms1,ms2,ms3,ms4,ms5,ms6,ms7,ms8,ms9,ms10,ms11,ms12);
        return showMonthList;

    }

    @Override
    public void myBatchUpdate(IRequest requestCtx, List<MeterShareResult> meterShareResultList) {
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        logger.info("根据传入的数据去抄表历史表进行查询");
        for(MeterShareResult msr:meterShareResultList){
            MeterReadHis  mrh = new MeterReadHis();
            mrh.setCompanyId(msr.getCompanyId());  //公司id
            mrh.setProjectId(msr.getProjectId());  //项目id
            mrh.setEquipmentId(msr.getEquipmentId()); //仪表id
            mrh.setYear(msr.getYear());  //费用日期 年



            mrh.setStartMonth(msr.getStartMonth());   //开始时间
            mrh.setEndMonth(msr.getEndMonth());    //结束时间

            logger.info("查询抄表历史中的数据");
            List<MeterReadHis> meterReadHises = meterReadHisMapper.queryMeterReadHisForMsr(mrh);

            if(!meterReadHises.isEmpty()&&meterReadHises.size()!=0){
                for(MeterReadHis mr:meterReadHises){
                    logger.info("将查询得到的数据赋给公表分摊结果表");
                    msr.setInvoiceCode(mr.getInvoiceCode());  //发票号
                    msr.setCallableDate(mr.getReadDate());   //费用日期
                    msr.setStatus(mr.getStatus());   //状态
                }
            }

            logger.info("将propertyId暂存到数据库");
            Long propertyId=new Long((long)10041);
            msr.setPropertyId(propertyId);

            logger.info("进行批量更新");
            if(msr.getShareResultId()!=null){
                self.updateByPrimaryKey(requestCtx,msr);
            }else{
                self.insertSelective(requestCtx,msr);
            }


        }



    }
}
