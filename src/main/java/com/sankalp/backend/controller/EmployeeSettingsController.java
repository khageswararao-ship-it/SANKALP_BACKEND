package com.sankalp.backend.controller;

import com.sankalp.backend.entity.EmployeeSettings;
import com.sankalp.backend.service.EmployeeSettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/settings")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeSettingsController {

    private final EmployeeSettingsService service;

    public EmployeeSettingsController(EmployeeSettingsService service) {
        this.service = service;
    }

    @GetMapping("/{employeeId}")
    public EmployeeSettings getSettings(@PathVariable String employeeId) {
        return service.getSettings(employeeId);
    }

    @PostMapping
    public EmployeeSettings saveSettings(@RequestBody EmployeeSettings settings) {
        return service.saveSettings(settings);
    }

    @PutMapping("/{employeeId}")
    public EmployeeSettings updateSettings(
            @PathVariable String employeeId,
            @RequestBody EmployeeSettings settings) {

        return service.updateSettings(employeeId, settings);
    }
}