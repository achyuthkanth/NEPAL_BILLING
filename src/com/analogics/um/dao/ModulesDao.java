package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ModuleDetails;
import com.analogics.um.vo.ModuleMaster;
import com.analogics.utils.CommonQueryFrameUtils;

/**
 * 
 * @author Sandhya.B
 *
 */
public class ModulesDao extends BaseHibernateDAO{
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	

	@SuppressWarnings("unchecked")
	public List<ModuleMaster> fetchModuleMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ModuleMaster masterObj) {
		List<ModuleMaster> list = new ArrayList<ModuleMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("from ModuleMaster master ");
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			strb.append(" order by master.moduleTypeName "+sorting+"");
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

	public Long fetchModuleMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting,
			ModuleMaster masterObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from ModuleMaster master ");
			
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

	public boolean deleteModuleMaster(String moduleTypeName) {
		Transaction tr = null;
		Session session = null;
		boolean isDeleted = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from ModuleMaster where moduleTypeName=:moduleTypeName";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("moduleTypeName", moduleTypeName);
			int res = query.executeUpdate();
			
			String sqlQuery2 = "delete from ModuleDetails where id.moduleTypeName=:moduleTypeName1";
			Query query2 = session.createQuery(sqlQuery2);
			query2.setParameter("moduleTypeName1", moduleTypeName);
			query2.executeUpdate();
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

	public ModuleMaster fetchModuleMasterData(String moduleTypeName) {
		ModuleMaster masterObj = new ModuleMaster();
		Session session = null;
		try {
			session = getSession();
			String sqlQuery = "from ModuleMaster where moduleTypeName=:moduleTypeName";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("moduleTypeName", moduleTypeName);
			masterObj=(ModuleMaster) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}


	@SuppressWarnings("unchecked")
	public List<ModuleDetails> fetchModuleDetailsList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ModuleDetails detailsObj) {

		List<ModuleDetails> list = new ArrayList<ModuleDetails>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("from ModuleDetails master where id.moduleTypeName=:moduleTypeName ");
			
			if(!detailsObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !detailsObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(detailsObj.getSearchSelectVar(),
						detailsObj.getSearchParameter(),
						detailsObj.getConditionStr());
				strb.append(strb1);
			}
			strb.append(" order by master.id.moduleTypeName "+sorting+"");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("moduleTypeName", detailsObj.getId().getModuleTypeName());
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

	public Long fetchModuleDetailsCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ModuleDetails detailsObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from ModuleDetails master where id.moduleTypeName=:moduleTypeName ");
			
			if(!detailsObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !detailsObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(detailsObj.getSearchSelectVar(),
						detailsObj.getSearchParameter(),
						detailsObj.getConditionStr());
				strb.append(strb1);
			}
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("moduleTypeName", detailsObj.getId().getModuleTypeName());
			count = (Long) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return count;
	}

	public boolean deleteModuleDetails(String moduleTypeName,
			String moduleAction) {
		Transaction tr = null;
		Session session = null;
		boolean isDeleted = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from ModuleDetails where id.moduleTypeName=:moduleTypeName and id.moduleAction=:moduleAction";
			Query queryObj = session.createQuery(sqlQuery);
			queryObj.setParameter("moduleTypeName", moduleTypeName);
			queryObj.setParameter("moduleAction", moduleAction);
			int res = queryObj.executeUpdate();
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
	
	public ModuleDetails fetchModuleDetails(String moduleTypeName,
			String moduleAction) {
		ModuleDetails detailsObj = new ModuleDetails();
		Session session = null;
		try {
			session = getSession();
			StringBuilder str = new StringBuilder();
			str.append("from ModuleDetails where id.moduleTypeName=:moduleTypeName and id.moduleAction=:moduleAction");
			Query queryObj = session.createQuery(str.toString());
			queryObj.setParameter("moduleTypeName", moduleTypeName);
			queryObj.setParameter("moduleAction", moduleAction);
			detailsObj = (ModuleDetails) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return detailsObj;
	}
	
	
}
