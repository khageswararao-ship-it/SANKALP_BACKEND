package com.sankalp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject("Sankalp HRMS - OTP Verification");

        message.setText(
                "Dear Employee,\n\n" +
                        "Your OTP for login is: " + otp +
                        "\n\nThis OTP is valid for 5 minutes." +
                        "\n\nDo not share it with anyone." +
                        "\n\nRegards,\nSankalp HRMS"
        );

        mailSender.send(message);
    }
}