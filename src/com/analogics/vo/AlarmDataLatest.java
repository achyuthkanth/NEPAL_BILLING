package com.analogics.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.analogics.um.vo.HierarchyLevelsVo;

/**
 * AlarmDataLatest entity. @author MyEclipse Persistence Tools
 */

public class AlarmDataLatest extends HierarchyLevelsVo implements java.io.Serializable {

	// Fields

	private String nodeNumber;
	private Timestamp nodeDateTime;
	private Date nodeDate;
	private Time nodeTime;
	private String meterNumber;
	private Timestamp meterDateTime;
	private Date meterDate;
	private Time meterTime;
	private Timestamp alarmDate;
	private Timestamp insertedDate;
	private String alarmCode;
	private String alarmDescription;
	private String sequenceNumber;

	// Constructors

	/** default constructor */
	public AlarmDataLatest() {
	}

	/** minimal constructor */
	public AlarmDataLatest(String nodeNumber, Timestamp nodeDateTime,
			Date nodeDate, String meterNumber, Timestamp meterDateTime,
			Date meterDate, Timestamp alarmDate) {
		this.nodeNumber = nodeNumber;
		this.nodeDateTime = nodeDateTime;
		this.nodeDate = nodeDate;
		this.meterNumber = meterNumber;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
		this.alarmDate = alarmDate;
	}

	/** full constructor */
	public AlarmDataLatest(String nodeNumber, Timestamp nodeDateTime,
			Date nodeDate, Time nodeTime, String meterNumber,
			Timestamp meterDateTime, Date meterDate, Time meterTime,
			Timestamp alarmDate, Timestamp insertedDate, String alarmCode,
			String alarmDescription, String sequenceNumber) {
		this.nodeNumber = nodeNumber;
		this.nodeDateTime = nodeDateTime;
		this.nodeDate = nodeDate;
		this.nodeTime = nodeTime;
		this.meterNumber = meterNumber;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
		this.meterTime = meterTime;
		this.alarmDate = alarmDate;
		this.insertedDate = insertedDate;
		this.alarmCode = alarmCode;
		this.alarmDescription = alarmDescription;
		this.sequenceNumber = sequenceNumber;
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

	public Date getNodeDate() {
		return this.nodeDate;
	}

	public void setNodeDate(Date nodeDate) {
		this.nodeDate = nodeDate;
	}

	public Time getNodeTime() {
		return this.nodeTime;
	}

	public void setNodeTime(Time nodeTime) {
		this.nodeTime = nodeTime;
	}

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

	public Date getMeterDate() {
		return this.meterDate;
	}

	public void setMeterDate(Date meterDate) {
		this.meterDate = meterDate;
	}

	public Time getMeterTime() {
		return this.meterTime;
	}

	public void setMeterTime(Time meterTime) {
		this.meterTime = meterTime;
	}

	public Timestamp getAlarmDate() {
		return this.alarmDate;
	}

	public void setAlarmDate(Timestamp alarmDate) {
		this.alarmDate = alarmDate;
	}

	public Timestamp getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Timestamp insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getAlarmCode() {
		return this.alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public String getAlarmDescription() {
		return this.alarmDescription;
	}

	public void setAlarmDescription(String alarmDescription) {
		this.alarmDescription = alarmDescription;
	}

	public String getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}