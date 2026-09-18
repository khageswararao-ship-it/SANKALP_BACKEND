package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Payroll;
import com.sankalp.backend.service.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "http://localhost:5173")
public class PayrollController {

    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payroll> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Payroll getById(@PathVariable String id) {
        return service.getById(id);
    }


    @GetMapping("/employee/{employeeId}")
    public Payroll getEmployeePayroll(@PathVariable String employeeId) {
        return service.getById(employeeId);
    }


    @PostMapping
    public Payroll save(@RequestBody Payroll payroll) {
        return service.save(payroll);
    }

    @PutMapping("/{id}")
    public Payroll update(@PathVariable String id,
                          @RequestBody Payroll payroll) {
        return service.update(id, payroll);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}