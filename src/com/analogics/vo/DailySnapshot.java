package com.analogics.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.analogics.um.vo.HierarchyLevelsVo;

/**
 * DailySnapshot entity. @author MyEclipse Persistence Tools
 */

public class DailySnapshot extends HierarchyLevelsVo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DailySnapshotId id;
	private Date snapshotDate;
	private Time snapshotTime;
	private Timestamp meterDateTime;
	private Date meterDate;
	private Time meterTime;
	private Integer intervalNo;
	private String activeEnergy;
	private String activeEnergyImport;
	private String activeEnergyExport;
	private String activeEnergyCombinedTotal;
	private String activeEnergyNetTotal;
	private String reactiveEnergy;
	private String reactiveEnergyImport;
	private String reactiveEnergyExport;
	private String apparentEnergy;
	private String apparentEnergyImport;
	private String apparentEnergyExport;
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

	
	//Required Fields
		private MeterMaster meterMasterObj;
		
		
	// Constructors

	/** default constructor */
	public DailySnapshot() {
	}

	/** minimal constructor */
	public DailySnapshot(DailySnapshotId id, Date snapshotDate,
			Timestamp meterDateTime, Date meterDate) {
		this.id = id;
		this.snapshotDate = snapshotDate;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
	}

	/** full constructor */
	public DailySnapshot(DailySnapshotId id, Date snapshotDate,
			Time snapshotTime, Timestamp meterDateTime, Date meterDate,
			Time meterTime, Integer intervalNo, String activeEnergy,
			String activeEnergyImport, String activeEnergyExport,
			String activeEnergyCombinedTotal, String activeEnergyNetTotal,
			String reactiveEnergy, String reactiveEnergyImport,
			String reactiveEnergyExport, String apparentEnergy,
			String apparentEnergyImport, String apparentEnergyExport,
			String activeDemand, String activeDemandImport,
			String activeDemandImportOccTime, String activeDemandExport,
			String activeDemandExportOccTime, String apparentDemand,
			String apparentDemandImport, String apparentDemandImportOccTime,
			String apparentDemandExport, String apparentDemandExportOccTime) {
		this.id = id;
		this.snapshotDate = snapshotDate;
		this.snapshotTime = snapshotTime;
		this.meterDateTime = meterDateTime;
		this.meterDate = meterDate;
		this.meterTime = meterTime;
		this.intervalNo = intervalNo;
		this.activeEnergy = activeEnergy;
		this.activeEnergyImport = activeEnergyImport;
		this.activeEnergyExport = activeEnergyExport;
		this.activeEnergyCombinedTotal = activeEnergyCombinedTotal;
		this.activeEnergyNetTotal = activeEnergyNetTotal;
		this.reactiveEnergy = reactiveEnergy;
		this.reactiveEnergyImport = reactiveEnergyImport;
		this.reactiveEnergyExport = reactiveEnergyExport;
		this.apparentEnergy = apparentEnergy;
		this.apparentEnergyImport = apparentEnergyImport;
		this.apparentEnergyExport = apparentEnergyExport;
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

	public DailySnapshotId getId() {
		return this.id;
	}

	public void setId(DailySnapshotId id) {
		this.id = id;
	}

	public Date getSnapshotDate() {
		return this.snapshotDate;
	}

	public void setSnapshotDate(Date snapshotDate) {
		this.snapshotDate = snapshotDate;
	}

	public Time getSnapshotTime() {
		return this.snapshotTime;
	}

	public void setSnapshotTime(Time snapshotTime) {
		this.snapshotTime = snapshotTime;
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

	public Integer getIntervalNo() {
		return this.intervalNo;
	}

	public void setIntervalNo(Integer intervalNo) {
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

	public String getActiveEnergyExport() {
		return this.activeEnergyExport;
	}

	public void setActiveEnergyExport(String activeEnergyExport) {
		this.activeEnergyExport = activeEnergyExport;
	}

	public String getActiveEnergyCombinedTotal() {
		return this.activeEnergyCombinedTotal;
	}

	public void setActiveEnergyCombinedTotal(String activeEnergyCombinedTotal) {
		this.activeEnergyCombinedTotal = activeEnergyCombinedTotal;
	}

	public String getActiveEnergyNetTotal() {
		return this.activeEnergyNetTotal;
	}

	public void setActiveEnergyNetTotal(String activeEnergyNetTotal) {
		this.activeEnergyNetTotal = activeEnergyNetTotal;
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

	public String getApparentEnergyExport() {
		return this.apparentEnergyExport;
	}

	public void setApparentEnergyExport(String apparentEnergyExport) {
		this.apparentEnergyExport = apparentEnergyExport;
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