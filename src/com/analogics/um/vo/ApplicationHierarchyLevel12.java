package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel12 entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel12 implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private Integer level12Id;
	private String level12Name;
	private String level12Code;
	private String level12Uniquecode;
	private Integer level11Id;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel12() {
	}

	/** minimal constructor */
	public ApplicationHierarchyLevel12(Integer level12Id) {
		this.level12Id = level12Id;
	}

	/** full constructor */
	public ApplicationHierarchyLevel12(Integer level12Id, String level12Name,
			String level12Code, String level12Uniquecode, Integer level11Id) {
		this.level12Id = level12Id;
		this.level12Name = level12Name;
		this.level12Code = level12Code;
		this.level12Uniquecode = level12Uniquecode;
		this.level11Id = level11Id;
	}

	// Property accessors

	public Integer getLevel12Id() {
		return this.level12Id;
	}

	public void setLevel12Id(Integer level12Id) {
		this.level12Id = level12Id;
	}

	public String getLevel12Name() {
		return this.level12Name;
	}

	public void setLevel12Name(String level12Name) {
		this.level12Name = level12Name;
	}

	public String getLevel12Code() {
		return this.level12Code;
	}

	public void setLevel12Code(String level12Code) {
		this.level12Code = level12Code;
	}

	public String getLevel12Uniquecode() {
		return this.level12Uniquecode;
	}

	public void setLevel12Uniquecode(String level12Uniquecode) {
		this.level12Uniquecode = level12Uniquecode;
	}

	public Integer getLevel11Id() {
		return this.level11Id;
	}

	public void setLevel11Id(Integer level11Id) {
		this.level11Id = level11Id;
	}

}