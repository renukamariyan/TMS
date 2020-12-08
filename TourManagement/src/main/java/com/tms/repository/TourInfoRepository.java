package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.tms.model.TourInfoEntity;

public interface TourInfoRepository extends JpaRepository<TourInfoEntity, Integer> {

}