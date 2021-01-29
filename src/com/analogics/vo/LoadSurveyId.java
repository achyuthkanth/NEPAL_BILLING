package com.analogics.vo;

import java.sql.Timestamp;

/**
 * LoadSurveyId entity. @author MyEclipse Persistence Tools
 */

public class LoadSurveyId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String meterNumber;
	private Timestamp intervalDateTime;

	// Constructors

	/** default constructor */
	public LoadSurveyId() {
	}

	/** full constructor */
	public LoadSurveyId(String meterNumber, Timestamp intervalDateTime) {
		this.meterNumber = meterNumber;
		this.intervalDateTime = intervalDateTime;
	}

	// Property accessors

	public String getMeterNumber() {
		return this.meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public Timestamp getIntervalDateTime() {
		return this.intervalDateTime;
	}

	public void setIntervalDateTime(Timestamp intervalDateTime) {
		this.intervalDateTime = intervalDateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoadSurveyId))
			return false;
		LoadSurveyId castOther = (LoadSurveyId) other;

		return ((this.getMeterNumber() == castOther.getMeterNumber()) || (this
				.getMeterNumber() != null && castOther.getMeterNumber() != null && this
				.getMeterNumber().equals(castOther.getMeterNumber())))
				&& ((this.getIntervalDateTime() == castOther
						.getIntervalDateTime()) || (this.getIntervalDateTime() != null
						&& castOther.getIntervalDateTime() != null && this
						.getIntervalDateTime().equals(
								castOther.getIntervalDateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMeterNumber() == null ? 0 : this.getMeterNumber()
						.hashCode());
		result = 37
				* result
				+ (getIntervalDateTime() == null ? 0 : this
						.getIntervalDateTime().hashCode());
		return result;
	}

}