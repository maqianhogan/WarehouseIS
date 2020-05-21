package com.HoganWIS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HoganWIS.entities.Locate;

@Repository
public interface LocateRepository extends JpaRepository<Locate, Long>{
	
	//@Query(value="select * from Locate c where c.code = %:code%", nativeQuery=true)
	//List<Locate> code(@Param("code")String code);
	
	//@Query(value="select * from Locate u where u.Loc = %:locationcode%", nativeQuery=true)
	List<Locate> findByLoc(@Param("locationcode")String Loc);
	List<Locate> findByCode(@Param("code")String code);
	
	@Query(value="select * from Locate e where e.code like %:keyword%", nativeQuery=true)
	List<Locate> findByKeyword(@Param("keyword") String keyword);
	
}
