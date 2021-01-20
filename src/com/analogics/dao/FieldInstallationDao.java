package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.vo.FieldInstallationMaster;
import com.analogics.vo.MeterMaster;

public class FieldInstallationDao extends BaseHibernateDAO  {
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	
	@SuppressWarnings("unchecked")
	public List<FieldInstallationMaster> fetchFieldInstallationMasterList(int pageNumber,
			int parseInt, String searchParameter,
			FieldInstallationMaster masterObj) {
		
		List<FieldInstallationMaster> list = new ArrayList<FieldInstallationMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append(" from FieldInstallationMaster master   ");
			
			
		/*	if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			*/
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			list= queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	public Long fetchFieldInstallationCount(FieldInstallationMaster masterObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from FieldInstallationMaster master ");
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
	public FieldInstallationMaster fetchFieldInstalltionMasterDetails(
			String circleid, String consumerNo, String consumerid) {
		FieldInstallationMaster list = new FieldInstallationMaster();
		Session session = null;

		try {
			session = getSession();
			String str = "from FieldInstallationMaster where id.circleid=:circleid and id.consumerNo = :consumerNo and id.consumerid = :consumerid";
			Query que = session.createQuery(str);
			que.setParameter("circleid", circleid);
			que.setParameter("consumerNo", consumerNo);
			que.setParameter("consumerid", consumerid);
			list = (FieldInstallationMaster) que.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	public boolean deleteFieldInstalltionMasterDetails(String circleid,
			String consumerNo, String consumerid) {
		Transaction tr = null;
		Session session = null;
		boolean isSaved = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from FieldInstallationMaster where id.circleid=:circleid and id.consumerNo = :consumerNo and id.consumerid = :consumerid";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("circleid", circleid);
			query.setParameter("consumerNo", consumerNo);
			query.setParameter("consumerid", consumerid);
			query.executeUpdate();
			tr.commit();
			isSaved = true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return isSaved;
	}
	

}
