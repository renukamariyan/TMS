package com.tms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tms.exception.IssueNotFoundException;
import com.tms.model.IssueEntity;
import com.tms.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssueController {
	@Autowired
	IssueService issueService;
	
	@GetMapping("")
	public List<IssueEntity> findAll(){
		return issueService.displayAllIssue();
	}
	@GetMapping("/{issueId}")
	public ResponseEntity<IssueEntity> findIssueById(@PathVariable int issueId) throws IssueNotFoundException{
	    IssueEntity issue= issueService.displayIssueById(issueId).orElseThrow(()-> new IssueNotFoundException("Sorry! No Issue Found with the given ID "+issueId));
		return ResponseEntity.ok().body(issue);
	}

	@PostMapping("")
	public IssueEntity createIssue(@RequestBody IssueEntity issue) {
		return issueService.createNewIssue(issue);	
	}
	@PutMapping("")
	public ResponseEntity<IssueEntity> updateIssue(@RequestBody  IssueEntity issue)throws IssueNotFoundException{
		IssueEntity updatedIssue=issueService.updateIssueAsResolved(issue);
		return ResponseEntity.ok(updatedIssue);
	}
}
