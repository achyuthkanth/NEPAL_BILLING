package com.analogics.utils;

import java.util.HashMap;
import java.util.Map;

public class ExtraFieldspojo {
	
	private String colStr;
	private String colParameter;
	private Map<String,String> columnsMap=new HashMap<String,String>();
	
	public String getColStr() {
		return colStr;
	}
	public void setColStr(String colStr) {
		this.colStr = colStr;
	}
	public String getColParameter() {
		return colParameter;
	}
	public void setColParameter(String colParameter) {
		this.colParameter = colParameter;
	}
	public Map<String, String> getColumnsMap() {
		return columnsMap;
	}
	public void setColumnsMap(Map<String, String> columnsMap) {
		this.columnsMap = columnsMap;
	}

}
