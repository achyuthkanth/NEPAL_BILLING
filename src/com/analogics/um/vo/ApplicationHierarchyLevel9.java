package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel9 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel9 implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private Integer level9Id;
	private String level9Name;
	private String level9Code;
	private String level9Uniquecode;
	private Integer level8Id;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel9() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel9(Integer level9Id) {
		this.level9Id = level9Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel9(Integer level9Id, String level9Name,
			String level9Code, String level9Uniquecode, Integer level8Id) {
		this.level9Id = level9Id;
		this.level9Name = level9Name;
		this.level9Code = level9Code;
		this.level9Uniquecode = level9Uniquecode;
		this.level8Id = level8Id;
	}

	// Property accessors

	public Integer getLevel9Id() {
		return this.level9Id;
	}

	public void setLevel9Id(Integer level9Id) {
		this.level9Id = level9Id;
	}

	public String getLevel9Name() {
		return this.level9Name;
	}

	public void setLevel9Name(String level9Name) {
		this.level9Name = level9Name;
	}

	public String getLevel9Code() {
		return this.level9Code;
	}

	public void setLevel9Code(String level9Code) {
		this.level9Code = level9Code;
	}

	public String getLevel9Uniquecode() {
		return this.level9Uniquecode;
	}

	public void setLevel9Uniquecode(String level9Uniquecode) {
		this.level9Uniquecode = level9Uniquecode;
	}

	public Integer getLevel8Id() {
		return this.level8Id;
	}

	public void setLevel8Id(Integer level8Id) {
		this.level8Id = level8Id;
	}

}