package com.analogics.um.vo;

import java.sql.Timestamp;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ApplicationMaster entity. @author MyEclipse Persistence Tools
 */

public class ApplicationMaster extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1162675275720806791L;
	private String applicationuniquecode;
	private String applicationname;//
	private String applicationid;//
	private String applicationowner;//
	private String primarycontact; //
	private String alternatecontact;//
	private String contactaddress;//
	private String emailaddress;//
	private Long personsallowed;//
	private Long appusersallowed;//
	private String applicationstatus;
	private Long level1Id;
	private Integer orghierarchylevel;//
	private Integer subhierarchylevel;//
	private String subhierarchyleveltype;
	private Long applicationuniqueid;
	private String inserteduser;
	private Timestamp inserteddate;
	private String imagelogo;

	// Constructors

	/** default constructor */
	public ApplicationMaster() {
	}

	/** minimal constructor */
	public ApplicationMaster(String applicationuniquecode,
			Long applicationuniqueid) {
		this.applicationuniquecode = applicationuniquecode;
		this.applicationuniqueid = applicationuniqueid;
	}

	/** full constructor */
	public ApplicationMaster(String applicationuniquecode,
			String applicationname, String applicationid,
			String applicationowner, String primarycontact,
			String alternatecontact, String contactaddress,
			String emailaddress, Long personsallowed, Long appusersallowed,
			String applicationstatus, Long level1Id, Integer orghierarchylevel,
			Integer subhierarchylevel, String subhierarchyleveltype,
			Long applicationuniqueid, String inserteduser,
			Timestamp inserteddate, String imagelogo) {
		this.applicationuniquecode = applicationuniquecode;
		this.applicationname = applicationname;
		this.applicationid = applicationid;
		this.applicationowner = applicationowner;
		this.primarycontact = primarycontact;
		this.alternatecontact = alternatecontact;
		this.contactaddress = contactaddress;
		this.emailaddress = emailaddress;
		this.personsallowed = personsallowed;
		this.appusersallowed = appusersallowed;
		this.applicationstatus = applicationstatus;
		this.level1Id = level1Id;
		this.orghierarchylevel = orghierarchylevel;
		this.subhierarchylevel = subhierarchylevel;
		this.subhierarchyleveltype = subhierarchyleveltype;
		this.applicationuniqueid = applicationuniqueid;
		this.inserteduser = inserteduser;
		this.inserteddate = inserteddate;
		this.imagelogo = imagelogo;
	}

	// Property accessors

	public String getApplicationuniquecode() {
		return this.applicationuniquecode;
	}

	public void setApplicationuniquecode(String applicationuniquecode) {
		this.applicationuniquecode = applicationuniquecode;
	}

	public String getApplicationname() {
		return this.applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

	public String getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	public String getApplicationowner() {
		return this.applicationowner;
	}

	public void setApplicationowner(String applicationowner) {
		this.applicationowner = applicationowner;
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

	public String getContactaddress() {
		return this.contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public Long getPersonsallowed() {
		return this.personsallowed;
	}

	public void setPersonsallowed(Long personsallowed) {
		this.personsallowed = personsallowed;
	}

	public Long getAppusersallowed() {
		return this.appusersallowed;
	}

	public void setAppusersallowed(Long appusersallowed) {
		this.appusersallowed = appusersallowed;
	}

	public String getApplicationstatus() {
		return this.applicationstatus;
	}

	public void setApplicationstatus(String applicationstatus) {
		this.applicationstatus = applicationstatus;
	}

	public Long getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(Long level1Id) {
		this.level1Id = level1Id;
	}

	public Integer getOrghierarchylevel() {
		return this.orghierarchylevel;
	}

	public void setOrghierarchylevel(Integer orghierarchylevel) {
		this.orghierarchylevel = orghierarchylevel;
	}

	public Integer getSubhierarchylevel() {
		return this.subhierarchylevel;
	}

	public void setSubhierarchylevel(Integer subhierarchylevel) {
		this.subhierarchylevel = subhierarchylevel;
	}

	public String getSubhierarchyleveltype() {
		return this.subhierarchyleveltype;
	}

	public void setSubhierarchyleveltype(String subhierarchyleveltype) {
		this.subhierarchyleveltype = subhierarchyleveltype;
	}

	public Long getApplicationuniqueid() {
		return this.applicationuniqueid;
	}

	public void setApplicationuniqueid(Long applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
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

	public String getImagelogo() {
		return this.imagelogo;
	}

	public void setImagelogo(String imagelogo) {
		this.imagelogo = imagelogo;
	}

}