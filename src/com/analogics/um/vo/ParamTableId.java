package com.analogics.um.vo;

/**
 * ParamTableId entity. @author MyEclipse Persistence Tools
 */

public class ParamTableId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7600124703153695199L;
	private String paramType;
	private String paramName;

	// Constructors

	/** default constructor */
	public ParamTableId() {
	}

	/** full constructor */
	public ParamTableId(String paramType, String paramName) {
		this.paramType = paramType;
		this.paramName = paramName;
	}

	// Property accessors

	public String getParamType() {
		return this.paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParamTableId))
			return false;
		ParamTableId castOther = (ParamTableId) other;

		return ((this.getParamType() == castOther.getParamType()) || (this
				.getParamType() != null && castOther.getParamType() != null && this
				.getParamType().equals(castOther.getParamType())))
				&& ((this.getParamName() == castOther.getParamName()) || (this
						.getParamName() != null
						&& castOther.getParamName() != null && this
						.getParamName().equals(castOther.getParamName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getParamType() == null ? 0 : this.getParamType().hashCode());
		result = 37 * result
				+ (getParamName() == null ? 0 : this.getParamName().hashCode());
		return result;
	}

}