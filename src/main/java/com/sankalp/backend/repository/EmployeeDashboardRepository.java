package com.sankalp.backend.repository;

import com.sankalp.backend.entity.EmployeeDashboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDashboardRepository
        extends JpaRepository<EmployeeDashboard, String> {
}