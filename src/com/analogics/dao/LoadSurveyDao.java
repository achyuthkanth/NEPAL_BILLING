package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.LoadSurvey;
import com.analogics.vo.MeterMaster;

public class LoadSurveyDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	
	public Long fetchLoadSurveyDataDetailsCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, LoadSurvey dataObj,
			LevelIndexMaster levelIndexObj) {
		
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from LoadSurveyLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
			strb.append(" and master.meterDate between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
			strb.append(" and mas.indexid=levels.indexid");
			
			stb1=frameObj.frameUserHierarchyQuery(levelIndexObj);
			if(!dataObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !dataObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and (");
				stb2 = queryFrameObj.conditionQuery(dataObj.getSearchSelectVar(),
						dataObj.getSearchParameter(),
						dataObj.getConditionStr());
				strb.append(stb2+")");
			}
			
			strb.append(stb1);
			Query queryObj = session.createQuery(strb.toString());
			count = (Long) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return count;
	}

	public List<LoadSurvey> fetchLoadSurveyDataList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			LoadSurvey dataObj, LevelIndexMaster levelIndexObj) {
		List<LoadSurvey> dataList=new ArrayList<LoadSurvey>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from LoadSurveyLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
			strb.append(" and master.meterDate between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
			strb.append(" and mas.indexid=levels.indexid");
			
			stb1=frameObj.frameUserHierarchyQuery(levelIndexObj);
			if(!dataObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !dataObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and (");
				stb2 = queryFrameObj.conditionQuery(dataObj.getSearchSelectVar(),
						dataObj.getSearchParameter(),
						dataObj.getConditionStr());
				strb.append(stb2+")");
			}
			
			strb.append(stb1);
			Query queryObj = session.createQuery(strb.toString());
			
			strb.append(" order by master.insertedDate");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			@SuppressWarnings("unchecked")
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				LoadSurvey loadSurveyDataObj=(LoadSurvey) objArr[0];
				MeterMaster masterObj = (MeterMaster) objArr[1];
				loadSurveyDataObj.setMeterMasterObj(masterObj);
				dataList.add(loadSurveyDataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return dataList;
	}
}
