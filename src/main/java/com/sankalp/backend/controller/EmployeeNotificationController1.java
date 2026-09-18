package com.sankalp.backend.controller;

import com.sankalp.backend.entity.EmployeeNotification;
import com.sankalp.backend.service.EmployeeNotificationService1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/notifications")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeNotificationController1 {

    private final EmployeeNotificationService1 service;

    public EmployeeNotificationController1(EmployeeNotificationService1 service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeNotification> getAllNotifications() {
        return service.getAllNotifications();
    }

    @GetMapping("/{id}")
    public EmployeeNotification getNotification(@PathVariable Long id) {
        return service.getNotificationById(id).orElse(null);
    }

    @PostMapping
    public EmployeeNotification saveNotification(@RequestBody EmployeeNotification notification) {
        return service.saveNotification(notification);
    }

    @PutMapping("/{id}")
    public EmployeeNotification updateNotification(
            @PathVariable Long id,
            @RequestBody EmployeeNotification notification) {
        return service.updateNotification(id, notification);
    }

    @PutMapping("/{id}/read")
    public EmployeeNotification markAsRead(@PathVariable Long id) {
        return service.markAsRead(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        service.deleteNotification(id);
    }

    @DeleteMapping("/clear")
    public void clearNotifications() {
        service.clearNotifications();
    }
}