package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojo.DoctorClinic;
import com.example.demo.repo.doctorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorClinicService {
	
	@Autowired
	  doctorRepo repo;
	  
	  //insert
	  public DoctorClinic insert(DoctorClinic DoctorClinic) {
		  return repo.save(DoctorClinic);
	  }
	  
	  //getAll
	  public List<DoctorClinic> getAll(){
		  return repo.findAll();
	  }
	  
	  //getById
	  public Optional<DoctorClinic> getById(int id) {
		  return repo.findById(id);
	  }
	  
	  //delete
	  public String delete(int id) {
		  repo.deleteById(id);
		  return "Deleted id of "+id;
	  }
	  
	  //update
	  public DoctorClinic update(DoctorClinic DoctorClinic) {
		  DoctorClinic newDoctorClinic = repo.findById(DoctorClinic.getDoctorId()).orElse(null);
		  newDoctorClinic.setDoctorName(DoctorClinic.getDoctorName());
		  newDoctorClinic.setAvailabilityStatus(DoctorClinic.getAvailabilityStatus());
		  newDoctorClinic.setCost(DoctorClinic.getCost());
		  //newDoctorClinic.setOwnerId(DoctorClinic.getOwnerId());
		  return repo.save(newDoctorClinic);
	  }
	  
	  //update
	  public DoctorClinic updateOwnerId(int doctorId,int ownerId) {
		  DoctorClinic newDoctorClinic = repo.findById(doctorId).orElse(null);
		  newDoctorClinic.setOwnerId(ownerId);
		  return repo.save(newDoctorClinic);
	  }
	  
	  //get booking details
	  public List<DoctorClinic> getBookingDetails(int doctorId){
		  List<DoctorClinic> newDoctorClinic = repo.getBookingDetails(doctorId);
		  
		  return newDoctorClinic;
		   //null;
	  }

}
