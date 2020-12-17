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
import com.analogics.vo.MeterMaster;

public class MeterMasterDao extends BaseHibernateDAO  {
	UserHierarchyQueryFraming frameObj = new UserHierarchyQueryFraming();
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	
	
	
	public List<MeterMaster> fetchMeterMasterList(int pageNumber, int parseInt,
			String searchParameter, MeterMaster masterObj,
			LevelIndexMaster levelIndexObj) {
		List<MeterMaster> list = new ArrayList<MeterMaster>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append(" from MeterMaster master,LevelIndexMaster levels where  ");
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
			@SuppressWarnings("unchecked")
			List<Object[]> objList= queryObj.list();
			for(Object[] objArr:objList){
				MeterMaster dObj=(MeterMaster) objArr[0];
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

	public Long fetchMeterMasterCount(MeterMaster masterObj,
			LevelIndexMaster levelIndexObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from MeterMaster master,LevelIndexMaster levels where  ");
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

	public MeterMaster fetchMeterMasterDetails(String meterNumber) {
		MeterMaster list = new MeterMaster();
		Session session = null;

		try {
			session = getSession();
			String str = "from MeterMaster where meterNumber=:meterNumber";
			Query que = session.createQuery(str);
			que.setParameter("meterNumber", meterNumber);
			list = (MeterMaster) que.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	
	public MeterMaster fetchLevelIndexMasterDetails(MeterMaster meterMasterObj) {
		Session session = null;
		LevelIndexMaster masterObj = new LevelIndexMaster();
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from  LevelIndexMaster where  indexId=:indexId");
			Query queryObj = session.createQuery(strb.toString());
			queryObj.setParameter("indexId", meterMasterObj.getIndexid());
			masterObj = (LevelIndexMaster) queryObj.list().get(0);
			meterMasterObj.setLevel1Id(masterObj.getId().getLevel1id() + "");
			meterMasterObj.setLevel2Id(masterObj.getId().getLevel2id() + "");
			meterMasterObj.setLevel3Id(masterObj.getId().getLevel3id() + "");
			meterMasterObj.setLevel4Id(masterObj.getId().getLevel4id() + "");
			meterMasterObj.setLevel5Id(masterObj.getId().getLevel5id() + "");
			meterMasterObj.setLevel6Id(masterObj.getId().getLevel6id() + "");
			meterMasterObj.setLevel7Id(masterObj.getId().getLevel7id() + "");
			meterMasterObj.setLevel8Id(masterObj.getId().getLevel8id() + "");
			meterMasterObj.setLevel9Id(masterObj.getId().getLevel9id() + "");
			meterMasterObj.setLevel10Id(masterObj.getId().getLevel10id() + "");
			meterMasterObj.setLevel11Id(masterObj.getId().getLevel11id() + "");
			meterMasterObj.setLevel12Id(masterObj.getId().getLevel12id() + "");
			meterMasterObj.setLevel13Id(masterObj.getId().getLevel13id() + "");
			meterMasterObj.setLevel14Id(masterObj.getId().getLevel14id() + "");
			meterMasterObj.setLevel15Id(masterObj.getId().getLevel15id() + "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return meterMasterObj;

	}
	
	public boolean deleteMeterMasterDetails(String meterNumber) {
		Transaction tr = null;
		Session session = null;
		boolean isSaved = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from MeterMaster where meterNumber=:meterNumber";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("meterNumber", meterNumber);
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
	
	public Object[] fetchLevelDetails(Integer levelNumber,String uniqueCode){
		Object[] strArr=null;
		Session session=null;
		try{
			session=getSession();
			Query queryObj = session.createSQLQuery("SELECT level" + levelNumber+ "_Id,level" + levelNumber+ "_Name from hierarchy_level" + levelNumber + " "
					+ "where level" + levelNumber + "_uniqueCode=?");
			
			queryObj.setParameter(0, uniqueCode.toUpperCase());
			Object[] objArr = (Object[]) queryObj.list().get(0);
			strArr=objArr;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return strArr;
	}
	
	
	public MeterMaster saveUploadMeterMasterDetails(MeterMaster meterMaster) {
		MeterMaster meterMasterObj=new MeterMaster(); 
		Transaction tr = null;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			session.saveOrUpdate(meterMaster);
//			session.save(meterMaster);
			tr.commit();
			meterMasterObj.setSuccessMessage("SUCCESS");
		} catch (Exception e) {
			tr.rollback();
			meterMasterObj.setErrorMessage("Error in Insertion");
			if(e.getMessage().contains("batch")){
			
			}else{
				meterMasterObj.setErrorMessage(e+"");
			}
		}finally{
			if (session.isOpen())
				session.close();
		}
		return meterMasterObj;
	}
}
