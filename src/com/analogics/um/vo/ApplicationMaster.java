package com.analogics.um.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ApplicationMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "application_master", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "applicationuniqueid"))
public class ApplicationMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String applicationuniquecode;
	private String applicationname;
	private String applicationid;
	private String applicationowner;
	private String primarycontact;
	private String alternatecontact;
	private String contactaddress;
	private String emailaddress;
	private Long personsallowed;
	private Long appusersallowed;
	private String applicationstatus;
	private Long level1Id;
	private Integer orghierarchylevel;
	private Integer subhierarchylevel;
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
	@Id
	@Column(name = "applicationuniquecode", unique = true, nullable = false, length = 300)
	public String getApplicationuniquecode() {
		return this.applicationuniquecode;
	}

	public void setApplicationuniquecode(String applicationuniquecode) {
		this.applicationuniquecode = applicationuniquecode;
	}

	@Column(name = "applicationname", length = 45)
	public String getApplicationname() {
		return this.applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

	@Column(name = "applicationid", length = 45)
	public String getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	@Column(name = "applicationowner", length = 45)
	public String getApplicationowner() {
		return this.applicationowner;
	}

	public void setApplicationowner(String applicationowner) {
		this.applicationowner = applicationowner;
	}

	@Column(name = "primarycontact", length = 45)
	public String getPrimarycontact() {
		return this.primarycontact;
	}

	public void setPrimarycontact(String primarycontact) {
		this.primarycontact = primarycontact;
	}

	@Column(name = "alternatecontact", length = 45)
	public String getAlternatecontact() {
		return this.alternatecontact;
	}

	public void setAlternatecontact(String alternatecontact) {
		this.alternatecontact = alternatecontact;
	}

	@Column(name = "contactaddress", length = 300)
	public String getContactaddress() {
		return this.contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	@Column(name = "emailaddress", length = 45)
	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	@Column(name = "personsallowed")
	public Long getPersonsallowed() {
		return this.personsallowed;
	}

	public void setPersonsallowed(Long personsallowed) {
		this.personsallowed = personsallowed;
	}

	@Column(name = "appusersallowed")
	public Long getAppusersallowed() {
		return this.appusersallowed;
	}

	public void setAppusersallowed(Long appusersallowed) {
		this.appusersallowed = appusersallowed;
	}

	@Column(name = "applicationstatus", length = 45)
	public String getApplicationstatus() {
		return this.applicationstatus;
	}

	public void setApplicationstatus(String applicationstatus) {
		this.applicationstatus = applicationstatus;
	}

	@Column(name = "level1_id")
	public Long getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(Long level1Id) {
		this.level1Id = level1Id;
	}

	@Column(name = "orghierarchylevel")
	public Integer getOrghierarchylevel() {
		return this.orghierarchylevel;
	}

	public void setOrghierarchylevel(Integer orghierarchylevel) {
		this.orghierarchylevel = orghierarchylevel;
	}

	@Column(name = "subhierarchylevel")
	public Integer getSubhierarchylevel() {
		return this.subhierarchylevel;
	}

	public void setSubhierarchylevel(Integer subhierarchylevel) {
		this.subhierarchylevel = subhierarchylevel;
	}

	@Column(name = "subhierarchyleveltype", length = 45)
	public String getSubhierarchyleveltype() {
		return this.subhierarchyleveltype;
	}

	public void setSubhierarchyleveltype(String subhierarchyleveltype) {
		this.subhierarchyleveltype = subhierarchyleveltype;
	}

	@Column(name = "applicationuniqueid", unique = true, nullable = false)
	public Long getApplicationuniqueid() {
		return this.applicationuniqueid;
	}

	public void setApplicationuniqueid(Long applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
	}

	@Column(name = "inserteduser", length = 45)
	public String getInserteduser() {
		return this.inserteduser;
	}

	public void setInserteduser(String inserteduser) {
		this.inserteduser = inserteduser;
	}

	@Column(name = "inserteddate", length = 22)
	public Timestamp getInserteddate() {
		return this.inserteddate;
	}

	public void setInserteddate(Timestamp inserteddate) {
		this.inserteddate = inserteddate;
	}

	@Column(name = "imagelogo", length = 45)
	public String getImagelogo() {
		return this.imagelogo;
	}

	public void setImagelogo(String imagelogo) {
		this.imagelogo = imagelogo;
	}

}