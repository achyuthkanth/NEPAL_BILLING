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

import com.analogics.dao.InstantDataDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.InstantData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class InstantDataController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	CommonDAO commonDaoObj = new CommonDAO();
	InstantDataDao masterDaoObj = new InstantDataDao();
	
	@RequestMapping("/viewInstantData")
	public ModelAndView viewInstantData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") InstantData dataObj) {
		ModelAndView model = new ModelAndView("Masters/InstantData/ViewInstantDataDetails",
				"command", dataObj);
		try {
			HttpSession session=request.getSession();
			UserLoginDetails userSessionObj=(UserLoginDetails) session.getAttribute("sessionObj");
			
			if (dataObj.getFromDate() == null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d = new Date();
				dataObj.setFromDate(format.format(d));
				dataObj.setToDate(format.format(d));
			}

			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1") && hierVoObj.getLevel1Id()!=null){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("command", fetchInstantDataColumsMap(dataObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchInstantDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchInstantDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") InstantData dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<InstantData> dataList = new ArrayList<InstantData>();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			try {
				dataList = masterDaoObj.fetchInstantDataList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,dataObj,levelIndexObj);
				count = masterDaoObj.fetchInstantDataDetailsCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,dataObj,levelIndexObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(dataList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	private Object fetchInstantDataColumsMap(InstantData dataObj) {
		try {
			/*Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "METER NUMBER");
			columnsMap.put("2", "Consumer Number");
			columnsMap.put("3", "Consumer Address");
			columnsMap.put("4", "Consumer Company Details");
			columnsMap.put("5", "Contact No");
			columnsMap.put("6", "Alternate Contact");
			columnsMap.put("7", "Email Address");
			columnsMap.put("8", "Identification Number");
			columnsMap.put("9", "Connection Status");
			columnsMap.put("10", "Installation Date");
			columnsMap.put("11", "Inserted Date");
			columnsMap.put("12", "Inserted User");
			dataObj.setColumnsMap(columnsMap);*/
			
			Map<String,String> searchColumnsMap = new HashMap<String,String>();
			searchColumnsMap.put("id.meterNumber", "METER NUMBER");
			searchColumnsMap.put("nodeNumber", "NODE NUMBER");
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
