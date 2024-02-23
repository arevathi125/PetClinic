package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Pet;
import com.example.demo.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class OwnerController {
	
	@Autowired
	OwnerService service;
	
	Logger log=Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView defaultpage(HttpServletRequest request,HttpServletResponse response) {
		log.info("entered into the / request");
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("index.jsp");	
		log.info("went to index.jsp page ");
		return mv;
	}
	
	@RequestMapping("/insertOwner")
	public ModelAndView insertOpr(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	Owner owner = new Owner();
	owner.setOwner_name(request.getParameter("ownerName"));
	Pet petDetl = new Pet();
	petDetl.setPet_name(request.getParameter("petName"));
	petDetl.setPet_type(request.getParameter("petType"));
	List<Pet> list = new ArrayList<Pet>();
	list.add(petDetl);
	owner.setPets(list);		
	
	log.info("welcome to index page ");
	if(service.insert(owner)!=null) {
	mv.setViewName("display.jsp");
	}
		return mv;
	}
	
	
		
	@RequestMapping("/getAll")
	public ModelAndView getallOpr(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	
	List<Owner> list = service.getAll();
	log.info("Display page");
	mv.setViewName("ownerList.jsp");
	mv.addObject("list", list);
		return mv;	
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteOpr(HttpServletRequest request,HttpServletResponse response, @RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		service.delete(id);
		List<Owner> list=service.getAll();
		mv.addObject("list", list);
		log.info("Delete page");
		mv.setViewName("ownerList.jsp");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView updateOpr(HttpServletRequest request,HttpServletResponse response, Owner owner){
		ModelAndView mv = new ModelAndView();
		System.out.println("Updated :"+ owner);
		System.out.println("Updated name:"+ owner.getOwner_name());
		owner.setOwner_name(request.getParameter("ownerName"));
		service.update(owner);
		//mv.setViewName("getAll");
		List<Owner> list = service.getAll();
		mv.addObject("list", list);
		log.info("Update page");
		mv.setViewName("ownerList.jsp");
		return mv;
	}
	
//	@PostMapping("/insertOwner")
//	public String register(@RequestBody Owner owner) {
//		//owner.setPets(null)
//		Owner obj = service.insert(owner);
//		if (obj != null) {
//		return "Hey your Owner booking done successfully";
//		}
//		else {
//			return "Hey check your credentials"; 
//		}
//	}
//	
//	@GetMapping("/getAllOwners")
//	public List<Owner> getAll(){
//		return service.getAll();
//	}
//	
//	@GetMapping("/getOwnerById/{id}")
//	public Optional<Owner> getById(@PathVariable int id) {
//		return service.getById(id);
//	}
//	
//	@DeleteMapping("/deleteOwner/{id}")
//	public List<Owner> deleteById(@PathVariable int id) {
//		service.delete(id);
//		return service.getAll();
//	}
//	
//	@PutMapping("/updateOwner/{id}")
//	public List<Owner> updateOwner(@RequestBody Owner Owner,@PathVariable int id){
//		//Owner.setOwner_id(id);
//		service.update(Owner);
//		return service.getAll();
//	}

}
