package com.analogics.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.dao.FieldInstallationDao;
import com.analogics.um.controllers.UserHierUtils;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.vo.FieldInstallationMaster;
import com.analogics.vo.FieldInstallationMasterId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class FieldInstallationController {
	CommonDAO commonDaoObj = new CommonDAO();
	UserHierUtils utilsObj = new UserHierUtils();
	
	FieldInstallationDao daoObj = new FieldInstallationDao();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	@RequestMapping("/addorviewFieldInstallation")
	public ModelAndView addorviewFieldInstallation(FieldInstallationMaster fieldInsObj){
		ModelAndView model =null;
		try {
			model = new ModelAndView("Masters/FieldInstallation/AddOrViewFieldInstallation" ,"command",fieldInsObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	
	@RequestMapping("/saveFieldInstallation")
	public ModelAndView saveFieldInstallation(@ModelAttribute("fieldInsObj") FieldInstallationMaster fieldInsObj,HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model =null;
		boolean isSaved = false;
		try {
			 isSaved = commonDaoObj.saveOrUpdate(fieldInsObj);
			 if(isSaved){
				 model = new ModelAndView("redirect:/addorviewFieldInstallation");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/fetchFieldInstallationMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchMeterMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") FieldInstallationMaster masterObj,@ModelAttribute("hierVoObj")HierarchyLevelsVo hierVoObj)
			 {
		String json=null;
	
	try {
		List<FieldInstallationMaster> installationList=new ArrayList<FieldInstallationMaster>();
		int pageNumber = 0;
		pageNumber = Integer.parseInt(iDisplayStart);
		ServerDataTable dataTable = new ServerDataTable();
		installationList=daoObj.fetchFieldInstallationMasterList(pageNumber,
				Integer.parseInt(pageDisplayLength), searchParameter,
				masterObj);
    	Long count =daoObj.fetchFieldInstallationCount(masterObj);

    	dataTable.setiTotalRecords(count.intValue());
		dataTable.setiTotalDisplayRecords(count.intValue());

		dataTable.setAaData(installationList);
		 json = gson.toJson(dataTable);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return json;
}
	@RequestMapping("editFieldInstallationMaster")
	public ModelAndView editMeterMaster(@RequestParam("circleid") String circleid,@RequestParam("consumerid") String consumerid,@RequestParam("consumerNo") String consumerNo,@RequestParam("viewType") String viewType,HttpServletRequest request,HttpServletResponse response){
		ModelAndView model =new ModelAndView("common/error.jsp");
		FieldInstallationMaster masterObj = new FieldInstallationMaster();
		try {
			masterObj = daoObj.fetchFieldInstalltionMasterDetails(circleid,consumerid,consumerNo);
			model = new ModelAndView("Masters/FieldInstallation/AddOrViewFieldInstallation" ,"command",masterObj);
				try {
				masterObj.setViewType(viewType);
//				model.addObject("command", fetchMeterMasterColumsMap(masterObj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping("deleteFieldInstallation")
	public ModelAndView deleteMeterMaster(@RequestParam("circleid") String circleid,@RequestParam("consumerid") String consumerid,@RequestParam("consumerNo") String consumerNo,@RequestParam("viewType") String viewType,HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView("common/error.jsp");
		boolean isSaved = false;
		try {
			isSaved= daoObj.deleteFieldInstalltionMasterDetails(circleid,consumerid,consumerNo);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/addorviewFieldInstallation");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping("exportFieldInstallation")
	@ResponseBody
	public void exportFieldInstallation(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("dataObj")FieldInstallationMaster masterObj
		){
		int records;
		int total;
		try {
			String headerKey = "Content-Disposition";
			String folderPath = "/tmp";
			String fileName = "FieldInstallationMasterDetails.csv";
			int noOfRecords=5000;
			StringBuilder dataStr = new StringBuilder();
			dataStr.append(ExportFieldInstallationHeader());
			appendFileData(folderPath, fileName, dataStr.toString(), response);
			String headerValue = String.format("attachment; filename=\"%s\"",
					fileName);
			response.setContentType("text/csv");
			response.setHeader(headerKey, headerValue);
			OutputStream outputStream = response.getOutputStream();
				
			List<FieldInstallationMaster> dataList = new ArrayList<FieldInstallationMaster>();
			
			Long totalRecords=daoObj.fetchFieldInstallationCount(masterObj);
			records = totalRecords.intValue();
			total = (int)Math.ceil(records /(double)noOfRecords );
			
			masterObj.setRows(noOfRecords);
			
				for(int i=1;i<=total;i++){
								
					masterObj.setPage(i);
					
					dataList = daoObj.fetchFieldInstallationMasterList(i-1,
							records, null,
							masterObj);
								for (FieldInstallationMaster fieldObj : dataList) {
									if(fieldObj.getId().getCircleid() != null && !fieldObj.getId().getCircleid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getId().getCircleid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getId().getConsumerNo() != null && !fieldObj.getId().getConsumerNo().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getId().getConsumerNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getId().getConsumerid() != null && !fieldObj.getId().getConsumerid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getId().getConsumerid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getConsId() != null && !fieldObj.getConsId().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getConsId() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDiscomid() != null && !fieldObj.getDiscomid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getDiscomid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDiscom() != null && !fieldObj.getDiscomid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getDiscom() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getBoardid() != null && !fieldObj.getBoardid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getBoardid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getBoard() != null && !fieldObj.getBoard().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getBoard() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCircle() != null && !fieldObj.getCircle() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCircle() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDivisionid() != null && !fieldObj.getDivisionid() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getDivisionid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getDivision() != null && !fieldObj.getDivision().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getDivision() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getSubdivisionid() != null && !fieldObj.getSubdivisionid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSubdivisionid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSubdivision() != null && !fieldObj.getSubdivision().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSubdivision() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSectionid() != null && !fieldObj.getSectionid().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSectionid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSection() != null && !fieldObj.getSection().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSection() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getRegistratonId() != null && !fieldObj.getRegistratonId() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getRegistratonId() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getName() != null && !fieldObj.getName().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getName() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getAddr() != null && !fieldObj.getAddr().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getAddr() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getConsumerCategory() != null && !fieldObj.getConsumerCategory() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getConsumerCategory() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCdKva() != null){
										dataStr.append(fieldObj.getCdKva() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getOfficePhone() != null && !fieldObj.getOfficePhone().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getOfficePhone() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMobileNo() != null && !fieldObj.getMobileNo() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMobileNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getEmailAddress() != null && !fieldObj.getEmailAddress() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getEmailAddress() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getLoadType() != null && !fieldObj.getLoadType() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getLoadType() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getPhase() != null && !fieldObj.getPhase() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getPhase() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSchedulePower() != null && !fieldObj.getSchedulePower() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSchedulePower() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCategory() != null && !fieldObj.getCategory() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCategory() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterCtType() != null && !fieldObj.getMeterCtType()  .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterCtType() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterOwnership() != null && !fieldObj.getMeterOwnership() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterOwnership() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterElecType() != null && !fieldObj.getMeterElecType() .equalsIgnoreCase("") ){
										dataStr.append(fieldObj.getMeterElecType() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getTransformerownership() != null && !fieldObj.getTransformerownership() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getTransformerownership() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getTransformerscapacity() != null && !fieldObj.getTransformerscapacity() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getTransformerscapacity() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getTransformermake() != null && fieldObj.getTransformermake() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getTransformermake() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getTransferLocation() != null && !fieldObj.getTransferLocation() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getTransferLocation() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getTransformerserialno() != null && !fieldObj.getTransformerserialno() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getTransformerserialno() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getIndependent() != null && !fieldObj.getIndependent()  .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getIndependent() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterno() != null && !fieldObj.getMeterno()  .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterno() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getHid() != null && !fieldObj.getHid() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getHid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getModemmeidnumber() != null && !fieldObj.getModemmeidnumber() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getModemmeidnumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getModemmdn() != null && !fieldObj.getModemmdn() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getModemmdn() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getModemnumber() != null && !fieldObj.getModemnumber() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getModemnumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMcc() != null && !fieldObj.getMcc() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMcc() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMnc() != null && !fieldObj.getMnc()  .equalsIgnoreCase("") ){
										dataStr.append(fieldObj.getMnc() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getLac() != null && !fieldObj.getLac() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getLac() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCellid() != null && !fieldObj.getCellid() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCellid() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSqual() != null && !fieldObj.getSqual() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSqual() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSrclev() != null && !fieldObj.getSrclev() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSrclev() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getImeiNumber() != null && !fieldObj.getImeiNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getImeiNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSimProviderName() != null && !fieldObj.getSimProviderName().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSimProviderName() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getModemmanufacturername() != null && !fieldObj.getModemmanufacturername().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getModemmanufacturername() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getLatitude() != null && !fieldObj.getLatitude().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getLatitude() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getLongitude() != null && !fieldObj.getLongitude() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getLongitude() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getPhotolocation() != null && !fieldObj.getPhotolocation() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getPhotolocation() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSubstation() != null && !fieldObj.getSubstation().equalsIgnoreCase("") ){
										dataStr.append(fieldObj.getSubstation() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSubstationCode() != null && !fieldObj.getSubstationCode().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSubstationCode() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getFeeder() != null && !fieldObj.getFeeder().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getFeeder() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getFeederCode() != null && !fieldObj.getFeederCode() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getFeederCode() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getFeedertype() != null && !fieldObj.getFeedertype() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getFeedertype() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDtname() != null && !fieldObj.getDtname().equalsIgnoreCase("")) {
										dataStr.append(fieldObj.getDtname() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDtcode() != null && !fieldObj.getDtcode().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getDtcode() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getPermanentpolenumber() != null && !fieldObj.getPermanentpolenumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getPermanentpolenumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getAcno() != null && !fieldObj.getAcno().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getAcno() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMCt() != null && !fieldObj.getMCt().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMCt() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMPt() != null && !fieldObj.getMPt().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMPt() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMf() != null ){
										dataStr.append(fieldObj.getMf() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMake() != null && !fieldObj.getMake().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMake() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterSealDate() != null && !fieldObj.getMeterSealDate() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterSealDate() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterSealNo() != null && !fieldObj.getMeterSealNo().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterSealNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterRevolutionPermit() != null && !fieldObj.getMeterRevolutionPermit().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterRevolutionPermit() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterMfgDate() != null && !fieldObj.getMeterMfgDate().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterMfgDate() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterDecimal() != null && !fieldObj.getMeterDecimal().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterDecimal() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterDigit() != null && !fieldObj.getMeterDigit().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterDigit() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterCapacity() != null && !fieldObj.getMeterCapacity().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterCapacity() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCurrentrating() != null && !fieldObj.getCurrentrating().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCurrentrating() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getVoltagerating() != null && !fieldObj.getVoltagerating().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getVoltagerating() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getConnectiondate() != null && !fieldObj.getConnectiondate().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getConnectiondate() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMeterChnageFlag() != null && !fieldObj.getMeterChnageFlag().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMeterChnageFlag() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getProprietorName() != null && !fieldObj.getProprietorName().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getProprietorName() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getDistrict() != null && !fieldObj.getDistrict().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getDistrict() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMunicipalityVdc() != null && !fieldObj.getMunicipalityVdc().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMunicipalityVdc() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getWardNo() != null && !fieldObj.getWardNo().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getWardNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCitizenshipNo() != null && !fieldObj.getCitizenshipNo().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCitizenshipNo() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCitizenshipIssuedDist() != null && !fieldObj.getCitizenshipIssuedDist().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCitizenshipIssuedDist() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getSupplyVoltage() != null && !fieldObj.getSupplyVoltage().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getSupplyVoltage() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getMfKva() != null && !fieldObj.getMfKva().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getMfKva() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getVersionNumber() != null && !fieldObj.getVersionNumber().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getVersionNumber() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getCreateddate() != null && !fieldObj.getCreateddate().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getCreateddate() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getStatus() != null && !fieldObj.getStatus().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getStatus() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getFlag1() != null && !fieldObj.getFlag1().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getFlag1() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getFlag2() != null && !fieldObj.getFlag2().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getFlag2() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									if(fieldObj.getBillDate() != null && !fieldObj.getBillDate().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getBillDate() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									if(fieldObj.getUssdCode() != null && !fieldObj.getUssdCode().equalsIgnoreCase("")){
										dataStr.append(fieldObj.getUssdCode() + ",");
									}else{
										dataStr.append("-"+ ",");
									}
									
									
									if(fieldObj.getOffSet() != null && !fieldObj.getOffSet() .equalsIgnoreCase("")){
										dataStr.append(fieldObj.getOffSet() + "\n");
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
	
	
	
	private Object ExportFieldInstallationHeader() {
		String header="";
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("CIRCLE ID,");
			sb.append("CONSUEMR NO,");
			sb.append("CONSUMER ID,");
			sb.append("CONS ID,");
			sb.append("DISCOM ID,");
			sb.append("DISCOM,");
			sb.append("BOARD ID,");
			sb.append("BOARD,");
			sb.append("CIRCLE,");
			sb.append("DIVISION ID,");
			sb.append("DIVISION,");
			sb.append("SUB DIVISION ID,");
			sb.append("SUB DIVISION,");
			sb.append("SECTION ID,");
			sb.append("SECTION,");
			sb.append("REGISTRATON ID,");
			sb.append("NAME,");
			sb.append("ADDR,");
			sb.append("CONSUMER CATEGORY,");
			sb.append("CDKVA,");
			sb.append("OFFICE PHONE,");
			sb.append("MOBILE NO,");
			sb.append("EMAIL ADDRESS,");
			sb.append("LOAD TYPE,");
			sb.append("PHASE,");
			sb.append("SCHEDULE POWER,");
			sb.append("CATEGORY,");
			sb.append("METER CT TYPE,");
			sb.append("METER OWNERSHIP,");
			sb.append("METER ELECTYPE,");
			sb.append("TRANSFORMER OWNERSHIP,");
			sb.append("TRANSFORMERS CAPACITY,");
			sb.append("TRANSFORMER MAKE,");
			sb.append("TRANSFER LOCATION,");
			sb.append("TRANSFORMER SERIAL NO,");
			sb.append("INDEPENDENT,");
			sb.append("METER NO,");
			sb.append("HID,");
			sb.append("MODEM MEID NUMBER,");
			sb.append("MODEM MDN,");
			sb.append("MODEM NUMBER,");
			sb.append("MCC,");
			sb.append("MNC,");
			sb.append("LAC,");
			sb.append("CELLID,");
			sb.append("SQUAL,");
			sb.append("SRCLEV,");
			sb.append("IMEI NUMBER,");
			sb.append("SIM PROVIDER NAME,");
			sb.append("MODEM MANUFACTURER NAME,");
			sb.append("LATITUDE,");
			sb.append("LONGITUDE,");
			sb.append("PHOTOLOCATION,");
			sb.append("SUBSTATION,");
			sb.append("SUB STATION CODE,");
			sb.append("FEEDER,");
			sb.append("FEEDER CODE,");
			sb.append("FEEDER TYPE,");
			sb.append("DTNAME,");
			sb.append("DTCODE,");
			sb.append("PERMANENT POLE NUMBER,");
			sb.append("ACNO,");
			sb.append("MCT,");
			sb.append("MPT,");
			sb.append("MF,");
			sb.append("MAKE,");
			sb.append("METER SEAL DATE,");
			sb.append("METER SEAL NO,");
			sb.append("METER REVOLUTION PERMIT,");
			sb.append("METER MFG DATE,");
			sb.append("METER DECIMAL,");
			sb.append("METER DIGIT,");
			sb.append("METER CAPACITY,");
			sb.append("CURRENT RATING,");
			sb.append("VOLTAGE RATING,");
			sb.append("CONNECTION DATE,");
			sb.append("METERCHNAGEF LAG,");
			sb.append("PROPRIETOR NAME,");
			sb.append("DISTRICT,");
			sb.append("MUNICIPALITY VDC,");
			sb.append("WARD NO,");
			sb.append("CITIZENSHIP NO,");
			sb.append("CITIZENSHIP ISSUED DIST,");
			sb.append("SUPPLY VOLTAGE,");
			sb.append("MFKVA,");
			sb.append("VERSION NUMBER,");
			sb.append("CREATED DATE,");
			sb.append("STATUS,");
			sb.append("FLAG1,");
			sb.append("FLAG2,");
			sb.append("BILL DATE,");
			sb.append("USSD CODE,");
			sb.append("OFFSET"+"\n");
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
	
	
	@RequestMapping("bulkFieldInstallationUpload")
	public ModelAndView bulkFieldInstallationUpload(@RequestParam("MeterDataupload") MultipartFile MeterDataupload,
			HttpServletRequest request){
		ModelAndView model = new ModelAndView("common/error.jsp");
		
		HashMap<String, String> rowDataMap = null; 
		boolean isSaved =false;
		int rowCount = 0;
		
		try {
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
			 	FieldInstallationMaster InsmasterObj = new FieldInstallationMaster();
				FieldInstallationMasterId InsmasterObjId  = new FieldInstallationMasterId();
			 	
				InsmasterObjId.setCircleid(rowDataMap.get("CIRCLE ID"));
				InsmasterObjId.setConsumerNo(rowDataMap.get("CONSUEMR NO"));
				InsmasterObjId.setConsumerid(rowDataMap.get("CONSUMER ID"));
				InsmasterObj.setConsId(rowDataMap.get("CONS ID"));
				InsmasterObj.setDiscomid(rowDataMap.get("DISCOM ID"));
				InsmasterObj.setDiscom(rowDataMap.get("DISCOM"));
				InsmasterObj.setBoardid(rowDataMap.get("BOARD ID"));
				InsmasterObj.setBoardid(rowDataMap.get("BOARD"));
				InsmasterObj.setCircle(rowDataMap.get("CIRCLE"));
				InsmasterObj.setDivisionid(rowDataMap.get("DIVISION ID"));
				InsmasterObj.setDivision(rowDataMap.get("DIVISION"));
				InsmasterObj.setSubdivision(rowDataMap.get("SUB DIVISION"));
				InsmasterObj.setSubdivisionid(rowDataMap.get("SUB DIVISION ID"));
				InsmasterObj.setSectionid(rowDataMap.get("SECTION ID"));
				InsmasterObj.setSection(rowDataMap.get("SECTION"));
				InsmasterObj.setRegistratonId(rowDataMap.get("REGISTRATON ID"));
				InsmasterObj.setName(rowDataMap.get("NAME"));
				InsmasterObj.setAddr(rowDataMap.get("ADDR"));
				InsmasterObj.setConsumerCategory(rowDataMap.get("CONSUMER CATEGORY"));
//				InsmasterObj.setCdKva(rowDataMap.get(Double.parseDouble("CDKVA")));
				InsmasterObj.setOfficePhone(rowDataMap.get("OFFICE PHONE"));
				InsmasterObj.setMobileNo(rowDataMap.get("MOBILE NO"));
				InsmasterObj.setEmailAddress(rowDataMap.get("EMAIL ADDRESS"));
				InsmasterObj.setLoadType(rowDataMap.get("LOAD TYPE"));
				InsmasterObj.setPhase(rowDataMap.get("PHASE"));
				InsmasterObj.setSchedulePower(rowDataMap.get("SCHEDULE POWER"));
				InsmasterObj.setCategory(rowDataMap.get("CATEGORY"));
				InsmasterObj.setMeterCtType(rowDataMap.get("METER CT TYPE"));
				InsmasterObj.setMeterOwnership(rowDataMap.get("METER OWNERSHIP"));
				InsmasterObj.setMeterElecType(rowDataMap.get("METER ELECTYPE"));
				InsmasterObj.setTransformerownership(rowDataMap.get("TRANSFORMER OWNERSHIP"));
				InsmasterObj.setTransformerscapacity(rowDataMap.get("TRANSFORMERS CAPACITY"));
				InsmasterObj.setTransformermake(rowDataMap.get("TRANSFORMER MAKE"));
				InsmasterObj.setTransferLocation(rowDataMap.get("TRANSFER LOCATION"));
				InsmasterObj.setTransformerserialno(rowDataMap.get("TRANSFORMER SERIAL NO"));
				InsmasterObj.setIndependent(rowDataMap.get("INDEPENDENT"));
				InsmasterObj.setMeterno(rowDataMap.get("METER NO"));
				InsmasterObj.setHid(rowDataMap.get("HID"));
				InsmasterObj.setModemmeidnumber(rowDataMap.get("MODEM MEID NUMBER"));
				InsmasterObj.setModemmdn(rowDataMap.get("MODEM MDN"));
				InsmasterObj.setModemnumber(rowDataMap.get("MODEM NUMBER"));
				InsmasterObj.setMcc(rowDataMap.get("MCC"));
				InsmasterObj.setMnc(rowDataMap.get("MNC"));
				InsmasterObj.setLac(rowDataMap.get("LAC"));
				InsmasterObj.setCellid(rowDataMap.get("CELLID"));
				InsmasterObj.setSqual(rowDataMap.get("SQUAL"));
				InsmasterObj.setSrclev(rowDataMap.get("SRCLEV"));
				InsmasterObj.setImeiNumber(rowDataMap.get("IMEI NUMBER"));
				InsmasterObj.setSimProviderName(rowDataMap.get("SIM PROVIDER NAME"));
				InsmasterObj.setModemmanufacturername(rowDataMap.get("MODEM MANUFACTURER NAME"));
				InsmasterObj.setLatitude(rowDataMap.get("LATITUDE"));
				InsmasterObj.setLongitude(rowDataMap.get("LONGITUDE"));
				InsmasterObj.setPhotolocation(rowDataMap.get("PHOTOLOCATION"));
				InsmasterObj.setSubstation(rowDataMap.get("SUBSTATION"));
				InsmasterObj.setSubstationCode(rowDataMap.get("SUB STATION CODE"));
				InsmasterObj.setFeeder(rowDataMap.get("FEEDER"));
				InsmasterObj.setFeederCode(rowDataMap.get("FEEDER CODE"));
				InsmasterObj.setFeedertype(rowDataMap.get("FEEDER TYPE"));
				InsmasterObj.setDtname(rowDataMap.get("DTNAME"));
				InsmasterObj.setDtcode(rowDataMap.get("DTCODE"));
				InsmasterObj.setPermanentpolenumber(rowDataMap.get("PERMANENT POLE NUMBER"));
				InsmasterObj.setAcno(rowDataMap.get("ACNO"));
				InsmasterObj.setMCt(rowDataMap.get("MCT"));
				InsmasterObj.setMPt(rowDataMap.get("MPT"));
//				InsmasterObj.setMf(Double.parseDouble(rowDataMap.get("MF")));
				InsmasterObj.setMake(rowDataMap.get("MAKE"));
				InsmasterObj.setMeterSealDate(rowDataMap.get("METER SEAL DATE"));
				InsmasterObj.setMeterSealNo(rowDataMap.get("METER SEAL NO"));
				InsmasterObj.setMeterRevolutionPermit(rowDataMap.get("METER REVOLUTION PERMIT"));
				InsmasterObj.setMeterMfgDate(rowDataMap.get("METER MFG DATE"));
				InsmasterObj.setMeterDecimal(rowDataMap.get("METER DECIMAL"));
				InsmasterObj.setMeterDigit(rowDataMap.get("METER DIGIT"));
				InsmasterObj.setMeterCapacity(rowDataMap.get("METER CAPACITY"));
				InsmasterObj.setCurrentrating(rowDataMap.get("CURRENT RATING"));
				InsmasterObj.setVoltagerating(rowDataMap.get("VOLTAGE RATING"));
				InsmasterObj.setConnectiondate(rowDataMap.get("CONNECTION DATE"));
				InsmasterObj.setMeterChnageFlag(rowDataMap.get("METERCHNAGEF LAG"));
				InsmasterObj.setProprietorName(rowDataMap.get("PROPRIETOR NAME"));
				InsmasterObj.setDistrict(rowDataMap.get("DISTRICT"));
				InsmasterObj.setMunicipalityVdc(rowDataMap.get("MUNICIPALITY VDC"));
				InsmasterObj.setWardNo(rowDataMap.get("WARD NO"));
				InsmasterObj.setCitizenshipNo(rowDataMap.get("CITIZENSHIP NO"));
				InsmasterObj.setCitizenshipIssuedDist(rowDataMap.get("CITIZENSHIP ISSUED DIST"));
				InsmasterObj.setSupplyVoltage(rowDataMap.get("SUPPLY VOLTAGE"));
				InsmasterObj.setMfKva(rowDataMap.get("MFKVA"));
				InsmasterObj.setVersionNumber(rowDataMap.get("VERSION NUMBER"));
				InsmasterObj.setCreateddate(rowDataMap.get("CREATED DATE"));
				InsmasterObj.setStatus(rowDataMap.get("STATUS"));
				InsmasterObj.setFlag1(rowDataMap.get("FLAG1"));
				InsmasterObj.setFlag2(rowDataMap.get("FLAG2"));
				InsmasterObj.setBillDate(rowDataMap.get("BILL DATE"));
				InsmasterObj.setUssdCode(rowDataMap.get("USSD CODE"));
				InsmasterObj.setOffSet(rowDataMap.get("OFFSET")); 
				InsmasterObj.setId(InsmasterObjId);
				 isSaved = commonDaoObj.saveOrUpdate(InsmasterObj);
				 if(isSaved){
					 model = new ModelAndView("redirect:/addorviewFieldInstallation");
				 }
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				return model;
	}
	
	
	
}
