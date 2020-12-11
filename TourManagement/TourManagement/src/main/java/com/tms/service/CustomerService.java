package com.tms.service;
import java.util.List;
import java.util.Optional;

import com.tms.model.CustomerEntity;
public interface CustomerService {
		
		public Optional<CustomerEntity> getCustomerById(int userId);
		
		public CustomerEntity insertCustomer(CustomerEntity customer);
		
		public List<CustomerEntity> displayAllCustomer();
		
		public boolean validateCustomer(int userId, String userPassword);

	}
	
