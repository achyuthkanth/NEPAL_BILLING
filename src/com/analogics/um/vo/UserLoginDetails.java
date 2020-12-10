package com.analogics.um.vo;

import java.util.ArrayList;
import java.util.List;


public class UserLoginDetails extends HierarchyLevelsVo{

	
	public BioUserDetails biouserdetails = new BioUserDetails();
	private LevelIndexMaster LevelIndexMasterObj;
	private ApplicationMaster applicationMasterObj;
	private ApplicationLevelIndexMaster appLevelIndexMasterObj;
	
	
	
	
	
	
	private List<String> enabledActionsList=new ArrayList<String>();
	private List<String> enabledViewsList=new ArrayList<String>();
	private List<String> expiredActionsList=new ArrayList<String>();
	private String statusOfOpr;
	private String applicationuniqueid;
	
	public BioUserDetails getBiouserdetails() {
		return biouserdetails;
	}
	public void setBiouserdetails(BioUserDetails biouserdetails) {
		this.biouserdetails = biouserdetails;
	}
	public LevelIndexMaster getLevelIndexMasterObj() {
		return LevelIndexMasterObj;
	}
	public void setLevelIndexMasterObj(LevelIndexMaster levelIndexMasterObj) {
		LevelIndexMasterObj = levelIndexMasterObj;
	}
	public ApplicationMaster getApplicationMasterObj() {
		return applicationMasterObj;
	}
	public void setApplicationMasterObj(ApplicationMaster applicationMasterObj) {
		this.applicationMasterObj = applicationMasterObj;
	}
	public ApplicationLevelIndexMaster getAppLevelIndexMasterObj() {
		return appLevelIndexMasterObj;
	}
	public void setAppLevelIndexMasterObj(
			ApplicationLevelIndexMaster appLevelIndexMasterObj) {
		this.appLevelIndexMasterObj = appLevelIndexMasterObj;
	}
	public List<String> getEnabledActionsList() {
		return enabledActionsList;
	}
	public void setEnabledActionsList(List<String> enabledActionsList) {
		this.enabledActionsList = enabledActionsList;
	}
	public List<String> getEnabledViewsList() {
		return enabledViewsList;
	}
	public void setEnabledViewsList(List<String> enabledViewsList) {
		this.enabledViewsList = enabledViewsList;
	}
	public List<String> getExpiredActionsList() {
		return expiredActionsList;
	}
	public void setExpiredActionsList(List<String> expiredActionsList) {
		this.expiredActionsList = expiredActionsList;
	}
	public String getApplicationuniqueid() {
		return applicationuniqueid;
	}
	public void setApplicationuniqueid(String applicationuniqueid) {
		this.applicationuniqueid = applicationuniqueid;
	}
	public String getStatusOfOpr() {
		return statusOfOpr;
	}
	public void setStatusOfOpr(String statusOfOpr) {
		this.statusOfOpr = statusOfOpr;
	}
}
