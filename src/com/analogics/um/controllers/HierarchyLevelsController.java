package com.analogics.um.controllers;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.LevelIndexMasterId;
import com.analogics.um.vo.ServerDataTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HierarchyLevelsController {
	HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@RequestMapping("viewHierarchyLevels")
	public ModelAndView viewHierarchyLevels() {
		ModelAndView model = new ModelAndView("common/error.jsp");
		HierarchyLevelsVo hierObj = new HierarchyLevelsVo();
		Map<String, String> levelMap = new HashMap<String, String>();
		try {
			model = new ModelAndView(
					"HierarchyLevels/AddOrViewHierarchyLevels", "command",
					hierObj);
			levelMap = daoObj.nextLevelsMap("0", "-1");
			levelMap.put("NEW LEVEL", "NEW LEVEL");
			model.addObject("level1Map", levelMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	// to load hierarchies on hiearachy base//
	@RequestMapping("/hierarchylevelsmap")
	public void hierarchylevelmapping(String levelCount, String levelValue,
			Writer writer) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String jsonArray = gson.toJson(daoObj.nextLevelsMap(levelCount,
				levelValue));
		writer.write(jsonArray);
	}

	// ServerDataTable//
	@SuppressWarnings("unchecked")
	@RequestMapping("/fetchHierarchies")
	public @ResponseBody
	String fetchHierarchies(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("iSortCol_0") String sCol,
			@ModelAttribute("hierarchyObj") HierarchyLevelsVo hierarchyObj) {

		String json = null;
		try {
			List<HierarchyLevelsVo> masterList = new ArrayList<HierarchyLevelsVo>();
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);

			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			masterList = daoObj.fetchHierarchyData(hierarchyObj, pageNumber,
					Integer.parseInt(pageDisplayLength), sorting,
					searchParameter, sCol);
			Long count = daoObj.fetchHierarchyDataCount(hierarchyObj,
					pageNumber, Integer.parseInt(pageDisplayLength), sorting,
					searchParameter, sCol);

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());

			dataTable.setAaData(masterList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	// save hierarchies on hiearachy base//

	@RequestMapping("saveHierarchyDetails")
	public ModelAndView saveHierarchyDetails(
			@ModelAttribute("hierObj") HierarchyLevelsVo hierObj,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("HierarchyLevels/error.jsp");

		try {
			Map<String, String> levelMap = new HashMap<String, String>();
			UserHierUtils utilsObj = new UserHierUtils();
			levelMap.put("level1Id",
					utilsObj.getlevelId(hierObj.getLevel1Id() + ""));
			levelMap.put("level2Id",
					utilsObj.getlevelId(hierObj.getLevel2Id() + ""));
			levelMap.put("level3Id",
					utilsObj.getlevelId(hierObj.getLevel3Id() + ""));
			levelMap.put("level4Id",
					utilsObj.getlevelId(hierObj.getLevel4Id() + ""));
			levelMap.put("level5Id",
					utilsObj.getlevelId(hierObj.getLevel5Id() + ""));
			levelMap.put("level6Id",
					utilsObj.getlevelId(hierObj.getLevel6Id() + ""));
			levelMap.put("level7Id",
					utilsObj.getlevelId(hierObj.getLevel7Id() + ""));
			levelMap.put("level8Id",
					utilsObj.getlevelId(hierObj.getLevel8Id() + ""));
			levelMap.put("level9Id",
					utilsObj.getlevelId(hierObj.getLevel9Id() + ""));
			levelMap.put("level10Id",
					utilsObj.getlevelId(hierObj.getLevel10Id() + ""));
			levelMap.put("level11Id",
					utilsObj.getlevelId(hierObj.getLevel11Id() + ""));
			levelMap.put("level12Id",
					utilsObj.getlevelId(hierObj.getLevel12Id() + ""));
			levelMap.put("level13Id",
					utilsObj.getlevelId(hierObj.getLevel13Id() + ""));
			levelMap.put("level14Id",
					utilsObj.getlevelId(hierObj.getLevel14Id() + ""));
			levelMap.put("level15Id",
					utilsObj.getlevelId(hierObj.getLevel15Id() + ""));

			LevelIndexMaster levelIndexObj = utilsObj
					.levelIndexDetails(levelMap);
			hierObj.setLevelIndexObj(levelIndexObj);
			int IndexId = daoObj.fetchIndexId(levelIndexObj);
			boolean isSaved = daoObj.saveNewHierarchyLevel(hierObj, IndexId);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/viewHierarchyLevels");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/saveHierarchies",method=RequestMethod.POST)  
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file,HttpSession session)
	{
 		@SuppressWarnings("unused")
		String response="error";
		String levelName=null;
		String levelCode=null;
		String uniqueCode = null;
		Integer level1Id=0;
		Integer level2Id=0;
		Integer levelId=0;
		
		String fileName=file.getOriginalFilename();
		
		LevelIndexMaster levelMasterObj=new LevelIndexMaster();
		LevelIndexMasterId levelMasterIdObj=new LevelIndexMasterId();
		try {
			File file1=new File("/tmp/"+fileName); 
			file.transferTo(file1);
//			System.out.println(file1);
			
			List<String> dataList= FileUtils.readLines(file1);
			
			for(String data:dataList)
			{
				try {
					String[] HierarchyData=data.split("\\,",-1);
					Map<String,String> levelMap=new HashMap<String,String>();
					
					Integer levelCount=1;
					for(int i=0;i<HierarchyData.length;i=i+2){
						String levelname=HierarchyData[i];
						String levelcode=HierarchyData[i+1];
						
						levelMap.put("level"+levelCount+"name", levelname);
						levelMap.put("level"+levelCount+"code", levelcode);
						
						levelCount++;
					}
					
//					System.out.println(levelMap);
					
					levelName=levelMap.get("level1name");
					levelCode=levelMap.get("level1code");
					
					Map<Integer,Integer> levelIndexMap=new HashMap<Integer,Integer>();
				
					try {
						
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel1(level1Id,levelName,levelCode,uniqueCode);
						levelIndexMap.put(1, levelId);
						}
						
						levelName=levelMap.get("level2name");
						levelCode=levelMap.get("level2code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,2);
						levelIndexMap.put(2, levelId);
						}
						
						
						levelName=levelMap.get("level3name");
						levelCode=levelMap.get("level3code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,3);
						levelIndexMap.put(3, levelId);
						}
						
						levelName=levelMap.get("level4name");
						levelCode=levelMap.get("level4code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,4);
						levelIndexMap.put(4, levelId);
						}
						
						levelName=levelMap.get("level5name");
						levelCode=levelMap.get("level5code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,5);
						levelIndexMap.put(5, levelId);
						}
						
						levelName=levelMap.get("level6name");
						levelCode=levelMap.get("level6code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,6);
						levelIndexMap.put(6, levelId);
						}
						
						levelName=levelMap.get("level7name");
						levelCode=levelMap.get("level7code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,7);
						levelIndexMap.put(7, levelId);
						}
						
						levelName=levelMap.get("level8name");
						levelCode=levelMap.get("level8code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,8);
						levelIndexMap.put(8, levelId);
						}
						levelName=levelMap.get("level9name");
						levelCode=levelMap.get("level9code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,9);
						levelIndexMap.put(9, levelId);
						}
						
						levelName=levelMap.get("level10name");
						levelCode=levelMap.get("level10code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,10);
						levelIndexMap.put(10, levelId);
						}
						
						levelName=levelMap.get("level11name");
						levelCode=levelMap.get("level11code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,11);
						levelIndexMap.put(11, levelId);
						}
						
						levelName=levelMap.get("level12name");
						levelCode=levelMap.get("level12code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,12);
						levelIndexMap.put(12, levelId);
						}
						
						levelName=levelMap.get("level13name");
						levelCode=levelMap.get("level13code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,13);
						levelIndexMap.put(13, levelId);
						}
						
						levelName=levelMap.get("level14name");
						levelCode=levelMap.get("level14code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,14);
						levelIndexMap.put(14, levelId);
						}
						
						levelName=levelMap.get("level15name");
						levelCode=levelMap.get("level15code");
						if(levelName!=null){
						levelId=daoObj.saveHierarchyLevel(level2Id,levelName,levelCode,uniqueCode,levelId,15);
						levelIndexMap.put(15, levelId);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					if(levelIndexMap.get(1) !=null){
						levelMasterIdObj.setLevel1id(levelIndexMap.get(1));
					}else{
						levelMasterIdObj.setLevel1id(-1);
					}
					
					if(levelIndexMap.get(2) !=null){
						levelMasterIdObj.setLevel2id(levelIndexMap.get(2));
					}else{
						levelMasterIdObj.setLevel2id(-1);
					}
					
					if(levelIndexMap.get(3) !=null){
						levelMasterIdObj.setLevel3id(levelIndexMap.get(3));					
						}else{
						levelMasterIdObj.setLevel3id(-1);
					}
					
					if(levelIndexMap.get(4) !=null){
						levelMasterIdObj.setLevel4id(levelIndexMap.get(4));
					}else{
						levelMasterIdObj.setLevel4id(-1);
					}
					
					if(levelIndexMap.get(5) !=null){
						levelMasterIdObj.setLevel5id(levelIndexMap.get(5));
					}else{
						levelMasterIdObj.setLevel5id(-1);
					}
					
					if(levelIndexMap.get(6) !=null){
						levelMasterIdObj.setLevel6id(levelIndexMap.get(6));
					}else{
						levelMasterIdObj.setLevel6id(-1);
					}

					if(levelIndexMap.get(7) !=null){
						levelMasterIdObj.setLevel7id(levelIndexMap.get(7));
					}else{
						levelMasterIdObj.setLevel7id(-1);
					}

					if(levelIndexMap.get(8) !=null){
						levelMasterIdObj.setLevel8id(levelIndexMap.get(8));
					}else{
						levelMasterIdObj.setLevel8id(-1);
					}

					if(levelIndexMap.get(9) !=null){
						levelMasterIdObj.setLevel9id(levelIndexMap.get(9));
					}else{
						levelMasterIdObj.setLevel9id(-1);
					}

					if(levelIndexMap.get(10) !=null){
						levelMasterIdObj.setLevel10id(levelIndexMap.get(10));
					}else{
						levelMasterIdObj.setLevel10id(-1);
					}
					
					if(levelIndexMap.get(11) !=null){
						levelMasterIdObj.setLevel11id(levelIndexMap.get(11));
					}else{
						levelMasterIdObj.setLevel11id(-1);
					}
					
					if(levelIndexMap.get(12) !=null){
						levelMasterIdObj.setLevel12id(levelIndexMap.get(12));
					}else{
						levelMasterIdObj.setLevel12id(-1);
					}
				
					if(levelIndexMap.get(13) !=null){
						levelMasterIdObj.setLevel13id(levelIndexMap.get(13));
					}else{
						levelMasterIdObj.setLevel13id(-1);
					}
					
					if(levelIndexMap.get(14) !=null){
						levelMasterIdObj.setLevel14id(levelIndexMap.get(14));
					}else{
						levelMasterIdObj.setLevel14id(-1);
					}
					
					if(levelIndexMap.get(15) !=null){
						levelMasterIdObj.setLevel15id(levelIndexMap.get(15));
					}else{
						levelMasterIdObj.setLevel15id(-1);
					}
					levelMasterObj.setId(levelMasterIdObj);
					
					response=daoObj.saveHierarchyDetails(levelMasterObj);
					
				}catch (Exception e) {
			e.printStackTrace();
		}
	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/Hierarchies/newHierarchies");
	}
}
