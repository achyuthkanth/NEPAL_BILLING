package com.analogics.vo;

/**
 * FieldInstallationMasterId entity. @author MyEclipse Persistence Tools
 */

public class FieldInstallationMasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 811946097202758194L;
	private String circleid;
	private String consumerNo;
	private String consumerid;

	// Constructors

	/** default constructor */
	public FieldInstallationMasterId() {
	}

	/** full constructor */
	public FieldInstallationMasterId(String circleid, String consumerNo,
			String consumerid) {
		this.circleid = circleid;
		this.consumerNo = consumerNo;
		this.consumerid = consumerid;
	}

	// Property accessors

	public String getCircleid() {
		return this.circleid;
	}

	public void setCircleid(String circleid) {
		this.circleid = circleid;
	}

	public String getConsumerNo() {
		return this.consumerNo;
	}

	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}

	public String getConsumerid() {
		return this.consumerid;
	}

	public void setConsumerid(String consumerid) {
		this.consumerid = consumerid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FieldInstallationMasterId))
			return false;
		FieldInstallationMasterId castOther = (FieldInstallationMasterId) other;

		return ((this.getCircleid() == castOther.getCircleid()) || (this
				.getCircleid() != null && castOther.getCircleid() != null && this
				.getCircleid().equals(castOther.getCircleid())))
				&& ((this.getConsumerNo() == castOther.getConsumerNo()) || (this
						.getConsumerNo() != null
						&& castOther.getConsumerNo() != null && this
						.getConsumerNo().equals(castOther.getConsumerNo())))
				&& ((this.getConsumerid() == castOther.getConsumerid()) || (this
						.getConsumerid() != null
						&& castOther.getConsumerid() != null && this
						.getConsumerid().equals(castOther.getConsumerid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCircleid() == null ? 0 : this.getCircleid().hashCode());
		result = 37
				* result
				+ (getConsumerNo() == null ? 0 : this.getConsumerNo()
						.hashCode());
		result = 37
				* result
				+ (getConsumerid() == null ? 0 : this.getConsumerid()
						.hashCode());
		return result;
	}

}