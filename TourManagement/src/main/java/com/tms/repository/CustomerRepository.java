package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.tms.model.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
