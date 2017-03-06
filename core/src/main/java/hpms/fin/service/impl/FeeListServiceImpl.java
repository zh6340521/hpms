package hpms.fin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.Code;
import com.hand.hap.system.dto.CodeValue;
import com.hand.hap.system.mapper.CodeMapper;
import com.hand.hap.system.mapper.CodeValueMapper;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hpms.bs.dto.ConfigValue;
import hpms.bs.mapper.ConfigValuesMapper;
import hpms.cs.dto.Occupation;
import hpms.cs.mapper.OccupationMapper;
import hpms.fin.dto.FeeList;
import hpms.fin.dto.FeeListNew;
import hpms.fin.mapper.FeeListMapper;
import hpms.fin.service.IFeeListService;
import hpms.mdm.dto.BuildingVersion;
import hpms.mdm.dto.CalRuleLine;
import hpms.mdm.dto.CalculateElement;
import hpms.mdm.dto.CalculateRule;
import hpms.mdm.dto.Fee;
import hpms.mdm.dto.FeeType;
import hpms.mdm.dto.PriceLine;
import hpms.mdm.dto.Property;
import hpms.mdm.dto.VersionStructure;
import hpms.mdm.mapper.BuildingVersionMapper;
import hpms.mdm.mapper.CalRuleLineMapper;
import hpms.mdm.mapper.CalculateElementMapper;
import hpms.mdm.mapper.CalculateRuleMapper;
import hpms.mdm.mapper.FeeMapper;
import hpms.mdm.mapper.FeeTypeMapper;
import hpms.mdm.mapper.PriceLineMapper;
import hpms.mdm.mapper.PropertyMapper;
import hpms.mdm.mapper.VersionStructureMapper;
import hpms.utils.ValidationTableException;
/**
 * 
 * @name FeeListServiceImpl
 * @description 应收费用清单Impl
 * @author chengye.hu@hand-china.com	2017年2月27日下午4:17:44
 * @version 1.0
 */
@Service
public class FeeListServiceImpl extends BaseServiceImpl<FeeList> implements IFeeListService{
	@Autowired
	private FeeListMapper feeListMapper;
	@Autowired
	private BuildingVersionMapper buildingVersionMapper;
	@Autowired
	private VersionStructureMapper versionStructureMapper;
	@Autowired
	private PropertyMapper propertyMapper;
	@Autowired
	private ConfigValuesMapper configValuesMapper;
	@Autowired
	private OccupationMapper occupationMapper;
	@Autowired
	private PriceLineMapper priceLineMapper;
	@Autowired
	private FeeTypeMapper feeTypeMapper;
	@Autowired
	private FeeMapper feeMapper;
	@Autowired
	private CodeMapper codeMapper;
	@Autowired
	private CodeValueMapper codeValueMapper;
	@Autowired
	private CalculateRuleMapper calculateRuleMapper;
	@Autowired
	private CalRuleLineMapper calRuleLineMapper;
	@Autowired
	private CalculateElementMapper calculateElementMapper;
	private static List<VersionStructure> returnList = new ArrayList<VersionStructure>();
	@Override
	public List<FeeList> feeListQuery(IRequest requestContext, FeeList feeList, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return feeListMapper.feeListQuery(feeList);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<FeeList> feeListUpdate(IRequest requestContext, List<FeeList> feeLists, String operation) {
		if(operation.equals("REVOCATION")){
			for (FeeList feeList : feeLists) {
				feeList.setFeeStatus("CANCELLED");
				feeListMapper.updateByPrimaryKeySelective(feeList);
			}
		}else if(operation.equals("WITHDRAWING")){
			for (FeeList feeList : feeLists) {
				feeList.setFeeStatus("COUNTED");
				feeListMapper.updateByPrimaryKeySelective(feeList);
			}
		}
		return feeListMapper.feeListQuery(null);
	}

	@Override
	public List<VersionStructure> structureQuery(BuildingVersion buildingVersion, IRequest requestContext) {
		buildingVersion.setDefaultVersion("Y");
		VersionStructure versionStructure3 = new VersionStructure();
		versionStructure3.setVersionId(buildingVersionMapper.selectOne(buildingVersion).getVersionId());
		List<VersionStructure> versionStructures = versionStructureMapper.queryVersionStructure(versionStructure3);
		List<VersionStructure> versionStructures2 = new ArrayList<VersionStructure>();
		for (VersionStructure versionStructure : versionStructures) {
			List<VersionStructure> vs = new ArrayList<VersionStructure>();
			for (VersionStructure versionStructure2 : versionStructures) {
				if(versionStructure.getStructureId().equals(versionStructure2.getParentStructureId())){
					vs.add(versionStructure2);
				}
			}
			if(vs.size()>0){
				versionStructure.setHasChildren(true);
				versionStructure.setItems(vs);
			}
			if(versionStructure.getParentStructureId()==null){
				versionStructures2.add(versionStructure);
			}
			
		}
		return versionStructures2;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<FeeList> feeListPreview(FeeListNew feeListNew, IRequest requestContext) throws Exception {
		PriceLine priceLine = new PriceLine();
		priceLine.setFeeId(feeListNew.getFeeId());
		priceLine = priceLineMapper.selectOne(priceLine);
		if(priceLine.getUnitPrice()>0){
			VersionStructure versionStructure1 = new VersionStructure();
			versionStructure1.setVersionId(feeListNew.getVersionId());
			List<VersionStructure> versionStructures = versionStructureMapper.queryVersionStructure(versionStructure1);
			List<VersionStructure> versionStructures2 = getChildNodes(versionStructures,feeListNew.getStructureId());
			List<VersionStructure> versionStructures3 = new ArrayList<VersionStructure>();
			List<VersionStructure> versionStructures4 = new ArrayList<VersionStructure>();
			if(versionStructures2.size()>0){
				for (VersionStructure versionStructure : versionStructures2) {
					boolean boo = true;
					for (VersionStructure versionStructure2 : versionStructures2) {
						if(versionStructure.getStructureId().equals(versionStructure2.getParentStructureId())){
							boo = false;
						}
					}
					if(boo){
						versionStructures3.add(versionStructure);
					}
				}
			}else{
				versionStructure1.setStructureId(feeListNew.getStructureId());
				versionStructures3.add(versionStructureMapper.selectOne(versionStructure1));
			}
			for (VersionStructure versionStructure3 : versionStructures3) {//遍历所有的根节点
				Property property = new Property();
				property.setPropertyId(versionStructure3.getPropertyId());
				property = propertyMapper.selectOne(property);
				ConfigValue configValue = new ConfigValue();
				configValue.setConfigValueId(property.getPropertyType());
				configValue = configValuesMapper.selectOne(configValue);
				if(!(configValue.getConfigValueNumber().equals(""))){
					continue;
				}
				Occupation occupation = new Occupation();
				occupation.setPropertyId(versionStructure3.getPropertyId());
				List<Occupation> occupations = occupationMapper.select(occupation);
				if(occupations.size()<=0){
					continue;
				}else{
					for (int i = 0; i < occupations.size(); i++) {
						occupation = occupations.get(0);
						if(occupations.get(i).getCreationDate().after(occupation.getCreationDate())){
							occupation = occupations.get(i);
						}
					}
					if(occupation.getStatus().equals("IN")){
						versionStructures4.add(versionStructure3);
					}else{
						continue;
					}
				}
			}
			List<FeeList> feeLists = new ArrayList<FeeList>();
			Fee fee = new Fee();
			fee.setFeeId(feeListNew.getFeeId());
			fee = feeMapper.selectOne(fee);
			if(fee.getBillingFrequency().equals("PERIOD")){//按周期
				for (VersionStructure versionStructure4 : versionStructures4) {
					Occupation occupation = new Occupation();
					occupation.setPropertyId(versionStructure4.getPropertyId());
					List<Occupation> occupations = occupationMapper.select(occupation);
					for (int i = 0; i < occupations.size(); i++) {
						occupation = occupations.get(0);
						if(occupations.get(i).getCreationDate().after(occupation.getCreationDate())){
							occupation = occupations.get(i);
						}
					}
					FeeList feeList2 = new FeeList();
					feeList2.setOccupationId(occupation.getOccupationId());
					List<FeeList> feeLists2 = feeListMapper.select(feeList2);
					if(feeLists2.size()>0){
						for (int i = 0; i < feeLists2.size(); i++) {
							feeList2 = feeLists2.get(0);
							if(feeLists2.get(i).getCreationDate().after(feeList2.getCreationDate())){
								feeList2 = feeLists2.get(i);
							}
						}
						Calendar cal = Calendar.getInstance();
						cal.setTime(feeList2.getDateTo());
						cal.add(Calendar.DATE, 1);
						for (int i = 0; i < feeListNew.getNum(); i++) {
							FeeList feeList = new FeeList();
							Property property = new Property();
							property.setPropertyId(versionStructure4.getPropertyId());
							property = propertyMapper.selectOne(property);
							feeList.setPropertyNumber(property.getPropertyNumber());//建筑代码
							feeList.setPropertyName(property.getPropertyName());//建筑名称
							feeList.setFeeStatus("NEW");
							feeList.setFeeStatusName("新建");
							feeList.setOccupationId(occupation.getOccupationId());//收费对象
							feeList.setCustomerName(occupation.getCustomerName());//客户名称
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
							if(i==0){
								feeList.setAccruedDate(cal.getTime());
								feeList.setDateTo(getMaxMonthDate(cal.getTime()));
								feeList.setFeePeriod(df.parse(cal.getTime().toString()).toString());
							}else{
								feeList.setAccruedDate(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo()));
								feeList.setDateTo(getMaxMonthDate(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo())));
								feeList.setFeePeriod(df.parse(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo()).toString()).toString());
							}
							feeList.setFeeTypeId(feeListNew.getFeeTypeId());//赋值项目类型和收费项目
							FeeType feeType = new FeeType();
							feeType.setFeeTypeId(feeListNew.getFeeTypeId());
							feeList.setFeeTypeName(feeTypeMapper.selectOne(feeType).getFeeTypeName());
							feeList.setFeeId(feeListNew.getFeeId());
							feeList.setFeeName(fee.getFeeName());
							feeList.setUnitPrice(priceLine.getUnitPrice());//定价
							feeList.setCurrencyType(priceLine.getCurrency());//币种
							Code code2 = new Code();
							code2.setCode("HPMS_MDM_PAYMENT_CURRENCY");
							code2 = codeMapper.selectOne(code2);
							CodeValue codeValue2 = new CodeValue();
							codeValue2.setValue(priceLine.getCurrency());
							codeValue2.setCodeId(code2.getCodeId());
							codeValue2 = codeValueMapper.selectOne(codeValue2);
							feeList.setCurrencyTypeName(codeValue2.getMeaning());
							feeList.setTransType(fee.getTransType());//交易类型
							Code code = new Code();
							code.setCode("HPMS_TRANS_TYPE");
							code = codeMapper.selectOne(code);
							CodeValue codeValue = new CodeValue();
							codeValue.setValue(fee.getTransType());
							codeValue.setCodeId(code.getCodeId());
							codeValue = codeValueMapper.selectOne(codeValue);
							feeList.setTransTypeName(codeValue.getMeaning());
							feeList.setAdjAmount(Float.parseFloat("0"));
							feeList.setOverduePayment(Float.parseFloat("0"));
							if(fee.getBillingMethod().equals("FIXED")){
								feeList.setGrossAmount(feeList.getUnitPrice()*Long.parseLong("1"));
							}else if(fee.getBillingMethod().equals("CALCULATED")){
								if(fee.getFeeName().equals("物业费")){
									CalculateRule calculateRule = new CalculateRule(); 
									calculateRule.setCalculateRuleId(priceLine.getCalculateRuleId());
									calculateRule = calculateRuleMapper.selectOne(calculateRule);
									CalRuleLine calRuleLine = new CalRuleLine();
									calRuleLine.setCalculateRuleId(calculateRule.getCalculateRuleId());
									List<CalRuleLine> calRuleLines = calRuleLineMapper.select(calRuleLine);
									for (CalRuleLine calRuleLine2 : calRuleLines) {
										CalculateElement calculateElement = new CalculateElement(); 
										calculateElement.setCalculateElementId(calRuleLine2.getCalculateElementId());
										calculateElement = calculateElementMapper.selectOne(calculateElement);
										if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("ROOM_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getRoomArea()*Long.parseLong("1"));
											break;
										}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("USE_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getUseArea()*Long.parseLong("1"));
											break;
										}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("FEE_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getFeeArea()*Long.parseLong("1"));
											break;
										}
									}
								}else{
									throw new ValidationTableException("收费项目未定价", null);
								}
							}
							feeList.setTotalAmount(feeList.getGrossAmount());
							feeList.setGenerateDate(new Date());
							feeLists.add(feeList);
						}
					}else{
						for (int i = 0; i < feeListNew.getNum(); i++) {
							FeeList feeList = new FeeList();
							Property property = new Property();
							property.setPropertyId(versionStructure4.getPropertyId());
							property = propertyMapper.selectOne(property);
							feeList.setPropertyNumber(property.getPropertyNumber());//建筑代码
							feeList.setPropertyName(property.getPropertyName());//建筑名称
							feeList.setFeeStatus("NEW");
							feeList.setFeeStatusName("新建");
							feeList.setOccupationId(occupation.getOccupationId());//收费对象
							feeList.setCustomerName(occupation.getCustomerName());//客户名称
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
							if(i==0){
								feeList.setAccruedDate(occupation.getFeeDate());
								feeList.setDateTo(getMaxMonthDate(occupation.getFeeDate()));
								feeList.setFeePeriod(df.parse(occupation.getFeeDate().toString()).toString());
							}else{
								feeList.setAccruedDate(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo()));
								feeList.setDateTo(getMaxMonthDate(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo())));
								feeList.setFeePeriod(df.parse(getPerFirstDayOfMonth(feeLists.get(i-1).getDateTo()).toString()).toString());
							}
							feeList.setFeeTypeId(feeListNew.getFeeTypeId());//赋值项目类型和收费项目
							FeeType feeType = new FeeType();
							feeType.setFeeTypeId(feeListNew.getFeeTypeId());
							feeList.setFeeTypeName(feeTypeMapper.selectOne(feeType).getFeeTypeName());
							feeList.setFeeId(feeListNew.getFeeId());
							feeList.setFeeName(fee.getFeeName());
							feeList.setUnitPrice(priceLine.getUnitPrice());//定价
							feeList.setCurrencyType(priceLine.getCurrency());//币种
							Code code2 = new Code();
							code2.setCode("HPMS_MDM_PAYMENT_CURRENCY");
							code2 = codeMapper.selectOne(code2);
							CodeValue codeValue2 = new CodeValue();
							codeValue2.setValue(priceLine.getCurrency());
							codeValue2.setCodeId(code2.getCodeId());
							codeValue2 = codeValueMapper.selectOne(codeValue2);
							feeList.setCurrencyTypeName(codeValue2.getMeaning());
							feeList.setTransType(fee.getTransType());//交易类型
							Code code = new Code();
							code.setCode("HPMS_TRANS_TYPE");
							code = codeMapper.selectOne(code);
							CodeValue codeValue = new CodeValue();
							codeValue.setValue(fee.getTransType());
							codeValue.setCodeId(code.getCodeId());
							codeValue = codeValueMapper.selectOne(codeValue);
							feeList.setTransTypeName(codeValue.getMeaning());
							feeList.setAdjAmount(Float.parseFloat("0"));
							feeList.setOverduePayment(Float.parseFloat("0"));
							if(fee.getBillingMethod().equals("FIXED")){
								feeList.setGrossAmount(feeList.getUnitPrice()*Long.parseLong("1"));
							}else if(fee.getBillingMethod().equals("CALCULATED")){
								if(fee.getFeeName().equals("物业费")){
									CalculateRule calculateRule = new CalculateRule(); 
									calculateRule.setCalculateRuleId(priceLine.getCalculateRuleId());
									calculateRule = calculateRuleMapper.selectOne(calculateRule);
									CalRuleLine calRuleLine = new CalRuleLine();
									calRuleLine.setCalculateRuleId(calculateRule.getCalculateRuleId());
									List<CalRuleLine> calRuleLines = calRuleLineMapper.select(calRuleLine);
									for (CalRuleLine calRuleLine2 : calRuleLines) {
										CalculateElement calculateElement = new CalculateElement(); 
										calculateElement.setCalculateElementId(calRuleLine2.getCalculateElementId());
										calculateElement = calculateElementMapper.selectOne(calculateElement);
										if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("ROOM_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getRoomArea()*Long.parseLong("1"));
											break;
										}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("USE_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getUseArea()*Long.parseLong("1"));
											break;
										}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("FEE_AREA")){
											feeList.setGrossAmount(feeList.getUnitPrice()*property.getFeeArea()*Long.parseLong("1"));
											break;
										}
									}
								}else{
									throw new ValidationTableException("收费项目未定价", null);
								}
							}
							feeList.setTotalAmount(feeList.getGrossAmount());
							feeList.setGenerateDate(new Date());
							feeLists.add(feeList);
						}
					}
				}
			}else if(fee.getBillingFrequency().equals("UNTIME")){//不定
				for (VersionStructure versionStructure4 : versionStructures4) {
					FeeList feeList = new FeeList();
					Property property = new Property();
					property.setPropertyId(versionStructure4.getPropertyId());
					property = propertyMapper.selectOne(property);
					feeList.setPropertyNumber(property.getPropertyNumber());//建筑代码
					feeList.setPropertyName(property.getPropertyName());//建筑名称
					feeList.setFeeStatus("NEW");
					feeList.setFeeStatusName("新建");
					Occupation occupation = new Occupation();
					occupation.setPropertyId(versionStructure4.getPropertyId());
					List<Occupation> occupations = occupationMapper.select(occupation);
					for (int i = 0; i < occupations.size(); i++) {
						occupation = occupations.get(0);
						if(occupations.get(i).getCreationDate().after(occupation.getCreationDate())){
							occupation = occupations.get(i);
						}
					}
					feeList.setOccupationId(occupation.getOccupationId());//收费对象
					feeList.setCustomerName(occupation.getCustomerName());//客户名称
					FeeList feeList2 = new FeeList();
					feeList2.setOccupationId(occupation.getOccupationId());
					List<FeeList> feeLists2 = feeListMapper.select(feeList2);
					if(feeLists2.size()>0){
						for (int i = 0; i < feeLists2.size(); i++) {
							feeList2 = feeLists2.get(0);
							if(feeLists2.get(i).getCreationDate().after(feeList2.getCreationDate())){
								feeList2 = feeLists2.get(i);
							}
						}
						Calendar cal = Calendar.getInstance();
						cal.setTime(feeList2.getDateTo());
						cal.add(Calendar.DATE, 1);
						feeList.setAccruedDate(cal.getTime());
						feeList.setDateTo(cal.getTime());
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
						feeList.setFeePeriod(df.parse(cal.getTime().toString()).toString());
					}else{
						feeList.setAccruedDate(occupation.getFeeDate());
						feeList.setDateTo(occupation.getFeeDate());
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
						feeList.setFeePeriod(df.parse(occupation.getFeeDate().toString()).toString());
					}
					feeList.setFeeTypeId(feeListNew.getFeeTypeId());//赋值项目类型和收费项目
					FeeType feeType = new FeeType();
					feeType.setFeeTypeId(feeListNew.getFeeTypeId());
					feeList.setFeeTypeName(feeTypeMapper.selectOne(feeType).getFeeTypeName());
					feeList.setFeeId(feeListNew.getFeeId());
					feeList.setFeeName(fee.getFeeName());
					feeList.setUnitPrice(priceLine.getUnitPrice());//定价
					feeList.setCurrencyType(priceLine.getCurrency());//币种
					Code code2 = new Code();
					code2.setCode("HPMS_MDM_PAYMENT_CURRENCY");
					code2 = codeMapper.selectOne(code2);
					CodeValue codeValue2 = new CodeValue();
					codeValue2.setValue(priceLine.getCurrency());
					codeValue2.setCodeId(code2.getCodeId());
					codeValue2 = codeValueMapper.selectOne(codeValue2);
					feeList.setCurrencyTypeName(codeValue2.getMeaning());
					feeList.setTransType(fee.getTransType());//交易类型
					Code code = new Code();
					code.setCode("HPMS_TRANS_TYPE");
					code = codeMapper.selectOne(code);
					CodeValue codeValue = new CodeValue();
					codeValue.setValue(fee.getTransType());
					codeValue.setCodeId(code.getCodeId());
					codeValue = codeValueMapper.selectOne(codeValue);
					feeList.setTransTypeName(codeValue.getMeaning());
					if(feeListNew.getNumber()!=null){//数量
						feeList.setFeeQuantity(feeListNew.getNumber());
					}else{
						feeList.setFeeQuantity(Long.parseLong("1"));
					}
					feeList.setAdjAmount(Float.parseFloat("0"));
					feeList.setOverduePayment(Float.parseFloat("0"));
					if(fee.getBillingMethod().equals("FIXED")){
						feeList.setGrossAmount(feeList.getUnitPrice()*feeList.getFeeQuantity());
					}else if(fee.getBillingMethod().equals("CALCULATED")){
						if(fee.getFeeName().equals("物业费")){
							CalculateRule calculateRule = new CalculateRule(); 
							calculateRule.setCalculateRuleId(priceLine.getCalculateRuleId());
							calculateRule = calculateRuleMapper.selectOne(calculateRule);
							CalRuleLine calRuleLine = new CalRuleLine();
							calRuleLine.setCalculateRuleId(calculateRule.getCalculateRuleId());
							List<CalRuleLine> calRuleLines = calRuleLineMapper.select(calRuleLine);
							for (CalRuleLine calRuleLine2 : calRuleLines) {
								CalculateElement calculateElement = new CalculateElement(); 
								calculateElement.setCalculateElementId(calRuleLine2.getCalculateElementId());
								calculateElement = calculateElementMapper.selectOne(calculateElement);
								if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("ROOM_AREA")){
									feeList.setGrossAmount(feeList.getUnitPrice()*property.getRoomArea()*feeList.getFeeQuantity());
									break;
								}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("USE_AREA")){
									feeList.setGrossAmount(feeList.getUnitPrice()*property.getUseArea()*feeList.getFeeQuantity());
									break;
								}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("FEE_AREA")){
									feeList.setGrossAmount(feeList.getUnitPrice()*property.getFeeArea()*feeList.getFeeQuantity());
									break;
								}
							}
						}else{
							throw new ValidationTableException("收费项目未定价", null);
						}
					}
					feeList.setTotalAmount(feeList.getGrossAmount());
					feeList.setGenerateDate(new Date());
					feeLists.add(feeList);
				}
			}
			returnList.clear();
			return feeLists;
		}else{
			throw new ValidationTableException("收费项目未定价", null);
		}
	}
	
	public static List<VersionStructure> getChildNodes(List<VersionStructure> list, Long parentId) {
        if(list == null && parentId == null) return null;
        for (VersionStructure versionStructure : list) {
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (versionStructure.getParentStructureId()!=null&& parentId.equals(versionStructure.getParentStructureId())) {
            	boolean boo = true;
            	if(returnList!=null){
	            	for (VersionStructure versionStructure2 : returnList){
	            		if(versionStructure2.getStructureId().equals(versionStructure.getStructureId())){
	            			boo = false;
	            		}
	            	}
            	}
            	if(boo){
            		returnList.add(versionStructure);
            	}
            	//递归遍历子后子
                getChildNodes(list, versionStructure.getStructureId());
            }
        }
        return returnList;
    }
	/**
     * 获取当前月份最后一天
     *
     * @param date
     * @return
     */
	public static Date getMaxMonthDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
	/**
    *
    * 描述:获取下一个月的第一天.
    * @param date
    * @return
    */
   public static Date getPerFirstDayOfMonth(Date date){
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       calendar.add(Calendar.MONTH, 1);
       calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
       return calendar.getTime();
   }

	@Override
	public void feeListSubmit(IRequest requestContext, List<FeeList> feeLists) {
		for (FeeList feeList : feeLists) {
			feeList.setFeeStatus("CREATED");
			feeListMapper.insertSelective(feeList);
		}
	}
}
