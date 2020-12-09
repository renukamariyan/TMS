package com.tms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tms.exception.RecordNotFoundException;
import com.tms.model.CustomerEntity;
import com.tms.model.IssueEntity;
import com.tms.model.TourInfoEntity;
import com.tms.model.TourPackageEntity;
import com.tms.repository.TourInfoRepository;
import com.tms.service.TourInfoService;
import com.tms.service.TourInfoServiceImpl;

@SpringBootTest
public class TourInfoServiceTest {

	@Autowired
	private TourInfoService service;

	@MockBean
	private TourInfoRepository repository;

	@Test
	public void testPostExample() {
		CustomerEntity customer = new CustomerEntity();
		customer.setUserId(12);
		customer.setName("Percy");
		customer.setAge(19);
		customer.setEmailId("annabeth@camprock");
		customer.setPassword("jjjj");
		customer.setPhoneNo(12234455);
		TourPackageEntity pack = new TourPackageEntity();
		pack.setPackageId(2);
		pack.setPackageName("Kerala");
		pack.setPackageType("Gold");
		pack.setTrip_Price(12299);
		pack.setDescription("good");
		pack.setDaysCount(3);
		pack.setNightsCount(4);
		pack.setHotelName("ABC");
		TourInfoEntity tour = new TourInfoEntity();
		tour.setUserId(customer);
		tour.setPackageId(pack);
		tour.setNoOfPassenger(3);
		tour.setModeOfPayment("cash");

		Mockito.when(repository.save(tour)).thenReturn(tour);
		assertThat(service.confirmTour(tour)).isEqualTo(tour);
	}

	@Test
	public void testDisplayAllIssue() {
		CustomerEntity customer = new CustomerEntity();
		customer.setUserId(12);
		customer.setName("Percy");
		customer.setAge(19);
		customer.setEmailId("annabeth@camprock");
		customer.setPassword("jjjj");
		customer.setPhoneNo(12234455);
		TourPackageEntity pack = new TourPackageEntity();
		pack.setPackageId(2);
		pack.setPackageName("Kerala");
		pack.setPackageType("Gold");
		pack.setTrip_Price(12299);
		pack.setDescription("good");
		pack.setDaysCount(3);
		pack.setNightsCount(4);
		pack.setHotelName("ABC");
		TourInfoEntity tour = new TourInfoEntity();
		tour.setUserId(customer);
		tour.setPackageId(pack);
		tour.setNoOfPassenger(3);
		tour.setModeOfPayment("cash");

		CustomerEntity customer1 = new CustomerEntity();
		customer1.setUserId(12);
		customer1.setName("Percy");
		customer1.setAge(19);
		customer1.setEmailId("annabeth@camprock");
		customer1.setPassword("jjjj");
		customer1.setPhoneNo(12234455);
		TourPackageEntity pack1 = new TourPackageEntity();
		pack1.setPackageId(2);
		pack1.setPackageName("Kerala");
		pack1.setPackageType("Gold");
		pack1.setTrip_Price(12299);
		pack1.setDescription("good");
		pack1.setDaysCount(3);
		pack1.setNightsCount(4);
		pack1.setHotelName("ABC");
		TourInfoEntity tour1 = new TourInfoEntity();
		tour1.setUserId(customer);
		tour1.setPackageId(pack);
		tour1.setNoOfPassenger(3);
		tour1.setModeOfPayment("cash");

		List<TourInfoEntity> TourList = new ArrayList<>();
		TourList.add(tour);
		TourList.add(tour1);

		Mockito.when(repository.findAll()).thenReturn(TourList);
		assertThat(service.displayAllTourInfo()).isEqualTo(TourList);

	}

	@Test
	public void testPutExample() throws Exception {
		CustomerEntity customer = new CustomerEntity();
		customer.setUserId(12);
		customer.setName("Percy");
		customer.setAge(19);
		customer.setEmailId("annabeth@camprock");
		customer.setPassword("jjjj");
		customer.setPhoneNo(12234455);
		TourPackageEntity pack = new TourPackageEntity();
		pack.setPackageId(2);
		pack.setPackageName("Kerala");
		pack.setPackageType("Gold");
		pack.setTrip_Price(12299);
		pack.setDescription("good");
		pack.setDaysCount(3);
		pack.setNightsCount(4);
		pack.setHotelName("ABC");
		TourInfoEntity tour = new TourInfoEntity();
		tour.setUserId(customer);
		tour.setPackageId(pack);
		tour.setNoOfPassenger(3);
		tour.setModeOfPayment("cash");

		Mockito.when(repository.save(tour)).thenReturn(tour);
		tour.setPaymentStatus(true);
		assertSame(service.updatePaymentStatus(tour), tour);

	}
	/*
	 * @Test public void testRemoveExample() throws Exception{ AbstractUser user=new
	 * Customer(); user.setUsername("Sreeja"); user.setFirstname("yalla");
	 * user.setLastname("satya"); user.setMobileNumber("9090909090");
	 * user.setPassword("yalla890"); user.setEmail("yalla.siri.sai@gmail.com");
	 * Mockito.when(IUserService.removeUser(user)).thenReturn(user);
	 * mockMvc.perform(delete("http://localhost:8080/amusement/user/remove/username"
	 * ).param("username","password")) .andExpect(status().isOk());
	 * 
	 * }
	 * 
	 * @Test public void testValidateExample(String username, String password)
	 * throws Exception{ AbstractUser user=new Customer();
	 * user.setUsername("Sreeja"); user.setFirstname("yalla");
	 * user.setLastname("satya"); user.setMobileNumber("9090909090");
	 * user.setPassword("yalla890"); user.setEmail("yalla.siri.sai@gmail.com");
	 * Mockito.when(IUserService.validateUser(user.getUsername(),
	 * user.getPassword())).thenReturn(user);
	 * mockMvc.perform(get("http://localhost:8080/amusement/user/validate/username")
	 * .param("username","password")) .andExpect(status().isOk());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

}
