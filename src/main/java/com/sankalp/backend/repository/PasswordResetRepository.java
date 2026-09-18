package com.sankalp.backend.repository;

import com.sankalp.backend.entity.PasswordResetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetRepository
        extends JpaRepository<PasswordResetRequest, Long> {
}