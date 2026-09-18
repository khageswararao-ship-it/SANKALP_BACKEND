package com.sankalp.backend.service;
import com.sankalp.backend.entity.Login;
import com.sankalp.backend.entity.EmployeeDashboard;
import com.sankalp.backend.entity.Attendance;
import com.sankalp.backend.entity.Leave;
import com.sankalp.backend.entity.Payroll;

import com.sankalp.backend.repository.LoginRepository;
import com.sankalp.backend.repository.AttendanceRepository;
import com.sankalp.backend.repository.LeaveRepository;
import com.sankalp.backend.repository.PayrollRepository;

import com.sankalp.backend.entity.Employee;
import com.sankalp.backend.repository.EmployeeRepository;
import com.sankalp.backend.repository.EmployeeDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmployeeDashboardRepository employeeDashboardRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {

        // Automatically add EMP prefix
        if (!employee.getId().startsWith("EMP")) {
            employee.setId("EMP" + employee.getId());
        }

        // Save Employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Save Login
        Login login = new Login();
        login.setEmployeeId(employee.getId());
        login.setUsername(employee.getEmail());
        login.setPassword("123456");
        login.setRole("Employee");
        login.setEmail(employee.getEmail());
        login.setMobileNumber("");
        login.setAccountStatus("Active");
        loginRepository.save(login);

        // Save Dashboard
        EmployeeDashboard dashboard = new EmployeeDashboard();
        dashboard.setId(employee.getId());
        dashboard.setName(employee.getName());
        dashboard.setDesignation(employee.getDepartment());
        dashboard.setAttendance(0);
        dashboard.setLeaveBalance(12);
        dashboard.setSalary(0);
        dashboard.setNotifications(0);
        employeeDashboardRepository.save(dashboard);

        // Save Attendance
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employee.getId());
        attendance.setEmployeeName(employee.getName());
        attendance.setDepartment(employee.getDepartment());
        attendance.setDate("");
        attendance.setCheckIn("");
        attendance.setCheckOut("");
        attendance.setStatus("Absent");
        attendanceRepository.save(attendance);

        // Save Leave
        Leave leave = new Leave();
        leave.setId(employee.getId());
        leave.setName(employee.getName());
        leave.setDepartment(employee.getDepartment());
        leave.setLeaveType("");
        leave.setFromDate("");
        leave.setToDate("");
        leave.setDays(0);
        leave.setReason("");
        leave.setStatus("Available");
        leaveRepository.save(leave);

        // Save Payroll
        Payroll payroll = new Payroll();

        payroll.setId(employee.getId());
        payroll.setName(employee.getName());
        payroll.setDepartment(employee.getDepartment());

// Set Basic Salary based on Department
        switch (employee.getDepartment().toUpperCase()) {
            case "HR":
                payroll.setBasicSalary(75000);
                break;

            case "IT":
                payroll.setBasicSalary(90000);
                break;

            case "FINANCE":
                payroll.setBasicSalary(80000);
                break;

            case "MARKETING":
                payroll.setBasicSalary(70000);
                break;

            case "SALES":
                payroll.setBasicSalary(65000);
                break;

            default:
                payroll.setBasicSalary(50000);
                break;
        }

        payroll.setBonus(0);
        payroll.setMonth("");
        payroll.setStatus("Pending");

        payrollRepository.save(payroll);
        return savedEmployee;
    }
    @Transactional
    public void deleteEmployee(String id) {

        loginRepository.findByEmployeeId(id)
                .ifPresent(loginRepository::delete);

        attendanceRepository.deleteByEmployeeId(id);

        leaveRepository.deleteById(id);

        payrollRepository.deleteById(id);

        employeeDashboardRepository.deleteById(id);

        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {

        if (!employee.getId().startsWith("EMP")) {
            employee.setId("EMP" + employee.getId());
        }

        // Update Employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Update Login
        Login login = loginRepository.findByEmployeeId(employee.getId()).orElse(null);
        if (login != null) {
            login.setEmployeeId(employee.getId());
            login.setUsername(employee.getEmail());
            login.setEmail(employee.getEmail());
            loginRepository.save(login);
        }

        // Update Employee Dashboard
        EmployeeDashboard dashboard =
                employeeDashboardRepository.findById(employee.getId()).orElse(null);

        if (dashboard != null) {
            dashboard.setName(employee.getName());
            dashboard.setDesignation(employee.getDepartment());
            employeeDashboardRepository.save(dashboard);
        }

        // Update Attendance
        List<Attendance> attendances = attendanceRepository.findAll();

        for (Attendance attendance : attendances) {
            if (attendance.getEmployeeId().equals(employee.getId())) {
                attendance.setEmployeeName(employee.getName());
                attendance.setDepartment(employee.getDepartment());
                attendanceRepository.save(attendance);
            }
        }

        // Update Leave
        Leave leave = leaveRepository.findById(employee.getId()).orElse(null);

        if (leave != null) {
            leave.setName(employee.getName());
            leave.setDepartment(employee.getDepartment());
            leaveRepository.save(leave);
        }

        // Update Payroll
        Payroll payroll = payrollRepository.findById(employee.getId()).orElse(null);

        if (payroll != null) {
            payroll.setName(employee.getName());
            payroll.setDepartment(employee.getDepartment());

            switch (employee.getDepartment().toUpperCase()) {
                case "HR":
                    payroll.setBasicSalary(75000);
                    break;
                case "IT":
                    payroll.setBasicSalary(90000);
                    break;
                case "FINANCE":
                    payroll.setBasicSalary(80000);
                    break;
                case "MARKETING":
                    payroll.setBasicSalary(70000);
                    break;
                case "SALES":
                    payroll.setBasicSalary(65000);
                    break;
                default:
                    payroll.setBasicSalary(50000);
            }

            payrollRepository.save(payroll);
        }

        return savedEmployee;
    }


    }

