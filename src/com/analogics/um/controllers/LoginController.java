package com.analogics.um.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.HierarchyLevelsDao;
import com.analogics.um.dao.UserLoginDao;
import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.BioUserDetails;
import com.analogics.um.vo.LevelIndexMaster;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.utils.EncAndDecLogic;


@Controller
public class LoginController {
	HierarchyLevelsDao daoObj = new HierarchyLevelsDao();
	UserLoginDao loginDaoObj = new UserLoginDao();
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userid")String userid,
			@RequestParam("userpassword")String userpassword,HttpServletRequest request){
		
		UserLoginDetails sessionObj=new UserLoginDetails();
		BioUserDetails userObj=new BioUserDetails();
		
		
		ModelAndView model = new ModelAndView("common/error");
		String response="error";
		try {
			HttpSession session=request.getSession();
			userObj=loginDaoObj.fetchBioUserDetails(userid);
			if(userObj!=null){
				if(userObj.getUserpassword().equalsIgnoreCase(new EncAndDecLogic().encrypt(userpassword))){
					sessionObj.setBiouserdetails(userObj);
					sessionObj.setLevelIndexMasterObj(loginDaoObj.fetchLevelIndexMaster(userObj.getIndexid()));
					sessionObj.setAppLevelIndexMasterObj(loginDaoObj.appLevelIndexMasterDetails(userObj.getIndexid()));
					sessionObj.setEnabledActionsList(loginDaoObj.fetchEnabledActionsList(userObj.getUsergroupid(),userObj.getUserid()));
					sessionObj.setEnabledViewsList(loginDaoObj.fetchEnabledViewsList(userObj.getUsergroupid(),userObj.getUserid()));
					sessionObj.setExpiredActionsList(loginDaoObj.fetchExpiredActionsList(userObj.getUsergroupid(),userObj.getUserid()));
				}
				
				 if (!sessionObj.getBiouserdetails().getApplicationuniqueid().equalsIgnoreCase("-1")) {
					 ApplicationMaster appMasterObj=loginDaoObj.fetchApplicationDetails(userObj.getApplicationuniqueid());
					 if(appMasterObj==null){
							response ="error";
							sessionObj.setStatusOfOpr("APPLICATION DETAILS MISMATCH");
						}else{
							sessionObj.setApplicationMasterObj(appMasterObj);
							response="success";
						}
				 }else {
	                   response ="success";
				}
				 if(userObj.getUserid().equalsIgnoreCase("superuser")){
						response="superuser";
						ApplicationMaster applicationObj=new ApplicationMaster();
						applicationObj.setOrghierarchylevel(15);
						sessionObj.setApplicationMasterObj(applicationObj);
						sessionObj.getApplicationMasterObj().setOrghierarchylevel(15);
					}
				 sessionObj=frameLevelMapsData(sessionObj);	
//				 sessionObj=frameAppLevelMapsData(sessionObj);
				 session.setAttribute("sessionObj",sessionObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(response.equalsIgnoreCase("superuser")){
			model=new ModelAndView("common/homepage");
			
		}else if(response.equalsIgnoreCase("success")){
			model=new ModelAndView("common/appHomepage");
		}
		return model;
	}
	
	
	
	
	





	private UserLoginDetails frameLevelMapsData(UserLoginDetails sessionObj) {
		LevelIndexMaster levelindexobj = sessionObj.getLevelIndexMasterObj();
		try {
			sessionObj.setLevel1Map(daoObj.levelsDataMap("1", levelindexobj.getId().getLevel1id()+"",""));
			if (levelindexobj.getId().getLevel1id()!=-1) {
				sessionObj.setLevel2Map(daoObj.levelsDataMap("2",levelindexobj.getId().getLevel2id()+"",levelindexobj.getId().getLevel1id()+""));
				 if(levelindexobj.getId().getLevel2id()!=-1){
					 sessionObj.setLevel3Map(daoObj.levelsDataMap("3",levelindexobj.getId().getLevel3id()+"",levelindexobj.getId().getLevel2id()+""));
					 
					 if(levelindexobj.getId().getLevel3id()!=-1){
						 sessionObj.setLevel4Map(daoObj.levelsDataMap("4",levelindexobj.getId().getLevel4id()+"",levelindexobj.getId().getLevel3id()+""));
						 if(levelindexobj.getId().getLevel4id()!=-1){
							 sessionObj.setLevel5Map(daoObj.levelsDataMap("5",levelindexobj.getId().getLevel5id()+"",levelindexobj.getId().getLevel4id()+""));
							 if(levelindexobj.getId().getLevel5id()!=-1){
								 sessionObj.setLevel6Map(daoObj.levelsDataMap("6",levelindexobj.getId().getLevel6id()+"",levelindexobj.getId().getLevel5id()+""));
								 if(levelindexobj.getId().getLevel6id()!=-1){
									 sessionObj.setLevel7Map(daoObj.levelsDataMap("7",levelindexobj.getId().getLevel7id()+"",levelindexobj.getId().getLevel6id()+""));
									 if(levelindexobj.getId().getLevel7id()!=-1){
										 sessionObj.setLevel8Map(daoObj.levelsDataMap("8",levelindexobj.getId().getLevel8id()+"",levelindexobj.getId().getLevel7id()+""));
										 if(levelindexobj.getId().getLevel8id()!=-1){
											 sessionObj.setLevel9Map(daoObj.levelsDataMap("9",levelindexobj.getId().getLevel9id()+"",levelindexobj.getId().getLevel8id()+""));
											 
											 if(levelindexobj.getId().getLevel9id()!=-1){
												 
												 sessionObj.setLevel10Map(daoObj.levelsDataMap("10",levelindexobj.getId().getLevel10id()+"",levelindexobj.getId().getLevel9id()+""));
												 
												 if(levelindexobj.getId().getLevel10id()!=-1){
													 sessionObj.setLevel11Map(daoObj.levelsDataMap("11",levelindexobj.getId().getLevel11id()+"",levelindexobj.getId().getLevel10id()+""));
													 
													 if(levelindexobj.getId().getLevel11id()!=-1){
														 sessionObj.setLevel12Map(daoObj.levelsDataMap("12",levelindexobj.getId().getLevel12id()+"",levelindexobj.getId().getLevel11id()+""));
														 if(levelindexobj.getId().getLevel12id()!=-1){
															 sessionObj.setLevel13Map(daoObj.levelsDataMap("13",levelindexobj.getId().getLevel13id()+"",levelindexobj.getId().getLevel12id()+""));
															 if(levelindexobj.getId().getLevel13id()!=-1){
																 sessionObj.setLevel14Map(daoObj.levelsDataMap("14",levelindexobj.getId().getLevel14id()+"",levelindexobj.getId().getLevel13id()+""));
																 if(levelindexobj.getId().getLevel14id()!=-1){
																	 sessionObj.setLevel15Map(daoObj.levelsDataMap("15",levelindexobj.getId().getLevel15id()+"",levelindexobj.getId().getLevel14id()+""));
																	 
																 }  
															 }  
														 } 
													 }
												 }
												 
											 }
											 
										 }
									 }
								 }
							 }
							 
						 }
					 }
				 }
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionObj;
	}

	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request)
	{
		ModelAndView model =null;
		String response="error";
		try {
			HttpSession session=request.getSession();
			session.removeAttribute("sessionObj");
			if (session != null) {
			    session.invalidate();
			    response ="success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(response == "success"){
			model= new ModelAndView("common/login");
		}
		return model;
	}



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sampleCall(HttpServletRequest request ,HttpServletResponse response) {
		ModelAndView model = new ModelAndView("common/error");
		try {
			
			
			
			
			System.out.println("in login");
			model=new ModelAndView("common/homepage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}