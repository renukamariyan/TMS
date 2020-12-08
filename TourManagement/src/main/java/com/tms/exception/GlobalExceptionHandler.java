package com.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IssueNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(IssueNotFoundException ex){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.NOT_FOUND.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg, HttpStatus.OK);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException ex){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.NOT_FOUND.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg, HttpStatus.OK);
	}
	@ExceptionHandler(TourPackageNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleTourPackageNotFoundException(TourPackageNotFoundException ex){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.NOT_FOUND.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg, HttpStatus.OK);
	}
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleRecordNotFoundException(RecordNotFoundException ex){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.NOT_FOUND.value());
		errMsg.setErrorMessage(ex.getMessage());
		return new ResponseEntity(errMsg, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e) {
		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
