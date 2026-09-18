package com.sankalp.backend.repository;

import com.sankalp.backend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUsername(String username);

    Optional<Login> findByEmployeeId(String employeeId);

    Optional<Login> findByEmail(String email);

}