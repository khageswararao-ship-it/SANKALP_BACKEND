package com.sankalp.backend.service;

import com.sankalp.backend.entity.EmployeeDashboard;
import com.sankalp.backend.repository.EmployeeDashboardRepository;
import org.springframework.stereotype.Service;
import com.sankalp.backend.repository.NotificationRepository;


@Service
public class EmployeeDashboardService {

    private final EmployeeDashboardRepository repository;
    private final NotificationRepository notificationRepository;

    public EmployeeDashboardService(
            EmployeeDashboardRepository repository,
            NotificationRepository notificationRepository) {

        this.repository = repository;
        this.notificationRepository = notificationRepository;
    }

    public EmployeeDashboard getEmployee(String id) {

        EmployeeDashboard employee = repository.findById(id).orElse(null);

        if (employee != null) {
            employee.setNotifications(
                    notificationRepository.findByEmployeeId(id).size()
            );
        }

        return employee;
    }

    public EmployeeDashboard addEmployee(EmployeeDashboard employee) {
        return repository.save(employee);
    }

    public EmployeeDashboard updateEmployee(String id, EmployeeDashboard employee) {

        EmployeeDashboard existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(employee.getName());
        existing.setDesignation(employee.getDesignation());
        existing.setAttendance(employee.getAttendance());
        existing.setLeaveBalance(employee.getLeaveBalance());
        existing.setSalary(employee.getSalary());

        // Don't update notifications manually
        // existing.setNotifications(employee.getNotifications());

        return repository.save(existing);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}