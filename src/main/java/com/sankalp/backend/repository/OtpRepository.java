package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OtpRepository extends JpaRepository<Otp, Long> {


    List<Otp> findAllByEmployeeId(String employeeId);

}