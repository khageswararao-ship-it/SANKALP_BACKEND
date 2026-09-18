package com.sankalp.backend.controller;

import com.sankalp.backend.entity.PasswordChangeRequest;
import com.sankalp.backend.service.PasswordChangeRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/password-change")
@CrossOrigin(origins = "http://localhost:5173")
public class PasswordChangeRequestController {

    private final PasswordChangeRequestService service;

    public PasswordChangeRequestController(PasswordChangeRequestService service) {
        this.service = service;
    }

    @PostMapping
    public String createRequest(@RequestBody PasswordChangeRequest request) {
        return service.createRequest(request);
    }

    @GetMapping
    public List<PasswordChangeRequest> getAllRequests() {
        return service.getAllRequests();
    }

    @PutMapping("/approve/{id}")
    public String approveRequest(@PathVariable Long id) {
        return service.approveRequest(id);
    }

    @PutMapping("/reject/{id}")
    public String rejectRequest(@PathVariable Long id) {
        return service.rejectRequest(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllRequests() {
        service.deleteAllRequests();
    }
}
