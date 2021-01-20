package com.analogics.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.dao.AlarmDataDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.AlarmData;
import com.analogics.vo.AlarmDataLatest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Controller
public class AlarmDataController {
	UserHierUtils utilsObj = new UserHierUtils();
	AlarmDataDao alarmDao = new AlarmDataDao();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	// Alarm Data //
	
	
	@RequestMapping("/viewAlarmData")
	public ModelAndView viewAlarmData(HttpServletRequest request ,HttpServletResponse response,
			@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,@ModelAttribute("dataObj") AlarmData dataObj) {
		ModelAndView model = new ModelAndView(
				"/Masters/AlarmData/ViewAlarmDataDetails", "command",
				dataObj);
		try {
			HttpSession session = request.getSession();
			UserLoginDetails userSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			
			if (dataObj.getFromDate() == null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d = new Date();
				dataObj.setFromDate(format.format(d));
				dataObj.setToDate(format.format(d));
			}
			
			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1")){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("command", fetchAlarmdataColumsMap(dataObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	private Object fetchAlarmdataColumsMap(AlarmData dataObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Node Number");
			columnsMap.put("2", "Meter Number");
			columnsMap.put("3", "Consumer Name");
			columnsMap.put("4", "Consumer Number");
			columnsMap.put("5", "Date Time");
			columnsMap.put("6", "Seq No");
			columnsMap.put("7", "Alarm Code");
			columnsMap.put("8", "Alarm Description");
			columnsMap.put("9", "Utility");
			columnsMap.put("10", "Utility Code");
			columnsMap.put("11", "Region");
			columnsMap.put("12", "Region Code");
			columnsMap.put("13", "Circle");
			columnsMap.put("14", "Circle Code");
			columnsMap.put("15", "Division");
			columnsMap.put("16", "Division Code");
			columnsMap.put("17", "Sub Division");
			columnsMap.put("18", "Sub Division Code");
			columnsMap.put("19", "Town");
			columnsMap.put("20", "Town Code");
			columnsMap.put("21", "Section");
			columnsMap.put("22", "Section Code");
			columnsMap.put("23", "Sub Station");
			columnsMap.put("24", "Sub Station Code");
			columnsMap.put("25", "Feeder");
			columnsMap.put("26", "Feeder Code");
			dataObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("meterNumber", "METER NUMBER");
			
			dataObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			dataObj.setConditionListStr(conditionListStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataObj;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/fetchAlarmDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchAlarmDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") AlarmData masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json=null;
	
	try {
		List<AlarmData> alarmList=new ArrayList<AlarmData>();
		int pageNumber = 0;
		pageNumber = Integer.parseInt(iDisplayStart);
		ServerDataTable dataTable = new ServerDataTable();
		Map<String,Integer> levelMap=new HashMap<String,Integer>();
		LevelIndexMaster levelIndexObj = new LevelIndexMaster();
		utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
		levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
		
		alarmList=alarmDao.fetchAlarmDataList(pageNumber,
				Integer.parseInt(pageDisplayLength), searchParameter,
				masterObj,levelIndexObj);
    	Long count =alarmDao.fetchAlarmDataCount(masterObj,levelIndexObj);

    	dataTable.setiTotalRecords(count.intValue());
		dataTable.setiTotalDisplayRecords(count.intValue());

		dataTable.setAaData(alarmList);
		 json = gson.toJson(dataTable);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return json;
}
	
	
	// Latest Alarm Data //
	
	
	@RequestMapping("/viewAlarmDataLatest")
	public ModelAndView viewAlarmDataLatest(HttpServletRequest request ,HttpServletResponse response,
			@ModelAttribute("hierarchyObj")HierarchyLevelsVo hierVoObj,@ModelAttribute("dataObj") AlarmDataLatest dataObj) {
		ModelAndView model = new ModelAndView(
				"/Masters/AlarmData/ViewAlarmLatestDataDetails", "command",
				dataObj);
		try {
			HttpSession session = request.getSession();
			UserLoginDetails userSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			
			
			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1")){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("command", fetchAlarmLatestdataColumsMap(dataObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/fetchAlarmLatestDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchAlarmLatestDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") AlarmDataLatest masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json=null;
	
	try {
		List<AlarmDataLatest> alarmLatestList=new ArrayList<AlarmDataLatest>();
		int pageNumber = 0;
		pageNumber = Integer.parseInt(iDisplayStart);
		ServerDataTable dataTable = new ServerDataTable();
		Map<String,Integer> levelMap=new HashMap<String,Integer>();
		LevelIndexMaster levelIndexObj = new LevelIndexMaster();
		utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
		levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
		
		alarmLatestList=alarmDao.fetchAlarmDataLatestList(pageNumber,
				Integer.parseInt(pageDisplayLength), searchParameter,
				masterObj,levelIndexObj);
    	Long count =alarmDao.fetchAlarmDataLatestCount(masterObj,levelIndexObj);

    	dataTable.setiTotalRecords(count.intValue());
		dataTable.setiTotalDisplayRecords(count.intValue());

		dataTable.setAaData(alarmLatestList);
		 json = gson.toJson(dataTable);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return json;
}
	
	private Object fetchAlarmLatestdataColumsMap(AlarmDataLatest dataObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Node Number");
			columnsMap.put("2", "Meter Number");
			columnsMap.put("3", "Consumer Name");
			columnsMap.put("4", "Consumer Number");
			columnsMap.put("5", "Date Time");
			columnsMap.put("6", "Seq No");
			columnsMap.put("7", "Alarm Code");
			columnsMap.put("8", "Alarm Description");
			columnsMap.put("9", "Utility");
			columnsMap.put("10", "Utility Code");
			columnsMap.put("11", "Region");
			columnsMap.put("12", "Region Code");
			columnsMap.put("13", "Circle");
			columnsMap.put("14", "Circle Code");
			columnsMap.put("15", "Division");
			columnsMap.put("16", "Division Code");
			columnsMap.put("17", "Sub Division");
			columnsMap.put("18", "Sub Division Code");
			columnsMap.put("19", "Town");
			columnsMap.put("20", "Town Code");
			columnsMap.put("21", "Section");
			columnsMap.put("22", "Section Code");
			columnsMap.put("23", "Sub Station");
			columnsMap.put("24", "Sub Station Code");
			columnsMap.put("25", "Feeder");
			columnsMap.put("26", "Feeder Code");
			dataObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("meterNumber", "METER NUMBER");
			
			dataObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			dataObj.setConditionListStr(conditionListStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataObj;
	}
}
