package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Employee;
import com.sankalp.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://10.205.165.151:5173"
})
@RestController
@RequestMapping("/api/admin/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id,
                                   @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}