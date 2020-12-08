package com.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.TourPackageEntity;
import com.tms.repository.TourPackageRepository;

@Service // specialized componenets
public class TourPackageServiceImpl implements TourPackageService {

	@Autowired
	private TourPackageRepository tourpackageRepo;

	public TourPackageEntity createTourPackage(TourPackageEntity tour) {
		return tourpackageRepo.save(tour);
	}

	public List<TourPackageEntity> getAllTourPackages() {
		return tourpackageRepo.findAll();
	}

	public List<TourPackageEntity> getTourPackageByName(String packageName) {
		return tourpackageRepo.findByPackageName(packageName);
	}

	public Optional<TourPackageEntity> getTourPackageById(int id) {
		return tourpackageRepo.findById(id);
	}

	public TourPackageEntity updateTourPackage(TourPackageEntity tour) {
		return tourpackageRepo.save(tour);
	}

	public void deleteTourPackage(TourPackageEntity tour) {
		tourpackageRepo.delete(tour);
	}
}
