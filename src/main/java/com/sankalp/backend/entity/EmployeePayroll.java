package com.sankalp.backend.entity;

import jakarta.persistence.*;

@Entity
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String employeeName;
    private String month;
    private double basic;
    private double allowance;
    private double deduction;
    private double net;

    public EmployeePayroll() {
    }

    public EmployeePayroll(Long id, String employeeId, String employeeName,
                           String month, double basic, double allowance,
                           double deduction, double net) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.month = month;
        this.basic = basic;
        this.allowance = allowance;
        this.deduction = deduction;
        this.net = net;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }
}