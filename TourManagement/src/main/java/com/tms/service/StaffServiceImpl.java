package com.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.IssueEntity;
import com.tms.model.StaffEntity;
import com.tms.repository.IssueRepository;
import com.tms.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	IssueRepository issueRepository;
	@Autowired 
	StaffRepository staffRepository;
	
	@Override
	public List<IssueEntity> displayAllIssue() {
		return issueRepository.findAll();
	}


	@Override
	public IssueEntity updateIssueAsResolved(IssueEntity issue) {
		if(issueRepository.findById(issue.getIssueId())!=null){
		    issue.setIssueStatus("Resolved");
			return issueRepository.save(issue);
		}
		
		else
			return null;
	}
	
	
	
	
		
		
	}