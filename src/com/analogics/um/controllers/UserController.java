package com.analogics.um.controllers;

import java.io.IOException;
import java.sql.Timestamp;
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

import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.dao.UserMasterDao;
import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.BioUserDetails;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.utils.EncAndDecLogic;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class UserController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
	UserMasterDao userObj = new UserMasterDao();
	CommonDAO commonDaoObj = new CommonDAO();
	
	
	@RequestMapping("ViewNewUserMaster")
	public ModelAndView viewUserMaster(
			@ModelAttribute("userDetailsObj") BioUserDetails userDetailsObj,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> levelMap = new HashMap<String, String>();
		ModelAndView model = new ModelAndView("common/error");
		try {
			model = new ModelAndView("/NewUserMaster/AddOrViewUserMaster","command",userDetailsObj);
			levelMap = daoObj.nextLevelsMap("0", "-1");
			model.addObject("level1Map", levelMap);
			model.addObject("userDetailsObj", fetchUserDetails(userDetailsObj));
			model.addObject("command", fetchNewUserMasterColumsMap(userDetailsObj));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;

	}
	
	
	
	
	
	
	@RequestMapping("saveNewUserDetails")
	public ModelAndView saveNewUserDetails(@ModelAttribute("userDetailsObj") BioUserDetails userDetailsObj){
		ModelAndView model = new ModelAndView("common/error");
		boolean isSaved = false;
		Map<String, String> levelMap = new HashMap<String, String>();
		UserHierUtils UserHierarchyUtilsObj = new UserHierUtils();
		ApplicationMaster appMasterObj = new ApplicationMaster();
		try {
			levelMap.put("level1Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel1Id()))+"");
			levelMap.put("level2Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel2Id()))+"");
			levelMap.put("level3Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel3Id()))+"");
			levelMap.put("level4Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel4Id()))+"");
			levelMap.put("level5Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel5Id()))+"");
			levelMap.put("level6Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel6Id()))+"");
			levelMap.put("level7Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel7Id()))+"");
			levelMap.put("level8Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel8Id()))+"");
			levelMap.put("level9Id",
					Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj.getLevel9Id()))+"");
			levelMap.put("level10Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel10Id()))+"");
			levelMap.put("level11Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel11Id()))+"");
			levelMap.put("level12Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel12Id()))+"");
			levelMap.put("level13Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel13Id()))+"");
			levelMap.put("level14Id",Integer.parseInt( UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel14Id()))+"");
			levelMap.put("level15Id", Integer.parseInt(UserHierarchyUtilsObj.getlevelId(userDetailsObj
					.getLevel15Id() ))+"");
			
			
			LevelIndexMaster levelIndexObj = UserHierarchyUtilsObj
					.levelIndexDetails(levelMap);
			int IndexId = daoObj.fetchIndexId(levelIndexObj);
			if (levelIndexObj != null) {
				
				userDetailsObj.setIndexid(IndexId+"");
				userDetailsObj.setAppindexid("-1");
				userDetailsObj.setUserpassword(new EncAndDecLogic().encrypt(userDetailsObj
						.getUserpassword()));
					userDetailsObj.setInserteddate(new Timestamp(new Date().getTime()));
					userDetailsObj.setInserteduser("Super User");
					appMasterObj = userObj.fetchApplicationUniqueId(userDetailsObj.getLevel1Id());
					
					userDetailsObj.setApplicationuniqueid(appMasterObj.getApplicationuniqueid()+"");
					userDetailsObj.setOrganizationuniqueid(appMasterObj.getOrghierarchylevel()+"");
				
			}
			isSaved = commonDaoObj.saveOrUpdate(userDetailsObj);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/ViewNewUserMaster");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchNewUserMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchModuleMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") BioUserDetails newUserObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<BioUserDetails> newUserList = new ArrayList<BioUserDetails>();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				newUserList = userObj.fetchNewUserList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,newUserObj);
				count = userObj.fetchNewUserCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,newUserObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(newUserList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value ="/deleteNewUserMaster", method = RequestMethod.GET)
	public ModelAndView deleteNewUserMaster(@RequestParam("userId") String userId ){
		ModelAndView model =new ModelAndView("common/error");
		boolean isDeleted = false;
		try {
			isDeleted = userObj.deleteNewUserMaster(userId);
			if (isDeleted == true) {
				model = new ModelAndView("redirect:/ViewNewUserMaster");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/editNewUserMaster" )
	public ModelAndView editNewUserMaster(HttpServletRequest request,
			HttpServletResponse resp, @RequestParam("userId") String userId,@RequestParam("viewType") String viewType,HttpServletResponse response){
		ModelAndView model =new ModelAndView("common/error");
		BioUserDetails detaisObj = new BioUserDetails();
		try {
			HttpSession session = request.getSession();
			UserLoginDetails UserSessionObj = (UserLoginDetails) session
					.getAttribute("sessionObj");
			detaisObj = userObj.editNewUserDetails(userId);
			model = new ModelAndView("/NewUserMaster/AddOrViewUserMaster","command",detaisObj);
			
				try {
					userObj.fetchLevelIndexMasterDetails(detaisObj);
					model.addObject("level1Id", detaisObj.getLevel1Id());
					model.addObject("level2Id", detaisObj.getLevel2Id());
					model.addObject("level3Id", detaisObj.getLevel3Id());
					model.addObject("level4Id", detaisObj.getLevel4Id());
					model.addObject("level5Id", detaisObj.getLevel5Id());
					model.addObject("level6Id", detaisObj.getLevel6Id());
					model.addObject("level7Id", detaisObj.getLevel7Id());
					model.addObject("level8Id", detaisObj.getLevel8Id());
					model.addObject("level9Id", detaisObj.getLevel9Id());
					model.addObject("level10Id", detaisObj.getLevel10Id());
					model.addObject("level11Id", detaisObj.getLevel11Id());
					model.addObject("level12Id", detaisObj.getLevel12Id());
					model.addObject("level13Id", detaisObj.getLevel13Id());
					model.addObject("level14Id", detaisObj.getLevel14Id());
					model.addObject("level15Id", detaisObj.getLevel15Id());
            
				model.addObject("level1Map", UserSessionObj.getLevel1Map());
				model.addObject("level2Map", daoObj.nextLevelsMap("1",detaisObj.getLevel1Id()));
				model.addObject("level3Map", daoObj.nextLevelsMap("2",detaisObj.getLevel2Id()));
				model.addObject("level4Map", daoObj.nextLevelsMap("3",detaisObj.getLevel3Id()));
				model.addObject("level5Map", daoObj.nextLevelsMap("4",detaisObj.getLevel4Id()));
				model.addObject("level6Map", daoObj.nextLevelsMap("5",detaisObj.getLevel5Id()));
				model.addObject("level7Map", daoObj.nextLevelsMap("6",detaisObj.getLevel6Id()));
				model.addObject("level8Map", daoObj.nextLevelsMap("7",detaisObj.getLevel7Id()));
				model.addObject("level9Map", daoObj.nextLevelsMap("8",detaisObj.getLevel8Id()));
				model.addObject("level10Map", daoObj.nextLevelsMap("9",detaisObj.getLevel9Id()));
				model.addObject("level11Map", daoObj.nextLevelsMap("10",detaisObj.getLevel10Id()));
				model.addObject("level12Map",daoObj.nextLevelsMap("11",detaisObj.getLevel11Id()));
				model.addObject("level13Map",daoObj.nextLevelsMap("12",detaisObj.getLevel12Id()));
				model.addObject("level14Map",daoObj.nextLevelsMap("13",detaisObj.getLevel13Id()));
				model.addObject("level15Map",daoObj.nextLevelsMap("14",detaisObj.getLevel14Id()));
				model.addObject("detaisObj", fetchUserDetails(detaisObj));
				detaisObj.setViewType(viewType);
				} catch (Exception e) {
					e.printStackTrace();
				}
				detaisObj.setUserpassword(new EncAndDecLogic().decrypt(detaisObj.getUserpassword()));
		} catch (Exception e) {
		e.printStackTrace();
		}
		return model;
	}
	
	
	private Object fetchNewUserMasterColumsMap(BioUserDetails masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "User Id");
			columnsMap.put("2", "User Name");
			columnsMap.put("3", "Contact Address");
			columnsMap.put("4", "primary Contact");
			columnsMap.put("5", "User Status");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("userid", "USER ID");
			searchColumnsMap.put("username", "USER NAME");
			searchColumnsMap.put("userstatus", "USER STATUS");
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
	
	private BioUserDetails fetchUserDetails(BioUserDetails userDetailsObj) {
		try {
			
			List<String> userStatusList = new ArrayList<String>();
			userStatusList.add("ENABLE");
			userStatusList.add("DISABLE");
			userDetailsObj.setUserStatusList(userStatusList);
			userDetailsObj.setBioUserGroupList(userObj.fetchUserGroupList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetailsObj;
	}
	
	
}
