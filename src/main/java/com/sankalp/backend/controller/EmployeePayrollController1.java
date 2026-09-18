package com.sankalp.backend.controller;

import com.sankalp.backend.entity.EmployeePayroll;
import com.sankalp.backend.service.EmployeePayrollService1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/payroll")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeePayrollController1 {

    private final EmployeePayrollService1 service;

    public EmployeePayrollController1(EmployeePayrollService1 service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeePayroll> getAllPayroll() {
        return service.getAllPayroll();
    }

    @GetMapping("/{id}")
    public EmployeePayroll getPayroll(@PathVariable Long id) {
        return service.getPayroll(id);
    }

    @PostMapping
    public EmployeePayroll savePayroll(@RequestBody EmployeePayroll payroll) {
        return service.savePayroll(payroll);
    }

    @PutMapping("/{id}")
    public EmployeePayroll updatePayroll(
            @PathVariable Long id,
            @RequestBody EmployeePayroll payroll) {

        return service.updatePayroll(id, payroll);

    }

    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Long id) {
        service.deletePayroll(id);
    }

}
