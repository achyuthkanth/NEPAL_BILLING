package com.analogics.um.vo;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ModuleDetails entity. @author MyEclipse Persistence Tools
 */

public class ModuleDetails extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -286977914443145198L;
	private ModuleDetailsId id;
	private String moduledescription;

	// Constructors

	/** default constructor */
	public ModuleDetails() {
	}

	/** minimal constructor */
	public ModuleDetails(ModuleDetailsId id) {
		this.id = id;
	}

	/** full constructor */
	public ModuleDetails(ModuleDetailsId id, String moduledescription) {
		this.id = id;
		this.moduledescription = moduledescription;
	}

	// Property accessors

	public ModuleDetailsId getId() {
		return this.id;
	}

	public void setId(ModuleDetailsId id) {
		this.id = id;
	}

	public String getModuledescription() {
		return this.moduledescription;
	}

	public void setModuledescription(String moduledescription) {
		this.moduledescription = moduledescription;
	}

}