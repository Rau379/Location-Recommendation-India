package com.tvsmotor.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeocodingService {

    private final String GOOGLE_MAPS_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private final String GOOGLE_PLACES_TEXTSEARCH_API_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json";

    public Map<String, Object> getLatLongFromAddress(String address, String apiKey) {
        // Check if the input is likely a business name or an address
        if (isLikelyBusinessName(address)) {
            // Use Places Text Search API for business names
            return getLatLongFromBusinessTextSearch(address, apiKey);
        } else {
            // Use Geocoding API for addresses or pincodes
            return getLatLongFromGeocodingAPI(address, apiKey);
        }
    }

    // Use the Geocoding API for regular addresses or pincodes
    private Map<String, Object> getLatLongFromGeocodingAPI(String address, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();

        // Build the API URL for the Geocoding API
        String uri = UriComponentsBuilder.fromHttpUrl(GOOGLE_MAPS_API_URL)
                .queryParam("address", address)
                .queryParam("key", apiKey)
                .toUriString();

        // Make the API request
        Map<String, Object> response = restTemplate.getForObject(uri, HashMap.class);

        return parseLatLongFromResponse(response);
    }

    // Use the Places Text Search API for business names
    private Map<String, Object> getLatLongFromBusinessTextSearch(String businessName, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();

        // Build the API URL for the Places Text Search API
        String uri = UriComponentsBuilder.fromHttpUrl(GOOGLE_PLACES_TEXTSEARCH_API_URL)
                .queryParam("query", businessName + ", India")  // Add "India" to the query to improve results
                .queryParam("key", apiKey)
                .toUriString();

        // Make the API request
        Map<String, Object> response = restTemplate.getForObject(uri, HashMap.class);

        return parseLatLongFromPlaceResponse(response);
    }

    // Parse the response from the Geocoding API
    private Map<String, Object> parseLatLongFromResponse(Map<String, Object> response) {
        Map<String, Object> locationMap = new HashMap<>();

        if (response != null && response.containsKey("results")) {
            List<Object> results = (List<Object>) response.get("results");

            if (!results.isEmpty()) {
                Map<String, Object> geometry = (Map<String, Object>) ((Map<String, Object>) results.get(0)).get("geometry");
                Map<String, Object> location = (Map<String, Object>) geometry.get("location");
                locationMap.put("lat", location.get("lat"));
                locationMap.put("lng", location.get("lng"));
            } else {
                locationMap.put("error", "No results found for the given address.");
            }
        } else {
            locationMap.put("error", "Could not retrieve lat/long from the address.");
        }

        return locationMap;
    }

    // Parse the response from the Places Text Search API
    private Map<String, Object> parseLatLongFromPlaceResponse(Map<String, Object> response) {
        Map<String, Object> locationMap = new HashMap<>();

        if (response != null && response.containsKey("results")) {
            List<Object> results = (List<Object>) response.get("results");

            if (!results.isEmpty()) {
                Map<String, Object> geometry = (Map<String, Object>) ((Map<String, Object>) results.get(0)).get("geometry");
                Map<String, Object> location = (Map<String, Object>) geometry.get("location");
                locationMap.put("lat", location.get("lat"));
                locationMap.put("lng", location.get("lng"));
            } else {
                locationMap.put("error", "No results found for the given business name.");
            }
        } else {
            locationMap.put("error", "Could not retrieve lat/long from the business name.");
        }

        return locationMap;
    }

    // Check if the input is likely a business name (heuristic based)
    private boolean isLikelyBusinessName(String input) {
        // Basic heuristic: if input contains "TVS", "Motors", "LLP", etc., it's likely a business name
        return input.toLowerCase().contains("TVS");
    }
}


