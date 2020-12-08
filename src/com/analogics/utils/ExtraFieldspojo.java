package com.analogics.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
