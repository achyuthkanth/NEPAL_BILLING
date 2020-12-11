package com.analogics.um.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.ApplicationMasterDao;
import com.analogics.um.dao.CommonDAO;
import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.ServerDataTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 
 * @author Sandhya.B
 *
 */
@Controller
public class ApplicationMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@RequestMapping("/applicationMaster")
	public ModelAndView applicationMaster(@ModelAttribute("masterObj") ApplicationMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("ApplicationMaster/applicationMaster",
					"command", masterObj);
			model.addObject("command", fetchApplicationMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchApplicationMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchApplicationMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ApplicationMaster masterObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ApplicationMaster> appList = new ArrayList<ApplicationMaster>();
		ApplicationMasterDao masterDaoObj = new ApplicationMasterDao();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				appList = masterDaoObj.fetchApplicationMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
				count = masterDaoObj.fetchApplicationMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(appList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	@RequestMapping("/saveOrUpdateApplicationMaster")
	public ModelAndView saveOrUpdateApplicationMaster(
			@ModelAttribute("masterObj") ApplicationMaster masterObj,HttpServletRequest request) {
		ModelAndView model = null;
		boolean isSaved = false;
		CommonDAO daoObj = new CommonDAO();
		try {
//			HttpSession session = request.getSession();
//			UserLoginDetails userLoginSessionObj=(UserLoginDetails)session.getAttribute("sessionObj"); 
//			masterObj.setInserteduser(userLoginSessionObj.getBiouserdetails().getUserid());
			masterObj.setInserteddate(new Timestamp(new Date().getTime()));
			if(masterObj.getApplicationuniquecode()==null || masterObj.getApplicationuniquecode()==""){
				masterObj.setApplicationuniquecode(masterObj.getApplicationname());
			}
			isSaved = daoObj.saveOrUpdate(masterObj);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/applicationMaster");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/deleteApplicationMaster", method = RequestMethod.GET)
	public ModelAndView deleteApplicationMaster(
			@RequestParam("applicationuniquecode") String applicationuniquecode) {
		ModelAndView model = null;
		boolean isDeleted = false;
		ApplicationMasterDao masterDaoObj = new ApplicationMasterDao();
		try {
			isDeleted = masterDaoObj.deleteApplicationMaster(applicationuniquecode);
			if (isDeleted == true) {
				model = new ModelAndView("redirect:/applicationMaster");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/viewApplicationMaster", method = RequestMethod.POST)
	public ModelAndView viewApplicationMaster(@RequestParam("applicationuniquecode") String applicationuniquecode,
			@RequestParam("viewType") String viewType) {
		ModelAndView model = null;
		ApplicationMaster masterObj = new ApplicationMaster();
		ApplicationMasterDao masterDaoObj = new ApplicationMasterDao();
		try {
			masterObj = masterDaoObj.fetchApplicationMasterData(applicationuniquecode);
			masterObj.setViewType(viewType);
			model =new ModelAndView("ApplicationMaster/applicationMaster",
					"command", masterObj);
			model.addObject("command", fetchApplicationMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	private Object fetchApplicationMasterColumsMap(ApplicationMaster masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Application Unique Code");
			columnsMap.put("2", "Application Name");
			columnsMap.put("3", "Application Id");
			columnsMap.put("4", "Application Owner");
			columnsMap.put("5", "Primary Contact");
			columnsMap.put("6", "Alternate Contact");
			columnsMap.put("7", "Contact Address");
			columnsMap.put("8", "Email Address");
			columnsMap.put("9", "Persons Allowed");
			columnsMap.put("10", "Appusers Allowed");
			columnsMap.put("11", "Application Status");
			columnsMap.put("12", "Level1 Id");
			columnsMap.put("13", "Org Hierarchy Level");
			columnsMap.put("14", "Sub hierarchyLevel");
			columnsMap.put("15", "Sub HierarchyLevel Type");
			columnsMap.put("16", "Application Unique Id");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("applicationuniquecode", "APPLICATION UNIQUE CODE");
			searchColumnsMap.put("applicationname", "APPLICATION NAME");
			searchColumnsMap.put("applicationid", "APPLICATION ID");
			masterObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			masterObj.setConditionListStr(conditionListStr);
			
			Map<String, String> appstatusList = new HashMap<String, String>();
			appstatusList.put("ENABLE", "ENABLE");
			appstatusList.put("DISABLE", "DISABLE");
			masterObj.setApplicationStatusList(appstatusList);
			
			Map<String, String> organizationList = new HashMap<String, String>();
			organizationList.put("ORGANIZATION", "ORGANIZATION");
			organizationList.put("APPLICATION", "APPLICATION");
			masterObj.setOrganizationList(organizationList);
			masterObj.setLevelMapList(fetchLevelMapList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterObj;
	}
	
	private Map<Integer, String> fetchLevelMapList() {
		Map<Integer, String> levelMapList = new HashMap<Integer, String>();
		ApplicationMasterDao masterDaoObj = new ApplicationMasterDao();
		try {
			levelMapList = masterDaoObj.fetchLevelMapList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levelMapList;
	}
	

}
