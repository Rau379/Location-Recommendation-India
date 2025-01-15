package com.tvsmotor.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvsmotor.Service.GeocodingService;

import java.util.Map;

@RestController
public class GeocodingController {

    @Autowired
    private GeocodingService geocodingService;

    @GetMapping("/api/geocode")
    public Map<String, Object> getLatLong(@RequestParam String address) {
        // Provide your Google Maps API key
        String apiKey = "AIzaSyBLDc2gSkDRMSN_jYuJsXrExChObFpqqr0";

        // Call the service to get LatLong from the address
        return geocodingService.getLatLongFromAddress(address, apiKey);
    }
}

