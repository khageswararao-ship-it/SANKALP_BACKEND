package com.sankalp.backend.controller;

import com.sankalp.backend.entity.EmployeeDashboard;
import com.sankalp.backend.service.EmployeeDashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-dashboard")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://10.205.165.151:5173"
})
public class EmployeeDashboardController {

    private final EmployeeDashboardService service;

    public EmployeeDashboardController(EmployeeDashboardService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public EmployeeDashboard getEmployee(@PathVariable String id) {
        return service.getEmployee(id);
    }

    @PostMapping
    public EmployeeDashboard addEmployee(@RequestBody EmployeeDashboard employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDashboard updateEmployee(@PathVariable String id,
                                            @RequestBody EmployeeDashboard employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        service.deleteEmployee(id);
    }
}