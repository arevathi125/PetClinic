package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojo.DoctorClinic;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Pet;
import com.example.demo.repo.ownerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

	@Autowired
	  ownerRepo repo;
	  
	  //insert
	  public Owner insert(Owner Owner) {
		  return repo.save(Owner);
	  }
	  
	  //getAll
	  public List<Owner> getAll(){
		  return repo.findAll();
	  }
	  
	  //getById
	  public Optional<Owner> getById(int id) {
		  return repo.findById(id);
	  }
	  
	  //delete
	  public String delete(int id) {
		   repo.deleteById(id);
		  return "Deleted id of "+id;
	  }
	  
	  //update
	  public Owner update(Owner owner) {
		  Owner newOwner = repo.findById(owner.getId()).orElse(null);
		  newOwner.setOwner_name(owner.getOwner_name());
		  return repo.save(newOwner);
	  }
	  
	  //get booking details
	  public List<Pet> getPets(int ownerId){
		  List<Pet> pets = repo.getPets(ownerId);
		  return pets;
		   
	  }

}
