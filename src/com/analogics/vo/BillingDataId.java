package com.analogics.vo;

import java.sql.Timestamp;

/**
 * BillingDataId entity. @author MyEclipse Persistence Tools
 */

public class BillingDataId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8632014682992956310L;
	private String meterNumber;
	private Timestamp mdresetDateTime;

	// Constructors

	/** default constructor */
	public BillingDataId() {
	}

	/** full constructor */
	public BillingDataId(String meterNumber, Timestamp mdresetDateTime) {
		this.meterNumber = meterNumber;
		this.mdresetDateTime = mdresetDateTime;
	}

	// Property accessors

	public String getMeterNumber() {
		return this.meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public Timestamp getMdresetDateTime() {
		return this.mdresetDateTime;
	}

	public void setMdresetDateTime(Timestamp mdresetDateTime) {
		this.mdresetDateTime = mdresetDateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillingDataId))
			return false;
		BillingDataId castOther = (BillingDataId) other;

		return ((this.getMeterNumber() == castOther.getMeterNumber()) || (this
				.getMeterNumber() != null && castOther.getMeterNumber() != null && this
				.getMeterNumber().equals(castOther.getMeterNumber())))
				&& ((this.getMdresetDateTime() == castOther
						.getMdresetDateTime()) || (this.getMdresetDateTime() != null
						&& castOther.getMdresetDateTime() != null && this
						.getMdresetDateTime().equals(
								castOther.getMdresetDateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMeterNumber() == null ? 0 : this.getMeterNumber()
						.hashCode());
		result = 37
				* result
				+ (getMdresetDateTime() == null ? 0 : this.getMdresetDateTime()
						.hashCode());
		return result;
	}

}