package com.sankalp.backend.service;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    // Save Login
    public Login saveLogin(Login login) {

        return repository.save(login);
    }

    // Get All Login Users
    public List<Login> getAllLogins() {

        return repository.findAll();
    }

    // Get Login by ID
    public Login getLoginById(Long id) {

        return repository.findById(id).orElse(null);
    }

    // Update Login
    public Login updateLogin(Long id, Login login) {

        Login existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setEmployeeId(login.getEmployeeId());
        existing.setUsername(login.getUsername());
        existing.setPassword(login.getPassword());
        existing.setRole(login.getRole());
        existing.setEmail(login.getEmail());
        existing.setMobileNumber(login.getMobileNumber());
        existing.setAccountStatus(login.getAccountStatus());

        return repository.save(existing);
    }

    // Delete Login
    public void deleteLogin(Long id) {

        repository.deleteById(id);
    }

    // Login Authentication
    public Login authenticate(String username, String password, String role) {

        System.out.println("===== LOGIN REQUEST =====");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);

        Optional<Login> login = repository.findByUsername(username);

        if (login.isEmpty()) {
            System.out.println("User not found!");
            return null;
        }

        Login user = login.get();

        System.out.println("===== DATABASE VALUES =====");
        System.out.println("DB Username: " + user.getUsername());
        System.out.println("DB Password: " + user.getPassword());
        System.out.println("DB Role: " + user.getRole());
        System.out.println("DB Status: " + user.getAccountStatus());

        if (user.getPassword().equals(password)
                && user.getRole().equalsIgnoreCase(role)
                && user.getAccountStatus().equalsIgnoreCase("ACTIVE")) {

            System.out.println("LOGIN SUCCESS");
            return user;
        }

        System.out.println("LOGIN FAILED - Credentials do not match");
        return null;
    }
}