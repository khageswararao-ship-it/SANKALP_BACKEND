package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.service.ProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public Login getProfile() {
        return service.getAdminProfile();
    }

    @PutMapping
    public Login updateProfile(@RequestBody Login login) {
        return service.updateAdminProfile(login);
    }
}