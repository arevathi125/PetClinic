package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojo.Pet;
import com.example.demo.repo.petRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	@Autowired
	  petRepo repo;
	  
	  //insert
	  public Pet insert(Pet pet) {
		  return repo.save(pet);
	  }
	  
	  //getAll
	  public List<Pet> getAll(){
		  return repo.findAll();
	  }
	  
	  //getById
	  public Optional<Pet> getById(int id) {
		  return repo.findById(id);
	  }
	  
	  //delete
	  public String delete(int id) {
		  repo.deleteById(id);
		  return "Deleted id of "+id;
	  }
	  
	  //update
	  public Pet update(Pet Pet) {
		  Pet newPet = repo.findById(Pet.getPet_id()).orElse(null);
		  newPet.setPet_name(Pet.getPet_name());
		  newPet.setPet_type(Pet.getPet_type());
		  return repo.save(newPet);
	  }

}
