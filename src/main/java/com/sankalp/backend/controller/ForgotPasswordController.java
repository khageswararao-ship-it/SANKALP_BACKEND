package com.sankalp.backend.controller;

import com.sankalp.backend.service.ForgotPasswordService;
import org.springframework.web.bind.annotation.*;
import com.sankalp.backend.dto.ResetPasswordRequest;

@RestController
@RequestMapping("/api/forgot-password")
@CrossOrigin(origins = "http://localhost:5173")
public class ForgotPasswordController {

    private final ForgotPasswordService service;

    public ForgotPasswordController(ForgotPasswordService service) {
        this.service = service;
    }

    @PutMapping("/reset")
    public String resetPassword(@RequestBody ResetPasswordRequest request) {
        return service.resetPassword(request);
    }
}