package com.sankalp.backend.repository;

import java.util.List;
import com.sankalp.backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Transactional
    @Modifying
    void deleteByEmployeeId(String employeeId);

    List<Attendance> findByEmployeeId(String employeeId);
}