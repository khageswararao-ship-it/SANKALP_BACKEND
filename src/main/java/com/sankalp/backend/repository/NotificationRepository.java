package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {

    // Get all notifications of a specific employee
    List<Notification> findByEmployeeId(String employeeId);

    // Get notifications by receiver (ADMIN or EMPLOYEE)
    List<Notification> findByReceiver(String receiver);


}