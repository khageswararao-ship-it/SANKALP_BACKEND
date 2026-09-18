package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Leave;
import com.sankalp.backend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins = "http://localhost:5173")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @PostMapping
    public Leave saveLeave(@RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable String id,
                             @RequestBody Leave leave) {
        return leaveService.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable String id) {
        leaveService.deleteLeave(id);
    }

    @GetMapping("/{id}")
    public Optional<Leave> getLeaveById(@PathVariable String id) {
        return leaveService.getLeaveById(id);
    }
}