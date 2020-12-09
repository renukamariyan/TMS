package com.tms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "Payment_details")

public class PaymentDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	@OneToOne
    @JoinColumn(name="tour_id")
	private TourInfoEntity tourId;
	@OneToOne
    @JoinColumn(name="user_id")
	private CustomerEntity userId;
	@NotBlank(message="Bank name must not be empty")
	@Column(name="bank_name")
	private String bankName;
	@NotBlank(message="card number must not be empty")
	@Pattern(regexp="[0-9]{16}", message="Account number must contain 16 digits")
	@Column(name="card_number")
	private String creditCardNumber;
	@Pattern(regexp="[0-9]{6}", message="check number must contain 6 digits")
	@Column(name="cheque_number")
	private String chequeNumber;
	@NotBlank(message="card holder number must not be empty")
	@Column(name="card_holder_name")
	private String cardHolderName;
	@NotBlank(message="expiry date must not be empty")
	@Column(name="expiry_date")
	private Date expiryDate;
	@NotBlank(message="cvv number must not be empty")
	@Pattern(regexp="[0-9]{3}", message="cvv must contain 3 digits")
	@Column(name="cvv")
	private int cvv;
    public PaymentDetailEntity(){
		
	}
	
	public PaymentDetailEntity(TourInfoEntity tourId,String bankName, String creditCardNumber,
			String chequeNumber, String cardHolderName, Date expiryDate, int cvv) {
		this.tourId=tourId;
		this.bankName = bankName;
		this.creditCardNumber = creditCardNumber;
		this.chequeNumber = chequeNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}
	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public CustomerEntity getUserId() {
		return userId;
	}

	public void setUserId(CustomerEntity userId) {
		this.userId = userId;
	}
	
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public TourInfoEntity getTourId() {
		return tourId;
	}
	public void setTourId(TourInfoEntity tourId) {
		this.tourId = tourId;
	}

	@Override
	public String toString() {
		return "PaymentDetailEntity [transaction_id=" + transaction_id + ", tourId=" + tourId + ", bankName=" + bankName
				+ ", creditCardNumber=" + creditCardNumber + ", chequeNumber=" + chequeNumber + ", cardHolderName="
				+ cardHolderName + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}

	
	
	
}