package com.analogics.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ModuleMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "module_master")
public class ModuleMaster implements java.io.Serializable {

	private static final long serialVersionUID = 3670965793841489961L;
	// Fields

	private String moduleTypeName;
	private String moduleTypeCode;
	private String moduleDescription;

	// Constructors

	/** default constructor */
	public ModuleMaster() {
	}

	/** minimal constructor */
	public ModuleMaster(String moduleTypeName, String moduleTypeCode) {
		this.moduleTypeName = moduleTypeName;
		this.moduleTypeCode = moduleTypeCode;
	}

	/** full constructor */
	public ModuleMaster(String moduleTypeName, String moduleTypeCode,
			String moduleDescription) {
		this.moduleTypeName = moduleTypeName;
		this.moduleTypeCode = moduleTypeCode;
		this.moduleDescription = moduleDescription;
	}

	// Property accessors
	@Id
	@Column(name = "module_type_name", unique = true, nullable = false, length = 100)
	public String getModuleTypeName() {
		return this.moduleTypeName;
	}

	public void setModuleTypeName(String moduleTypeName) {
		this.moduleTypeName = moduleTypeName;
	}

	@Column(name = "module_type_code", nullable = false, length = 20)
	public String getModuleTypeCode() {
		return this.moduleTypeCode;
	}

	public void setModuleTypeCode(String moduleTypeCode) {
		this.moduleTypeCode = moduleTypeCode;
	}

	@Column(name = "module_description", length = 200)
	public String getModuleDescription() {
		return this.moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

}