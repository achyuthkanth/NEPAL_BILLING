package com.analogics.vo;

import java.sql.Timestamp;

/**
 * AlarmDataId entity. @author MyEclipse Persistence Tools
 */

public class AlarmDataId implements java.io.Serializable {

	// Fields

	private String nodeNumber;
	private Timestamp nodeDateTime;

	// Constructors

	/** default constructor */
	public AlarmDataId() {
	}

	/** full constructor */
	public AlarmDataId(String nodeNumber, Timestamp nodeDateTime) {
		this.nodeNumber = nodeNumber;
		this.nodeDateTime = nodeDateTime;
	}

	// Property accessors

	public String getNodeNumber() {
		return this.nodeNumber;
	}

	public void setNodeNumber(String nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	public Timestamp getNodeDateTime() {
		return this.nodeDateTime;
	}

	public void setNodeDateTime(Timestamp nodeDateTime) {
		this.nodeDateTime = nodeDateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AlarmDataId))
			return false;
		AlarmDataId castOther = (AlarmDataId) other;

		return ((this.getNodeNumber() == castOther.getNodeNumber()) || (this
				.getNodeNumber() != null && castOther.getNodeNumber() != null && this
				.getNodeNumber().equals(castOther.getNodeNumber())))
				&& ((this.getNodeDateTime() == castOther.getNodeDateTime()) || (this
						.getNodeDateTime() != null
						&& castOther.getNodeDateTime() != null && this
						.getNodeDateTime().equals(castOther.getNodeDateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNodeNumber() == null ? 0 : this.getNodeNumber()
						.hashCode());
		result = 37
				* result
				+ (getNodeDateTime() == null ? 0 : this.getNodeDateTime()
						.hashCode());
		return result;
	}

}