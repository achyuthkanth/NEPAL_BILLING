package com.analogics.vo;

import com.analogics.utils.ExtraFieldspojo;

/**
 * FieldInstallationMaster entity. @author MyEclipse Persistence Tools
 */

public class FieldInstallationMaster extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FieldInstallationMasterId id;
	private String consId;
	private String discomid;
	private String discom;
	private String boardid;
	private String board;
	private String circle;
	private String divisionid;
	private String division;
	private String subdivisionid;
	private String subdivision;
	private String sectionid;
	private String section;
	private String registratonId;
	private String name;
	private String addr;
	private String consumerCategory;
	private Double cdKva;
	private String officePhone;
	private String mobileNo;
	private String emailAddress;
	private String loadType;
	private String phase;
	private String schedulePower;
	private String category;
	private String meterCtType;
	private String meterOwnership;
	private String meterElecType;
	private String transformerownership;
	private String transformerscapacity;
	private String transformermake;
	private String transferLocation;
	private String transformerserialno;
	private String independent;
	private String meterno;
	private String hid;
	private String modemmeidnumber;
	private String modemmdn;
	private String modemnumber;
	private String mcc;
	private String mnc;
	private String lac;
	private String cellid;
	private String squal;
	private String srclev;
	private String imeiNumber;
	private String simProviderName;
	private String modemmanufacturername;
	private String latitude;
	private String longitude;
	private String photolocation;
	private String substation;
	private String substationCode;
	private String feeder;
	private String feederCode;
	private String feedertype;
	private String dtname;
	private String dtcode;
	private String permanentpolenumber;
	private String acno;
	private String MCt;
	private String MPt;
	private Double mf;
	private String make;
	private String meterSealDate;
	private String meterSealNo;
	private String meterRevolutionPermit;
	private String meterMfgDate;
	private String meterDecimal;
	private String meterDigit;
	private String meterCapacity;
	private String currentrating;
	private String voltagerating;
	private String connectiondate;
	private String meterChnageFlag;
	private String proprietorName;
	private String district;
	private String municipalityVdc;
	private String wardNo;
	private String citizenshipNo;
	private String citizenshipIssuedDist;
	private String supplyVoltage;
	private String mfKva;
	private String versionNumber;
	private String createddate;
	private String status;
	private String flag1;
	private String flag2;
	private String billDate;
	private String ussdCode;
	private String offSet;

	// Constructors

	/** default constructor */
	public FieldInstallationMaster() {
	}

	/** minimal constructor */
	public FieldInstallationMaster(FieldInstallationMasterId id) {
		this.id = id;
	}

	/** full constructor */
	public FieldInstallationMaster(FieldInstallationMasterId id, String consId,
			String discomid, String discom, String boardid, String board,
			String circle, String divisionid, String division,
			String subdivisionid, String subdivision, String sectionid,
			String section, String registratonId, String name, String addr,
			String consumerCategory, Double cdKva, String officePhone,
			String mobileNo, String emailAddress, String loadType,
			String phase, String schedulePower, String category,
			String meterCtType, String meterOwnership, String meterElecType,
			String transformerownership, String transformerscapacity,
			String transformermake, String transferLocation,
			String transformerserialno, String independent, String meterno,
			String hid, String modemmeidnumber, String modemmdn,
			String modemnumber, String mcc, String mnc, String lac,
			String cellid, String squal, String srclev, String imeiNumber,
			String simProviderName, String modemmanufacturername,
			String latitude, String longitude, String photolocation,
			String substation, String substationCode, String feeder,
			String feederCode, String feedertype, String dtname, String dtcode,
			String permanentpolenumber, String acno, String MCt, String MPt,
			Double mf, String make, String meterSealDate, String meterSealNo,
			String meterRevolutionPermit, String meterMfgDate,
			String meterDecimal, String meterDigit, String meterCapacity,
			String currentrating, String voltagerating, String connectiondate,
			String meterChnageFlag, String proprietorName, String district,
			String municipalityVdc, String wardNo, String citizenshipNo,
			String citizenshipIssuedDist, String supplyVoltage, String mfKva,
			String versionNumber, String createddate, String status,
			String flag1, String flag2, String billDate, String ussdCode,
			String offSet) {
		this.id = id;
		this.consId = consId;
		this.discomid = discomid;
		this.discom = discom;
		this.boardid = boardid;
		this.board = board;
		this.circle = circle;
		this.divisionid = divisionid;
		this.division = division;
		this.subdivisionid = subdivisionid;
		this.subdivision = subdivision;
		this.sectionid = sectionid;
		this.section = section;
		this.registratonId = registratonId;
		this.name = name;
		this.addr = addr;
		this.consumerCategory = consumerCategory;
		this.cdKva = cdKva;
		this.officePhone = officePhone;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
		this.loadType = loadType;
		this.phase = phase;
		this.schedulePower = schedulePower;
		this.category = category;
		this.meterCtType = meterCtType;
		this.meterOwnership = meterOwnership;
		this.meterElecType = meterElecType;
		this.transformerownership = transformerownership;
		this.transformerscapacity = transformerscapacity;
		this.transformermake = transformermake;
		this.transferLocation = transferLocation;
		this.transformerserialno = transformerserialno;
		this.independent = independent;
		this.meterno = meterno;
		this.hid = hid;
		this.modemmeidnumber = modemmeidnumber;
		this.modemmdn = modemmdn;
		this.modemnumber = modemnumber;
		this.mcc = mcc;
		this.mnc = mnc;
		this.lac = lac;
		this.cellid = cellid;
		this.squal = squal;
		this.srclev = srclev;
		this.imeiNumber = imeiNumber;
		this.simProviderName = simProviderName;
		this.modemmanufacturername = modemmanufacturername;
		this.latitude = latitude;
		this.longitude = longitude;
		this.photolocation = photolocation;
		this.substation = substation;
		this.substationCode = substationCode;
		this.feeder = feeder;
		this.feederCode = feederCode;
		this.feedertype = feedertype;
		this.dtname = dtname;
		this.dtcode = dtcode;
		this.permanentpolenumber = permanentpolenumber;
		this.acno = acno;
		this.MCt = MCt;
		this.MPt = MPt;
		this.mf = mf;
		this.make = make;
		this.meterSealDate = meterSealDate;
		this.meterSealNo = meterSealNo;
		this.meterRevolutionPermit = meterRevolutionPermit;
		this.meterMfgDate = meterMfgDate;
		this.meterDecimal = meterDecimal;
		this.meterDigit = meterDigit;
		this.meterCapacity = meterCapacity;
		this.currentrating = currentrating;
		this.voltagerating = voltagerating;
		this.connectiondate = connectiondate;
		this.meterChnageFlag = meterChnageFlag;
		this.proprietorName = proprietorName;
		this.district = district;
		this.municipalityVdc = municipalityVdc;
		this.wardNo = wardNo;
		this.citizenshipNo = citizenshipNo;
		this.citizenshipIssuedDist = citizenshipIssuedDist;
		this.supplyVoltage = supplyVoltage;
		this.mfKva = mfKva;
		this.versionNumber = versionNumber;
		this.createddate = createddate;
		this.status = status;
		this.flag1 = flag1;
		this.flag2 = flag2;
		this.billDate = billDate;
		this.ussdCode = ussdCode;
		this.offSet = offSet;
	}

	// Property accessors

	public FieldInstallationMasterId getId() {
		return this.id;
	}

	public void setId(FieldInstallationMasterId id) {
		this.id = id;
	}

	public String getConsId() {
		return this.consId;
	}

	public void setConsId(String consId) {
		this.consId = consId;
	}

	public String getDiscomid() {
		return this.discomid;
	}

	public void setDiscomid(String discomid) {
		this.discomid = discomid;
	}

	public String getDiscom() {
		return this.discom;
	}

	public void setDiscom(String discom) {
		this.discom = discom;
	}

	public String getBoardid() {
		return this.boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getBoard() {
		return this.board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getCircle() {
		return this.circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getDivisionid() {
		return this.divisionid;
	}

	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSubdivisionid() {
		return this.subdivisionid;
	}

	public void setSubdivisionid(String subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	public String getSubdivision() {
		return this.subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getSectionid() {
		return this.sectionid;
	}

	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getRegistratonId() {
		return this.registratonId;
	}

	public void setRegistratonId(String registratonId) {
		this.registratonId = registratonId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getConsumerCategory() {
		return this.consumerCategory;
	}

	public void setConsumerCategory(String consumerCategory) {
		this.consumerCategory = consumerCategory;
	}

	public Double getCdKva() {
		return this.cdKva;
	}

	public void setCdKva(Double cdKva) {
		this.cdKva = cdKva;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLoadType() {
		return this.loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getSchedulePower() {
		return this.schedulePower;
	}

	public void setSchedulePower(String schedulePower) {
		this.schedulePower = schedulePower;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMeterCtType() {
		return this.meterCtType;
	}

	public void setMeterCtType(String meterCtType) {
		this.meterCtType = meterCtType;
	}

	public String getMeterOwnership() {
		return this.meterOwnership;
	}

	public void setMeterOwnership(String meterOwnership) {
		this.meterOwnership = meterOwnership;
	}

	public String getMeterElecType() {
		return this.meterElecType;
	}

	public void setMeterElecType(String meterElecType) {
		this.meterElecType = meterElecType;
	}

	public String getTransformerownership() {
		return this.transformerownership;
	}

	public void setTransformerownership(String transformerownership) {
		this.transformerownership = transformerownership;
	}

	public String getTransformerscapacity() {
		return this.transformerscapacity;
	}

	public void setTransformerscapacity(String transformerscapacity) {
		this.transformerscapacity = transformerscapacity;
	}

	public String getTransformermake() {
		return this.transformermake;
	}

	public void setTransformermake(String transformermake) {
		this.transformermake = transformermake;
	}

	public String getTransferLocation() {
		return this.transferLocation;
	}

	public void setTransferLocation(String transferLocation) {
		this.transferLocation = transferLocation;
	}

	public String getTransformerserialno() {
		return this.transformerserialno;
	}

	public void setTransformerserialno(String transformerserialno) {
		this.transformerserialno = transformerserialno;
	}

	public String getIndependent() {
		return this.independent;
	}

	public void setIndependent(String independent) {
		this.independent = independent;
	}

	public String getMeterno() {
		return this.meterno;
	}

	public void setMeterno(String meterno) {
		this.meterno = meterno;
	}

	public String getHid() {
		return this.hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getModemmeidnumber() {
		return this.modemmeidnumber;
	}

	public void setModemmeidnumber(String modemmeidnumber) {
		this.modemmeidnumber = modemmeidnumber;
	}

	public String getModemmdn() {
		return this.modemmdn;
	}

	public void setModemmdn(String modemmdn) {
		this.modemmdn = modemmdn;
	}

	public String getModemnumber() {
		return this.modemnumber;
	}

	public void setModemnumber(String modemnumber) {
		this.modemnumber = modemnumber;
	}

	public String getMcc() {
		return this.mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMnc() {
		return this.mnc;
	}

	public void setMnc(String mnc) {
		this.mnc = mnc;
	}

	public String getLac() {
		return this.lac;
	}

	public void setLac(String lac) {
		this.lac = lac;
	}

	public String getCellid() {
		return this.cellid;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
	}

	public String getSqual() {
		return this.squal;
	}

	public void setSqual(String squal) {
		this.squal = squal;
	}

	public String getSrclev() {
		return this.srclev;
	}

	public void setSrclev(String srclev) {
		this.srclev = srclev;
	}

	public String getImeiNumber() {
		return this.imeiNumber;
	}

	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	public String getSimProviderName() {
		return this.simProviderName;
	}

	public void setSimProviderName(String simProviderName) {
		this.simProviderName = simProviderName;
	}

	public String getModemmanufacturername() {
		return this.modemmanufacturername;
	}

	public void setModemmanufacturername(String modemmanufacturername) {
		this.modemmanufacturername = modemmanufacturername;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPhotolocation() {
		return this.photolocation;
	}

	public void setPhotolocation(String photolocation) {
		this.photolocation = photolocation;
	}

	public String getSubstation() {
		return this.substation;
	}

	public void setSubstation(String substation) {
		this.substation = substation;
	}

	public String getSubstationCode() {
		return this.substationCode;
	}

	public void setSubstationCode(String substationCode) {
		this.substationCode = substationCode;
	}

	public String getFeeder() {
		return this.feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public String getFeederCode() {
		return this.feederCode;
	}

	public void setFeederCode(String feederCode) {
		this.feederCode = feederCode;
	}

	public String getFeedertype() {
		return this.feedertype;
	}

	public void setFeedertype(String feedertype) {
		this.feedertype = feedertype;
	}

	public String getDtname() {
		return this.dtname;
	}

	public void setDtname(String dtname) {
		this.dtname = dtname;
	}

	public String getDtcode() {
		return this.dtcode;
	}

	public void setDtcode(String dtcode) {
		this.dtcode = dtcode;
	}

	public String getPermanentpolenumber() {
		return this.permanentpolenumber;
	}

	public void setPermanentpolenumber(String permanentpolenumber) {
		this.permanentpolenumber = permanentpolenumber;
	}

	public String getAcno() {
		return this.acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public String getMCt() {
		return this.MCt;
	}

	public void setMCt(String MCt) {
		this.MCt = MCt;
	}

	public String getMPt() {
		return this.MPt;
	}

	public void setMPt(String MPt) {
		this.MPt = MPt;
	}

	public Double getMf() {
		return this.mf;
	}

	public void setMf(Double mf) {
		this.mf = mf;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getMeterSealDate() {
		return this.meterSealDate;
	}

	public void setMeterSealDate(String meterSealDate) {
		this.meterSealDate = meterSealDate;
	}

	public String getMeterSealNo() {
		return this.meterSealNo;
	}

	public void setMeterSealNo(String meterSealNo) {
		this.meterSealNo = meterSealNo;
	}

	public String getMeterRevolutionPermit() {
		return this.meterRevolutionPermit;
	}

	public void setMeterRevolutionPermit(String meterRevolutionPermit) {
		this.meterRevolutionPermit = meterRevolutionPermit;
	}

	public String getMeterMfgDate() {
		return this.meterMfgDate;
	}

	public void setMeterMfgDate(String meterMfgDate) {
		this.meterMfgDate = meterMfgDate;
	}

	public String getMeterDecimal() {
		return this.meterDecimal;
	}

	public void setMeterDecimal(String meterDecimal) {
		this.meterDecimal = meterDecimal;
	}

	public String getMeterDigit() {
		return this.meterDigit;
	}

	public void setMeterDigit(String meterDigit) {
		this.meterDigit = meterDigit;
	}

	public String getMeterCapacity() {
		return this.meterCapacity;
	}

	public void setMeterCapacity(String meterCapacity) {
		this.meterCapacity = meterCapacity;
	}

	public String getCurrentrating() {
		return this.currentrating;
	}

	public void setCurrentrating(String currentrating) {
		this.currentrating = currentrating;
	}

	public String getVoltagerating() {
		return this.voltagerating;
	}

	public void setVoltagerating(String voltagerating) {
		this.voltagerating = voltagerating;
	}

	public String getConnectiondate() {
		return this.connectiondate;
	}

	public void setConnectiondate(String connectiondate) {
		this.connectiondate = connectiondate;
	}

	public String getMeterChnageFlag() {
		return this.meterChnageFlag;
	}

	public void setMeterChnageFlag(String meterChnageFlag) {
		this.meterChnageFlag = meterChnageFlag;
	}

	public String getProprietorName() {
		return this.proprietorName;
	}

	public void setProprietorName(String proprietorName) {
		this.proprietorName = proprietorName;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMunicipalityVdc() {
		return this.municipalityVdc;
	}

	public void setMunicipalityVdc(String municipalityVdc) {
		this.municipalityVdc = municipalityVdc;
	}

	public String getWardNo() {
		return this.wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getCitizenshipNo() {
		return this.citizenshipNo;
	}

	public void setCitizenshipNo(String citizenshipNo) {
		this.citizenshipNo = citizenshipNo;
	}

	public String getCitizenshipIssuedDist() {
		return this.citizenshipIssuedDist;
	}

	public void setCitizenshipIssuedDist(String citizenshipIssuedDist) {
		this.citizenshipIssuedDist = citizenshipIssuedDist;
	}

	public String getSupplyVoltage() {
		return this.supplyVoltage;
	}

	public void setSupplyVoltage(String supplyVoltage) {
		this.supplyVoltage = supplyVoltage;
	}

	public String getMfKva() {
		return this.mfKva;
	}

	public void setMfKva(String mfKva) {
		this.mfKva = mfKva;
	}

	public String getVersionNumber() {
		return this.versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag1() {
		return this.flag1;
	}

	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}

	public String getFlag2() {
		return this.flag2;
	}

	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}

	public String getBillDate() {
		return this.billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getUssdCode() {
		return this.ussdCode;
	}

	public void setUssdCode(String ussdCode) {
		this.ussdCode = ussdCode;
	}

	public String getOffSet() {
		return this.offSet;
	}

	public void setOffSet(String offSet) {
		this.offSet = offSet;
	}

}