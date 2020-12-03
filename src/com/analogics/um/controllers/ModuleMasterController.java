package com.analogics.um.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.analogics.um.dao.CommonDAO;
import com.analogics.um.dao.ModulesDao;
import com.analogics.um.vo.ModuleMaster;
import com.analogics.um.vo.ServerDataTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ModuleMasterController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@RequestMapping("/moduleMasterDetails")
	public ModelAndView moduleMasterDetails(@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModelAndView model =null;
		try {
			model =new ModelAndView("ModuleDetails/AddOrViewModuleMaster",
					"command", masterObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/saveModuleMasterDetails")
	public ModelAndView saveModuleMasterDetails(
			@ModelAttribute("masterObj") ModuleMaster masterObj) {
		ModelAndView model = null;
		boolean isSaved = false;
		try {
			CommonDAO daoObj = new CommonDAO();
			isSaved = daoObj.saveOrUpdate(masterObj);
			if (isSaved == true) {
				model = new ModelAndView("redirect:/moduleMasterDetails");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fetchModuleMasterDetails", method = RequestMethod.GET)
	public @ResponseBody
	String fetchModuleMasterDetails(HttpServletRequest request,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("sSearch") String searchParameter,
			@RequestParam("sSortDir_0") String sorting,
			@RequestParam("iSortCol_0") String sCol,
			@RequestParam("iColumns") String iColumns,
			@RequestParam("iDisplayLength") String pageDisplayLength,
			@ModelAttribute("masterObj") ModuleMaster masterObj)
			throws IOException {
		String json = null;
		Long count = 0l;
		List<ModuleMaster> modulesList = new ArrayList<ModuleMaster>();
		ModulesDao masterDaoObj = new ModulesDao();
		try {
			int col = 0;
			if (sCol != null) {
				col = Integer.parseInt(sCol);
				if (col < 0 || col > 5)
					col = 0;
			}
			String[] cols = { "","moduleTypeName", "moduleTypeCode", "moduleDescription"};
			String colName = cols[col];

			int pageNumber = 0;
			pageNumber = Integer.parseInt(iDisplayStart);
			@SuppressWarnings("rawtypes")
			ServerDataTable dataTable = new ServerDataTable();
			try {
				modulesList = masterDaoObj.fetchModuleMasterList(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting, colName,masterObj);
				count = masterDaoObj.fetchModuleMasterCount(pageNumber,
						Integer.parseInt(pageDisplayLength), searchParameter,
						sorting, colName,masterObj);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dataTable.setiTotalRecords(count.intValue());
			dataTable.setiTotalDisplayRecords(count.intValue());
			dataTable.setAaData(modulesList);
			json = gson.toJson(dataTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
}
