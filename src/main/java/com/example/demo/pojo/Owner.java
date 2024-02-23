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
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String owner_name;
	private String petId;
	//private String pet_type;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="pet_owner_map",
	//present class column or id 
	joinColumns = {@JoinColumn(name="oid",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="pid",referencedColumnName = "pet_id")})
    List<Pet> pets;
}

