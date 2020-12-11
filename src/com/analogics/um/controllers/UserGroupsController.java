package com.analogics.um.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.UserGroupDAO;
import com.analogics.um.dao.ViewsMasterDAO;
import com.analogics.um.vo.ModuleDetails;
import com.analogics.um.vo.UserGroup;

@Controller
public class UserGroupsController {
	
	@RequestMapping("/viewUserGroup")
	public ModelAndView viewUserGroup(@ModelAttribute("UserGroup") UserGroup userGroup){
		ModelAndView model=null;
		UserGroupDAO daoObj=new UserGroupDAO();
		ViewsMasterDAO viewDao=new ViewsMasterDAO();
		try {
			List<String> userGroupViewsList=new ArrayList<String>();
			Map<String,String> actionsMap=new HashMap<String, String>();
			
			String viewsCheckBoxStr=viewDao.fetchUlLiString(userGroupViewsList);
			userGroup.setModuleDetails(daoObj.fetchModuleDetailsList());
			userGroup.setUserGroupList(daoObj.fetchUserGroupList());
			
			String moduleActionsStr=frameModuleActions(userGroup.getModuleDetails(),actionsMap);
			model=new ModelAndView("/UserGroup/AddOrViewUserGroup","command",userGroup);
			model.addObject("viewsCheckBoxStr", viewsCheckBoxStr);
			model.addObject("moduleActionsStr", moduleActionsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	private String frameModuleActions(List<ModuleDetails> list,Map<String,String> actionsMap){
		String response="";
		StringBuilder strb=new StringBuilder();
		try{
			String moduleNameOld="";
			String moduleNameNew="";
			
			Integer count=1;
			for(ModuleDetails moduleDetails:list){
				moduleNameNew=moduleDetails.getId().getModuleTypeName();
				
				String actionCheckedStr="";
				String createCheckedStr="";
				String readCheckedStr="";
				String updateCheckedStr="";
				String deleteCheckedStr="";
				
				String permissionStr=actionsMap.get(moduleDetails.getId().getModuleAction());
				if(permissionStr!=null){
					String[] strArr=permissionStr.split("\\|");
					
					actionCheckedStr=" checked='true' ";
					
					if(strArr[0].equalsIgnoreCase("Y")){
						createCheckedStr=" checked='true' ";
					}
					
					if(strArr[1].equalsIgnoreCase("Y")){
						readCheckedStr=" checked='true' ";
					}
					
					if(strArr[2].equalsIgnoreCase("Y")){
						updateCheckedStr=" checked='true' ";
					}
					
					if(strArr[3].equalsIgnoreCase("Y")){
						deleteCheckedStr=" checked='true' ";
					}
				}
				
				if(!moduleNameNew.equalsIgnoreCase(moduleNameOld)){
					count=1;
					if(!moduleNameOld.equalsIgnoreCase("")){
						strb.append("</tbody></table>");
					}
					strb.append("<table cellpadding='0' cellspacing='0' border='0' class='table' >");
					strb.append("<thead><tr><th>S.No</th>");
					strb.append("<th>All<input type='checkbox' class='checkBoxClass mainCheckAll' name='selectAll' value='"+moduleDetails.getId().getModuleTypeName()+"'/></th>");
					strb.append("<th colspan='2'>"+moduleDetails.getId().getModuleTypeName()+"</th>");
					strb.append("<th>Create<input type='checkbox' class='checkBoxClass mainCheckAll' name='createAll' value='"+moduleDetails.getId().getModuleTypeName()+"'/></th>");
					strb.append("<th>Read<input type='checkbox' class='checkBoxClass mainCheckAll' name='readAll' value='"+moduleDetails.getId().getModuleTypeName()+"'/></th>");
					strb.append("<th>Update<input type='checkbox' class='checkBoxClass mainCheckAll' name='updateAll' value='"+moduleDetails.getId().getModuleTypeName()+"'/></th>");
					strb.append("<th>Delete<input type='checkbox' class='checkBoxClass mainCheckAll' name='deleteAll' value='"+moduleDetails.getId().getModuleTypeName()+"'/></th>");
					strb.append("</tr></thead><tbody>");
				}
				moduleNameOld=moduleDetails.getId().getModuleTypeName();

				strb.append("<tr class='"+moduleDetails.getId().getModuleTypeName()+"Class'>");
				strb.append("<td>"+count+"</td>");
				

			
				strb.append("<td><input type='checkbox' class='checkBoxClass actionClass "+moduleDetails.getId().getModuleTypeName()+"' "+actionCheckedStr+" name='moduleEnabledActions' value='"+moduleDetails.getId().getModuleTypeName()+"|"+moduleDetails.getId().getModuleAction()+"'/></td>");
				strb.append("<td>"+moduleDetails.getId().getModuleAction()+"</td>");
				strb.append("<td>"+moduleDetails.getModuledescription()+"</td>");
				strb.append("<td><input type='checkbox' class='checkBoxClass createClass "+moduleDetails.getId().getModuleTypeName()+"' "+createCheckedStr+" name='createflag' value='"+moduleDetails.getId().getModuleAction()+"'/></td>");
				strb.append("<td><input type='checkbox' class='readClass "+moduleDetails.getId().getModuleTypeName()+"' "+readCheckedStr+" name='readflag' value='"+moduleDetails.getId().getModuleAction()+"'/></td>");
				strb.append("<td><input type='checkbox' class='checkBoxClass checkBoxClass updateClass "+moduleDetails.getId().getModuleTypeName()+"' "+updateCheckedStr+" name='updateflag' value='"+moduleDetails.getId().getModuleAction()+"'/></td>");
				strb.append("<td><input type='checkbox' class='checkBoxClass deleteClass "+moduleDetails.getId().getModuleTypeName()+"' "+deleteCheckedStr+" name='deleteflag' value='"+moduleDetails.getId().getModuleAction()+"'/></td>");
				strb.append("</tr>");
				
				count++;
				
			}
			
			strb.append("</tbody></table>");
			
			response=strb.toString();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	@RequestMapping("/saveUserGroup")
	public ModelAndView saveUserGroup(@ModelAttribute("UserGroup") UserGroup userGroup){
		ModelAndView model=new ModelAndView("common/error");
		 boolean isSaved=false;
		try {
			UserGroupDAO daoObj=new UserGroupDAO();
			userGroup.getId().setApplicationuniqueid(-1l);
			isSaved=daoObj.saveGroupDetails(userGroup);
			
			if(isSaved==true){
				userGroup.setResponse("success");
				userGroup.setReasonResponse("Group Updated Successfully");
				model=editUserGroup(userGroup);
			}else{
				
			}
			if (isSaved == true) {
				model = new ModelAndView("redirect:/viewUserGroup");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping("/editUserGroup")
	public ModelAndView editUserGroup(@ModelAttribute("UserGroup") UserGroup userGroup){
		ModelAndView model=null;
		UserGroupDAO daoObj=new UserGroupDAO();
		ViewsMasterDAO viewDao=new ViewsMasterDAO();

		try {
			String groupName=userGroup.getId().getGroupname();
			UserGroup userGroupObj=daoObj.fetchUserGroup(groupName);
			userGroupObj.setResponse(userGroup.getResponse());
			userGroupObj.setReasonResponse(userGroup.getReasonResponse());
			List<String> userGroupViewsList=daoObj.fetchUserGroupViewsList(groupName);
			String viewsCheckBoxStr=viewDao.fetchUlLiString(userGroupViewsList);
			userGroupObj.setModuleDetails(daoObj.fetchModuleDetailsList());
			userGroupObj.setUserGroupList(daoObj.fetchUserGroupList());
			
			Map<String,String> actionsMap= daoObj.fetchUserGroupActionsList(groupName);
			String moduleActionsStr=frameModuleActions(userGroupObj.getModuleDetails(),actionsMap);
			
			model=new ModelAndView("/UserGroup/AddOrViewUserGroup","command",userGroupObj);
			model.addObject("viewsCheckBoxStr", viewsCheckBoxStr);
			model.addObject("moduleActionsStr", moduleActionsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
