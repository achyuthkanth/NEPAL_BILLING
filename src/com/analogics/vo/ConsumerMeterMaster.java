package com.analogics.vo;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ConsumerMeterMaster entity. @author MyEclipse Persistence Tools
 */

public class ConsumerMeterMaster extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 4952123967092437074L;
	private ConsumerMeterMasterId id;
	private String statusOfMeter;
	private String remarks1;
	private String remarks2;

	// Constructors

	/** default constructor */
	public ConsumerMeterMaster() {
	}

	/** minimal constructor */
	public ConsumerMeterMaster(ConsumerMeterMasterId id, String statusOfMeter) {
		this.id = id;
		this.statusOfMeter = statusOfMeter;
	}

	/** full constructor */
	public ConsumerMeterMaster(ConsumerMeterMasterId id, String statusOfMeter,
			String remarks1, String remarks2) {
		this.id = id;
		this.statusOfMeter = statusOfMeter;
		this.remarks1 = remarks1;
		this.remarks2 = remarks2;
	}

	// Property accessors

	public ConsumerMeterMasterId getId() {
		return this.id;
	}

	public void setId(ConsumerMeterMasterId id) {
		this.id = id;
	}

	public String getStatusOfMeter() {
		return this.statusOfMeter;
	}

	public void setStatusOfMeter(String statusOfMeter) {
		this.statusOfMeter = statusOfMeter;
	}

	public String getRemarks1() {
		return this.remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getRemarks2() {
		return this.remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

}