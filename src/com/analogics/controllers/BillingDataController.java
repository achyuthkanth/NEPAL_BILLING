package com.analogics.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
				count = masterDaoObj.fetchBillingDataDetailsCount(dataObj,levelIndexObj);
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
				count = masterDaoObj.fetchLatestBillingDataDetailsCount(dataObj,levelIndexObj);
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
	
	
	@RequestMapping("exportBillingData")
	@ResponseBody
	public void exportBillingData(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")BillingData masterObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "BillingDataDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportBillingDataHeader());
			appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<BillingData> dataList = new ArrayList<BillingData>();
			
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			
			Long totalRecords=masterDaoObj.fetchBillingDataDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords);
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = masterDaoObj.fetchBillingDataList(i-1,
							records, null,null,
							masterObj,levelIndexObj);
								for (BillingData dataObj : dataList) {
									if(dataObj.getId().getMeterNumber() != null && !dataObj.getId().getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(dataObj.getId().getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getId().getMdresetDateTime() != null){
										dataStr.append(dataObj.getId().getMdresetDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getMeterDateTime() != null){
										dataStr.append(dataObj.getMeterDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getIntervalNo() != null){
										dataStr.append(dataObj.getIntervalNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergy() != null && !dataObj.getActiveEnergy().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImport() != null && !dataObj.getActiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL1() != null && !dataObj.getActiveEnergyImportL1().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL2() != null && !dataObj.getActiveEnergyImportL2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL3() != null && !dataObj.getActiveEnergyImportL3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyImportT1()!= null && !dataObj.getActiveEnergyImportT1().equalsIgnoreCase("")) {
										dataStr.append(dataObj.getActiveEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyImportT2() != null && !dataObj.getActiveEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT3() != null && !dataObj.getActiveEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT4()!= null && !dataObj.getActiveEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT5() != null && !dataObj.getActiveEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT6() != null && !dataObj.getActiveEnergyImportT6() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT7()!= null && !dataObj.getActiveEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT8() != null && !dataObj.getActiveEnergyImportT8().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyExport() != null && !dataObj.getActiveEnergyExport() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL1() != null  && !dataObj.getActiveEnergyExportL1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL2() != null && !dataObj.getActiveEnergyExportL2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL3() != null && !dataObj.getActiveEnergyExportL3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT1() != null && !dataObj.getActiveEnergyExportT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT2() != null && !dataObj.getActiveEnergyExportT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT3() != null && !dataObj.getActiveEnergyExportT3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT4() != null && !dataObj.getActiveEnergyExportT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT5() != null && !dataObj.getActiveEnergyExportT5() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT6() != null && !dataObj.getActiveEnergyExportT6()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT7() != null && !dataObj.getActiveEnergyExportT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT8() != null && !dataObj.getActiveEnergyExportT8() .equalsIgnoreCase("") ){
										dataStr.append(dataObj.getActiveEnergyExportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotal() != null && !dataObj.getActiveEnergyCombinedTotal() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT1() != null && !dataObj.getActiveEnergyCombinedTotalT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT2() != null && dataObj.getActiveEnergyCombinedTotalT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT3() != null && !dataObj.getActiveEnergyCombinedTotalT3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT4() != null && !dataObj.getActiveEnergyCombinedTotalT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT5() != null && !dataObj.getActiveEnergyCombinedTotalT5()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT6() != null && !dataObj.getActiveEnergyCombinedTotalT6()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT7() != null && !dataObj.getActiveEnergyCombinedTotalT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT8() != null && !dataObj.getActiveEnergyCombinedTotalT8() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotal() != null && !dataObj.getActiveEnergyNetTotal() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT1() != null && !dataObj.getActiveEnergyNetTotalT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT2() != null && !dataObj.getActiveEnergyNetTotalT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT3() != null && !dataObj.getActiveEnergyNetTotalT3()  .equalsIgnoreCase("") ){
										dataStr.append(dataObj.getActiveEnergyNetTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT4() != null && !dataObj.getActiveEnergyNetTotalT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT5() != null && !dataObj.getActiveEnergyNetTotalT5() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT6() != null && !dataObj.getActiveEnergyNetTotalT6() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT7() != null && !dataObj.getActiveEnergyNetTotalT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT8() != null && !dataObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergy() != null && !dataObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyImport() != null && !dataObj.getReactiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyExport()!= null && !dataObj.getReactiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ1() != null && !dataObj.getReactiveEnergyQ1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ1() != null && !dataObj.getReactiveEnergyQ1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ2() != null && !dataObj.getReactiveEnergyQ2().equalsIgnoreCase("") ){
										dataStr.append(dataObj.getReactiveEnergyQ2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ3() != null && !dataObj.getReactiveEnergyQ3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ4() != null && !dataObj.getReactiveEnergyQ4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergy() != null && !dataObj.getApparentEnergy() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImport() != null && !dataObj.getApparentEnergyImport() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT1() != null && !dataObj.getApparentEnergyImportT1().equalsIgnoreCase("")) {
										dataStr.append(dataObj.getApparentEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT2() != null && !dataObj.getApparentEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT3() != null && !dataObj.getApparentEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT4() != null && !dataObj.getApparentEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT5() != null && !dataObj.getApparentEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT6() != null && !dataObj.getApparentEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT7() != null  && !dataObj.getApparentEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT8() != null && !dataObj.getApparentEnergyImportT8() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT8() + "\n");
									}else{
										dataStr.append("-"+ "\n");
									}
								
								}
				}
				appendFileData(folderPath, fileName, dataStr.toString(),response);

		        outputStream.write(dataStr.toString().getBytes());
		        outputStream.flush();
		        outputStream.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	

	private Object ExportBillingDataHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("METER NUMBER,");
			sb.append("MD RESET DATE TIME,");
			sb.append("METER DATE TIME,");
			sb.append("INTERVAL NO,");
			sb.append("ACTIVE ENERGY,");
			sb.append("ACTIVE ENERGY IMPORT,");
			sb.append("ACTIVE ENERGY IMPORT L1,");
			sb.append("ACTIVE ENERGY IMPORT L2,");
			sb.append("ACTIVE ENERGY IMPORT L3,");
			sb.append("ACTIVE ENERGY IMPORT T1,");
			sb.append("ACTIVE ENERGY IMPORT T2,");
			sb.append("ACTIVE ENERGY IMPORT T3,");
			sb.append("ACTIVE ENERGY IMPORT T4,");
			sb.append("ACTIVE ENERGY IMPORT T5,");
			sb.append("ACTIVE ENERGY IMPORT T6,");
			sb.append("ACTIVE ENERGY IMPORT T7,");
			sb.append("ACTIVE ENERGY IMPORT T8,");
			sb.append("ACTIVE ENERGY EXPORT,");
			sb.append("ACTIVE ENERGY EXPORT L1,");
			sb.append("ACTIVE ENERGY EXPORT L2,");
			sb.append("ACTIVE ENERGY EXPORT L3,");
			sb.append("ACTIVE ENERGY EXPORT T1,");
			sb.append("ACTIVE ENERGY EXPORT T2,");
			sb.append("ACTIVE ENERGY EXPORT T3,");
			sb.append("ACTIVE ENERGY EXPORT T4,");
			sb.append("ACTIVE ENERGY EXPORT T5,");
			sb.append("ACTIVE ENERGY EXPORT T6,");
			sb.append("ACTIVE ENERGY EXPORT T7,");
			sb.append("ACTIVE ENERGY EXPORT T8,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T1,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T2,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T3,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T4,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T5,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T6,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T7,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T8,");
			sb.append("ACTIVE ENERGY NETTOTAL,");
			sb.append("ACTIVE ENERGY NETTOTALT1,");
			sb.append("ACTIVE ENERGY NETTOTALT2,");
			sb.append("ACTIVE ENERGY NETTOTALT3,");
			sb.append("ACTIVE ENERGY NETTOTALT4,");
			sb.append("ACTIVE ENERGY NETTOTALT5,");
			sb.append("ACTIVE ENERGY NETTOTALT6,");
			sb.append("ACTIVE ENERGY NETTOTALT7,");
			sb.append("ACTIVE ENERGY NETTOTALT8,");
			sb.append("REACTIVE ENERGY,");
			sb.append("REACTIVE ENERGY IMPORT,");
			sb.append("REACTIVE ENERGY EXPORT,");
			sb.append("REACTIVE ENERGY Q1,");
			sb.append("REACTIVE ENERGY Q2,");
			sb.append("REACTIVE ENERGY Q3,");
			sb.append("REACTIVE ENERGY Q4,");
			sb.append("APPARENT ENERGY,");
			sb.append("APPARENT ENERGY IMPORT,");
			sb.append("APPARENT ENERGY IMPORT T1,");
			sb.append("APPARENT ENERGY IMPORT T2,");
			sb.append("APPARENT ENERGY IMPORT T3,");
			sb.append("APPARENT ENERGY IMPORT T4,");
			sb.append("APPARENT ENERGY IMPORT T5,");
			sb.append("APPARENT ENERGY IMPORT T6,");
			sb.append("APPARENT ENERGY IMPORT T7,");
			sb.append("APPARENT ENERGY IMPORT T8"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}
	
	
	
	@RequestMapping("exportLatestBillingData")
	@ResponseBody
	public void exportLatestBillingData(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")BillingDataLatest masterObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "BillingLatestDataDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportBillingLatestDataHeader());
			appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<BillingDataLatest> dataList = new ArrayList<BillingDataLatest>();
			
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);

			Long totalRecords=masterDaoObj.fetchLatestBillingDataDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords);
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = masterDaoObj.fetchLatestBillingDataList(i-1,
							records, null,null,
							masterObj,levelIndexObj);
								for (BillingDataLatest dataObj : dataList) {
									if(dataObj.getMeterNumber() != null && !dataObj.getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(dataObj.getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getMdresetDateTime() != null){
										dataStr.append(dataObj.getMdresetDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getMeterDateTime() != null){
										dataStr.append(dataObj.getMeterDateTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getIntervalNo() != null){
										dataStr.append(dataObj.getIntervalNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergy() != null && !dataObj.getActiveEnergy().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImport() != null && !dataObj.getActiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL1() != null && !dataObj.getActiveEnergyImportL1().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL2() != null && !dataObj.getActiveEnergyImportL2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportL3() != null && !dataObj.getActiveEnergyImportL3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyImportT1()!= null && !dataObj.getActiveEnergyImportT1().equalsIgnoreCase("")) {
										dataStr.append(dataObj.getActiveEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyImportT2() != null && !dataObj.getActiveEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT3() != null && !dataObj.getActiveEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT4()!= null && !dataObj.getActiveEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT5() != null && !dataObj.getActiveEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT6() != null && !dataObj.getActiveEnergyImportT6() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT7()!= null && !dataObj.getActiveEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyImportT8() != null && !dataObj.getActiveEnergyImportT8().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyImportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(dataObj.getActiveEnergyExport() != null && !dataObj.getActiveEnergyExport() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL1() != null  && !dataObj.getActiveEnergyExportL1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL2() != null && !dataObj.getActiveEnergyExportL2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportL3() != null && !dataObj.getActiveEnergyExportL3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportL3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT1() != null && !dataObj.getActiveEnergyExportT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT2() != null && !dataObj.getActiveEnergyExportT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT3() != null && !dataObj.getActiveEnergyExportT3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT4() != null && !dataObj.getActiveEnergyExportT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT5() != null && !dataObj.getActiveEnergyExportT5() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT6() != null && !dataObj.getActiveEnergyExportT6()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT7() != null && !dataObj.getActiveEnergyExportT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyExportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyExportT8() != null && !dataObj.getActiveEnergyExportT8() .equalsIgnoreCase("") ){
										dataStr.append(dataObj.getActiveEnergyExportT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotal() != null && !dataObj.getActiveEnergyCombinedTotal() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT1() != null && !dataObj.getActiveEnergyCombinedTotalT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT2() != null && dataObj.getActiveEnergyCombinedTotalT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT3() != null && !dataObj.getActiveEnergyCombinedTotalT3() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT4() != null && !dataObj.getActiveEnergyCombinedTotalT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT5() != null && !dataObj.getActiveEnergyCombinedTotalT5()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT6() != null && !dataObj.getActiveEnergyCombinedTotalT6()  .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT7() != null && !dataObj.getActiveEnergyCombinedTotalT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyCombinedTotalT8() != null && !dataObj.getActiveEnergyCombinedTotalT8() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyCombinedTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotal() != null && !dataObj.getActiveEnergyNetTotal() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT1() != null && !dataObj.getActiveEnergyNetTotalT1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT2() != null && !dataObj.getActiveEnergyNetTotalT2() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT3() != null && !dataObj.getActiveEnergyNetTotalT3()  .equalsIgnoreCase("") ){
										dataStr.append(dataObj.getActiveEnergyNetTotalT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT4() != null && !dataObj.getActiveEnergyNetTotalT4() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT5() != null && !dataObj.getActiveEnergyNetTotalT5() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT6() != null && !dataObj.getActiveEnergyNetTotalT6() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT7() != null && !dataObj.getActiveEnergyNetTotalT7() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getActiveEnergyNetTotalT8() != null && !dataObj.getActiveEnergyNetTotalT8().equalsIgnoreCase("")){
										dataStr.append(dataObj.getActiveEnergyNetTotalT8() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergy() != null && !dataObj.getReactiveEnergy().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyImport() != null && !dataObj.getReactiveEnergyImport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyExport()!= null && !dataObj.getReactiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ1() != null && !dataObj.getReactiveEnergyQ1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ1() != null && !dataObj.getReactiveEnergyQ1() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ2() != null && !dataObj.getReactiveEnergyQ2().equalsIgnoreCase("") ){
										dataStr.append(dataObj.getReactiveEnergyQ2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ3() != null && !dataObj.getReactiveEnergyQ3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getReactiveEnergyQ4() != null && !dataObj.getReactiveEnergyQ4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getReactiveEnergyQ4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergy() != null && !dataObj.getApparentEnergy() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImport() != null && !dataObj.getApparentEnergyImport() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT1() != null && !dataObj.getApparentEnergyImportT1().equalsIgnoreCase("")) {
										dataStr.append(dataObj.getApparentEnergyImportT1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT2() != null && !dataObj.getApparentEnergyImportT2().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT3() != null && !dataObj.getApparentEnergyImportT3().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT3() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT4() != null && !dataObj.getApparentEnergyImportT4().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT4() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT5() != null && !dataObj.getApparentEnergyImportT5().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT5() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT6() != null && !dataObj.getApparentEnergyImportT6().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT6() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT7() != null  && !dataObj.getApparentEnergyImportT7().equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT7() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(dataObj.getApparentEnergyImportT8() != null && !dataObj.getApparentEnergyImportT8() .equalsIgnoreCase("")){
										dataStr.append(dataObj.getApparentEnergyImportT8() + "\n");
									}else{
										dataStr.append("-"+ "\n");
									}
								
								}
				}
				appendFileData(folderPath, fileName, dataStr.toString(),response);

		        outputStream.write(dataStr.toString().getBytes());
		        outputStream.flush();
		        outputStream.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	
	

	private Object ExportBillingLatestDataHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("METER NUMBER,");
			sb.append("MD RESET DATE TIME,");
			sb.append("METER DATE TIME,");
			sb.append("INTERVAL NO,");
			sb.append("ACTIVE ENERGY,");
			sb.append("ACTIVE ENERGY IMPORT,");
			sb.append("ACTIVE ENERGY IMPORT L1,");
			sb.append("ACTIVE ENERGY IMPORT L2,");
			sb.append("ACTIVE ENERGY IMPORT L3,");
			sb.append("ACTIVE ENERGY IMPORT T1,");
			sb.append("ACTIVE ENERGY IMPORT T2,");
			sb.append("ACTIVE ENERGY IMPORT T3,");
			sb.append("ACTIVE ENERGY IMPORT T4,");
			sb.append("ACTIVE ENERGY IMPORT T5,");
			sb.append("ACTIVE ENERGY IMPORT T6,");
			sb.append("ACTIVE ENERGY IMPORT T7,");
			sb.append("ACTIVE ENERGY IMPORT T8,");
			sb.append("ACTIVE ENERGY EXPORT,");
			sb.append("ACTIVE ENERGY EXPORT L1,");
			sb.append("ACTIVE ENERGY EXPORT L2,");
			sb.append("ACTIVE ENERGY EXPORT L3,");
			sb.append("ACTIVE ENERGY EXPORT T1,");
			sb.append("ACTIVE ENERGY EXPORT T2,");
			sb.append("ACTIVE ENERGY EXPORT T3,");
			sb.append("ACTIVE ENERGY EXPORT T4,");
			sb.append("ACTIVE ENERGY EXPORT T5,");
			sb.append("ACTIVE ENERGY EXPORT T6,");
			sb.append("ACTIVE ENERGY EXPORT T7,");
			sb.append("ACTIVE ENERGY EXPORT T8,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T1,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T2,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T3,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T4,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T5,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T6,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T7,");
			sb.append("ACTIVE ENERGY COMBINED TOTAL T8,");
			sb.append("ACTIVE ENERGY NETTOTAL,");
			sb.append("ACTIVE ENERGY NETTOTALT1,");
			sb.append("ACTIVE ENERGY NETTOTALT2,");
			sb.append("ACTIVE ENERGY NETTOTALT3,");
			sb.append("ACTIVE ENERGY NETTOTALT4,");
			sb.append("ACTIVE ENERGY NETTOTALT5,");
			sb.append("ACTIVE ENERGY NETTOTALT6,");
			sb.append("ACTIVE ENERGY NETTOTALT7,");
			sb.append("ACTIVE ENERGY NETTOTALT8,");
			sb.append("REACTIVE ENERGY,");
			sb.append("REACTIVE ENERGY IMPORT,");
			sb.append("REACTIVE ENERGY EXPORT,");
			sb.append("REACTIVE ENERGY Q1,");
			sb.append("REACTIVE ENERGY Q2,");
			sb.append("REACTIVE ENERGY Q3,");
			sb.append("REACTIVE ENERGY Q4,");
			sb.append("APPARENT ENERGY,");
			sb.append("APPARENT ENERGY IMPORT,");
			sb.append("APPARENT ENERGY IMPORT T1,");
			sb.append("APPARENT ENERGY IMPORT T2,");
			sb.append("APPARENT ENERGY IMPORT T3,");
			sb.append("APPARENT ENERGY IMPORT T4,");
			sb.append("APPARENT ENERGY IMPORT T5,");
			sb.append("APPARENT ENERGY IMPORT T6,");
			sb.append("APPARENT ENERGY IMPORT T7,");
			sb.append("APPARENT ENERGY IMPORT T8"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}
	
	
	private void appendFileData(String folderPath, String fileName,
			String data, HttpServletResponse response) {
		try {
  			File file = new File(folderPath, fileName);
  			if (!file.exists()) {
  				file.createNewFile();
  			}else {
  				file.delete();
  				file.createNewFile();
  			}
  			FileWriter fileWritter = new FileWriter(file, true);
  			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
  			bufferWritter.write(data);
  			bufferWritter.close();
  			
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
	}

}
