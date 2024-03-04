package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.LoginRequest;
import com.aditya.ecommerce.application.response.AuthResponse;
import com.aditya.ecommerce.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        String token = authService.createUserHandler(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Successfully");
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {
        String token = authService.loginUserHandler(loginRequest);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signin Successfully");
        return ResponseEntity.ok(authResponse);
    }
}
