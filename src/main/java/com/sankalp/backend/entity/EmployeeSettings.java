package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeSettings {

    @Id
    private String employeeId;

    private boolean emailNotification;
    private boolean smsNotification;
    private boolean darkMode;
    private String language;

    public EmployeeSettings() {
    }

    public EmployeeSettings(String employeeId,
                            boolean emailNotification,
                            boolean smsNotification,
                            boolean darkMode,
                            String language) {
        this.employeeId = employeeId;
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        this.darkMode = darkMode;
        this.language = language;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public boolean isSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}