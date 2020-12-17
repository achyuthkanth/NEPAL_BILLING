package com.analogics.vo;

/**
 * ConsumerMeterMasterId entity. @author MyEclipse Persistence Tools
 */

public class ConsumerMeterMasterId implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 8365932594505263916L;
	private String consumerId;
	private String meterNumber;

	// Constructors

	/** default constructor */
	public ConsumerMeterMasterId() {
	}

	/** full constructor */
	public ConsumerMeterMasterId(String consumerId, String meterNumber) {
		this.consumerId = consumerId;
		this.meterNumber = meterNumber;
	}

	// Property accessors

	public String getConsumerId() {
		return this.consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getMeterNumber() {
		return this.meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConsumerMeterMasterId))
			return false;
		ConsumerMeterMasterId castOther = (ConsumerMeterMasterId) other;

		return ((this.getConsumerId() == castOther.getConsumerId()) || (this
				.getConsumerId() != null && castOther.getConsumerId() != null && this
				.getConsumerId().equals(castOther.getConsumerId())))
				&& ((this.getMeterNumber() == castOther.getMeterNumber()) || (this
						.getMeterNumber() != null
						&& castOther.getMeterNumber() != null && this
						.getMeterNumber().equals(castOther.getMeterNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getConsumerId() == null ? 0 : this.getConsumerId()
						.hashCode());
		result = 37
				* result
				+ (getMeterNumber() == null ? 0 : this.getMeterNumber()
						.hashCode());
		return result;
	}

}