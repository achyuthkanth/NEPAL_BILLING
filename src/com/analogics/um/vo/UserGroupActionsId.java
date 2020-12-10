package com.analogics.um.vo;

/**
 * UserGroupActionsId entity. @author MyEclipse Persistence Tools
 */

public class UserGroupActionsId implements java.io.Serializable {

	// Fields

	private String groupname;
	private String moduleAction;

	// Constructors

	/** default constructor */
	public UserGroupActionsId() {
	}

	/** full constructor */
	public UserGroupActionsId(String groupname, String moduleAction) {
		this.groupname = groupname;
		this.moduleAction = moduleAction;
	}

	// Property accessors

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getModuleAction() {
		return this.moduleAction;
	}

	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserGroupActionsId))
			return false;
		UserGroupActionsId castOther = (UserGroupActionsId) other;

		return ((this.getGroupname() == castOther.getGroupname()) || (this
				.getGroupname() != null && castOther.getGroupname() != null && this
				.getGroupname().equals(castOther.getGroupname())))
				&& ((this.getModuleAction() == castOther.getModuleAction()) || (this
						.getModuleAction() != null
						&& castOther.getModuleAction() != null && this
						.getModuleAction().equals(castOther.getModuleAction())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupname() == null ? 0 : this.getGroupname().hashCode());
		result = 37
				* result
				+ (getModuleAction() == null ? 0 : this.getModuleAction()
						.hashCode());
		return result;
	}

}