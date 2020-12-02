package com.analogics.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sampleCall(HttpServletRequest request ,HttpServletResponse response) {
		ModelAndView model =null;
		try {
			System.out.println("in login");
			model=new ModelAndView("common/homepage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
