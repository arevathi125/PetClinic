package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.pojo.DoctorClinic;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Pet;
import com.example.demo.service.DoctorClinicService;
import com.example.demo.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorClinicService service;
	
	@Autowired
	OwnerService ownerService;
	
	Logger log = Logger.getAnonymousLogger();
	
	@RequestMapping("/insertDoctor")
	public ModelAndView insertOpr(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	DoctorClinic doctor = new DoctorClinic();
	doctor.setDoctorName(request.getParameter("doctorName"));
	doctor.setAvailabilityStatus(request.getParameter("availability"));
	doctor.setCost(request.getParameter("cost"));
	//doctor.setOwnerId(request.getParameter("ownerId"));
	
	log.info("welcome to clinic page ");
	if(service.insert(doctor)!=null) {
	mv.setViewName("display1.jsp");
	}
		return mv;
	}
	
	@RequestMapping("/getAllDoctor")
	public ModelAndView getallOpr(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	
	List<DoctorClinic> list = service.getAll();
	log.info("Display1 page");
	//mv.setViewName("ownerList");
	mv.setViewName("doctorList.jsp");
	mv.addObject("list", list);
		return mv;	
	}
	
	@RequestMapping("/displayBookingDetails")
	public ModelAndView displayAllOpr(HttpServletRequest request,HttpServletResponse response) {
    service.updateOwnerId(Integer.parseInt(request.getParameter("doctorId")),
    		Integer.parseInt(request.getParameter("ownerId")));	
    Optional<Owner> ownerDetl = ownerService.getById(Integer.parseInt(request.getParameter("ownerId")));
    
    List<Pet> pets = ownerService.getPets(Integer.parseInt(request.getParameter("ownerId")));
    //ownerDetl.ge
	ModelAndView mv = new ModelAndView();
	List<DoctorClinic> list = service.getBookingDetails(Integer.parseInt(request.getParameter("doctorId")));
	if(pets.size()>0) {
		list.get(0).setPetName(pets.get(0).getPet_name());
		list.get(0).setOwnerName(ownerDetl.get().getOwner_name());
	}
	System.out.println("list"+list);
	mv.setViewName("BookingList.jsp");
	mv.addObject("BookingList", list);
	return mv;
	}
	
//	@PostMapping("/insertDoctor")
//	public String register(@RequestBody DoctorClinic doctorClinic) {
//		DoctorClinic obj = service.insert(doctorClinic);
//		if (obj != null) {
//		return "Hey your DoctorClinic booking done successfully";
//		}
//		else {
//			return "Hey check your credentials"; 
//		}
//	}
//	
//	@GetMapping("/getAllDoctors")
//	public List<DoctorClinic> getAll(){
//		return service.getAll();
//	}
//	
//	@GetMapping("/getDoctorById/{id}")
//	public Optional<DoctorClinic> getById(@PathVariable int id) {
//		return service.getById(id);
//	}
//	
//	@DeleteMapping("/deleteDoctor/{id}")
//	public List<DoctorClinic> deleteById(@PathVariable int id) {
//		service.delete(id);
//		return service.getAll();
//	}
//	
//	@PutMapping("/updateDoctor/{id}")
//	public List<DoctorClinic> updateDoctor(@RequestBody DoctorClinic doctorClinic,@PathVariable int id){
//		doctorClinic.setDoctorId(id);
//		service.update(doctorClinic);
//		return service.getAll();
//	}

}
