package com.tms.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tour_Info")
public class TourInfoEntity implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tourId;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="package_id")
	private TourPackageEntity packageId;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
	private CustomerEntity userId;
	@Column(name="no_of_passenger")
	private int noOfPassenger;
	@Column(name="total_Cost")
	private double totalCost;
	@Column(name="mode_of_payment")
	private String modeOfPayment;
	@Column(name="payment_status")
	private boolean paymentStatus;
	@Column(name="resevation_status")
	private boolean reservationStatus;

	public TourInfoEntity() {
	}
	

	public TourInfoEntity(int tourId, TourPackageEntity packageId, CustomerEntity userId, int noOfPassenger, String modeOfPayment) {
		super();
		this.packageId = packageId;
		this.userId = userId;
		this.noOfPassenger = noOfPassenger;
		this.totalCost = packageId.getTrip_Price()*noOfPassenger;
		this.modeOfPayment = modeOfPayment;
		this.paymentStatus =false;
		this.reservationStatus =false;
	}


	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public TourPackageEntity getPackageId() {
		return packageId;
	}


	public void setPackageId(TourPackageEntity packageId) {
		this.packageId = packageId;
	}


	

	public CustomerEntity getUserId() {
		return userId;
	}


	public void setUserId(CustomerEntity userId) {
		this.userId = userId;
	}


	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost() {
		this.totalCost = this.noOfPassenger* this.packageId.getTrip_Price();
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public boolean getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
