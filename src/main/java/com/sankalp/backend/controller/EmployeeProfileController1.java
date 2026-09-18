package com.sankalp.backend.controller;

import com.sankalp.backend.entity.EmployeeProfileDashboard;
import com.sankalp.backend.service.EmployeeProfileService1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeProfileController1 {

    private final EmployeeProfileService1 service;

    public EmployeeProfileController1(EmployeeProfileService1 service) {
        this.service = service;
    }

    @GetMapping("/{employeeId}")
    public EmployeeProfileDashboard getProfile(
            @PathVariable String employeeId) {

        return service.getProfile(employeeId);
    }

    @PostMapping
    public EmployeeProfileDashboard saveProfile(
            @RequestBody EmployeeProfileDashboard profile) {

        return service.saveProfile(profile);
    }

    @PutMapping("/{employeeId}")
    public EmployeeProfileDashboard updateProfile(
            @PathVariable String employeeId,
            @RequestBody EmployeeProfileDashboard profile) {

        return service.updateProfile(employeeId, profile);
    }
}