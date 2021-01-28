package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.DailySnapshot;
import com.analogics.vo.DailySnapshotLatest;
import com.analogics.vo.MeterMaster;


public class DailySnapshotDao  extends BaseHibernateDAO{
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	@SuppressWarnings("unchecked")
	public List<DailySnapshot> fetchDailySnapshotDataList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			DailySnapshot dataObj, LevelIndexMaster levelIndexObj) {
		List<DailySnapshot> dataList=new ArrayList<DailySnapshot>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from DailySnapshot master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
			strb.append(" and master.id.snapshotDateTime between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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
			
			strb.append(" order by master.id.snapshotDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				DailySnapshot instantDataObj=(DailySnapshot) objArr[0];
				MeterMaster masterObj = (MeterMaster) objArr[1];
				instantDataObj.setMeterMasterObj(masterObj);
				dataList.add(instantDataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return dataList;
	}

	public Long fetchDailySnapshotDetailsCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, DailySnapshot dataObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from DailySnapshot master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
			strb.append(" and master.id.snapshotDateTime between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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

	public List<DailySnapshotLatest> fetchDailySnapshotLatestDataList(
			int pageNumber, int parseInt, String searchParameter,
			String sorting, DailySnapshotLatest dataObj,
			LevelIndexMaster levelIndexObj) {
		List<DailySnapshotLatest> dataList=new ArrayList<DailySnapshotLatest>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from DailySnapshotLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
			strb.append(" and master.snapshotDateTime between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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
			
			strb.append(" order by master.snapshotDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			@SuppressWarnings("unchecked")
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				DailySnapshotLatest instantDataObj=(DailySnapshotLatest) objArr[0];
				MeterMaster masterObj = (MeterMaster) objArr[1];
				instantDataObj.setMeterMasterObj(masterObj);
				dataList.add(instantDataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return dataList;
	}

	public Long fetchDailySnapshotLatestDetailsCount(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			DailySnapshotLatest dataObj, LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from DailySnapshotLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
			strb.append(" and master.snapshotDateTime between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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
	
}
