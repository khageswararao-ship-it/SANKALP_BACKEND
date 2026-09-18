package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payroll {

    @Id
    private String id;   // Employee ID (EMP001, EMP002...)

    private String name;
    private String department;
    private double basicSalary;
    private double bonus;
    private double netSalary;
    private String month;
    private String status;

    public Payroll() {
    }

    public Payroll(String id, String name, String department,
                   double basicSalary, double bonus,
                   String month, String status) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.netSalary = basicSalary + bonus;
        this.month = month;
        this.status = status;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
        calculateNetSalary();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
        calculateNetSalary();
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void calculateNetSalary() {
        this.netSalary = this.basicSalary + this.bonus;
    }
}