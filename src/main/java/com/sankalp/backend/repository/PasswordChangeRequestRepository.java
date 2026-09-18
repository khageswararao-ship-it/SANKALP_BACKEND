package com.sankalp.backend.repository;

import com.sankalp.backend.entity.PasswordChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordChangeRequestRepository
        extends JpaRepository<PasswordChangeRequest, Long> {

    List<PasswordChangeRequest> findByStatus(String status);
}