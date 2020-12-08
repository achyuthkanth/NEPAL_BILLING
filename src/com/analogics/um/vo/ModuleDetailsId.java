package com.analogics.um.vo;

/**
 * ModuleDetailsId entity. @author MyEclipse Persistence Tools
 */

public class ModuleDetailsId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -723794321343836264L;
	private String moduleTypeName;
	private String moduleAction;

	// Constructors

	/** default constructor */
	public ModuleDetailsId() {
	}

	/** full constructor */
	public ModuleDetailsId(String moduleTypeName, String moduleAction) {
		this.moduleTypeName = moduleTypeName;
		this.moduleAction = moduleAction;
	}

	// Property accessors

	public String getModuleTypeName() {
		return this.moduleTypeName;
	}

	public void setModuleTypeName(String moduleTypeName) {
		this.moduleTypeName = moduleTypeName;
	}

	public String getModuleAction() {
		return this.moduleAction;
	}

	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ModuleDetailsId))
			return false;
		ModuleDetailsId castOther = (ModuleDetailsId) other;

		return ((this.getModuleTypeName() == castOther.getModuleTypeName()) || (this
				.getModuleTypeName() != null
				&& castOther.getModuleTypeName() != null && this
				.getModuleTypeName().equals(castOther.getModuleTypeName())))
				&& ((this.getModuleAction() == castOther.getModuleAction()) || (this
						.getModuleAction() != null
						&& castOther.getModuleAction() != null && this
						.getModuleAction().equals(castOther.getModuleAction())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getModuleTypeName() == null ? 0 : this.getModuleTypeName()
						.hashCode());
		result = 37
				* result
				+ (getModuleAction() == null ? 0 : this.getModuleAction()
						.hashCode());
		return result;
	}

}