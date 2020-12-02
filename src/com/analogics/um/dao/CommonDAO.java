package com.analogics.um.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author achyuth kanth pamuru
 *
 */
public class CommonDAO extends BaseHibernateDAO{
	
	
	public boolean saveOrUpdate(Object obj){
		boolean response=false;
		Session session=null;
		Transaction tr=null;
		try{
			session=getSession();
			tr=session.beginTransaction();
			session.saveOrUpdate(obj);
			tr.commit();
			response=true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return response;
	}
	
	public boolean save(Object obj){
		boolean response=false;
		Session session=null;
		Transaction tr=null;
		try{
			session=getSession();
			tr=session.beginTransaction();
			session.save(obj);
			tr.commit();
			response=true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return response;
	}

	public static void main(String[] args) {
		new CommonDAO().save(null);

	}

}
