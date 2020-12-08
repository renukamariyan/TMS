
package com.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.exception.IssueNotFoundException;
import com.tms.model.IssueEntity;
import com.tms.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	IssueRepository issueRepository;
	@Override
	public IssueEntity createNewIssue(IssueEntity issue) {
		return issueRepository.save(issue);
	}

	
	@Override
	public List<IssueEntity> displayAllIssue() {
		return issueRepository.findAll();
	}

	@Override
	public Optional<IssueEntity> displayIssueById(int userid) {
		return issueRepository.findById(userid);
	}

	@Override
	public IssueEntity updateIssueAsResolved(IssueEntity issue)throws IssueNotFoundException {
		if(issueRepository.findById(issue.getIssueId())!=null){
		    issue.setIssueStatus("Resolved");
			return issueRepository.save(issue);
		}
		
		else
			throw new IssueNotFoundException("Given Issue Id does not exist");
	}

	
		
		
	}


