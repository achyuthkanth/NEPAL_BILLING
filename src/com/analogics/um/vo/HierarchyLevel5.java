package com.analogics.um.vo;

/**
 * HierarchyLevel5 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel5 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1792278385553935330L;
	private String level5Uniquecode;
	private Integer level5Id;
	private String level5Name;
	private String level5Code;
	private Integer level4Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel5() {
	}

	/** minimal constructor */
	public HierarchyLevel5(String level5Uniquecode, Integer level5Id) {
		this.level5Uniquecode = level5Uniquecode;
		this.level5Id = level5Id;
	}

	/** full constructor */
	public HierarchyLevel5(String level5Uniquecode, Integer level5Id,
			String level5Name, String level5Code, Integer level4Id) {
		this.level5Uniquecode = level5Uniquecode;
		this.level5Id = level5Id;
		this.level5Name = level5Name;
		this.level5Code = level5Code;
		this.level4Id = level4Id;
	}

	// Property accessors

	public String getLevel5Uniquecode() {
		return this.level5Uniquecode;
	}

	public void setLevel5Uniquecode(String level5Uniquecode) {
		this.level5Uniquecode = level5Uniquecode;
	}

	public Integer getLevel5Id() {
		return this.level5Id;
	}

	public void setLevel5Id(Integer level5Id) {
		this.level5Id = level5Id;
	}

	public String getLevel5Name() {
		return this.level5Name;
	}

	public void setLevel5Name(String level5Name) {
		this.level5Name = level5Name;
	}

	public String getLevel5Code() {
		return this.level5Code;
	}

	public void setLevel5Code(String level5Code) {
		this.level5Code = level5Code;
	}

	public Integer getLevel4Id() {
		return this.level4Id;
	}

	public void setLevel4Id(Integer level4Id) {
		this.level4Id = level4Id;
	}

}