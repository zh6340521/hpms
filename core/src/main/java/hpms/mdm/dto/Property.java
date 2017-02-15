package hpms.mdm.dto;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.system.dto.BaseDTO;

/**
 * @name Property
 * @description 建筑实体DTO
 * @author chengye.hu@hand-china.com	2017年2月15日下午6:25:13
 * @version 
 */
@Table(name = "hpms.hpms_mdm_property")
public class Property extends BaseDTO{
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(generator = GENERATOR_TYPE)
	private Long propertyId;//主键
	@Column
	private Long groupId;//集团id
	@Column
	private Long companyId;//公司id
	@Column
	private Long projectId;//项目id
	@Column
	private String propertyType;//建筑类型id
	@Column
	private String propertyName;//建筑名称
	@Column
	private String propertyNameAlias;//建筑名称别名
	@Column
	private String propertyNumber;//建筑编码
	@Column
	private String oldNumber;//建筑原始编码
	@Column 
	private String propertyStatus;//建筑状态
	@Column
	private Long parentPropertyId;//父建筑id
	@Column
	private Long buildingAmount;//建筑数量
	@Column
	private String deptArea;//所属片区
	@Column
	private Long floorArea;//占地面积
	@Column 
	private Long greenArea;//绿化面积
	@Column 
	private String postalCode;//邮政编码
	@Column 
	private String deptBuilder;//施工单位
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column 
	private Date completeTime;//竣工日期
	@Column
	private String securityUnit;//安保单位
	@Column
	private String longitude;//经度
	@Column
	private String latitude;//纬度
	@Column
	private String country;//所属国家id
	@Column
	private String province;//所属省份id
	@Column
	private String city;//所属城市id
	@Column
	private String district;//所属区域id
	@Column
	private String street;//所属街道id
	@Column
	private String buildingType;//楼宇类型
	@Column
	private String heatingWay;//供暖方式
	@Column
	private String roomKind;//户型
	@Column
	private String roomType;//房型
	@Column
	private String roomOrientation;//房屋朝向
	@Column
	private Long roomArea;//建筑面积
	@Column
	private Long useArea;//使用面积
	@Column
	private Long feeArea;//收费面积
	@Column
	private String roomDecoration;//装修情况
	@Column
	private String buildDetails;//建筑细节
	@Column
	private String parkingType;//车位类型
	@Column
	private Long parkingLength;//车位长度
	@Column
	private Long parkingWidth;//车位宽度
	@Column
	private Long parkingArea;//车位面积
	@Column
	private String publicSpaceType;//公共区域类型
	@Column
	private Long publicSpaceArea;//公共区域面积
	@Column
	private String roomStatus;//房屋状态
	@Column
	private String parkingStatus;//车位状态
	@Column
	private String publicSpaceStatus;//公共区域状态
	@Column
	private String enableFlag;//记录状态
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyNameAlias() {
		return propertyNameAlias;
	}
	public void setPropertyNameAlias(String propertyNameAlias) {
		this.propertyNameAlias = propertyNameAlias;
	}
	public String getPropertyNumber() {
		return propertyNumber;
	}
	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}
	public String getOldNumber() {
		return oldNumber;
	}
	public void setOldNumber(String oldNumber) {
		this.oldNumber = oldNumber;
	}
	public String getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	public Long getParentPropertyId() {
		return parentPropertyId;
	}
	public void setParentPropertyId(Long parentPropertyId) {
		this.parentPropertyId = parentPropertyId;
	}
	public Long getBuildingAmount() {
		return buildingAmount;
	}
	public void setBuildingAmount(Long buildingAmount) {
		this.buildingAmount = buildingAmount;
	}
	public String getDeptArea() {
		return deptArea;
	}
	public void setDeptArea(String deptArea) {
		this.deptArea = deptArea;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public Long getGreenArea() {
		return greenArea;
	}
	public void setGreenArea(Long greenArea) {
		this.greenArea = greenArea;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getDeptBuilder() {
		return deptBuilder;
	}
	public void setDeptBuilder(String deptBuilder) {
		this.deptBuilder = deptBuilder;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setComplete_time(Date completeTime) {
		this.completeTime = completeTime;
	}
	public String getSecurityUnit() {
		return securityUnit;
	}
	public void setSecurityUnit(String securityUnit) {
		this.securityUnit = securityUnit;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getHeatingWay() {
		return heatingWay;
	}
	public void setHeatingWay(String heatingWay) {
		this.heatingWay = heatingWay;
	}
	public String getRoomKind() {
		return roomKind;
	}
	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomOrientation() {
		return roomOrientation;
	}
	public void setRoomOrientation(String roomOrientation) {
		this.roomOrientation = roomOrientation;
	}
	public Long getRoomArea() {
		return roomArea;
	}
	public void setRoomArea(Long roomArea) {
		this.roomArea = roomArea;
	}
	public Long getUseArea() {
		return useArea;
	}
	public void setUseArea(Long useArea) {
		this.useArea = useArea;
	}
	public Long getFeeArea() {
		return feeArea;
	}
	public void setFeeArea(Long feeArea) {
		this.feeArea = feeArea;
	}
	public String getRoomDecoration() {
		return roomDecoration;
	}
	public void setRoomDecoration(String roomDecoration) {
		this.roomDecoration = roomDecoration;
	}
	public String getBuildDetails() {
		return buildDetails;
	}
	public void setBuildDetails(String buildDetails) {
		this.buildDetails = buildDetails;
	}
	public String getParkingType() {
		return parkingType;
	}
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}
	public Long getParkingLength() {
		return parkingLength;
	}
	public void setParkingLength(Long parkingLength) {
		this.parkingLength = parkingLength;
	}
	public Long getParkingWidth() {
		return parkingWidth;
	}
	public void setParkingWidth(Long parkingWidth) {
		this.parkingWidth = parkingWidth;
	}
	public Long getParkingArea() {
		return parkingArea;
	}
	public void setParkingArea(Long parkingArea) {
		this.parkingArea = parkingArea;
	}
	public String getPublicSpaceType() {
		return publicSpaceType;
	}
	public void setPublicSpaceType(String publicSpaceType) {
		this.publicSpaceType = publicSpaceType;
	}
	public Long getPublicSpaceArea() {
		return publicSpaceArea;
	}
	public void setPublicSpaceArea(Long publicSpaceArea) {
		this.publicSpaceArea = publicSpaceArea;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getParkingStatus() {
		return parkingStatus;
	}
	public void setParkingStatus(String parkingStatus) {
		this.parkingStatus = parkingStatus;
	}
	public String getPublicSpaceStatus() {
		return publicSpaceStatus;
	}
	public void setPublicSpaceStatus(String publicSpaceStatus) {
		this.publicSpaceStatus = publicSpaceStatus;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	
}
