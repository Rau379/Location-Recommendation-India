package com.tvsmotor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.Model.Dealer;
import com.tvsmotor.Repository.DealerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    // Haversine formula to calculate distance between two points on Earth
    private static final double EARTH_RADIUS = 6371; // Radius in kilometers

    public List<Dealer> findDealersNearLocation(double latitude, double longitude, double radiusInKm) {
        List<Dealer> allDealers = dealerRepository.findAll();
        List<Dealer> nearbyDealers = new ArrayList<>();

        for (Dealer dealer : allDealers) {
            double distance = calculateDistance(latitude, longitude, dealer.getLat(), dealer.getLng());
            
            if (distance <= radiusInKm) { // 15 km
            	dealer.setDistanceInKm(distance);
                nearbyDealers.add(dealer);
            }
        }

        return nearbyDealers;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // Distance in kilometers
    }
}
