package com.sankalp.backend.service;

import com.sankalp.backend.entity.Settings;
import com.sankalp.backend.repository.SettingsRepository;
import org.springframework.stereotype.Service;
import com.sankalp.backend.entity.Login;
import com.sankalp.backend.repository.LoginRepository;

@Service
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository repository;
    private final LoginRepository loginRepository;

    public SettingsServiceImpl(SettingsRepository repository,
                               LoginRepository loginRepository) {
        this.repository = repository;
        this.loginRepository = loginRepository;
    }

    @Override
    public Settings getSettings() {

        return repository.findById(1L)
                .orElse(new Settings(
                        1L,
                        "Sankalp IP",
                        "admin@sankalpip.com",
                        "+91 9876543210",
                        "Hyderabad, Telangana",
                        "Light Theme",
                        "English"
                ));
    }

    @Override
    public Settings saveSettings(Settings settings) {

        settings.setId(1L);

        // Save settings
        Settings savedSettings = repository.save(settings);

        // Update admin email in login table
        Login admin = loginRepository.findByUsername("admin")
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setEmail(settings.getCompanyEmail());
        admin.setMobileNumber(settings.getPhone());

        loginRepository.save(admin);

        return savedSettings;
    }
}