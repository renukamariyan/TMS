package com.tms.controller;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.MXBean;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.model.PaymentDetailEntity;
import com.tms.model.TourInfoEntity;
import com.tms.exception.IdNotFoundException;
import com.tms.exception.InvalidInputDataException;
import com.tms.service.PaymentDetailService;

@RestController
@RequestMapping("/payment")
public class PaymentDetailController {
	@Autowired
	PaymentDetailService paymentservice;

	@GetMapping("/readall")
	public List<PaymentDetailEntity> findAll() {
		return paymentservice.getAllPaymentDetails();
	}

	@GetMapping("/readbypayment/{id}")
	public ResponseEntity<PaymentDetailEntity> find(@PathVariable int id) throws IdNotFoundException {
		PaymentDetailEntity details = paymentservice.getPaymentDetail(id)
				.orElseThrow(() -> new IdNotFoundException("Sorry! No Id Found with the given ID " + id));
		return ResponseEntity.ok().body(details);
	}

	@PostMapping("/addpayment")
	public ResponseEntity<PaymentDetailEntity> add(@Valid @RequestBody PaymentDetailEntity payment)
			throws InvalidInputDataException {

		return new ResponseEntity<PaymentDetailEntity>(paymentservice.savePayment(payment), HttpStatus.CREATED);

	}

	@PutMapping("/updating")
	public ResponseEntity<PaymentDetailEntity> update(@RequestBody PaymentDetailEntity payment)
			throws InvalidInputDataException, IdNotFoundException {
		
		PaymentDetailEntity op = paymentservice.editPayment(payment);
		return ResponseEntity.ok(op);
	}

	@DeleteMapping("/deleting/{id}")
	public String delete(@PathVariable int id) throws IdNotFoundException {
		return paymentservice.deletePayment(id);

	}

}
