package com.tvsmotor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tvsmotor.Model.Dealer;
import com.tvsmotor.Service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proximity")
public class DealerController {
//
    @Autowired
    private DealerService dealerService;

    // GET request to retrieve dealers by proximity
//    @GetMapping("/dealers")
//    public List<Dealer> getDealers(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "15") double radiusInKm) {
//        // Fetch the dealers within the proximity
//        return dealerService.findDealersNearLocation(lat, lng, radiusInKm);
//    }
    
    
  
    
    
    @GetMapping("/nearby")
    public List<Dealer> getDealers(@RequestParam double lat, @RequestParam double lng, @RequestParam double radiusInKm) {
        return dealerService.findDealersNearLocation(lat, lng, radiusInKm);
    }

//	   @Autowired
//	    private DealerService dealerService;
//
//	    @GetMapping("/dealers")
//	    public List<Dealer> getAllDealers() {
//	        return dealerService.findAllDealers();
//	    }
}


