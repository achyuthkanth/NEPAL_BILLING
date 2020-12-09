package com.analogics.um.vo;

/**
 * UserGroupId entity. @author MyEclipse Persistence Tools
 */

public class UserGroupId implements java.io.Serializable {

	// Fields

	private String groupname;
	private Long applicationuniqueid;

	// Constructors

	/** default constructor */
	public UserGroupId() {
	}

	/** full constructor */
	public UserGroupId(String groupname, Long applicationuniqueid) {
		this.groupname = groupname;
		this.applicationuniqueid = applicationuniqueid;
	}

	// Property accessors

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Long getApplicationuniqueid() {
		return this.applicationuniqueid;
	}

	public void setApplicationuniqueid(Long applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserGroupId))
			return false;
		UserGroupId castOther = (UserGroupId) other;

		return ((this.getGroupname() == castOther.getGroupname()) || (this
				.getGroupname() != null && castOther.getGroupname() != null && this
				.getGroupname().equals(castOther.getGroupname())))
				&& ((this.getApplicationuniqueid() == castOther
						.getApplicationuniqueid()) || (this
						.getApplicationuniqueid() != null
						&& castOther.getApplicationuniqueid() != null && this
						.getApplicationuniqueid().equals(
								castOther.getApplicationuniqueid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupname() == null ? 0 : this.getGroupname().hashCode());
		result = 37
				* result
				+ (getApplicationuniqueid() == null ? 0 : this
						.getApplicationuniqueid().hashCode());
		return result;
	}

}