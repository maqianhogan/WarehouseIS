package com.HoganWIS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.service.LocateService;


@Controller
public class ShowallproductController {
	
	@Autowired
	private LocateService locateservice;
	
	
	
	@GetMapping("/showproducts")
	public String getLocate(Model model, String keyword) {
		
		List<Locate> locatelist = locateservice.getLocate();
		if(keyword != null) {
			model.addAttribute("locates", locateservice.findByKeyword(keyword));
		}
		else {
			model.addAttribute("locates", locatelist);
		}
		return "showproducts";
	}
	
	
	
}
