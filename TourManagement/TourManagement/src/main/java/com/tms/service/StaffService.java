package com.tms.service;

import java.util.List;

import com.tms.model.IssueEntity;
import com.tms.model.StaffEntity;

public interface StaffService {

	
	public List<IssueEntity> displayAllIssue();

	public IssueEntity updateIssueAsResolved(IssueEntity issue);
	
	

	
}