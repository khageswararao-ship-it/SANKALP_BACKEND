package com.sankalp.backend.service;

import com.sankalp.backend.entity.PasswordResetRequest;
import com.sankalp.backend.repository.PasswordResetRepository;
import org.springframework.stereotype.Service;
import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.util.List;

@Service
public class PasswordResetService {

    private final PasswordResetRepository repository;


    public List<PasswordResetRequest> getAllRequests() {
        return repository.findAll();
    }

    public PasswordResetRequest saveRequest(PasswordResetRequest request) {
        request.setStatus("Pending");
        return repository.save(request);
    }

    public PasswordResetRequest approve(Long id) {

        PasswordResetRequest request =
                repository.findById(id).orElse(null);

        if (request == null)
            return null;

        request.setStatus("Approved");

        return repository.save(request);
    }

    public PasswordResetRequest reject(Long id) {

        PasswordResetRequest request =
                repository.findById(id).orElse(null);

        if (request == null)
            return null;

        request.setStatus("Rejected");

        return repository.save(request);
    }
    private final LoginRepository loginRepository;
    private final JavaMailSender mailSender;

    public PasswordResetService(
            PasswordResetRepository repository,
            LoginRepository loginRepository,
            JavaMailSender mailSender) {

        this.repository = repository;
        this.loginRepository = loginRepository;
        this.mailSender = mailSender;

    }
    public PasswordResetRequest completeRequest(Long id, String newPassword) {

        PasswordResetRequest request = repository.findById(id).orElse(null);

        if (request == null) {
            return null;
        }

        Login login = loginRepository
                .findByEmployeeId(request.getEmployeeId())
                .orElse(null);

        if (login == null) {
            return null;
        }

        login.setPassword(newPassword);
        loginRepository.save(login);

        // Update request status
        request.setStatus("Approved");
        repository.save(request);

        // Send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(login.getEmail());
        mail.setSubject("Password Reset Successful");
        mail.setText(
                "Hello " + login.getUsername() + ",\n\n" +
                        "Your password has been reset by the administrator.\n\n" +
                        "Your new password is:\n\n" +
                        newPassword + "\n\n" +
                        "Please use this password to log in."
        );

        mailSender.send(mail);

        return request;
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllRequests() {
        repository.deleteAll();
    }
}