package com.mindtree.hotelApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hotelApp.model.Admin;

/**
* Generated by Spring Data Generator on 22/09/2021
*/
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmailId(String userEmailId);

}
