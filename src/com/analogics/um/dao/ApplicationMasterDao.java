package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.HierarchyLevel1;
import com.analogics.utils.CommonQueryFrameUtils;

/**
 * 
 * @author Sandhya.B
 *
 */
public class ApplicationMasterDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();

	@SuppressWarnings("unchecked")
	public List<ApplicationMaster> fetchApplicationMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ApplicationMaster masterObj) {
		List<ApplicationMaster> list = new ArrayList<ApplicationMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("from ApplicationMaster master ");
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			strb.append(" order by master.applicationuniquecode "+sorting+"");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			list = queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	public Long fetchApplicationMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ApplicationMaster masterObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from ApplicationMaster master ");
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
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

	public boolean deleteApplicationMaster(String applicationuniquecode) {
		Transaction tr = null;
		Session session = null;
		boolean isDeleted = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from ApplicationMaster where applicationuniquecode=:applicationuniquecode";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("applicationuniquecode", applicationuniquecode);
			int res = query.executeUpdate();
			if (res > 0) {
				tr.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return isDeleted;
	}

	public ApplicationMaster fetchApplicationMasterData(
			String applicationuniquecode) {
		ApplicationMaster masterObj = new ApplicationMaster();
		Session session = null;
		try {
			session = getSession();
			String sqlQuery = "from ApplicationMaster where applicationuniquecode=:applicationuniquecode";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("applicationuniquecode", applicationuniquecode);
			masterObj=(ApplicationMaster) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> fetchLevelMapList() {
		Session session = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<HierarchyLevel1> level1 = new ArrayList<HierarchyLevel1>();
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from HierarchyLevel1");
					
			Query query = session.createQuery(strb.toString());
			level1 = query.list();
			for (HierarchyLevel1 hierarchyLevel1 : level1) {
				map.put(hierarchyLevel1.getLevel1Id(),
						hierarchyLevel1.getLevel1Name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return map;
	}	

}
