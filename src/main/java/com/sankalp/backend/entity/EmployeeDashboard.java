package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeDashboard {

    @Id
    private String id;

    private String name;
    private String designation;
    private int attendance;
    private int leaveBalance;
    private double salary;
    private int notifications;

    public EmployeeDashboard() {}

    public EmployeeDashboard(String id, String name, String designation,
                             int attendance, int leaveBalance,
                             double salary, int notifications) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.attendance = attendance;
        this.leaveBalance = leaveBalance;
        this.salary = salary;
        this.notifications = notifications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNotifications() {
        return notifications;
    }

    public void setNotifications(int notifications) {
        this.notifications = notifications;
    }
}