package com.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.repository.CustomerRepository;
import com.tms.model.CustomerEntity;
import com.tms.model.IssueEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public Optional<CustomerEntity> getCustomerById(int userId) {
		return customerrepository.findById(userId);
		
	}

	@Override
	public CustomerEntity insertCustomer(CustomerEntity customer) {
		return customerrepository.save(customer);
		
	}
	/*
	 * @Override public Issue raiseIssue(Issue issue, int userId) { return ; }
	 * 
	 * @Override public boolean validateUser(int userId, String password) { return ;
	 * 
	 * }
	 */

	@Override
	public List<CustomerEntity> displayAllCustomer() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

}
