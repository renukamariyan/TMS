package com.tms.service;

import java.util.List;

import com.tms.exception.RecordNotFoundException;
import com.tms.model.*;



public interface TourInfoService {


	public abstract List<TourInfoEntity> displayAllTourInfo();

	public abstract TourInfoEntity confirmTour(TourInfoEntity pack);

	public abstract TourInfoEntity updatePaymentStatus(int id) throws RecordNotFoundException ;

	public abstract void cancelTourPackage(int id) throws RecordNotFoundException ;
}
