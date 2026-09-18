package com.sankalp.backend.repository;

import com.sankalp.backend.entity.EmployeeProfileDashboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository1
        extends JpaRepository<EmployeeProfileDashboard, String> {
}