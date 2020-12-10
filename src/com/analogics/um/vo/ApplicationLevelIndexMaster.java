package com.analogics.um.vo;

/**
 * ApplicationLevelIndexMaster entity. @author MyEclipse Persistence Tools
 */

public class ApplicationLevelIndexMaster implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private ApplicationLevelIndexMasterId id;
	private Integer appIndexid;

	// Constructors

	/** default constructor */
	public ApplicationLevelIndexMaster() {
	}

	/** full constructor */
	public ApplicationLevelIndexMaster(ApplicationLevelIndexMasterId id,
			Integer appIndexid) {
		this.id = id;
		this.appIndexid = appIndexid;
	}

	// Property accessors

	public ApplicationLevelIndexMasterId getId() {
		return this.id;
	}

	public void setId(ApplicationLevelIndexMasterId id) {
		this.id = id;
	}

	public Integer getAppIndexid() {
		return this.appIndexid;
	}

	public void setAppIndexid(Integer appIndexid) {
		this.appIndexid = appIndexid;
	}

}