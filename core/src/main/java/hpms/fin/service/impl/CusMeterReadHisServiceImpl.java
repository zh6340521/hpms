package hpms.fin.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hpms.cs.dto.Occupation;
import hpms.fin.dto.FeeList;
import hpms.fin.mapper.CusMeterReadHisMapper;
import hpms.fin.mapper.FeeListMapper;
import hpms.mdm.dto.Fee;
import hpms.mdm.mapper.FeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hpms.fin.dto.CusMeterReadHis;
import hpms.fin.service.ICusMeterReadHisService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CusMeterReadHisServiceImpl extends BaseServiceImpl<CusMeterReadHis> implements ICusMeterReadHisService{

    @Autowired
    private CusMeterReadHisMapper cusMeterReadHisMapper;
    @Autowired
    private FeeListMapper feeListMapper;
    @Autowired
    private FeeMapper feeMapper;
    @Override
    public List<CusMeterReadHis> queryMeterReadHis(IRequest requestContext, CusMeterReadHis meterReadHis, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return cusMeterReadHisMapper.queryCusMeterReadHis(meterReadHis);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<CusMeterReadHis> changeMeterReadHis(IRequest requestContext, List<CusMeterReadHis> cusMeterReadHises) {
        for(CusMeterReadHis cusMeterReadHis:cusMeterReadHises){
            if(cusMeterReadHis.getStatus().equals("ACTIVE")){
                CusMeterReadHis cusMeterReadHis1=self().selectByPrimaryKey(requestContext,cusMeterReadHis);
                cusMeterReadHis1.setStatus("FREEZED");
                self().updateByPrimaryKeySelective(requestContext,cusMeterReadHis1);
                FeeList feeList=new FeeList();
                Date date = new Date();
                Occupation occupation=cusMeterReadHisMapper.queryOccupationIn(cusMeterReadHis);
                if(occupation==null){
                    throw new RuntimeException("该房间没有人入住！");
                }else{
                    feeList.setOccupationId(occupation.getOccupationId());
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
                SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
                String formDate =sdf.format(date);
                String feePriod = sdf1.format(cusMeterReadHis.getReadDate());
                feeList.setFeeStatus("CREATED");
                feeList.setFeeListCode(formDate);
                feeList.setFeePeriod(feePriod);

                Fee fee=new Fee();
                fee.setEquipmentType(cusMeterReadHis.getTypeName());
                fee.setEnableFlag("Y");
                if(feeMapper.queryFee(fee)!=null){
                    Long feeId=feeMapper.queryFee(fee).get(0).getFeeId();
                    feeList.setFeeId(feeId);
                    feeList.setTransType(feeMapper.queryFee(fee).get(0).getTransType());
                    feeList.setFeeTypeId(feeMapper.queryFee(fee).get(0).getFeeTypeId());
                }else{
                    throw new RuntimeException("未添加仪表类型的费项");
                }
                feeList.setUnitPrice(cusMeterReadHis.getMeterTotalAmount()/cusMeterReadHis.getMeterTotalUse().longValue());
                feeList.setFeeQuantity(cusMeterReadHis.getMeterTotalUse().longValue());
                feeList.setCurrencyType("CNY");
                feeList.setLastRecord(cusMeterReadHis.getLastRead());
                feeList.setPresentRecord(cusMeterReadHis.getCurrentRead());
                feeList.setGrossAmount(cusMeterReadHis.getMeterTotalAmount());
                feeList.setTotalAmount(cusMeterReadHis.getMeterTotalAmount());
                feeList.setAccruedDate(new Date());
                feeList.setDateTo(new Date());
                feeList.setGenerateDate(new Date());
                feeList.setCompanyId(cusMeterReadHis.getCompanyId());
                feeListMapper.insertSelective(feeList);
            }

        }

        return cusMeterReadHises;
    }

    @Override
    public List<CusMeterReadHis> batchMeterReadHis(IRequest requestContext, CusMeterReadHis cusMeterReadHis, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return cusMeterReadHisMapper.batchCusMeterReadHis(cusMeterReadHis);
    }


}