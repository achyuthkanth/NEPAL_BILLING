package com.analogics.um.vo;

/**
 * HierarchyLevel4 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel4 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4166450715798448482L;
	private String level4Uniquecode;
	private Integer level4Id;
	private String level4Name;
	private String level4Code;
	private Integer level3Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel4() {
	}

	/** minimal constructor */
	public HierarchyLevel4(String level4Uniquecode, Integer level4Id) {
		this.level4Uniquecode = level4Uniquecode;
		this.level4Id = level4Id;
	}

	/** full constructor */
	public HierarchyLevel4(String level4Uniquecode, Integer level4Id,
			String level4Name, String level4Code, Integer level3Id) {
		this.level4Uniquecode = level4Uniquecode;
		this.level4Id = level4Id;
		this.level4Name = level4Name;
		this.level4Code = level4Code;
		this.level3Id = level3Id;
	}

	// Property accessors

	public String getLevel4Uniquecode() {
		return this.level4Uniquecode;
	}

	public void setLevel4Uniquecode(String level4Uniquecode) {
		this.level4Uniquecode = level4Uniquecode;
	}

	public Integer getLevel4Id() {
		return this.level4Id;
	}

	public void setLevel4Id(Integer level4Id) {
		this.level4Id = level4Id;
	}

	public String getLevel4Name() {
		return this.level4Name;
	}

	public void setLevel4Name(String level4Name) {
		this.level4Name = level4Name;
	}

	public String getLevel4Code() {
		return this.level4Code;
	}

	public void setLevel4Code(String level4Code) {
		this.level4Code = level4Code;
	}

	public Integer getLevel3Id() {
		return this.level3Id;
	}

	public void setLevel3Id(Integer level3Id) {
		this.level3Id = level3Id;
	}

}