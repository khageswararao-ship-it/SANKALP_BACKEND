package com.sankalp.backend.service;

import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final LoginRepository loginRepository;

    public ProfileServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login getAdminProfile() {

        return loginRepository.findByUsername("admin")
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public Login updateAdminProfile(Login profile) {

        Login admin = loginRepository.findByUsername("admin")
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        admin.setUsername(profile.getUsername());
        admin.setEmail(profile.getEmail());
        admin.setMobileNumber(profile.getMobileNumber());

        return loginRepository.save(admin);
    }
}