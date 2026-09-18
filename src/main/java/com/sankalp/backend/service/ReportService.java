package com.sankalp.backend.service;

import com.sankalp.backend.entity.Report;
import com.sankalp.backend.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public List<Report> getAll() {
        return repository.findAll();
    }

    public Report getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Report save(Report report) {
        return repository.save(report);
    }

    public Report update(String id, Report report) {

        Report existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setReportName(report.getReportName());
        existing.setGeneratedBy(report.getGeneratedBy());
        existing.setDate(report.getDate());
        existing.setStatus(report.getStatus());

        return repository.save(existing);
    }

    public Report generateEmployeeReport() {

        Report report = new Report();

        report.setId("REP" + System.currentTimeMillis());
        report.setReportName("Employee Report");
        report.setGeneratedBy("Admin");
        report.setDate(java.time.LocalDate.now().toString());
        report.setStatus("Generated");

        return repository.save(report);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}