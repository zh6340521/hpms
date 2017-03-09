package hpms.fin.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
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
		if(priceLine!=null&&priceLine.getUnitPrice()>0){
			StringBuffer sb = new StringBuffer();
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
				if(!(configValue.getConfigValueNumber().equals("CN03"))){
					continue;
				}
				Occupation occupation = new Occupation();
				occupation.setPropertyId(versionStructure3.getPropertyId());
				List<Occupation> occupations = occupationMapper.select(occupation);
				if(occupations.size()<=0){
					sb.append(versionStructure3.getStructureName()+",");
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
						sb.append(versionStructure3.getStructureName()+",");
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
							if(i == 0){
								feeList2 = feeLists2.get(0);
							}
							if(feeLists2.get(i).getDateTo().after(feeList2.getDateTo())){
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
								feeList.setFeePeriod(df.format(cal.getTime()));
							}else{
								Calendar cal1 = Calendar.getInstance();
								cal1.setTime(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo()));
								feeList.setAccruedDate(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo()));
								feeList.setDateTo(getMaxMonthDate(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo())));
								feeList.setFeePeriod(df.format(cal1.getTime()));
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
							feeList.setAdjAmount(Float.parseFloat("0.00"));
							feeList.setOverduePayment(Float.parseFloat("0.00"));
							if(fee.getBillingMethod().equals("FIXED")){
								Calendar cal2 = Calendar.getInstance();
								cal2.setTime(feeList.getAccruedDate());
								Calendar cal3 = Calendar.getInstance();
								cal3.setTime(feeList.getDateTo());
								SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
								if(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime())).equals(temp(df1.format(cal2.getTime()))-1)){
									feeList.setGrossAmount(feeList.getUnitPrice()*Long.parseLong("1"));
								}else{
									BigDecimal b = new BigDecimal((feeList.getUnitPrice()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
									feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
								}
							}else if(fee.getBillingMethod().equals("CALCULATED")){
								if(fee.getFeeName().equals("物业费")){
									CalculateRule calculateRule = new CalculateRule(); 
									calculateRule.setCalculateRuleId(priceLine.getCalculateRuleId());
									calculateRule = calculateRuleMapper.selectOne(calculateRule);
									CalRuleLine calRuleLine = new CalRuleLine();
									calRuleLine.setCalculateRuleId(calculateRule.getCalculateRuleId());
									List<CalRuleLine> calRuleLines = calRuleLineMapper.select(calRuleLine);
									Calendar cal2 = Calendar.getInstance();
									cal2.setTime(feeList.getAccruedDate());
									Calendar cal3 = Calendar.getInstance();
									cal3.setTime(feeList.getDateTo());
									SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
									for (CalRuleLine calRuleLine2 : calRuleLines) {
										CalculateElement calculateElement = new CalculateElement(); 
										calculateElement.setCalculateElementId(calRuleLine2.getCalculateElementId());
										calculateElement = calculateElementMapper.selectOne(calculateElement);
										if(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime())).equals(temp(df1.format(cal2.getTime()))-1)){
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
										}else{
											if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("ROOM_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getRoomArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("USE_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getUseArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("FEE_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getFeeArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}
										}
									}
								}else{
									throw new ValidationTableException("hpms.fin.feelist.charging_projects_not_pricing", null);
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
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
							cal.setTime(occupation.getFeeDate());
							if(i==0){
								feeList.setAccruedDate(occupation.getFeeDate());
								feeList.setDateTo(getMaxMonthDate(occupation.getFeeDate()));
								feeList.setFeePeriod(df.format(cal.getTime()));
							}else{
								Calendar cal1 = Calendar.getInstance();
								cal1.setTime(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo()));
								feeList.setAccruedDate(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo()));
								feeList.setDateTo(getMaxMonthDate(getPerFirstDayOfMonth(feeLists.get(feeLists.size()-1).getDateTo())));
								feeList.setFeePeriod(df.format(cal1.getTime()));
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
							feeList.setAdjAmount(Float.parseFloat("0.00"));
							feeList.setOverduePayment(Float.parseFloat("0.00"));
							if(fee.getBillingMethod().equals("FIXED")){
								Calendar cal2 = Calendar.getInstance();
								cal2.setTime(feeList.getAccruedDate());
								Calendar cal3 = Calendar.getInstance();
								cal3.setTime(feeList.getDateTo());
								SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
								if(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime())).equals(temp(df1.format(cal2.getTime()))-1)){
									feeList.setGrossAmount(feeList.getUnitPrice()*Long.parseLong("1"));
								}else{
									BigDecimal b = new BigDecimal((feeList.getUnitPrice()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
									feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
								}
							}else if(fee.getBillingMethod().equals("CALCULATED")){
								if(fee.getFeeName().equals("物业费")){
									CalculateRule calculateRule = new CalculateRule(); 
									calculateRule.setCalculateRuleId(priceLine.getCalculateRuleId());
									calculateRule = calculateRuleMapper.selectOne(calculateRule);
									CalRuleLine calRuleLine = new CalRuleLine();
									calRuleLine.setCalculateRuleId(calculateRule.getCalculateRuleId());
									List<CalRuleLine> calRuleLines = calRuleLineMapper.select(calRuleLine);
									Calendar cal2 = Calendar.getInstance();
									cal2.setTime(feeList.getAccruedDate());
									Calendar cal3 = Calendar.getInstance();
									cal3.setTime(feeList.getDateTo());
									SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
									for (CalRuleLine calRuleLine2 : calRuleLines) {
										CalculateElement calculateElement = new CalculateElement(); 
										calculateElement.setCalculateElementId(calRuleLine2.getCalculateElementId());
										calculateElement = calculateElementMapper.selectOne(calculateElement);
										if(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime())).equals(temp(df1.format(cal2.getTime()))-1)){
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
										}else{
											if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("ROOM_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getRoomArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("USE_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getUseArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}else if(calculateElement.getTableName().equals("HPMS_MDM_PROPERTY")&&calculateElement.getColumnName().equals("FEE_AREA")){
												BigDecimal b = new BigDecimal((feeList.getUnitPrice()*property.getFeeArea()*Long.parseLong("1")*(daysBetween(df1.format(cal2.getTime()),df1.format(cal3.getTime()))/temp(df1.format(cal2.getTime())))));
												feeList.setGrossAmount(b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
												break;
											}
										}
										
									}
								}else{
									throw new ValidationTableException("hpms.fin.feelist.charging_projects_not_pricing", null);
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
					Calendar cal = Calendar.getInstance();
					cal.setTime(feeListNew.getFeeListDate());
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
					feeList.setAccruedDate(feeListNew.getFeeListDate());
					feeList.setDateTo(feeListNew.getFeeListDate());
					feeList.setFeePeriod(df.format(cal.getTime()));
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
					feeList.setAdjAmount(Float.parseFloat("0.00"));
					feeList.setOverduePayment(Float.parseFloat("0.00"));
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
							throw new ValidationTableException("hpms.fin.feelist.charging_projects_not_pricing", null);
						}
					}
					feeList.setTotalAmount(feeList.getGrossAmount());
					feeList.setGenerateDate(new Date());
					feeLists.add(feeList);
				}
			}
			returnList.clear();
			if(feeLists.size()>0){
				if(sb.length()>0){
					feeLists.get(0).setBeff(sb.toString().substring(0, sb.toString().length()-1));
				}
			}else{
				throw new ValidationTableException("hpms.fin.feelist.was_not_found_on_board_room", null);
			}
			return feeLists;
		}else{
			throw new ValidationTableException("hpms.fin.feelist.charging_projects_not_pricing", null);
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
   /**
   *
   * 描述:获取两个日期相差的天数
   * @param smdate
   * @param bdate
   * @return
   */
   public static Float daysBetween(String smdate,String bdate) throws ParseException{  
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
       Calendar cal = Calendar.getInstance();    
       cal.setTime(sdf.parse(smdate));    
       long time1 = cal.getTimeInMillis();                 
       cal.setTime(sdf.parse(bdate));    
       long time2 = cal.getTimeInMillis();         
       long between_days=(time2-time1)/(1000*3600*24);  
           
      return Float.parseFloat(String.valueOf(between_days));     
   }
   /**
   *
   * 描述:获取当前月的天数
   * @param YYMMdd
   * @return
   */
   public static Float temp(String YYMMdd) throws ParseException{   
	   String strDate = YYMMdd;
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	   Calendar calendar = Calendar.getInstance();   
	   Date date = sdf.parse(strDate); 
	   calendar.setTime(date);   
	   int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   
	   return Float.parseFloat(String.valueOf(day));

	}

	@Override
	public void feeListSubmit(IRequest requestContext, List<FeeList> feeLists) {
		for (FeeList feeList : feeLists) {
			Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
	        String formDate =sdf.format(date);
			feeList.setFeeStatus("CREATED");
			feeList.setFeeListCode(formDate);
			feeListMapper.insertSelective(feeList);
		}
	}
}
