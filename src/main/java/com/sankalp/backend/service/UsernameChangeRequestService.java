package com.sankalp.backend.service;

import com.sankalp.backend.entity.UsernameChangeRequest;
import com.sankalp.backend.repository.UsernameChangeRequestRepository;
import org.springframework.stereotype.Service;
import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;

import java.util.List;

@Service
public class UsernameChangeRequestService {

    private final UsernameChangeRequestRepository repository;
    private final LoginRepository LoginRepository;

    public UsernameChangeRequestService(
            UsernameChangeRequestRepository repository,
            LoginRepository loginRepository) {

        this.repository = repository;
        this.LoginRepository = loginRepository;
    }

    // Save Request
    public UsernameChangeRequest saveRequest(UsernameChangeRequest request) {
        request.setStatus("Pending");
        return repository.save(request);
    }

    // Get All Requests
    public List<UsernameChangeRequest> getAllRequests() {
        return repository.findAll();
    }

    // Get Request by ID
    public UsernameChangeRequest getRequest(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Request
    public UsernameChangeRequest updateRequest(Long id, UsernameChangeRequest request) {
        request.setId(id);
        return repository.save(request);
    }
    public UsernameChangeRequest approveRequest(Long id) {

        UsernameChangeRequest request =
                repository.findById(id).orElseThrow();
        System.out.println("Searching Employee ID : [" + request.getEmployeeId() + "]");

        System.out.println("All Login Records:");
        LoginRepository.findAll().forEach(l ->
                System.out.println(
                        "EmployeeId=[" + l.getEmployeeId() + "] Username=" + l.getUsername()
                )
        );

        Login login = LoginRepository
                .findByEmployeeId(request.getEmployeeId())
                .orElse(null);

        System.out.println("Login Object = " + login);






        if (login == null) {
            throw new RuntimeException("Employee login not found");
        }

        login.setUsername(request.getNewUsername());

        LoginRepository.save(login);

        request.setStatus("Approved");

        return repository.save(request);
    }

    public UsernameChangeRequest rejectRequest(Long id) {

        UsernameChangeRequest request = repository.findById(id).orElseThrow();

        request.setStatus("Rejected");

        return repository.save(request);
    }
    public void deleteAll() {
        repository.deleteAll();
    }

}