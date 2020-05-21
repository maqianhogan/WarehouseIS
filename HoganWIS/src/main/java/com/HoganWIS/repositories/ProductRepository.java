package com.HoganWIS.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.HoganWIS.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	boolean existsBycode(String code);
	
}
