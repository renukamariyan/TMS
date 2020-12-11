package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tms.model.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	@Query("SELECT CASE WHEN (customer.userId = :Id AND customer.userPassword = :pwd) THEN true ELSE false END FROM CustomerEntity customer")
	boolean validateCustomer(@Param("Id") int userId,@Param("pwd") String userPassword);
	

}
