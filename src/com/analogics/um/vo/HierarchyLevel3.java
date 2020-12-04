package com.analogics.um.vo;

/**
 * HierarchyLevel3 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel3 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8942354919002298321L;
	private String level3Uniquecode;
	private Integer level3Id;
	private String level3Name;
	private String level3Code;
	private Integer level2Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel3() {
	}

	/** minimal constructor */
	public HierarchyLevel3(String level3Uniquecode, Integer level3Id) {
		this.level3Uniquecode = level3Uniquecode;
		this.level3Id = level3Id;
	}

	/** full constructor */
	public HierarchyLevel3(String level3Uniquecode, Integer level3Id,
			String level3Name, String level3Code, Integer level2Id) {
		this.level3Uniquecode = level3Uniquecode;
		this.level3Id = level3Id;
		this.level3Name = level3Name;
		this.level3Code = level3Code;
		this.level2Id = level2Id;
	}

	// Property accessors

	public String getLevel3Uniquecode() {
		return this.level3Uniquecode;
	}

	public void setLevel3Uniquecode(String level3Uniquecode) {
		this.level3Uniquecode = level3Uniquecode;
	}

	public Integer getLevel3Id() {
		return this.level3Id;
	}

	public void setLevel3Id(Integer level3Id) {
		this.level3Id = level3Id;
	}

	public String getLevel3Name() {
		return this.level3Name;
	}

	public void setLevel3Name(String level3Name) {
		this.level3Name = level3Name;
	}

	public String getLevel3Code() {
		return this.level3Code;
	}

	public void setLevel3Code(String level3Code) {
		this.level3Code = level3Code;
	}

	public Integer getLevel2Id() {
		return this.level2Id;
	}

	public void setLevel2Id(Integer level2Id) {
		this.level2Id = level2Id;
	}

}