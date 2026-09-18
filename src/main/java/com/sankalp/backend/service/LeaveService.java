package com.sankalp.backend.service;

import com.sankalp.backend.entity.Leave;
import com.sankalp.backend.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(String id, Leave leave) {
        leave.setId(id);
        return leaveRepository.save(leave);
    }

    public void deleteLeave(String id) {
        leaveRepository.deleteById(id);
    }

    public Optional<Leave> getLeaveById(String id) {
        return leaveRepository.findById(id);
    }
}