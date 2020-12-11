package com.analogics.um.controllers;

import java.io.IOException;
import java.util.ArrayList;
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

import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.ParamMasterDao;
import com.analogics.um.vo.ParamTable;
import com.analogics.um.vo.ParamTableId;
import com.analogics.um.vo.ServerDataTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 
 * @author Sandhya.B
 *
 */

@Controller
public class ParamMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	ParamMasterDao paramDaoObj = new ParamMasterDao();
	
	
	@RequestMapping("/paramDetailsAction")
	public ModelAndView paramDetailsAction() {
		ModelAndView model =null;
		ParamTable paramObj=new ParamTable();
		try {
			model =new ModelAndView("ParamMaster/AddOrViewParamTypeDetails",
					"command", paramObj);
			model.addObject("command", fetchParamMasterColumsMap(paramObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value="/getParamTypeDetails",method=RequestMethod.POST)
	public ModelAndView getParamTypeDetails(@RequestParam("paramType") String paramType){
		ModelAndView model =null;
		ParamTable paramObj=new ParamTable();
		ParamTableId paramObjId=new ParamTableId();
		try {
			paramObjId.setParamType(paramType);
			paramObj.setId(paramObjId);
			model = new ModelAndView("ParamMaster/AddOrViewParamTypeDetails",
					"command", paramObj);
			model.addObject("command", fetchParamMasterColumsMap(paramObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	private Object fetchParamMasterColumsMap(ParamTable paramObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "param Type");
			columnsMap.put("2", "Param Name");
			columnsMap.put("3", "Param Value");
			columnsMap.put("4", "Status");
			columnsMap.put("5", "Order No");
			paramObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("id.paramType", "PARAM TYPE");
			searchColumnsMap.put("id.paramName", "PARAM NAME");
			paramObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			paramObj.setConditionListStr(conditionListStr);
			
			Map<String, String> statusList=new HashMap<String, String>();
			statusList.put("ENABLE", "ENABLE");
			statusList.put("DISABLE", "DISABLE");
			paramObj.setParamStatusList(statusList);
			paramObj.setParamTypeList(paramDaoObj.fetchParamTypeList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paramObj;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchParamTypeDetailsData", method = RequestMethod.GET)
	public @ResponseBody
	String fetchParamTypeDetailsData(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ParamTable masterObj,
			@RequestParam("paramType") String paramType)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ParamTable> paramList = new ArrayList<ParamTable>();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				paramList = paramDaoObj.fetchParamMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj,paramType);
				count = paramDaoObj.fetchParamMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj,paramType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(paramList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/saveOrUpdateParamDetails",method=RequestMethod.POST)
 	 public ModelAndView saveOrUpdateParamDetails(@ModelAttribute("param")ParamTable param,HttpServletRequest request){
		CommonDAO daoObj = new CommonDAO();
		boolean isSaved = false;
		ModelAndView model = null;
		try {
//			param1.setParamType(param.getId().getParamType());
			isSaved = daoObj.saveOrUpdate(param);
			HttpSession session=request.getSession();
			session.setAttribute("currentParamType", param.getId().getParamType());
			if (isSaved == true) {
				model = new ModelAndView("redirect:/fetchParamTypeDetails");
			}else{
				model = new ModelAndView("common/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value="/fetchParamTypeDetails",method=RequestMethod.GET)
	public ModelAndView fetchParamTypeDetails(@ModelAttribute("paramobj") ParamTable paramobj,
			HttpServletResponse resp,HttpServletRequest request){
		HttpSession session=request.getSession();
		ParamTable paramObj=new ParamTable();
		ParamTableId paramObjId=new ParamTableId();
		ModelAndView model=null;
		try {
			if(paramobj.getParamType() !=null)
				paramObjId.setParamType(paramobj.getParamType());
				else{
					paramObjId.setParamType((String) session.getAttribute("currentParamType"));
				}
				paramObj.setId(paramObjId);
			    session.removeAttribute("currentParamType");
			    model = new ModelAndView("ParamMaster/AddOrViewParamTypeDetails",
						"command", paramObj);
			    model.addObject("command", fetchParamMasterColumsMap(paramObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return model;
	}
	
	
	@RequestMapping(value="/deleteParamTypeDetails",method=RequestMethod.POST)
	public ModelAndView deleteParamTypeDetails(@RequestParam("paramType") String paramType,
			@RequestParam("paramName") String paramName,HttpServletRequest request){
		ParamTable paramObj=new ParamTable();
		ModelAndView model=null;
		try {
			paramDaoObj.deleteParamTypeDetails(paramType,paramName);
			paramObj.setParamType(paramType);
			List<ParamTable> list=new ArrayList<ParamTable>();
			list=paramDaoObj.fetchParamDetails(paramType);
			
			if(list.size()==0){
				model = new ModelAndView("redirect:/paramDetailsAction","command",paramObj);
			}
			else{
				HttpSession session=request.getSession();
				session.setAttribute("currentParamType", paramObj.getParamType());
				model= new ModelAndView("redirect:/fetchParamTypeDetails");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/editParamTypeDetails",method=RequestMethod.POST)  
    public ModelAndView editParamTypeDetails(@RequestParam("paramType") String paramType,
    										@RequestParam("paramName") String paramName,
    										@RequestParam("viewType") String viewType){
		ParamTable paramObj = new ParamTable();
		ModelAndView model = null;
		try {
			paramObj=paramDaoObj.editParamTypeDetails(paramName,paramType);
			paramObj.setViewType(viewType);
			model = new ModelAndView("ParamMaster/AddOrViewParamTypeDetails",
					"command", paramObj);
			model.addObject("command", fetchParamMasterColumsMap(paramObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
}
