package com.tms.service;

import java.util.List;
import java.util.Optional;

import com.tms.model.PaymentDetailEntity;
import com.tms.model.TourInfoEntity;
import com.tms.exception.IdNotFoundException;
import com.tms.exception.InvalidInputDataException;

public interface PaymentDetailService {
	List<PaymentDetailEntity> getAllPaymentDetails();
	Optional< PaymentDetailEntity >getPaymentDetail(int id);
	 public PaymentDetailEntity savePayment(PaymentDetailEntity pay) ;
	 public PaymentDetailEntity editPayment(PaymentDetailEntity pay)throws IdNotFoundException;
	 public String deletePayment(int id)throws IdNotFoundException;
	 //String deletePayment(PaymentDetailEntity payment);
	 public boolean validateCreditCard(PaymentDetailEntity payment) throws InvalidInputDataException ;
	 public boolean validateChequeNumber(PaymentDetailEntity payment) throws InvalidInputDataException ; 
	
}
