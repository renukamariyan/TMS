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
	public TourInfoEntity updatePaymentStatus(int id) throws RecordNotFoundException {
		
			TourInfoEntity update=tourInfoRepo.findById(id).orElseThrow(()-> new RecordNotFoundException("Given info Id does not exist"));
		    update.setPaymentStatus(true);
			return tourInfoRepo.save(update);
		}

	@Override
	public void cancelTourPackage(int id) throws RecordNotFoundException {
		TourInfoEntity update=tourInfoRepo.findById(id).orElseThrow(()-> new RecordNotFoundException("Given info Id does not exist"));
	    update.setReservationStatus(false);
		
	}

}
