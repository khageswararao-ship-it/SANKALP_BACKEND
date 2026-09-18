package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Attendance;
import com.sankalp.backend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sankalp.backend.entity.AttendanceSummary;



import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id,
                                       @RequestBody Attendance attendance) {
        return attendanceService.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }


    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getEmployeeAttendance(
            @PathVariable String employeeId) {

        return attendanceService.getEmployeeAttendance(employeeId);
    }

    @GetMapping("/employee/{employeeId}/summary")
    public AttendanceSummary getSummary(
            @PathVariable String employeeId) {

        return attendanceService.getSummary(employeeId);
    }

}