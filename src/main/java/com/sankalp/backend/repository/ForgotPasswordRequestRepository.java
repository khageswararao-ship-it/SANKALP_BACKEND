package com.sankalp.backend.repository;

import com.sankalp.backend.entity.ForgotPasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForgotPasswordRequestRepository
        extends JpaRepository<ForgotPasswordRequest, Long> {

    Optional<ForgotPasswordRequest> findByEmployeeId(String employeeId);
}