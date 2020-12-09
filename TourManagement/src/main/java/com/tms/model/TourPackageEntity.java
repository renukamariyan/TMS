package com.tms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tour_Pack")
public class TourPackageEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int packageId;
	@Column(name = "package_name")
	private String packageName;
	@Column
	private String description;
	@Column(name = "days_count")
	private int daysCount;
	@Column(name = "nights_count")
	private int nightsCount;
	@Column(name = "packageType")
	private String packageType;
	@Column(name = "Hotel_Name")
	private String hotelName;
	@Column(name = "TripPrice")
	private double Trip_Price;

	public TourPackageEntity() {
	}

	public TourPackageEntity(String packageName, String description, int daysCount, int nightsCount, String packageType,
			String hotelName, double trip_Price) {
		super();

		this.packageName = packageName;
		this.description = description;
		this.daysCount = daysCount;
		this.nightsCount = nightsCount;
		this.packageType = packageType;
		this.hotelName = hotelName;
		this.Trip_Price = trip_Price;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}

	public int getNightsCount() {
		return nightsCount;
	}

	public void setNightsCount(int nightsCount) {
		this.nightsCount = nightsCount;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getTrip_Price() {
		return Trip_Price;
	}

	public void setTrip_Price(double trip_Price) {
		Trip_Price = trip_Price;
	}

	@Override
	public String toString() {
		return "packageId=" + packageId + "\n packageName=" + packageName + "\n description=" + description
				+ "\n daysCount=" + daysCount + "\n nightsCount=" + nightsCount + "\n packageType=" + packageType
				+ "\n hotelName=" + hotelName + "\n Trip_Price=" + Trip_Price;
	}

}
