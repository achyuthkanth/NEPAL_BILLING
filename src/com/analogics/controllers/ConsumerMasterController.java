package com.analogics.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.dao.ConsumerMasterDao;
import com.analogics.um.vo.ServerDataTable;
import com.analogics.vo.ConsumerMaster;
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
	
	@RequestMapping("/consumerMasterDetails")
	public ModelAndView consumerMasterDetails(@ModelAttribute("masterObj") ConsumerMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("Masters/ConsumerMaster/AddOrViewConsumerDetails",
					"command", masterObj);
			model.addObject("command", fetchConsumerMasterColumsMap(masterObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	private Object fetchConsumerMasterColumsMap(ConsumerMaster masterObj) {
		try {
			Map<String, String> columnsMap = new HashMap<String, String>();
			columnsMap.put("1", "Consumer Id");
			columnsMap.put("2", "Consumer Number");
			columnsMap.put("3", "Consumer Address");
			masterObj.setColumnsMap(columnsMap);
			
			Map<String,String> searchColumnsMap=new HashMap<String,String>();
			searchColumnsMap.put("consumerId", "CONSUMER ID");
			searchColumnsMap.put("consumerNumber", "CONSUMER NUMBER");
			searchColumnsMap.put("consumerAddress", "CONSUMER ADDRESS");
			masterObj.setSearchColumnsMap(searchColumnsMap);
			
			List<String> conditionListStr = new ArrayList<String>();
			conditionListStr.add("EQUAL TO");
			conditionListStr.add("LIKE");
			conditionListStr.add("NOT EQUAL TO");
			masterObj.setConditionListStr(conditionListStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterObj;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchConsumerMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchConsumerMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ConsumerMaster masterObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ConsumerMaster> consumerList = new ArrayList<ConsumerMaster>();
		ConsumerMasterDao masterDaoObj = new ConsumerMasterDao();
		try {
			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				consumerList = masterDaoObj.fetchConsumerMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
				count = masterDaoObj.fetchConsumerMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting,masterObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(consumerList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
