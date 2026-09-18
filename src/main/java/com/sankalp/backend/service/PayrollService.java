package com.sankalp.backend.service;

import com.sankalp.backend.entity.Payroll;
import com.sankalp.backend.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    // Get all payrolls
    public List<Payroll> getAll() {
        return repository.findAll();
    }

    // Get payroll by Employee ID
    public Payroll getById(String id) {
        return repository.findById(id).orElse(null);
    }

    // Add new payroll
    public Payroll save(Payroll payroll) {

        // Calculate Net Salary
        payroll.setNetSalary(
                payroll.getBasicSalary() + payroll.getBonus()
        );

        return repository.save(payroll);
    }

    // Update payroll
    public Payroll update(String id, Payroll payroll) {

        Payroll existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(payroll.getName());
        existing.setDepartment(payroll.getDepartment());
        existing.setBasicSalary(payroll.getBasicSalary());
        existing.setBonus(payroll.getBonus());
        existing.setMonth(payroll.getMonth());
        existing.setStatus(payroll.getStatus());

        // Net Salary
        existing.setNetSalary(
                payroll.getBasicSalary() + payroll.getBonus()
        );

        return repository.save(existing);
    }

    // Delete payroll
    public void delete(String id) {
        repository.deleteById(id);
    }
}