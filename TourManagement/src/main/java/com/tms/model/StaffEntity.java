package com.tms.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Staff")
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String staffId;
	private String password;
	private String name;
	private String emailId;
	private int age;
	private String gender;
	private String address;
	private long phoneNo;

	public StaffEntity() {
	}

	public StaffEntity(String staffId, String password, String name, String emailId, int age, String gender,
			String address, long phoneNo) {
		super();
		this.password = password;
		this.name = name;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public String getStaffId() {
		return staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", emailId=" + emailId + ", age=" + age + ",  password=" + password
				+ ", gender=" + gender + ", emailId=" + emailId + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}

}