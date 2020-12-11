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

import com.tms.exception.TourPackageNotFoundException;
import com.tms.model.TourPackageEntity;
import com.tms.service.TourPackageService;

@RestController
@RequestMapping("/tour")
public class TourPackageController {
	@Autowired
	private TourPackageService tourpackageService;

	@PostMapping("/createnewpackage")
	public TourPackageEntity createTourPackage(@RequestBody TourPackageEntity tour) {
		return tourpackageService.createTourPackage(tour);
	}

	@GetMapping("/all")
	public List<TourPackageEntity> getAllTourPackages() {
		return tourpackageService.getAllTourPackages();
	}
	//newman run https://www.getpostman.com/collections/aac2bcfb0ea9ba957f79
	@GetMapping("/{packageId}")
	public ResponseEntity<TourPackageEntity> getTourPackageById(@PathVariable(value = "packageId") int packageId)
			throws TourPackageNotFoundException {

		TourPackageEntity tour = tourpackageService.getTourPackageById(packageId).orElseThrow(
				() -> new TourPackageNotFoundException("No Tour Package Found With this Id : " + packageId));
		return ResponseEntity.ok().body(tour);
	}

	@GetMapping("/tourbyname/{packageName}")
	public List<TourPackageEntity> getTourPackageByName(@PathVariable(value = "packageName") String packageName) {
		return tourpackageService.getTourPackageByName(packageName);
	}

	@PutMapping("/update/{packageid}")
	public ResponseEntity<TourPackageEntity> updateTourPackage(@PathVariable(value = "packageid") int packageId,
			@RequestBody TourPackageEntity tour) throws TourPackageNotFoundException {
		TourPackageEntity tourpackage = tourpackageService.getTourPackageById(packageId).orElseThrow(
				() -> new TourPackageNotFoundException("Noo Tour Package Found With this Id : " + packageId));
		tourpackage.setTrip_Price(tour.getTrip_Price());
		TourPackageEntity updateTourPackage = tourpackageService.updateTourPackage(tourpackage);
		return ResponseEntity.ok(updateTourPackage);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTourPackage(@PathVariable(value = "id") int tourpackageId) throws TourPackageNotFoundException {
		TourPackageEntity tourpackage = tourpackageService.getTourPackageById(tourpackageId).orElseThrow(
				() -> new TourPackageNotFoundException("Noo Tour Package Found With this Id : " + tourpackageId));
		tourpackageService.deleteTourPackage(tourpackage);
		return "TourPackage Delete";
	}

}