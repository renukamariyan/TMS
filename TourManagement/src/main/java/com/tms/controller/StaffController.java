package com.tms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.tms.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffService staffservice;
	@Autowired
	IssueService issueservice;

	@GetMapping("/allissues")
	public List<IssueEntity> findAll() {
		return issueservice.displayAllIssue();
	}

	@PutMapping("/updateissue")
	public ResponseEntity<IssueEntity> updateIssue(@RequestBody IssueEntity issue) throws IssueNotFoundException {
		IssueEntity updatedIssue = issueservice.updateIssueAsResolved(issue);
		return ResponseEntity.ok(updatedIssue);
	}

}
