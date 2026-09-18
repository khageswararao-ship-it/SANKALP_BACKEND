package com.sankalp.backend.controller;

import com.sankalp.backend.entity.PasswordResetRequest;
import com.sankalp.backend.service.PasswordResetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/password-reset")
@CrossOrigin(origins = "http://localhost:5173")
public class PasswordResetController {

    private final PasswordResetService service;

    public PasswordResetController(PasswordResetService service) {
        this.service = service;
    }

    @GetMapping
    public List<PasswordResetRequest> getAllRequests() {
        return service.getAllRequests();
    }

    @PostMapping
    public PasswordResetRequest createRequest(
            @RequestBody PasswordResetRequest request) {

        return service.saveRequest(request);
    }

    @PutMapping("/approve/{id}")
    public PasswordResetRequest approve(@PathVariable Long id) {
        return service.approve(id);
    }



    @PutMapping("/reject/{id}")
    public PasswordResetRequest reject(@PathVariable Long id) {
        return service.reject(id);
    }
    @PutMapping("/complete/{id}")
    public PasswordResetRequest completeRequest(
            @PathVariable Long id,
            @RequestParam String newPassword) {

        return service.completeRequest(id, newPassword);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllRequests() {
        service.deleteAllRequests();
    }
}