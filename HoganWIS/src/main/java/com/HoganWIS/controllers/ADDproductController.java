package com.HoganWIS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HoganWIS.entities.Product;
import com.HoganWIS.service.ProductService;

@Controller
public class ADDproductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/importproductcsv")
	public String importcsv(ModelMap model) {
		model.put("product", new Product());
		return "importproductcsv";
	}
	
	@PostMapping("/importproductcsv")
	public String importcsvdata(@ModelAttribute Product product) {
		productService.saveProductData();
		return "redirect:/importproductcsv";
	}
}
