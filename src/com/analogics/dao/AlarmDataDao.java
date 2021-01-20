package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.AlarmData;
import com.analogics.vo.AlarmDataLatest;

public class AlarmDataDao extends BaseHibernateDAO{
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	
	
	
	public List<AlarmData> fetchAlarmDataList(int pageNumber, int parseInt,
			String searchParameter, AlarmData masterObj,
			LevelIndexMaster levelIndexObj) {
		List<AlarmData> list = new ArrayList<AlarmData>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append(" from AlarmData data, MeterMaster master,LevelIndexMaster levels ");
			strb.append("where data.meterNumber=master.meterNumber");
			strb.append(" and data.nodeDate between '"+masterObj.getFromDate()+"' and '"+masterObj.getToDate()+"'");
			strb.append(" and master.indexid=levels.indexid");

			
			strb.append(frameObj.frameUserHierarchyQuery(levelIndexObj));
			
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			
			strb.append(" order by master.insertedDate desc");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			@SuppressWarnings("unchecked")
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				AlarmData dObj=(AlarmData) objArr[0];
				list.add(dObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	public Long fetchAlarmDataCount(AlarmData masterObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from AlarmData data, MeterMaster master,LevelIndexMaster levels ");
			strb.append("where data.meterNumber=master.meterNumber ");
			strb.append(" and data.nodeDate between '"+masterObj.getFromDate()+"' and '"+masterObj.getToDate()+"'");
			strb.append(" and master.indexid=levels.indexid");
			strb.append(frameObj
					.frameUserHierarchyQuery(levelIndexObj));
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
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

	public List<AlarmDataLatest> fetchAlarmDataLatestList(int pageNumber,
			int parseInt, String searchParameter, AlarmDataLatest masterObj,
			LevelIndexMaster levelIndexObj) {
		List<AlarmDataLatest> list = new ArrayList<AlarmDataLatest>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append(" from AlarmDataLatest data, MeterMaster master,LevelIndexMaster levels ");
			strb.append("where data.meterNumber=master.meterNumber");
//			strb.append(" and data.nodeDate between '"+masterObj.getFromDate()+"' and '"+masterObj.getToDate()+"'");
			strb.append(" and master.indexid=levels.indexid");

			
			strb.append(frameObj.frameUserHierarchyQuery(levelIndexObj));
			
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			
			strb.append(" order by master.insertedDate desc");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			@SuppressWarnings("unchecked")
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				AlarmDataLatest dObj=(AlarmDataLatest) objArr[0];
				list.add(dObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	public Long fetchAlarmDataLatestCount(AlarmDataLatest masterObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from AlarmDataLatest data, MeterMaster master,LevelIndexMaster levels ");
			strb.append("where data.meterNumber=master.meterNumber ");
//			strb.append(" and data.nodeDate between '"+masterObj.getFromDate()+"' and '"+masterObj.getToDate()+"'");
			strb.append(" and master.indexid=levels.indexid");
			strb.append(frameObj
					.frameUserHierarchyQuery(levelIndexObj));
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
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

}
