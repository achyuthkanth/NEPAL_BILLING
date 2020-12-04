package com.analogics.um.vo;

/**
 * HierarchyLevel6 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel6 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2047319485792542916L;
	private String level6Uniquecode;
	private Integer level6Id;
	private String level6Name;
	private String level6Code;
	private Integer level5Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel6() {
	}

	/** minimal constructor */
	public HierarchyLevel6(String level6Uniquecode, Integer level6Id) {
		this.level6Uniquecode = level6Uniquecode;
		this.level6Id = level6Id;
	}

	/** full constructor */
	public HierarchyLevel6(String level6Uniquecode, Integer level6Id,
			String level6Name, String level6Code, Integer level5Id) {
		this.level6Uniquecode = level6Uniquecode;
		this.level6Id = level6Id;
		this.level6Name = level6Name;
		this.level6Code = level6Code;
		this.level5Id = level5Id;
	}

	// Property accessors

	public String getLevel6Uniquecode() {
		return this.level6Uniquecode;
	}

	public void setLevel6Uniquecode(String level6Uniquecode) {
		this.level6Uniquecode = level6Uniquecode;
	}

	public Integer getLevel6Id() {
		return this.level6Id;
	}

	public void setLevel6Id(Integer level6Id) {
		this.level6Id = level6Id;
	}

	public String getLevel6Name() {
		return this.level6Name;
	}

	public void setLevel6Name(String level6Name) {
		this.level6Name = level6Name;
	}

	public String getLevel6Code() {
		return this.level6Code;
	}

	public void setLevel6Code(String level6Code) {
		this.level6Code = level6Code;
	}

	public Integer getLevel5Id() {
		return this.level5Id;
	}

	public void setLevel5Id(Integer level5Id) {
		this.level5Id = level5Id;
	}

}