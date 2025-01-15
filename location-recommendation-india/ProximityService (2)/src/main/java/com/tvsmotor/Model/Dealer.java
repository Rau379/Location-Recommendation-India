package com.tvsmotor.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

@Document(collection = "Dealers")
public class Dealer {

	
	 @Id
	    private String id; // MongoDB will generate the ID automatically
	    private String name;
	    private String address;
	    private double lat;
	    private double lng;
	    private String pincode;
	    private double ratings;
	    private String timings;
	    private String category;
	    private String phoneNumber;
	    private String website;
	    private String businessStatus;
	    private String photoUrl;
	    private double distanceInKm;
	    
	    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	    private double[] location;
	    
	    public GeoJsonPoint getlocation() {
	    	return new GeoJsonPoint(lng,lat);
	    }
	    
// Additional field to hold sales, service, or store
	    // Constructors
	    public Dealer() {}
	    public Dealer(String name, String address, double lat, double lng, String pincode, double ratings, String timings,
	                   String category, String phoneNumber, String website, String businessStatus, String photoUrl) {
	        this.name = name;
	        this.address = address;
	        this.lat = lat;
	        this.lng = lng;
	        this.pincode = pincode;
	        this.ratings = ratings;
	        this.timings = timings;
	        this.category = category;
	        this.phoneNumber = phoneNumber;
	        this.website = website;
	        this.businessStatus = businessStatus;
	        this.photoUrl = photoUrl;
	        
	    }
	    // Getters and Setters
	    public String getId() {
	        return id;
	    }
	    public double getDistanceInKm() {
			return distanceInKm;
		}

		public void setDistanceInKm(double distanceInKm) {
			this.distanceInKm = distanceInKm;
		}

		public void setId(String id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getAddress() {
	        return address;
	    }
	    public void setAddress(String address) {
	        this.address = address;
	    }
	    public double getLat() {
	        return lat;
	    }
	    public void setLat(double lat) {
	        this.lat = lat;
	    }
	    public double getLng() {
	        return lng;
	    }
	    public void setLng(double lng) {
	        this.lng = lng;
	    }
	    public String getPincode() {
	        return pincode;
	    }
	    public void setPincode(String pincode) {
	        this.pincode = pincode;
	    }
	    public double getRatings() {
	        return ratings;
	    }
	    public void setRatings(double ratings) {
	        this.ratings = ratings;
	    }
	    public String getTimings() {
	        return timings;
	    }
	    public void setTimings(String timings) {
	        this.timings = timings;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public void setCategory(String category) {
	        this.category = category;
	    }
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	    public String getWebsite() {
	        return website;
	    }
	    public void setWebsite(String website) {
	        this.website = website;
	    }
	    public String getBusinessStatus() {
	        return businessStatus;
	    }
	    public void setBusinessStatus(String businessStatus) {
	        this.businessStatus = businessStatus;
	    }
	    public String getPhotoUrl() {
	        return photoUrl;
	    }
	    public void setPhotoUrl(String photoUrl) {
	        this.photoUrl = photoUrl;
	    }
	 	    @Override
	    public String toString() {
	        return "Vehicle{" +
	                "id='" + id + '\'' +
	                ", name='" + name + '\'' +
	                ", address='" + address + '\'' +
	                ", lat=" + lat +
	                ", lng=" + lng +
	                ", pincode='" + pincode + '\'' +
	                ", ratings=" + ratings +
	                ", timings='" + timings + '\'' +
	                ", category='" + category + '\'' +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                ", website='" + website + '\'' +
	                ", businessStatus='" + businessStatus + '\'' +
	                ", photoUrl='" + photoUrl + '\'' +
	                '}';
	    }

	    
    // getters and setters
}
