package com.mindtree.hotelApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mindtree.hotelApp.model.CartView;

/**
* Generated by Spring Data Generator on 22/09/2021
*/
@Repository
public interface CartViewRepository extends JpaRepository<CartView, Integer> {
	
	List<CartView> findByUserId(int userId);

}
