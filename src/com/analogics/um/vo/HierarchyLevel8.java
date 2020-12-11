package com.analogics.um.vo;

/**
 * HierarchyLevel8 entity. @author MyEclipse Persistence Tools
 */

public class HierarchyLevel8 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -827725217511013720L;
	private String level8Uniquecode;
	private Integer level8Id;
	private String level8Name;
	private String level8Code;
	private Integer level7Id;

	// Constructors

	/** default constructor */
	public HierarchyLevel8() {
	}

	/** minimal constructor */
	public HierarchyLevel8(String level8Uniquecode, Integer level8Id) {
		this.level8Uniquecode = level8Uniquecode;
		this.level8Id = level8Id;
	}

	/** full constructor */
	public HierarchyLevel8(String level8Uniquecode, Integer level8Id,
			String level8Name, String level8Code, Integer level7Id) {
		this.level8Uniquecode = level8Uniquecode;
		this.level8Id = level8Id;
		this.level8Name = level8Name;
		this.level8Code = level8Code;
		this.level7Id = level7Id;
	}

	// Property accessors

	public String getLevel8Uniquecode() {
		return this.level8Uniquecode;
	}

	public void setLevel8Uniquecode(String level8Uniquecode) {
		this.level8Uniquecode = level8Uniquecode;
	}

	public Integer getLevel8Id() {
		return this.level8Id;
	}

	public void setLevel8Id(Integer level8Id) {
		this.level8Id = level8Id;
	}

	public String getLevel8Name() {
		return this.level8Name;
	}

	public void setLevel8Name(String level8Name) {
		this.level8Name = level8Name;
	}

	public String getLevel8Code() {
		return this.level8Code;
	}

	public void setLevel8Code(String level8Code) {
		this.level8Code = level8Code;
	}

	public Integer getLevel7Id() {
		return this.level7Id;
	}

	public void setLevel7Id(Integer level7Id) {
		this.level7Id = level7Id;
	}

}