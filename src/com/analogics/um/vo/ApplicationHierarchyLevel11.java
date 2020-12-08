package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel11 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel11 implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private Integer level11Id;
	private String level11Name;
	private String level11Code;
	private String level11Uniquecode;
	private Integer level10Id;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel11() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel11(Integer level11Id) {
		this.level11Id = level11Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel11(Integer level11Id, String level11Name,
			String level11Code, String level11Uniquecode, Integer level10Id) {
		this.level11Id = level11Id;
		this.level11Name = level11Name;
		this.level11Code = level11Code;
		this.level11Uniquecode = level11Uniquecode;
		this.level10Id = level10Id;
	}

	// Property accessors

	public Integer getLevel11Id() {
		return this.level11Id;
	}

	public void setLevel11Id(Integer level11Id) {
		this.level11Id = level11Id;
	}

	public String getLevel11Name() {
		return this.level11Name;
	}

	public void setLevel11Name(String level11Name) {
		this.level11Name = level11Name;
	}

	public String getLevel11Code() {
		return this.level11Code;
	}

	public void setLevel11Code(String level11Code) {
		this.level11Code = level11Code;
	}

	public String getLevel11Uniquecode() {
		return this.level11Uniquecode;
	}

	public void setLevel11Uniquecode(String level11Uniquecode) {
		this.level11Uniquecode = level11Uniquecode;
	}

	public Integer getLevel10Id() {
		return this.level10Id;
	}

	public void setLevel10Id(Integer level10Id) {
		this.level10Id = level10Id;
	}

}