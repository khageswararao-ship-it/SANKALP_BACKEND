package com.sankalp.backend.repository;

import com.sankalp.backend.entity.AdminPasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminPasswordResetTokenRepository
        extends JpaRepository<AdminPasswordResetToken, Long> {

    Optional<AdminPasswordResetToken> findByToken(String token);

    Optional<AdminPasswordResetToken> findByEmail(String email);


}