package com.analogics.um.vo;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ParamTable entity. @author MyEclipse Persistence Tools
 */

public class ParamTable extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1983834304242298873L;
	private ParamTableId id;
	private String paramValue;
	private String status;
	private Integer orderNo;

	// Constructors

	/** default constructor */
	public ParamTable() {
	}

	/** minimal constructor */
	public ParamTable(ParamTableId id) {
		this.id = id;
	}

	/** full constructor */
	public ParamTable(ParamTableId id, String paramValue, String status,
			Integer orderNo) {
		this.id = id;
		this.paramValue = paramValue;
		this.status = status;
		this.orderNo = orderNo;
	}

	// Property accessors

	public ParamTableId getId() {
		return this.id;
	}

	public void setId(ParamTableId id) {
		this.id = id;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}