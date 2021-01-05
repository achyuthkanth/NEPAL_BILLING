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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Controller
public class AlarmDataController {
	UserHierUtils utilsObj = new UserHierUtils();
	AlarmDataDao alarmDao = new AlarmDataDao();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
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
	
}
