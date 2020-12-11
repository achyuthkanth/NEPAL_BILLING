package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ModuleDetails;
import com.analogics.um.vo.UserGroup;
import com.analogics.um.vo.UserGroupActions;
import com.analogics.um.vo.UserGroupActionsId;
import com.analogics.um.vo.UserGroupViews;
import com.analogics.um.vo.UserGroupViewsId;

public class UserGroupDAO  extends BaseHibernateDAO{

	@SuppressWarnings("unchecked")
	public List<ModuleDetails> fetchModuleDetailsList() {
		List<ModuleDetails> list = new ArrayList<ModuleDetails>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from ModuleDetails master order by id.moduleTypeName");
			Query queryObj = session.createQuery(strb.toString());
			list = queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UserGroup> fetchUserGroupList() {
		List<UserGroup> list = new ArrayList<UserGroup>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from UserGroup ");
			Query queryObj = session.createQuery(strb.toString());
			list = queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	public boolean saveGroupDetails(UserGroup userGroup){
		boolean isSaved = false;
		Transaction tr = null;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			
			Query queryObj=session.createQuery("delete from UserGroup where id.groupname='"+userGroup.getId().getGroupname()+"'");
			queryObj.executeUpdate();
			
			queryObj=session.createQuery("delete from UserGroupViews where id.groupname='"+userGroup.getId().getGroupname()+"'");
			queryObj.executeUpdate();
			
			queryObj=session.createQuery("delete from UserGroupActions where id.groupname='"+userGroup.getId().getGroupname()+"'");
			queryObj.executeUpdate();
			
			String[] moduleEnabledActions=userGroup.getModuleEnabledActions();
			String[] checkBoxArr=userGroup.getCheckBoxArr();
			
			String[] createflag=userGroup.getCreateflag();
			String[] readflag=userGroup.getReadflag();
			String[] updateflag=userGroup.getUpdateflag();
			String[] deleteflag=userGroup.getDeleteflag();

			List<String> createList=new ArrayList<String>();
			for(String str:createflag){
				if(!createList.contains(str)){
					createList.add(str);
				}
			}
			
			List<String> readList=new ArrayList<String>();
			for(String str:readflag){
				if(!readList.contains(str)){
					readList.add(str);
				}
			}
			
			List<String> updateList=new ArrayList<String>();
			for(String str:updateflag){
				if(!updateList.contains(str)){
					updateList.add(str);
				}
			}
			
			List<String> deleteList=new ArrayList<String>();
			for(String str:deleteflag){
				if(!deleteList.contains(str)){
					deleteList.add(str);
				}
			}
			
			try{
				for(String viewStr:checkBoxArr){
					UserGroupViews viewsObj=new UserGroupViews();
					UserGroupViewsId viewsIdObj=new UserGroupViewsId();
					viewsIdObj.setGroupname(userGroup.getId().getGroupname());
					viewsIdObj.setViewname(viewStr);
					viewsObj.setId(viewsIdObj);
					session.saveOrUpdate(viewsObj);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			for(String moduleStr:moduleEnabledActions){
				String[] strArr=moduleStr.split("\\|",-1);
				String moduleName=strArr[0];
				String moduleAction=strArr[1];
				
				UserGroupActions groupActionObj=new UserGroupActions();
				UserGroupActionsId groupActionId=new UserGroupActionsId();
				
				groupActionId.setGroupname(userGroup.getId().getGroupname());
				groupActionId.setModuleAction(moduleAction);
				groupActionObj.setId(groupActionId);
				groupActionObj.setModuleName(moduleName);

				groupActionObj.setCreateflag("N");
				if(createList.contains(moduleAction)){
					groupActionObj.setCreateflag("Y");
				}
				
				groupActionObj.setDeleteflag("N");
				if(deleteList.contains(moduleAction)){
					groupActionObj.setDeleteflag("Y");
				}
				
				groupActionObj.setReadflag("N");
				if(readList.contains(moduleAction)){
					groupActionObj.setReadflag("Y");
				}
				
				groupActionObj.setUpdateflag("N");
				if(updateList.contains(moduleAction)){
					groupActionObj.setUpdateflag("Y");
				}
				
				session.saveOrUpdate(groupActionObj);
				
			}
			
			session.saveOrUpdate(userGroup);
			
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

	public UserGroup fetchUserGroup(String groupName) {
		UserGroup userGroup = null;
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from UserGroup where id.groupname='"+groupName+"'");
			Query queryObj = session.createQuery(strb.toString());
			userGroup = (UserGroup) queryObj.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return userGroup;
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchUserGroupViewsList(String groupName) {
		List<String> list = new ArrayList<String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("select id.viewname from UserGroupViews where id.groupname='"+groupName+"'");
			Query queryObj = session.createQuery(strb.toString());
			list = queryObj.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Map<String,String> fetchUserGroupActionsList(String groupName) {
		Map<String,String> map = new HashMap<String,String>();
		Session session = null;
		try {
			session = getSession();
			StringBuilder strb = new StringBuilder();
			strb.append("from UserGroupActions where id.groupname='"+groupName+"'");
			Query queryObj = session.createQuery(strb.toString());
			List<UserGroupActions> list = queryObj.list();
			for(UserGroupActions userAct:list){
				String permissions=userAct.getCreateflag()+"|"+userAct.getReadflag()+"|"+userAct.getUpdateflag()+"|"+userAct.getDeleteflag()+"|";
				String moduleAction=userAct.getId().getModuleAction();
				map.put(moduleAction, permissions);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return map;
	}
	

}
