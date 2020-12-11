
package com.tms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tms.exception.TourPackageNotFoundException;
import com.tms.model.TourPackageEntity;
import com.tms.repository.TourPackageRepository;
import com.tms.service.TourPackageService;

@SpringBootTest
class TourPackageServiceImplTest {
	
	@Autowired
	private TourPackageService service;
	@MockBean
	private TourPackageRepository repository;

	@Test
	public void testCreateTourPackage() {
		TourPackageEntity tourpackage=new TourPackageEntity();
		tourpackage.setPackageId(101);
		tourpackage.setPackageName("Moonar");
		tourpackage.setHotelName("AbcHotel");
		tourpackage.setDaysCount(3);
		tourpackage.setNightsCount(4);
		tourpackage.setPackageType("Gold");
		tourpackage.setTrip_Price(3000);

		Mockito.when(repository.save(tourpackage)).thenReturn(tourpackage);
		assertThat(service.createTourPackage(tourpackage)).isEqualTo(tourpackage);
	}
	@Test
	public void  testgetAllTourPackages() {
		TourPackageEntity tourpackage=new TourPackageEntity();
		tourpackage.setPackageId(101);
		tourpackage.setPackageName("Moonar");
		tourpackage.setHotelName("AbcHotel");
		tourpackage.setDaysCount(3);
		tourpackage.setNightsCount(4);
		tourpackage.setPackageType("Gold");
		tourpackage.setTrip_Price(3000);
		
		TourPackageEntity tourpackage1=new TourPackageEntity();
		tourpackage1.setPackageId(102);
		tourpackage1.setPackageName("Ooty");
		tourpackage1.setHotelName("XYZHotel");
		tourpackage1.setDaysCount(3);
		tourpackage1.setNightsCount(4);
		tourpackage1.setPackageType("Gold");
		tourpackage1.setTrip_Price(5000);
		
		
		List<TourPackageEntity> tourpackageList=new ArrayList<>();
		tourpackageList.add(tourpackage);
		tourpackageList.add(tourpackage1);
		
		Mockito.when(repository.findAll()).thenReturn(tourpackageList);
		assertThat(service.getAllTourPackages()).isEqualTo(tourpackageList);
		
	}
	
   @Test
   public void testgetTourPackageById() {
	    TourPackageEntity tourpackage=new TourPackageEntity();
	    tourpackage.setPackageId(101);
		tourpackage.setPackageName("Moonar");
		tourpackage.setHotelName("ABCHotel");
		tourpackage.setDaysCount(3);
		tourpackage.setNightsCount(4);
		tourpackage.setPackageType("Gold");
		tourpackage.setTrip_Price(3000);
		
		
		assertThat(service.getTourPackageById(101)).isEqualTo(repository.findById(101));
		
   }
   @Test
   public void testUpdateTourPackage() {
	   TourPackageEntity tourpackage=new TourPackageEntity();
	    tourpackage.setPackageId(101);
		tourpackage.setPackageName("Moonar");
		tourpackage.setHotelName("AbcHotel");
		tourpackage.setDaysCount(3);
		tourpackage.setNightsCount(4);
		tourpackage.setPackageType("Gold");
		tourpackage.setTrip_Price(3000);
		
		Mockito.when(repository.save(tourpackage)).thenReturn(tourpackage);
		 tourpackage.setHotelName("XyzHotel");
		assertSame(service.updateTourPackage(tourpackage),tourpackage);
	   
   }
	/*
	 * @Test public void testUpdateTourPackage() throws TourPackageNotFoundException
	 * { TourPackageEntity tourpackage=new TourPackageEntity();
	 * tourpackage.setPackageId(102);
	 * tourpackage.setPackageName("Proper name has to be given");
	 * tourpackage.setHotelName("Proper hotel name has to be given");
	 * tourpackage.setDaysCount(3); tourpackage.setNightsCount(4);
	 * tourpackage.setPackageType("Give Proper package type");
	 * tourpackage.setTrip_Price(3000);
	 * 
	 * TourPackageEntity listWithData = mock(TourPackageEntity.class);
	 * when(listWithData.get()).thenReturn(item1);
	 * when(myService.getListWithData()).thenReturn(listWithData);
	 * 
	 * TourPackageEntity
	 * tourpackageUpdate=repository.findById(tourpackage.getPackageId()).orElse(null
	 * ); Mockito.when(repository.save(tourpackage)).thenReturn(tourpackage);
	 * 
	 * 
	 * TourPackageEntity value=service.updateTourPackage(tourpackageUpdate);
	 * 
	 * assertEquals(tourpackageUpdate.getPackageName(),"Updated");
	 * Mockito.when(repository.findById(101).orElse(null)).thenReturn(tourpackage);
	 * 
	 * assertThat(tourpackage.getPackageName()).isEqualTo("Updated");
	 * 
	 * 
	 * 
	 * }
	 */
	 @Test
	 public void deleteTourPackage() throws TourPackageNotFoundException {
	 TourPackageEntity tourpackage=new TourPackageEntity();
	 tourpackage.setPackageId(102);
	 tourpackage.setPackageName("Proper name has to be given");
	 tourpackage.setHotelName("Proper hotel name has to be given");
	 tourpackage.setDaysCount(3); tourpackage.setNightsCount(4);
	 tourpackage.setPackageType("Give Proper package type");
	 tourpackage.setTrip_Price(3000);
	 String entity=service.deleteTourPackage(tourpackage);
	 assertEquals(entity,"package Successfully deleted");
	 
   }
}

