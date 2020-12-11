package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tms.model.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {

}