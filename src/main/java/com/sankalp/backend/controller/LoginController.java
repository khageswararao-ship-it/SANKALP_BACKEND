package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://10.205.165.151:5173"
})
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    // Create Login
    @PostMapping
    public Login saveLogin(@RequestBody Login login) {
        return service.saveLogin(login);
    }

    // Get All Login Users
    @GetMapping
    public List<Login> getAllLogins() {
        return service.getAllLogins();
    }

    // Get Login By ID
    @GetMapping("/{id}")
    public Login getLoginById(@PathVariable Long id) {
        return service.getLoginById(id);
    }

    // Update Login
    @PutMapping("/{id}")
    public Login updateLogin(
            @PathVariable Long id,
            @RequestBody Login login) {

        return service.updateLogin(id, login);
    }

    // Delete Login
    @DeleteMapping("/{id}")
    public void deleteLogin(@PathVariable Long id) {
        service.deleteLogin(id);
    }

    // Authenticate Login
    @PostMapping("/authenticate")
    public Login authenticate(@RequestBody Login login) {

        return service.authenticate(
                login.getUsername(),
                login.getPassword(),
                login.getRole()
        );
    }
}