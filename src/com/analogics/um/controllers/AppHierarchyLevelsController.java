package com.analogics.um.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.vo.ApplicationLevelIndexMaster;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class AppHierarchyLevelsController {
	HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	
	@RequestMapping("viewAppHierarchyLevels")
	public ModelAndView viewHierarchyLevels() {
		ModelAndView model = new ModelAndView("common/error.jsp");
		HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
		Map<String, String> levelMap = new HashMap<String, String>();
		HierarchyLevelsVo hierObj = new HierarchyLevelsVo();
		try {
			model = new ModelAndView(
					"AppHierarchyLevels/AddOrViewAppHierarchyLevels", "command",
					hierObj);
			levelMap = daoObj.AppnextLevelsMap("0", "-1");
			levelMap.put("NEW LEVEL", "NEW LEVEL");
			model.addObject("level1Map", levelMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping("saveAppHierarchyDetails")
	public ModelAndView saveHierarchyDetails(
			@ModelAttribute("hierObj") HierarchyLevelsVo hierObj,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("HierarchyLevels/error.jsp");

		try {
			Map<String, String> levelMap = new HashMap<String, String>();
			UserHierUtils utilsObj = new UserHierUtils();
			levelMap.put("level1Id",
					utilsObj.getlevelId(hierObj.getAppLevel1Id() + ""));
			levelMap.put("level2Id",
					utilsObj.getlevelId(hierObj.getAppLevel2Id() + ""));
			levelMap.put("level3Id",
					utilsObj.getlevelId(hierObj.getAppLevel3Id() + ""));
			levelMap.put("level4Id",
					utilsObj.getlevelId(hierObj.getAppLevel4Id() + ""));
			levelMap.put("level5Id",
					utilsObj.getlevelId(hierObj.getAppLevel5Id() + ""));
			levelMap.put("level6Id",
					utilsObj.getlevelId(hierObj.getAppLevel6Id() + ""));
			levelMap.put("level7Id",
					utilsObj.getlevelId(hierObj.getAppLevel7Id() + ""));
			levelMap.put("level8Id",
					utilsObj.getlevelId(hierObj.getAppLevel8Id() + ""));
			levelMap.put("level9Id",
					utilsObj.getlevelId(hierObj.getAppLevel9Id() + ""));
			levelMap.put("level10Id",
					utilsObj.getlevelId(hierObj.getAppLevel10Id() + ""));
			levelMap.put("level11Id",
					utilsObj.getlevelId(hierObj.getAppLevel11Id() + ""));
			levelMap.put("level12Id",
					utilsObj.getlevelId(hierObj.getAppLevel12Id() + ""));
			levelMap.put("level13Id",
					utilsObj.getlevelId(hierObj.getAppLevel13Id() + ""));
			levelMap.put("level14Id",
					utilsObj.getlevelId(hierObj.getAppLevel14Id() + ""));
			levelMap.put("level15Id",
					utilsObj.getlevelId(hierObj.getAppLevel15Id() + ""));

			ApplicationLevelIndexMaster levelIndexObj = utilsObj
					.appLevelIndexDetails(levelMap);
			hierObj.setAppLevelIndexObj(levelIndexObj);
			int IndexId = daoObj.fetchAppIndexId(levelIndexObj);
			boolean isSaved = daoObj.saveAppNewHierarchyLevel(hierObj, IndexId);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/viewHierarchyLevels");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
}
