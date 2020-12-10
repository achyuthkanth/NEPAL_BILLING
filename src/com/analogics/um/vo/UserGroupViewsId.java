package com.analogics.um.vo;

/**
 * UserGroupViewsId entity. @author MyEclipse Persistence Tools
 */

public class UserGroupViewsId implements java.io.Serializable {

	// Fields

	private String groupname;
	private String viewname;

	// Constructors

	/** default constructor */
	public UserGroupViewsId() {
	}

	/** full constructor */
	public UserGroupViewsId(String groupname, String viewname) {
		this.groupname = groupname;
		this.viewname = viewname;
	}

	// Property accessors

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getViewname() {
		return this.viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserGroupViewsId))
			return false;
		UserGroupViewsId castOther = (UserGroupViewsId) other;

		return ((this.getGroupname() == castOther.getGroupname()) || (this
				.getGroupname() != null && castOther.getGroupname() != null && this
				.getGroupname().equals(castOther.getGroupname())))
				&& ((this.getViewname() == castOther.getViewname()) || (this
						.getViewname() != null
						&& castOther.getViewname() != null && this
						.getViewname().equals(castOther.getViewname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupname() == null ? 0 : this.getGroupname().hashCode());
		result = 37 * result
				+ (getViewname() == null ? 0 : this.getViewname().hashCode());
		return result;
	}

}