package com.example.demo.repo;

import java.util.List;

import com.example.demo.pojo.DoctorClinic;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ownerRepo extends JpaRepository<Owner, Integer>{

String query1 = "select pets from Owner o where o.id=?1";
	
	@Query(query1)
	//@Query(nativeQuery = true,value =query1 )
	public List<Pet> getPets(int ownerId);
}
