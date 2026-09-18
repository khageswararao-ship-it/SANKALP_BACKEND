package com.sankalp.backend.repository;

import com.sankalp.backend.entity.EmployeeSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSettingsRepository
        extends JpaRepository<EmployeeSettings, String> {

}