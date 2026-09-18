package com.sankalp.backend.service;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;
import org.springframework.stereotype.Service;
import com.sankalp.backend.dto.ResetPasswordRequest;

@Service
public class ForgotPasswordService {

    private final LoginRepository loginRepository;

    public ForgotPasswordService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String resetPassword(ResetPasswordRequest request) {

        Login login = loginRepository.findByEmployeeId(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        login.setPassword(request.getNewPassword());

        loginRepository.save(login);

        return "Password Updated Successfully";
    }
}