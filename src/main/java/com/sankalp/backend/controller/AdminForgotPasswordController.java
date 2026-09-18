package com.sankalp.backend.controller;

import com.sankalp.backend.service.AdminForgotPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminForgotPasswordController {

    private final AdminForgotPasswordService service;

    public AdminForgotPasswordController(AdminForgotPasswordService service) {
        this.service = service;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {

        String result = service.createResetToken(email);

        if ("INVALID_EMAIL".equals(result)) {
            return ResponseEntity.badRequest().body("Invalid email address.");
        }

        return ResponseEntity.ok("Password reset link generated.");
    }


}