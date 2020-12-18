package com.analogics.um.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.vo.ApplicationLevelIndexMaster;
import com.analogics.um.vo.ApplicationLevelIndexMasterId;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.LevelIndexMasterId;
import com.analogics.um.vo.UserLoginDetails;

public class UserHierUtils extends BaseHibernateDAO{
	
	public String getlevelId(String levelId){
		String response="-1";
		
		try{
			if(levelId.equalsIgnoreCase("undefined")){
				response="-1";
			}else if(levelId.equalsIgnoreCase("")){
				response="-1";
			}else if(levelId.equalsIgnoreCase("null")){
				response="-1";
			}else{
					response=levelId;
			}
		}catch (Exception e) {
			response="-1";
		}
		return response;
	}
	
	public LevelIndexMaster levelIndexDetails(Map<String,String> extraMap){
		LevelIndexMaster levelIndexMasterObj=new LevelIndexMaster();
		LevelIndexMasterId levelIndexMasterIdObj=new LevelIndexMasterId();
		
		try{
				levelIndexMasterIdObj.setLevel1id(Integer.parseInt(extraMap.get("level1Id")));
				levelIndexMasterIdObj.setLevel2id(Integer.parseInt(extraMap.get("level2Id")));
				levelIndexMasterIdObj.setLevel3id(Integer.parseInt(extraMap.get("level3Id")));
				levelIndexMasterIdObj.setLevel4id(Integer.parseInt(extraMap.get("level4Id")));
				levelIndexMasterIdObj.setLevel5id(Integer.parseInt(extraMap.get("level5Id")));
				levelIndexMasterIdObj.setLevel6id(Integer.parseInt(extraMap.get("level6Id")));
				levelIndexMasterIdObj.setLevel7id(Integer.parseInt(extraMap.get("level7Id")));
				levelIndexMasterIdObj.setLevel8id(Integer.parseInt(extraMap.get("level8Id")));
				levelIndexMasterIdObj.setLevel9id(Integer.parseInt(extraMap.get("level9Id")));
				levelIndexMasterIdObj.setLevel10id(Integer.parseInt(extraMap.get("level10Id")));
				levelIndexMasterIdObj.setLevel11id(Integer.parseInt(extraMap.get("level11Id")));
				levelIndexMasterIdObj.setLevel12id(Integer.parseInt(extraMap.get("level12Id")));
				levelIndexMasterIdObj.setLevel13id(Integer.parseInt(extraMap.get("level13Id")));
				levelIndexMasterIdObj.setLevel14id(Integer.parseInt(extraMap.get("level14Id")));
				levelIndexMasterIdObj.setLevel15id(Integer.parseInt(extraMap.get("level15Id")));
				levelIndexMasterObj.setId(levelIndexMasterIdObj);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return levelIndexMasterObj;
	}
	
	public LevelIndexMaster fetchIndexIdDetails(Map<String, Integer> levelMap) {
		LevelIndexMaster levelIndexMasterObj = null;

		Session session = null;
		try {
			session = getSession();

			StringBuilder strb = new StringBuilder();

			strb.append(" from LevelIndexMaster level where ");
			strb.append(" level.id.level1id=:level1Id");
			strb.append(" and level.id.level2id=:level2Id");
			strb.append(" and level.id.level3id=:level3Id");
			strb.append(" and level.id.level4id=:level4Id");
			strb.append(" and level.id.level5id=:level5Id");
			strb.append(" and level.id.level6id=:level6Id");
			strb.append(" and level.id.level7id=:level7Id");
			strb.append(" and level.id.level8id=:level8Id");
			strb.append(" and level.id.level9id=:level9Id");
			strb.append(" and level.id.level10id=:level10Id");
			strb.append(" and level.id.level11id=:level11Id");
			strb.append(" and level.id.level12id=:level12Id");
			strb.append(" and level.id.level13id=:level13Id");
			strb.append(" and level.id.level14id=:level14Id");
			strb.append(" and level.id.level15id=:level15Id");

			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("level1Id", levelMap.get("level1Id"));
			queryObj.setParameter("level2Id", levelMap.get("level2Id"));
			queryObj.setParameter("level3Id", levelMap.get("level3Id"));
			queryObj.setParameter("level4Id", levelMap.get("level4Id"));
			queryObj.setParameter("level5Id", levelMap.get("level5Id"));
			queryObj.setParameter("level6Id", levelMap.get("level6Id"));
			queryObj.setParameter("level7Id", levelMap.get("level7Id"));
			queryObj.setParameter("level8Id", levelMap.get("level8Id"));
			queryObj.setParameter("level9Id", levelMap.get("level9Id"));
			queryObj.setParameter("level10Id", levelMap.get("level10Id"));
			queryObj.setParameter("level11Id", levelMap.get("level11Id"));
			queryObj.setParameter("level12Id", levelMap.get("level12Id"));
			queryObj.setParameter("level13Id", levelMap.get("level13Id"));
			queryObj.setParameter("level14Id", levelMap.get("level14Id"));
			queryObj.setParameter("level15Id", levelMap.get("level15Id"));
			levelIndexMasterObj = (LevelIndexMaster) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelIndexMasterObj;
	}
	
	
	
	
	
	
	public String frameLevelIndexString(LevelIndexMaster levelIndexmasterObj){
		StringBuilder strb=new StringBuilder();
		if(levelIndexmasterObj.getId().getLevel1id()!=-1){
			strb.append(" index.id.level1id="+levelIndexmasterObj.getId().getLevel1id());
				if(levelIndexmasterObj.getId().getLevel2id()!=-1){
					strb.append(" and index.id.level2id="+levelIndexmasterObj.getId().getLevel2id());
					if(levelIndexmasterObj.getId().getLevel3id()!=-1){
						strb.append(" and  index.id.level3id="+levelIndexmasterObj.getId().getLevel3id());
						if(levelIndexmasterObj.getId().getLevel4id()!=-1){
							strb.append(" and  index.id.level4id="+levelIndexmasterObj.getId().getLevel4id());
							if(levelIndexmasterObj.getId().getLevel5id()!=-1){
								strb.append(" and  index.id.level5id="+levelIndexmasterObj.getId().getLevel5id());
								if(levelIndexmasterObj.getId().getLevel6id()!=-1){
									strb.append(" and  index.id.level6id="+levelIndexmasterObj.getId().getLevel6id());
									if(levelIndexmasterObj.getId().getLevel7id()!=-1){
										strb.append(" and  index.id.level7id="+levelIndexmasterObj.getId().getLevel7id());
										if(levelIndexmasterObj.getId().getLevel8id()!=-1){
											strb.append(" and  index.id.level8id="+levelIndexmasterObj.getId().getLevel8id());
											if(levelIndexmasterObj.getId().getLevel9id()!=-1){
												strb.append(" and  index.id.level9id="+levelIndexmasterObj.getId().getLevel9id());
												if(levelIndexmasterObj.getId().getLevel10id()!=-1){
													strb.append(" and  index.id.level10id="+levelIndexmasterObj.getId().getLevel10id());
													if(levelIndexmasterObj.getId().getLevel11id()!=-1){
														strb.append(" and  index.id.level11id="+levelIndexmasterObj.getId().getLevel11id());
														if(levelIndexmasterObj.getId().getLevel12id()!=-1){
															strb.append(" and  index.id.level12id="+levelIndexmasterObj.getId().getLevel12id());
															if(levelIndexmasterObj.getId().getLevel13id()!=-1){
																strb.append(" and  index.id.level13id="+levelIndexmasterObj.getId().getLevel13id());
																if(levelIndexmasterObj.getId().getLevel14id()!=-1){
																	strb.append(" and  index.id.level14id="+levelIndexmasterObj.getId().getLevel14id());
																	if(levelIndexmasterObj.getId().getLevel15id()!=-1){
																		strb.append(" and  index.id.level15id="+levelIndexmasterObj.getId().getLevel15id());
																	}
																}
															}
														}
													}
												}
											}
										}
										
									}
									
								}
							}
						}
					}
				}
			}
		return strb.toString();
	}
	
	//****			 framing Levels In Model  Object Based On hierarchy		****//

	public void fetchHierarchyLevels(ModelAndView model,
			UserLoginDetails userSessionObj,HierarchyLevelsVo hierarchyObj) {
		HierarchyLevelsDao hieDaoObj = new HierarchyLevelsDao();
		try {
			model.addObject("level1Id", hierarchyObj.getLevel1Id());
			model.addObject("level2Id", hierarchyObj.getLevel2Id());
			model.addObject("level3Id", hierarchyObj.getLevel3Id());
			model.addObject("level4Id", hierarchyObj.getLevel4Id());
			model.addObject("level5Id", hierarchyObj.getLevel5Id());
			model.addObject("level6Id", hierarchyObj.getLevel6Id());
			model.addObject("level7Id", hierarchyObj.getLevel7Id());
			model.addObject("level8Id", hierarchyObj.getLevel8Id());
			model.addObject("level9Id", hierarchyObj.getLevel9Id());
			model.addObject("level10Id", hierarchyObj.getLevel10Id());
			model.addObject("level11Id", hierarchyObj.getLevel11Id());
			model.addObject("level12Id", hierarchyObj.getLevel12Id());
			model.addObject("level13Id", hierarchyObj.getLevel13Id());
			model.addObject("level14Id", hierarchyObj.getLevel14Id());
			model.addObject("level15Id", hierarchyObj.getLevel15Id());
			
			model.addObject("level1Map", userSessionObj.getLevel1Map());
			if(!hierarchyObj.getLevel1Id().equalsIgnoreCase("-1")){
				model.addObject("level2Map", hieDaoObj.nextLevelsMap("1",hierarchyObj.getLevel1Id()));
			}
			if(!hierarchyObj.getLevel2Id().equalsIgnoreCase("-1")){
			model.addObject("level3Map", hieDaoObj.nextLevelsMap("2",hierarchyObj.getLevel2Id()));
			}
			if(!hierarchyObj.getLevel3Id().equalsIgnoreCase("-1")){
			model.addObject("level4Map", hieDaoObj.nextLevelsMap("3",hierarchyObj.getLevel3Id()));
			}
			if(!hierarchyObj.getLevel4Id().equalsIgnoreCase("-1")){
			model.addObject("level5Map", hieDaoObj.nextLevelsMap("4",hierarchyObj.getLevel4Id()));
			}
			if(!hierarchyObj.getLevel5Id().equalsIgnoreCase("-1")){
			model.addObject("level6Map", hieDaoObj.nextLevelsMap("5",hierarchyObj.getLevel5Id()));
			}
			if(!hierarchyObj.getLevel6Id().equalsIgnoreCase("-1")){
			model.addObject("level7Map", hieDaoObj.nextLevelsMap("6",hierarchyObj.getLevel6Id()));
			}
			if(!hierarchyObj.getLevel7Id().equalsIgnoreCase("-1")){
			model.addObject("level8Map", hieDaoObj.nextLevelsMap("7",hierarchyObj.getLevel7Id()));
			}
			if(!hierarchyObj.getLevel8Id().equalsIgnoreCase("-1")){
			model.addObject("level9Map", hieDaoObj.nextLevelsMap("8",hierarchyObj.getLevel8Id()));
			}
			if(!hierarchyObj.getLevel9Id().equalsIgnoreCase("-1")){
			model.addObject("level10Map", hieDaoObj.nextLevelsMap("9",hierarchyObj.getLevel9Id()));
			}
			if(!hierarchyObj.getLevel10Id().equalsIgnoreCase("-1")){
			model.addObject("level11Map", hieDaoObj.nextLevelsMap("10",hierarchyObj.getLevel10Id()));
			}
			if(!hierarchyObj.getLevel11Id().equalsIgnoreCase("-1")){
			model.addObject("level12Map",hieDaoObj.nextLevelsMap("11",hierarchyObj.getLevel11Id()));
			}
			if(!hierarchyObj.getLevel12Id().equalsIgnoreCase("-1")){
			model.addObject("level13Map",hieDaoObj.nextLevelsMap("12",hierarchyObj.getLevel12Id()));
			}
			if(!hierarchyObj.getLevel13Id().equalsIgnoreCase("-1")){
			model.addObject("level14Map",hieDaoObj.nextLevelsMap("13",hierarchyObj.getLevel13Id()));
			}
			if(!hierarchyObj.getLevel14Id().equalsIgnoreCase("-1")){
			model.addObject("level15Map",hieDaoObj.nextLevelsMap("14",hierarchyObj.getLevel14Id()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//****			Default framing Levels In Model  Object			****//

	public void frameLevelMaps(ModelAndView model,
			UserLoginDetails UserSessionObj) {
		Session session = null;
		try {
			session = getSession();
			model.addObject("level1Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel1id()+"");
			model.addObject("level2Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel2id()+"");
			model.addObject("level3Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel3id()+"");
			model.addObject("level4Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel4id()+"");
			model.addObject("level5Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel5id()+"");
			model.addObject("level6Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel6id()+"");
			model.addObject("level7Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel7id()+"");
			model.addObject("level8Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel8id()+"");
			model.addObject("level9Id", UserSessionObj.getLevelIndexMasterObj().getId().getLevel9id()+"");
			model.addObject("level10Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel10id()+"");
			model.addObject("level11Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel11id()+"");
			model.addObject("level12Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel12id()+"");
			model.addObject("level13Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel13id()+"");
			model.addObject("level14Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel14id()+"");
			model.addObject("level15Id",UserSessionObj.getLevelIndexMasterObj().getId().getLevel15id()+"");
			
			
			
			model.addObject("level1Map", UserSessionObj.getLevel1Map());
			model.addObject("level2Map", UserSessionObj.getLevel2Map());
			model.addObject("level3Map", UserSessionObj.getLevel3Map());
			model.addObject("level4Map", UserSessionObj.getLevel4Map());
			model.addObject("level5Map", UserSessionObj.getLevel5Map());
			model.addObject("level6Map", UserSessionObj.getLevel6Map());
			model.addObject("level7Map", UserSessionObj.getLevel7Map());
			model.addObject("level8Map", UserSessionObj.getLevel8Map());
			model.addObject("level9Map", UserSessionObj.getLevel9Map());
			model.addObject("level10Map", UserSessionObj.getLevel10Map());
			model.addObject("level11Map", UserSessionObj.getLevel11Map());
			model.addObject("level12Map", UserSessionObj.getLevel12Map());
			model.addObject("level13Map", UserSessionObj.getLevel13Map());
			model.addObject("level14Map", UserSessionObj.getLevel14Map());
			model.addObject("level15Map", UserSessionObj.getLevel15Map());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		
	}

	//		framing LevelindexMaster levels			//
	public void frameLevelIndexLevelMaps(UserHierUtils utilsObj,
			HierarchyLevelsVo hierVoObj, Map<String, Integer> levelMap) {
		levelMap.put("level1Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel1Id()+"")));
		levelMap.put("level2Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel2Id()+"")));
		levelMap.put("level3Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel3Id()+"")));
		levelMap.put("level4Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel4Id()+"")));
		levelMap.put("level5Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel5Id()+"")));
		levelMap.put("level6Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel6Id()+"")));
		levelMap.put("level7Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel7Id()+"")));
		levelMap.put("level8Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel8Id()+"")));
		levelMap.put("level9Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel9Id()+"")));
		levelMap.put("level10Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel10Id()+"")));
		levelMap.put("level11Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel11Id()+"")));
		levelMap.put("level12Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel12Id()+"")));
		levelMap.put("level13Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel13Id()+"")));
		levelMap.put("level14Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel14Id()+"")));
		levelMap.put("level15Id", Integer.parseInt(utilsObj.getlevelId(hierVoObj.getLevel15Id()+"")));
		
	}
	public Map<String,String> fetchColMap(String tableTag){
		Map<String,String> columnMap=new HashMap<String, String>();
		Session session=null;
		try{
			session=getSession();
			Query queryObj=session.createQuery("select columnname,columndatatype from D"+tableTag+"ColumnHeader");
			@SuppressWarnings("unchecked")
			List<Object[]> objList=queryObj.list();
			for(Object[] obj:objList){
				columnMap.put(obj[1]+"", obj[0]+"");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return columnMap;
	}
	
	
	public List<String> fetchColList(String tableTag){
		List<String> columnList=new ArrayList<String>();
		Session session=null;
		try{
			session=getSession();
			Query queryObj=session.createQuery("select columndatatype from D"+tableTag+"ColumnHeader order by columndatatype");
			@SuppressWarnings("unchecked")
			List<String> list=queryObj.list();
			columnList=list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return columnList;
	}
	
	
	public StringBuilder conditionQuery(String searchSelectVar, String searchParameter, String conditionStr){
		StringBuilder strb = new StringBuilder();
		try {
			for (int i = 0; i < searchSelectVar.split(",").length; i++) {
				String [] searchVal = searchSelectVar.split(",");
				String [] searchParam = searchParameter.split(",");
				String [] conditionStrg = conditionStr.split(",");
					if(conditionStrg[i].equalsIgnoreCase("LIKE")){
						strb.append(" data."+searchVal[i]+" like '%"+searchParam[i]+"%' ");
					}else if(conditionStrg[i].equalsIgnoreCase("EQUAL TO")){
						strb.append(" data."+searchVal[i]+" = '"+searchParam[i]+"' ");
					}else if(conditionStrg[i].equalsIgnoreCase("NOT EQUAL TO")){
						strb.append(" data."+searchVal[i]+" != '"+searchParam[i]+"' ");
					}
					if(i+1 < searchSelectVar.split(",").length){
						strb.append(" and ");
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strb;
	}
	
	public void appendFileData(String folderPath, String fileName,
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

	public ApplicationLevelIndexMaster appLevelIndexDetails(
			Map<String, String> extraMap) {
		ApplicationLevelIndexMaster appLevelIndexMasterObj=new ApplicationLevelIndexMaster();
		ApplicationLevelIndexMasterId appLevelIndexMasterIdObj=new ApplicationLevelIndexMasterId();
		
		try{
			appLevelIndexMasterIdObj.setLevel1id(Integer.parseInt(extraMap.get("level1Id")));
				appLevelIndexMasterIdObj.setLevel2id(Integer.parseInt(extraMap.get("level2Id")));
				appLevelIndexMasterIdObj.setLevel3id(Integer.parseInt(extraMap.get("level3Id")));
				appLevelIndexMasterIdObj.setLevel4id(Integer.parseInt(extraMap.get("level4Id")));
				appLevelIndexMasterIdObj.setLevel5id(Integer.parseInt(extraMap.get("level5Id")));
				appLevelIndexMasterIdObj.setLevel6id(Integer.parseInt(extraMap.get("level6Id")));
				appLevelIndexMasterIdObj.setLevel7id(Integer.parseInt(extraMap.get("level7Id")));
				appLevelIndexMasterIdObj.setLevel8id(Integer.parseInt(extraMap.get("level8Id")));
				appLevelIndexMasterIdObj.setLevel9id(Integer.parseInt(extraMap.get("level9Id")));
				appLevelIndexMasterIdObj.setLevel10id(Integer.parseInt(extraMap.get("level10Id")));
				appLevelIndexMasterIdObj.setLevel11id(Integer.parseInt(extraMap.get("level11Id")));
				appLevelIndexMasterIdObj.setLevel12id(Integer.parseInt(extraMap.get("level12Id")));
				appLevelIndexMasterIdObj.setLevel13id(Integer.parseInt(extraMap.get("level13Id")));
				appLevelIndexMasterIdObj.setLevel14id(Integer.parseInt(extraMap.get("level14Id")));
				appLevelIndexMasterIdObj.setLevel15id(Integer.parseInt(extraMap.get("level15Id")));
				appLevelIndexMasterObj.setId(appLevelIndexMasterIdObj);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return appLevelIndexMasterObj;
	}

	public Object fetchHierarchyObjectById(int levelNumber, String levelId) {
		Object object=null;
        Session session=null;
		try {
			session=getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from HierarchyLevel"+levelNumber+"" +
                     " where level"+levelNumber+"Id=:levelId");
			
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("levelId", Integer.parseInt(levelId));
			object=queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		 return object;
    }

	public LevelIndexMaster fetchLevelIndexMasterDetails(Integer indexId,LevelIndexMaster masterObj) {
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from LevelIndexMaster where indexId=:indexId");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("indexId", indexId);
			masterObj = (LevelIndexMaster) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}
	
	
	public Object[] fetchLevelDetails(Integer levelNumber,String uniqueCode){
		Object[] strArr=null;
		Session session=null;
		try{
			session=getSession();
			Query queryObj = session.createSQLQuery("SELECT level" + levelNumber+ "_Id,level" + levelNumber+ "_Name from hierarchy_level" + levelNumber + " "
					+ "where level" + levelNumber + "_uniqueCode=?");
			
			queryObj.setParameter(0, uniqueCode.toUpperCase());
			Object[] objArr = (Object[]) queryObj.list().get(0);
			strArr=objArr;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return strArr;
	}
		
}
	
	
