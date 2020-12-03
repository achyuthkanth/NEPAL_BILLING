package com.analogics.um.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author achyuth kanth pamuru
 *
 */
@Controller
public class ApplicationMasterController {
	
	
	@RequestMapping("/applicationMaster")
	public ModelAndView applicationMasterCall(){
		ModelAndView view=null;
		
		try{
			System.out.println("applicationMaster");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			view=new ModelAndView("ApplicationMaster/applicationMaster");
		}
		
		return view;
	}

}
