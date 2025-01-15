package com.tvsmotor.Authservice.Service;

import com.tvsmotor.Authservice.Model.Dealer;
import com.tvsmotor.Authservice.Model.LoginRequest;
import com.tvsmotor.Authservice.Repository.DealerRepository;
import com.tvsmotor.Authservice.Util.JwtUtil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private DealerRepository dealerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(LoginRequest loginRequest) {
        // Check if the dealer exists by username
        Optional<Dealer> dealerOptional = dealerRepository.findByUsername(loginRequest.getUsername());

        if (!dealerOptional.isPresent()) {
            throw new RuntimeException("Invalid username or password");
        }

        Dealer dealer = dealerOptional.get();
        
        // Print out debug information
        System.out.println("Username found: " + dealer.getUsername());
        System.out.println("Database Password: " + dealer.getPassword());
        System.out.println("Request Password: " + loginRequest.getPassword());

        // Check if the password matches (hashed passwords should use passwordEncoder)
        if (!passwordEncoder.matches(loginRequest.getPassword(), dealer.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // Return JWT token on successful login
        return jwtUtil.generateToken(dealer.getUsername());
    }

}
