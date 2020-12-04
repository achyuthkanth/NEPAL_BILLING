package com.analogics.um.vo;

/**
 * HierarchyLevel13 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel13 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6766257517339934772L;
	private Integer level13Id;
	private String level13Name;
	private String level13Code;
	private String level13Uniquecode;
	private Integer level12Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel13() {
	}

	/** minimal constructor */
	public HierarchyLevel13(Integer level13Id) {
		this.level13Id = level13Id;
	}

	/** full constructor */
	public HierarchyLevel13(Integer level13Id, String level13Name,
			String level13Code, String level13Uniquecode, Integer level12Id) {
		this.level13Id = level13Id;
		this.level13Name = level13Name;
		this.level13Code = level13Code;
		this.level13Uniquecode = level13Uniquecode;
		this.level12Id = level12Id;
	}

	// Property accessors

	public Integer getLevel13Id() {
		return this.level13Id;
	}

	public void setLevel13Id(Integer level13Id) {
		this.level13Id = level13Id;
	}

	public String getLevel13Name() {
		return this.level13Name;
	}

	public void setLevel13Name(String level13Name) {
		this.level13Name = level13Name;
	}

	public String getLevel13Code() {
		return this.level13Code;
	}

	public void setLevel13Code(String level13Code) {
		this.level13Code = level13Code;
	}

	public String getLevel13Uniquecode() {
		return this.level13Uniquecode;
	}

	public void setLevel13Uniquecode(String level13Uniquecode) {
		this.level13Uniquecode = level13Uniquecode;
	}

	public Integer getLevel12Id() {
		return this.level12Id;
	}

	public void setLevel12Id(Integer level12Id) {
		this.level12Id = level12Id;
	}

}