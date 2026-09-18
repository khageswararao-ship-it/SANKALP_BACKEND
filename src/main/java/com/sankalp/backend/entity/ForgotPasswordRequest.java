package com.sankalp.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "forgot_password_request")
public class ForgotPasswordRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;

    private String email;

    private String status;

    public ForgotPasswordRequest() {
    }

    public ForgotPasswordRequest(Long id, String employeeId, String email, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.email = email;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}