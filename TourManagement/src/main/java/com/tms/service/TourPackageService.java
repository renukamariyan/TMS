package com.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.TourPackageEntity;
import com.tms.repository.TourPackageRepository;

public interface TourPackageService {

	public TourPackageEntity createTourPackage(TourPackageEntity tour);

	public List<TourPackageEntity> getAllTourPackages();

	public List<TourPackageEntity> getTourPackageByName(String name);

	public Optional<TourPackageEntity> getTourPackageById(int id);

	public TourPackageEntity updateTourPackage(TourPackageEntity tour);

	public void deleteTourPackage(TourPackageEntity tour);
}
