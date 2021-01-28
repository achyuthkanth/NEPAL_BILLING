package com.analogics.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.analogics.um.vo.HierarchyLevelsVo;

/**
 * BillingDataLatest entity. @author MyEclipse Persistence Tools
 */

public class BillingDataLatest extends HierarchyLevelsVo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 5837025026621870070L;
	private String meterNumber;
	private Timestamp mdresetDateTime;
	private Date mdresetDate;
	private Time mdresetTime;
	private Integer mdresetYear;
	private Integer mdresetMonth;
	private Integer intervalNo;
	private Timestamp meterDateTime;
	private Date meterDate;
	private Time meterTime;
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

	// Constructors

	/** default constructor */
	public BillingDataLatest() {
	}

	/** minimal constructor */
	public BillingDataLatest(String meterNumber, Timestamp mdresetDateTime,
			Date mdresetDate, Integer mdresetYear, Integer mdresetMonth,
			Timestamp meterDateTime, Date meterDate) {
		this.meterNumber = meterNumber;
		this.mdresetDateTime = mdresetDateTime;
		this.mdresetDate = mdresetDate;
		this.mdresetYear = mdresetYear;
		this.mdresetMonth = mdresetMonth;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
	}

	/** full constructor */
	public BillingDataLatest(String meterNumber, Timestamp mdresetDateTime,
			Date mdresetDate, Time mdresetTime, Integer mdresetYear,
			Integer mdresetMonth, Integer intervalNo, Timestamp meterDateTime,
			Date meterDate, Time meterTime, String activeEnergy,
			String activeEnergyImport, String activeEnergyImportL1,
			String activeEnergyImportL2, String activeEnergyImportL3,
			String activeEnergyImportT1, String activeEnergyImportT2,
			String activeEnergyImportT3, String activeEnergyImportT4,
			String activeEnergyImportT5, String activeEnergyImportT6,
			String activeEnergyImportT7, String activeEnergyImportT8,
			String activeEnergyExport, String activeEnergyExportL1,
			String activeEnergyExportL2, String activeEnergyExportL3,
			String activeEnergyExportT1, String activeEnergyExportT2,
			String activeEnergyExportT3, String activeEnergyExportT4,
			String activeEnergyExportT5, String activeEnergyExportT6,
			String activeEnergyExportT7, String activeEnergyExportT8,
			String activeEnergyCombinedTotal,
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
			String activeDemand, String activeDemandImport,
			String activeDemandImportOccTime, String activeDemandExport,
			String activeDemandExportOccTime, String apparentDemand,
			String apparentDemandImport, String apparentDemandImportOccTime,
			String apparentDemandExport, String apparentDemandExportOccTime) {
		this.meterNumber = meterNumber;
		this.mdresetDateTime = mdresetDateTime;
		this.mdresetDate = mdresetDate;
		this.mdresetTime = mdresetTime;
		this.mdresetYear = mdresetYear;
		this.mdresetMonth = mdresetMonth;
		this.intervalNo = intervalNo;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
		this.meterTime = meterTime;
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

	public Date getMdresetDate() {
		return this.mdresetDate;
	}

	public void setMdresetDate(Date mdresetDate) {
		this.mdresetDate = mdresetDate;
	}

	public Time getMdresetTime() {
		return this.mdresetTime;
	}

	public void setMdresetTime(Time mdresetTime) {
		this.mdresetTime = mdresetTime;
	}

	public Integer getMdresetYear() {
		return this.mdresetYear;
	}

	public void setMdresetYear(Integer mdresetYear) {
		this.mdresetYear = mdresetYear;
	}

	public Integer getMdresetMonth() {
		return this.mdresetMonth;
	}

	public void setMdresetMonth(Integer mdresetMonth) {
		this.mdresetMonth = mdresetMonth;
	}

	public Integer getIntervalNo() {
		return this.intervalNo;
	}

	public void setIntervalNo(Integer intervalNo) {
		this.intervalNo = intervalNo;
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

}