package com.tms.model;


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
@Table(name = "Issue")
public class IssueEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int issueId;
	@Column(name="issue_Description")
	private String issueDescription;
	@Column(name="issue_Status")
	private String issueStatus;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
	private CustomerEntity userId;
	public IssueEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IssueEntity(int issueId, String issueDescription, String issueStatus, CustomerEntity userId) {
		super();
		this.issueId = issueId;
		this.issueDescription = issueDescription;
		this.issueStatus = issueStatus;
		this.userId = userId;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	public CustomerEntity getUserId() {
		return userId;
	}
	public void setUserId(CustomerEntity userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "IssueEntity [issueId=" + issueId + ", issueDescription=" + issueDescription + ", issueStatus="
				+ issueStatus + ", userId=" + userId + "]";
	}
	
	

}
