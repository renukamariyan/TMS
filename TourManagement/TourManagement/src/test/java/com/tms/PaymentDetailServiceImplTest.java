package com.tms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.model.CustomerEntity;
import com.tms.model.PaymentDetailEntity;
import com.tms.model.TourInfoEntity;
import com.tms.model.TourPackageEntity;
import com.tms.exception.IdNotFoundException;
import com.tms.exception.InvalidInputDataException;
import com.tms.repository.PaymentDetailRepository;
import com.tms.service.PaymentDetailService;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;
@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentDetailServiceImplTest{
@Autowired
private PaymentDetailService paymentDetailService;
@MockBean
private PaymentDetailRepository payrepo;
@Test
public void addpaymentTest() throws ParseException
{
	PaymentDetailEntity payment=new PaymentDetailEntity();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2025-12-25");
	payment.setBankName("axis");
	payment.setCardHolderName("durga");
	payment.setCreditCardNumber("1234567890123456");
	payment.setChequeNumber("789456");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	
	CustomerEntity customer=new CustomerEntity();
	//CustomerService service=new CustomerService(0)
	customer.setName("Percy");
	customer.setAge(19);
	customer.setEmailId("annabeth@camprock");
	customer.setPassword("jjjj");
	customer.setPhoneNo(12234455);
	customer.setUserId(21);
	//int custId=service.insertCustomer(customer);
	TourPackageEntity pack=new TourPackageEntity();
	pack.setPackageName("Kerala");
	pack.setPackageType("Gold");
	pack.setTrip_Price(12299);
	pack.setDescription("good");
	pack.setDaysCount(3);
	pack.setNightsCount(4);
	pack.setHotelName("ABC");
	pack.setPackageId(10);
	TourInfoEntity tour=new TourInfoEntity();
	//TourInfoService tourservice=new TourInfoService();
	//int pid = tourservice.confirmTour(tour);
	tour.setUserId(customer);
	tour.setPackageId(pack);
	tour.setNoOfPassenger(3);
	tour.setModeOfPayment("cash");
	
	Mockito.when(payrepo.save(payment)).thenReturn(payment);
	assertThat(paymentDetailService.savePayment(payment)).isEqualTo(payment);
	}
@Test
public void testAllPaymentDetails() throws ParseException
{
	PaymentDetailEntity payment=new PaymentDetailEntity();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2025-12-25");
	payment.setBankName("axis");
	payment.setCardHolderName("durga");
	payment.setCreditCardNumber("1234567890123456");
	payment.setChequeNumber("789456");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	PaymentDetailEntity payment2=new PaymentDetailEntity();
	//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//Date date=sdf.parse("2025-12-25");
	payment.setBankName("hdfc");
	payment.setCardHolderName("vijaya");
	payment.setCreditCardNumber("7894561237894561");
	payment.setChequeNumber("123456");
	payment.setExpiryDate(date);
	payment.setCvv(4321);
	List<PaymentDetailEntity> paymentList=new ArrayList();
	paymentList.add(payment);
	paymentList.add(payment2);
	Mockito.when(payrepo.findAll()).thenReturn(paymentList);
	assertThat(paymentDetailService.getAllPaymentDetails()).isEqualTo(paymentList);
}
@Test
public void testPaymentDetail() throws ParseException
{
	PaymentDetailEntity payment=new PaymentDetailEntity();
	//CustomerEntity customer=new CustomerEntity();

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2024-12-25");
	payment.setTransaction_id(1);
	payment.setBankName("axis");
	payment.setCardHolderName("durga");
	payment.setCreditCardNumber("1234567890123456");
	payment.setChequeNumber("789456");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	 //payment.setUserId(customer);
	assertThat(paymentDetailService.getPaymentDetail(1)).isEqualTo(payrepo.findById(1));
}
@Test
public void testdeletePaymentDetail() throws ParseException,IdNotFoundException
{
	PaymentDetailEntity payment=new PaymentDetailEntity();
	CustomerEntity customer=new CustomerEntity();

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2024-12-25");
	payment.setTransaction_id(7);
	payment.setBankName("axis");
	payment.setCardHolderName("durga");
	payment.setCreditCardNumber("1234567890123456");
	payment.setChequeNumber("789456");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	 //payment.setUserId(customer)
	String entity=paymentDetailService.deletePayment(7);
	assertSame(entity,"Id Successfully deleted!");
	//assertEquals(entity,"Id Successfully deleted!");
	
	
	//Mockito.when(payrepo.findById(1).get()).thenReturn(payment);
	//Mockito.when(payrepo.existsById(payment.getTransaction_id())).thenReturn(false);
	//assertFalse(payrepo.existsById(payment.getTransaction_id()));
}

@Test
public void testupdatePaymentDetail() throws ParseException,IdNotFoundException
{
	PaymentDetailEntity payment=new PaymentDetailEntity();
	
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2024-12-25");
	
	payment.setBankName("axis");
	payment.setCardHolderName("durga");
	payment.setCreditCardNumber("1234567890123456");
	payment.setChequeNumber("789456");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	payment.setTransaction_id(7);
	CustomerEntity customer=new CustomerEntity();
	//CustomerService service=new CustomerService(0)
	customer.setName("Percy");
	customer.setAge(19);
	customer.setEmailId("annabeth@camprock");
	customer.setPassword("jjjj");
	customer.setPhoneNo(12234455);
	customer.setUserId(21);
	//int custId=service.insertCustomer(customer);
	TourPackageEntity pack=new TourPackageEntity();
	pack.setPackageName("Kerala");
	pack.setPackageType("Gold");
	pack.setTrip_Price(12299);
	pack.setDescription("good");
	pack.setDaysCount(3);
	pack.setNightsCount(4);
	pack.setHotelName("ABC");
	pack.setPackageId(10);
	TourInfoEntity tour=new TourInfoEntity();
	//TourInfoService tourservice=new TourInfoService();
	//int pid = tourservice.confirmTour(tour);
	tour.setUserId(customer);
	tour.setPackageId(pack);
	tour.setNoOfPassenger(3);
	tour.setModeOfPayment("cash");
	
	// payment.setUserId(customer);
	 //Mockito.when(payrepo.findById(7).get()).thenReturn(payment);
	
	//payment.setCardHolderName("vijaya");
	
	 Mockito.when(payrepo.save(payment)).thenReturn(payment);
	 payment.setCardHolderName("vijaya");
	 
	 
	//assertThat(paymentDetailService.editPayment(payment)).isEqualTo(payment);
	 assertSame(paymentDetailService.editPayment(payment),payment);
}
@Test
public void testPaymentStatus() throws InvalidInputDataException, ParseException {
	PaymentDetailEntity payment = new PaymentDetailEntity();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date date=sdf.parse("2025-12-25");

	payment.setBankName("ABC");
	payment.setCreditCardNumber("1234567891127894");
	payment.setChequeNumber("123455");
	payment.setCardHolderName("Smith");
	payment.setExpiryDate(date);
	payment.setCvv(1234);
	boolean Entity2 = paymentDetailService.validateCreditCard(payment);
	boolean Entity3=paymentDetailService.validateChequeNumber(payment);
	assertSame(true, Entity2);
	assertSame(true,Entity3);


}
}
	