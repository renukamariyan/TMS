

package com.tms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tms.model.CustomerEntity;
import com.tms.repository.CustomerRepository;
import com.tms.service.CustomerService;

@SpringBootTest
class CustomerServiceImplTest {
	
	@Autowired
	private CustomerService customerservice;
	
	@MockBean
	private CustomerRepository customerrepository;
	
	@Test
	public void testInsertCustomer() {
		CustomerEntity customerentity= new CustomerEntity();
		customerentity.setUserId(105);
		customerentity.setPassword("vijaya12");
		customerentity.setName("vijaya");
		customerentity.setEmailId("vijaya@gmail.com");
		customerentity.setAge(22);
		customerentity.setPhoneNo(6384293029L);
		Mockito.when(customerrepository.save(customerentity)).thenReturn(customerentity);
		assertThat(customerservice.insertCustomer(customerentity)).isEqualTo(customerentity);
	}
	
	@Test
	public void testGetCustomerById() {
		assertThat(customerservice.getCustomerById(1)).isEqualTo(customerrepository.findById(1));
	}
	
	@Test
	public void testdisplayAllCustomer() {
		CustomerEntity customerentity= new CustomerEntity();
		customerentity.setUserId(101);
		customerentity.setPassword("felcy12");
		customerentity.setName("felcy");
		customerentity.setEmailId("felcy@gmail.com");
		customerentity.setAge(20);
		customerentity.setPhoneNo(6381698553L);
		
		CustomerEntity customerentity1= new CustomerEntity();
		customerentity1.setUserId(102);
		customerentity1.setPassword("renu12");
		customerentity1.setName("renu");
		customerentity1.setEmailId("renu@gmail.com");
		customerentity1.setAge(22);
		customerentity1.setPhoneNo(6381345128L);
		
		List<CustomerEntity> customers=new ArrayList<>();
		customers.add(customerentity1);
		customers.add(customerentity);
		
		Mockito.when(customerrepository.findAll()).thenReturn(customers);
		assertThat(customerservice.displayAllCustomer()).isEqualTo(customers);
	}

	@Test
	public void testvalidateCustomer() {
		CustomerEntity customerentity= new CustomerEntity();
		customerentity.setUserId(101);
		customerentity.setPassword("felcy12");
		customerentity.setName("felcy");
		customerentity.setEmailId("felcy@gmail.com");
		customerentity.setAge(20);
		customerentity.setPhoneNo(6381698553L);
		Mockito.when(customerrepository.validateCustomer(customerentity.getUserId(), customerentity.getPassword())).thenReturn(true);
		assertTrue(customerservice.validateCustomer(101,"felcy12"));
	}
}
