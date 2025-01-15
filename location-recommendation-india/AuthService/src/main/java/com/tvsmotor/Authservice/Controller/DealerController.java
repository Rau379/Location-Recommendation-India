package com.tvsmotor.Authservice.Controller;

import com.tvsmotor.Authservice.Model.LoginRequest;
import com.tvsmotor.Authservice.Model.LoginResponse;
import com.tvsmotor.Authservice.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class DealerController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login", produces = "application/json")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String jwtToken = authService.login(loginRequest);
        LoginResponse response = new LoginResponse();
        response.setJwtToken(jwtToken);
        return response;
    }
}
