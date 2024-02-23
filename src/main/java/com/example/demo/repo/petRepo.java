package com.example.demo.repo;

import com.example.demo.pojo.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface petRepo extends JpaRepository<Pet, Integer>{

}
