package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel6 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel6 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer level6Id;
	private String level6Name;
	private String level6Code;
	private String level6Uniquecode;
	private Integer level5Id;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel6() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel6(Integer level6Id) {
		this.level6Id = level6Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel6(Integer level6Id, String level6Name,
			String level6Code, String level6Uniquecode, Integer level5Id) {
		this.level6Id = level6Id;
		this.level6Name = level6Name;
		this.level6Code = level6Code;
		this.level6Uniquecode = level6Uniquecode;
		this.level5Id = level5Id;
	}

	// Property accessors

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

	public String getLevel6Uniquecode() {
		return this.level6Uniquecode;
	}

	public void setLevel6Uniquecode(String level6Uniquecode) {
		this.level6Uniquecode = level6Uniquecode;
	}

	public Integer getLevel5Id() {
		return this.level5Id;
	}

	public void setLevel5Id(Integer level5Id) {
		this.level5Id = level5Id;
	}

}