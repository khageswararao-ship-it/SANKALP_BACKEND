package com.sankalp.backend.service;

import com.sankalp.backend.entity.Attendance;
import com.sankalp.backend.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.sankalp.backend.entity.AttendanceSummary;



@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        attendance.setId(id);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getEmployeeAttendance(String employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    public AttendanceSummary getSummary(String employeeId) {

        List<Attendance> list = attendanceRepository.findByEmployeeId(employeeId);

        int present = 0;
        int absent = 0;
        int late = 0;

        for (Attendance a : list) {
            if ("Present".equalsIgnoreCase(a.getStatus())) {
                present++;
            } else if ("Absent".equalsIgnoreCase(a.getStatus())) {
                absent++;
            } else if ("Late".equalsIgnoreCase(a.getStatus())) {
                late++;
            }
        }

        int total = list.size();
        double percentage = total == 0 ? 0 : (present * 100.0) / total;

        return new AttendanceSummary(present, absent, late, percentage);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }




}
