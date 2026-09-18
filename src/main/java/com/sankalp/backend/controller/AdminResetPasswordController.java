package com.sankalp.backend.controller;

import com.sankalp.backend.service.AdminForgotPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminResetPasswordController {

    private final AdminForgotPasswordService service;

    public AdminResetPasswordController(AdminForgotPasswordService service) {
        this.service = service;
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestParam String token,
            @RequestParam String password) {

        String result = service.resetPassword(token, password);

        if ("INVALID_TOKEN".equals(result)) {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }

        return ResponseEntity.ok("Password changed successfully.");
    }
}