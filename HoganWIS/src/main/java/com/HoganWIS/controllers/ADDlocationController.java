package com.HoganWIS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.service.LocateService;

@Controller
public class ADDlocationController {
	
	@Autowired
	private LocateService locateser;
	
	
	
	@GetMapping("/importlocationcsv")
	public String importlocsv(ModelMap model) {
		model.put("location", new Locate());
		return"importlocationcsv";
	}
	
	@PostMapping("/importlocationcsv")
	public String importloccsvdata(@ModelAttribute Locate locate) {
		locateser.saveLocatData();
		return "redirect:/importlocationcsv";
	}
	
}
