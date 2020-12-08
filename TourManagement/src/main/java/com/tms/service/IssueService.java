package com.tms.service;

import java.util.List;
import java.util.Optional;

import com.tms.exception.IssueNotFoundException;
import com.tms.model.IssueEntity;



public interface IssueService {
	
	 public abstract IssueEntity createNewIssue(IssueEntity issue);
	 public abstract List<IssueEntity> displayAllIssue();
	 public abstract Optional<IssueEntity> displayIssueById(int userid);
	 public abstract IssueEntity updateIssueAsResolved(IssueEntity issue) throws IssueNotFoundException ;

}
