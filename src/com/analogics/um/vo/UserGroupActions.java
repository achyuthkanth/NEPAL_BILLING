package com.analogics.um.vo;

/**
 * UserGroupActions entity. @author MyEclipse Persistence Tools
 */

public class UserGroupActions implements java.io.Serializable {

	// Fields

	private UserGroupActionsId id;
	private String moduleName;
	private String createflag;
	private String readflag;
	private String updateflag;
	private String deleteflag;
	private Integer status;

	// Constructors

	/** default constructor */
	public UserGroupActions() {
	}

	/** minimal constructor */
	public UserGroupActions(UserGroupActionsId id, String moduleName,
			String createflag, String readflag, String updateflag,
			String deleteflag) {
		this.id = id;
		this.moduleName = moduleName;
		this.createflag = createflag;
		this.readflag = readflag;
		this.updateflag = updateflag;
		this.deleteflag = deleteflag;
	}

	/** full constructor */
	public UserGroupActions(UserGroupActionsId id, String moduleName,
			String createflag, String readflag, String updateflag,
			String deleteflag, Integer status) {
		this.id = id;
		this.moduleName = moduleName;
		this.createflag = createflag;
		this.readflag = readflag;
		this.updateflag = updateflag;
		this.deleteflag = deleteflag;
		this.status = status;
	}

	// Property accessors

	public UserGroupActionsId getId() {
		return this.id;
	}

	public void setId(UserGroupActionsId id) {
		this.id = id;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getCreateflag() {
		return this.createflag;
	}

	public void setCreateflag(String createflag) {
		this.createflag = createflag;
	}

	public String getReadflag() {
		return this.readflag;
	}

	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}

	public String getUpdateflag() {
		return this.updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	public String getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}