package com.analogics.vo;

import java.sql.Timestamp;

/**
 * InstantDataId entity. @author MyEclipse Persistence Tools
 */

public class InstantDataId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 719211190121918337L;
	private String meterNumber;
	private Timestamp meterDateTime;

	// Constructors

	/** default constructor */
	public InstantDataId() {
	}

	/** full constructor */
	public InstantDataId(String meterNumber, Timestamp meterDateTime) {
		this.meterNumber = meterNumber;
		this.meterDateTime = meterDateTime;
	}

	// Property accessors

	public String getMeterNumber() {
		return this.meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public Timestamp getMeterDateTime() {
		return this.meterDateTime;
	}

	public void setMeterDateTime(Timestamp meterDateTime) {
		this.meterDateTime = meterDateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InstantDataId))
			return false;
		InstantDataId castOther = (InstantDataId) other;

		return ((this.getMeterNumber() == castOther.getMeterNumber()) || (this
				.getMeterNumber() != null && castOther.getMeterNumber() != null && this
				.getMeterNumber().equals(castOther.getMeterNumber())))
				&& ((this.getMeterDateTime() == castOther.getMeterDateTime()) || (this
						.getMeterDateTime() != null
						&& castOther.getMeterDateTime() != null && this
						.getMeterDateTime()
						.equals(castOther.getMeterDateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMeterNumber() == null ? 0 : this.getMeterNumber()
						.hashCode());
		result = 37
				* result
				+ (getMeterDateTime() == null ? 0 : this.getMeterDateTime()
						.hashCode());
		return result;
	}

}