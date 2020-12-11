package com.analogics.um.vo;

/**
 * HierarchyLevel1 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel1 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7387393866416896922L;
	private String level1Uniquecode;
	private Integer level1Id;
	private String level1Name;
	private String level1Code;

	// Constructors

	/** default constructor */
	public HierarchyLevel1() {
	}

	/** minimal constructor */
	public HierarchyLevel1(String level1Uniquecode, Integer level1Id) {
		this.level1Uniquecode = level1Uniquecode;
		this.level1Id = level1Id;
	}

	/** full constructor */
	public HierarchyLevel1(String level1Uniquecode, Integer level1Id,
			String level1Name, String level1Code) {
		this.level1Uniquecode = level1Uniquecode;
		this.level1Id = level1Id;
		this.level1Name = level1Name;
		this.level1Code = level1Code;
	}

	// Property accessors

	public String getLevel1Uniquecode() {
		return this.level1Uniquecode;
	}

	public void setLevel1Uniquecode(String level1Uniquecode) {
		this.level1Uniquecode = level1Uniquecode;
	}

	public Integer getLevel1Id() {
		return this.level1Id;
	}

	public void setLevel1Id(Integer level1Id) {
		this.level1Id = level1Id;
	}

	public String getLevel1Name() {
		return this.level1Name;
	}

	public void setLevel1Name(String level1Name) {
		this.level1Name = level1Name;
	}

	public String getLevel1Code() {
		return this.level1Code;
	}

	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}

}