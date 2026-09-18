package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, String> {

}