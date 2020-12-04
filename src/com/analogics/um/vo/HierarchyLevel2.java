package com.analogics.um.vo;

/**
 * HierarchyLevel2 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel2 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -9181552089101301052L;
	private String level2Uniquecode;
	private Integer level2Id;
	private String level2Name;
	private String level2Code;
	private Integer level1Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel2() {
	}

	/** minimal constructor */
	public HierarchyLevel2(String level2Uniquecode, Integer level2Id) {
		this.level2Uniquecode = level2Uniquecode;
		this.level2Id = level2Id;
	}

	/** full constructor */
	public HierarchyLevel2(String level2Uniquecode, Integer level2Id,
			String level2Name, String level2Code, Integer level1Id) {
		this.level2Uniquecode = level2Uniquecode;
		this.level2Id = level2Id;
		this.level2Name = level2Name;
		this.level2Code = level2Code;
		this.level1Id = level1Id;
	}

	// Property accessors

	public String getLevel2Uniquecode() {
		return this.level2Uniquecode;
	}

	public void setLevel2Uniquecode(String level2Uniquecode) {
		this.level2Uniquecode = level2Uniquecode;
	}

	public Integer getLevel2Id() {
		return this.level2Id;
	}

	public void setLevel2Id(Integer level2Id) {
		this.level2Id = level2Id;
	}

	public String getLevel2Name() {
		return this.level2Name;
	}

	public void setLevel2Name(String level2Name) {
		this.level2Name = level2Name;
	}

	public String getLevel2Code() {
		return this.level2Code;
	}

	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}

	public Integer getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(Integer level1Id) {
		this.level1Id = level1Id;
	}

}