package com.analogics.um.vo;

/**
 * UserGroupViews entity. @author MyEclipse Persistence Tools
 */

public class UserGroupViews implements java.io.Serializable {

	// Fields

	private UserGroupViewsId id;

	// Constructors

	/** default constructor */
	public UserGroupViews() {
	}

	/** full constructor */
	public UserGroupViews(UserGroupViewsId id) {
		this.id = id;
	}

	// Property accessors

	public UserGroupViewsId getId() {
		return this.id;
	}

	public void setId(UserGroupViewsId id) {
		this.id = id;
	}

}