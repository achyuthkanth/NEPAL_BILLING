package com.analogics.vo;

import java.sql.Timestamp;

/**
 * DailySnapshotId entity. @author MyEclipse Persistence Tools
 */

public class DailySnapshotId implements java.io.Serializable {

	// Fields

	private String meterNumber;
	private Timestamp snapshotDateTime;

	// Constructors

	/** default constructor */
	public DailySnapshotId() {
	}

	/** full constructor */
	public DailySnapshotId(String meterNumber, Timestamp snapshotDateTime) {
		this.meterNumber = meterNumber;
		this.snapshotDateTime = snapshotDateTime;
	}

	// Property accessors

	public String getMeterNumber() {
		return this.meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public Timestamp getSnapshotDateTime() {
		return this.snapshotDateTime;
	}

	public void setSnapshotDateTime(Timestamp snapshotDateTime) {
		this.snapshotDateTime = snapshotDateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DailySnapshotId))
			return false;
		DailySnapshotId castOther = (DailySnapshotId) other;

		return ((this.getMeterNumber() == castOther.getMeterNumber()) || (this
				.getMeterNumber() != null && castOther.getMeterNumber() != null && this
				.getMeterNumber().equals(castOther.getMeterNumber())))
				&& ((this.getSnapshotDateTime() == castOther
						.getSnapshotDateTime()) || (this.getSnapshotDateTime() != null
						&& castOther.getSnapshotDateTime() != null && this
						.getSnapshotDateTime().equals(
								castOther.getSnapshotDateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMeterNumber() == null ? 0 : this.getMeterNumber()
						.hashCode());
		result = 37
				* result
				+ (getSnapshotDateTime() == null ? 0 : this
						.getSnapshotDateTime().hashCode());
		return result;
	}

}