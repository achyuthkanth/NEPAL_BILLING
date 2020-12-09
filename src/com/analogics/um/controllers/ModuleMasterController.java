package com.analogics.um.controllers;

import java.io.IOException;
import java.util.ArrayList;
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

import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.ModulesDao;
import com.analogics.um.vo.ModuleDetails;
import com.analogics.um.vo.ModuleDetailsId;
import com.analogics.um.vo.ModuleMaster;
import com.analogics.um.vo.ServerDataTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Sandhya.B
 *
 */
@Controller
public class ModuleMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@RequestMapping("/moduleMasterDetails")
	public ModelAndView moduleMasterDetails(@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("ModuleDetails/AddOrViewModuleMaster",
					"command", masterObj);
			model.addObject("command", fetchModuleMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	private Object fetchModuleMasterColumsMap(ModuleMaster masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Module Type Name");
			columnsMap.put("2", "Module Type Code");
			columnsMap.put("3", "Module Description");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("moduleTypeName", "MODULE TYPE NAME");
			searchColumnsMap.put("moduleTypeCode", "MODULE TYPE CODE");
			searchColumnsMap.put("moduleDescription", "MODULE DESCRIPTION");
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchModuleMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchModuleMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ModuleMaster masterObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ModuleMaster> modulesList = new ArrayList<ModuleMaster>();
		ModulesDao masterDaoObj = new ModulesDao();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				modulesList = masterDaoObj.fetchModuleMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
				count = masterDaoObj.fetchModuleMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(modulesList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/saveOrUpdateModuleMaster")
	public ModelAndView saveOrUpdateModuleMaster(
			@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModelAndView model = null;
		boolean isSaved = false;
		try {
			CommonDAO daoObj = new CommonDAO();
			isSaved = daoObj.saveOrUpdate(masterObj);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/moduleMasterDetails");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/deleteModuleMaster", method = RequestMethod.GET)
	public ModelAndView deleteModuleMaster(
			@RequestParam("moduleTypeName") String moduleTypeName) {
		ModelAndView model = null;
		boolean isDeleted = false;
		ModulesDao masterDaoObj = new ModulesDao();
		try {
			isDeleted = masterDaoObj.deleteModuleMaster(moduleTypeName);
			if (isDeleted == true) {
				model = new ModelAndView("redirect:/moduleMasterDetails");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/viewModuleMaster", method = RequestMethod.POST)
	public ModelAndView viewModuleMaster(@RequestParam("moduleTypeName") String moduleTypeName,
			@RequestParam("viewType") String viewType) {
		ModelAndView model = null;
		ModuleMaster masterObj = new ModuleMaster();
		ModulesDao masterDaoObj = new ModulesDao();
		try {
			masterObj = masterDaoObj.fetchModuleMasterData(moduleTypeName);
			masterObj.setViewType(viewType);
			model =new ModelAndView("ModuleDetails/AddOrViewModuleMaster",
					"command", masterObj);
			model.addObject("command", fetchModuleMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("/fetchOrAddModuleDetails")
	public ModelAndView fetchOrAddModuleDetails(
			@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModuleDetails detailsObj = new ModuleDetails();
		ModuleDetailsId detailsObjId = new ModuleDetailsId();
		ModelAndView model = null;
		try {
			detailsObjId.setModuleTypeName(masterObj.getModuleTypeName());
			detailsObj.setId(detailsObjId);
			model = new ModelAndView("ModuleDetails/AddOrViewModuleDetails",
					"command", detailsObj);
			model.addObject("command", fetchModuleDetailsColumsMap(detailsObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	private Object fetchModuleDetailsColumsMap(ModuleDetails masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Module Type Name");
			columnsMap.put("2", "Module Action");
			columnsMap.put("3", "Module Description");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("id.moduleAction", "MODULE TYPE NAME");
			searchColumnsMap.put("id.moduleTypeName", "MODULE ACTION");
			searchColumnsMap.put("moduledescription", "MODULE DESCRIPTION");
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
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchModuleViewDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchModuleViewDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("detailsObj") ModuleDetails detailsObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ModuleDetails> detailsList = new ArrayList<ModuleDetails>();
		ModulesDao masterDaoObj = new ModulesDao();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				detailsList = masterDaoObj.fetchModuleDetailsList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,detailsObj);
				count = masterDaoObj.fetchModuleDetailsCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,detailsObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(detailsList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/saveOrUpdateModuleDetails")
	public ModelAndView saveOrUpdateModuleDetails(
			@ModelAttribute("moduleDetails") ModuleDetails detailsObj) {
		ModelAndView model = null;
		boolean isSaved = false;
		CommonDAO daoObj = new CommonDAO();
		try {
			isSaved = daoObj.saveOrUpdate(detailsObj);
			if (isSaved == true) {
				ModuleDetailsId detailsObjId = new ModuleDetailsId();
				detailsObj.setModuledescription(null);
				detailsObjId.setModuleAction(null);
				detailsObjId.setModuleTypeName(detailsObj.getId().getModuleTypeName());
				detailsObj.setId(detailsObjId);
				model =new ModelAndView("ModuleDetails/AddOrViewModuleDetails",
						"command", detailsObj);
				model.addObject("command", fetchModuleDetailsColumsMap(detailsObj));
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value="/viewModuleDetails",method= RequestMethod.POST)
	public ModelAndView viewModuleDetails(
			@ModelAttribute("moduleDetails") ModuleDetails masterObj){
		ModelAndView model=null;
		ModulesDao masterDaoObj = new ModulesDao();
		ModuleDetails detailsObj = new ModuleDetails();
		try {
			detailsObj = masterDaoObj.fetchModuleDetails(masterObj.getId().getModuleTypeName(),
					masterObj.getId().getModuleAction());
			detailsObj.setViewType(masterObj.getViewType());
			model =new ModelAndView("ModuleDetails/AddOrViewModuleDetails",
					"command", detailsObj);
			model.addObject("command", fetchModuleDetailsColumsMap(detailsObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping(value="/deleteModuleDetails" ,method= RequestMethod.POST)
	public ModelAndView deleteModuleDetails(
			@ModelAttribute("moduleDetails") ModuleDetails detailsObj){
		ModelAndView model = null;
		 boolean isDeleted=false;
		 ModulesDao masterDaoObj = new ModulesDao();
		try {
			isDeleted= masterDaoObj.deleteModuleDetails(detailsObj.getId().getModuleTypeName(),
					detailsObj.getId().getModuleAction());
			if(isDeleted==true){
				ModuleDetailsId detailsObjId = new ModuleDetailsId();
				detailsObj.setModuledescription(null);
				detailsObjId.setModuleAction(null);
				detailsObjId.setModuleTypeName(detailsObj.getId().getModuleTypeName());
				detailsObj.setId(detailsObjId);
				model =new ModelAndView("ModuleDetails/AddOrViewModuleDetails",
						"command", detailsObj);
				model.addObject("command", fetchModuleDetailsColumsMap(detailsObj));
			 }else{
				model = new ModelAndView("common/error");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
}
