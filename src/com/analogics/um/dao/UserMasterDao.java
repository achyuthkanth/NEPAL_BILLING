package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.BioUserDetails;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.utils.CommonQueryFrameUtils;

public class UserMasterDao extends BaseHibernateDAO {
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();	
	@SuppressWarnings("unchecked")
	public List<String> fetchUserGroupList() {
		List<String> grouplist = new ArrayList<String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("select distinct id.groupname from UserGroup");
			Query queryobj = session.createQuery(strb.toString());
			grouplist = queryobj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return grouplist;
	}
	
	public ApplicationMaster fetchApplicationUniqueId(String level1Id) {
		ApplicationMaster ApplicationMasterObj = null;
		Session session = null;
		try {
			session = getSession();
			Query queryObj = session
					.createQuery("from ApplicationMaster where level1Id='"
							+ level1Id + "'");
			ApplicationMasterObj = (ApplicationMaster) queryObj.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return ApplicationMasterObj;
	}

	@SuppressWarnings("unchecked")
	public List<BioUserDetails> fetchNewUserList(int pageNumber, int parseInt,
			String searchParameter, String sorting, BioUserDetails newUserObj) {
		List<BioUserDetails> list = new ArrayList<BioUserDetails>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("from BioUserDetails master ");
			
			if(!newUserObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !newUserObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
				strb1 = queryFrameObj.conditionQuery(newUserObj.getSearchSelectVar(),
						newUserObj.getSearchParameter(),
						newUserObj.getConditionStr());
				strb.append(strb1);
			}
			strb.append(" order by master.userid "+sorting+"");
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

	public Long fetchNewUserCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, BioUserDetails newUserObj) {
		long count = 0;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			StringBuilder strb1 = new StringBuilder(); 
			strb.append("select count(*) from BioUserDetails master ");
			
			if(!newUserObj.getSearchSelectVar().equalsIgnoreCase("")
					&& !newUserObj.getSearchSelectVar().equalsIgnoreCase("SELECT")){
				strb.append(" where ");
				strb1 = queryFrameObj.conditionQuery(newUserObj.getSearchSelectVar(),
						newUserObj.getSearchParameter(),
						newUserObj.getConditionStr());
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

	public boolean deleteNewUserMaster(String userId) {
		Transaction tr = null;
		Session session = null;
		boolean isSaved = false;
		try {
			session = getSession();
			tr = session.beginTransaction();
			String sqlQuery = "delete from BioUserDetails where userId=:userId";
			Query query = session.createQuery(sqlQuery);
			query.setParameter("userId", userId);
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

	public BioUserDetails editNewUserDetails(String userId) {
		BioUserDetails list = new BioUserDetails();
		Session session = null;

		try {
			session = getSession();
			String str = "from BioUserDetails where userId=:userId";
			Query que = session.createQuery(str);
			que.setParameter("userId", userId);
			list = (BioUserDetails) que.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}
	public BioUserDetails fetchLevelIndexMasterDetails(BioUserDetails detailsObj) {
		Session session = null;
		LevelIndexMaster masterObj = new LevelIndexMaster();
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from  LevelIndexMaster where  indexId='"+detailsObj.getIndexid()+"'");
			Query queryObj = session.createQuery(strb.toString());
//			queryObj.setParameter("indexId", detailsObj.getIndexid());
			masterObj = (LevelIndexMaster) queryObj.list().get(0);
			
			detailsObj.setLevel1Id(masterObj.getId().getLevel1id()+"");
			detailsObj.setLevel2Id(masterObj.getId().getLevel2id()+"");
			detailsObj.setLevel3Id(masterObj.getId().getLevel3id()+"");
			detailsObj.setLevel4Id(masterObj.getId().getLevel4id()+"");
			detailsObj.setLevel5Id(masterObj.getId().getLevel5id()+"");
			detailsObj.setLevel6Id(masterObj.getId().getLevel6id()+"");
			detailsObj.setLevel7Id(masterObj.getId().getLevel7id()+"");
			detailsObj.setLevel8Id(masterObj.getId().getLevel8id()+"");
			detailsObj.setLevel9Id(masterObj.getId().getLevel9id()+"");
			detailsObj.setLevel10Id(masterObj.getId().getLevel10id()+"");
			detailsObj.setLevel11Id(masterObj.getId().getLevel11id()+"");
			detailsObj.setLevel12Id(masterObj.getId().getLevel12id()+"");
			detailsObj.setLevel13Id(masterObj.getId().getLevel13id()+"");
			detailsObj.setLevel14Id(masterObj.getId().getLevel14id()+"");
			detailsObj.setLevel15Id(masterObj.getId().getLevel15id()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return detailsObj;
		
	}
}
