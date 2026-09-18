package com.sankalp.backend.service;

import com.sankalp.backend.entity.AdminPasswordResetToken;
import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.AdminPasswordResetTokenRepository;
import com.sankalp.backend.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class AdminForgotPasswordService {

    private final LoginRepository loginRepository;
    private final AdminPasswordResetTokenRepository tokenRepository;
    private final JavaMailSender mailSender;

    public AdminForgotPasswordService(
            LoginRepository loginRepository,
            AdminPasswordResetTokenRepository tokenRepository,
            JavaMailSender mailSender) {

        this.loginRepository = loginRepository;
        this.tokenRepository = tokenRepository;
        this.mailSender = mailSender;
    }

    public String createResetToken(String email) {

        Login admin = loginRepository.findByUsername("Admin")
                .orElseThrow(() -> new RuntimeException("Admin account not found"));

        System.out.println("Entered Email: " + email);
        System.out.println("Admin Email: " + admin.getEmail());

        // Wrong email entered
        if (!admin.getEmail().equalsIgnoreCase(email)) {

            SimpleMailMessage alert = new SimpleMailMessage();
            alert.setTo(admin.getEmail());
            alert.setSubject("Security Alert");
            alert.setText(
                    "Someone attempted to reset your admin account password using the email: "
                            + email +
                            ".\n\nIf this was not you, you can safely ignore this email."
            );

            mailSender.send(alert);

            return "INVALID_EMAIL";
        }

        String token = java.util.UUID.randomUUID().toString();

        AdminPasswordResetToken resetToken = new AdminPasswordResetToken();
        resetToken.setEmail(email);
        resetToken.setToken(token);
        resetToken.setExpiryTime(java.time.LocalDateTime.now().plusMinutes(15));
        resetToken.setUsed(false);

        tokenRepository.save(resetToken);

        String resetLink =
                "http://localhost:5173/admin/reset-password?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Admin Password Reset");
        message.setText(
                "Click the link below to reset your password:\n\n"
                        + resetLink +
                        "\n\nThis link expires in 15 minutes."
        );

        mailSender.send(message);

        return "SUCCESS";
    }

    public String resetPassword(String token, String newPassword) {

        Optional<AdminPasswordResetToken> optionalToken =
                tokenRepository.findByToken(token);

        if (optionalToken.isEmpty()) {
            return "INVALID_TOKEN";
        }

        AdminPasswordResetToken resetToken = optionalToken.get();

        if (resetToken.isUsed()) {
            return "INVALID_TOKEN";
        }

        if (resetToken.getExpiryTime().isBefore(LocalDateTime.now())) {
            return "INVALID_TOKEN";
        }

        Login admin = loginRepository.findByEmail(resetToken.getEmail())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        admin.setPassword(newPassword);
        loginRepository.save(admin);

        resetToken.setUsed(true);
        tokenRepository.save(resetToken);

        return "SUCCESS";
    }
}