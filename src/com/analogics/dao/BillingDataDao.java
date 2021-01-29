package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.BillingData;
import com.analogics.vo.BillingDataLatest;
import com.analogics.vo.MeterMaster;

/**
 * 
 * @author Sandhya.B
 *
 */

public class BillingDataDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	
	@SuppressWarnings("unchecked")
	public List<BillingData> fetchBillingDataList(int pageNumber, int parseInt,
			String searchParameter, String sorting, BillingData dataObj,
			LevelIndexMaster levelIndexObj) {
		List<BillingData> dataList=new ArrayList<BillingData>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from BillingData master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
			strb.append(" and master.mdresetDate between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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
			
			strb.append(" order by master.id.mdresetDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				BillingData billingDataObj=(BillingData) objArr[0];
				MeterMaster masterObj = (MeterMaster) objArr[1];
				billingDataObj.setMeterMasterObj(masterObj);
				dataList.add(billingDataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return dataList;
	}
	public Long fetchBillingDataDetailsCount(BillingData dataObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from BillingData master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append("where master.id.meterNumber=mas.meterNumber");
			strb.append(" and master.mdresetDate between '"+dataObj.getFromDate()+"' and '"+dataObj.getToDate()+"'");
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
	public List<BillingDataLatest> fetchLatestBillingDataList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			BillingDataLatest dataObj, LevelIndexMaster levelIndexObj) {
		List<BillingDataLatest> dataList=new ArrayList<BillingDataLatest>();
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			strb.append(" from BillingDataLatest master, MeterMaster mas,LevelIndexMaster levels ");
			strb.append(" where master.meterNumber=mas.meterNumber");
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
			
			strb.append(" order by master.mdresetDateTime");
			
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				BillingDataLatest billingDataObj=(BillingDataLatest) objArr[0];
				/*MeterMaster masterObj = (MeterMaster) objArr[1];
				instantDataObj.setMeterMasterObj(masterObj);*/
				dataList.add(billingDataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return dataList;
	}
	public Long fetchLatestBillingDataDetailsCount(BillingDataLatest dataObj, LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuffer stb1 = new StringBuffer();
			StringBuilder stb2 = new StringBuilder(); 
			StringBuilder strb = new StringBuilder();
			
			strb.append("select count(*) from BillingDataLatest master, MeterMaster mas,LevelIndexMaster levels ");
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
