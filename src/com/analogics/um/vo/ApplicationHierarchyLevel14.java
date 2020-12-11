package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel14 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel14 implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private Integer level14Id;
	private String level14Name;
	private String level14Code;
	private String level14Uniquecode;
	private Integer level13Id;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel14() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel14(Integer level14Id) {
		this.level14Id = level14Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel14(Integer level14Id, String level14Name,
			String level14Code, String level14Uniquecode, Integer level13Id) {
		this.level14Id = level14Id;
		this.level14Name = level14Name;
		this.level14Code = level14Code;
		this.level14Uniquecode = level14Uniquecode;
		this.level13Id = level13Id;
	}

	// Property accessors

	public Integer getLevel14Id() {
		return this.level14Id;
	}

	public void setLevel14Id(Integer level14Id) {
		this.level14Id = level14Id;
	}

	public String getLevel14Name() {
		return this.level14Name;
	}

	public void setLevel14Name(String level14Name) {
		this.level14Name = level14Name;
	}

	public String getLevel14Code() {
		return this.level14Code;
	}

	public void setLevel14Code(String level14Code) {
		this.level14Code = level14Code;
	}

	public String getLevel14Uniquecode() {
		return this.level14Uniquecode;
	}

	public void setLevel14Uniquecode(String level14Uniquecode) {
		this.level14Uniquecode = level14Uniquecode;
	}

	public Integer getLevel13Id() {
		return this.level13Id;
	}

	public void setLevel13Id(Integer level13Id) {
		this.level13Id = level13Id;
	}

}