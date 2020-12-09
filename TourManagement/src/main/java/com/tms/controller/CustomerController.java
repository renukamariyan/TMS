package com.tms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.exception.CustomerNotFoundException;
import com.tms.model.CustomerEntity;
import com.tms.model.IssueEntity;
import com.tms.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerservice;

	@GetMapping("")
	public List<CustomerEntity> findAll() {
		return customerservice.displayAllCustomer();
	}

	@PostMapping("")
	public CustomerEntity insertCustomer(@RequestBody CustomerEntity customer) {
		CustomerEntity insert = customerservice.insertCustomer(customer);
		return insert;
	}

	/*
	 * @PostMapping("") public ResponseEntity<CustomerEntity>
	 * insertCustomer(@Valid @RequestBody CustomerEntity customerentity, Errors
	 * errors) throws CustomerNotFoundException {
	 * 
	 * if (errors.hasErrors()) { // Extract ConstraintViolation list from body
	 * errors List<ConstraintViolation<?>> violationsList = new ArrayList<>(); for
	 * (ObjectError e : errors.getAllErrors()) {
	 * violationsList.add(e.unwrap(ConstraintViolation.class)); }
	 * 
	 * String exceptionMessage = "";
	 * 
	 * // Construct a helpful message for each input violation for
	 * (ConstraintViolation<?> violation : violationsList) { exceptionMessage +=
	 * violation.getMessage() + ". "; } throw new
	 * CustomerNotFoundException(exceptionMessage); }
	 * 
	 * return new
	 * ResponseEntity<CustomerEntity>(customerservice.insertCustomer(customerentity)
	 * , HttpStatus.CREATED);
	 * 
	 * }
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable int userId) throws CustomerNotFoundException {
		CustomerEntity customer = customerservice.getCustomerById(userId).orElseThrow(
				() -> new CustomerNotFoundException("Sorry! No customer Found with the given ID " + userId));
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping("/{userId}/{userPassword}")
	public ResponseEntity<String> validateCustomer(@PathVariable("userId") int userId,
			@PathVariable("userPassword") String userPassword) {
		boolean status = customerservice.validateCustomer(userId, userPassword);
		if (status)
			return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Log in attempt failed", HttpStatus.BAD_REQUEST);

	}

	/*
	 * @GetMapping("/{userId}") public ResponseEntity<Customer> find(@PathVariable
	 * int userId){ Optional<Customer> custoptional
	 * =customerservice.getCustomerById(userId); return new
	 * ResponseEntity<Customer>(custoptional.get(), HttpStatus.OK); }
	 */
}
