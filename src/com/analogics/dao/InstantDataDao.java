package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.InstantData;
import com.analogics.vo.InstantDataLatest;
import com.analogics.vo.MeterMaster;

/**
 * 
 * @author Sandhya.B
 *
 */

public class InstantDataDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	
	@SuppressWarnings("unchecked")
	public List<InstantData> fetchInstantDataList(int pageNumber, int parseInt,
			String searchParameter, String sorting, InstantData dataObj,
			LevelIndexMaster levelIndexObj) {
		List<InstantData> dataList=new ArrayList<InstantData>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from InstantData master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
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
			
			strb.append(" order by master.id.meterDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				InstantData instantDataObj=(InstantData) objArr[0];
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
	public Long fetchInstantDataDetailsCount(InstantData dataObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from InstantData master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
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
	@SuppressWarnings("unchecked")
	public List<InstantDataLatest> fetchLatestInstantDataList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			InstantDataLatest dataObj, LevelIndexMaster levelIndexObj) {
		List<InstantDataLatest> dataList=new ArrayList<InstantDataLatest>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from InstantDataLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
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
			
			strb.append(" order by master.meterDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				InstantDataLatest instantDataObj=(InstantDataLatest) objArr[0];
				/*MeterMaster masterObj = (MeterMaster) objArr[1];
				instantDataObj.setMeterMasterObj(masterObj);*/
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
	public Long fetchLatestInstantDataDetailsCount(InstantDataLatest dataObj, LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from InstantDataLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.meterNumber=mas.meterNumber");
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
