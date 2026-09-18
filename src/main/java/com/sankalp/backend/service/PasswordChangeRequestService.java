package com.sankalp.backend.service;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;
import java.util.List;

import com.sankalp.backend.entity.PasswordChangeRequest;
import com.sankalp.backend.repository.PasswordChangeRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class PasswordChangeRequestService {

    private final PasswordChangeRequestRepository repository;
    private final LoginRepository loginRepository;

    public PasswordChangeRequestService(
            PasswordChangeRequestRepository repository,
            LoginRepository loginRepository) {

        this.repository = repository;
        this.loginRepository = loginRepository;
    }

    public String createRequest(PasswordChangeRequest request) {

        System.out.println("Employee ID: " + request.getEmployeeId());

        request.setStatus("PENDING");

        PasswordChangeRequest saved = repository.save(request);

        System.out.println("Saved ID: " + saved.getId());

        return "Password change request sent to Admin";
    }

    public List<PasswordChangeRequest> getAllRequests() {
        return repository.findAll();
    }

    public String approveRequest(Long id) {

        PasswordChangeRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        Login login = loginRepository.findByEmployeeId(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Update the employee password
        login.setPassword(request.getNewPassword());
        loginRepository.save(login);

        // Mark request as approved
        request.setStatus("APPROVED");
        repository.save(request);

        return "Password changed successfully.";
    }

    public String rejectRequest(Long id) {

        PasswordChangeRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("REJECTED");
        repository.save(request);

        return "Password request rejected.";
    }

    public void deleteAllRequests() {
        repository.deleteAll();
    }

}