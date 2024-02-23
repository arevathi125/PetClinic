package com.example.demo.repo;

import java.util.List;

import com.example.demo.pojo.DoctorClinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface doctorRepo extends JpaRepository<DoctorClinic, Integer>{
	
//	String query1 = "select p.pet_name,o.owner_name,d.doctor_name from pet p join owner o join doctor_clinic d "
//			+ "	where d.doctorId=?1";
	
//	String query1 = "select sct.name from Student s join s.courses sc join sc.teachers sct where s.name=?1";
//	  
	///String query1 = "select p.pet_name,o.owner_name,d.doctor_name from owner o join o.pets join doctorClinic d "
			//+ "	where d.doctorId=?1";
	
//	String query1 = "select p.pet_name,o.owner_name,d.doctorName from DoctorClinic d join d.owners o join o.pets p"
//	+ "	where d.doctorId=?1";
	
	String query1 = "select * from doctor_clinic d where d.doctor_Id=?1";
	
	//@Query(query1)
	@Query(nativeQuery = true,value =query1 )
	public List<DoctorClinic> getBookingDetails(int doctorId);


}
