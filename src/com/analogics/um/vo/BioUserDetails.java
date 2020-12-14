package com.analogics.um.vo;

import java.sql.Timestamp;

/**
 * BioUserDetails entity. @author MyEclipse Persistence Tools
 */

public class BioUserDetails extends HierarchyLevelsVo implements java.io.Serializable {

	private static final long serialVersionUID = 4204225870201504648L;
	private String userid;
	private String username;
	private String userpassword;
	private String contactaddress;
	private String primarycontact;
	private String alternatecontact;
	private String emailaddress;
	private String usergroupid;
	private String userstatus;
	private String applicationuniqueid;
	private String organizationuniqueid;
	private String indexid;
	private String inserteduser;
	private Timestamp inserteddate;
	private String appindexid;

	// Constructors

	/** default constructor */
	public BioUserDetails() {
	}

	/** minimal constructor */
	public BioUserDetails(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public BioUserDetails(String userid, String username, String userpassword,
			String contactaddress, String primarycontact,
			String alternatecontact, String emailaddress, String usergroupid,
			String userstatus, String applicationuniqueid,
			String organizationuniqueid, String indexid, String inserteduser,
			Timestamp inserteddate, String appindexid) {
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.contactaddress = contactaddress;
		this.primarycontact = primarycontact;
		this.alternatecontact = alternatecontact;
		this.emailaddress = emailaddress;
		this.usergroupid = usergroupid;
		this.userstatus = userstatus;
		this.applicationuniqueid = applicationuniqueid;
		this.organizationuniqueid = organizationuniqueid;
		this.indexid = indexid;
		this.inserteduser = inserteduser;
		this.inserteddate = inserteddate;
		this.appindexid = appindexid;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getContactaddress() {
		return this.contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getPrimarycontact() {
		return this.primarycontact;
	}

	public void setPrimarycontact(String primarycontact) {
		this.primarycontact = primarycontact;
	}

	public String getAlternatecontact() {
		return this.alternatecontact;
	}

	public void setAlternatecontact(String alternatecontact) {
		this.alternatecontact = alternatecontact;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getUsergroupid() {
		return this.usergroupid;
	}

	public void setUsergroupid(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	public String getApplicationuniqueid() {
		return this.applicationuniqueid;
	}

	public void setApplicationuniqueid(String applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
	}

	public String getOrganizationuniqueid() {
		return this.organizationuniqueid;
	}

	public void setOrganizationuniqueid(String organizationuniqueid) {
		this.organizationuniqueid = organizationuniqueid;
	}

	public String getIndexid() {
		return this.indexid;
	}

	public void setIndexid(String indexid) {
		this.indexid = indexid;
	}

	public String getInserteduser() {
		return this.inserteduser;
	}

	public void setInserteduser(String inserteduser) {
		this.inserteduser = inserteduser;
	}

	public Timestamp getInserteddate() {
		return this.inserteddate;
	}

	public void setInserteddate(Timestamp inserteddate) {
		this.inserteddate = inserteddate;
	}

	public String getAppindexid() {
		return this.appindexid;
	}

	public void setAppindexid(String appindexid) {
		this.appindexid = appindexid;
	}

}