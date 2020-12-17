package com.analogics.controllers;

import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Sandhya.B
 *
 */
@Controller
public class ConsumerMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

}
