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

import com.analogics.dao.DailySnapshotDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.DailySnapshot;
import com.analogics.vo.DailySnapshotLatest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class DailySnapshotController {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	CommonDAO commonDaoObj = new CommonDAO();
	DailySnapshotDao daoObj = new DailySnapshotDao();
	
	
	
	@RequestMapping("/viewDailySnapshotData")
	public ModelAndView viewDailySnapshotData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") DailySnapshot dataObj) {
		ModelAndView model = new ModelAndView("Masters/DailySnapshot/ViewDailySnapshotDataDetails",
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
	@RequestMapping(value = "/fetchDailySnapshotDataDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchDailySnapshotDataDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") DailySnapshot dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<DailySnapshot> dataList = new ArrayList<DailySnapshot>();
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
				dataList = daoObj.fetchDailySnapshotDataList(pageNumber,
						Integer.parseInt(pageDisplayLength),
						dataObj,levelIndexObj);
				count = daoObj.fetchDailySnapshotDetailsCount(
						dataObj,levelIndexObj);
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
	
	
	@RequestMapping("/viewDailySnapshotLatestData")
	public ModelAndView viewDailySnapshotLatestData(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("dataObj") DailySnapshotLatest dataObj) {
		ModelAndView model = new ModelAndView("Masters/DailySnapshot/ViewDailySnapshotLatestDataDetails",
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
	@RequestMapping(value = "/fetchDailySnapshotDataLatestDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchDailySnapshotDataLatestDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("dataObj") DailySnapshotLatest dataObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<DailySnapshotLatest> dataList = new ArrayList<DailySnapshotLatest>();
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
				dataList = daoObj.fetchDailySnapshotLatestDataList(pageNumber,
						Integer.parseInt(pageDisplayLength),dataObj,levelIndexObj);
				count = daoObj.fetchDailySnapshotLatestDetailsCount(dataObj,levelIndexObj);
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
	
	@RequestMapping("exportDailySnapshot")
	@ResponseBody
	public void exportDailySnapshot(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")DailySnapshot masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj
		){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "DailySnapshotMasterDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportFieldInstallationHeader());
			utilsObj.appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<DailySnapshot> dataList = new ArrayList<DailySnapshot>();
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			Long totalRecords=daoObj.fetchDailySnapshotDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords );
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = daoObj.fetchDailySnapshotDataList(i-1,
							records,
							masterObj,levelIndexObj);
								for (DailySnapshot fieldObj : dataList) {
									if(fieldObj.getId().getMeterNumber() != null && !fieldObj.getId().getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getId().getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getId().getSnapshotDateTime() != null ){
										dataStr.append(fieldObj.getId().getSnapshotDateTime() + ",");
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
									
											if(fieldObj.getActiveEnergyExport() != null && !fieldObj.getActiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyCombinedTotal() != null && !fieldObj.getActiveEnergyCombinedTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyNetTotal() != null && !fieldObj.getActiveEnergyNetTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getReactiveEnergyImport() != null && !fieldObj.getReactiveEnergyImport() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getReactiveEnergyExport() != null && !fieldObj.getReactiveEnergyExport().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getApparentEnergyExport() != null && !fieldObj.getApparentEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
														if(fieldObj.getApparentEnergyImport() != null && !fieldObj.getApparentEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemand() != null && !fieldObj.getActiveDemand().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemand() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveDemandImport() != null && !fieldObj.getActiveDemandImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandImportOccTime() != null && !fieldObj.getActiveDemandImportOccTime() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandImportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandExport() != null && !fieldObj.getActiveDemandExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandExportOccTime() != null && !fieldObj.getActiveDemandExportOccTime().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandExportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									///
									
									if(fieldObj.getApparentDemandImport() != null && !fieldObj.getApparentDemandImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandImportOccTime() != null && !fieldObj.getApparentDemandImportOccTime() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandImportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandExport() != null && !fieldObj.getApparentDemandExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandExportOccTime() != null && !fieldObj.getApparentDemandExportOccTime().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandExportOccTime() + ",");
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
	
	
	
	private Object ExportFieldInstallationHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("Meter Number,");
			sb.append("Snapshot Date Time,");
			sb.append("intervalNo,");
			sb.append("activeEnergy,");
			sb.append("activeEnergyImport,");
			sb.append("activeEnergyExport,");
			sb.append("activeEnergyCombinedTotal,");
			sb.append("activeEnergyNetTotal,");
			sb.append("reactiveEnergy,");
			sb.append("reactiveEnergyImport,");
			sb.append("reactiveEnergyExport,");
			sb.append("apparentEnergy,");
			sb.append("apparentEnergyImport,");
			sb.append("apparentEnergyExport,");
			sb.append("activeDemand,");
			sb.append("activeDemandImport,");
			sb.append("activeDemandImportOccTime,");
			sb.append("activeDemandExport,");
			sb.append("activeDemandExportOccTime,");
			sb.append("apparentDemand,");
			sb.append("apparentDemandImport,");
			sb.append("apparentDemandImportOccTime,");
			sb.append("apparentDemandExport,");
			sb.append("apparentDemandExportOccTime"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}
	
	@RequestMapping("exportDailySnapshotLatest")
	@ResponseBody
	public void exportDailySnapshotLatest(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")DailySnapshotLatest masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj
		){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "DailySnapshotLatestMasterDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportFieldInstallationHeader());
			utilsObj.appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<DailySnapshotLatest> dataList = new ArrayList<DailySnapshotLatest>();
			Map<String,Integer> levelMap=new HashMap<String,Integer>();
			LevelIndexMaster levelIndexObj = new LevelIndexMaster();
			utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
			levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
			Long totalRecords=daoObj.fetchDailySnapshotLatestDetailsCount(masterObj,levelIndexObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords );
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = daoObj.fetchDailySnapshotLatestDataList(i-1,
							records,
							masterObj,levelIndexObj);
								for (DailySnapshotLatest fieldObj : dataList) {
									if(fieldObj.getMeterNumber() != null && !fieldObj.getMeterNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getSnapshotDateTime() != null ){
										dataStr.append(fieldObj.getSnapshotDateTime() + ",");
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
									
											if(fieldObj.getActiveEnergyExport() != null && !fieldObj.getActiveEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyCombinedTotal() != null && !fieldObj.getActiveEnergyCombinedTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyCombinedTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getActiveEnergyNetTotal() != null && !fieldObj.getActiveEnergyNetTotal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveEnergyNetTotal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getReactiveEnergy() != null && !fieldObj.getReactiveEnergy() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergy() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
												if(fieldObj.getReactiveEnergyImport() != null && !fieldObj.getReactiveEnergyImport() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getReactiveEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getReactiveEnergyExport() != null && !fieldObj.getReactiveEnergyExport().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getReactiveEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
													if(fieldObj.getApparentEnergyExport() != null && !fieldObj.getApparentEnergyExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
														if(fieldObj.getApparentEnergyImport() != null && !fieldObj.getApparentEnergyImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentEnergyImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemand() != null && !fieldObj.getActiveDemand().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemand() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
										if(fieldObj.getActiveDemandImport() != null && !fieldObj.getActiveDemandImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandImportOccTime() != null && !fieldObj.getActiveDemandImportOccTime() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandImportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandExport() != null && !fieldObj.getActiveDemandExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getActiveDemandExportOccTime() != null && !fieldObj.getActiveDemandExportOccTime().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getActiveDemandExportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									///
									
									if(fieldObj.getApparentDemandImport() != null && !fieldObj.getApparentDemandImport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandImport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandImportOccTime() != null && !fieldObj.getApparentDemandImportOccTime() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandImportOccTime() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandExport() != null && !fieldObj.getApparentDemandExport().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandExport() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getApparentDemandExportOccTime() != null && !fieldObj.getApparentDemandExportOccTime().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getApparentDemandExportOccTime() + ",");
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
}
