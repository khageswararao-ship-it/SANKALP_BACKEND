package com.sankalp.backend.service;

import com.sankalp.backend.entity.EmployeePayroll;
import com.sankalp.backend.repository.EmployeePayrollRepository1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService1 {

    private final EmployeePayrollRepository1 repository;

    public EmployeePayrollService1(EmployeePayrollRepository1 repository) {
        this.repository = repository;
    }

    public List<EmployeePayroll> getAllPayroll() {
        return repository.findAll();
    }

    public EmployeePayroll getPayroll(Long id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeePayroll savePayroll(EmployeePayroll payroll) {
        return repository.save(payroll);
    }

    public EmployeePayroll updatePayroll(Long id, EmployeePayroll payroll) {

        payroll.setId(id);

        return repository.save(payroll);

    }

    public void deletePayroll(Long id) {
        repository.deleteById(id);
    }

}