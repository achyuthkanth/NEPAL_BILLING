package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ApplicationLevelIndexMaster;
import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.BioUserDetails;
import com.analogics.um.vo.LevelIndexMaster;

public class UserLoginDao extends BaseHibernateDAO{

	public BioUserDetails fetchBioUserDetails(String userid) {
		Transaction tr = null;
		Session session = null;
		BioUserDetails masterObj = new BioUserDetails();
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "from BioUserDetails where userid=:userid";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("userid", userid);
			masterObj=(BioUserDetails) query.uniqueResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}

	public LevelIndexMaster fetchLevelIndexMaster(String indexid) {
		Session session = null;
		LevelIndexMaster masterObj = new LevelIndexMaster();
		try {
			session = getSession();
			String sqlQuery = "from LevelIndexMaster where indexid=:indexid";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("indexid", Integer.parseInt(indexid));
			masterObj=(LevelIndexMaster) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}

	public ApplicationLevelIndexMaster appLevelIndexMasterDetails(String indexid) {
		ApplicationLevelIndexMaster levelindexobj = null;
		Session session = null;
		try {
			session = getSession();
			Query queryobj = session.createQuery("from ApplicationLevelIndexMaster where appIndexid=:indexId");
			queryobj.setParameter("indexId", Integer.parseInt(indexid));
			levelindexobj = (ApplicationLevelIndexMaster) queryobj.list().get(0);
			
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return levelindexobj;
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchEnabledActionsList(String usergroupid, String userId) {
		List<String> enabledactionlist = new ArrayList<String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder viewSbr=new StringBuilder();
			if(userId.equalsIgnoreCase("superuser")){
				viewSbr.append("select id.moduleAction from ModuleDetails");
			}else{
				viewSbr.append("select m.id.moduleAction from UserGroupActions as m  ");
				viewSbr.append(" where m.id.groupname=:usergroupid and m.status=1 or m.status=2");
			}
			Query viewsQuery = session.createQuery(viewSbr.toString());
			if(!userId.equalsIgnoreCase("superuser")){
			viewsQuery.setParameter("usergroupid", usergroupid);
			enabledactionlist = viewsQuery.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return enabledactionlist;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> fetchEnabledViewsList(String usergroupid, String userId) {
		List<String> enabledViewsList = new ArrayList<String>();
		Session session = null;
		Query viewsQuery = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			if (userId.equalsIgnoreCase("superuser")) {
				Query q1 = session
						.createQuery("select viewname from ViewsMaster1");
				List l1 = q1.list();
				Query q2 = session
						.createQuery("select viewname from ViewsMaster2");
				List l2 = q2.list();
				l1.addAll(l2);
				Query q3 = session
						.createQuery("select viewname from ViewsMaster3");
				List l3 = q3.list();
				l1.addAll(l3);

				Query q4 = session
						.createQuery("select viewname from ViewsMaster4");
				List l4 = q4.list();
				l1.addAll(l4);
				enabledViewsList.addAll(l1);
			} else {
				strb.append("select v.id.viewname from UserGroup as g , UserGroupViews as v ");
				strb.append("where g.id.groupname=v.id.groupname  ");
				strb.append(" and g.id.groupname=:usergroupid");
				viewsQuery = session.createQuery(strb.toString());
				viewsQuery.setParameter("usergroupid", usergroupid);
				enabledViewsList = viewsQuery.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return enabledViewsList;
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchExpiredActionsList(String usergroupid,
			String userId) {
		List<String> expiredActionsList =new ArrayList<String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			if(userId.equalsIgnoreCase("superuser")){
				expiredActionsList=new ArrayList<String>();
			}else{
				strb.append("select m.id.moduleAction from UserGroupActions as m  ");
				strb.append(" where m.id.groupname=:usergroupid and m.status=2");
				Query viewsQuery = session.createQuery(strb.toString());
				viewsQuery.setParameter("usergroupid", usergroupid);
				expiredActionsList = viewsQuery.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return expiredActionsList;
	}

	public ApplicationMaster fetchApplicationDetails(String applicationuniqueid) {
		ApplicationMaster appMasterObj = null;
		Session session = null;
		try {
			session = getSession();
			Query queryobj = session.createQuery("from ApplicationMaster where applicationuniqueid=:applicationuniqueid");
			queryobj.setParameter("applicationuniqueid", Long.parseLong(applicationuniqueid));
			appMasterObj = (ApplicationMaster) queryobj.list().get(0);
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return appMasterObj;
	}

}
