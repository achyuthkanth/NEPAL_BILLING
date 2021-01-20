package com.analogics.controllers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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

import com.analogics.dao.MeterMasterDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.vo.ConsumerMeterMaster;
import com.analogics.vo.ConsumerMeterMasterId;
import com.analogics.vo.MeterMaster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MeterMasterController {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	UserHierUtils utilsObj = new UserHierUtils();
	MeterMasterDao meterDaoObj = new MeterMasterDao();
	CommonDAO commonDaoObj = new CommonDAO();
	
	int records;
	int total;
	
	@RequestMapping("/addOrViewMeterMaster")
	public ModelAndView addOrViewMeterMaster(HttpServletRequest request ,HttpServletResponse response,
			@ModelAttribute("masterObj")MeterMaster masterObj,@ModelAttribute("hierVoObj") HierarchyLevelsVo hierVoObj){
		ModelAndView model = null;
		try {
			model = new ModelAndView("Masters/MeterMaster/AddOrViewMeterMaster","command", masterObj);
			HttpSession session=request.getSession();
			UserLoginDetails userSessionObj=(UserLoginDetails) session.getAttribute("sessionObj");
			if(!hierVoObj.getLevel1Id().equalsIgnoreCase("-1")){
				utilsObj.fetchHierarchyLevels(model,userSessionObj,hierVoObj);
			}else{
				utilsObj.frameLevelMaps(model,userSessionObj);
			}
			model.addObject("command", fetchMeterMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/fetchMeterMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchMeterMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") MeterMaster masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			throws IOException {
		String json=null;
	
	try {
		List<MeterMaster> meterList=new ArrayList<MeterMaster>();
		int pageNumber = 0;
		pageNumber = Integer.parseInt(iDisplayStart);
		ServerDataTable dataTable = new ServerDataTable();
		Map<String,Integer> levelMap=new HashMap<String,Integer>();
		LevelIndexMaster levelIndexObj = new LevelIndexMaster();
		utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
		levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
		
		meterList=meterDaoObj.fetchMeterMasterList(pageNumber,
				Integer.parseInt(pageDisplayLength), searchParameter,
				masterObj,levelIndexObj);
    	Long count =meterDaoObj.fetchMeterMasterCount(masterObj,levelIndexObj);

    	dataTable.setiTotalRecords(count.intValue());
		dataTable.setiTotalDisplayRecords(count.intValue());

		dataTable.setAaData(meterList);
		 json = gson.toJson(dataTable);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return json;
}
	
	
	@RequestMapping("/saveMeterMasterDetails")
	public ModelAndView saveMeterMasterDetails(@ModelAttribute("meterDetailsObj")MeterMaster meterDetailsObj,
												HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("common/error.jsp");
		boolean isSaved = false;
		Map<String, Integer> levelMap = new HashMap<String, Integer>();
		
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			UserHierUtils UserHierarchyUtilsObj = new UserHierUtils();
			try {
				levelMap.put("level1Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel1Id())));
				levelMap.put("level2Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel2Id())));
				levelMap.put("level3Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel3Id())));
				levelMap.put("level4Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel4Id())));
				levelMap.put("level5Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel5Id())));
				levelMap.put("level6Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel6Id())));
				levelMap.put("level7Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel7Id())));
				levelMap.put("level8Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel8Id())));
				levelMap.put("level9Id",Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel9Id())));
				levelMap.put("level10Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel10Id())));
				levelMap.put("level11Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel11Id())));
				levelMap.put("level12Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel12Id())));
				levelMap.put("level13Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel13Id())));
				levelMap.put("level14Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel14Id())));
				levelMap.put("level15Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(meterDetailsObj.getLevel15Id())));
				
				LevelIndexMaster LevelIndexMasterObj = utilsObj.fetchIndexIdDetails(levelMap);
						try {
							if (LevelIndexMasterObj != null) {
//								frameLevelsIdCodeDetails(levelNumber, meterDetailsObj,LevelIndexMasterObj);
							 meterDetailsObj.setIndexid(LevelIndexMasterObj.getIndexid());
							 meterDetailsObj.setInsertedDate(new Timestamp(new Date().getTime()));
							 meterDetailsObj.setInstallationDate(new Timestamp(new Date().getTime()));
							 meterDetailsObj.setInsertedUser(UserSessionObj
										.getBiouserdetails().getUserid());
							 isSaved = commonDaoObj.saveOrUpdate(meterDetailsObj);
							 if(isSaved){
								 isSaved = false;
								 ConsumerMeterMaster csmObj = new ConsumerMeterMaster();
								 ConsumerMeterMasterId csmObjId = new ConsumerMeterMasterId();
								 boolean status = meterDaoObj.fetchMeterStatus(meterDetailsObj);
								 if(status== false){
									 csmObjId.setConsumerId(meterDetailsObj.getConsumerId());
									 csmObjId.setMeterNumber(meterDetailsObj.getMeterNumber());
									 csmObj.setId(csmObjId);
									 csmObj.setStatusOfMeter("ENABLE");
									 isSaved = commonDaoObj.saveOrUpdate(csmObj);
								 }
									 model = new ModelAndView("redirect:/addOrViewMeterMaster");
								 
							 }
							
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (isSaved == true) {
				model = new ModelAndView("redirect:/addOrViewMeterMaster");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping("editMeterMaster")
	public ModelAndView editMeterMaster(@RequestParam("meterNumber") String meterNumber,@RequestParam("viewType") String viewType,HttpServletRequest request,HttpServletResponse response){
		ModelAndView model =new ModelAndView("common/error.jsp");
		MeterMaster masterObj = new MeterMaster();
		HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			masterObj = meterDaoObj.fetchMeterMasterDetails(meterNumber);
			model = new ModelAndView("Masters/MeterMaster/AddOrViewMeterMaster","command", masterObj);
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
				model.addObject("command", fetchMeterMasterColumsMap(masterObj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("deleteMeterMaster")
	public ModelAndView deleteMeterMaster(@RequestParam("meterNumber")String meterNumber){
		ModelAndView model = new ModelAndView("common/error.jsp");
		boolean isSaved = false;
		try {
			isSaved= meterDaoObj.deleteMeterMasterDetails(meterNumber);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/addOrViewMeterMaster");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	@RequestMapping("bulkMeterMasterUpload")
	public ModelAndView bulkMeterMasterUpload(@RequestParam("MeterDataupload") MultipartFile MeterDataupload,
			HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("common/error.jsp");
		MeterMaster masterObj = new MeterMaster();
		
		HashMap<String, String> rowDataMap = null;     
	/*	Map<String, String> successMetersMap = new HashMap<String, String>();
		Map<String, String> failureMetersMap = new HashMap<String, String>();*/
		Map<String, Integer> levelIndexMap = new HashMap<String, Integer>();
		boolean isSaved =false;
		LevelIndexMaster LevelIndexMasterObj = new LevelIndexMaster();
		int rowCount = 0;
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			String fileName = MeterDataupload.getOriginalFilename();
			File file = new File("/tmp/" + fileName);
			MeterDataupload.transferTo(file);
			Workbook w = Workbook.getWorkbook(file);
			Sheet sheet = w.getSheet(0);
			String header = commonDaoObj.readHeader(sheet);
			HashMap<String, Integer> headerMap =commonDaoObj.prepareHeaderMap(header);
			int TotalRowCount = sheet.getRows();
			int totalRows = TotalRowCount - 1;
			
				while (totalRows != rowCount) {
					rowCount++; 
				 	rowDataMap = commonDaoObj.getRowDataMap(sheet.getRow(rowCount), headerMap);
				 	MeterMaster meterMaster = new MeterMaster();
					meterMaster.setMeterNumber(rowDataMap.get("METER_NUMBER"));
					meterMaster.setMeterMake(rowDataMap.get("METER_MAKE"));
					meterMaster.setInstallationType(rowDataMap.get("INSTALLATION_TYPE"));
					meterMaster.setInstallationSubType(rowDataMap.get("INSTALLATION_SUB_TYPE"));
					meterMaster.setIdentificationNumber(rowDataMap.get("IDENTIFICATION_NO"));
					meterMaster.setConnectionStatus(rowDataMap.get("CONNECTION_STATUS"));//NEED
					meterMaster.setSimNumber(rowDataMap.get("SIM_NO"));
					meterMaster.setMdnNumber(rowDataMap.get("MDN_NUMBER"));
					meterMaster.setModemNumber(rowDataMap.get("MODEM_NO"));
					
					try{
	                	 if( !rowDataMap.get("VOLTAGE_MULTIPLIER").equalsIgnoreCase("")){
			                	meterMaster.setVoltageMultiplier(Double.parseDouble(rowDataMap.get("VOLTAGE_MULTIPLIER")));
			                }
	                }catch (Exception e) {
						// TODO: handle exception
					}
					
					try{	
	                	 if( !rowDataMap.get("CURRENT_MULTIPLIER").equalsIgnoreCase("")){
			                	meterMaster.setCurrentMultiplier(Double.parseDouble(rowDataMap.get("CURRENT_MULTIPLIER")));
			                }
	                }catch (Exception e) {
						// TODO: handle exception
					}
					
					 try{
	                	 if( !rowDataMap.get("MF").equalsIgnoreCase("")){
	                		 	meterMaster.setMf(rowDataMap.get("ENERGY_MULTIPLIER"));
			                	meterMaster.setEnergyMultiplier(Double.parseDouble(rowDataMap.get("MF")));
			                }
	                }catch (Exception e) {
						// TODO: handle exception
					}
					 meterMaster.setModemVersion(rowDataMap.get("MODEM_VERSION"));
					 
					 try{
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						    Date parsedDate = dateFormat.parse(rowDataMap.get("INSTALLATION_DATE"));
						    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
						    meterMaster.setInstallationDate(timestamp);
						}catch (Exception e) {
							// TODO: handle exception
						}
					 
					 meterMaster.setSimProvider(rowDataMap.get("SIM_PROVIDER"));
					 meterMaster.setConsumerNumber(rowDataMap.get("CONSUMER_NO"));
					 meterMaster.setConsumerAddress(rowDataMap.get("CONSUMER_ADDRESS"));
					 meterMaster.setConsumerName(rowDataMap.get("CONSUMER_NAME"));
					 meterMaster.setAccountId(rowDataMap.get("ACCOUNT_ID"));
					 meterMaster.setIpAddress(rowDataMap.get("SIM_IP_ADDRESS"));
					 meterMaster.setDtCode(rowDataMap.get("DT_CODE"));
					 meterMaster.setFeederCode(rowDataMap.get("FEEDER_CODE"));
					 meterMaster.setSubstationCode(rowDataMap.get("SUBSTATION_CODE"));
					 meterMaster.setVoltageRating(rowDataMap.get("VOLTAGE_RATING"));
					 meterMaster.setSupplyDirection(rowDataMap.get("SUPPLY_DIRECTION"));//NEED
					 meterMaster.setInstallationId(rowDataMap.get("INSTALLATION_ID"));
					 meterMaster.setRfdnodenumber(rowDataMap.get("RFDNODENUMBER"));
					 
					 String latitude=rowDataMap.get("LATITUDE");
					 String longitude=rowDataMap.get("LATITUDE");
				     meterMaster.setGpscoordinates(latitude+"|"+longitude);
				     meterMaster.setMetercapacity(rowDataMap.get("METER_CAPACITY"));
				     meterMaster.setCtratio(rowDataMap.get("METER_CT"));//NEED
				     meterMaster.setPtratio(rowDataMap.get("METER_PT"));//NEED
				     meterMaster.setMeterratio(rowDataMap.get("METER_RATIO"));
				     meterMaster.setPinconfig(rowDataMap.get("PIN_CONFIG"));
				     meterMaster.setSlaveid(rowDataMap.get("SLAVE_ID"));
				     meterMaster.setFeedername(rowDataMap.get("FEEDER_NAME"));
				     meterMaster.setDtname(rowDataMap.get("DT_NAME"));
				     meterMaster.setLevel1Code("NEA");
					 meterMaster.setLevel2Code(rowDataMap.get("LEVEL_2CODE"));
					 meterMaster.setLevel3Code(rowDataMap.get("LEVEL_3CODE"));
					 meterMaster.setLevel4Code(rowDataMap.get("LEVEL_4CODE"));
					 meterMaster.setLevel5Code(rowDataMap.get("LEVEL_5CODE"));
					 meterMaster.setLevel6Code(rowDataMap.get("LEVEL_6CODE"));
					 meterMaster.setLevel7Code(rowDataMap.get("LEVEL_7CODE"));
					 meterMaster.setLevel8Code(rowDataMap.get("LEVEL_8CODE"));
					 meterMaster.setLevel9Code(rowDataMap.get("LEVEL_9CODE"));
					 try {
			     			String uniqueCodeStr="";
					    	String levelCode="";
					    	
					    	if(StringUtils.isNotEmpty(meterMaster.getLevel1Code())){
					    		
					    		levelCode = meterMaster.getLevel1Code();
								uniqueCodeStr += levelCode;
								
								try {
									Object[] strArr = utilsObj.fetchLevelDetails(1, uniqueCodeStr);
									Integer levelId = (Integer) strArr[0];
									String levelName=(String) strArr[1];
									meterMaster.setLevel1Name(levelName+"");
					        		meterMaster.setLevel1Id(levelId+"");
					        		levelIndexMap.put("level1Id", levelId);
								} catch (Exception e) {
									levelIndexMap.put("level1Id", -1);
									LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 1 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
									throw e;
								}
					    		
					    	}else{
				        		levelIndexMap.put("level1Id", -1);
				        	}
					    if(StringUtils.isNotEmpty(meterMaster.getLevel2Code())){
					    	
					    	try {
					    		levelCode = meterMaster.getLevel2Code();
					    		uniqueCodeStr = meterMaster.getLevel1Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(2, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		meterMaster.setLevel2Name(levelName+"");
				        		meterMaster.setLevel2Id(levelId+"");
				        		levelIndexMap.put("level2Id", levelId);
							} catch (Exception e) {
								 levelIndexMap.put("level2Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 2 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
					    	
					    }else{
			        		levelIndexMap.put("level2Id", -1);
			        	}
					 if(StringUtils.isNotEmpty(meterMaster.getLevel3Code())){
						 	try {
						 		levelCode = meterMaster.getLevel3Code();
						 		uniqueCodeStr = meterMaster.getLevel2Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(3, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		meterMaster.setLevel3Name(levelName+"");
				        		meterMaster.setLevel3Id(levelId+"");
				        		levelIndexMap.put("level3Id", levelId);
							} catch (Exception e) {
								 levelIndexMap.put("level3Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 3 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				    			 throw e;
							}
						 
						 
					 }else{
			        		levelIndexMap.put("level3Id", -1);
			        	}
					 
					 if (StringUtils.isNotEmpty(meterMaster.getLevel4Code())) {
							try{
								levelCode = meterMaster.getLevel4Code();
								uniqueCodeStr = meterMaster.getLevel3Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(
										4, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName = (String) strArr[1];
								meterMaster.setLevel4Name(levelName + "");
								meterMaster.setLevel4Id(levelId + "");
								levelIndexMap.put("level4Id", levelId);
							}catch (Exception e) {
								levelIndexMap.put("level4Id", -1);
								LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 4 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
								 throw e;
							}
							
						} else {
							levelIndexMap.put("level4Id", -1);
						}
				    	 
					 if(StringUtils.isNotEmpty(meterMaster.getLevel5Code())){
				    		try{
				    			levelCode = meterMaster.getLevel5Code();
				    			uniqueCodeStr = meterMaster.getLevel4Id()+"_"+levelCode;
								Object[] strArr = utilsObj.fetchLevelDetails(5, uniqueCodeStr);
								Integer levelId = (Integer) strArr[0];
								String levelName=(String) strArr[1];
				        		meterMaster.setLevel5Name(levelName+"");
				        		meterMaster.setLevel5Id(levelId+"");
				        		levelIndexMap.put("level5Id", levelId);
				    		}catch (Exception e) {
				    			levelIndexMap.put("level5Id", -1);
				    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 5 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
				        		 throw e;
							}
								
			        	}else{
			        		levelIndexMap.put("level5Id", -1);
			        		
			        	}	
					 
					 if(StringUtils.isNotEmpty(meterMaster.getLevel6Code())){
			    		 try{
			    			levelCode = meterMaster.getLevel6Code();
			    			uniqueCodeStr = meterMaster.getLevel5Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(6, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel6Name(levelName+"");
			        		meterMaster.setLevel6Id(levelId+"");
			        		levelIndexMap.put("level6Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level6Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 6 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level6Id", -1);
		        	}
					 
					 if(StringUtils.isNotEmpty(meterMaster.getLevel7Code())){
			    		 try{
			    			levelCode = meterMaster.getLevel7Code();
			    			uniqueCodeStr = meterMaster.getLevel6Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(7, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel7Name(levelName+"");
			        		meterMaster.setLevel7Id(levelId+"");
			        		levelIndexMap.put("level7Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level7Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 7 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level7Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel8Code())){
			    		 try{
			    			levelCode = meterMaster.getLevel8Code();
			    			uniqueCodeStr = meterMaster.getLevel7Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(8, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel8Name(levelName+"");
			        		meterMaster.setLevel8Id(levelId+"");
			        		levelIndexMap.put("level8Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level8Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 8 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level8Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel9Code())){
			    		 try{
			    			levelCode = meterMaster.getLevel9Code();
			    			uniqueCodeStr = meterMaster.getLevel8Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(9, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel9Name(levelName+"");
			        		meterMaster.setLevel9Id(levelId+"");
			        		levelIndexMap.put("level9Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level9Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 9 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level9Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel10Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel10Code();
			    			 uniqueCodeStr = meterMaster.getLevel9Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(10, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel10Name(levelName+"");
			        		meterMaster.setLevel10Id(levelId+"");
			        		levelIndexMap.put("level10Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level10Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 10 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level10Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel11Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel11Code();
			    			 uniqueCodeStr = meterMaster.getLevel10Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(11, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel11Name(levelName+"");
			        		meterMaster.setLevel11Id(levelId+"");
			        		levelIndexMap.put("level11Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level11Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 11 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level11Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel12Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel12Code();
			    			 uniqueCodeStr = meterMaster.getLevel11Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(12, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel12Name(levelName+"");
			        		meterMaster.setLevel12Id(levelId+"");
			        		levelIndexMap.put("level12Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level12Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 12 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level12Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel13Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel13Code();
			    			 uniqueCodeStr = meterMaster.getLevel12Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(13, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel13Name(levelName+"");
			        		meterMaster.setLevel13Id(levelId+"");
			        		levelIndexMap.put("level13Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level13Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 13 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level13Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel14Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel14Code();
			    			 uniqueCodeStr = meterMaster.getLevel13Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(14, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel14Name(levelName+"");
			        		meterMaster.setLevel14Id(levelId+"");
			        		levelIndexMap.put("level14Id", levelId);
			    		 }catch (Exception e) {
			    			 levelIndexMap.put("level14Id", -1);
			    			 LevelIndexMasterObj.setResponse("Error in fetching Hiererchylevel 14 Code :: "+levelCode+" uniqueCodeStr : "+uniqueCodeStr);
			    			 throw e;
						}
							
		        	}else{
		        		levelIndexMap.put("level14Id", -1);
		        	}
			    	 
			    	 if(StringUtils.isNotEmpty(meterMaster.getLevel15Code())){
			    		 try{
			    			 levelCode = meterMaster.getLevel15Code();
			    			 uniqueCodeStr = meterMaster.getLevel14Id()+"_"+levelCode;
							Object[] strArr = utilsObj.fetchLevelDetails(15, uniqueCodeStr);
							Integer levelId = (Integer) strArr[0];
							String levelName=(String) strArr[1];
			        		meterMaster.setLevel15Name(levelName+"");
			        		meterMaster.setLevel15Id(levelId+"");
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
				    		 meterMaster.setIndexid(LevelIndexMasterObj.getIndexid());
							 meterMaster.setInsertedDate(new Timestamp(new Date().getTime()));
							 meterMaster.setInsertedUser(UserSessionObj
										.getBiouserdetails().getUserid());
							 isSaved = commonDaoObj.saveOrUpdate(meterMaster);
							 if(isSaved){
								 isSaved = false;
								 ConsumerMeterMaster csmObj = new ConsumerMeterMaster();
								 ConsumerMeterMasterId csmObjId = new ConsumerMeterMasterId();
								 
								 csmObjId.setConsumerId(meterMaster.getConsumerNumber());
								 csmObjId.setMeterNumber(meterMaster.getMeterNumber());
								 csmObj.setId(csmObjId);
								 csmObj.setStatusOfMeter("ENABLE");
								 isSaved = commonDaoObj.saveOrUpdate(csmObj);
							 }
							 if(isSaved){
								 model = new ModelAndView("redirect:/addOrViewMeterMaster");
							 }
//								masterObj=meterDaoObj.saveUploadMeterMasterDetails(meterMaster);
				    		 
								/*if(masterObj.getSuccessMessage()=="SUCCESS"){
									successMetersMap.put(meterMaster.getMeterNumber(), "SUCCESS");
									
								}else{
									failureMetersMap.put(meterMaster.getMeterNumber(), masterObj.getErrorMessage());
								}*/
				    	 }
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				model = new ModelAndView(
						"masters/MeterMaster/MeterMasterDetailsList", "command",
						masterObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return model;
	}
	
	@RequestMapping("exportMeterMasterReport")
	@ResponseBody
	public void exportMeterMasterReport(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")MeterMaster masterObj,
		@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj){
		
		try {
			int noOfRecords=5000;
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "MeterMasterExport.csv";
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportMeterMasterPrepareHeader());
			utilsObj.appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
			
			MeterMasterDao daoObj = new MeterMasterDao();
			
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			LevelIndexMaster levelIndexObj=UserSessionObj.getLevelIndexMasterObj();
			masterObj.setSearchSelectVar("");
			 Map<String,Integer> levelMap=new HashMap<String,Integer>();
			 utilsObj.frameLevelIndexLevelMaps(utilsObj,hierVoObj,levelMap);
				levelIndexObj = utilsObj.fetchIndexIdDetails(levelMap);
				List<MeterMaster> dataList = new ArrayList<MeterMaster>();
				
				Long totalRecords=daoObj.fetchMeterMasterCount( 
						masterObj,levelIndexObj);
				
				records = totalRecords.intValue();
				total = (int)Math.ceil(records /(double)noOfRecords);
				
				masterObj.setRows(noOfRecords);
				
				for(int i=1;i<=total;i++){
					masterObj.setPage(i);
					dataList= daoObj.fetchMeterMasterList(i-1, records, null, masterObj, levelIndexObj);
					for (MeterMaster meterDetailsObj : dataList) {
						
						if(meterDetailsObj.getMeterNumber() != null){
							dataStr.append(meterDetailsObj.getMeterNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getMeterMake() != null){
							dataStr.append(meterDetailsObj.getMeterMake() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getInstallationType() != null){
							dataStr.append(meterDetailsObj.getInstallationType() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getInstallationSubType() != null){
							dataStr.append(meterDetailsObj.getInstallationSubType() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getIdentificationNumber() != null){
							dataStr.append(meterDetailsObj.getIdentificationNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getConnectionStatus() != null){
							dataStr.append(meterDetailsObj.getConnectionStatus() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getSimNumber() != null){
							dataStr.append(meterDetailsObj.getSimNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getMdnNumber() != null){
							dataStr.append(meterDetailsObj.getMdnNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getModemNumber() != null){
							dataStr.append(meterDetailsObj.getModemNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getVoltageMultiplier() != null){
							dataStr.append(meterDetailsObj.getVoltageMultiplier() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getCurrentMultiplier() != null){
							dataStr.append(meterDetailsObj.getCurrentMultiplier() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getEnergyMultiplier() != null){
							dataStr.append(meterDetailsObj.getEnergyMultiplier() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getModemVersion() != null){
							dataStr.append(meterDetailsObj.getModemVersion() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getInstallationDate() != null){
							dataStr.append(meterDetailsObj.getInstallationDate() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getSimProvider() != null){
							dataStr.append(meterDetailsObj.getSimProvider() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getConsumerNumber() != null){
							dataStr.append(meterDetailsObj.getConsumerNumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getConsumerAddress() != null){
							dataStr.append(meterDetailsObj.getConsumerAddress() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getConsumerName() != null){
							dataStr.append(meterDetailsObj.getConsumerName() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getAccountId() != null){
							dataStr.append(meterDetailsObj.getAccountId() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getIpAddress() != null){
							dataStr.append(meterDetailsObj.getIpAddress() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getDtCode() != null){
							dataStr.append(meterDetailsObj.getDtCode() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getFeederCode() != null){
							dataStr.append(meterDetailsObj.getFeederCode() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getSubstationCode() != null){
							dataStr.append(meterDetailsObj.getSubstationCode() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getVoltageRating() != null){
							dataStr.append(meterDetailsObj.getVoltageRating() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getSupplyDirection() != null){
							dataStr.append(meterDetailsObj.getSupplyDirection() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getInstallationId() != null){
							dataStr.append(meterDetailsObj.getInstallationId() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getRfdnodenumber() != null){
							dataStr.append(meterDetailsObj.getRfdnodenumber() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getBoundarytype()!=null){
							dataStr.append(meterDetailsObj.getBoundarytype() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getMetertype()!=null){
							dataStr.append(meterDetailsObj.getMetertype() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getMeterclass()!=null){
							dataStr.append(meterDetailsObj.getMeterclass() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getMdnno()!=null){
							dataStr.append(meterDetailsObj.getMdnno() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						
						if(meterDetailsObj.getGpscoordinates()!=null){
							dataStr.append(meterDetailsObj.getGpscoordinates() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getMetercapacity()!=null){
							dataStr.append(meterDetailsObj.getMetercapacity() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getCtratio()!=null){
							dataStr.append(meterDetailsObj.getCtratio() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getPtratio()!=null){
							dataStr.append(meterDetailsObj.getPtratio() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getMeterratio()!=null){
							dataStr.append(meterDetailsObj.getMeterratio() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						if(meterDetailsObj.getPinconfig()!=null){
							dataStr.append(meterDetailsObj.getPinconfig() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getMeterpono()!=null){
							dataStr.append(meterDetailsObj.getMeterpono() + ",");
						}else{
							dataStr.append("-"+ ",");
						}
						
						if(meterDetailsObj.getSlaveid()!=null){
							dataStr.append(meterDetailsObj.getSlaveid() + "\n");
						}else{
							dataStr.append("-"+ "\n");
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
	private String ExportMeterMasterPrepareHeader() {
  		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("METER NUMBER,");
			sb.append("METER MAKE,");
			sb.append("INSTALLATION TYPE,");
			sb.append("INSTALLATION SUB TYPE,");
			sb.append("IDENTIFICATION_NUMBER,");
			sb.append("CONNECTION_STATUS,");
			sb.append("SIM_NUMBER,");
			sb.append("MDN_NUMBER,");
			sb.append("MODEM_NUMBER,");
			sb.append("VOLTAGE_MULTIPLIER,");
			sb.append("CURRENT_MULTIPLIER,");
			sb.append("ENERGY_MULTIPLIER,");
			sb.append("MODEM_VERSION,");
			sb.append("INSTALLATION_DATE,");
			sb.append("SIM_PROVIDER,");
			sb.append("CONSUMER_NUMBER,");
			sb.append("CONSUMER_ADDRESS,");
			sb.append("CONSUMER_NAME,");
			sb.append("ACCOUNT_ID,");
			sb.append("IP_ADDRESS,");
			sb.append("DT_CODE,");
			sb.append("FEEDER_CODE,");
			sb.append("SUBSTATION_CODE,");
			sb.append("VOLTAGE_RATING,");
			sb.append("SUPPLY_DIRECTION,");
			sb.append("INSTALLATION_ID,");
			sb.append("RFDNODENUMBER"+",");
			sb.append("BOUNDARY_TYPE,");
			sb.append("METER_TYPE,");
			sb.append("METER_CLASS,");
			sb.append("MDN_NO,");
			sb.append("GPS_COORDINATES,");
			sb.append("METER_CAPACITY,");
			sb.append("CT_RATIO,");
			sb.append("PT_RATIO,");
			sb.append("METER_RATIO,");
			sb.append("PIN_CONFIG,");
			sb.append("METER_PO_NO,");
			sb.append("SLAVE_ID"+"\n");
			header=sb.toString();
  		} catch (Exception ex) {
  			ex.printStackTrace();
  		}
  		return header;
  	}







	private Object fetchMeterMasterColumsMap(MeterMaster masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Meter Number");
			columnsMap.put("2", "Modem Number");
			columnsMap.put("3", "Meter Make");
//			columnsMap.put("4", "Modem Number");
//			columnsMap.put("4", "Meter Make");
			columnsMap.put("4", "Installation Type");
			columnsMap.put("5", "Installation Sub Type");
			columnsMap.put("6", "Identification Number");
			columnsMap.put("7", "Connection Status");
			columnsMap.put("8", "Sim Number");
			columnsMap.put("9", "Mdn Number");
			columnsMap.put("10", "Voltage Multiplier");
			columnsMap.put("11", "Current Multiplier");
			columnsMap.put("12", "Energy Multiplier");
			columnsMap.put("13", "Installation Date");
			columnsMap.put("14", "Inserted Date");
			columnsMap.put("15", "Inserted User");
			columnsMap.put("16", "Sim Provider");
			columnsMap.put("17", "Consumer Number");
			columnsMap.put("18", "Consumer Address");
			columnsMap.put("19", "Dt Code");
			columnsMap.put("20", "Feeder Code");
			columnsMap.put("21", "Substation Code");
			columnsMap.put("22", "Voltage Rating");
			columnsMap.put("23", "Supply Direction");
			columnsMap.put("24", "Installation Id");
			columnsMap.put("25", "rfdnode Number");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("meterNumber", "METER NUMBER");
			
			masterObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			masterObj.setConditionListStr(conditionListStr);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterObj;
	}
}
