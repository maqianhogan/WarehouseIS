package com.HoganWIS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.entities.Product;
import com.HoganWIS.service.ProductService;


@Controller
public class DashboardController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootView (Model model) {
		List<Product> productlist = productService.getProduct();
		model.addAttribute("products", productlist);
		return "index";
	}
	
	@GetMapping("/index")
	public String getindex(Model model) {
		List<Product> productlist = productService.getProduct();
		model.addAttribute("products", productlist);
		return "index";
	}
	
	
	
}
