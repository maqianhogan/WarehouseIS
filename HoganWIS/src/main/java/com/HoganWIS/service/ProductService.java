package com.HoganWIS.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.entities.Product;
import com.HoganWIS.repositories.LocateRepository;
import com.HoganWIS.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	String line = "";
	
	public void saveProductData() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/product.csv"));
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				Product p = new Product();
				p.setName(data[0]);
				p.setCode(data[1]);
				p.setWeight(data[2]);
				boolean check = productRepo.existsBycode(data[1]);
				if(check==false) {
				productRepo.save(p);}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getProduct(){
		return productRepo.findAll();
	}
	
	
	
	
}
