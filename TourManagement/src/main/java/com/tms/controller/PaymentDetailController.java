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

	public ResponseEntity<PaymentDetailEntity> add(@Valid @RequestBody PaymentDetailEntity payment, Errors errors)
			throws InvalidInputDataException {
		if (errors.hasErrors()) {
			// Extract ConstraintViolation list from body errors
			List<ConstraintViolation<?>> violationsList = new ArrayList<>();
			for (ObjectError e : errors.getAllErrors()) {
				violationsList.add(e.unwrap(ConstraintViolation.class));
			}

			String exceptionMessage = "";

			// Construct a helpful message for each input violation
			for (ConstraintViolation<?> violation : violationsList) {
				exceptionMessage += violation.getMessage() + ". ";
			}
			throw new InvalidInputDataException(exceptionMessage);
		}

		return new ResponseEntity<PaymentDetailEntity>(paymentservice.savePayment(payment), HttpStatus.CREATED);

	}

	@PutMapping("/updating")
	public ResponseEntity<PaymentDetailEntity> update(@RequestBody PaymentDetailEntity payment, Errors errors)
			throws InvalidInputDataException, IdNotFoundException {
		if (errors.hasErrors()) {
			// Extract ConstraintViolation list from body errors
			List<ConstraintViolation<?>> violationsList = new ArrayList<>();
			for (ObjectError e : errors.getAllErrors()) {
				violationsList.add(e.unwrap(ConstraintViolation.class));
			}

			String exceptionMessage = "";

			// Construct a helpful message for each input violation
			for (ConstraintViolation<?> violation : violationsList) {
				exceptionMessage += violation.getMessage() + ". ";
			}
			throw new InvalidInputDataException(exceptionMessage);
		}
		PaymentDetailEntity op = paymentservice.editPayment(payment);
		return ResponseEntity.ok(op);
	}

	@DeleteMapping("/deleting/{id}")
	public String delete(@PathVariable int id) throws IdNotFoundException {
		return paymentservice.deletePayment(id);

	}

}
