package com.analogics.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.dao.ConsumerMasterDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.ConsumerMaster;
import com.analogics.vo.ConsumerMeterMaster;
import com.analogics.vo.ConsumerMeterMasterId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Sandhya.B
 *
 */
@Controller
public class ConsumerMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	CommonDAO commonDaoObj = new CommonDAO();
	ConsumerMasterDao masterDaoObj = new ConsumerMasterDao();
	
	@RequestMapping("/consumerMasterDetails")
	public ModelAndView consumerMasterDetails(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj,
			@ModelAttribute("masterObj") ConsumerMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("Masters/ConsumerMaster/AddOrViewConsumerDetails",
					"command", masterObj);
			masterObj = masterDaoObj.fetchMeterNumberList(masterObj);
			HttpSession session=request.getSession();
			UserLoginDetails userSessionObj=(UserLoginDetails) session.getAttribute("sessionObj");
			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1")){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("masterObj", masterObj);
			model.addObject("command", fetchConsumerMasterColumsMap(masterObj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchConsumerMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchConsumerMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ConsumerMaster masterObj,
			@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ConsumerMaster> consumerList = new ArrayList<ConsumerMaster>();
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
				consumerList = masterDaoObj.fetchConsumerMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj,levelIndexObj);
				count = masterDaoObj.fetchConsumerMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj,levelIndexObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(consumerList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	@RequestMapping("/saveConsumerMasterDetails")
	public ModelAndView saveConsumerMasterDetails(
			@ModelAttribute("masterObj") ConsumerMaster masterObj,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = null;
		boolean isSaved = false;
		boolean isDeleted = false;
		Map<String, Integer> levelMap = new HashMap<String, Integer>();
		
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			UserHierUtils UserHierarchyUtilsObj = new UserHierUtils();
			try {
				levelMap.put("level1Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel1Id())));
				levelMap.put("level2Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel2Id())));
				levelMap.put("level3Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel3Id())));
				levelMap.put("level4Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel4Id())));
				levelMap.put("level5Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel5Id())));
				levelMap.put("level6Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel6Id())));
				levelMap.put("level7Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel7Id())));
				levelMap.put("level8Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel8Id())));
				levelMap.put("level9Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel9Id())));
				levelMap.put("level10Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel10Id())));
				levelMap.put("level11Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel11Id())));
				levelMap.put("level12Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(masterObj.getLevel12Id())));
				levelMap.put("level13Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel13Id())));
				levelMap.put("level14Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(masterObj.getLevel14Id())));
				levelMap.put("level15Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(masterObj.getLevel15Id())));
				
				LevelIndexMaster LevelIndexMasterObj = utilsObj.fetchIndexIdDetails(levelMap);
						try {
							if (LevelIndexMasterObj != null) {
							 masterObj.setIndexid(LevelIndexMasterObj.getIndexid());
							 masterObj.setInsertedDate(new Timestamp(new Date().getTime()));
							 masterObj.setInstallationDate(new Timestamp(new Date().getTime()));
							 masterObj.setInsertedUser(UserSessionObj
										.getBiouserdetails().getUserid());
							 isSaved = commonDaoObj.saveOrUpdate(masterObj);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
			if(masterObj.getCsmMeterMasterObj()!=null){
				String [] meterNumber = masterObj.getCsmMeterMasterObj().getId().getMeterNumber().split(",");
				String [] status = masterObj.getCsmMeterMasterObj().getStatusOfMeter().split(",");
				if(meterNumber.length>0){
					isDeleted = masterDaoObj.deleteConsumerMeterMasterDetails(masterObj.getConsumerId());
					if(isDeleted){
						for (int i = 0; i < meterNumber.length; i++) {
							ConsumerMeterMaster meterMasterObj = new ConsumerMeterMaster();
							ConsumerMeterMasterId meterMasterObjId = new ConsumerMeterMasterId();
							meterMasterObjId.setMeterNumber(meterNumber[i]);
							meterMasterObjId.setConsumerId(masterObj.getConsumerId());
							meterMasterObj.setId(meterMasterObjId);
							meterMasterObj.setStatusOfMeter(status[i]);
							commonDaoObj.saveOrUpdate(meterMasterObj);
						}
					}
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (isSaved == true) {
				model = new ModelAndView("redirect:/consumerMasterDetails");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("viewConsumerMaster")
	public ModelAndView viewConsumerMaster(
			@RequestParam("consumerId") String consumerId,
			@RequestParam("viewType") String viewType,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = null;
		ConsumerMaster masterObj = new ConsumerMaster();
		List<ConsumerMeterMaster> meterMasterList = new ArrayList<ConsumerMeterMaster>();
		HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			masterObj = masterDaoObj.fetchConsumerMasterDetails(consumerId);
			masterDaoObj.fetchMeterNumberList(masterObj);
			meterMasterList = masterDaoObj.fetchConsumerMeterMasterDetails(consumerId);
			masterObj.setCsmMeterMasterList(meterMasterList);
			model = new ModelAndView("Masters/ConsumerMaster/AddOrViewConsumerDetails","command", masterObj);
				try {
					LevelIndexMaster levelObj = new LevelIndexMaster();
					levelObj = utilsObj.fetchLevelIndexMasterDetails(masterObj.getIndexid(),levelObj);
					model.addObject("level1Id", levelObj.getId().getLevel1id());
					model.addObject("level2Id", levelObj.getId().getLevel2id());
					model.addObject("level3Id", levelObj.getId().getLevel3id());
					model.addObject("level4Id", levelObj.getId().getLevel4id());
					model.addObject("level5Id", levelObj.getId().getLevel5id());
					model.addObject("level6Id", levelObj.getId().getLevel6id());
					model.addObject("level7Id", levelObj.getId().getLevel7id());
					model.addObject("level8Id", levelObj.getId().getLevel8id());
					model.addObject("level9Id", levelObj.getId().getLevel9id());
					model.addObject("level10Id", levelObj.getId().getLevel10id());
					model.addObject("level11Id", levelObj.getId().getLevel11id());
					model.addObject("level12Id", levelObj.getId().getLevel12id());
					model.addObject("level13Id", levelObj.getId().getLevel13id());
					model.addObject("level14Id", levelObj.getId().getLevel14id());
					model.addObject("level15Id", levelObj.getId().getLevel15id());
            
					model.addObject("level1Map", UserSessionObj.getLevel1Map());
					model.addObject("level2Map", daoObj.nextLevelsMap("1",levelObj.getId().getLevel1id()+""));
					model.addObject("level3Map", daoObj.nextLevelsMap("2",levelObj.getId().getLevel2id()+""));
					model.addObject("level4Map", daoObj.nextLevelsMap("3",levelObj.getId().getLevel3id()+""));
					model.addObject("level5Map", daoObj.nextLevelsMap("4",levelObj.getId().getLevel4id()+""));
					model.addObject("level6Map", daoObj.nextLevelsMap("5",levelObj.getId().getLevel5id()+""));
					model.addObject("level7Map", daoObj.nextLevelsMap("6",levelObj.getId().getLevel6id()+""));
					model.addObject("level8Map", daoObj.nextLevelsMap("7",levelObj.getId().getLevel7id()+""));
					model.addObject("level9Map", daoObj.nextLevelsMap("8",levelObj.getId().getLevel8id()+""));
					model.addObject("level10Map",daoObj.nextLevelsMap("9",levelObj.getId().getLevel9id()+""));
					model.addObject("level11Map",daoObj.nextLevelsMap("10",levelObj.getId().getLevel10id()+""));
					model.addObject("level12Map",daoObj.nextLevelsMap("11",levelObj.getId().getLevel11id()+""));
					model.addObject("level13Map",daoObj.nextLevelsMap("12",levelObj.getId().getLevel12id()+""));
					model.addObject("level14Map",daoObj.nextLevelsMap("13",levelObj.getId().getLevel13id()+""));
					model.addObject("level15Map",daoObj.nextLevelsMap("14",levelObj.getId().getLevel14id()+""));
					masterObj.setViewType(viewType);
					model.addObject("command", fetchConsumerMasterColumsMap(masterObj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("deleteConsumerMaster")
	public ModelAndView deleteConsumerMaster(@RequestParam("consumerId")String consumerId){
		ModelAndView model = null;
		boolean isDeleted = false;
		try {
			isDeleted= masterDaoObj.deleteConsumerMasterDetails(consumerId);
			if (isDeleted == true) {
				model = new ModelAndView("redirect:/consumerMasterDetails");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("bulkConsumerMasterUpload")
	public ModelAndView bulkConsumerMasterUpload(@RequestParam("ConsumerDataupload") MultipartFile ConsumerDataupload,
			HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("common/error.jsp");
		ConsumerMaster consObj = new ConsumerMaster();
		
		HashMap<String, String> rowDataMap = null;     
		Map<String, String> successMetersMap = new HashMap<String, String>();
		Map<String, String> failureMetersMap = new HashMap<String, String>();
		Map<String, Integer> levelIndexMap = new HashMap<String, Integer>();
		
		LevelIndexMaster LevelIndexMasterObj = new LevelIndexMaster();
		int rowCount = 0;
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			String fileName = ConsumerDataupload.getOriginalFilename();
			File file = new File("/tmp/" + fileName);
			ConsumerDataupload.transferTo(file);
			Workbook w = Workbook.getWorkbook(file);
			Sheet sheet = w.getSheet(0);
			String header = commonDaoObj.readHeader(sheet);
			HashMap<String, Integer> headerMap =commonDaoObj.prepareHeaderMap(header);
			int TotalRowCount = sheet.getRows();
			int totalRows = TotalRowCount - 1;
			
				while (totalRows != rowCount) {
					rowCount++; 
				 	rowDataMap = commonDaoObj.getRowDataMap(sheet.getRow(rowCount), headerMap);
				 	ConsumerMaster masterObj = new ConsumerMaster();
					masterObj.setConsumerId(rowDataMap.get("CONSUMER_ID"));
					masterObj.setConsumerNumber(rowDataMap.get("CONSUMER_NO"));
					masterObj.setConsumerAddress(rowDataMap.get("CONSUMER_ADDRESS"));
					masterObj.setConsumerCompanyDetails(rowDataMap.get("CONSUMER_COMPANY_DETAILS"));
					masterObj.setContactNo(rowDataMap.get("CONTACT_NO"));
					masterObj.setAlternateContact(rowDataMap.get("ALTERNATE_CONTACT"));
//					masterObj.setEmailAddress(rowDataMap.get("EMAIL_ADDRESS"));
					masterObj.setEmailAddress("@gmail.com");
					masterObj.setIdentificationNumber(rowDataMap.get("IDENTIFICATION_NO"));
					masterObj.setConnectionStatus(rowDataMap.get("CONNECTION_STATUS"));
					masterObj.setAccountId(rowDataMap.get("ACCOUNT_ID"));
					 
					 try{
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						    Date parsedDate = dateFormat.parse(rowDataMap.get("INSTALLATION_DATE"));
						    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
						    masterObj.setInstallationDate(timestamp);
						}catch (Exception e) {
							// TODO: handle exception
						}
					 
				     masterObj.setLevel1Code("NEA");
					 masterObj.setLevel2Code(rowDataMap.get("LEVEL_2CODE"));
					 masterObj.setLevel3Code(rowDataMap.get("LEVEL_3CODE"));
					 masterObj.setLevel4Code(rowDataMap.get("LEVEL_4CODE"));
					 masterObj.setLevel5Code(rowDataMap.get("LEVEL_5CODE"));
					 masterObj.setLevel6Code(rowDataMap.get("LEVEL_6CODE"));
					 masterObj.setLevel7Code(rowDataMap.get("LEVEL_7CODE"));
					 masterObj.setLevel8Code(rowDataMap.get("LEVEL_8CODE"));
					 masterObj.setLevel9Code(rowDataMap.get("LEVEL_9CODE"));
				     		try {
				     			String uniqueCodeStr="";
						    	String levelCode="";
						    	
						    	if(StringUtils.isNotEmpty(masterObj.getLevel1Code())){
						    		
						    		levelCode = masterObj.getLevel1Code();
									uniqueCodeStr += levelCode;
									
									try {
										Object[] strArr = utilsObj.fetchLevelDetails(1, uniqueCodeStr);
										Integer levelId = (Integer) strArr[0];
										String levelName=(String) strArr[1];
						        		masterObj.setLevel1Name(levelName+"");
						        		masterObj.setLevel1Id(levelId+"");
						        		levelIndexMap.put("level1Id", levelId);
									} catch (Exception e) {
										levelIndexMap.put("level1Id", -1);
										LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 1 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
										throw e;
									}
						    		
						    	}else{
					        		levelIndexMap.put("level1Id", -1);
					        	}
						    if(StringUtils.isNotEmpty(masterObj.getLevel2Code())){
						    	
						    	try {
						    		levelCode = masterObj.getLevel2Code();
						    		uniqueCodeStr = masterObj.getLevel1Id()+"_"+levelCode;
									Object[] strArr = utilsObj.fetchLevelDetails(2, uniqueCodeStr);
									Integer levelId = (Integer) strArr[0];
									String levelName=(String) strArr[1];
					        		masterObj.setLevel2Name(levelName+"");
					        		masterObj.setLevel2Id(levelId+"");
					        		levelIndexMap.put("level2Id", levelId);
								} catch (Exception e) {
									 levelIndexMap.put("level2Id", -1);
					    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 2 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
					    			 throw e;
								}
						    	
						    }else{
				        		levelIndexMap.put("level2Id", -1);
				        	}
						 if(StringUtils.isNotEmpty(masterObj.getLevel3Code())){
							 	try {
							 		levelCode = masterObj.getLevel3Code();
							 		uniqueCodeStr = masterObj.getLevel2Id()+"_"+levelCode;
									Object[] strArr = utilsObj.fetchLevelDetails(3, uniqueCodeStr);
									Integer levelId = (Integer) strArr[0];
									String levelName=(String) strArr[1];
					        		masterObj.setLevel3Name(levelName+"");
					        		masterObj.setLevel3Id(levelId+"");
					        		levelIndexMap.put("level3Id", levelId);
								} catch (Exception e) {
									 levelIndexMap.put("level3Id", -1);
					    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 3 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
					    			 throw e;
								}
							 
							 
						 }else{
				        		levelIndexMap.put("level3Id", -1);
				        	}
						 
						 if (StringUtils.isNotEmpty(masterObj.getLevel4Code())) {
								try{
									levelCode = masterObj.getLevel4Code();
									uniqueCodeStr = masterObj.getLevel3Id()+"_"+levelCode;
									Object[] strArr = utilsObj.fetchLevelDetails(
											4, uniqueCodeStr);
									Integer levelId = (Integer) strArr[0];
									String levelName = (String) strArr[1];
									masterObj.setLevel4Name(levelName + "");
									masterObj.setLevel4Id(levelId + "");
									levelIndexMap.put("level4Id", levelId);
								}catch (Exception e) {
									levelIndexMap.put("level4Id", -1);
									LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 4 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
									 throw e;
								}
								
							} else {
								levelIndexMap.put("level4Id", -1);
							}
					    	 
						 if(StringUtils.isNotEmpty(masterObj.getLevel5Code())){
					    		try{
					    			levelCode = masterObj.getLevel5Code();
					    			uniqueCodeStr = masterObj.getLevel4Id()+"_"+levelCode;
									Object[] strArr = utilsObj.fetchLevelDetails(5, uniqueCodeStr);
									Integer levelId = (Integer) strArr[0];
									String levelName=(String) strArr[1];
					        		masterObj.setLevel5Name(levelName+"");
					        		masterObj.setLevel5Id(levelId+"");
					        		levelIndexMap.put("level5Id", levelId);
					    		}catch (Exception e) {
					    			levelIndexMap.put("level5Id", -1);
					    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 5 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
					        		 throw e;
								}
									
				        	}else{
				        		levelIndexMap.put("level5Id", -1);
				        		
				        	}	
						 
						 if(StringUtils.isNotEmpty(masterObj.getLevel6Code())){
				    		 try{
				    			levelCode = masterObj.getLevel6Code();
				    			uniqueCodeStr = masterObj.getLevel5Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(6, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel6Name(levelName+"");
				        		masterObj.setLevel6Id(levelId+"");
				        		levelIndexMap.put("level6Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level6Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 6 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level6Id", -1);
			        	}
						 
						 if(StringUtils.isNotEmpty(masterObj.getLevel7Code())){
				    		 try{
				    			levelCode = masterObj.getLevel7Code();
				    			uniqueCodeStr = masterObj.getLevel6Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(7, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel7Name(levelName+"");
				        		masterObj.setLevel7Id(levelId+"");
				        		levelIndexMap.put("level7Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level7Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 7 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level7Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel8Code())){
				    		 try{
				    			levelCode = masterObj.getLevel8Code();
				    			uniqueCodeStr = masterObj.getLevel7Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(8, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel8Name(levelName+"");
				        		masterObj.setLevel8Id(levelId+"");
				        		levelIndexMap.put("level8Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level8Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 8 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level8Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel9Code())){
				    		 try{
				    			levelCode = masterObj.getLevel9Code();
				    			uniqueCodeStr = masterObj.getLevel8Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(9, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel9Name(levelName+"");
				        		masterObj.setLevel9Id(levelId+"");
				        		levelIndexMap.put("level9Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level9Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 9 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level9Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel10Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel10Code();
				    			 uniqueCodeStr = masterObj.getLevel9Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(10, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel10Name(levelName+"");
				        		masterObj.setLevel10Id(levelId+"");
				        		levelIndexMap.put("level10Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level10Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 10 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level10Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel11Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel11Code();
				    			 uniqueCodeStr = masterObj.getLevel10Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(11, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel11Name(levelName+"");
				        		masterObj.setLevel11Id(levelId+"");
				        		levelIndexMap.put("level11Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level11Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 11 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level11Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel12Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel12Code();
				    			 uniqueCodeStr = masterObj.getLevel11Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(12, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel12Name(levelName+"");
				        		masterObj.setLevel12Id(levelId+"");
				        		levelIndexMap.put("level12Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level12Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 12 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level12Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel13Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel13Code();
				    			 uniqueCodeStr = masterObj.getLevel12Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(13, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel13Name(levelName+"");
				        		masterObj.setLevel13Id(levelId+"");
				        		levelIndexMap.put("level13Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level13Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 13 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level13Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel14Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel14Code();
				    			 uniqueCodeStr = masterObj.getLevel13Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(14, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel14Name(levelName+"");
				        		masterObj.setLevel14Id(levelId+"");
				        		levelIndexMap.put("level14Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level14Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 14 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level14Id", -1);
			        	}
				    	 
				    	 if(StringUtils.isNotEmpty(masterObj.getLevel15Code())){
				    		 try{
				    			 levelCode = masterObj.getLevel15Code();
				    			 uniqueCodeStr = masterObj.getLevel14Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(15, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		masterObj.setLevel15Name(levelName+"");
				        		masterObj.setLevel15Id(levelId+"");
				        		levelIndexMap.put("level15Id", levelId);
				    		 }catch (Exception e) {
				    			 levelIndexMap.put("level15Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 15 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level15Id", -1);
			        	}
				    	 LevelIndexMasterObj = utilsObj.fetchIndexIdDetails(levelIndexMap);
						 
							} catch (Exception e) {
								e.printStackTrace();
							}
				     
				     try {
				    	 if(LevelIndexMasterObj.getIndexid()!=0){
				    		 masterObj.setIndexid(LevelIndexMasterObj.getIndexid());
							 masterObj.setInsertedDate(new Timestamp(new Date().getTime()));
							 masterObj.setInsertedUser(UserSessionObj
										.getBiouserdetails().getUserid());
							 
							 consObj=masterDaoObj.saveUploadConsumerMasterDetails(masterObj);
							 
								if(consObj.getSuccessMessage()=="SUCCESS"){
									successMetersMap.put(masterObj.getConsumerId(), "SUCCESS");
									
								}else{
									failureMetersMap.put(masterObj.getConsumerId(), consObj.getErrorMessage());
								}
				    	 }
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				model = new ModelAndView("redirect:/consumerMasterDetails");
				/*
				model = new ModelAndView(
						"Masters/ConsumerMaster/AddOrViewConsumerDetails", "command",
						consObj);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	private Object fetchConsumerMasterColumsMap(ConsumerMaster masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Consumer Id");
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
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("consumerId", "CONSUMER ID");
			searchColumnsMap.put("consumerNumber", "CONSUMER NUMBER");
			searchColumnsMap.put("consumerAddress", "CONSUMER ADDRESS");
			masterObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			masterObj.setConditionListStr(conditionListStr);
			
			List<String> statusList = new ArrayList<String>();
			statusList.add("ENABLE");
			statusList.add("DISABLE");
			masterObj.setStatusList(statusList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterObj;
	}
	
	
}
