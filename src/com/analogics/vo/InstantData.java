package com.analogics.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.analogics.utils.ExtraFieldspojo;

/**
 * InstantData entity. @author MyEclipse Persistence Tools
 */

public class InstantData extends ExtraFieldspojo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -4749596990798077323L;
	private InstantDataId id;
	private Date meterDate;
	private Time meterTime;
	private String nodeNumber;
	private Timestamp nodeDateTime;
	private Date nodeDate;
	private Time nodeTime;
	private Timestamp gsmDateTime;
	private String sequenceNumber;
	private String voltageRPhase;
	private String voltageBPhase;
	private String voltageYPhase;
	private String currentRPhase;
	private String currentBPhase;
	private String currentYPhase;
	private String frequency;
	private String apparentPower;
	private String activePower;
	private String reactivePower;
	private String apparentEnergyImp;
	private String activeEnergyImp;
	private String reactiveEnergyLagImp;
	private String reactiveEnergyLeadImp;
	private String apparentEnergyExp;
	private String activeEnergyExp;
	private String reactiveEnergyLagExp;
	private String reactiveEnergyLeadExp;
	private String rphasepf;
	private String yphasepf;
	private String bphasepf;
	private String averagePf;
	private String signalStrength;
	private String batteryStatus;
	private Timestamp insertedDate;
	
	//Required Fields
	private MeterMaster meterMasterObj;

	// Constructors

	/** default constructor */
	public InstantData() {
	}

	/** minimal constructor */
	public InstantData(InstantDataId id, Date meterDate,
			Timestamp nodeDateTime, Date nodeDate) {
		this.id = id;
		this.meterDate = meterDate;
		this.nodeDateTime = nodeDateTime;
		this.nodeDate = nodeDate;
	}

	/** full constructor */
	public InstantData(InstantDataId id, Date meterDate, Time meterTime,
			String nodeNumber, Timestamp nodeDateTime, Date nodeDate,
			Time nodeTime, Timestamp gsmDateTime, String sequenceNumber,
			String voltageRPhase, String voltageBPhase, String voltageYPhase,
			String currentRPhase, String currentBPhase, String currentYPhase,
			String frequency, String apparentPower, String activePower,
			String reactivePower, String apparentEnergyImp,
			String activeEnergyImp, String reactiveEnergyLagImp,
			String reactiveEnergyLeadImp, String apparentEnergyExp,
			String activeEnergyExp, String reactiveEnergyLagExp,
			String reactiveEnergyLeadExp, String rphasepf, String yphasepf,
			String bphasepf, String averagePf, String signalStrength,
			String batteryStatus, Timestamp insertedDate) {
		this.id = id;
		this.meterDate = meterDate;
		this.meterTime = meterTime;
		this.nodeNumber = nodeNumber;
		this.nodeDateTime = nodeDateTime;
		this.nodeDate = nodeDate;
		this.nodeTime = nodeTime;
		this.gsmDateTime = gsmDateTime;
		this.sequenceNumber = sequenceNumber;
		this.voltageRPhase = voltageRPhase;
		this.voltageBPhase = voltageBPhase;
		this.voltageYPhase = voltageYPhase;
		this.currentRPhase = currentRPhase;
		this.currentBPhase = currentBPhase;
		this.currentYPhase = currentYPhase;
		this.frequency = frequency;
		this.apparentPower = apparentPower;
		this.activePower = activePower;
		this.reactivePower = reactivePower;
		this.apparentEnergyImp = apparentEnergyImp;
		this.activeEnergyImp = activeEnergyImp;
		this.reactiveEnergyLagImp = reactiveEnergyLagImp;
		this.reactiveEnergyLeadImp = reactiveEnergyLeadImp;
		this.apparentEnergyExp = apparentEnergyExp;
		this.activeEnergyExp = activeEnergyExp;
		this.reactiveEnergyLagExp = reactiveEnergyLagExp;
		this.reactiveEnergyLeadExp = reactiveEnergyLeadExp;
		this.rphasepf = rphasepf;
		this.yphasepf = yphasepf;
		this.bphasepf = bphasepf;
		this.averagePf = averagePf;
		this.signalStrength = signalStrength;
		this.batteryStatus = batteryStatus;
		this.insertedDate = insertedDate;
	}

	// Property accessors

	public InstantDataId getId() {
		return this.id;
	}

	public void setId(InstantDataId id) {
		this.id = id;
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

	public Timestamp getGsmDateTime() {
		return this.gsmDateTime;
	}

	public void setGsmDateTime(Timestamp gsmDateTime) {
		this.gsmDateTime = gsmDateTime;
	}

	public String getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getVoltageRPhase() {
		return this.voltageRPhase;
	}

	public void setVoltageRPhase(String voltageRPhase) {
		this.voltageRPhase = voltageRPhase;
	}

	public String getVoltageBPhase() {
		return this.voltageBPhase;
	}

	public void setVoltageBPhase(String voltageBPhase) {
		this.voltageBPhase = voltageBPhase;
	}

	public String getVoltageYPhase() {
		return this.voltageYPhase;
	}

	public void setVoltageYPhase(String voltageYPhase) {
		this.voltageYPhase = voltageYPhase;
	}

	public String getCurrentRPhase() {
		return this.currentRPhase;
	}

	public void setCurrentRPhase(String currentRPhase) {
		this.currentRPhase = currentRPhase;
	}

	public String getCurrentBPhase() {
		return this.currentBPhase;
	}

	public void setCurrentBPhase(String currentBPhase) {
		this.currentBPhase = currentBPhase;
	}

	public String getCurrentYPhase() {
		return this.currentYPhase;
	}

	public void setCurrentYPhase(String currentYPhase) {
		this.currentYPhase = currentYPhase;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getApparentPower() {
		return this.apparentPower;
	}

	public void setApparentPower(String apparentPower) {
		this.apparentPower = apparentPower;
	}

	public String getActivePower() {
		return this.activePower;
	}

	public void setActivePower(String activePower) {
		this.activePower = activePower;
	}

	public String getReactivePower() {
		return this.reactivePower;
	}

	public void setReactivePower(String reactivePower) {
		this.reactivePower = reactivePower;
	}

	public String getApparentEnergyImp() {
		return this.apparentEnergyImp;
	}

	public void setApparentEnergyImp(String apparentEnergyImp) {
		this.apparentEnergyImp = apparentEnergyImp;
	}

	public String getActiveEnergyImp() {
		return this.activeEnergyImp;
	}

	public void setActiveEnergyImp(String activeEnergyImp) {
		this.activeEnergyImp = activeEnergyImp;
	}

	public String getReactiveEnergyLagImp() {
		return this.reactiveEnergyLagImp;
	}

	public void setReactiveEnergyLagImp(String reactiveEnergyLagImp) {
		this.reactiveEnergyLagImp = reactiveEnergyLagImp;
	}

	public String getReactiveEnergyLeadImp() {
		return this.reactiveEnergyLeadImp;
	}

	public void setReactiveEnergyLeadImp(String reactiveEnergyLeadImp) {
		this.reactiveEnergyLeadImp = reactiveEnergyLeadImp;
	}

	public String getApparentEnergyExp() {
		return this.apparentEnergyExp;
	}

	public void setApparentEnergyExp(String apparentEnergyExp) {
		this.apparentEnergyExp = apparentEnergyExp;
	}

	public String getActiveEnergyExp() {
		return this.activeEnergyExp;
	}

	public void setActiveEnergyExp(String activeEnergyExp) {
		this.activeEnergyExp = activeEnergyExp;
	}

	public String getReactiveEnergyLagExp() {
		return this.reactiveEnergyLagExp;
	}

	public void setReactiveEnergyLagExp(String reactiveEnergyLagExp) {
		this.reactiveEnergyLagExp = reactiveEnergyLagExp;
	}

	public String getReactiveEnergyLeadExp() {
		return this.reactiveEnergyLeadExp;
	}

	public void setReactiveEnergyLeadExp(String reactiveEnergyLeadExp) {
		this.reactiveEnergyLeadExp = reactiveEnergyLeadExp;
	}

	public String getRphasepf() {
		return this.rphasepf;
	}

	public void setRphasepf(String rphasepf) {
		this.rphasepf = rphasepf;
	}

	public String getYphasepf() {
		return this.yphasepf;
	}

	public void setYphasepf(String yphasepf) {
		this.yphasepf = yphasepf;
	}

	public String getBphasepf() {
		return this.bphasepf;
	}

	public void setBphasepf(String bphasepf) {
		this.bphasepf = bphasepf;
	}

	public String getAveragePf() {
		return this.averagePf;
	}

	public void setAveragePf(String averagePf) {
		this.averagePf = averagePf;
	}

	public String getSignalStrength() {
		return this.signalStrength;
	}

	public void setSignalStrength(String signalStrength) {
		this.signalStrength = signalStrength;
	}

	public String getBatteryStatus() {
		return this.batteryStatus;
	}

	public void setBatteryStatus(String batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	public Timestamp getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Timestamp insertedDate) {
		this.insertedDate = insertedDate;
	}

	public MeterMaster getMeterMasterObj() {
		return meterMasterObj;
	}

	public void setMeterMasterObj(MeterMaster meterMasterObj) {
		this.meterMasterObj = meterMasterObj;
	}

}