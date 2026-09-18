package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Notification;
import com.sankalp.backend.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://10.205.165.151:5173"
})
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    // Get all notifications
    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

    // Get notification by ID
    @GetMapping("/{id}")
    public Notification getById(@PathVariable String id) {
        return service.getById(id);
    }

    // Get notifications of a specific employee
    @GetMapping("/employee/{employeeId}")
    public List<Notification> getEmployeeNotifications(
            @PathVariable String employeeId) {
        return service.getEmployeeNotifications(employeeId);


    }


    // Get all notifications/replies received by admin
    @GetMapping("/admin")
    public List<Notification> getAdminNotifications() {
        return service.getAdminNotifications();
    }



    // Create notification
    @PostMapping
    public Notification save(@RequestBody Notification notification) {
        return service.save(notification);
    }

    // Update notification
    @PutMapping("/{id}")
    public Notification update(
            @PathVariable String id,
            @RequestBody Notification notification) {

        return service.update(id, notification);
    }

    // Mark notification as read
    @PutMapping("/read/{id}")
    public Notification markAsRead(@PathVariable String id) {
        return service.markAsRead(id);
    }

    // Employee reply to admin
    @PutMapping("/reply/{id}")
    public Notification replyToNotification(
            @PathVariable String id,
            @RequestBody Map<String, String> request) {

        return service.replyToNotification(
                id,
                request.get("reply")
        );
    }

    // Delete one notification
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    // Delete all notifications
    @DeleteMapping("/delete-all")
    public void deleteAll() {
        service.deleteAll();
    }
}