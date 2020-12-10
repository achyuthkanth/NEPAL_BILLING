package com.analogics.um.vo;

import java.sql.Timestamp;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */

public class UserGroup implements java.io.Serializable {

	// Fields

	private UserGroupId id;
	private String groupdescription;
	private Timestamp inserteddate;
	private String inserteduser;

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	/** minimal constructor */
	public UserGroup(UserGroupId id, String groupdescription) {
		this.id = id;
		this.groupdescription = groupdescription;
	}

	/** full constructor */
	public UserGroup(UserGroupId id, String groupdescription,
			Timestamp inserteddate, String inserteduser) {
		this.id = id;
		this.groupdescription = groupdescription;
		this.inserteddate = inserteddate;
		this.inserteduser = inserteduser;
	}

	// Property accessors

	public UserGroupId getId() {
		return this.id;
	}

	public void setId(UserGroupId id) {
		this.id = id;
	}

	public String getGroupdescription() {
		return this.groupdescription;
	}

	public void setGroupdescription(String groupdescription) {
		this.groupdescription = groupdescription;
	}

	public Timestamp getInserteddate() {
		return this.inserteddate;
	}

	public void setInserteddate(Timestamp inserteddate) {
		this.inserteddate = inserteddate;
	}

	public String getInserteduser() {
		return this.inserteduser;
	}

	public void setInserteduser(String inserteduser) {
		this.inserteduser = inserteduser;
	}

}