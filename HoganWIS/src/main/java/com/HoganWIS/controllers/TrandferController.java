package com.HoganWIS.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.service.LocateService;

@Controller
public class TrandferController {
	@Autowired
	private LocateService locateservice;
	
	
	
	@GetMapping("/transfer")
	public String getLocate(Model model, String locationcode, String code, String quantity, String destination) {
		
		List<Locate> locatelist = locateservice.getLocate();
		if(locationcode == ""||code == ""||locationcode == null||code == null||quantity == ""||quantity == null||destination == ""||destination == null) {
		}
		else {
			Long idofstart = locateservice.findID(locationcode, code);
			Long idofdes = locateservice.findID(destination, code);
			locateservice.transferaction(idofstart, idofdes, quantity, destination, code);
		}
		return "transfer";
	}
}
