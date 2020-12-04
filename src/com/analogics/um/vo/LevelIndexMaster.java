package com.analogics.um.vo;

/**
 * LevelIndexMaster entity. @author MyEclipse Persistence Tools
 */

public class LevelIndexMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8024252827449539485L;
	private LevelIndexMasterId id;
	private Integer indexid;

	// Constructors

	/** default constructor */
	public LevelIndexMaster() {
	}

	/** full constructor */
	public LevelIndexMaster(LevelIndexMasterId id, Integer indexid) {
		this.id = id;
		this.indexid = indexid;
	}

	// Property accessors

	public LevelIndexMasterId getId() {
		return this.id;
	}

	public void setId(LevelIndexMasterId id) {
		this.id = id;
	}

	public Integer getIndexid() {
		return this.indexid;
	}

	public void setIndexid(Integer indexid) {
		this.indexid = indexid;
	}

}