package com.analogics.um.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.vo.ModuleMaster;


/**
 * 
 * @author achyuth kanth pamuru
 *
 */
public class UserGroupsController {
	
	@RequestMapping("/userGroups")
	public ModelAndView userGroups(@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("ModuleDetails/AddOrViewModuleMaster",
					"command", masterObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
