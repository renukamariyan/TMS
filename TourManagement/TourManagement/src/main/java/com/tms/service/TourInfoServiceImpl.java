package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.exception.RecordNotFoundException;
import com.tms.model.TourInfoEntity;
import com.tms.repository.TourInfoRepository;

@Service
public class TourInfoServiceImpl implements TourInfoService {

	@Autowired
	private TourInfoRepository tourInfoRepo;

	@Override
	public List<TourInfoEntity> displayAllTourInfo() {
		return tourInfoRepo.findAll();
	}

	@Override
	public TourInfoEntity confirmTour(TourInfoEntity pack) {
		return tourInfoRepo.save(pack);
	}

	@Override
	public TourInfoEntity updatePaymentStatus(TourInfoEntity tour) throws RecordNotFoundException {

		if (tourInfoRepo.findById(tour.getTourId()) != null) {

			tour.setPaymentStatus(true);
			return tourInfoRepo.save(tour);
		} else
			throw new RecordNotFoundException("Given info Id does not exist");
	}

	@Override
	public String cancelTourPackage(int id) throws RecordNotFoundException {
		TourInfoEntity update = tourInfoRepo.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Given info Id does not exist"));

		update.setReservationStatus(false);
		return "Cancelled Succesfully";
	}

}
