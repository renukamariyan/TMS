package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tms.model.IssueEntity;

public interface IssueRepository extends JpaRepository<IssueEntity, Integer> {

}
