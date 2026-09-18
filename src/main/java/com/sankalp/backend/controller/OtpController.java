package com.sankalp.backend.controller;

import com.sankalp.backend.service.OtpService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(origins = "http://localhost:5173")
public class OtpController {

    private final OtpService service;

    public OtpController(OtpService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public String sendOtp(@RequestBody Map<String,String> request){

        String employeeId = request.get("employeeId");

        service.generateOtp(employeeId);

        return "OTP Sent";

    }

    @PostMapping("/verify")
    public boolean verifyOtp(@RequestBody Map<String,String> request){

        System.out.println("Request Body = " + request);
        System.out.println("Employee ID = " + request.get("employeeId"));
        System.out.println("OTP = " + request.get("otp"));

        return service.verifyOtp(
                request.get("employeeId"),
                request.get("otp")
        );
    }

}