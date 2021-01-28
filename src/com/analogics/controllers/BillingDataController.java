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

import com.analogics.dao.BillingDataDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.BillingData;
import com.analogics.vo.BillingDataLatest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Sandhya.B
 *
 */

@Controller
public class BillingDataController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	CommonDAO commonDaoObj = new CommonDAO();
	BillingDataDao masterDaoObj = new BillingDataDao();
	
	@RequestMapping("/viewBillingData")
	public ModelAndView viewBillingData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") BillingData dataObj) {
		ModelAndView model = new ModelAndView("Masters/BillingData/ViewBillingDataDetails",
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
			model.addObject("command", fetchBillingDataColumsMap(dataObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchBillingDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchBillingDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") BillingData dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<BillingData> dataList = new ArrayList<BillingData>();
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
				dataList = masterDaoObj.fetchBillingDataList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,dataObj,levelIndexObj);
				count = masterDaoObj.fetchBillingDataDetailsCount(pageNumber,
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
	
	
	
	@RequestMapping("/viewLatestBillingData")
	public ModelAndView viewLatestBillingData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") BillingDataLatest dataObj) {
		ModelAndView model = new ModelAndView("Masters/BillingData/ViewLatestBillingDataDetails",
				"command", dataObj);
		try {
			HttpSession session=request.getSession();
			UserLoginDetails userSessionObj=(UserLoginDetails) session.getAttribute("sessionObj");
			
			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1") && hierVoObj.getLevel1Id()!=null){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("command", fetchBillingLatestDataColumsMap(dataObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchLatestBillingDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchLatestBillingDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") BillingDataLatest dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<BillingDataLatest> dataList = new ArrayList<BillingDataLatest>();
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
				dataList = masterDaoObj.fetchLatestBillingDataList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,dataObj,levelIndexObj);
				count = masterDaoObj.fetchLatestBillingDataDetailsCount(pageNumber,
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
	
	
	
	private Object fetchBillingDataColumsMap(BillingData dataObj) {
		try {
			Map<String,String> searchColumnsMap = new HashMap<String,String>();
			searchColumnsMap.put("id.meterNumber", "METER NUMBER");
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

	private Object fetchBillingLatestDataColumsMap(BillingDataLatest dataObj) {
		try {
			
			Map<String,String> searchColumnsMap = new HashMap<String,String>();
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
