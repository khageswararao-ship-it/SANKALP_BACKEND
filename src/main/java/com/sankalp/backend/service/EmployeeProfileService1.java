package com.sankalp.backend.service;

import com.sankalp.backend.entity.EmployeeProfileDashboard;
import com.sankalp.backend.repository.EmployeeProfileRepository1;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProfileService1 {

    private final EmployeeProfileRepository1 repository;

    public EmployeeProfileService1(EmployeeProfileRepository1 repository) {
        this.repository = repository;
    }

    public EmployeeProfileDashboard getProfile(String employeeId) {
        return repository.findById(employeeId).orElse(null);
    }

    public EmployeeProfileDashboard saveProfile(EmployeeProfileDashboard profile) {
        return repository.save(profile);
    }

    public EmployeeProfileDashboard updateProfile(String employeeId,
                                                  EmployeeProfileDashboard profile) {

        profile.setEmployeeId(employeeId);
        return repository.save(profile);
    }
}