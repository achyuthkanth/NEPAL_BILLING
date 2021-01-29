package com.analogics.vo;

import java.sql.Time;
import java.util.Date;

import com.analogics.um.vo.HierarchyLevelsVo;

/**
 * InstantData entity. @author MyEclipse Persistence Tools
 */

public class InstantData extends HierarchyLevelsVo implements java.io.Serializable {

	private static final long serialVersionUID = 3168997208617909772L;
	// Fields

	private InstantDataId id;
	private Date meterDate;
	private Time meterTime;
	private Long intervalNo;
	private String activeEnergy;
	private String activeEnergyImport;
	private String activeEnergyImportL1;
	private String activeEnergyImportL2;
	private String activeEnergyImportL3;
	private String activeEnergyImportT1;
	private String activeEnergyImportT2;
	private String activeEnergyImportT3;
	private String activeEnergyImportT4;
	private String activeEnergyImportT5;
	private String activeEnergyImportT6;
	private String activeEnergyImportT7;
	private String activeEnergyImportT8;
	private String activeEnergyExport;
	private String activeEnergyExportL1;
	private String activeEnergyExportL2;
	private String activeEnergyExportL3;
	private String activeEnergyExportT1;
	private String activeEnergyExportT2;
	private String activeEnergyExportT3;
	private String activeEnergyExportT4;
	private String activeEnergyExportT5;
	private String activeEnergyExportT6;
	private String activeEnergyExportT7;
	private String activeEnergyExportT8;
	private String activeEnergyCombinedTotal;
	private String activeEnergyCombinedTotalT1;
	private String activeEnergyCombinedTotalT2;
	private String activeEnergyCombinedTotalT3;
	private String activeEnergyCombinedTotalT4;
	private String activeEnergyCombinedTotalT5;
	private String activeEnergyCombinedTotalT6;
	private String activeEnergyCombinedTotalT7;
	private String activeEnergyCombinedTotalT8;
	private String activeEnergyNetTotal;
	private String activeEnergyNetTotalT1;
	private String activeEnergyNetTotalT2;
	private String activeEnergyNetTotalT3;
	private String activeEnergyNetTotalT4;
	private String activeEnergyNetTotalT5;
	private String activeEnergyNetTotalT6;
	private String activeEnergyNetTotalT7;
	private String activeEnergyNetTotalT8;
	private String reactiveEnergy;
	private String reactiveEnergyImport;
	private String reactiveEnergyExport;
	private String reactiveEnergyQ1;
	private String reactiveEnergyQ2;
	private String reactiveEnergyQ3;
	private String reactiveEnergyQ4;
	private String apparentEnergy;
	private String apparentEnergyImport;
	private String apparentEnergyImportT1;
	private String apparentEnergyImportT2;
	private String apparentEnergyImportT3;
	private String apparentEnergyImportT4;
	private String apparentEnergyImportT5;
	private String apparentEnergyImportT6;
	private String apparentEnergyImportT7;
	private String apparentEnergyImportT8;
	private String apparentEnergyExport;
	private String apparentEnergyExportT1;
	private String apparentEnergyExportT2;
	private String apparentEnergyExportT3;
	private String apparentEnergyExportT4;
	private String apparentEnergyExportT5;
	private String apparentEnergyExportT6;
	private String apparentEnergyExportT7;
	private String apparentEnergyExportT8;
	private String activePowerImport;
	private String activePowerImportL1;
	private String activePowerImportL2;
	private String activePowerImportL3;
	private String activePowerExport;
	private String activePowerExportL1;
	private String activePowerExportL2;
	private String activePowerExportL3;
	private String reactivePower;
	private String reactivePowerImport;
	private String reactivePowerImportL1;
	private String reactivePowerImportL2;
	private String reactivePowerImportL3;
	private String reactivePowerExport;
	private String reactivePowerExportL1;
	private String reactivePowerExportL2;
	private String reactivePowerExportL3;
	private String apparentPower;
	private String apparentPowerImport;
	private String apparentPowerImportL1;
	private String apparentPowerImportL2;
	private String apparentPowerImportL3;
	private String apparentPowerExport;
	private String apparentPowerExportL1;
	private String apparentPowerExportL2;
	private String apparentPowerExportL3;
	private String powerFactor;
	private String powerFactorL1;
	private String powerFactorL2;
	private String powerFactorL3;
	private String phaseAngle;
	private String phaseAngleL1;
	private String phaseAngleL2;
	private String phaseAngleL3;
	private String voltage;
	private String voltageL1;
	private String voltageL2;
	private String voltageL3;
	private String current;
	private String currentL1;
	private String currentL2;
	private String currentL3;
	private String ampereHoursInAbsenceOfVoltageL1;
	private String ampereHoursInAbsenceOfVoltageL2;
	private String ampereHoursInAbsenceOfVoltageL3;
	private String activeDemand;
	private String activeDemandImport;
	private String activeDemandImportOccTime;
	private String activeDemandExport;
	private String activeDemandExportOccTime;
	private String apparentDemand;
	private String apparentDemandImport;
	private String apparentDemandImportOccTime;
	private String apparentDemandExport;
	private String apparentDemandExportOccTime;
	
	// Required Fields
	private MeterMaster meterMasterObj;

	// Constructors

	/** default constructor */
	public InstantData() {
	}

	/** minimal constructor */
	public InstantData(InstantDataId id, Date meterDate) {
		this.id = id;
		this.meterDate = meterDate;
	}

	/** full constructor */
	public InstantData(InstantDataId id, Date meterDate, Time meterTime,
			Long intervalNo, String activeEnergy, String activeEnergyImport,
			String activeEnergyImportL1, String activeEnergyImportL2,
			String activeEnergyImportL3, String activeEnergyImportT1,
			String activeEnergyImportT2, String activeEnergyImportT3,
			String activeEnergyImportT4, String activeEnergyImportT5,
			String activeEnergyImportT6, String activeEnergyImportT7,
			String activeEnergyImportT8, String activeEnergyExport,
			String activeEnergyExportL1, String activeEnergyExportL2,
			String activeEnergyExportL3, String activeEnergyExportT1,
			String activeEnergyExportT2, String activeEnergyExportT3,
			String activeEnergyExportT4, String activeEnergyExportT5,
			String activeEnergyExportT6, String activeEnergyExportT7,
			String activeEnergyExportT8, String activeEnergyCombinedTotal,
			String activeEnergyCombinedTotalT1,
			String activeEnergyCombinedTotalT2,
			String activeEnergyCombinedTotalT3,
			String activeEnergyCombinedTotalT4,
			String activeEnergyCombinedTotalT5,
			String activeEnergyCombinedTotalT6,
			String activeEnergyCombinedTotalT7,
			String activeEnergyCombinedTotalT8, String activeEnergyNetTotal,
			String activeEnergyNetTotalT1, String activeEnergyNetTotalT2,
			String activeEnergyNetTotalT3, String activeEnergyNetTotalT4,
			String activeEnergyNetTotalT5, String activeEnergyNetTotalT6,
			String activeEnergyNetTotalT7, String activeEnergyNetTotalT8,
			String reactiveEnergy, String reactiveEnergyImport,
			String reactiveEnergyExport, String reactiveEnergyQ1,
			String reactiveEnergyQ2, String reactiveEnergyQ3,
			String reactiveEnergyQ4, String apparentEnergy,
			String apparentEnergyImport, String apparentEnergyImportT1,
			String apparentEnergyImportT2, String apparentEnergyImportT3,
			String apparentEnergyImportT4, String apparentEnergyImportT5,
			String apparentEnergyImportT6, String apparentEnergyImportT7,
			String apparentEnergyImportT8, String apparentEnergyExport,
			String apparentEnergyExportT1, String apparentEnergyExportT2,
			String apparentEnergyExportT3, String apparentEnergyExportT4,
			String apparentEnergyExportT5, String apparentEnergyExportT6,
			String apparentEnergyExportT7, String apparentEnergyExportT8,
			String activePowerImport, String activePowerImportL1,
			String activePowerImportL2, String activePowerImportL3,
			String activePowerExport, String activePowerExportL1,
			String activePowerExportL2, String activePowerExportL3,
			String reactivePower, String reactivePowerImport,
			String reactivePowerImportL1, String reactivePowerImportL2,
			String reactivePowerImportL3, String reactivePowerExport,
			String reactivePowerExportL1, String reactivePowerExportL2,
			String reactivePowerExportL3, String apparentPower,
			String apparentPowerImport, String apparentPowerImportL1,
			String apparentPowerImportL2, String apparentPowerImportL3,
			String apparentPowerExport, String apparentPowerExportL1,
			String apparentPowerExportL2, String apparentPowerExportL3,
			String powerFactor, String powerFactorL1, String powerFactorL2,
			String powerFactorL3, String phaseAngle, String phaseAngleL1,
			String phaseAngleL2, String phaseAngleL3, String voltage,
			String voltageL1, String voltageL2, String voltageL3,
			String current, String currentL1, String currentL2,
			String currentL3, String ampereHoursInAbsenceOfVoltageL1,
			String ampereHoursInAbsenceOfVoltageL2,
			String ampereHoursInAbsenceOfVoltageL3, String activeDemand,
			String activeDemandImport, String activeDemandImportOccTime,
			String activeDemandExport, String activeDemandExportOccTime,
			String apparentDemand, String apparentDemandImport,
			String apparentDemandImportOccTime, String apparentDemandExport,
			String apparentDemandExportOccTime) {
		this.id = id;
		this.meterDate = meterDate;
		this.meterTime = meterTime;
		this.intervalNo = intervalNo;
		this.activeEnergy = activeEnergy;
		this.activeEnergyImport = activeEnergyImport;
		this.activeEnergyImportL1 = activeEnergyImportL1;
		this.activeEnergyImportL2 = activeEnergyImportL2;
		this.activeEnergyImportL3 = activeEnergyImportL3;
		this.activeEnergyImportT1 = activeEnergyImportT1;
		this.activeEnergyImportT2 = activeEnergyImportT2;
		this.activeEnergyImportT3 = activeEnergyImportT3;
		this.activeEnergyImportT4 = activeEnergyImportT4;
		this.activeEnergyImportT5 = activeEnergyImportT5;
		this.activeEnergyImportT6 = activeEnergyImportT6;
		this.activeEnergyImportT7 = activeEnergyImportT7;
		this.activeEnergyImportT8 = activeEnergyImportT8;
		this.activeEnergyExport = activeEnergyExport;
		this.activeEnergyExportL1 = activeEnergyExportL1;
		this.activeEnergyExportL2 = activeEnergyExportL2;
		this.activeEnergyExportL3 = activeEnergyExportL3;
		this.activeEnergyExportT1 = activeEnergyExportT1;
		this.activeEnergyExportT2 = activeEnergyExportT2;
		this.activeEnergyExportT3 = activeEnergyExportT3;
		this.activeEnergyExportT4 = activeEnergyExportT4;
		this.activeEnergyExportT5 = activeEnergyExportT5;
		this.activeEnergyExportT6 = activeEnergyExportT6;
		this.activeEnergyExportT7 = activeEnergyExportT7;
		this.activeEnergyExportT8 = activeEnergyExportT8;
		this.activeEnergyCombinedTotal = activeEnergyCombinedTotal;
		this.activeEnergyCombinedTotalT1 = activeEnergyCombinedTotalT1;
		this.activeEnergyCombinedTotalT2 = activeEnergyCombinedTotalT2;
		this.activeEnergyCombinedTotalT3 = activeEnergyCombinedTotalT3;
		this.activeEnergyCombinedTotalT4 = activeEnergyCombinedTotalT4;
		this.activeEnergyCombinedTotalT5 = activeEnergyCombinedTotalT5;
		this.activeEnergyCombinedTotalT6 = activeEnergyCombinedTotalT6;
		this.activeEnergyCombinedTotalT7 = activeEnergyCombinedTotalT7;
		this.activeEnergyCombinedTotalT8 = activeEnergyCombinedTotalT8;
		this.activeEnergyNetTotal = activeEnergyNetTotal;
		this.activeEnergyNetTotalT1 = activeEnergyNetTotalT1;
		this.activeEnergyNetTotalT2 = activeEnergyNetTotalT2;
		this.activeEnergyNetTotalT3 = activeEnergyNetTotalT3;
		this.activeEnergyNetTotalT4 = activeEnergyNetTotalT4;
		this.activeEnergyNetTotalT5 = activeEnergyNetTotalT5;
		this.activeEnergyNetTotalT6 = activeEnergyNetTotalT6;
		this.activeEnergyNetTotalT7 = activeEnergyNetTotalT7;
		this.activeEnergyNetTotalT8 = activeEnergyNetTotalT8;
		this.reactiveEnergy = reactiveEnergy;
		this.reactiveEnergyImport = reactiveEnergyImport;
		this.reactiveEnergyExport = reactiveEnergyExport;
		this.reactiveEnergyQ1 = reactiveEnergyQ1;
		this.reactiveEnergyQ2 = reactiveEnergyQ2;
		this.reactiveEnergyQ3 = reactiveEnergyQ3;
		this.reactiveEnergyQ4 = reactiveEnergyQ4;
		this.apparentEnergy = apparentEnergy;
		this.apparentEnergyImport = apparentEnergyImport;
		this.apparentEnergyImportT1 = apparentEnergyImportT1;
		this.apparentEnergyImportT2 = apparentEnergyImportT2;
		this.apparentEnergyImportT3 = apparentEnergyImportT3;
		this.apparentEnergyImportT4 = apparentEnergyImportT4;
		this.apparentEnergyImportT5 = apparentEnergyImportT5;
		this.apparentEnergyImportT6 = apparentEnergyImportT6;
		this.apparentEnergyImportT7 = apparentEnergyImportT7;
		this.apparentEnergyImportT8 = apparentEnergyImportT8;
		this.apparentEnergyExport = apparentEnergyExport;
		this.apparentEnergyExportT1 = apparentEnergyExportT1;
		this.apparentEnergyExportT2 = apparentEnergyExportT2;
		this.apparentEnergyExportT3 = apparentEnergyExportT3;
		this.apparentEnergyExportT4 = apparentEnergyExportT4;
		this.apparentEnergyExportT5 = apparentEnergyExportT5;
		this.apparentEnergyExportT6 = apparentEnergyExportT6;
		this.apparentEnergyExportT7 = apparentEnergyExportT7;
		this.apparentEnergyExportT8 = apparentEnergyExportT8;
		this.activePowerImport = activePowerImport;
		this.activePowerImportL1 = activePowerImportL1;
		this.activePowerImportL2 = activePowerImportL2;
		this.activePowerImportL3 = activePowerImportL3;
		this.activePowerExport = activePowerExport;
		this.activePowerExportL1 = activePowerExportL1;
		this.activePowerExportL2 = activePowerExportL2;
		this.activePowerExportL3 = activePowerExportL3;
		this.reactivePower = reactivePower;
		this.reactivePowerImport = reactivePowerImport;
		this.reactivePowerImportL1 = reactivePowerImportL1;
		this.reactivePowerImportL2 = reactivePowerImportL2;
		this.reactivePowerImportL3 = reactivePowerImportL3;
		this.reactivePowerExport = reactivePowerExport;
		this.reactivePowerExportL1 = reactivePowerExportL1;
		this.reactivePowerExportL2 = reactivePowerExportL2;
		this.reactivePowerExportL3 = reactivePowerExportL3;
		this.apparentPower = apparentPower;
		this.apparentPowerImport = apparentPowerImport;
		this.apparentPowerImportL1 = apparentPowerImportL1;
		this.apparentPowerImportL2 = apparentPowerImportL2;
		this.apparentPowerImportL3 = apparentPowerImportL3;
		this.apparentPowerExport = apparentPowerExport;
		this.apparentPowerExportL1 = apparentPowerExportL1;
		this.apparentPowerExportL2 = apparentPowerExportL2;
		this.apparentPowerExportL3 = apparentPowerExportL3;
		this.powerFactor = powerFactor;
		this.powerFactorL1 = powerFactorL1;
		this.powerFactorL2 = powerFactorL2;
		this.powerFactorL3 = powerFactorL3;
		this.phaseAngle = phaseAngle;
		this.phaseAngleL1 = phaseAngleL1;
		this.phaseAngleL2 = phaseAngleL2;
		this.phaseAngleL3 = phaseAngleL3;
		this.voltage = voltage;
		this.voltageL1 = voltageL1;
		this.voltageL2 = voltageL2;
		this.voltageL3 = voltageL3;
		this.current = current;
		this.currentL1 = currentL1;
		this.currentL2 = currentL2;
		this.currentL3 = currentL3;
		this.ampereHoursInAbsenceOfVoltageL1 = ampereHoursInAbsenceOfVoltageL1;
		this.ampereHoursInAbsenceOfVoltageL2 = ampereHoursInAbsenceOfVoltageL2;
		this.ampereHoursInAbsenceOfVoltageL3 = ampereHoursInAbsenceOfVoltageL3;
		this.activeDemand = activeDemand;
		this.activeDemandImport = activeDemandImport;
		this.activeDemandImportOccTime = activeDemandImportOccTime;
		this.activeDemandExport = activeDemandExport;
		this.activeDemandExportOccTime = activeDemandExportOccTime;
		this.apparentDemand = apparentDemand;
		this.apparentDemandImport = apparentDemandImport;
		this.apparentDemandImportOccTime = apparentDemandImportOccTime;
		this.apparentDemandExport = apparentDemandExport;
		this.apparentDemandExportOccTime = apparentDemandExportOccTime;
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

	public Long getIntervalNo() {
		return this.intervalNo;
	}

	public void setIntervalNo(Long intervalNo) {
		this.intervalNo = intervalNo;
	}

	public String getActiveEnergy() {
		return this.activeEnergy;
	}

	public void setActiveEnergy(String activeEnergy) {
		this.activeEnergy = activeEnergy;
	}

	public String getActiveEnergyImport() {
		return this.activeEnergyImport;
	}

	public void setActiveEnergyImport(String activeEnergyImport) {
		this.activeEnergyImport = activeEnergyImport;
	}

	public String getActiveEnergyImportL1() {
		return this.activeEnergyImportL1;
	}

	public void setActiveEnergyImportL1(String activeEnergyImportL1) {
		this.activeEnergyImportL1 = activeEnergyImportL1;
	}

	public String getActiveEnergyImportL2() {
		return this.activeEnergyImportL2;
	}

	public void setActiveEnergyImportL2(String activeEnergyImportL2) {
		this.activeEnergyImportL2 = activeEnergyImportL2;
	}

	public String getActiveEnergyImportL3() {
		return this.activeEnergyImportL3;
	}

	public void setActiveEnergyImportL3(String activeEnergyImportL3) {
		this.activeEnergyImportL3 = activeEnergyImportL3;
	}

	public String getActiveEnergyImportT1() {
		return this.activeEnergyImportT1;
	}

	public void setActiveEnergyImportT1(String activeEnergyImportT1) {
		this.activeEnergyImportT1 = activeEnergyImportT1;
	}

	public String getActiveEnergyImportT2() {
		return this.activeEnergyImportT2;
	}

	public void setActiveEnergyImportT2(String activeEnergyImportT2) {
		this.activeEnergyImportT2 = activeEnergyImportT2;
	}

	public String getActiveEnergyImportT3() {
		return this.activeEnergyImportT3;
	}

	public void setActiveEnergyImportT3(String activeEnergyImportT3) {
		this.activeEnergyImportT3 = activeEnergyImportT3;
	}

	public String getActiveEnergyImportT4() {
		return this.activeEnergyImportT4;
	}

	public void setActiveEnergyImportT4(String activeEnergyImportT4) {
		this.activeEnergyImportT4 = activeEnergyImportT4;
	}

	public String getActiveEnergyImportT5() {
		return this.activeEnergyImportT5;
	}

	public void setActiveEnergyImportT5(String activeEnergyImportT5) {
		this.activeEnergyImportT5 = activeEnergyImportT5;
	}

	public String getActiveEnergyImportT6() {
		return this.activeEnergyImportT6;
	}

	public void setActiveEnergyImportT6(String activeEnergyImportT6) {
		this.activeEnergyImportT6 = activeEnergyImportT6;
	}

	public String getActiveEnergyImportT7() {
		return this.activeEnergyImportT7;
	}

	public void setActiveEnergyImportT7(String activeEnergyImportT7) {
		this.activeEnergyImportT7 = activeEnergyImportT7;
	}

	public String getActiveEnergyImportT8() {
		return this.activeEnergyImportT8;
	}

	public void setActiveEnergyImportT8(String activeEnergyImportT8) {
		this.activeEnergyImportT8 = activeEnergyImportT8;
	}

	public String getActiveEnergyExport() {
		return this.activeEnergyExport;
	}

	public void setActiveEnergyExport(String activeEnergyExport) {
		this.activeEnergyExport = activeEnergyExport;
	}

	public String getActiveEnergyExportL1() {
		return this.activeEnergyExportL1;
	}

	public void setActiveEnergyExportL1(String activeEnergyExportL1) {
		this.activeEnergyExportL1 = activeEnergyExportL1;
	}

	public String getActiveEnergyExportL2() {
		return this.activeEnergyExportL2;
	}

	public void setActiveEnergyExportL2(String activeEnergyExportL2) {
		this.activeEnergyExportL2 = activeEnergyExportL2;
	}

	public String getActiveEnergyExportL3() {
		return this.activeEnergyExportL3;
	}

	public void setActiveEnergyExportL3(String activeEnergyExportL3) {
		this.activeEnergyExportL3 = activeEnergyExportL3;
	}

	public String getActiveEnergyExportT1() {
		return this.activeEnergyExportT1;
	}

	public void setActiveEnergyExportT1(String activeEnergyExportT1) {
		this.activeEnergyExportT1 = activeEnergyExportT1;
	}

	public String getActiveEnergyExportT2() {
		return this.activeEnergyExportT2;
	}

	public void setActiveEnergyExportT2(String activeEnergyExportT2) {
		this.activeEnergyExportT2 = activeEnergyExportT2;
	}

	public String getActiveEnergyExportT3() {
		return this.activeEnergyExportT3;
	}

	public void setActiveEnergyExportT3(String activeEnergyExportT3) {
		this.activeEnergyExportT3 = activeEnergyExportT3;
	}

	public String getActiveEnergyExportT4() {
		return this.activeEnergyExportT4;
	}

	public void setActiveEnergyExportT4(String activeEnergyExportT4) {
		this.activeEnergyExportT4 = activeEnergyExportT4;
	}

	public String getActiveEnergyExportT5() {
		return this.activeEnergyExportT5;
	}

	public void setActiveEnergyExportT5(String activeEnergyExportT5) {
		this.activeEnergyExportT5 = activeEnergyExportT5;
	}

	public String getActiveEnergyExportT6() {
		return this.activeEnergyExportT6;
	}

	public void setActiveEnergyExportT6(String activeEnergyExportT6) {
		this.activeEnergyExportT6 = activeEnergyExportT6;
	}

	public String getActiveEnergyExportT7() {
		return this.activeEnergyExportT7;
	}

	public void setActiveEnergyExportT7(String activeEnergyExportT7) {
		this.activeEnergyExportT7 = activeEnergyExportT7;
	}

	public String getActiveEnergyExportT8() {
		return this.activeEnergyExportT8;
	}

	public void setActiveEnergyExportT8(String activeEnergyExportT8) {
		this.activeEnergyExportT8 = activeEnergyExportT8;
	}

	public String getActiveEnergyCombinedTotal() {
		return this.activeEnergyCombinedTotal;
	}

	public void setActiveEnergyCombinedTotal(String activeEnergyCombinedTotal) {
		this.activeEnergyCombinedTotal = activeEnergyCombinedTotal;
	}

	public String getActiveEnergyCombinedTotalT1() {
		return this.activeEnergyCombinedTotalT1;
	}

	public void setActiveEnergyCombinedTotalT1(
			String activeEnergyCombinedTotalT1) {
		this.activeEnergyCombinedTotalT1 = activeEnergyCombinedTotalT1;
	}

	public String getActiveEnergyCombinedTotalT2() {
		return this.activeEnergyCombinedTotalT2;
	}

	public void setActiveEnergyCombinedTotalT2(
			String activeEnergyCombinedTotalT2) {
		this.activeEnergyCombinedTotalT2 = activeEnergyCombinedTotalT2;
	}

	public String getActiveEnergyCombinedTotalT3() {
		return this.activeEnergyCombinedTotalT3;
	}

	public void setActiveEnergyCombinedTotalT3(
			String activeEnergyCombinedTotalT3) {
		this.activeEnergyCombinedTotalT3 = activeEnergyCombinedTotalT3;
	}

	public String getActiveEnergyCombinedTotalT4() {
		return this.activeEnergyCombinedTotalT4;
	}

	public void setActiveEnergyCombinedTotalT4(
			String activeEnergyCombinedTotalT4) {
		this.activeEnergyCombinedTotalT4 = activeEnergyCombinedTotalT4;
	}

	public String getActiveEnergyCombinedTotalT5() {
		return this.activeEnergyCombinedTotalT5;
	}

	public void setActiveEnergyCombinedTotalT5(
			String activeEnergyCombinedTotalT5) {
		this.activeEnergyCombinedTotalT5 = activeEnergyCombinedTotalT5;
	}

	public String getActiveEnergyCombinedTotalT6() {
		return this.activeEnergyCombinedTotalT6;
	}

	public void setActiveEnergyCombinedTotalT6(
			String activeEnergyCombinedTotalT6) {
		this.activeEnergyCombinedTotalT6 = activeEnergyCombinedTotalT6;
	}

	public String getActiveEnergyCombinedTotalT7() {
		return this.activeEnergyCombinedTotalT7;
	}

	public void setActiveEnergyCombinedTotalT7(
			String activeEnergyCombinedTotalT7) {
		this.activeEnergyCombinedTotalT7 = activeEnergyCombinedTotalT7;
	}

	public String getActiveEnergyCombinedTotalT8() {
		return this.activeEnergyCombinedTotalT8;
	}

	public void setActiveEnergyCombinedTotalT8(
			String activeEnergyCombinedTotalT8) {
		this.activeEnergyCombinedTotalT8 = activeEnergyCombinedTotalT8;
	}

	public String getActiveEnergyNetTotal() {
		return this.activeEnergyNetTotal;
	}

	public void setActiveEnergyNetTotal(String activeEnergyNetTotal) {
		this.activeEnergyNetTotal = activeEnergyNetTotal;
	}

	public String getActiveEnergyNetTotalT1() {
		return this.activeEnergyNetTotalT1;
	}

	public void setActiveEnergyNetTotalT1(String activeEnergyNetTotalT1) {
		this.activeEnergyNetTotalT1 = activeEnergyNetTotalT1;
	}

	public String getActiveEnergyNetTotalT2() {
		return this.activeEnergyNetTotalT2;
	}

	public void setActiveEnergyNetTotalT2(String activeEnergyNetTotalT2) {
		this.activeEnergyNetTotalT2 = activeEnergyNetTotalT2;
	}

	public String getActiveEnergyNetTotalT3() {
		return this.activeEnergyNetTotalT3;
	}

	public void setActiveEnergyNetTotalT3(String activeEnergyNetTotalT3) {
		this.activeEnergyNetTotalT3 = activeEnergyNetTotalT3;
	}

	public String getActiveEnergyNetTotalT4() {
		return this.activeEnergyNetTotalT4;
	}

	public void setActiveEnergyNetTotalT4(String activeEnergyNetTotalT4) {
		this.activeEnergyNetTotalT4 = activeEnergyNetTotalT4;
	}

	public String getActiveEnergyNetTotalT5() {
		return this.activeEnergyNetTotalT5;
	}

	public void setActiveEnergyNetTotalT5(String activeEnergyNetTotalT5) {
		this.activeEnergyNetTotalT5 = activeEnergyNetTotalT5;
	}

	public String getActiveEnergyNetTotalT6() {
		return this.activeEnergyNetTotalT6;
	}

	public void setActiveEnergyNetTotalT6(String activeEnergyNetTotalT6) {
		this.activeEnergyNetTotalT6 = activeEnergyNetTotalT6;
	}

	public String getActiveEnergyNetTotalT7() {
		return this.activeEnergyNetTotalT7;
	}

	public void setActiveEnergyNetTotalT7(String activeEnergyNetTotalT7) {
		this.activeEnergyNetTotalT7 = activeEnergyNetTotalT7;
	}

	public String getActiveEnergyNetTotalT8() {
		return this.activeEnergyNetTotalT8;
	}

	public void setActiveEnergyNetTotalT8(String activeEnergyNetTotalT8) {
		this.activeEnergyNetTotalT8 = activeEnergyNetTotalT8;
	}

	public String getReactiveEnergy() {
		return this.reactiveEnergy;
	}

	public void setReactiveEnergy(String reactiveEnergy) {
		this.reactiveEnergy = reactiveEnergy;
	}

	public String getReactiveEnergyImport() {
		return this.reactiveEnergyImport;
	}

	public void setReactiveEnergyImport(String reactiveEnergyImport) {
		this.reactiveEnergyImport = reactiveEnergyImport;
	}

	public String getReactiveEnergyExport() {
		return this.reactiveEnergyExport;
	}

	public void setReactiveEnergyExport(String reactiveEnergyExport) {
		this.reactiveEnergyExport = reactiveEnergyExport;
	}

	public String getReactiveEnergyQ1() {
		return this.reactiveEnergyQ1;
	}

	public void setReactiveEnergyQ1(String reactiveEnergyQ1) {
		this.reactiveEnergyQ1 = reactiveEnergyQ1;
	}

	public String getReactiveEnergyQ2() {
		return this.reactiveEnergyQ2;
	}

	public void setReactiveEnergyQ2(String reactiveEnergyQ2) {
		this.reactiveEnergyQ2 = reactiveEnergyQ2;
	}

	public String getReactiveEnergyQ3() {
		return this.reactiveEnergyQ3;
	}

	public void setReactiveEnergyQ3(String reactiveEnergyQ3) {
		this.reactiveEnergyQ3 = reactiveEnergyQ3;
	}

	public String getReactiveEnergyQ4() {
		return this.reactiveEnergyQ4;
	}

	public void setReactiveEnergyQ4(String reactiveEnergyQ4) {
		this.reactiveEnergyQ4 = reactiveEnergyQ4;
	}

	public String getApparentEnergy() {
		return this.apparentEnergy;
	}

	public void setApparentEnergy(String apparentEnergy) {
		this.apparentEnergy = apparentEnergy;
	}

	public String getApparentEnergyImport() {
		return this.apparentEnergyImport;
	}

	public void setApparentEnergyImport(String apparentEnergyImport) {
		this.apparentEnergyImport = apparentEnergyImport;
	}

	public String getApparentEnergyImportT1() {
		return this.apparentEnergyImportT1;
	}

	public void setApparentEnergyImportT1(String apparentEnergyImportT1) {
		this.apparentEnergyImportT1 = apparentEnergyImportT1;
	}

	public String getApparentEnergyImportT2() {
		return this.apparentEnergyImportT2;
	}

	public void setApparentEnergyImportT2(String apparentEnergyImportT2) {
		this.apparentEnergyImportT2 = apparentEnergyImportT2;
	}

	public String getApparentEnergyImportT3() {
		return this.apparentEnergyImportT3;
	}

	public void setApparentEnergyImportT3(String apparentEnergyImportT3) {
		this.apparentEnergyImportT3 = apparentEnergyImportT3;
	}

	public String getApparentEnergyImportT4() {
		return this.apparentEnergyImportT4;
	}

	public void setApparentEnergyImportT4(String apparentEnergyImportT4) {
		this.apparentEnergyImportT4 = apparentEnergyImportT4;
	}

	public String getApparentEnergyImportT5() {
		return this.apparentEnergyImportT5;
	}

	public void setApparentEnergyImportT5(String apparentEnergyImportT5) {
		this.apparentEnergyImportT5 = apparentEnergyImportT5;
	}

	public String getApparentEnergyImportT6() {
		return this.apparentEnergyImportT6;
	}

	public void setApparentEnergyImportT6(String apparentEnergyImportT6) {
		this.apparentEnergyImportT6 = apparentEnergyImportT6;
	}

	public String getApparentEnergyImportT7() {
		return this.apparentEnergyImportT7;
	}

	public void setApparentEnergyImportT7(String apparentEnergyImportT7) {
		this.apparentEnergyImportT7 = apparentEnergyImportT7;
	}

	public String getApparentEnergyImportT8() {
		return this.apparentEnergyImportT8;
	}

	public void setApparentEnergyImportT8(String apparentEnergyImportT8) {
		this.apparentEnergyImportT8 = apparentEnergyImportT8;
	}

	public String getApparentEnergyExport() {
		return this.apparentEnergyExport;
	}

	public void setApparentEnergyExport(String apparentEnergyExport) {
		this.apparentEnergyExport = apparentEnergyExport;
	}

	public String getApparentEnergyExportT1() {
		return this.apparentEnergyExportT1;
	}

	public void setApparentEnergyExportT1(String apparentEnergyExportT1) {
		this.apparentEnergyExportT1 = apparentEnergyExportT1;
	}

	public String getApparentEnergyExportT2() {
		return this.apparentEnergyExportT2;
	}

	public void setApparentEnergyExportT2(String apparentEnergyExportT2) {
		this.apparentEnergyExportT2 = apparentEnergyExportT2;
	}

	public String getApparentEnergyExportT3() {
		return this.apparentEnergyExportT3;
	}

	public void setApparentEnergyExportT3(String apparentEnergyExportT3) {
		this.apparentEnergyExportT3 = apparentEnergyExportT3;
	}

	public String getApparentEnergyExportT4() {
		return this.apparentEnergyExportT4;
	}

	public void setApparentEnergyExportT4(String apparentEnergyExportT4) {
		this.apparentEnergyExportT4 = apparentEnergyExportT4;
	}

	public String getApparentEnergyExportT5() {
		return this.apparentEnergyExportT5;
	}

	public void setApparentEnergyExportT5(String apparentEnergyExportT5) {
		this.apparentEnergyExportT5 = apparentEnergyExportT5;
	}

	public String getApparentEnergyExportT6() {
		return this.apparentEnergyExportT6;
	}

	public void setApparentEnergyExportT6(String apparentEnergyExportT6) {
		this.apparentEnergyExportT6 = apparentEnergyExportT6;
	}

	public String getApparentEnergyExportT7() {
		return this.apparentEnergyExportT7;
	}

	public void setApparentEnergyExportT7(String apparentEnergyExportT7) {
		this.apparentEnergyExportT7 = apparentEnergyExportT7;
	}

	public String getApparentEnergyExportT8() {
		return this.apparentEnergyExportT8;
	}

	public void setApparentEnergyExportT8(String apparentEnergyExportT8) {
		this.apparentEnergyExportT8 = apparentEnergyExportT8;
	}

	public String getActivePowerImport() {
		return this.activePowerImport;
	}

	public void setActivePowerImport(String activePowerImport) {
		this.activePowerImport = activePowerImport;
	}

	public String getActivePowerImportL1() {
		return this.activePowerImportL1;
	}

	public void setActivePowerImportL1(String activePowerImportL1) {
		this.activePowerImportL1 = activePowerImportL1;
	}

	public String getActivePowerImportL2() {
		return this.activePowerImportL2;
	}

	public void setActivePowerImportL2(String activePowerImportL2) {
		this.activePowerImportL2 = activePowerImportL2;
	}

	public String getActivePowerImportL3() {
		return this.activePowerImportL3;
	}

	public void setActivePowerImportL3(String activePowerImportL3) {
		this.activePowerImportL3 = activePowerImportL3;
	}

	public String getActivePowerExport() {
		return this.activePowerExport;
	}

	public void setActivePowerExport(String activePowerExport) {
		this.activePowerExport = activePowerExport;
	}

	public String getActivePowerExportL1() {
		return this.activePowerExportL1;
	}

	public void setActivePowerExportL1(String activePowerExportL1) {
		this.activePowerExportL1 = activePowerExportL1;
	}

	public String getActivePowerExportL2() {
		return this.activePowerExportL2;
	}

	public void setActivePowerExportL2(String activePowerExportL2) {
		this.activePowerExportL2 = activePowerExportL2;
	}

	public String getActivePowerExportL3() {
		return this.activePowerExportL3;
	}

	public void setActivePowerExportL3(String activePowerExportL3) {
		this.activePowerExportL3 = activePowerExportL3;
	}

	public String getReactivePower() {
		return this.reactivePower;
	}

	public void setReactivePower(String reactivePower) {
		this.reactivePower = reactivePower;
	}

	public String getReactivePowerImport() {
		return this.reactivePowerImport;
	}

	public void setReactivePowerImport(String reactivePowerImport) {
		this.reactivePowerImport = reactivePowerImport;
	}

	public String getReactivePowerImportL1() {
		return this.reactivePowerImportL1;
	}

	public void setReactivePowerImportL1(String reactivePowerImportL1) {
		this.reactivePowerImportL1 = reactivePowerImportL1;
	}

	public String getReactivePowerImportL2() {
		return this.reactivePowerImportL2;
	}

	public void setReactivePowerImportL2(String reactivePowerImportL2) {
		this.reactivePowerImportL2 = reactivePowerImportL2;
	}

	public String getReactivePowerImportL3() {
		return this.reactivePowerImportL3;
	}

	public void setReactivePowerImportL3(String reactivePowerImportL3) {
		this.reactivePowerImportL3 = reactivePowerImportL3;
	}

	public String getReactivePowerExport() {
		return this.reactivePowerExport;
	}

	public void setReactivePowerExport(String reactivePowerExport) {
		this.reactivePowerExport = reactivePowerExport;
	}

	public String getReactivePowerExportL1() {
		return this.reactivePowerExportL1;
	}

	public void setReactivePowerExportL1(String reactivePowerExportL1) {
		this.reactivePowerExportL1 = reactivePowerExportL1;
	}

	public String getReactivePowerExportL2() {
		return this.reactivePowerExportL2;
	}

	public void setReactivePowerExportL2(String reactivePowerExportL2) {
		this.reactivePowerExportL2 = reactivePowerExportL2;
	}

	public String getReactivePowerExportL3() {
		return this.reactivePowerExportL3;
	}

	public void setReactivePowerExportL3(String reactivePowerExportL3) {
		this.reactivePowerExportL3 = reactivePowerExportL3;
	}

	public String getApparentPower() {
		return this.apparentPower;
	}

	public void setApparentPower(String apparentPower) {
		this.apparentPower = apparentPower;
	}

	public String getApparentPowerImport() {
		return this.apparentPowerImport;
	}

	public void setApparentPowerImport(String apparentPowerImport) {
		this.apparentPowerImport = apparentPowerImport;
	}

	public String getApparentPowerImportL1() {
		return this.apparentPowerImportL1;
	}

	public void setApparentPowerImportL1(String apparentPowerImportL1) {
		this.apparentPowerImportL1 = apparentPowerImportL1;
	}

	public String getApparentPowerImportL2() {
		return this.apparentPowerImportL2;
	}

	public void setApparentPowerImportL2(String apparentPowerImportL2) {
		this.apparentPowerImportL2 = apparentPowerImportL2;
	}

	public String getApparentPowerImportL3() {
		return this.apparentPowerImportL3;
	}

	public void setApparentPowerImportL3(String apparentPowerImportL3) {
		this.apparentPowerImportL3 = apparentPowerImportL3;
	}

	public String getApparentPowerExport() {
		return this.apparentPowerExport;
	}

	public void setApparentPowerExport(String apparentPowerExport) {
		this.apparentPowerExport = apparentPowerExport;
	}

	public String getApparentPowerExportL1() {
		return this.apparentPowerExportL1;
	}

	public void setApparentPowerExportL1(String apparentPowerExportL1) {
		this.apparentPowerExportL1 = apparentPowerExportL1;
	}

	public String getApparentPowerExportL2() {
		return this.apparentPowerExportL2;
	}

	public void setApparentPowerExportL2(String apparentPowerExportL2) {
		this.apparentPowerExportL2 = apparentPowerExportL2;
	}

	public String getApparentPowerExportL3() {
		return this.apparentPowerExportL3;
	}

	public void setApparentPowerExportL3(String apparentPowerExportL3) {
		this.apparentPowerExportL3 = apparentPowerExportL3;
	}

	public String getPowerFactor() {
		return this.powerFactor;
	}

	public void setPowerFactor(String powerFactor) {
		this.powerFactor = powerFactor;
	}

	public String getPowerFactorL1() {
		return this.powerFactorL1;
	}

	public void setPowerFactorL1(String powerFactorL1) {
		this.powerFactorL1 = powerFactorL1;
	}

	public String getPowerFactorL2() {
		return this.powerFactorL2;
	}

	public void setPowerFactorL2(String powerFactorL2) {
		this.powerFactorL2 = powerFactorL2;
	}

	public String getPowerFactorL3() {
		return this.powerFactorL3;
	}

	public void setPowerFactorL3(String powerFactorL3) {
		this.powerFactorL3 = powerFactorL3;
	}

	public String getPhaseAngle() {
		return this.phaseAngle;
	}

	public void setPhaseAngle(String phaseAngle) {
		this.phaseAngle = phaseAngle;
	}

	public String getPhaseAngleL1() {
		return this.phaseAngleL1;
	}

	public void setPhaseAngleL1(String phaseAngleL1) {
		this.phaseAngleL1 = phaseAngleL1;
	}

	public String getPhaseAngleL2() {
		return this.phaseAngleL2;
	}

	public void setPhaseAngleL2(String phaseAngleL2) {
		this.phaseAngleL2 = phaseAngleL2;
	}

	public String getPhaseAngleL3() {
		return this.phaseAngleL3;
	}

	public void setPhaseAngleL3(String phaseAngleL3) {
		this.phaseAngleL3 = phaseAngleL3;
	}

	public String getVoltage() {
		return this.voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getVoltageL1() {
		return this.voltageL1;
	}

	public void setVoltageL1(String voltageL1) {
		this.voltageL1 = voltageL1;
	}

	public String getVoltageL2() {
		return this.voltageL2;
	}

	public void setVoltageL2(String voltageL2) {
		this.voltageL2 = voltageL2;
	}

	public String getVoltageL3() {
		return this.voltageL3;
	}

	public void setVoltageL3(String voltageL3) {
		this.voltageL3 = voltageL3;
	}

	public String getCurrent() {
		return this.current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getCurrentL1() {
		return this.currentL1;
	}

	public void setCurrentL1(String currentL1) {
		this.currentL1 = currentL1;
	}

	public String getCurrentL2() {
		return this.currentL2;
	}

	public void setCurrentL2(String currentL2) {
		this.currentL2 = currentL2;
	}

	public String getCurrentL3() {
		return this.currentL3;
	}

	public void setCurrentL3(String currentL3) {
		this.currentL3 = currentL3;
	}

	public String getAmpereHoursInAbsenceOfVoltageL1() {
		return this.ampereHoursInAbsenceOfVoltageL1;
	}

	public void setAmpereHoursInAbsenceOfVoltageL1(
			String ampereHoursInAbsenceOfVoltageL1) {
		this.ampereHoursInAbsenceOfVoltageL1 = ampereHoursInAbsenceOfVoltageL1;
	}

	public String getAmpereHoursInAbsenceOfVoltageL2() {
		return this.ampereHoursInAbsenceOfVoltageL2;
	}

	public void setAmpereHoursInAbsenceOfVoltageL2(
			String ampereHoursInAbsenceOfVoltageL2) {
		this.ampereHoursInAbsenceOfVoltageL2 = ampereHoursInAbsenceOfVoltageL2;
	}

	public String getAmpereHoursInAbsenceOfVoltageL3() {
		return this.ampereHoursInAbsenceOfVoltageL3;
	}

	public void setAmpereHoursInAbsenceOfVoltageL3(
			String ampereHoursInAbsenceOfVoltageL3) {
		this.ampereHoursInAbsenceOfVoltageL3 = ampereHoursInAbsenceOfVoltageL3;
	}

	public String getActiveDemand() {
		return this.activeDemand;
	}

	public void setActiveDemand(String activeDemand) {
		this.activeDemand = activeDemand;
	}

	public String getActiveDemandImport() {
		return this.activeDemandImport;
	}

	public void setActiveDemandImport(String activeDemandImport) {
		this.activeDemandImport = activeDemandImport;
	}

	public String getActiveDemandImportOccTime() {
		return this.activeDemandImportOccTime;
	}

	public void setActiveDemandImportOccTime(String activeDemandImportOccTime) {
		this.activeDemandImportOccTime = activeDemandImportOccTime;
	}

	public String getActiveDemandExport() {
		return this.activeDemandExport;
	}

	public void setActiveDemandExport(String activeDemandExport) {
		this.activeDemandExport = activeDemandExport;
	}

	public String getActiveDemandExportOccTime() {
		return this.activeDemandExportOccTime;
	}

	public void setActiveDemandExportOccTime(String activeDemandExportOccTime) {
		this.activeDemandExportOccTime = activeDemandExportOccTime;
	}

	public String getApparentDemand() {
		return this.apparentDemand;
	}

	public void setApparentDemand(String apparentDemand) {
		this.apparentDemand = apparentDemand;
	}

	public String getApparentDemandImport() {
		return this.apparentDemandImport;
	}

	public void setApparentDemandImport(String apparentDemandImport) {
		this.apparentDemandImport = apparentDemandImport;
	}

	public String getApparentDemandImportOccTime() {
		return this.apparentDemandImportOccTime;
	}

	public void setApparentDemandImportOccTime(
			String apparentDemandImportOccTime) {
		this.apparentDemandImportOccTime = apparentDemandImportOccTime;
	}

	public String getApparentDemandExport() {
		return this.apparentDemandExport;
	}

	public void setApparentDemandExport(String apparentDemandExport) {
		this.apparentDemandExport = apparentDemandExport;
	}

	public String getApparentDemandExportOccTime() {
		return this.apparentDemandExportOccTime;
	}

	public void setApparentDemandExportOccTime(
			String apparentDemandExportOccTime) {
		this.apparentDemandExportOccTime = apparentDemandExportOccTime;
	}

	public MeterMaster getMeterMasterObj() {
		return meterMasterObj;
	}

	public void setMeterMasterObj(MeterMaster meterMasterObj) {
		this.meterMasterObj = meterMasterObj;
	}

}