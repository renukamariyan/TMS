package com.tms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tms.model.PaymentDetailEntity;
import com.tms.model.TourInfoEntity;
import com.tms.exception.IdNotFoundException;
import com.tms.exception.InvalidInputDataException;
import com.tms.repository.PaymentDetailRepository;


@Service
public  class PaymentDetailServiceImpl implements PaymentDetailService {
	@Autowired
	  private PaymentDetailRepository payrepo;
	@Override
	public List<PaymentDetailEntity> getAllPaymentDetails() {
		List<PaymentDetailEntity> alldetails=payrepo.findAll();
		return alldetails;
		
	}
  @Override
	public Optional<PaymentDetailEntity> getPaymentDetail(int id) {
	Optional<PaymentDetailEntity> detail=payrepo.findById(id);
	return detail;
	}
     @Override
	public PaymentDetailEntity savePayment(PaymentDetailEntity payment) {
		PaymentDetailEntity pay=payrepo.save(payment);
		return pay;
	}

	@Override
	public PaymentDetailEntity editPayment(PaymentDetailEntity payment) throws IdNotFoundException {
		Optional<PaymentDetailEntity> paymentUpdate=payrepo.findById(payment.getTransaction_id());
		if(paymentUpdate!=null)
		{
			return payrepo.save(payment);
		}
		else
		  throw new IdNotFoundException(" Id does not exist");
	}

	@Override
	public String deletePayment(int id) throws IdNotFoundException {
		Optional<PaymentDetailEntity> payment=payrepo.findById(id);
		if(payment!=null) {
		payrepo.deleteById(id);
		return "Id Successfully deleted!";
		}
		else
			throw new IdNotFoundException("Id not found");
	}

	
	public boolean validateCreditCard(PaymentDetailEntity payment) throws InvalidInputDataException {
		Date currentDate=new Date();
		boolean flag=true;
		if(((payment.getCreditCardNumber()).length()!=16) ||(payment.getExpiryDate().compareTo(currentDate)<0))
		{ 
			flag=true;
			throw new InvalidInputDataException("CreditCardNumber should not be empty.please Enter 12 digit number");
		    
		}
		else
		{
			return flag;
		}
	}

	
	public boolean validateChequeNumber(PaymentDetailEntity payment) throws InvalidInputDataException   {
	boolean flag=true;
		if((payment.getChequeNumber()).length()!=6)
	{
			flag=true;
			throw new InvalidInputDataException("CheckNumber should not be empty. Please Enter 12 digit number");
	}
		else
			return flag;
		
	}
	}

	
	

	
	