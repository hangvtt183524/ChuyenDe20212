package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.User;
import com.group2.petcareinfotype.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping(value = "/login")
    public ResponseEntity<String> login(@RequestParam(name = "mail", required = true) String mail,
                                @RequestParam(name = "password", required = true) String password) {
        return ResponseEntity.accepted().body(authService.handleLogin(mail, password));
    }
}
