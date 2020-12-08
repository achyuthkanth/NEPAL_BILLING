package com.analogics.um.vo;

import java.util.ArrayList;
import java.util.List;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ModuleMaster entity. @author MyEclipse Persistence Tools
 */

public class ModuleMaster extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7511288528787687146L;
	private String moduleTypeName;
	private String moduleTypeCode;
	private String moduleDescription;
	
	//Required Fields
	private List<ModuleDetails> modulesList=new ArrayList<ModuleDetails>();

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

	public String getModuleTypeName() {
		return this.moduleTypeName;
	}

	public void setModuleTypeName(String moduleTypeName) {
		this.moduleTypeName = moduleTypeName;
	}

	public String getModuleTypeCode() {
		return this.moduleTypeCode;
	}

	public void setModuleTypeCode(String moduleTypeCode) {
		this.moduleTypeCode = moduleTypeCode;
	}

	public String getModuleDescription() {
		return this.moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public List<ModuleDetails> getModulesList() {
		return modulesList;
	}

	public void setModulesList(List<ModuleDetails> modulesList) {
		this.modulesList = modulesList;
	}

}