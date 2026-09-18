package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeProfileDashboard {

    @Id
    private String employeeId;

    private String name;
    private String designation;
    private String email;
    private String phone;
    private String department;
    private String joining;
    private String dob;
    private String gender;
    private String blood;
    private String address;
    private String emergency;
    private String image;

    public EmployeeProfileDashboard() {
    }

    public EmployeeProfileDashboard(String employeeId,
                                    String name,
                                    String designation,
                                    String email,
                                    String phone,
                                    String department,
                                    String joining,
                                    String dob,
                                    String gender,
                                    String blood,
                                    String address,
                                    String emergency,
                                    String image) {

        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.joining = joining;
        this.dob = dob;
        this.gender = gender;
        this.blood = blood;
        this.address = address;
        this.emergency = emergency;
        this.image = image;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJoining() {
        return joining;
    }

    public void setJoining(String joining) {
        this.joining = joining;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}