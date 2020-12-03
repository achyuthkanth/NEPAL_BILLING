package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.analogics.um.vo.ModuleMaster;

public class ModulesDao extends BaseHibernateDAO{

	@SuppressWarnings("unchecked")
	public List<ModuleMaster> fetchModuleMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			String colName, ModuleMaster masterObj) {
		List<ModuleMaster> list = new ArrayList<ModuleMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder(); 
			strb.append("from ModuleMaster master");
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
			strb.append("select count(*) from ModuleMaster master");
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
	

}
