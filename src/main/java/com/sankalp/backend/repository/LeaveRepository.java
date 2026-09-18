package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, String> {
}