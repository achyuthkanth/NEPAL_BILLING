package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			String colName, ModuleMaster masterObj) {
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
			
			if(colName!=""){
				strb.append(" order by "+colName+" "+sorting+"");
			}
			/*if(!masterObj.getColStr().equalsIgnoreCase("")&& !masterObj.getColParameter().equalsIgnoreCase("")){
				strb.append(" where master."+masterObj.getColStr()+" like :colParameter");
			}*/
			Query queryObj = session.createQuery(strb.toString());
			/*if(!masterObj.getColStr().equalsIgnoreCase("")&& !masterObj.getColParameter().equalsIgnoreCase("")){
				queryObj.setParameter("colParameter", masterObj.getColParameter());
			}*/
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
			String searchParameter, String sorting, String colName,
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
			/*if(!masterObj.getColStr().equalsIgnoreCase("")&& !masterObj.getColParameter().equalsIgnoreCase("")){
				strb.append(" where master."+masterObj.getColStr()+" like :colParameter");
			}*/
			Query queryObj = session.createQuery(strb.toString());
			/*if(!masterObj.getColStr().equalsIgnoreCase("")&& !masterObj.getColParameter().equalsIgnoreCase("")){
			queryObj.setParameter("colParameter", masterObj.getColParameter());
			}*/
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
			query.executeUpdate();
			/*String sqlQuery2 = "delete from ModuleDetails  where id.moduleTypeName=:moduleTypeName1";
					
			Query query2 = session.createQuery(sqlQuery2);
			query2.setParameter("moduleTypeName1", moduleTypeName);
			query2.executeUpdate();*/
			tr.commit();
			isDeleted = true;
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
	
	
}
