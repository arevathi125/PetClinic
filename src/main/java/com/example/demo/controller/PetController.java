package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojo.Pet;
import com.example.demo.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

	@Autowired
	PetService service;
	
	@PostMapping("/insertPet")
	public String register(@RequestBody Pet Pet) {
		Pet obj = service.insert(Pet);
		if (obj != null) {
		return "Hey your Pet booking done successfully";
		}
		else {
			return "Hey check your credentials"; 
		}
	}
	
	@GetMapping("/getAllPets")
	public List<Pet> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getPetById/{id}")
	public Optional<Pet> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/deletePet/{id}")
	public List<Pet> deleteById(@PathVariable int id) {
		service.delete(id);
		return service.getAll();
	}
	
	@PutMapping("/updatePet/{id}")
	public List<Pet> updatePet(@RequestBody Pet Pet,@PathVariable int id){
		Pet.setPet_id(id);
		service.update(Pet);
		return service.getAll();
	}
}
