package com.sankalp.backend.entity;

public class AttendanceSummary {

    private int present;
    private int absent;
    private int late;
    private double percentage;

    public AttendanceSummary() {
    }

    public AttendanceSummary(int present, int absent, int late, double percentage) {
        this.present = present;
        this.absent = absent;
        this.late = late;
        this.percentage = percentage;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}