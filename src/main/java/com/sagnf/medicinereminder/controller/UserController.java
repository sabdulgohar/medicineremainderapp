package com.sagnf.medicinereminder.controller;

import com.sagnf.medicinereminder.dto.LoginRequest;
import com.sagnf.medicinereminder.dto.RegisterRequest;
import com.sagnf.medicinereminder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        String response = userService.register(request);
        return ResponseEntity.ok(response);
    }

    // ================= LOGIN =================


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        String token = userService.login(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok(token);
    }
}