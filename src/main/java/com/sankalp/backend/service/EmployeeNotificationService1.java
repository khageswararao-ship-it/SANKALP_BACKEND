package com.sankalp.backend.service;

import com.sankalp.backend.entity.EmployeeNotification;
import com.sankalp.backend.repository.EmployeeNotificationRepository1;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeNotificationService1 {

    private final EmployeeNotificationRepository1 repository;

    public EmployeeNotificationService1(EmployeeNotificationRepository1 repository) {
        this.repository = repository;
    }

    public List<EmployeeNotification> getAllNotifications() {
        return repository.findAll();
    }

    public Optional<EmployeeNotification> getNotificationById(Long id) {
        return repository.findById(id);
    }

    public EmployeeNotification saveNotification(EmployeeNotification notification) {
        return repository.save(notification);
    }

    public EmployeeNotification updateNotification(Long id, EmployeeNotification notification) {
        notification.setId(id);
        return repository.save(notification);
    }

    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }

    public void clearNotifications() {
        repository.deleteAll();
    }

    public EmployeeNotification markAsRead(Long id) {
        EmployeeNotification notification = repository.findById(id).orElseThrow();
        notification.setRead(true);
        return repository.save(notification);
    }
}