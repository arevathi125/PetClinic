package com.example.demo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



import lombok.Data;

@Entity
@Data
public class DoctorClinic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String availabilityStatus;
	private String cost;
	private int ownerId;
	private String petName;
	private String ownerName;
	private String BookingStatus;

}
