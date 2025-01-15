package com.tvsmotor.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tvsmotor.Model.Dealer;

import java.util.List;

public interface DealerRepository extends MongoRepository<Dealer, String> {

//  @Query("{ 'lat': { $gte: ?1 - ?2, $lte: ?1 + ?2 }, 'lng': { $gte: ?0 - ?2, $lte: ?0 + ?2 } }")
//	
//	
//	List<Dealer> findDealersNearLocation(double lng, double lat, double radius);
	//@Query("{ 'lat': { $gte: ?1 - ?2, $lte: ?1 + ?2 }, 'lng': { $gte: ?0 - ?2, $lte: ?0 + ?2 } }")
//	List<Dealer> findDealersNearLocation(double lng, double lat, double radiusInDegrees);
	
	List<Dealer> findAll();

	// List<Dealer> findAll();
}

