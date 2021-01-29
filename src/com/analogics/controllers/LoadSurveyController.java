package com.analogics.controllers;

import java.io.IOException;
import java.io.OutputStream;
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

import com.analogics.dao.LoadSurveyDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.LoadSurvey;
import com.analogics.vo.LoadSurveyLatest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class LoadSurveyController {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	CommonDAO commonDaoObj = new CommonDAO();
	LoadSurveyDao loadSurveyDaoObj = new LoadSurveyDao();
	
	@RequestMapping("/viewLoadSurveyData")
	public ModelAndView viewLoadSurveyData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") LoadSurvey dataObj) {
		ModelAndView model = new ModelAndView("Masters/LoadSurvey/ViewLoadSurveyDataDetails",
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
//			model.addObject("command", fetchInstantDataColumsMap(dataObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchLoadSurveyDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchLoadSurveyDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") LoadSurvey dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<LoadSurvey> dataList = new ArrayList<LoadSurvey>();
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
				dataList = loadSurveyDaoObj.fetchLoadSurveyDataList(pageNumber,
						Integer.parseInt(pageDisplayLength),dataObj,levelIndexObj);
				count = loadSurveyDaoObj.fetchLoadSurveyDataDetailsCount(dataObj,levelIndexObj);
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
	
	
	@RequestMapping("/viewLoadSurveyDataLatest")
	public ModelAndView viewLoadSurveyDataLatest(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") LoadSurveyLatest dataObj) {
		ModelAndView model = new ModelAndView("Masters/LoadSurvey/ViewLoadSurveyDataLatestDetails",
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
//			model.addObject("command", fetchInstantDataColumsMap(dataObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchLoadSurveyDataLatestDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchLoadSurveyDataLatestDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") LoadSurveyLatest dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<LoadSurveyLatest> dataList = new ArrayList<LoadSurveyLatest>();
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
				dataList = loadSurveyDaoObj.fetchLoadSurveyLatestDataList(pageNumber,
						Integer.parseInt(pageDisplayLength), dataObj,levelIndexObj);
				count = loadSurveyDaoObj.fetchLoadSurveyDataLatestDetailsCount(dataObj,levelIndexObj);
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
	
	@RequestMapping("exportLoadSurveyDetails")
	@ResponseBody
	public void exportLoadSurveyDetails(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")LoadSurvey masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj
		){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "LoadSurveyMasterDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportLoadSurveyHeader());
			utilsObj.appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<LoadSurvey> dataList = new ArrayList<LoadSurvey>();
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			Long totalRecords=loadSurveyDaoObj.fetchLoadSurveyDataDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords );
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = loadSurveyDaoObj.fetchLoadSurveyDataList(i-1,
							records,
							masterObj,levelIndexObj);
								for (LoadSurvey fieldObj : dataList) {
									
									if(fieldObj.getId().getMeterNumber() != null && !fieldObj.getId().getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getId().getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getId().getIntervalDateTime() != null ){
										dataStr.append(fieldObj.getId().getIntervalDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getIntervalNo() != null){
										dataStr.append(fieldObj.getIntervalNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergy() != null && !fieldObj.getActiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
											if(fieldObj.getActiveEnergyImport() != null && !fieldObj.getActiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL1() != null && !fieldObj.getActiveEnergyImportL1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL2() != null && !fieldObj.getActiveEnergyImportL2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL3() != null && !fieldObj.getActiveEnergyImportL3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT1() != null && !fieldObj.getActiveEnergyImportT1() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportT2() != null && !fieldObj.getActiveEnergyImportT2() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getActiveEnergyImportT3() != null && !fieldObj.getActiveEnergyImportT3().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getActiveEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
										if(fieldObj.getActiveEnergyImportT4() != null && !fieldObj.getActiveEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
														if(fieldObj.getActiveEnergyImportT5() != null && !fieldObj.getActiveEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT6() != null && !fieldObj.getActiveEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergyImportT7() != null && !fieldObj.getActiveEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT8() != null && !fieldObj.getActiveEnergyImportT8() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergyExport() != null && !fieldObj.getActiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT1() != null && !fieldObj.getActiveEnergyExportT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
										if(fieldObj.getActiveEnergyExportT2() != null && !fieldObj.getActiveEnergyExportT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT3() != null && !fieldObj.getActiveEnergyExportT3() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT4() != null && !fieldObj.getActiveEnergyExportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getActiveEnergyExportT5() != null && !fieldObj.getActiveEnergyExportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyExportT6() != null && !fieldObj.getActiveEnergyExportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT7() != null && !fieldObj.getActiveEnergyExportT7() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT8() != null && !fieldObj.getActiveEnergyExportT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getActiveEnergyCombinedTotal() != null && !fieldObj.getActiveEnergyCombinedTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT1() != null && !fieldObj.getActiveEnergyCombinedTotalT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT2() != null && !fieldObj.getActiveEnergyCombinedTotalT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT3() != null && !fieldObj.getActiveEnergyCombinedTotalT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT4() != null && !fieldObj.getActiveEnergyCombinedTotalT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT5() != null && !fieldObj.getActiveEnergyCombinedTotalT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT6() != null && !fieldObj.getActiveEnergyCombinedTotalT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT7() != null && !fieldObj.getActiveEnergyCombinedTotalT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT8() != null && !fieldObj.getActiveEnergyCombinedTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotal() != null && !fieldObj.getActiveEnergyNetTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT1() != null && !fieldObj.getActiveEnergyNetTotalT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT2() != null && !fieldObj.getActiveEnergyNetTotalT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT3() != null && !fieldObj.getActiveEnergyNetTotalT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT4() != null && !fieldObj.getActiveEnergyNetTotalT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT5() != null && !fieldObj.getActiveEnergyNetTotalT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT6() != null && !fieldObj.getActiveEnergyNetTotalT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotalT7() != null && !fieldObj.getActiveEnergyNetTotalT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT8() != null && !fieldObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyImport() != null && !fieldObj.getReactiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyExport() != null && !fieldObj.getReactiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotalT8() != null && !fieldObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ1() != null && !fieldObj.getReactiveEnergyQ1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ2() != null && !fieldObj.getReactiveEnergyQ2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ3() != null && !fieldObj.getReactiveEnergyQ3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ4() != null && !fieldObj.getReactiveEnergyQ4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergy() != null && !fieldObj.getApparentEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImport() != null && !fieldObj.getApparentEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT1() != null && !fieldObj.getApparentEnergyImportT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT2() != null && !fieldObj.getApparentEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT3() != null && !fieldObj.getApparentEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getApparentEnergyImportT4() != null && !fieldObj.getApparentEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT5() != null && !fieldObj.getApparentEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT6() != null && !fieldObj.getApparentEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT7() != null && !fieldObj.getApparentEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT8() != null && !fieldObj.getApparentEnergyImportT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getApparentEnergyExport() != null && !fieldObj.getApparentEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
								
								}
				}
				utilsObj.appendFileData(folderPath, fileName, dataStr.toString(),response);

		        outputStream.write(dataStr.toString().getBytes());
		        outputStream.flush();
		        outputStream.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	
	
	@RequestMapping("exportLoadSurveyLatestDetails")
	@ResponseBody
	public void exportLoadSurveyLatestDetails(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")LoadSurveyLatest masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj
		){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "LoadSurveyMasterLatestDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportLoadSurveyLatestHeader());
			utilsObj.appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<LoadSurveyLatest> dataList = new ArrayList<LoadSurveyLatest>();
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			Long totalRecords=loadSurveyDaoObj.fetchLoadSurveyDataLatestDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords );
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = loadSurveyDaoObj.fetchLoadSurveyLatestDataList(i-1,
							records,
							masterObj,levelIndexObj);
								for (LoadSurveyLatest fieldObj : dataList) {
									
									if(fieldObj.getMeterNumber() != null && !fieldObj.getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getIntervalDateTime() != null ){
										dataStr.append(fieldObj.getIntervalDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getIntervalNo() != null){
										dataStr.append(fieldObj.getIntervalNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergy() != null && !fieldObj.getActiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
											if(fieldObj.getActiveEnergyImport() != null && !fieldObj.getActiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL1() != null && !fieldObj.getActiveEnergyImportL1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL2() != null && !fieldObj.getActiveEnergyImportL2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportL3() != null && !fieldObj.getActiveEnergyImportL3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT1() != null && !fieldObj.getActiveEnergyImportT1() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyImportT2() != null && !fieldObj.getActiveEnergyImportT2() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getActiveEnergyImportT3() != null && !fieldObj.getActiveEnergyImportT3().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getActiveEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
										if(fieldObj.getActiveEnergyImportT4() != null && !fieldObj.getActiveEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
														if(fieldObj.getActiveEnergyImportT5() != null && !fieldObj.getActiveEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT6() != null && !fieldObj.getActiveEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergyImportT7() != null && !fieldObj.getActiveEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyImportT8() != null && !fieldObj.getActiveEnergyImportT8() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveEnergyExport() != null && !fieldObj.getActiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT1() != null && !fieldObj.getActiveEnergyExportT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
										if(fieldObj.getActiveEnergyExportT2() != null && !fieldObj.getActiveEnergyExportT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT3() != null && !fieldObj.getActiveEnergyExportT3() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT4() != null && !fieldObj.getActiveEnergyExportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getActiveEnergyExportT5() != null && !fieldObj.getActiveEnergyExportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyExportT6() != null && !fieldObj.getActiveEnergyExportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT7() != null && !fieldObj.getActiveEnergyExportT7() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyExportT8() != null && !fieldObj.getActiveEnergyExportT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getActiveEnergyCombinedTotal() != null && !fieldObj.getActiveEnergyCombinedTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT1() != null && !fieldObj.getActiveEnergyCombinedTotalT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT2() != null && !fieldObj.getActiveEnergyCombinedTotalT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT3() != null && !fieldObj.getActiveEnergyCombinedTotalT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT4() != null && !fieldObj.getActiveEnergyCombinedTotalT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT5() != null && !fieldObj.getActiveEnergyCombinedTotalT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT6() != null && !fieldObj.getActiveEnergyCombinedTotalT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT7() != null && !fieldObj.getActiveEnergyCombinedTotalT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyCombinedTotalT8() != null && !fieldObj.getActiveEnergyCombinedTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotal() != null && !fieldObj.getActiveEnergyNetTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT1() != null && !fieldObj.getActiveEnergyNetTotalT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT2() != null && !fieldObj.getActiveEnergyNetTotalT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT3() != null && !fieldObj.getActiveEnergyNetTotalT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT4() != null && !fieldObj.getActiveEnergyNetTotalT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT5() != null && !fieldObj.getActiveEnergyNetTotalT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT6() != null && !fieldObj.getActiveEnergyNetTotalT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotalT7() != null && !fieldObj.getActiveEnergyNetTotalT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveEnergyNetTotalT8() != null && !fieldObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyImport() != null && !fieldObj.getReactiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyExport() != null && !fieldObj.getReactiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getActiveEnergyNetTotalT8() != null && !fieldObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ1() != null && !fieldObj.getReactiveEnergyQ1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ2() != null && !fieldObj.getReactiveEnergyQ2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ3() != null && !fieldObj.getReactiveEnergyQ3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getReactiveEnergyQ4() != null && !fieldObj.getReactiveEnergyQ4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyQ4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergy() != null && !fieldObj.getApparentEnergy().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImport() != null && !fieldObj.getApparentEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT1() != null && !fieldObj.getApparentEnergyImportT1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT2() != null && !fieldObj.getApparentEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT3() != null && !fieldObj.getApparentEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getApparentEnergyImportT4() != null && !fieldObj.getApparentEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT5() != null && !fieldObj.getApparentEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT6() != null && !fieldObj.getApparentEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT7() != null && !fieldObj.getApparentEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentEnergyImportT8() != null && !fieldObj.getApparentEnergyImportT8().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getApparentEnergyExport() != null && !fieldObj.getApparentEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
								
								}
				}
				utilsObj.appendFileData(folderPath, fileName, dataStr.toString(),response);

		        outputStream.write(dataStr.toString().getBytes());
		        outputStream.flush();
		        outputStream.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	private Object ExportLoadSurveyLatestHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("Meter Number,");
			sb.append("Interval Date Time,");
			sb.append("Interval No,");
			sb.append("Active Energy,");
			sb.append("Active Energy Import,");
			sb.append("Active Energy ImportL1,");
			sb.append("Active Energy ImportL2,");
			sb.append("Active Energy ImportL3,");
			sb.append("Active Energy Import T1,");
			sb.append("Active Energy Import T2,");
			sb.append("Active Energy Import T3,");
			sb.append("Active Energy Import T4,");
			sb.append("Active Energy Import T5,");
			sb.append("Active Energy Import T6,");
			sb.append("Active Energy Import T7,");
			sb.append("Active Energy Import T8,");
			sb.append("Active Energy Export,");
			sb.append("Active Energy Export L1,");
			sb.append("Active Energy Export L2,");
			sb.append("Active Energy Export L3,");
			sb.append("Active Energy Export T1,");
			sb.append("Active Energy Export T2,");
			sb.append("Active Energy Export T3,");
			sb.append("Active Energy Export T4,");
			sb.append("Active Energy Export T5,");
			sb.append("Active Energy Export T6,");
			sb.append("Active Energy Export T7,");
			sb.append("Active Energy Export T8,");
			sb.append("Active Energy Combined Total,");
			sb.append("Active Energy Combined Total T1,");
			sb.append("Active Energy Combined Total T2,");
			sb.append("Active Energy Combined Total T3,");
			sb.append("Active Energy Combined Total T4,");
			sb.append("Active Energy Combined Total T5,");
			sb.append("Active Energy Combined Total T6,");
			sb.append("Active Energy Combined Total T7,");
			sb.append("Active Energy Combined Total T8,");
			sb.append("Active Energy Net Total,");
			sb.append("Active Energy Net Total T1,");
			sb.append("Active Energy Net Total T2,");
			sb.append("Active Energy Net Total T3,");
			sb.append("Active Energy Net Total T4,");
			sb.append("Active Energy Net Total T5,");
			sb.append("Active Energy Net Total T6,");
			sb.append("Active Energy Net Total T7,");
			sb.append("Active Energy Net Total T8,");
			sb.append("Reactive Energy,");
			sb.append("Reactive Energy Import,");
			sb.append("Reactive Energy Export,");
			sb.append("Reactive Energy Q1,");
			sb.append("Reactive Energy Q2,");
			sb.append("Reactive Energy Q3,");
			sb.append("Reactive Energy Q4,");
			sb.append("Apparent Energy,");
			sb.append("Apparent Energy Import,");
			sb.append("Apparent Energy Import T1,");
			sb.append("Apparent Energy Import T2,");
			sb.append("Apparent Energy Import T3,");
			sb.append("Apparent Energy Import T4,");
			sb.append("Apparent Energy Import T5,");
			sb.append("Apparent Energy Import T6,");
			sb.append("Apparent Energy Import T7,");
			sb.append("Apparent Energy Import T8,");
			sb.append("Apparent Energy Export"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}
	private Object ExportLoadSurveyHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("Meter Number,");
			sb.append("Interval Date Time,");
			sb.append("Interval No,");
			sb.append("Active Energy,");
			sb.append("Active Energy Import,");
			sb.append("Active Energy ImportL1,");
			sb.append("Active Energy ImportL2,");
			sb.append("Active Energy ImportL3,");
			sb.append("Active Energy Import T1,");
			sb.append("Active Energy Import T2,");
			sb.append("Active Energy Import T3,");
			sb.append("Active Energy Import T4,");
			sb.append("Active Energy Import T5,");
			sb.append("Active Energy Import T6,");
			sb.append("Active Energy Import T7,");
			sb.append("Active Energy Import T8,");
			sb.append("Active Energy Export,");
			sb.append("Active Energy Export L1,");
			sb.append("Active Energy Export L2,");
			sb.append("Active Energy Export L3,");
			sb.append("Active Energy Export T1,");
			sb.append("Active Energy Export T2,");
			sb.append("Active Energy Export T3,");
			sb.append("Active Energy Export T4,");
			sb.append("Active Energy Export T5,");
			sb.append("Active Energy Export T6,");
			sb.append("Active Energy Export T7,");
			sb.append("Active Energy Export T8,");
			sb.append("Active Energy Combined Total,");
			sb.append("Active Energy Combined Total T1,");
			sb.append("Active Energy Combined Total T2,");
			sb.append("Active Energy Combined Total T3,");
			sb.append("Active Energy Combined Total T4,");
			sb.append("Active Energy Combined Total T5,");
			sb.append("Active Energy Combined Total T6,");
			sb.append("Active Energy Combined Total T7,");
			sb.append("Active Energy Combined Total T8,");
			sb.append("Active Energy Net Total,");
			sb.append("Active Energy Net Total T1,");
			sb.append("Active Energy Net Total T2,");
			sb.append("Active Energy Net Total T3,");
			sb.append("Active Energy Net Total T4,");
			sb.append("Active Energy Net Total T5,");
			sb.append("Active Energy Net Total T6,");
			sb.append("Active Energy Net Total T7,");
			sb.append("Active Energy Net Total T8,");
			sb.append("Reactive Energy,");
			sb.append("Reactive Energy Import,");
			sb.append("Reactive Energy Export,");
			sb.append("Reactive Energy Q1,");
			sb.append("Reactive Energy Q2,");
			sb.append("Reactive Energy Q3,");
			sb.append("Reactive Energy Q4,");
			sb.append("Apparent Energy,");
			sb.append("Apparent Energy Import,");
			sb.append("Apparent Energy Import T1,");
			sb.append("Apparent Energy Import T2,");
			sb.append("Apparent Energy Import T3,");
			sb.append("Apparent Energy Import T4,");
			sb.append("Apparent Energy Import T5,");
			sb.append("Apparent Energy Import T6,");
			sb.append("Apparent Energy Import T7,");
			sb.append("Apparent Energy Import T8,");
			sb.append("Apparent Energy Export"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}
	
}
