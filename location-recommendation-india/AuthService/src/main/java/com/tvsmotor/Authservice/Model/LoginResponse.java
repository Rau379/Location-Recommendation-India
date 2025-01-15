package com.tvsmotor.Authservice.Model;

public class LoginResponse {

    private String jwtToken;

    // No-argument constructor (needed for creating objects without arguments)
    public LoginResponse() {
    }

    // Constructor with jwtToken parameter
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // Getter and Setter for jwtToken
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
