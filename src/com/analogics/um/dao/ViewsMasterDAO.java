package com.analogics.um.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.analogics.um.vo.ViewsMaster1;
import com.analogics.um.vo.ViewsMaster2;


/**
 * 
 * @author achyuth kanth pamuru
 *
 */
public class ViewsMasterDAO extends BaseHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public List<ViewsMaster2> fetchAllViewsMaster1(){
		List<ViewsMaster2> list=new ArrayList<ViewsMaster2>();
		Session session=null;
		try{
			session=getSession();
			StringBuilder strb=new StringBuilder();
			strb.append("from ViewsMaster1");
			Query queryObj=session.createQuery(strb.toString());
			List<ViewsMaster1> dataList=queryObj.list();
			
			for(ViewsMaster1 view1Master:dataList){
				ViewsMaster2 viewmaster=new ViewsMaster2();
				viewmaster.setViewname(view1Master.getViewname());
				viewmaster.setViewdescription(view1Master.getViewdescription());
				viewmaster.setActionname(view1Master.getActionname());
				list.add(viewmaster);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewsMaster2> fetchAllViewsMaster2(Integer viewLevel,String parentView){
		List<ViewsMaster2> list=new ArrayList<ViewsMaster2>();
		Session session=null;
		try{
			session=getSession();
			StringBuilder strb=new StringBuilder();
			strb.append("select viewname,viewdescription,actionname,parentview from ViewsMaster"+viewLevel+" where parentview=:parentview");

			Query queryObj=session.createQuery(strb.toString());
			queryObj.setParameter("parentview", parentView);
			
			List<Object[]> objList=queryObj.list();
			
			for(Object[] objArr:objList){
				ViewsMaster2 viewmaster=new ViewsMaster2();
				viewmaster.setViewname((String) objArr[0]);
				viewmaster.setViewdescription((String) objArr[1]);
				viewmaster.setActionname((String) objArr[2]);
				viewmaster.setParentview((String) objArr[3]);
				list.add(viewmaster);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return list;
	}
	
	public boolean deleteViewDetails(Integer viewLevel,String viewName){
		boolean isDeleted = false;
		Transaction tr = null;
		Session session = null;
		try {
			session = getSession();
			tr = session.beginTransaction();
			
			StringBuilder strb=new StringBuilder();
			strb.append("delete from ViewsMaster"+viewLevel+" where viewname=:viewname");
			
			Query queryObj=session.createQuery(strb.toString());
			queryObj.setParameter("viewname", viewName);
			queryObj.executeUpdate();
			
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
	
	public ViewsMaster2 fetchViewData(Integer viewLevel,String viewName,String parentName){
		ViewsMaster2 viewMaster=null;
		Session session=null;
		try{
			session=getSession();
			StringBuilder strb=new StringBuilder();
			
			if(viewLevel!=1){
				strb.append("select viewname,viewdescription,actionname,parentview from ViewsMaster"+viewLevel+" where viewname=:viewname");
			}else{
				strb.append("select viewname,viewdescription,actionname from ViewsMaster"+viewLevel+" where viewname=:viewname");
			}
			
			Query queryObj=session.createQuery(strb.toString());
			queryObj.setParameter("viewname", viewName);
			
			Object[] objArr=(Object[]) queryObj.uniqueResult();
			
			if(objArr!=null&&objArr.length>0){
				viewMaster=new ViewsMaster2();
				viewMaster.setViewLevel(viewLevel);
				viewMaster.setViewname((String) objArr[0]);
				viewMaster.setViewdescription((String) objArr[1]);
				viewMaster.setActionname((String) objArr[2]);
				if(viewLevel!=1){
					viewMaster.setParentview((String) objArr[3]);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		
		return viewMaster;
	}
	
	
	@SuppressWarnings("unchecked")
	public String fetchUlLiString(List<String> userGroupViewsList){
		Session session=null;
		String response="";
		try{
			Map<String,Map<String,String>> viewsMap=new HashMap<String,Map<String,String>>();
			session=getSession();
			
			Query queryObj=session.createQuery("select viewname,viewdescription,actionname,1 from ViewsMaster1");
			List<Object[]> objList=queryObj.list();
			
			for(Object[] objArr:objList){
				String parentView=objArr[3]+"";
				Map<String,String> submap=viewsMap.get(parentView);
				if(submap==null){
					submap=new HashMap<String, String>();
				}
				submap.put(objArr[0]+"", objArr[1]+"|"+objArr[2]);
				viewsMap.put(parentView, submap);
			}
			
			queryObj=session.createQuery("select viewname,viewdescription,actionname,parentview from ViewsMaster2");
			objList=queryObj.list();
			
			for(Object[] objArr:objList){
				String parentView=objArr[3]+"";
				Map<String,String> submap=viewsMap.get(parentView);
				if(submap==null){
					submap=new HashMap<String, String>();
				}
				submap.put(objArr[0]+"", objArr[1]+"|"+objArr[2]);
				viewsMap.put(parentView, submap);
			}
			
			queryObj=session.createQuery("select viewname,viewdescription,actionname,parentview from ViewsMaster3");
			objList=queryObj.list();
			
			for(Object[] objArr:objList){
				String parentView=objArr[3]+"";
				Map<String,String> submap=viewsMap.get(parentView);
				if(submap==null){
					submap=new HashMap<String, String>();
				}
				submap.put(objArr[0]+"", objArr[1]+"|"+objArr[2]);
				viewsMap.put(parentView, submap);
			}
			
			queryObj=session.createQuery("select viewname,viewdescription,actionname,parentview from ViewsMaster4");
			objList=queryObj.list();
			
			for(Object[] objArr:objList){
				String parentView=objArr[3]+"";
				Map<String,String> submap=viewsMap.get(parentView);
				if(submap==null){
					submap=new HashMap<String, String>();
				}
				submap.put(objArr[0]+"", objArr[1]+"|"+objArr[2]);
				viewsMap.put(parentView, submap);
			}
			
			Map<String,String> l1Map=viewsMap.get("1");
			response=frameLi(viewsMap, l1Map,userGroupViewsList);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session.isOpen())
				session.close();
		}
		return response;
		
	}
	
	private String frameLi(Map<String,Map<String,String>> viewsMap,Map<String,String> l1Map,List<String> userGroupViewsList){
		StringBuilder strb=new StringBuilder();
		try{
			strb.append("<ul>");
			for (Entry<String, String> entry : l1Map.entrySet())  {
				String key=entry.getKey();
				strb.append("<li><input type='checkbox' class='userViewClass' name='checkBoxArr' value='"+key+"'");
				if(userGroupViewsList.contains(key)){
					strb.append(" checked />"+key);
				}else{
					strb.append(" />"+key);
				}
				
				while(true){
					Map<String,String> subMap=viewsMap.get(key);
					if(subMap==null){
						break;
					}
					strb.append(frameLi(viewsMap, subMap,userGroupViewsList));
					break;
				}
				strb.append("</li>");
			}
			strb.append("</ul>");
//			System.out.println(strb.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return strb.toString();
	}

}
