package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ParamTable;
import com.analogics.um.vo.ParamTableId;
import com.analogics.utils.CommonQueryFrameUtils;

/**
 * 
 * @author Sandhya.B
 *
 */
public class ParamMasterDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	

	@SuppressWarnings("unchecked")
	public List<ParamTable> fetchParamTypeList() {
		List<ParamTable> list=new ArrayList<ParamTable>();
		List<String> list1=new ArrayList<String>();
		Session session = null;
		try{
			session = getSession();
			StringBuilder str=new StringBuilder();
			str.append("select distinct(id.paramType) from ParamTable");
			Query queryObj = session.createQuery(str.toString());
			list1= queryObj.list();
																				
			for (String paramTable : list1) {
				ParamTable param= new ParamTable();
				ParamTableId paramId=new ParamTableId();
				paramId.setParamType(paramTable);
				param.setId(paramId);
				list.add(param);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ParamTable> fetchParamMasterList(int pageNumber, int parseInt,
			String searchParameter, String sorting, ParamTable masterObj, String paramType) {
		List<ParamTable> list = new ArrayList<ParamTable>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("from ParamTable master where id.paramType=:paramType");
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			strb.append(" order by id.paramName "+sorting+"");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("paramType", paramType);
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

	public Long fetchParamMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ParamTable masterObj, String paramType) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from ParamTable master where id.paramType=:paramType");
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("paramType", paramType);
			count = (Long) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return count;
	}

	public String deleteParamTypeDetails(String paramType, String paramName) {
		Session session = null;
		String response = "error";
		Transaction tr=null;
		try {
			session = getSession();
			tr=session.beginTransaction();
			StringBuilder str=new StringBuilder();
			str.append("delete from ParamTable where id.paramType=:paramType and id.paramName=:paramName");
			Query queryObj = session.createQuery(str.toString());
			queryObj.setParameter("paramType", paramType);
			queryObj.setParameter("paramName", paramName);
			queryObj.executeUpdate();
			int res = queryObj.executeUpdate();
			if (res > 0) {
				tr.commit();
				response = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return response;
	}
	
	public ParamTable editParamTypeDetails(String paramName, String paramType) {
		ParamTable list = new ParamTable();
		Session session = null;
		try {
			session = getSession();
			String str ="from ParamTable where id.paramType=:paramType and id.paramName=:paramName";
			Query queryObj=session.createQuery(str);
			queryObj.setParameter("paramType", paramType);
			queryObj.setParameter("paramName", paramName);
			list=(ParamTable) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ParamTable> fetchParamDetails(String paramType) {
		List<ParamTable> list=new ArrayList<ParamTable>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder str=new StringBuilder();
			str.append("from ParamTable where id.paramType=:paramType");
			Query queryObj = session.createQuery(str.toString());
			queryObj.setParameter("paramType", paramType);
			list=queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}


}
