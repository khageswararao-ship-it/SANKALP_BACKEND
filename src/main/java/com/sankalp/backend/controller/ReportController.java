package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Report;
import com.sankalp.backend.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Report> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Report save(@RequestBody Report report) {
        return service.save(report);
    }

    @PutMapping("/{id}")
    public Report update(@PathVariable String id,
                         @RequestBody Report report) {
        return service.update(id, report);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/generate/employee")
    public Report generateEmployeeReport() {
        return service.generateEmployeeReport();
    }

}
