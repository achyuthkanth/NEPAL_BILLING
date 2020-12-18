package com.analogics.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.utils.UserHierarchyQueryFraming;
import com.analogics.vo.ConsumerMaster;
import com.analogics.vo.ConsumerMeterMaster;
import com.analogics.vo.MeterMaster;

/**
 * 
 * @author Sandhya.B
 *
 */
public class ConsumerMasterDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();

	@SuppressWarnings("unchecked")
	public List<ConsumerMaster> fetchConsumerMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ConsumerMaster masterObj, LevelIndexMaster levelIndexObj) {
		List<ConsumerMaster> list = new ArrayList<ConsumerMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append(" from ConsumerMaster master,LevelIndexMaster levels where  ");
			strb.append(" master.indexid=levels.indexid");
			
			strb.append(frameObj.frameUserHierarchyQuery(levelIndexObj));
			
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
				strb1 = queryFrameObj.conditionQuery(masterObj.getSearchSelectVar(),
						masterObj.getSearchParameter(),
						masterObj.getConditionStr());
				strb.append(strb1);
			}
			
			strb.append(" order by master.insertedDate");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setFirstResult(pageNumber);
			queryObj.setMaxResults(parseInt);
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				ConsumerMaster dObj=(ConsumerMaster) objArr[0];
				list.add(dObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	public Long fetchConsumerMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ConsumerMaster masterObj, LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from ConsumerMaster master,LevelIndexMaster levels where  ");
			strb.append(" master.indexid=levels.indexid");
			strb.append(frameObj
					.frameUserHierarchyQuery(levelIndexObj));
			if(!masterObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !masterObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" and ");
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

	public ConsumerMaster fetchConsumerMasterDetails(String consumerId) {
		ConsumerMaster list = new ConsumerMaster();
		Session session = null;
		try {
			session = getSession();
			String str = "from ConsumerMaster where consumerId=:consumerId";
			Query que = session.createQuery(str);
			que.setParameter("consumerId", consumerId);
			list = (ConsumerMaster) que.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	public boolean deleteConsumerMasterDetails(String consumerId) {
		Transaction tr = null;
		Session session = null;
		boolean isDeleted = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from ConsumerMaster where consumerId=:consumerId";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("consumerId", consumerId);
			query.executeUpdate();
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
	
	public boolean deleteConsumerMeterMasterDetails(String consumerId) {
		Transaction tr = null;
		Session session = null;
		boolean isDeleted = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from ConsumerMeterMaster where id.consumerId=:consumerId";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("consumerId", consumerId);
			query.executeUpdate();
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

	public ConsumerMaster saveUploadConsumerMasterDetails(
			ConsumerMaster masterObj) {
		ConsumerMaster consObj=new ConsumerMaster(); 
		Transaction tr = null;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			session.merge(masterObj);
			tr.commit();
			consObj.setSuccessMessage("SUCCESS");
		} catch (Exception e) {
			tr.rollback();
			consObj.setErrorMessage("Error in Insertion");
			if(e.getMessage().contains("batch")){
			
			}else{
				consObj.setErrorMessage(e+"");
			}
		}finally{
			if (session.isOpen())
				session.close();
		}
		return consObj;
	}

	
	@SuppressWarnings("unchecked")
	public ConsumerMaster fetchMeterNumberList() {
		ConsumerMaster masterObj = new ConsumerMaster();
		List<MeterMaster> list = new ArrayList<MeterMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("select meterNumber from MeterMaster");
			Query queryObj = session.createQuery(strb.toString());
			list = queryObj.list();
			masterObj.setMeterNumbersList(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return masterObj;
	}

	public ConsumerMeterMaster fetchConsumerMeterMasterDetails(String consumerId) {
		ConsumerMeterMaster list = new ConsumerMeterMaster();
		Session session = null;
		try {
			session = getSession();
			String str = "from ConsumerMeterMaster where id.consumerId=:consumerId";
			Query que = session.createQuery(str);
			que.setParameter("consumerId", consumerId);
			list = (ConsumerMeterMaster) que.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	
	
	
	/*public List<ConsumerMaster> fetchConsumerMeterMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ConsumerMaster masterObj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long fetchConsumerMeterMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ConsumerMaster masterObj) {
		// TODO Auto-generated method stub
		return null;
	}*/


}
