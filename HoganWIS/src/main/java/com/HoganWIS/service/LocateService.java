package com.HoganWIS.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoganWIS.entities.Locate;
import com.HoganWIS.repositories.LocateRepository;

@Service
public class LocateService {
	
	@Autowired
	private LocateRepository locationRepo;
	
	String line="";
	
	public void saveLocatData() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/location.csv"));
			while((line=br.readLine())!=null) {
				String [] data = line.split(",");
				Locate l = new Locate();
				l.setLoc(data[0]);
				l.setCode(data[1]);
				int num = Integer.parseInt(data[2]);
				l.setQuantity(num);
				Long check = findID(data[0],data[1]);
				if(check==null) {
					locationRepo.save(l);
				}
				else {
					locationRepo.deleteById(check);
					locationRepo.save(l);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//return list of the location and products
	public List<Locate> getLocate(){
		return locationRepo.findAll();
	}
	
	//get products by keyword
	public List<Locate> findByKeyword(String keyword){
		return locationRepo.findByKeyword(keyword);
	}
	
	//get product from loc and code
	public List<Locate> findBylocationcode(String locationcode){
		return locationRepo.findByLoc(locationcode);
	}
	
	public List<Locate> findBycode(String code){
		return locationRepo.findByCode(code);
	}
	
	public Long findID(String location, String code) {
		
		List<Locate> thelocation = locationRepo.findByLoc(location);
		List<Locate> thecode = locationRepo.findByCode(code);
		List<Long> liststart = new ArrayList<Long>();
		
		for(int i = 0; i < thelocation.size(); i++) {
			for(int j = 0; j < thecode.size(); j++) {
				if(thelocation.get(i).getCode() == thecode.get(j).getCode()) {
					liststart.add(thelocation.get(i).getId());
				}
			}
		}
		
		if(liststart.size()==0) {
			return null;
		}
		else {
			return liststart.get(0);
		}
	}
	
	
	public void transferaction(Long startid, Long desid, String quantity, String destination, String code) {
		int quan = Integer.parseInt(quantity);
		Locate temp = locationRepo.findById(startid).get();
		if(temp.getQuantity()>=quan) {
			temp.setQuantity(temp.getQuantity()-quan);
			locationRepo.deleteById(startid);
			locationRepo.save(temp);
			if(desid!=null) {
				Locate destemp = locationRepo.findById(desid).get();
				destemp.setQuantity(destemp.getQuantity()+quan);
				locationRepo.deleteById(desid);
				locationRepo.save(destemp);
			}
			else {
				Locate newdestemp = temp;
				newdestemp.setCode(code);
				newdestemp.setLoc(destination);
				newdestemp.setQuantity(quan);
				locationRepo.save(newdestemp);
				
			}
			
			
			
		}
		
	}
	
	
	
	
}
