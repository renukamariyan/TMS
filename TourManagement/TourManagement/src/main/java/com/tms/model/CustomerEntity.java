package com.tms.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cust_info")
public class CustomerEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	@Column
	private String userPassword;
	@Column
	private String name;
	@Column
	private String emailId;
	@Column
	private int age;
	@Column
	private long phoneNo;

	public CustomerEntity() {
	}
	


	public CustomerEntity(int userId, String userPassword, String name, String emailId, int age, long phoneNo) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.name = name;
		this.emailId = emailId;
		this.age = age;
		this.phoneNo = phoneNo;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

   public String getPassword() {
		return userPassword;
	}

	public void setPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	@Override
	public String toString() {
		return "CustomerEntity [userId=" + userId + ", userPassword=" + userPassword + ", name=" + name + ", emailId="
				+ emailId + ", age=" + age + ", phoneNo=" + phoneNo + "]";
	}

}
