package com.analogics.um.vo;

import java.sql.Timestamp;

import com.analogics.utils.ExtraFieldspojo;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */

public class UserGroup extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private UserGroupId id;
	private String groupdescription;
	private Timestamp inserteddate;
	private String inserteduser;

	
	//Extra Fields
	private String[] moduleEnabledActions;
	private String[] createflag;
	private String[] readflag;
	private String[] updateflag;
	private String[] deleteflag;
	private String[] checkBoxArr;
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

	public String[] getModuleEnabledActions() {
		return moduleEnabledActions;
	}

	public void setModuleEnabledActions(String[] moduleEnabledActions) {
		this.moduleEnabledActions = moduleEnabledActions;
	}

	public String[] getCreateflag() {
		return createflag;
	}

	public void setCreateflag(String[] createflag) {
		this.createflag = createflag;
	}

	public String[] getReadflag() {
		return readflag;
	}

	public void setReadflag(String[] readflag) {
		this.readflag = readflag;
	}

	public String[] getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String[] updateflag) {
		this.updateflag = updateflag;
	}

	public String[] getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String[] deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String[] getCheckBoxArr() {
		return checkBoxArr;
	}

	public void setCheckBoxArr(String[] checkBoxArr) {
		this.checkBoxArr = checkBoxArr;
	}

}