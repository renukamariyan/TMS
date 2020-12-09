package com.tms.controller;

import java.util.List;

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

import com.tms.exception.RecordNotFoundException;
import com.tms.model.IssueEntity;
import com.tms.model.TourInfoEntity;
import com.tms.service.TourInfoService;

@RestController
@RequestMapping("/tourinfo")
public class TourInfoController {

	@Autowired
	TourInfoService tourInfoService;

	@PostMapping("/confirm")
	public TourInfoEntity confirmTour(@RequestBody TourInfoEntity pack) {
		return tourInfoService.confirmTour(pack);
	}

	@GetMapping("/all")
	public List<TourInfoEntity> findAll() {
		return tourInfoService.displayAllTourInfo();
	}

	@PutMapping("/updatepaymentstatus/{tourId}")
	public String updatePaymentStatus(@PathVariable(value = "tourId") int tourId, @RequestBody TourInfoEntity tour)
			throws RecordNotFoundException {
		TourInfoEntity updated = tourInfoService.updatePaymentStatus(tour);
		return updated.getTourId() + "Payment made";
	}

	@DeleteMapping("/cancel/{tourId}")
	public String cancelTicket(@PathVariable(value = "tourId") int tourId) throws RecordNotFoundException {
		tourInfoService.cancelTourPackage(tourId);
		return "Trip Canceled";
	}

}
