package com.xk.Ujian.controller;

import com.xk.Ujian.dto.RegistrationRequest;
import com.xk.Ujian.dto.LoginRequest;
import com.xk.Ujian.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/api")
public class UserController {
 
    @Autowired
    private UserService userService;
 

    @GetMapping("/verify-token-google")
    public String verifyToken(@RequestParam("token") String token) {
        String url = "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + token;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Verify response and extract user info
        return response;
    }

    //dikasi peringatan dolo biar lengkap paramnya
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest request) {
        if (userService.register(request.getUsername(), request.getPassword(), request.getEmail())) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Email Sudah Terdaftar", HttpStatus.BAD_REQUEST);
        }
    }
//LoginRequest

    @PostMapping("/login") 
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {    
        if (userService.authenticate(request.getEmail(),request.getPassword())) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Password Anda Salah", HttpStatus.UNAUTHORIZED);
        }
    }
}


