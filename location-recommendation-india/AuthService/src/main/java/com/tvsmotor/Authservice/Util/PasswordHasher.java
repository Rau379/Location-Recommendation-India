package com.tvsmotor.Authservice.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {

    public static void main(String[] args) {
        // Create a BCryptPasswordEncoder instance
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Define the plaintext password you want to hash
        String plaintextPassword = "password6";

        // Hash the plaintext password
        String hashedPassword = encoder.encode(plaintextPassword);

        // Print the hashed password
        System.out.println("Plaintext Password: " + plaintextPassword);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}