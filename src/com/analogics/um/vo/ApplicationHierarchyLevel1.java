package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel1 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel1 implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private ApplicationHierarchyLevel1Id id;
	private Integer level1Id;
	private String level1Name;
	private String level1Code;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel1() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel1(ApplicationHierarchyLevel1Id id,
			Integer level1Id) {
		this.id = id;
		this.level1Id = level1Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel1(ApplicationHierarchyLevel1Id id,
			Integer level1Id, String level1Name, String level1Code) {
		this.id = id;
		this.level1Id = level1Id;
		this.level1Name = level1Name;
		this.level1Code = level1Code;
	}

	// Property accessors

	public ApplicationHierarchyLevel1Id getId() {
		return this.id;
	}

	public void setId(ApplicationHierarchyLevel1Id id) {
		this.id = id;
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