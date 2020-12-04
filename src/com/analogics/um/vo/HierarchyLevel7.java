package com.analogics.um.vo;

/**
 * HierarchyLevel7 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel7 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4517405273054945619L;
	private String level7Uniquecode;
	private Integer level7Id;
	private String level7Name;
	private String level7Code;
	private Integer level6Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel7() {
	}

	/** minimal constructor */
	public HierarchyLevel7(String level7Uniquecode, Integer level7Id) {
		this.level7Uniquecode = level7Uniquecode;
		this.level7Id = level7Id;
	}

	/** full constructor */
	public HierarchyLevel7(String level7Uniquecode, Integer level7Id,
			String level7Name, String level7Code, Integer level6Id) {
		this.level7Uniquecode = level7Uniquecode;
		this.level7Id = level7Id;
		this.level7Name = level7Name;
		this.level7Code = level7Code;
		this.level6Id = level6Id;
	}

	// Property accessors

	public String getLevel7Uniquecode() {
		return this.level7Uniquecode;
	}

	public void setLevel7Uniquecode(String level7Uniquecode) {
		this.level7Uniquecode = level7Uniquecode;
	}

	public Integer getLevel7Id() {
		return this.level7Id;
	}

	public void setLevel7Id(Integer level7Id) {
		this.level7Id = level7Id;
	}

	public String getLevel7Name() {
		return this.level7Name;
	}

	public void setLevel7Name(String level7Name) {
		this.level7Name = level7Name;
	}

	public String getLevel7Code() {
		return this.level7Code;
	}

	public void setLevel7Code(String level7Code) {
		this.level7Code = level7Code;
	}

	public Integer getLevel6Id() {
		return this.level6Id;
	}

	public void setLevel6Id(Integer level6Id) {
		this.level6Id = level6Id;
	}

}