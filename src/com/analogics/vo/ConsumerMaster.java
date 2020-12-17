package com.analogics.vo;

import java.sql.Timestamp;

/**
 * ConsumerMaster entity. @author MyEclipse Persistence Tools
 */

public class ConsumerMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -1310296043182068140L;
	private String consumerId;
	private String consumerNumber;
	private String consumerAddress;
	private String consumerCompanyDetails;
	private String contactNo;
	private String alternateContact;
	private String emailAddress;
	private String identificationNumber;
	private String connectionStatus;
	private String level1Code;
	private String level2Code;
	private String level3Code;
	private String level4Code;
	private String level5Code;
	private String level6Code;
	private String level7Code;
	private String level8Code;
	private String level9Code;
	private String level10Code;
	private String level11Code;
	private String level12Code;
	private String level13Code;
	private String level14Code;
	private String level15Code;
	private String level1Name;
	private String level2Name;
	private String level3Name;
	private String level4Name;
	private String level5Name;
	private String level6Name;
	private String level7Name;
	private String level8Name;
	private String level9Name;
	private String level10Name;
	private String level11Name;
	private String level12Name;
	private String level13Name;
	private String level14Name;
	private String level15Name;
	private String level1Id;
	private String level2Id;
	private String level3Id;
	private String level4Id;
	private String level5Id;
	private String level6Id;
	private String level7Id;
	private String level8Id;
	private String level9Id;
	private String level10Id;
	private String level11Id;
	private String level12Id;
	private String level13Id;
	private String level14Id;
	private String level15Id;
	private Integer baseId;
	private Integer indexid;
	private Integer appindexid;
	private Timestamp installationDate;
	private Timestamp insertedDate;
	private String insertedUser;
	private String accountId;
	private String remarks1;
	private String remarks2;

	// Constructors

	/** default constructor */
	public ConsumerMaster() {
	}

	/** minimal constructor */
	public ConsumerMaster(String consumerId, String consumerNumber,
			String consumerAddress, String consumerCompanyDetails,
			String contactNo, String alternateContact, String emailAddress) {
		this.consumerId = consumerId;
		this.consumerNumber = consumerNumber;
		this.consumerAddress = consumerAddress;
		this.consumerCompanyDetails = consumerCompanyDetails;
		this.contactNo = contactNo;
		this.alternateContact = alternateContact;
		this.emailAddress = emailAddress;
	}

	/** full constructor */
	public ConsumerMaster(String consumerId, String consumerNumber,
			String consumerAddress, String consumerCompanyDetails,
			String contactNo, String alternateContact, String emailAddress,
			String identificationNumber, String connectionStatus,
			String level1Code, String level2Code, String level3Code,
			String level4Code, String level5Code, String level6Code,
			String level7Code, String level8Code, String level9Code,
			String level10Code, String level11Code, String level12Code,
			String level13Code, String level14Code, String level15Code,
			String level1Name, String level2Name, String level3Name,
			String level4Name, String level5Name, String level6Name,
			String level7Name, String level8Name, String level9Name,
			String level10Name, String level11Name, String level12Name,
			String level13Name, String level14Name, String level15Name,
			String level1Id, String level2Id, String level3Id, String level4Id,
			String level5Id, String level6Id, String level7Id, String level8Id,
			String level9Id, String level10Id, String level11Id,
			String level12Id, String level13Id, String level14Id,
			String level15Id, Integer baseId, Integer indexid,
			Integer appindexid, Timestamp installationDate,
			Timestamp insertedDate, String insertedUser, String accountId,
			String remarks1, String remarks2) {
		this.consumerId = consumerId;
		this.consumerNumber = consumerNumber;
		this.consumerAddress = consumerAddress;
		this.consumerCompanyDetails = consumerCompanyDetails;
		this.contactNo = contactNo;
		this.alternateContact = alternateContact;
		this.emailAddress = emailAddress;
		this.identificationNumber = identificationNumber;
		this.connectionStatus = connectionStatus;
		this.level1Code = level1Code;
		this.level2Code = level2Code;
		this.level3Code = level3Code;
		this.level4Code = level4Code;
		this.level5Code = level5Code;
		this.level6Code = level6Code;
		this.level7Code = level7Code;
		this.level8Code = level8Code;
		this.level9Code = level9Code;
		this.level10Code = level10Code;
		this.level11Code = level11Code;
		this.level12Code = level12Code;
		this.level13Code = level13Code;
		this.level14Code = level14Code;
		this.level15Code = level15Code;
		this.level1Name = level1Name;
		this.level2Name = level2Name;
		this.level3Name = level3Name;
		this.level4Name = level4Name;
		this.level5Name = level5Name;
		this.level6Name = level6Name;
		this.level7Name = level7Name;
		this.level8Name = level8Name;
		this.level9Name = level9Name;
		this.level10Name = level10Name;
		this.level11Name = level11Name;
		this.level12Name = level12Name;
		this.level13Name = level13Name;
		this.level14Name = level14Name;
		this.level15Name = level15Name;
		this.level1Id = level1Id;
		this.level2Id = level2Id;
		this.level3Id = level3Id;
		this.level4Id = level4Id;
		this.level5Id = level5Id;
		this.level6Id = level6Id;
		this.level7Id = level7Id;
		this.level8Id = level8Id;
		this.level9Id = level9Id;
		this.level10Id = level10Id;
		this.level11Id = level11Id;
		this.level12Id = level12Id;
		this.level13Id = level13Id;
		this.level14Id = level14Id;
		this.level15Id = level15Id;
		this.baseId = baseId;
		this.indexid = indexid;
		this.appindexid = appindexid;
		this.installationDate = installationDate;
		this.insertedDate = insertedDate;
		this.insertedUser = insertedUser;
		this.accountId = accountId;
		this.remarks1 = remarks1;
		this.remarks2 = remarks2;
	}

	// Property accessors

	public String getConsumerId() {
		return this.consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerNumber() {
		return this.consumerNumber;
	}

	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public String getConsumerAddress() {
		return this.consumerAddress;
	}

	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	public String getConsumerCompanyDetails() {
		return this.consumerCompanyDetails;
	}

	public void setConsumerCompanyDetails(String consumerCompanyDetails) {
		this.consumerCompanyDetails = consumerCompanyDetails;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAlternateContact() {
		return this.alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getConnectionStatus() {
		return this.connectionStatus;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public String getLevel1Code() {
		return this.level1Code;
	}

	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}

	public String getLevel2Code() {
		return this.level2Code;
	}

	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}

	public String getLevel3Code() {
		return this.level3Code;
	}

	public void setLevel3Code(String level3Code) {
		this.level3Code = level3Code;
	}

	public String getLevel4Code() {
		return this.level4Code;
	}

	public void setLevel4Code(String level4Code) {
		this.level4Code = level4Code;
	}

	public String getLevel5Code() {
		return this.level5Code;
	}

	public void setLevel5Code(String level5Code) {
		this.level5Code = level5Code;
	}

	public String getLevel6Code() {
		return this.level6Code;
	}

	public void setLevel6Code(String level6Code) {
		this.level6Code = level6Code;
	}

	public String getLevel7Code() {
		return this.level7Code;
	}

	public void setLevel7Code(String level7Code) {
		this.level7Code = level7Code;
	}

	public String getLevel8Code() {
		return this.level8Code;
	}

	public void setLevel8Code(String level8Code) {
		this.level8Code = level8Code;
	}

	public String getLevel9Code() {
		return this.level9Code;
	}

	public void setLevel9Code(String level9Code) {
		this.level9Code = level9Code;
	}

	public String getLevel10Code() {
		return this.level10Code;
	}

	public void setLevel10Code(String level10Code) {
		this.level10Code = level10Code;
	}

	public String getLevel11Code() {
		return this.level11Code;
	}

	public void setLevel11Code(String level11Code) {
		this.level11Code = level11Code;
	}

	public String getLevel12Code() {
		return this.level12Code;
	}

	public void setLevel12Code(String level12Code) {
		this.level12Code = level12Code;
	}

	public String getLevel13Code() {
		return this.level13Code;
	}

	public void setLevel13Code(String level13Code) {
		this.level13Code = level13Code;
	}

	public String getLevel14Code() {
		return this.level14Code;
	}

	public void setLevel14Code(String level14Code) {
		this.level14Code = level14Code;
	}

	public String getLevel15Code() {
		return this.level15Code;
	}

	public void setLevel15Code(String level15Code) {
		this.level15Code = level15Code;
	}

	public String getLevel1Name() {
		return this.level1Name;
	}

	public void setLevel1Name(String level1Name) {
		this.level1Name = level1Name;
	}

	public String getLevel2Name() {
		return this.level2Name;
	}

	public void setLevel2Name(String level2Name) {
		this.level2Name = level2Name;
	}

	public String getLevel3Name() {
		return this.level3Name;
	}

	public void setLevel3Name(String level3Name) {
		this.level3Name = level3Name;
	}

	public String getLevel4Name() {
		return this.level4Name;
	}

	public void setLevel4Name(String level4Name) {
		this.level4Name = level4Name;
	}

	public String getLevel5Name() {
		return this.level5Name;
	}

	public void setLevel5Name(String level5Name) {
		this.level5Name = level5Name;
	}

	public String getLevel6Name() {
		return this.level6Name;
	}

	public void setLevel6Name(String level6Name) {
		this.level6Name = level6Name;
	}

	public String getLevel7Name() {
		return this.level7Name;
	}

	public void setLevel7Name(String level7Name) {
		this.level7Name = level7Name;
	}

	public String getLevel8Name() {
		return this.level8Name;
	}

	public void setLevel8Name(String level8Name) {
		this.level8Name = level8Name;
	}

	public String getLevel9Name() {
		return this.level9Name;
	}

	public void setLevel9Name(String level9Name) {
		this.level9Name = level9Name;
	}

	public String getLevel10Name() {
		return this.level10Name;
	}

	public void setLevel10Name(String level10Name) {
		this.level10Name = level10Name;
	}

	public String getLevel11Name() {
		return this.level11Name;
	}

	public void setLevel11Name(String level11Name) {
		this.level11Name = level11Name;
	}

	public String getLevel12Name() {
		return this.level12Name;
	}

	public void setLevel12Name(String level12Name) {
		this.level12Name = level12Name;
	}

	public String getLevel13Name() {
		return this.level13Name;
	}

	public void setLevel13Name(String level13Name) {
		this.level13Name = level13Name;
	}

	public String getLevel14Name() {
		return this.level14Name;
	}

	public void setLevel14Name(String level14Name) {
		this.level14Name = level14Name;
	}

	public String getLevel15Name() {
		return this.level15Name;
	}

	public void setLevel15Name(String level15Name) {
		this.level15Name = level15Name;
	}

	public String getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(String level1Id) {
		this.level1Id = level1Id;
	}

	public String getLevel2Id() {
		return this.level2Id;
	}

	public void setLevel2Id(String level2Id) {
		this.level2Id = level2Id;
	}

	public String getLevel3Id() {
		return this.level3Id;
	}

	public void setLevel3Id(String level3Id) {
		this.level3Id = level3Id;
	}

	public String getLevel4Id() {
		return this.level4Id;
	}

	public void setLevel4Id(String level4Id) {
		this.level4Id = level4Id;
	}

	public String getLevel5Id() {
		return this.level5Id;
	}

	public void setLevel5Id(String level5Id) {
		this.level5Id = level5Id;
	}

	public String getLevel6Id() {
		return this.level6Id;
	}

	public void setLevel6Id(String level6Id) {
		this.level6Id = level6Id;
	}

	public String getLevel7Id() {
		return this.level7Id;
	}

	public void setLevel7Id(String level7Id) {
		this.level7Id = level7Id;
	}

	public String getLevel8Id() {
		return this.level8Id;
	}

	public void setLevel8Id(String level8Id) {
		this.level8Id = level8Id;
	}

	public String getLevel9Id() {
		return this.level9Id;
	}

	public void setLevel9Id(String level9Id) {
		this.level9Id = level9Id;
	}

	public String getLevel10Id() {
		return this.level10Id;
	}

	public void setLevel10Id(String level10Id) {
		this.level10Id = level10Id;
	}

	public String getLevel11Id() {
		return this.level11Id;
	}

	public void setLevel11Id(String level11Id) {
		this.level11Id = level11Id;
	}

	public String getLevel12Id() {
		return this.level12Id;
	}

	public void setLevel12Id(String level12Id) {
		this.level12Id = level12Id;
	}

	public String getLevel13Id() {
		return this.level13Id;
	}

	public void setLevel13Id(String level13Id) {
		this.level13Id = level13Id;
	}

	public String getLevel14Id() {
		return this.level14Id;
	}

	public void setLevel14Id(String level14Id) {
		this.level14Id = level14Id;
	}

	public String getLevel15Id() {
		return this.level15Id;
	}

	public void setLevel15Id(String level15Id) {
		this.level15Id = level15Id;
	}

	public Integer getBaseId() {
		return this.baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public Integer getIndexid() {
		return this.indexid;
	}

	public void setIndexid(Integer indexid) {
		this.indexid = indexid;
	}

	public Integer getAppindexid() {
		return this.appindexid;
	}

	public void setAppindexid(Integer appindexid) {
		this.appindexid = appindexid;
	}

	public Timestamp getInstallationDate() {
		return this.installationDate;
	}

	public void setInstallationDate(Timestamp installationDate) {
		this.installationDate = installationDate;
	}

	public Timestamp getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Timestamp insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getInsertedUser() {
		return this.insertedUser;
	}

	public void setInsertedUser(String insertedUser) {
		this.insertedUser = insertedUser;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRemarks1() {
		return this.remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getRemarks2() {
		return this.remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

}