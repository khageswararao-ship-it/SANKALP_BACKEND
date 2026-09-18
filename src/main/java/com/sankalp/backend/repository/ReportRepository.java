package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, String> {

}