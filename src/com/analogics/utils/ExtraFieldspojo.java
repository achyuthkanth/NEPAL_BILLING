package com.analogics.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.analogics.um.vo.ModuleDetails;
import com.analogics.um.vo.ParamTable;
import com.analogics.um.vo.UserGroup;

public class ExtraFieldspojo {
	
	private Map<String,String> columnsMap=new HashMap<String,String>();
	private Map<String,String> searchColumnsMap=new HashMap<String,String>();
	private List<String> conditionListStr = new ArrayList<String>();
	private String colStr;
	private String searchParameter;
	private String conditionStr;
	private String searchSelectVar;
	private String selectParam;
	private String viewType;
	
	private String response;
	private String reasonResponse;
	
	// User Group
	private List<ModuleDetails> moduleDetails;
	private List<UserGroup> userGroupList;
	//Application Master
	private Map<String,String> applicationStatusList = new HashMap<String,String>();
	private Map<String,String> organizationList = new HashMap<String,String>();
	private Map<Integer,String> levelMapList = new HashMap<Integer, String>();
	
	//Param Master
	private Map<String, String> paramStatusList=new HashMap<String, String>();
	private List<ParamTable> paramTypeList=new ArrayList<ParamTable>();
	private String paramType;
	
	private List<String> userStatusList=new ArrayList<String>();
	private List<String> bioUserGroupList=new ArrayList<String>();
	
	public Map<String, String> getColumnsMap() {
		return columnsMap;
	}
	public void setColumnsMap(Map<String, String> columnsMap) {
		this.columnsMap = columnsMap;
	}
	public Map<String, String> getSearchColumnsMap() {
		return searchColumnsMap;
	}
	public void setSearchColumnsMap(Map<String, String> searchColumnsMap) {
		this.searchColumnsMap = searchColumnsMap;
	}
	public List<String> getConditionListStr() {
		return conditionListStr;
	}
	public void setConditionListStr(List<String> conditionListStr) {
		this.conditionListStr = conditionListStr;
	}
	public String getColStr() {
		return colStr;
	}
	public void setColStr(String colStr) {
		this.colStr = colStr;
	}
	public String getSearchParameter() {
		return searchParameter;
	}
	public void setSearchParameter(String searchParameter) {
		this.searchParameter = searchParameter;
	}
	public String getConditionStr() {
		return conditionStr;
	}
	public void setConditionStr(String conditionStr) {
		this.conditionStr = conditionStr;
	}
	public String getSearchSelectVar() {
		return searchSelectVar;
	}
	public void setSearchSelectVar(String searchSelectVar) {
		this.searchSelectVar = searchSelectVar;
	}
	public String getSelectParam() {
		return selectParam;
	}
	public void setSelectParam(String selectParam) {
		this.selectParam = selectParam;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getReasonResponse() {
		return reasonResponse;
	}
	public void setReasonResponse(String reasonResponse) {
		this.reasonResponse = reasonResponse;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public Map<String, String> getApplicationStatusList() {
		return applicationStatusList;
	}
	public void setApplicationStatusList(Map<String, String> applicationStatusList) {
		this.applicationStatusList = applicationStatusList;
	}
	public Map<String, String> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(Map<String, String> organizationList) {
		this.organizationList = organizationList;
	}
	public Map<Integer, String> getLevelMapList() {
		return levelMapList;
	}
	public void setLevelMapList(Map<Integer, String> levelMapList) {
		this.levelMapList = levelMapList;
	}
	public List<String> getUserStatusList() {
		return userStatusList;
	}
	public void setUserStatusList(List<String> userStatusList) {
		this.userStatusList = userStatusList;
	}
	public List<String> getBioUserGroupList() {
		return bioUserGroupList;
	}
	public void setBioUserGroupList(List<String> bioUserGroupList) {
		this.bioUserGroupList = bioUserGroupList;
	}
	public Map<String, String> getParamStatusList() {
		return paramStatusList;
	}
	public void setParamStatusList(Map<String, String> paramStatusList) {
		this.paramStatusList = paramStatusList;
	}
	public List<ParamTable> getParamTypeList() {
		return paramTypeList;
	}
	public void setParamTypeList(List<ParamTable> paramTypeList) {
		this.paramTypeList = paramTypeList;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public List<ModuleDetails> getModuleDetails() {
		return moduleDetails;
	}
	public void setModuleDetails(List<ModuleDetails> moduleDetails) {
		this.moduleDetails = moduleDetails;
	}
	public List<UserGroup> getUserGroupList() {
		return userGroupList;
	}
	public void setUserGroupList(List<UserGroup> userGroupList) {
		this.userGroupList = userGroupList;
	}

}
