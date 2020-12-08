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

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.ApplicationLevelIndexMaster;
import com.analogics.um.vo.ApplicationLevelIndexMasterId;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.LevelIndexMasterId;

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
	
	
	
	public String daoLevelIndexString(Map<String,String> extraMap){
		String response="";
		StringBuilder strb=new StringBuilder();
		try{
			
			if (!extraMap.get("level1Id").equalsIgnoreCase("-1"))
				strb.append(" level.id.level1id="+extraMap.get("level1Id"));
			
			if (!extraMap.get("level2Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level2id="+extraMap.get("level2Id"));
			
			if (!extraMap.get("level3Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level3id="+extraMap.get("level3Id"));
			
			if (!extraMap.get("level4Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level4id="+extraMap.get("level4Id"));
			
			if (!extraMap.get("level5Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level5id="+extraMap.get("level5Id"));
			
			if (!extraMap.get("level6Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level6id="+extraMap.get("level6Id"));
			
			if (!extraMap.get("level7Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level7id="+extraMap.get("level7Id"));
			
			if (!extraMap.get("level8Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level8id="+extraMap.get("level8Id"));
			
			if (!extraMap.get("level9Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level9id="+extraMap.get("level9Id"));
			
			if (!extraMap.get("level10Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level10id="+extraMap.get("level10Id"));
			
			if (!extraMap.get("level11Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level11id="+extraMap.get("level11Id"));
			
			if (!extraMap.get("level12Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level12id="+extraMap.get("level12Id"));
			
			if (!extraMap.get("level13Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level13id="+extraMap.get("level13Id"));
			
			if (!extraMap.get("level14Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level14id="+extraMap.get("level14Id"));
			
			if (!extraMap.get("level15Id").equalsIgnoreCase("-1"))
				strb.append(" and level.id.level15id="+extraMap.get("level15Id"));
			
			response=strb.toString();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
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
	
	//****			Default framing Levels In Model  Object			****//

	
	
	//****			 framing Levels In Model  Object Based On hierarchy		****//

	

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

	
		
	}
	
	
