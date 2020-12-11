package com.analogics.um.vo;

/**
 * ApplicationHierarchyLevel1Id entity. @author MyEclipse Persistence Tools
 */

public class ApplicationHierarchyLevel1Id implements java.io.Serializable {

	// Fields

	
	private static final long serialVersionUID = 1L;
	private String level1Uniquecode;
	private String applicationuniqueid;

	// Constructors

	/** default constructor */
	public ApplicationHierarchyLevel1Id() {
	}

	/** full constructor */
	public ApplicationHierarchyLevel1Id(String level1Uniquecode,
			String applicationuniqueid) {
		this.level1Uniquecode = level1Uniquecode;
		this.applicationuniqueid = applicationuniqueid;
	}

	// Property accessors

	public String getLevel1Uniquecode() {
		return this.level1Uniquecode;
	}

	public void setLevel1Uniquecode(String level1Uniquecode) {
		this.level1Uniquecode = level1Uniquecode;
	}

	public String getApplicationuniqueid() {
		return this.applicationuniqueid;
	}

	public void setApplicationuniqueid(String applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ApplicationHierarchyLevel1Id))
			return false;
		ApplicationHierarchyLevel1Id castOther = (ApplicationHierarchyLevel1Id) other;

		return ((this.getLevel1Uniquecode() == castOther.getLevel1Uniquecode()) || (this
				.getLevel1Uniquecode() != null
				&& castOther.getLevel1Uniquecode() != null && this
				.getLevel1Uniquecode().equals(castOther.getLevel1Uniquecode())))
				&& ((this.getApplicationuniqueid() == castOther
						.getApplicationuniqueid()) || (this
						.getApplicationuniqueid() != null
						&& castOther.getApplicationuniqueid() != null && this
						.getApplicationuniqueid().equals(
								castOther.getApplicationuniqueid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getLevel1Uniquecode() == null ? 0 : this
						.getLevel1Uniquecode().hashCode());
		result = 37
				* result
				+ (getApplicationuniqueid() == null ? 0 : this
						.getApplicationuniqueid().hashCode());
		return result;
	}

}