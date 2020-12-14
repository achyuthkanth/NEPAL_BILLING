package com.analogics.um.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.ViewsMasterDAO;
import com.analogics.um.vo.ViewsMaster1;
import com.analogics.um.vo.ViewsMaster2;
import com.analogics.um.vo.ViewsMaster3;
import com.analogics.um.vo.ViewsMaster4;


/**
 * 
 * @author achyuth kanth pamuru
 *
 */
@Controller
public class ViewsmasterController {
	
	@RequestMapping("/viewsMaster")
	public ModelAndView viewViewsMaster(@ModelAttribute("ViewsMaster2") ViewsMaster2 viewsMaster){
		ModelAndView model=null;
		ViewsMasterDAO daoObj=new ViewsMasterDAO();
		try {
			
			Integer viewLevel=viewsMaster.getViewLevel();
			if(viewLevel==null){
				viewLevel=1;
			}else{
				viewLevel=viewLevel+1;
			}
			
			if(viewLevel!=null&&viewLevel==1){
				viewsMaster.setViewMasterList(daoObj.fetchAllViewsMaster1());
			}else{
				viewsMaster.setViewMasterList(daoObj.fetchAllViewsMaster2(viewLevel, viewsMaster.getParentview()));
			}
			
			viewsMaster.setViewLevel(viewLevel);
			model=new ModelAndView("/ViewsMaster/AddOrViewViews","command",viewsMaster);
			model.addObject("command", fetchModuleMasterColumsMap(viewsMaster));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("/fetchViewDetails")
	public ModelAndView fetchViewDetails(@ModelAttribute("ViewsMaster2") ViewsMaster2 viewsMaster){
		ModelAndView model=null;
		ViewsMasterDAO daoObj=new ViewsMasterDAO();
		try {
			Integer viewLevel=viewsMaster.getViewLevel();
			viewLevel++;
			viewsMaster.setViewMasterList(daoObj.fetchAllViewsMaster2(viewLevel, viewsMaster.getParentview()));
			viewsMaster.setViewLevel(viewLevel);
			viewsMaster.setViewname(null);
			model=new ModelAndView("/ViewsMaster/AddOrViewViews","command",viewsMaster);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping("/deleteViewDetails")
	public ModelAndView deleteViewDetails(@ModelAttribute("ViewsMaster2") ViewsMaster2 viewsMaster){
		ModelAndView model=null;
		ViewsMasterDAO daoObj=new ViewsMasterDAO();
		try {
			boolean isDeleted=daoObj.deleteViewDetails(viewsMaster.getViewLevel(), viewsMaster.getViewname());
			
			if(isDeleted==true){
				viewsMaster.setResponse("success");
				viewsMaster.setReasonResponse("View Deleted Successfully...!!!");
			}else{
				viewsMaster.setResponse("failure");
				viewsMaster.setReasonResponse("Failed to Delete View Details.Please try Again");
			}
			
			viewsMaster.setViewLevel(viewsMaster.getViewLevel()-1);
			model=viewViewsMaster(viewsMaster);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping("/saveViewsMaster")
	public ModelAndView saveViewsMaster(@ModelAttribute("ViewsMaster2") ViewsMaster2 viewsMaster){
		ModelAndView model=null;
		 boolean isSaved=false;
		try {
			CommonDAO daoObj = new CommonDAO();
			
			if(viewsMaster.getViewLevel()==1){
				ViewsMaster1 viewMaster=new ViewsMaster1();
				viewMaster.setActionname(viewsMaster.getActionname());
				viewMaster.setViewdescription(viewsMaster.getViewdescription());
				viewMaster.setViewname(viewsMaster.getViewname());
				isSaved= daoObj.saveOrUpdate(viewMaster); 
			}else if(viewsMaster.getViewLevel()==2){
				ViewsMaster2 viewMaster=new ViewsMaster2();
				viewMaster.setActionname(viewsMaster.getActionname());
				viewMaster.setViewdescription(viewsMaster.getViewdescription());
				viewMaster.setViewname(viewsMaster.getViewname());
				viewMaster.setParentview(viewsMaster.getParentview());
				isSaved= daoObj.saveOrUpdate(viewMaster); 
			}else if(viewsMaster.getViewLevel()==3){
				ViewsMaster3 viewMaster=new ViewsMaster3();
				viewMaster.setActionname(viewsMaster.getActionname());
				viewMaster.setViewdescription(viewsMaster.getViewdescription());
				viewMaster.setViewname(viewsMaster.getViewname());
				viewMaster.setParentview(viewsMaster.getParentview());
				isSaved= daoObj.saveOrUpdate(viewMaster); 
			}else if(viewsMaster.getViewLevel()==4){
				ViewsMaster4 viewMaster=new ViewsMaster4();
				viewMaster.setActionname(viewsMaster.getActionname());
				viewMaster.setViewdescription(viewsMaster.getViewdescription());
				viewMaster.setViewname(viewsMaster.getViewname());
				viewMaster.setParentview(viewsMaster.getParentview());
				isSaved= daoObj.saveOrUpdate(viewMaster); 
			}
			
			if(isSaved==true){
				viewsMaster.setResponse("success");
				viewsMaster.setReasonResponse("View Saved Successfully...!!!");
			}else{
				viewsMaster.setResponse("failure");
				viewsMaster.setReasonResponse("Failed to save View Details.Please try Again");
			}
			
			viewsMaster.setViewLevel(viewsMaster.getViewLevel()-1);
			viewsMaster.setViewdescription(null);
			viewsMaster.setActionname(null);
			viewsMaster.setViewname(null);

			model=viewViewsMaster(viewsMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping("/editViewData")
	public ModelAndView editViewData(@ModelAttribute("ViewsMaster2") ViewsMaster2 viewsMaster){
		ModelAndView model=null;
		ViewsMasterDAO daoObj=new ViewsMasterDAO();
		try {
			
			viewsMaster=daoObj.fetchViewData(viewsMaster.getViewLevel(), viewsMaster.getViewname(), viewsMaster.getParentview());
			
			if(viewsMaster.getViewLevel()!=null&&viewsMaster.getViewLevel()==1){
				viewsMaster.setViewMasterList(daoObj.fetchAllViewsMaster1());
			}else{
				viewsMaster.setViewMasterList(daoObj.fetchAllViewsMaster2(viewsMaster.getViewLevel(), viewsMaster.getParentview()));
			}
			model=new ModelAndView("/ViewsMaster/AddOrViewViews","command",viewsMaster);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	private Object fetchModuleMasterColumsMap(ViewsMaster2 viewsMaster) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Module Type Name");
			columnsMap.put("2", "Module Type Code");
			columnsMap.put("3", "Module Description");
			viewsMaster.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("moduleTypeName", "MODULE TYPE NAME");
			searchColumnsMap.put("moduleTypeCode", "MODULE TYPE CODE");
			searchColumnsMap.put("moduleDescription", "MODULE DESCRIPTION");
			viewsMaster.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			viewsMaster.setConditionListStr(conditionListStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewsMaster;
	}
	
}
