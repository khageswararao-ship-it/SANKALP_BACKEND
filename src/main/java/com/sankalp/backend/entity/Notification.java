package com.sankalp.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    private String id;

    // Employee to whom the notification belongs
    private String employeeId;

    // ADMIN or EMPLOYEE
    private String sender;

    // ADMIN or EMPLOYEE
    private String receiver;

    private String title;

    private String message;

    // Employee reply
    private String reply;

    private String time;

    // info, success, warning, danger
    private String type;

    // Read/Unread status
    @Column(name = "is_read")
    private boolean read;

    public Notification() {
    }

    public Notification(String id, String employeeId, String sender,
                        String receiver, String title, String message,
                        String reply, String time, String type, boolean read) {
        this.id = id;
        this.employeeId = employeeId;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.message = message;
        this.reply = reply;
        this.time = time;
        this.type = type;
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}