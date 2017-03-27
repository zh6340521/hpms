package hpms.fin.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.Occupation;
import hpms.cs.service.IOccupationService;
import hpms.fin.dto.*;
import hpms.fin.mapper.*;
import hpms.fin.service.IMeterShareResultService;
import hpms.fin.service.IShareRuleBindService;
import hpms.fin.service.IShareRuleService;
import hpms.mdm.dto.EquipmentType;
import hpms.mdm.dto.Fee;
import hpms.mdm.dto.Property;
import hpms.mdm.mapper.BpGeneralMapper;
import hpms.mdm.mapper.EquipmentTypeMapper;
import hpms.mdm.mapper.FeeMapper;
import hpms.mdm.mapper.PropertyMapper;
import hpms.utils.ValidationTableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private PubMeterMapper pubMeterMapper;

    @Autowired
    private IShareRuleService shareRuleService;

    @Autowired
    private IShareRuleBindService shareRuleBindService;

    @Autowired
    private ShareRuleBindMapper shareRuleBindMapper;

    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private IOccupationService occupationService;

    @Autowired
    private FeeListMapper feeListMapper;

    @Autowired
    private BpGeneralMapper bpGeneralMapper;

    @Autowired
    private EquipmentTypeMapper equipmentTypeMapper;

    @Autowired
    private FeeMapper feeMapper;

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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ValidationTableException.class)
    public void myBatchUpdate(IRequest requestCtx, List<MeterShareResult> meterShareResultList) throws ValidationTableException{
        logger.info("创建IBaseService的动态代理");
        IBaseService self = (IBaseService) AopContext.currentProxy();

        List<MeterShareResult> m1List = new ArrayList<>();
        List<MeterShareResult> m2List = new ArrayList<>();
        List<MeterShareResult> m3List = new ArrayList<>();


        logger.info("根据传入的数据去抄表历史表进行查询");
        for(MeterShareResult msr:meterShareResultList){

            logger.info("查询之前的数据并进行删除");
            findMeterShareResultData(msr);


            logger.info("查询[公表抄表]中的仪表编码，仪表名称");
            PubMeter pm = new PubMeter();
            pm.setCompanyId(msr.getCompanyId());   //公司id
            pm.setProjectId(msr.getProjectId());    //项目id
            pm.setEquipmentTypeId(msr.getEquipmentTypeId());   //仪表类型id

            List<PubMeter> pmList = pubMeterMapper.queryPubMeter(pm);

            if(!pmList.isEmpty()&&pmList.size()!=0){
                for(PubMeter p1:pmList) {
                    logger.info("查询[抄表历史]中的金额");
                    MeterReadHis  mrh = new MeterReadHis();
                    mrh.setCompanyId(msr.getCompanyId());  //公司id
                    mrh.setProjectId(msr.getProjectId());  //项目id
                    mrh.setEquipmentTypeId(msr.getEquipmentTypeId()); //仪表类型id
                    mrh.setYear(msr.getYear());  //费用日期 年

                    mrh.setStartMonth(msr.getStartMonth());   //开始月份
                    mrh.setEndMonth(msr.getEndMonth());    //结束月份
                    mrh.setEquipmentId(p1.getEquipmentId());  //仪表id

                    Float meterTotalAmount=0.00f;  //总金额

                    List<MeterReadHis> meterReadHises = meterReadHisMapper.queryMeterReadHisForMsr(mrh);
                    if(!meterReadHises.isEmpty()&&meterReadHises.size()!=0){
                        for(MeterReadHis mr:meterReadHises){



                            logger.info("历史表中的总金额");
                            meterTotalAmount = mr.getMeterTotalAmount();



                            logger.info("查询[公表分摊]仪表编码，查询公表分摊中的分摊规则");
                            ShareRule sr = new ShareRule();
                            sr.setCompanyId(msr.getCompanyId());//公司id
                            sr.setProjectId(msr.getProjectId());//项目id
                            sr.setEquipmentTypeId(msr.getEquipmentTypeId());//仪表类型id

                            sr.setEquipmentId(p1.getEquipmentId());//仪表id

                            List<ShareRule> srList = shareRuleService.select(requestCtx,sr, 1, 10);

                            String shareRule="";   //分摊金额

                            int roomSize=0;//房间个数
                            Long shareRuleId=0L;

                            if(!srList.isEmpty()&&srList.size()!=0){
                                for(ShareRule s1:srList){
                                    logger.info("查询分摊规则");
                                    shareRule = s1.getShareRule();
                                    shareRuleId = s1.getShareRuleId();
                                }

                                logger.info("查询公表分摊下绑定的房间");
                                ShareRuleBind sr1 = new ShareRuleBind();
                                sr1.setCompanyId(msr.getCompanyId());//公司id
                                sr1.setProjectId(msr.getProjectId());//项目id
                                sr1.setShareRuleId(shareRuleId);  //分摊规则id



                                List<ShareRuleBind> srbList = shareRuleBindMapper.findAllShareRuleBind(sr1);
                                if(!srbList.isEmpty()&&srbList.size()!=0){
                                    for(ShareRuleBind srb:srbList) {
                                        roomSize = srbList.size();

                                        logger.info("将查询得到的数据赋给公表分摊结果表");
                                        MeterShareResult msr1  = new MeterShareResult();
                                        msr1.setInvoiceCode(mr.getInvoiceCode());  //发票号
                                        msr1.setCallableDate(mr.getReadDate());   //费用日期
                                        msr1.setStatus(mr.getStatus());   //状态
                                        msr1.setEquipmentId(mr.getEquipmentId());  //设备id
                                        msr1.setCompanyId(mr.getCompanyId());    //公司id
                                        msr1.setProjectId(mr.getProjectId());  //项目id
                                        msr1.setEquipmentTypeId(mr.getEquipmentTypeId()); //设备类型id

                                        msr1.setMsDate(new Date());   //分摊日期为当前时间
                                        msr1.setPropertyId(srb.getPropertyId());  //建筑实体id

                                        Occupation o =new Occupation();
                                        o.setPropertyId(srb.getPropertyId());
                                        o.setStatus("IN");
                                        List<Occupation> oList= occupationService.select(requestCtx,o, 1, 10);
                                        if(!oList.isEmpty()&&oList.size()!=0) {
                                            for (Occupation o1 : oList) {
                                                msr1.setMsPerson(o1.getCustomerName());  //分摊人
                                            }
                                        }

                                        m1List.add(msr1);
                                    }
                                   /* logger.info("查询分摊人");
                                    for(ShareRuleBind s1:srbList){
                                        Occupation o =new Occupation();
                                        o.setPropertyId(s1.getPropertyId());
                                        o.setStatus("IN");
                                       List<Occupation> oList= occupationService.select(requestCtx,o, 1, 10);
                                        if(!oList.isEmpty()&&oList.size()!=0){
                                            for(Occupation o1:oList){
                                                MeterShareResult msr4  = new MeterShareResult();
                                                msr4.setMsPerson(o1.getCustomerName());
                                                m4List.add(msr4);
                                            }
                                        }

                                    }*/


                                        logger.info("根据分摊规则来计算分摊金额");


                                        if(shareRule.equals("MEMBER")||shareRule=="MEMBER"){
                                            logger.info("按住户分摊");

                                            List<ShareRuleBind> srbList2 = shareRuleBindMapper.findAllShareRuleBind(sr1);
                                            for(ShareRuleBind s:srbList2){
                                                Float msMount = meterTotalAmount/roomSize;
                                                MeterShareResult msr2  = new MeterShareResult();
                                                msr2.setMsMount(msMount);   //分摊金额
                                                m3List.add(msr2);
                                            }


                                        }else if(shareRule.equals("AREA")||shareRule=="AREA"){
                                            List<Long> propertyIdList = new ArrayList<>();

                                            List<Property> pList = new ArrayList<>();
                                            BigDecimal sumFeeArea = new BigDecimal(0);
                                            logger.info("查询公表分摊绑定下所有的建筑实体");
                                            List<ShareRuleBind> srbList1 = shareRuleBindMapper.findAllShareRuleBind(sr1);


                                            for(ShareRuleBind s:srbList1){
                                                propertyIdList.add(s.getPropertyId());
                                            }

                                            logger.info("按面积分摊");
                                            Property p =new Property();
                                            for(Long propertyId:propertyIdList) {
                                                p.setPropertyId(propertyId);

                                                logger.info("查询该建筑代码的建筑档案下的收费面积");
                                                List<Property> pList1 = propertyMapper.propertyQuery(p);

                                                //Float sumFeeArea=0.0f;//房间总面积


                                                if (!pList1.isEmpty() && pList1.size() != 0) {
                                                    for (Property p2 : pList1) {
                                                        if (p2.getFeeArea() == null) {
                                                            throw new ValidationTableException("未找到房间收费面积！", null);
                                                        } else {
                                                            logger.info("算出所有房间的总面积");
                                                            for (int m = 0; m < pList1.size(); m++) {
                                                                BigDecimal a = new BigDecimal(pList1.get(m).getFeeArea());
                                                                sumFeeArea = sumFeeArea.add(a);
                                                            }
                                                        }

                                                    }
                                                }
                                                pList.addAll(pList1);
                                            }

                                            logger.info("收费面积");
                                            List<Float> feeAreaList = new ArrayList<>();
                                            for(Property p2:pList){
                                                feeAreaList.add(p2.getFeeArea());
                                            }


                                            BigDecimal c = new BigDecimal(0.00);   //定义百分比
                                            for(Float f:feeAreaList){
                                                MeterShareResult msr2  = new MeterShareResult();
                                                BigDecimal b=new BigDecimal(f);
                                                c=b.divide(sumFeeArea, 2, RoundingMode.HALF_UP);
                                                //pList.get(i).setFloorPercentage(c);

                                                logger.info("计算分摊金额");
                                                BigDecimal mta = new BigDecimal(meterTotalAmount);  //总金额
                                                Float msMount=c.multiply(mta).floatValue();

                                                msr2.setMsMount(msMount);
                                                m3List.add(msr2);

                                            }

                                        }

                                    }else{
                                    throw new ValidationTableException("该分摊规则下没有房间！", null);
                                }

                    }

                            }

                        }



                    }

                }
            }


        //将分摊金额的值赋给m1List
        for(int i=0;i<m1List.size();i++){
            m1List.get(i).setMsMount(m3List.get(i).getMsMount());

        }


        m2List.addAll(m1List);
        //将数据保存到数据库
        for(MeterShareResult m1:m2List){
            if(m1.getShareResultId()!=null){
                self.updateByPrimaryKey(requestCtx,m1);
            }else{
                self.insertSelective(requestCtx,m1);
            }
        }

        }


    //根据设备类型id和费用日期查询历史表的数据
    public void findMeterShareResultData(MeterShareResult msr){

        List<MeterShareResult> mList =  meterShareResultMapper.findMsrData(msr);
        logger.info("如果存在就将其删除");
        if(!mList.isEmpty()&&mList.size()!=0){
            for(MeterShareResult m1:mList){
                meterShareResultMapper.delete(m1);
            }
        }
    }








    @Override
    public List<MeterShareResult> findAllMeterShareResult(IRequest requestContext, MeterShareResult msr, int page, int pageSize) {
        List<MeterShareResult> msrList = meterShareResultMapper.findMeterShareResult(msr);
        return msrList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeStaus(IRequest requestCtx, List<MeterShareResult> meterShareResultList) {
        List<MeterReadHis> mrhList = new ArrayList<>();

        for(MeterShareResult m:meterShareResultList) {
            if(m.getStatus()=="ACTIVE"||m.getStatus().equals("ACTIVE")){
                logger.info("将数据存入应收费用清单表");
                insertDataToFeeList(requestCtx,m);
            }


            meterShareResultMapper.changeMeterShareResult(m);

            logger.info("查询抄表历史表的数据");
            MeterReadHis mr = new MeterReadHis();
            mr = meterReadHisMapper.queryMeterReadHisByData(m).get(0);
            mrhList.add(mr);
        }
            if(!mrhList.isEmpty()&&mrhList.size()!=0){
                for(MeterReadHis mrh:mrhList){
                    logger.info("改变抄表历史表的状态");
                    meterReadHisMapper.changeMeterReadHisStatus(mrh);
                }

            }

        }

    //将公表分摊查询的数据插入应收费用清单
    public void insertDataToFeeList(IRequest requestCtx,MeterShareResult m){
        FeeList fl = new FeeList();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
        String formDate =sdf.format(date);
        fl.setFeeListCode(formDate);   //计费单编号

        fl.setFeeStatus("CREATED");   //计费单状态  “已生成”

        fl.setCustomerName(m.getMsPerson());  //所属客户

        //根据分摊人和建筑名称找到建筑代码
        Occupation o =new Occupation();
        o.setPropertyId(m.getPropertyId());
        o.setCustomerName(m.getMsPerson());

        List<Occupation> oList= occupationService.select(requestCtx,o, 1, 10);
        if(!oList.isEmpty()&&oList.size()!=0){
            for(Occupation oc:oList){
                fl.setOccupationId(oc.getOccupationId());
            }
        }else{
            fl.setOccupationId(null);
        }

             //对费用日期进行类型转换
            SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
            String a1=dateformat1.format(m.getCallableDate());
            fl.setFeePeriod(a1);   //收费期间

            //根据仪表类型id查询仪表类型名称
            EquipmentType et = new EquipmentType();
            et.setEquipmentTypeId(m.getEquipmentTypeId());
            List<EquipmentType> equipmentTypeList =equipmentTypeMapper.select(et);
            if(!equipmentTypeList.isEmpty()&&equipmentTypeList.size()!=0){
                for(EquipmentType e:equipmentTypeList){

                    //根据分摊的仪表的仪表类型从费用项目表中读取相应的费用项的费用类型
                    Fee f = new Fee();
                    f.setEquipmentType(e.getTypeName());
                    List<Fee> feeList =feeMapper.queryFee(f);
                    if(!feeList.isEmpty()&&feeList.size()!=0){
                        for(Fee fee:feeList){
                            fl.setFeeTypeId(fee.getFeeTypeId());  //款项类型ID
                            fl.setFeeId(fee.getFeeId());   //收费项目ID
                            fl.setTransType(fee.getTransType());  //交易类型

                        }
                    }else{
                        fl.setFeeTypeId(null);  //款项类型ID
                        fl.setFeeId(null);   //收费项目ID
                        fl.setTransType(null);  //交易类型
                    }

                    fl.setUnitPrice(m.getMsMount());   //单价
                    fl.setFeeQuantity(1L);     //数量为“1”
                    fl.setCurrencyType("CNY");  //默认为“CNY”
                    fl.setSegmentFlag(null);   //峰度 默认为null

                    //查询抄表记录中的抄表数
                    MeterReadHis mr = new MeterReadHis();
                    mr.setEquipmentId(m.getEquipmentId());
                    List<MeterReadHis> meterReadHises = meterReadHisMapper.queryMeterReadHis(mr);
                    if(!meterReadHises.isEmpty()&&meterReadHises.size()!=0){
                        for(MeterReadHis r:meterReadHises){
                            fl.setLastRecord(r.getLastRead());  //本次抄表数
                            fl.setPresentRecord(r.getCurrentRead());  //上次抄表数
                        }
                    }else{
                        fl.setLastRecord(null);  //本次抄表数
                        fl.setPresentRecord(null);  //上次抄表数
                    }

                    BigDecimal a = new BigDecimal(m.getMsMount());
                    BigDecimal b = new BigDecimal(1L);
                    BigDecimal c =a.multiply(b.setScale(2,BigDecimal.ROUND_HALF_UP));
                    fl.setGrossAmount(c.floatValue());  //单价*数量

                    fl.setAdjAmount((float)0);//折扣
                    fl.setOverduePayment((float)0);//违约金;

                    fl.setAccruedDate(new Date()); //计费日期起 分摊结果中的转入计费日期
                    fl.setDateTo(new Date());   //计费截止日期
                    fl.setGenerateDate(new Date());//生成日期

                    fl.setCountedDate(null);//计提日期	空

                    fl.setTotalAmount(c.floatValue()); //应收合计 总价
                    fl.setRemark(null);  //备注 null
                    fl.setDataSource(null);  //数据来源 null
                    fl.setReferenceNumber(null);  //参考编号 null
                    fl.setPayPartRepair(null);  //维修单结算方  null
                    fl.setCountedDate(null);   //计提日期  null

                    logger.info("将数据存入数据库");
                    feeListMapper.insertSelective(fl);

                }
            }

        }



    }


