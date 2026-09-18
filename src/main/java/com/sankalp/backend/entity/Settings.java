package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "settings")
public class Settings {

    @Id
    private Long id;

    private String companyName;
    private String companyEmail;
    private String phone;
    private String address;
    private String theme;
    private String language;

    public Settings() {
    }

    public Settings(Long id, String companyName, String companyEmail,
                    String phone, String address,
                    String theme, String language) {
        this.id = id;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.phone = phone;
        this.address = address;
        this.theme = theme;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}