package com.tms.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.tms.model.TourPackageEntity;

	@Repository
	public interface TourPackageRepository extends JpaRepository <TourPackageEntity,Integer>{
	 public List<TourPackageEntity> findByPackageName(String packageName);
	}


