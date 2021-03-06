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

import com.tms.exception.IssueNotFoundException;
import com.tms.model.CustomerEntity;
import com.tms.model.IssueEntity;
import com.tms.repository.IssueRepository;
import com.tms.service.IssueService;

@SpringBootTest
class IssueServiceImplTest {
	
	@Autowired
	private IssueService service;
	@MockBean
	private IssueRepository repository;

	@Test
	public void testCreateIssue() {
		IssueEntity issues=new IssueEntity();
		CustomerEntity customer=new CustomerEntity();
		issues.setIssueId(17);
		issues.setIssueDescription("Payment failed");
		issues.setIssueStatus("Unresolved");
		customer.setUserId(28);
		customer.setName("Tom");
		customer.setAge(12);
		customer.setEmailId("Tom@gmail.com");
		customer.setPassword("Tom213");
		
		issues.setUserId(customer);
		Mockito.when(repository.save(issues)).thenReturn(issues);
		assertThat(service.createNewIssue(issues)).isEqualTo(issues);
	}
	@Test
	public void  testDisplayAllIssue() {
		
		IssueEntity issues=new IssueEntity();
		CustomerEntity customer=new CustomerEntity();
		issues.setIssueId(19);
		issues.setIssueDescription("Payment issue");
		issues.setIssueStatus("Unresolved");
		customer.setUserId(9);
		customer.setName("Sam");
		customer.setAge(21);
		customer.setEmailId("Sam@gmail.com");
		customer.setPassword("Sam213");
		issues.setUserId(customer);
		IssueEntity issues1=new IssueEntity();
		CustomerEntity customer1=new CustomerEntity();
		issues1.setIssueId(18);
		issues1.setIssueDescription("Login issue");
		issues1.setIssueStatus("Unresolved");
		customer1.setUserId(29);
		customer1.setName("Tom");
		customer1.setAge(12);
		customer1.setEmailId("Tom@gmail.com");
		customer1.setPassword("Tom213");
		issues1.setUserId(customer1);
		
		List<IssueEntity> issuesList=new ArrayList<>();
		issuesList.add(issues1);
		issuesList.add(issues);
		Mockito.when(repository.findAll()).thenReturn(issuesList);
		assertThat(service.displayAllIssue()).isEqualTo(issuesList);
		
	}
	
   @Test
   public void testDisplayIssueById() {
	   
			IssueEntity issues=new IssueEntity();
			CustomerEntity customer=new CustomerEntity();
			issues.setIssueId(17);
			issues.setIssueDescription("Payment failed");
			issues.setIssueStatus("Unresolved");
			customer.setUserId(28);
			customer.setName("Tom");
			customer.setAge(12);
			customer.setEmailId("Tom@gmail.com");
			customer.setPassword("Tom213");
			issues.setUserId(customer);
		
		    assertThat(service.displayIssueById(18)).isEqualTo(repository.findById(18));
		
   }
   @Test
   public void testUpdateIssue() throws IssueNotFoundException {
	   IssueEntity issues=new IssueEntity();
		CustomerEntity customer=new CustomerEntity();
		issues.setIssueId(17);
		issues.setIssueDescription("Payment failed");
		issues.setIssueStatus("Unresolved");
		customer.setUserId(28);
		customer.setName("Tom");
		customer.setAge(12);
		customer.setEmailId("Tom@gmail.com");
		customer.setPassword("Tom213");
		issues.setUserId(customer);
		
		Mockito.when(repository.save(issues)).thenReturn(issues);
		issues.setIssueStatus("Resolved");
		assertSame(service.updateIssueAsResolved(issues),issues);
	   
	   
   }
	/*
	 * @Test public void testUpdateIssue() throws IssueNotFoundException {
	 * IssueEntity issues=new IssueEntity(); CustomerEntity customer=new
	 * CustomerEntity(); issues.setIssueId(1);
	 * issues.setIssueDescription("Payment failed");
	 * issues.setIssueStatus("Unresolved"); customer.setUserId(9);
	 * issues.setUserId(customer);
	 * Mockito.when(repository.save(issues)).thenReturn(issues); IssueEntity
	 * issueUpdate=repository.findById(issues.getIssueId()).orElse(null);
	 * Mockito.when(repository.save(issues)).thenReturn(issues);
	 * 
	 * 
	 * IssueEntity value=service.updateIssueAsResolved(issueUpdate);
	 * 
	 * assertEquals(issueUpdate.getIssueStatus(),"Resolved");
	 * Mockito.when(repository.findById(17).orElse(null)).thenReturn(issues);
	 * IssueEntity issues1=service.updateIssueAsResolved(issues);
	 * issues.setIssueStatus("Resolved");
	 * Mockito.when(repository.save(issues)).thenReturn(issues);
	 * 
	 * assertThat(issues1.getIssueStatus()).isEqualTo("Resolved");
	 * 
	 * assertThat(issues1.getIssueStatus()).isEqualTo("Resolved");
	 * assertThat(issues.getIssueStatus()).isEqualTo("Resolved");
	 * 
	 * 
	 * }
	 */
	   
   }


