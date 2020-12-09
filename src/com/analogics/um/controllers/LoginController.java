package com.analogics.um.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.UserLoginDao;
import com.analogics.um.vo.ApplicationMaster;
import com.analogics.um.vo.BioUserDetails;
import com.analogics.um.vo.UserLoginDetails;
import com.analogics.utils.EncAndDecLogic;


@Controller
public class LoginController {
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
				
				 if (!sessionObj.getApplicationuniqueid().equalsIgnoreCase("-1")) {
					 ApplicationMaster appMasterObj=loginDaoObj.fetchApplicationDetails(userObj.getApplicationuniqueid());
					 if(appMasterObj==null){
							response ="error";
							sessionObj.setStatusOfOpr("APPLICATION DETAILS MISMATCH");
						}else{
							sessionObj.setApplicationMasterObj(appMasterObj);
							response="success";
						}
				 }
			}
		} catch (Exception e) {
			e.printStackTrace();
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
