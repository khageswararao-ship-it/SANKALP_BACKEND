package com.sankalp.backend.controller;

import com.sankalp.backend.entity.UsernameChangeRequest;
import com.sankalp.backend.service.UsernameChangeRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/username-request")
@CrossOrigin(origins = "http://localhost:5173")
public class UsernameChangeRequestController {

    private final UsernameChangeRequestService service;

    public UsernameChangeRequestController(UsernameChangeRequestService service) {
        this.service = service;
    }

    @PostMapping
    public UsernameChangeRequest saveRequest(
            @RequestBody UsernameChangeRequest request) {

        return service.saveRequest(request);
    }

    @GetMapping
    public List<UsernameChangeRequest> getAllRequests() {

        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public UsernameChangeRequest getRequest(@PathVariable Long id) {

        return service.getRequest(id);
    }

    @PutMapping("/{id}")
    public UsernameChangeRequest updateRequest(
            @PathVariable Long id,
            @RequestBody UsernameChangeRequest request) {

        return service.updateRequest(id, request);
    }
    @PutMapping("/{id}/approve")
    public UsernameChangeRequest approveRequest(@PathVariable Long id) {
        return service.approveRequest(id);
    }

    @PutMapping("/{id}/reject")
    public UsernameChangeRequest rejectRequest(@PathVariable Long id) {
        return service.rejectRequest(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        service.deleteAll();
    }

}