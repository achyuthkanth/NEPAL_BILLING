package com.analogics.um.vo;

/**
 * HierarchyLevel15 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel15 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -729502001222884109L;
	private Integer level15Id;
	private String level15Name;
	private String level15Code;
	private String level15Uniquecode;
	private Integer level14Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel15() {
	}

	/** minimal constructor */
	public HierarchyLevel15(Integer level15Id) {
		this.level15Id = level15Id;
	}

	/** full constructor */
	public HierarchyLevel15(Integer level15Id, String level15Name,
			String level15Code, String level15Uniquecode, Integer level14Id) {
		this.level15Id = level15Id;
		this.level15Name = level15Name;
		this.level15Code = level15Code;
		this.level15Uniquecode = level15Uniquecode;
		this.level14Id = level14Id;
	}

	// Property accessors

	public Integer getLevel15Id() {
		return this.level15Id;
	}

	public void setLevel15Id(Integer level15Id) {
		this.level15Id = level15Id;
	}

	public String getLevel15Name() {
		return this.level15Name;
	}

	public void setLevel15Name(String level15Name) {
		this.level15Name = level15Name;
	}

	public String getLevel15Code() {
		return this.level15Code;
	}

	public void setLevel15Code(String level15Code) {
		this.level15Code = level15Code;
	}

	public String getLevel15Uniquecode() {
		return this.level15Uniquecode;
	}

	public void setLevel15Uniquecode(String level15Uniquecode) {
		this.level15Uniquecode = level15Uniquecode;
	}

	public Integer getLevel14Id() {
		return this.level14Id;
	}

	public void setLevel14Id(Integer level14Id) {
		this.level14Id = level14Id;
	}

}