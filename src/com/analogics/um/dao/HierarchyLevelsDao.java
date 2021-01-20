package com.analogics.um.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ApplicationLevelIndexMaster;
import com.analogics.um.vo.HierarchyLevelsVo;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.LevelIndexMasterId;

public class HierarchyLevelsDao extends BaseHibernateDAO{

	
	public Map<String, String> nextLevelsMap(String levelId, String levelValue) {
		Map<String, String> levelMap = new HashMap<String, String>();
		Integer nextLevelId = Integer.parseInt(levelId) + 1;
		Session session = null;
		try {
			
			if(levelValue.equalsIgnoreCase("undefined")){
				levelValue="-1";
			}
			
			
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("select level" + nextLevelId + "Id,level" + nextLevelId
					+ "Name from HierarchyLevel" + nextLevelId);
			if (!levelValue.equalsIgnoreCase("-1")) {
				strb.append(" where level" + levelId + "Id=:levelValue");
			}
			Query queryLevel1Map = session.createQuery(strb.toString());
			if (!levelValue.equalsIgnoreCase("-1")) {
				queryLevel1Map.setParameter("levelValue", Integer.parseInt(levelValue));
			}
			
			@SuppressWarnings("unchecked")
			List<Object[]> list = queryLevel1Map.list();

			for (Object levelObj[] : list) {
				levelMap.put(String.valueOf(levelObj[0]), (String) levelObj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelMap;
	}

	public List<HierarchyLevelsVo> fetchHierarchyData(
			HierarchyLevelsVo hierarchyObj, int pageNumber, int parseInt,
			String sorting, String searchParameter, String sCol) {
		String str = "level";
		List<HierarchyLevelsVo> levelsList = new ArrayList<HierarchyLevelsVo>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strbQry = new StringBuilder();
			if (Integer.valueOf(hierarchyObj.getLevel1Id()) == -1) {
				strbQry = frameLevel(str, 1);
			} else if (Integer.valueOf(hierarchyObj.getLevel2Id()) == -1) {
				strbQry = frameLevel(str, 2);
			} else if (Integer.valueOf(hierarchyObj.getLevel3Id()) == -1) {
				strbQry = frameLevel(str, 3);
			} else if (Integer.valueOf(hierarchyObj.getLevel4Id()) == -1) {
				strbQry = frameLevel(str, 4);
			} else if (Integer.valueOf(hierarchyObj.getLevel5Id()) == -1) {
				strbQry = frameLevel(str, 5);
			} else if (Integer.valueOf(hierarchyObj.getLevel6Id()) == -1) {
				strbQry = frameLevel(str, 6);
			} else if (Integer.valueOf(hierarchyObj.getLevel7Id()) == -1) {
				strbQry = frameLevel(str, 7);
			} else if (Integer.valueOf(hierarchyObj.getLevel8Id()) == -1) {
				strbQry = frameLevel(str, 8);
			} else if (Integer.valueOf(hierarchyObj.getLevel9Id()) == -1) {
				strbQry = frameLevel(str, 9);
			} else if (Integer.valueOf(hierarchyObj.getLevel10Id()) == -1) {
				strbQry = frameLevel(str, 10);
			} else if (Integer.valueOf(hierarchyObj.getLevel11Id()) == -1) {
				strbQry = frameLevel(str, 11);
			} else if (Integer.valueOf(hierarchyObj.getLevel12Id()) == -1) {
				strbQry = frameLevel(str, 12);
			} else if (Integer.valueOf(hierarchyObj.getLevel13Id()) == -1) {
				strbQry = frameLevel(str, 13);
			} else if (Integer.valueOf(hierarchyObj.getLevel14Id()) == -1) {
				strbQry = frameLevel(str, 14);
			} else if (Integer.valueOf(hierarchyObj.getLevel15Id()) == -1) {
				strbQry = frameLevel(str, 15);
			}

			if (Integer.valueOf(hierarchyObj.getLevel1Id()) > 0) {
				strbQry.append(" where levels.level_1id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel2Id()) > 0) {
				strbQry.append(" and levels.level_2id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel3Id()) > 0) {
				strbQry.append(" and levels.level_3id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel4Id()) > 0) {
				strbQry.append(" and levels.level_4id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel5Id()) > 0) {
				strbQry.append(" and levels.level_5id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel6Id()) > 0) {
				strbQry.append(" and levels.level_6id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel7Id()) > 0) {
				strbQry.append(" where levels.level_7id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel8Id()) > 0) {
				strbQry.append(" and levels.level_8id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel9Id()) > 0) {
				strbQry.append(" and levels.level_9id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel10Id()) > 0) {
				strbQry.append(" and levels.level_10id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel11Id()) > 0) {
				strbQry.append(" and levels.level_11id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel12Id()) > 0) {
				strbQry.append(" and levels.level_12id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel13Id()) > 0) {
				strbQry.append(" and levels.level_13id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel14Id()) > 0) {
				strbQry.append(" and levels.level_14id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel15Id()) > 0) {
				strbQry.append(" and levels.level_15id=?");
			}
			
			Query queryObj = session.createSQLQuery(strbQry.toString());
			
			if (Integer.valueOf(hierarchyObj.getLevel1Id()) > 0) {
				queryObj.setParameter(0, Integer.parseInt(hierarchyObj.getLevel1Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel2Id()) > 0) {
				queryObj.setParameter(1, Integer.parseInt(hierarchyObj.getLevel2Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel3Id()) > 0) {
				queryObj.setParameter(2, Integer.parseInt(hierarchyObj.getLevel3Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel4Id()) > 0) {
				queryObj.setParameter(3, Integer.parseInt(hierarchyObj.getLevel4Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel5Id()) > 0) {
				queryObj.setParameter(4, Integer.parseInt(hierarchyObj.getLevel5Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel6Id()) > 0) {
				queryObj.setParameter(5, Integer.parseInt(hierarchyObj.getLevel6Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel7Id()) > 0) {
				queryObj.setParameter(6, Integer.parseInt(hierarchyObj.getLevel7Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel8Id()) > 0) {
				queryObj.setParameter(7, Integer.parseInt(hierarchyObj.getLevel8Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel9Id()) > 0) {
				queryObj.setParameter(8, Integer.parseInt(hierarchyObj.getLevel9Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel10Id()) > 0) {
				queryObj.setParameter(9, Integer.parseInt(hierarchyObj.getLevel10Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel11Id()) > 0) {
				queryObj.setParameter(10, Integer.parseInt(hierarchyObj.getLevel11Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel12Id()) > 0) {
				queryObj.setParameter(11, Integer.parseInt(hierarchyObj.getLevel12Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel13Id()) > 0) {
				queryObj.setParameter(12, Integer.parseInt(hierarchyObj.getLevel13Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel14Id()) > 0) {
				queryObj.setParameter(13, Integer.parseInt(hierarchyObj.getLevel14Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel15Id()) > 0) {
				queryObj.setParameter(14, Integer.parseInt(hierarchyObj.getLevel15Id()));
			}
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			@SuppressWarnings("unchecked")
			List<Object[]> obj = queryObj.list();

			for (Object[] object : obj) {
				HierarchyLevelsVo levelsObj = new HierarchyLevelsVo();
				levelsObj.sethLevelName((String) object[1]);
				levelsObj.sethLevelId(String.valueOf(object[0]));
				levelsObj.sethLevelCode((String) object[2]);
				levelsObj.sethLevelUniqueCode((String) object[3]);
				if (object.length == 5) {
					levelsObj.sethPreviousLevelId(String.valueOf(object[4]));
				}
				levelsList.add(levelsObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelsList;
	}

	private StringBuilder frameLevel(String level, Integer number) {
		StringBuilder strbQry = new StringBuilder();
		String levelId = level + number;
		String levelH = level + "_" + number;
		int preLevelId = number - 1;
		String previousLevelid = String.valueOf(preLevelId);
		String s = level + previousLevelid;
		try {
			strbQry.append("select distinct(" + levelId + "." + levelId
					+ "_Id)," + levelId + "." + levelId + "_Name  ");
			strbQry.append("," + levelId + "." + levelId + "_Code," + levelId
					+ "." + levelId + "_UniqueCode  ");
			if (number != 1) {
				strbQry.append(", " + levelId + "." + s + "_Id   ");
			}
			strbQry.append(" from hierarchy_" + levelId + " " + levelId
					+ " left join level_index_master  ");
			strbQry.append("levels on levels." + levelH + "id=" + levelId + "."
					+ levelId + "_id ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strbQry;
	}

	public Long fetchHierarchyDataCount(HierarchyLevelsVo hierarchyObj,
			int pageNumber, int parseInt, String sorting,
			String searchParameter, String sCol) {
		long count = 0;
		String str = "level";
		Session session = null;
		try {
			session = getSession();
			StringBuilder strbQry = new StringBuilder();
			if (Integer.valueOf(hierarchyObj.getLevel1Id()) == -1) {
				strbQry = frameLevelCount(str, 1);
			} else if (Integer.valueOf(hierarchyObj.getLevel2Id()) == -1) {
				strbQry = frameLevelCount(str, 2);
			} else if (Integer.valueOf(hierarchyObj.getLevel3Id()) == -1) {
				strbQry = frameLevelCount(str, 3);
			} else if (Integer.valueOf(hierarchyObj.getLevel4Id()) == -1) {
				strbQry = frameLevelCount(str, 4);
			} else if (Integer.valueOf(hierarchyObj.getLevel5Id()) == -1) {
				strbQry = frameLevelCount(str, 5);
			} else if (Integer.valueOf(hierarchyObj.getLevel6Id()) == -1) {
				strbQry = frameLevelCount(str, 6);
			} else if (Integer.valueOf(hierarchyObj.getLevel7Id()) == -1) {
				strbQry = frameLevelCount(str, 7);
			} else if (Integer.valueOf(hierarchyObj.getLevel8Id()) == -1) {
				strbQry = frameLevelCount(str, 8);
			} else if (Integer.valueOf(hierarchyObj.getLevel9Id()) == -1) {
				strbQry = frameLevelCount(str, 9);
			} else if (Integer.valueOf(hierarchyObj.getLevel10Id()) == -1) {
				strbQry = frameLevelCount(str, 10);
			} else if (Integer.valueOf(hierarchyObj.getLevel11Id()) == -1) {
				strbQry = frameLevelCount(str, 11);
			} else if (Integer.valueOf(hierarchyObj.getLevel12Id()) == -1) {
				strbQry = frameLevelCount(str, 12);
			} else if (Integer.valueOf(hierarchyObj.getLevel13Id()) == -1) {
				strbQry = frameLevelCount(str, 13);
			} else if (Integer.valueOf(hierarchyObj.getLevel14Id()) == -1) {
				strbQry = frameLevelCount(str, 14);
			} else if (Integer.valueOf(hierarchyObj.getLevel15Id()) == -1) {
				strbQry = frameLevelCount(str, 15);
			}

			if (Integer.valueOf(hierarchyObj.getLevel1Id()) > 0) {
				strbQry.append(" where levels.level_1id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel2Id()) > 0) {
				strbQry.append(" and levels.level_2id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel3Id()) > 0) {
				strbQry.append(" and levels.level_3id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel4Id()) > 0) {
				strbQry.append(" and levels.level_4id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel5Id()) > 0) {
				strbQry.append(" and levels.level_5id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel6Id()) > 0) {
				strbQry.append(" and levels.level_6id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel7Id()) > 0) {
				strbQry.append(" where levels.level_7id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel8Id()) > 0) {
				strbQry.append(" and levels.level_8id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel9Id()) > 0) {
				strbQry.append(" and levels.level_9id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel10Id()) > 0) {
				strbQry.append(" and levels.level_10id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel11Id()) > 0) {
				strbQry.append(" and levels.level_11id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel12Id()) > 0) {
				strbQry.append(" and levels.level_12id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel13Id()) > 0) {
				strbQry.append(" and levels.level_13id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel14Id()) > 0) {
				strbQry.append(" and levels.level_14id=?");
			}
			if (Integer.valueOf(hierarchyObj.getLevel15Id()) > 0) {
				strbQry.append(" and levels.level_15id=?");
			}
			/*count = ((BigInteger) session.createSQLQuery(strbQry.toString())
					.uniqueResult()).intValue();*/
			Query queryObj=session.createSQLQuery(strbQry.toString());
			
			
			if (Integer.valueOf(hierarchyObj.getLevel1Id()) > 0) {
				queryObj.setParameter(0, Integer.parseInt(hierarchyObj.getLevel1Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel2Id()) > 0) {
				queryObj.setParameter(1, Integer.parseInt(hierarchyObj.getLevel2Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel3Id()) > 0) {
				queryObj.setParameter(2, Integer.parseInt(hierarchyObj.getLevel3Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel4Id()) > 0) {
				queryObj.setParameter(3, Integer.parseInt(hierarchyObj.getLevel4Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel5Id()) > 0) {
				queryObj.setParameter(4, Integer.parseInt(hierarchyObj.getLevel5Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel6Id()) > 0) {
				queryObj.setParameter(5, Integer.parseInt(hierarchyObj.getLevel6Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel7Id()) > 0) {
				queryObj.setParameter(6, Integer.parseInt(hierarchyObj.getLevel7Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel8Id()) > 0) {
				queryObj.setParameter(7, Integer.parseInt(hierarchyObj.getLevel8Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel9Id()) > 0) {
				queryObj.setParameter(8, Integer.parseInt(hierarchyObj.getLevel9Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel10Id()) > 0) {
				queryObj.setParameter(9, Integer.parseInt(hierarchyObj.getLevel10Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel11Id()) > 0) {
				queryObj.setParameter(10, Integer.parseInt(hierarchyObj.getLevel11Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel12Id()) > 0) {
				queryObj.setParameter(11, Integer.parseInt(hierarchyObj.getLevel12Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel13Id()) > 0) {
				queryObj.setParameter(12, Integer.parseInt(hierarchyObj.getLevel13Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel14Id()) > 0) {
				queryObj.setParameter(13, Integer.parseInt(hierarchyObj.getLevel14Id()));
			}
			if (Integer.valueOf(hierarchyObj.getLevel15Id()) > 0) {
				queryObj.setParameter(14, Integer.parseInt(hierarchyObj.getLevel15Id()));
			}
			
			
			
			count=((BigInteger)queryObj .uniqueResult()).intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return count;
	}
	

	private StringBuilder frameLevelCount(String level, Integer number) {
		StringBuilder strbQry = new StringBuilder();
		String levelId = level + number;
		String levelH = level + "_" + number;
		try {
			strbQry.append("select  count(distinct(" + levelId + "." + levelId
					+ "_Id)) from ");
			strbQry.append("hierarchy_" + levelId + " " + levelId
					+ " left join level_index_master  ");
			strbQry.append("levels on levels." + levelH + "id=" + levelId + "."
					+ levelId + "_id ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strbQry;
	}

	public int fetchIndexId(LevelIndexMaster masterObj) {
		Transaction tr = null;
		int indexId=0;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			Query queryObj1 = session
					.createSQLQuery("select indexId from level_index_master where level_1Id=?" +
							" and level_2Id=? and level_3Id=?" +
							" and level_4Id=? and level_5Id=?" +
							" and level_6Id=? and level_7Id=?" +
							" and level_8Id=? and level_9Id=?" +
							" and level_10Id=? and level_11Id=?" +
							" and level_12Id=? and level_13Id=?" +
							" and level_14Id=? and level_15Id=?");
			
			 queryObj1.setParameter(0, masterObj.getId().getLevel1id());
			 queryObj1.setParameter(1, masterObj.getId().getLevel2id());
			 queryObj1.setParameter(2, masterObj.getId().getLevel3id());
			 queryObj1.setParameter(3, masterObj.getId().getLevel4id());
			 queryObj1.setParameter(4, masterObj.getId().getLevel5id());
			 queryObj1.setParameter(5, masterObj.getId().getLevel6id());
			 queryObj1.setParameter(6, masterObj.getId().getLevel7id());
			 queryObj1.setParameter(7, masterObj.getId().getLevel8id());
			 queryObj1.setParameter(8, masterObj.getId().getLevel9id());
			 queryObj1.setParameter(9, masterObj.getId().getLevel10id());
			 queryObj1.setParameter(10, masterObj.getId().getLevel11id());
			 queryObj1.setParameter(11, masterObj.getId().getLevel12id());
			 queryObj1.setParameter(12, masterObj.getId().getLevel13id());
			 queryObj1.setParameter(13, masterObj.getId().getLevel14id());
			 queryObj1.setParameter(14, masterObj.getId().getLevel15id());
			
			indexId = (Integer) queryObj1.list().get(0);
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return indexId;
	}

	public boolean saveNewHierarchyLevel(HierarchyLevelsVo hierObj, int indexId) {
		boolean isSaved = false;
		
		LevelIndexMaster levelIndexObj = hierObj.getLevelIndexObj();
		Transaction tr = null;
		String preLeveluniqCode=null;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			StringBuilder strb = new StringBuilder();

			Integer levelCount = Integer.parseInt(hierObj
					.getLevelCount());
			Integer preCountInteger = levelCount - 1;

			String prelevelId = preLevelId(levelIndexObj);
			if(levelCount!=1){
				preLeveluniqCode = indexId + "_"+ hierObj.getLevelName();
			}else{
				preLeveluniqCode = hierObj.getLevelName();
			}

			strb.append("insert into hierarchy_level" + levelCount);
			strb.append(" (level" + levelCount + "_name");
			strb.append(" ,level" + levelCount + "_code,level" + levelCount
					+ "_uniquecode ");
			if (levelCount != 1) {
				strb.append(",level" + preCountInteger + "_id");
			}
			strb.append(") values(?,?,?");
			if (levelCount != 1) {
				strb.append(",?");
			}
			strb.append(")");

			Query queryObj = session.createSQLQuery(strb.toString());
			
			queryObj.setParameter(0, hierObj.getLevelName().toUpperCase());
			queryObj.setParameter(1, hierObj.getLevelCode().toUpperCase());
			queryObj.setParameter(2, preLeveluniqCode);
			if (levelCount != 1) {
				queryObj.setParameter(3,Integer.parseInt(prelevelId));
			}

			int insertFlag = queryObj.executeUpdate();
			tr.commit();
			if (insertFlag == 1) {
				isSaved = true;
			}
			if (isSaved == true) {
				isSaved = false;
				tr = session.beginTransaction();
				String strData = "select level" + levelCount
						+ "_Id from hierarchy_level" + levelCount
						+ " where level" + levelCount + "_UniqueCode=?";
				Query qObj = session.createSQLQuery(strData);
				qObj.setParameter(0, preLeveluniqCode);
				Integer levelId = (Integer) qObj.list().get(0);

				if (levelCount == 1)
					levelIndexObj.getId().setLevel1id(levelId);
				if (levelCount == 2)
					levelIndexObj.getId().setLevel2id(levelId);
				if (levelCount == 3)
					levelIndexObj.getId().setLevel3id(levelId);
				if (levelCount == 4)
					levelIndexObj.getId().setLevel4id(levelId);
				if (levelCount == 5)
					levelIndexObj.getId().setLevel5id(levelId);
				if (levelCount == 6)
					levelIndexObj.getId().setLevel6id(levelId);
				if (levelCount == 7)
					levelIndexObj.getId().setLevel7id(levelId);
				if (levelCount == 8)
					levelIndexObj.getId().setLevel8id(levelId);
				if (levelCount == 9)
					levelIndexObj.getId().setLevel9id(levelId);
				if (levelCount == 10)
					levelIndexObj.getId().setLevel10id(levelId);
				if (levelCount == 11)
					levelIndexObj.getId().setLevel11id(levelId);
				if (levelCount == 12)
					levelIndexObj.getId().setLevel12id(levelId);
				if (levelCount == 13)
					levelIndexObj.getId().setLevel13id(levelId);
				if (levelCount == 14)
					levelIndexObj.getId().setLevel14id(levelId);
				if (levelCount == 15)
					levelIndexObj.getId().setLevel15id(levelId);
				
				session.save(levelIndexObj);
				tr.commit();
				isSaved = true;
			}
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return isSaved;
	}
	
	private String preLevelId(LevelIndexMaster levelIndexObj) {
		String levelId = "0";

		try {
			if (levelIndexObj.getId().getLevel1id() != -1)
				levelId = levelIndexObj.getId().getLevel1id() + "";
			if (levelIndexObj.getId().getLevel2id() != -1)
				levelId = levelIndexObj.getId().getLevel2id() + "";
			if (levelIndexObj.getId().getLevel3id() != -1)
				levelId = levelIndexObj.getId().getLevel3id() + "";
			if (levelIndexObj.getId().getLevel4id() != -1)
				levelId = levelIndexObj.getId().getLevel4id() + "";
			if (levelIndexObj.getId().getLevel5id() != -1)
				levelId = levelIndexObj.getId().getLevel5id() + "";
			if (levelIndexObj.getId().getLevel6id() != -1)
				levelId = levelIndexObj.getId().getLevel6id() + "";
			if (levelIndexObj.getId().getLevel7id() != -1)
				levelId = levelIndexObj.getId().getLevel7id() + "";
			if (levelIndexObj.getId().getLevel8id() != -1)
				levelId = levelIndexObj.getId().getLevel8id() + "";
			if (levelIndexObj.getId().getLevel9id() != -1)
				levelId = levelIndexObj.getId().getLevel9id() + "";
			if (levelIndexObj.getId().getLevel10id() != -1)
				levelId = levelIndexObj.getId().getLevel10id() + "";
			if (levelIndexObj.getId().getLevel11id() != -1)
				levelId = levelIndexObj.getId().getLevel11id() + "";
			if (levelIndexObj.getId().getLevel12id() != -1)
				levelId = levelIndexObj.getId().getLevel12id() + "";
			if (levelIndexObj.getId().getLevel13id() != -1)
				levelId = levelIndexObj.getId().getLevel13id() + "";
			if (levelIndexObj.getId().getLevel14id() != -1)
				levelId = levelIndexObj.getId().getLevel14id() + "";
			if (levelIndexObj.getId().getLevel15id() != -1)
				levelId = levelIndexObj.getId().getLevel15id() + "";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return levelId;
	}

	public Integer saveHierarchyLevel1(Integer level1Id, String level1Name,String level1Code, String uniqueCode) {
		Session session = null;
		@SuppressWarnings("unused")
		String response="error";
		Integer levelId=-1;
		Query queryObj=null;
		uniqueCode=level1Name;
		Transaction tr = null;
		session = getSession();
		try{
			
			tr = session.beginTransaction();
			StringBuilder strb = new StringBuilder();
			strb.append("insert into hierarchy_level1");
			strb.append(" (level1_Name");
			strb.append(" ,level1_Code,level1" 
					+ "_UniqueCode ");
			
			strb.append(") values('"+level1Name+"', '"+level1Code+"', '"+uniqueCode+"'");
			
			strb.append(")");
			 queryObj=session.createSQLQuery(strb.toString());
//			queryObj=session.createSQLQuery("INSERT INTO hierarchy_level1 VALUES(null,'"+level1Name+"','"+level1Code+"','"+uniqueCode+"')");
			queryObj.executeUpdate();
			tr.commit();
			response="success";
			
			queryObj=session.createSQLQuery("select level1_Id from hierarchy_level1 where level1_Code='"+level1Code+"'");
			levelId=(Integer) queryObj.list().get(0);
		}catch(Exception e)
		{
			tr.rollback();
//			e.printStackTrace();
			
			if((e.getMessage().contains("Duplicate")) || (e.getMessage().contains("could not execute native bulk manipulation"))){
				try {
					 queryObj=session.createSQLQuery("SELECT level1_Id from hierarchy_level1 where level1_Code='"+level1Code+"'");
		                levelId=(Integer) queryObj.list().get(0);
				} catch (Exception e2) {
					e.printStackTrace();
				}
				
			}
			
		}finally{
			session.close();
			
		}
		return levelId;
	}


	public Integer saveHierarchyLevel(Integer level2Id, String level2Name,String level2Code, String uniqueCode, Integer levelId,Integer levelNumber) {
		Query queryObj=null;
		Session session = null;
		Integer levelnId=-1;
		Transaction tr = null;
		session = getSession();
		
		try {
			tr = session.beginTransaction();
			 uniqueCode=levelId+"_"+level2Name;
			 int prevLevelId= levelNumber-1;
			 queryObj=session.createSQLQuery("insert into hierarchy_level"+levelNumber+"(level"+levelNumber+"_name ,level"+levelNumber+"_code,level"+levelNumber+"_uniquecode ,level"+prevLevelId+"_id) values('"+level2Name+"','"+level2Code+"','"+uniqueCode+"','"+levelId+"')");
//			 queryObj=session.createSQLQuery("INSERT INTO hierarchy_level"+levelNumber+" VALUES('"+level2Name+"','"+level2Code+"','"+uniqueCode+"','"+levelId+"')");
			 queryObj.executeUpdate();
			 tr.commit();
			 @SuppressWarnings("unused")
			String response="success";
			 
			 queryObj=session.createSQLQuery("SELECT level"+levelNumber+"_Id from hierarchy_level"+levelNumber+" where level"+levelNumber+"_Code='"+level2Code+"'");
			 levelnId=(Integer) queryObj.list().get(0);
			 
			
		
		} catch (Exception e) {
		e.printStackTrace();
			tr.rollback();
			if((e.getMessage().contains("Duplicate")) || (e.getMessage().contains("could not execute native bulk manipulation"))){
				 queryObj=session.createSQLQuery("SELECT level"+levelNumber+"_Id from hierarchy_level"+levelNumber+" where level"+levelNumber+"_Code='"+level2Code+"'");
				 levelnId=(Integer) queryObj.list().get(0);
			}
		}finally{
			session.close();
		}
		
		return levelnId;
	}

	public String saveHierarchyDetails(LevelIndexMaster levelMasterObj) {
		String response = "error";
		Session session = null;
		Transaction tr = null;
		session = getSession();
		try {
			tr = session.beginTransaction();
			session.save(levelMasterObj);
			tr.commit();
			response = "success";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return response;
	}

	public Map<String, String> AppnextLevelsMap(String levelId, String levelValue) {
		Map<String, String> levelMap = new HashMap<String, String>();
		Integer nextLevelId = Integer.parseInt(levelId) + 1;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("select level" + nextLevelId + "Id,level" + nextLevelId
					+ "Name from ApplicationHierarchyLevel" + nextLevelId);
			if (!levelValue.equalsIgnoreCase("-1")) {
				strb.append(" where level" + levelId + "Id=:levelValue");
			}
			Query queryLevel1Map = session.createQuery(strb.toString());
			if (!levelValue.equalsIgnoreCase("-1")) {
				queryLevel1Map.setParameter("levelValue", Integer.parseInt(levelValue));
			}
			@SuppressWarnings("unchecked")
			List<Object[]> list = queryLevel1Map.list();

			for (Object levelObj[] : list) {
				levelMap.put(String.valueOf(levelObj[0]), (String) levelObj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelMap;
	}

	
	public int fetchAppIndexId(ApplicationLevelIndexMaster masterObj) {
		Transaction tr = null;
		int indexId=0;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			 Query queryObj = session
						.createSQLQuery("select app_indexid from application_level_index_master where level_1Id=?" +
								" and level_2Id=? and level_3Id=?" +
								" and level_4Id=? and level_5Id=?" +
								" and level_6Id=? and level_7Id=?" +
								" and level_8Id=? and level_9Id=?" +
								" and level_10Id=? and level_11Id=?" +
								" and level_12Id=? and level_13Id=?" +
								" and level_14Id=? and level_15Id=?");
				
				 queryObj.setParameter(0, masterObj.getId().getLevel1id());
				 queryObj.setParameter(1, masterObj.getId().getLevel2id());
				 queryObj.setParameter(2, masterObj.getId().getLevel3id());
				 queryObj.setParameter(3, masterObj.getId().getLevel4id());
				 queryObj.setParameter(4, masterObj.getId().getLevel5id());
				 queryObj.setParameter(5, masterObj.getId().getLevel6id());
				 queryObj.setParameter(6, masterObj.getId().getLevel7id());
				 queryObj.setParameter(7, masterObj.getId().getLevel8id());
				 queryObj.setParameter(8, masterObj.getId().getLevel9id());
				 queryObj.setParameter(9, masterObj.getId().getLevel10id());
				 queryObj.setParameter(10, masterObj.getId().getLevel11id());
				 queryObj.setParameter(11, masterObj.getId().getLevel12id());
				 queryObj.setParameter(12, masterObj.getId().getLevel13id());
				 queryObj.setParameter(13, masterObj.getId().getLevel14id());
				 queryObj.setParameter(14, masterObj.getId().getLevel15id());
				
				indexId = (Integer) queryObj.list().get(0);
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return indexId;
	}

	public boolean saveAppNewHierarchyLevel(HierarchyLevelsVo hierarchyLevelsVoObj, int appIndexId) {
		Transaction tr = null;
		Session session = null;
		String preLeveluniqCode=null;
		boolean isSaved = false;
		ApplicationLevelIndexMaster levelIndexObj = hierarchyLevelsVoObj
				.getAppLevelIndexObj();
		try {
			session = getSession();
			tr = session.beginTransaction();
			StringBuilder strb = new StringBuilder();

			Integer levelCount = Integer.parseInt(hierarchyLevelsVoObj.getLevelCount());
			Integer preCountInteger = levelCount - 1;

			String prelevelId = preLevelId(levelIndexObj);
			if(levelCount!=1){
				preLeveluniqCode = appIndexId + "_"+ hierarchyLevelsVoObj.getLevelName();
			}else{
				preLeveluniqCode = hierarchyLevelsVoObj.getLevelName();
			}
			 

			strb.append("insert into application_hierarchy_level" + levelCount);
			strb.append(" (level" + levelCount + "_Name");
			strb.append(" ,level" + levelCount + "_Code,level" + levelCount
					+ "_UniqueCode ");
			if (levelCount != 1) {
				strb.append(",level" + preCountInteger + "_Id");
			} else {
				strb.append(",applicationUniqueId");
			}
			strb.append(") values(?,?,?");
			if (levelCount != 1) {
				strb.append(",?");
			} else {
				strb.append(",?");
			}
			strb.append(")");

			Query queryObj = session.createSQLQuery(strb.toString());
			queryObj.setParameter(0, hierarchyLevelsVoObj.getLevelName());
			queryObj.setParameter(1, hierarchyLevelsVoObj.getLevelCode());
			queryObj.setParameter(2, preLeveluniqCode);
			if (levelCount != 1) {
				queryObj.setParameter(3, Integer.parseInt(prelevelId));
			}else {
				queryObj.setParameter(3, hierarchyLevelsVoObj.gethApplicationUniqueId() );
			}
			int insertFlag = queryObj.executeUpdate();
			if (insertFlag == 1) {
				isSaved = true;
			}
			if (isSaved == true) {
				isSaved = false;
				String strData = "select level" + levelCount
						+ "_Id from application_hierarchy_level" + levelCount
						+ " where level" + levelCount + "_UniqueCode=?";
				Query qObj = session.createSQLQuery(strData);
				qObj.setParameter(0, preLeveluniqCode);
				Integer levelId = (Integer) qObj.list().get(0);

				if (levelCount == 1)
					levelIndexObj.getId().setLevel1id(levelId);
				if (levelCount == 2)
					levelIndexObj.getId().setLevel2id(levelId);
				if (levelCount == 3)
					levelIndexObj.getId().setLevel3id(levelId);
				if (levelCount == 4)
					levelIndexObj.getId().setLevel4id(levelId);
				if (levelCount == 5)
					levelIndexObj.getId().setLevel5id(levelId);
				if (levelCount == 6)
					levelIndexObj.getId().setLevel6id(levelId);
				if (levelCount == 7)
					levelIndexObj.getId().setLevel7id(levelId);
				if (levelCount == 8)
					levelIndexObj.getId().setLevel8id(levelId);
				if (levelCount == 9)
					levelIndexObj.getId().setLevel9id(levelId);
				if (levelCount == 10)
					levelIndexObj.getId().setLevel10id(levelId);
				if (levelCount == 11)
					levelIndexObj.getId().setLevel11id(levelId);
				if (levelCount == 12)
					levelIndexObj.getId().setLevel12id(levelId);
				if (levelCount == 13)
					levelIndexObj.getId().setLevel13id(levelId);
				if (levelCount == 14)
					levelIndexObj.getId().setLevel14id(levelId);
				if (levelCount == 15)
					levelIndexObj.getId().setLevel15id(levelId);

				session.save(levelIndexObj);
				tr.commit();
				isSaved = true;
			}
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return isSaved;
	}

	private String preLevelId(ApplicationLevelIndexMaster levelIndexObj) {
		String levelId = "0";
		try {
			if (levelIndexObj.getId().getLevel1id() != -1)
				levelId = levelIndexObj.getId().getLevel1id() + "";
			if (levelIndexObj.getId().getLevel2id() != -1)
				levelId = levelIndexObj.getId().getLevel2id() + "";
			if (levelIndexObj.getId().getLevel3id() != -1)
				levelId = levelIndexObj.getId().getLevel3id() + "";
			if (levelIndexObj.getId().getLevel4id() != -1)
				levelId = levelIndexObj.getId().getLevel4id() + "";
			if (levelIndexObj.getId().getLevel5id() != -1)
				levelId = levelIndexObj.getId().getLevel5id() + "";
			if (levelIndexObj.getId().getLevel6id() != -1)
				levelId = levelIndexObj.getId().getLevel6id() + "";
			if (levelIndexObj.getId().getLevel7id() != -1)
				levelId = levelIndexObj.getId().getLevel7id() + "";
			if (levelIndexObj.getId().getLevel8id() != -1)
				levelId = levelIndexObj.getId().getLevel8id() + "";
			if (levelIndexObj.getId().getLevel9id() != -1)
				levelId = levelIndexObj.getId().getLevel9id() + "";
			if (levelIndexObj.getId().getLevel10id() != -1)
				levelId = levelIndexObj.getId().getLevel10id() + "";
			if (levelIndexObj.getId().getLevel11id() != -1)
				levelId = levelIndexObj.getId().getLevel11id() + "";
			if (levelIndexObj.getId().getLevel12id() != -1)
				levelId = levelIndexObj.getId().getLevel12id() + "";
			if (levelIndexObj.getId().getLevel13id() != -1)
				levelId = levelIndexObj.getId().getLevel13id() + "";
			if (levelIndexObj.getId().getLevel14id() != -1)
				levelId = levelIndexObj.getId().getLevel14id() + "";
			if (levelIndexObj.getId().getLevel15id() != -1)
				levelId = levelIndexObj.getId().getLevel15id() + "";
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return levelId;
	}
	public Map<String, String> levelsDataMap(String levelId, String levelValue,
			String prelevelValue) {
		Map<String, String> levelMap = new HashMap<String, String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			Integer preLevelId = Integer.parseInt(levelId) - 1;

			strb.append("select level" + levelId + "Id,level" + levelId
					+ "Name from HierarchyLevel" + levelId);

			if (!levelValue.equalsIgnoreCase("-1")) {
				strb.append(" where level" + levelId + "Id=:levelValue");
			}

			if (!levelId.equalsIgnoreCase("1")) {
				if (strb.toString().contains("where")) {
					strb.append(" and ");
				} else {
					strb.append(" where ");
				}
				strb.append(" level" + preLevelId + "Id=:prelevelValue");
			}
			Query queryLevel1Map = session.createQuery(strb.toString());
			if (!levelValue.equalsIgnoreCase("-1")) {
				queryLevel1Map.setParameter("levelValue", Integer.parseInt(levelValue));
			}
			if (!levelId.equalsIgnoreCase("1")) {
				queryLevel1Map.setParameter("prelevelValue", Integer.parseInt(prelevelValue));
			}
			
			List<Object[]> list = queryLevel1Map.list();
			for (Object levelObj[] : list) {
				levelMap.put(String.valueOf(levelObj[0]), (String) levelObj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelMap;
	}

	public LevelIndexMaster saveTestHierarchyLevel(String levelName,
			String levelCode, String uniqueCode, int prevLevelId, int levelNumber,
			LevelIndexMaster masterObj) {
		Session session = null;
		Query queryObj=null;
		int levelnId=0;
		Integer indexId = -1;
		Transaction tr = null;
		Integer prevLvlNo = levelNumber - 1;
		levelName=levelName.toUpperCase();
		levelCode =levelCode.toUpperCase();
//		 masterObj = new LevelIndexMaster();
		LevelIndexMasterId masterIdObj=masterObj.getId();
		
		
		try {
			session = getSession();
			tr = session.beginTransaction();
			if(levelNumber!=1){
				uniqueCode = masterObj.getIndexid()+"_"+levelCode;
			}else{
				uniqueCode = levelName;
			}
			
			masterObj.setIndexid(null);
			
			StringBuilder strb = new StringBuilder();
			strb.append("insert into hierarchy_level" + levelNumber);
			strb.append(" (level" + levelNumber + "_Name");
			strb.append(" ,level" + levelNumber + "_Code,level" + levelNumber
					+ "_UniqueCode ");
			if (levelNumber != 1) {
				strb.append(",level" + prevLvlNo + "_Id");
			}
			strb.append(") values(?, ?, ?");
			if (levelNumber != 1) {
				strb.append(",?");
			}
			strb.append(")");
			
			 queryObj=session.createSQLQuery(strb.toString());
			 
			 queryObj.setParameter(0, levelName.toUpperCase());
			 queryObj.setParameter(1, levelCode.toUpperCase());
			 queryObj.setParameter(2, uniqueCode);
			 if (levelNumber != 1) {
			 queryObj.setParameter(3, prevLevelId);
			 }
			 
			queryObj.executeUpdate();
			tr.commit();
			
			queryObj = session.createSQLQuery("SELECT level" + levelNumber
					+ "_Id from hierarchy_level" + levelNumber + " where level" + levelNumber + "_Code=?  and level"+levelNumber+"_uniquecode=?");
			 queryObj.setParameter(0, levelCode);
			 queryObj.setParameter(1, uniqueCode);
			
			levelnId = (Integer) queryObj.list().get(0);
			
			if(levelNumber==1){
				masterIdObj.setLevel1id(levelnId);
			}if(levelNumber==2){
				masterIdObj.setLevel2id(levelnId);
			}if(levelNumber==3){
				masterIdObj.setLevel3id(levelnId);
			}if(levelNumber==4){
				masterIdObj.setLevel4id(levelnId);
			}if(levelNumber==5){
				masterIdObj.setLevel5id(levelnId);
			}if(levelNumber==6){
				masterIdObj.setLevel6id(levelnId);
			}if(levelNumber==7){
				masterIdObj.setLevel7id(levelnId);
			}if(levelNumber==8){
				masterIdObj.setLevel8id(levelnId);
			}if(levelNumber==9){
				masterIdObj.setLevel9id(levelnId);
			}if(levelNumber==10){
				masterIdObj.setLevel10id(levelnId);
			}if(levelNumber==11){
				masterIdObj.setLevel11id(levelnId);
			}if(levelNumber==12){
				masterIdObj.setLevel12id(levelnId);
			}if(levelNumber==13){
				masterIdObj.setLevel13id(levelnId);
			}if(levelNumber==14){
				masterIdObj.setLevel14id(levelnId);
			}if(levelNumber==15){
				masterIdObj.setLevel15id(levelnId);
			}
			masterObj.setId(masterIdObj);
			
		} catch (Exception e) {
			if ((e.getMessage().contains("Duplicate"))
					|| (e.getMessage()
							.contains("could not execute native bulk manipulation"))) {
				tr.rollback();
				queryObj = session.createSQLQuery("SELECT level" + levelNumber
						+ "_Id from hierarchy_level" + levelNumber
						+ " where level" + levelNumber + "_Code=? and level"+levelNumber+"_uniquecode=?");
				 queryObj.setParameter(0, levelCode);
				 queryObj.setParameter(1, uniqueCode);
				
				levelnId = (Integer) queryObj.list().get(0);
				
				if(levelNumber==1 && (masterObj.getId() == null || masterObj.getId().getLevel1id()==null || masterObj.getId().getLevel1id()==-1)){
					masterIdObj.setLevel1id(levelnId);
				}else{
					if(levelNumber >= 1){
						masterIdObj.setLevel1id(masterObj.getId().getLevel1id());
					}else{
						masterIdObj.setLevel1id(-1);
					}
				}
				
				if(levelNumber==2 && (masterObj.getId().getLevel2id()==null || masterObj.getId().getLevel2id()==-1)){
					masterIdObj.setLevel2id(levelnId);
				}else{
					if(levelNumber > 2){
						masterIdObj.setLevel2id(masterObj.getId().getLevel2id());
					}else{
						masterIdObj.setLevel2id(-1);
					}
				}
				if(levelNumber==3 && (masterObj.getId().getLevel3id()==null  || masterObj.getId().getLevel3id()==-1)){
					masterIdObj.setLevel3id(levelnId);
				}else{
					if(levelNumber > 3){
						masterIdObj.setLevel3id(masterObj.getId().getLevel3id());
					}else{
						masterIdObj.setLevel3id(-1);
					}
				}
				
				if(levelNumber==4 && (masterObj.getId().getLevel4id()==null  || masterObj.getId().getLevel4id()==-1)){
					masterIdObj.setLevel4id(levelnId);
				}else{
					if(levelNumber > 4){
						masterIdObj.setLevel4id(masterObj.getId().getLevel4id());
					}else{
						masterIdObj.setLevel4id(-1);
					}
				}
				
				if(levelNumber==5 && (masterObj.getId().getLevel5id()==null  || masterObj.getId().getLevel5id()==-1)){
					masterIdObj.setLevel5id(levelnId);
				}else{
					if(levelNumber > 5){
						masterIdObj.setLevel5id(masterObj.getId().getLevel5id());
					}else{
						masterIdObj.setLevel5id(-1);
					}
				}
				if(levelNumber==6 && (masterObj.getId().getLevel6id()==null  || masterObj.getId().getLevel6id()==-1)){
					masterIdObj.setLevel6id(levelnId);
				}else{
					if(levelNumber > 6){
						masterIdObj.setLevel6id(masterObj.getId().getLevel6id());
					}else{
						masterIdObj.setLevel6id(-1);
					}
				}
				if(levelNumber==7 && (masterObj.getId().getLevel7id()==null  || masterObj.getId().getLevel7id()==-1)){
					masterIdObj.setLevel7id(levelnId);
				}else{
					if(levelNumber > 7){
						masterIdObj.setLevel7id(masterObj.getId().getLevel7id());
					}else{
						masterIdObj.setLevel7id(-1);
					}
				}
				
				if(levelNumber==8 && (masterObj.getId().getLevel8id()==null  || masterObj.getId().getLevel8id()==-1)){
					masterIdObj.setLevel8id(levelnId);
				}else{
					if(levelNumber > 8){
						masterIdObj.setLevel8id(masterObj.getId().getLevel8id());
					}else{
						masterIdObj.setLevel8id(-1);
					}
				}
				
				if(levelNumber==9 && (masterObj.getId().getLevel9id()==null  || masterObj.getId().getLevel9id()==-1)){
					masterIdObj.setLevel9id(levelnId);
				}else{
					if(levelNumber > 9){
						masterIdObj.setLevel9id(masterObj.getId().getLevel9id());
					}else{
						masterIdObj.setLevel9id(-1);
					}
				}
				
				if(levelNumber==10 && (masterObj.getId().getLevel10id()==null  || masterObj.getId().getLevel10id()==-1)){
					masterIdObj.setLevel10id(levelnId);
				}else{
					if(levelNumber > 10){
						masterIdObj.setLevel10id(masterObj.getId().getLevel10id());
					}else{
						masterIdObj.setLevel10id(-1);
					}
				}
				
				if(levelNumber==11 && (masterObj.getId().getLevel11id()==null  || masterObj.getId().getLevel11id()==-1)){
					masterIdObj.setLevel11id(levelnId);
				}else{
					if(levelNumber > 11){
						masterIdObj.setLevel11id(masterObj.getId().getLevel11id());
					}else{
						masterIdObj.setLevel11id(-1);
					}
				}
				
				if(levelNumber==12 && (masterObj.getId().getLevel12id()==null  || masterObj.getId().getLevel12id()==-1)){
					masterIdObj.setLevel12id(levelnId);
				}else{
					if(levelNumber > 12){
						masterIdObj.setLevel12id(masterObj.getId().getLevel12id());
					}else{
						masterIdObj.setLevel12id(-1);
					}
				}
				
				if(levelNumber==13 && (masterObj.getId().getLevel13id()==null  || masterObj.getId().getLevel13id()==-1)){
					masterIdObj.setLevel13id(levelnId);
				}else{
					if(levelNumber > 13){
						masterIdObj.setLevel13id(masterObj.getId().getLevel13id());
					}else{
						masterIdObj.setLevel13id(-1);
					}
				}
				if(levelNumber==14 && (masterObj.getId().getLevel14id()==null  || masterObj.getId().getLevel14id()==-1)){
					masterIdObj.setLevel14id(levelnId);
				}else{
					if(levelNumber > 14){
						masterIdObj.setLevel14id(masterObj.getId().getLevel14id());
					}else{
						masterIdObj.setLevel14id(-1);
					}
				}
				
				if(levelNumber==15 && (masterObj.getId().getLevel15id()==null  || masterObj.getId().getLevel15id()==-1)){
					masterIdObj.setLevel15id(levelnId);
				}else{
					if(levelNumber > 15){
						masterIdObj.setLevel15id(masterObj.getId().getLevel15id());
					}else{
						masterIdObj.setLevel15id(-1);
					}
				}
				masterObj.setId(masterIdObj);
			}
	}finally{
		
		if (session.isOpen()){
			session.close();
		}
		
		try{
			session=getSession();
			tr=session.beginTransaction();
//			masterObj.setIndexid(null);
			session.save(masterObj);
			tr.commit();
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}finally{
			if (session.isOpen())
				session.close(); 
		}
		

		try {
			session=getSession();
			Query queryObj1 = session.createSQLQuery("select indexId from level_index_master where level_1Id=?" +
							" and level_2Id=? and level_3Id=?" +
							" and level_4Id=? and level_5Id=?" +
							" and level_6Id=? and level_7Id=?" +
							" and level_8Id=? and level_9Id=?" +
							" and level_10Id=? and level_11Id=?" +
							" and level_12Id=? and level_13Id=?" +
							" and level_14Id=? and level_15Id=?");
			
			 queryObj1.setParameter(0, masterObj.getId().getLevel1id());
			 queryObj1.setParameter(1, masterObj.getId().getLevel2id());
			 queryObj1.setParameter(2, masterObj.getId().getLevel3id());
			 queryObj1.setParameter(3, masterObj.getId().getLevel4id());
			 queryObj1.setParameter(4, masterObj.getId().getLevel5id());
			 queryObj1.setParameter(5, masterObj.getId().getLevel6id());
			 queryObj1.setParameter(6, masterObj.getId().getLevel7id());
			 queryObj1.setParameter(7, masterObj.getId().getLevel8id());
			 queryObj1.setParameter(8, masterObj.getId().getLevel9id());
			 queryObj1.setParameter(9, masterObj.getId().getLevel10id());
			 queryObj1.setParameter(10, masterObj.getId().getLevel11id());
			 queryObj1.setParameter(11, masterObj.getId().getLevel12id());
			 queryObj1.setParameter(12, masterObj.getId().getLevel13id());
			 queryObj1.setParameter(13, masterObj.getId().getLevel14id());
			 queryObj1.setParameter(14, masterObj.getId().getLevel15id());
			
			indexId = (Integer) queryObj1.list().get(0);
			masterObj.setIndexid(indexId);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		if (session.isOpen()){
			session.close();
		}
		
		
		
	}
	return masterObj;
}
}
