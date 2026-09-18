package com.sankalp.backend.service;

import com.sankalp.backend.entity.EmployeeSettings;
import com.sankalp.backend.repository.EmployeeSettingsRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSettingsService {

    private final EmployeeSettingsRepository repository;

    public EmployeeSettingsService(EmployeeSettingsRepository repository) {
        this.repository = repository;
    }

    // Get Employee Settings
    public EmployeeSettings getSettings(String employeeId) {
        return repository.findById(employeeId).orElse(null);
    }

    // Save Employee Settings
    public EmployeeSettings saveSettings(EmployeeSettings settings) {
        return repository.save(settings);
    }

    // Update Employee Settings
    public EmployeeSettings updateSettings(String employeeId, EmployeeSettings settings) {

        settings.setEmployeeId(employeeId);

        return repository.save(settings);
    }
}