package com.sankalp.backend.service;

import com.sankalp.backend.entity.Notification;
import com.sankalp.backend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    // Get all notifications
    public List<Notification> getAll() {
        return repository.findAll();
    }

    // Get notification by ID
    public Notification getById(String id) {
        return repository.findById(id).orElse(null);
    }

    // Save notification
    public Notification save(Notification notification) {

        notification.setRead(false);

        return repository.save(notification);
    }

    // Update notification
    public Notification update(String id, Notification notification) {

        Notification existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setEmployeeId(notification.getEmployeeId());
        existing.setSender(notification.getSender());
        existing.setReceiver(notification.getReceiver());
        existing.setTitle(notification.getTitle());
        existing.setMessage(notification.getMessage());
        existing.setReply(notification.getReply());
        existing.setTime(notification.getTime());
        existing.setType(notification.getType());
        existing.setRead(notification.isRead());

        return repository.save(existing);
    }

    // Delete one notification
    public void delete(String id) {
        repository.deleteById(id);
    }

    // Delete all notifications
    public void deleteAll() {
        repository.deleteAll();
    }

    // ===============================
    // NEW METHODS
    // ===============================

    // Get notifications of one employee
    public List<Notification> getEmployeeNotifications(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    // Mark notification as read
    public Notification markAsRead(String id) {

        Notification notification = repository.findById(id).orElse(null);

        if (notification == null) {
            return null;
        }

        notification.setRead(true);

        return repository.save(notification);
    }

    // Employee reply
    public Notification replyToNotification(String id, String reply) {

        Notification notification = repository.findById(id).orElse(null);

        if (notification == null) {
            return null;
        }

        notification.setReply(reply);
        notification.setSender("EMPLOYEE");
        notification.setReceiver("ADMIN");

        return repository.save(notification);
    }

    // Get all replies sent to admin
    public List<Notification> getAdminNotifications() {
        return repository.findByReceiver("ADMIN");
    }
}